package org.fletcher.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.fletcher.Settings;
import org.fletcher.flech.Fletch.FletchTypes;

public class ButtonHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Fletching") {
			Gui.stringingButton.setSelected(false);
			update();
			return;
		}
		if (e.getActionCommand() == "Stringing") {
			Gui.fletchButton.setSelected(false);
			Gui.methodBox.removeItem("Shafts");
			return;
		}
		if (e.getActionCommand() == "comboBoxChanged") {
			update();
			return;
		}
		System.out.println(e.getActionCommand());
	}
	
	public void update() {
		Settings.TYPES = (FletchTypes) Gui.logBox.getSelectedItem();
		Gui.methodBox.removeAllItems();
		for (int i = 0; i < Settings.TYPES.getMethods().length; i++) {
			Gui.methodBox.addItem(Settings.TYPES.getMethods()[i]);
			if (Gui.stringingButton.isSelected()) {
				Gui.methodBox.removeItem("Shafts");
			}
		}
	}

}
