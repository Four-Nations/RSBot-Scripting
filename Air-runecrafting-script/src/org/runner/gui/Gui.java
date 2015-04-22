package org.runner.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.powerbot.script.rt6.ClientContext;
import org.runner.Constants;
import org.runner.actions.AirRunner;
import org.runner.actions.Banker;
import org.runner.extras.Antiban;
import org.runner.task.Runecrafter;
import org.runner.task.Task;

/**
 * 
 * @author Cody
 *
 */

@SuppressWarnings("serial")
public class Gui extends JFrame {

	public static void init(ClientContext ctx) {
		Gui frame = new Gui(ctx);
		frame.setVisible(true);
	}

	public Gui(final ClientContext ctx) {
		setBounds(100, 100, 200, 185);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		final JComboBox essenceSelector = new JComboBox();
		essenceSelector.addItem("Rune essence");
		essenceSelector.addItem("Pure essence");
		essenceSelector.setBounds(30, 52, 125, 20);
		panel.add(essenceSelector);
		
		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (essenceSelector.getSelectedIndex() == 1) {
					Constants.PURE_ESS = true;
				}
				Runecrafter.taskList.addAll(Arrays.asList(new Task[] { new AirRunner(ctx), new Banker(ctx), new Antiban(ctx) }));
				dispose();
			}
		});
		start.setBounds(30, 95, 125, 25);
		panel.add(start);
		
		JLabel scriptVersionLabel = new JLabel("FN Air runner v"+Constants.SCRIPT_VERSION);
		scriptVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scriptVersionLabel.setBounds(30, 15, 125, 14);
		panel.add(scriptVersionLabel);
		
		for (int i = 0; i < panel.getComponents().length; i++) {
			panel.getComponents()[i].setFocusable(false);
		}
		
	}

}
