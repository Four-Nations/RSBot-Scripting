package org.fletcher.gui;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import org.fletcher.Settings;
import org.fletcher.flech.Fletch.FletchTypes;
import org.fletcher.flech.actions.Banker;
import org.fletcher.flech.actions.BowMaker;
import org.fletcher.flech.actions.BowStringer;
import org.fletcher.flech.extras.Antipattern;
import org.fletcher.task.Fletcher;
import org.powerbot.script.rt6.ClientContext;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

@SuppressWarnings("serial")
public class Gui extends JFrame {

	private JPanel contentPane = new JPanel();
	public static JRadioButton fletchButton = new JRadioButton("Fletching");
	public static JRadioButton stringingButton = new JRadioButton("Stringing");
	public static JComboBox logBox = new JComboBox();
	private final JCheckBox antiPattern = new JCheckBox("Antipattern");
	public static JComboBox methodBox = new JComboBox();
	private final JButton btnStart = new JButton("Start");

	public static void init(ClientContext ctx) {
		Gui frame = new Gui(ctx);
		frame.setVisible(true);
	}

	public Gui(final ClientContext ctx) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 340);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		fletchButton.setSelected(true);
		
		fletchButton.setBounds(31, 37, 82, 23);	
		contentPane.add(fletchButton);
		fletchButton.addActionListener(new ButtonHandler());
		
		stringingButton.setBounds(119, 37, 109, 23);
		contentPane.add(stringingButton);
		
		logBox.setBounds(65, 126, 102, 20);
		contentPane.add(logBox);
		logBox.addActionListener(new ButtonHandler());
		
		antiPattern.setSelected(true);
		antiPattern.setBounds(70, 79, 97, 23);
		
		contentPane.add(antiPattern);
		methodBox.setBounds(65, 176, 102, 20);
		
		contentPane.add(methodBox);
		btnStart.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				Settings.COMPONENT_INDEX = methodBox.getSelectedIndex();
				Settings.STRING_INDEX = methodBox.getSelectedIndex();
				System.out.println(Settings.STRING_INDEX);
				System.out.println(Settings.TYPES == FletchTypes.NORMAL);
				if (stringingButton.isSelected()) {
					if (Settings.TYPES == FletchTypes.NORMAL) {
						Settings.STRING_INDEX +=1;
						System.out.println(Settings.STRING_INDEX);
					}
					Settings.STRINGING = true;
				}
				if (antiPattern.isSelected()) {
					Fletcher.taskList.addAll(Arrays.asList(new Antipattern(ctx)));
				}
				Fletcher.taskList.addAll(Arrays.asList(fletchButton.isSelected() ?
				new BowMaker(ctx) : new BowStringer(ctx), new Banker(ctx)));
				dispose();
			}
		});
		btnStart.setBounds(65, 228, 102, 37);
		
		contentPane.add(btnStart);
		stringingButton.addActionListener(new ButtonHandler());
		
		for (FletchTypes types : FletchTypes.values()) {
			logBox.addItem(types);
		}
		
		for (int i = 0; i < contentPane.getComponentCount(); i++) {
			contentPane.getComponents()[i].setFocusable(false);
		}
		
	}
}
