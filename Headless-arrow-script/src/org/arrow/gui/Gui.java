package org.arrow.gui;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.arrow.Settings;
import org.arrow.actions.Fletcher;
import org.arrow.actions.Pickup;
import org.arrow.extras.Antipattern;
import org.arrow.task.HeadlessArrows;
import org.powerbot.script.rt6.ClientContext;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

@SuppressWarnings("serial")
public class Gui extends JFrame {

	private JPanel contentPane = new JPanel();
	private final JComboBox comboBox = new JComboBox();
	private final JButton start = new JButton("Start");

	public static void init(ClientContext ctx) {
		Gui frame = new Gui(ctx);
		frame.setVisible(true);
	}

	public Gui(final ClientContext ctx) {
		setTitle("FN-Arrows v"+Settings.SCRIPT_BUILD);
		setBounds(100, 100, 270, 175);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		comboBox.setBounds(65, 30, 120, 20);
		
		comboBox.addItem("Normal mode");
		comboBox.addItem("Pick-up mode");
		contentPane.add(comboBox);
		start.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				Settings.TAKING = comboBox.getSelectedIndex() == 1;
				HeadlessArrows.taskList.addAll(Arrays.asList(
				comboBox.getSelectedIndex() == 0 ? new Fletcher(ctx) : new Pickup(ctx), new Antipattern(ctx)));
				dispose();
			}
		});
		start.setBounds(65, 70, 120, 44);
		
		contentPane.add(start);
		
		for (int i = 0; i < contentPane.getComponentCount(); i++) {
			contentPane.getComponents()[i].setFocusable(false);
		}
	}
}
