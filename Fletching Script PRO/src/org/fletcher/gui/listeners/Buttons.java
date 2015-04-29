package org.fletcher.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.fletcher.Settings;
import org.fletcher.fletch.Info.Methods;
import org.fletcher.gui.Gui;

public class Buttons implements ActionListener {

	private int index;

	public Buttons(int index) {
		this.index = index;
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		switch(index) {
		case 0: //The cutting/stringing radio buttons.
		case 1:
			Gui.cutting.setSelected(index == 0);
			Gui.stringing.setSelected(index == 1);
			updateSettings();
			break;
		case 2: //The log box, updating the method box
			updateMethods();
			break;
		}
	}

	private void updateMethods() {
		Settings.method = (Methods) Gui.logBox.getSelectedItem();
		if (!Gui.stringing.isSelected()) {
			Gui.methodBox.removeAllItems();
			for (int i = 0; i < Settings.method.getMethod().length; i++) {
				Gui.methodBox.addItem(Settings.method.getMethod()[i].toUpperCase());
			}
		}
	}

	private void updateSettings() {		
		Gui.methodBox.removeAllItems();
		switch (index) {
		case 0:
			for (int i = 0; i < Settings.method.getMethod().length; i++) {
				Gui.methodBox.addItem(Settings.method.getMethod()[i].toUpperCase());
			}
			break;
		case 1:
			for (int i = 0; i < Settings.method.getMethod().length; i++) {
				String name = Settings.method.getMethod()[i];
				if (!name.contains("shaft") &&  !name.contains("stock")) {
					Gui.methodBox.addItem(Settings.method.getMethod()[i].toUpperCase());
				}
			}
			break;
		}
	}


}
