package org.fletcher.gui.listeners;

import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.fletcher.gui.Gui;

public class Slider implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) {
		JCheckBox[] box = new JCheckBox[] {Gui.antipattern, Gui.randomBreaks, Gui.cameraMovement, Gui.itemExamining, Gui.mouseMovement};
		Gui.antiPatternFrequency.setText("Antipattern frequency: "+Gui.slider.getValue());
		for (int i = 0; i < box.length; i++) {
			box[i].setEnabled(Gui.slider.getValue() != 0);
		}
		if (Gui.slider.getValue() == 0) {
			Gui.antiPatternFrequency.setText("Antipattern disabled");
		}
	}

}
