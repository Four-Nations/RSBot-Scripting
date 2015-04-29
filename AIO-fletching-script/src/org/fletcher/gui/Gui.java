package org.fletcher.gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.fletcher.Settings;
import org.fletcher.fletch.Info.Methods;
import org.fletcher.fletch.actions.Banker;
import org.fletcher.fletch.actions.BowCrafter;
import org.fletcher.fletch.actions.BowStringer;
import org.fletcher.fletch.extras.Antipattern;
import org.fletcher.gui.listeners.Buttons;
import org.fletcher.gui.listeners.Slider;
import org.fletcher.task.Fletcher;
import org.powerbot.script.rt6.ClientContext;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

@SuppressWarnings("serial")
public class Gui extends JFrame {
	
	private JPanel contentPane = new JPanel();

	public static JComboBox logBox = new JComboBox();
	public static JComboBox methodBox = new JComboBox();

	public static JRadioButton cutting = new JRadioButton("Cutting");
	public static JRadioButton stringing = new JRadioButton("Stringing");

	public static JSlider slider = new JSlider();
	public static JLabel antiPatternFrequency = new JLabel("Antipattern frequency: 5");

	public static JCheckBox antipattern = new JCheckBox("Antipattern");
	public static JCheckBox randomBreaks = new JCheckBox("Random breaks");
	public static JCheckBox cameraMovement = new JCheckBox("Camera MVMT");
	public static JCheckBox itemExamining = new JCheckBox("Item examining");
	public static JCheckBox mouseMovement = new JCheckBox("Mouse MVMT");

	public static void init(ClientContext ctx) {
		Gui frame = new Gui(ctx);
		frame.setVisible(true);
	}

	public Gui(final ClientContext ctx) {
		setResizable(false);
		setTitle("Choose settings");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 385);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFnFletcherV = new JLabel("FN Fletcher v"+Settings.SCRIPT_BUILD);
		lblFnFletcherV.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFnFletcherV.setBounds(420, 11, 89, 14);
		contentPane.add(lblFnFletcherV);

		cutting.setSelected(true);
		cutting.setBounds(20, 20, 67, 23);
		cutting.addActionListener(new Buttons(0));
		contentPane.add(cutting);

		stringing.setBounds(97, 20, 80, 23);
		stringing.addActionListener(new Buttons(1));
		contentPane.add(stringing);

		JPanel logBorder = new JPanel();
		logBorder.setBorder(new TitledBorder(null, "Select log type:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		logBorder.setBounds(20, 59, 157, 43);
		contentPane.add(logBorder);
		logBorder.setLayout(null);

		JPanel methodBorder = new JPanel();
		methodBorder.setBorder(new TitledBorder(null, "Select method:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		methodBorder.setBounds(20, 154, 157, 43);
		contentPane.add(methodBorder);
		methodBorder.setLayout(null);

		JPanel bankBorder = new JPanel();
		bankBorder.setBorder(new TitledBorder(null, "Select bank option:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bankBorder.setBounds(20, 249, 157, 43);
		contentPane.add(bankBorder);
		bankBorder.setLayout(null);

		JPanel antiPatternBorder = new JPanel();
		antiPatternBorder.setBorder(new TitledBorder(null, "Antipattern", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		antiPatternBorder.setBounds(208, 59, 267, 160);
		contentPane.add(antiPatternBorder);
		antiPatternBorder.setLayout(null);

		for (Methods method : Methods.values()) {
			logBox.addItem(method);
		}
		logBox.addActionListener(new Buttons(2));
		logBox.setBounds(6, 16, 145, 20);
		logBox.setFocusable(false);
		logBorder.add(logBox);

		for (int i = 0; i < Settings.method.getMethod().length; i++) {
			methodBox.addItem(Settings.method.getMethod()[i].toUpperCase());
		}
		methodBox.setBounds(6, 16, 145, 20);
		methodBox.setFocusable(false);
		methodBorder.add(methodBox);

		final JComboBox bankBox = new JComboBox();
		String[] options = new String[] {"Regular banking", "Custom preset 1", "Custom preset 2"};
		for (int i = 0; i < options.length; i++) {
			bankBox.addItem(options[i].toUpperCase());
		}
		bankBox.setBounds(6, 16, 145, 20);
		bankBox.setFocusable(false);
		bankBorder.add(bankBox);

		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				Settings.methodIndex = !stringing.isSelected() ? methodBox.getSelectedIndex() : calculateIndex();
				Settings.bankIndex = bankBox.getSelectedIndex();
				Settings.antiPattern = antipattern.isSelected() && antipattern.isEnabled();
				Settings.stringing = stringing.isSelected();
				Settings.antibanFreq = slider.getValue();
				Fletcher.taskList.addAll(
				Arrays.asList(stringing.isSelected() ? new BowStringer(ctx) : new BowCrafter(ctx),new Banker(ctx)));
				if (Settings.antiPattern) {
					Fletcher.taskList.addAll(Arrays.asList(new Antipattern(ctx)));
				}
				dispose();
			}
		});
		start.setBounds(208, 249, 267, 43);
		contentPane.add(start);
		
		antipattern.setHorizontalAlignment(SwingConstants.CENTER);
		antipattern.setSelected(true);
		antipattern.setBounds(6, 20, 255, 23);
		antiPatternBorder.add(antipattern);

		randomBreaks.setBounds(16, 46, 119, 23);
		antiPatternBorder.add(randomBreaks);

		cameraMovement.setBounds(152, 46, 109, 23);
		antiPatternBorder.add(cameraMovement);		

		itemExamining.setBounds(16, 82, 124, 23);
		antiPatternBorder.add(itemExamining);		

		mouseMovement.setBounds(152, 82, 109, 23);
		antiPatternBorder.add(mouseMovement);

		slider.addChangeListener(new Slider());
		slider.setMaximum(10);
		slider.setValue(5);
		slider.setSnapToTicks(true);
		slider.setBounds(25, 101, 216, 35);
		antiPatternBorder.add(slider);

		antiPatternFrequency.setHorizontalAlignment(SwingConstants.CENTER);
		antiPatternFrequency.setBounds(36, 135, 206, 14);
		antiPatternBorder.add(antiPatternFrequency);

		for (int i = 0; i < contentPane.getComponentCount(); i++) {
			contentPane.getComponents()[i].setFocusable(false);
		}

		for (int i = 0; i < antiPatternBorder.getComponentCount(); i++) {
			antiPatternBorder.getComponents()[i].setFocusable(false);
		}

	}

	protected int calculateIndex() {
		return methodBox.getSelectedIndex() >= 1 ? Settings.method == Methods.MAGIC ? 2 : 3 : 1;
	}
	
}
