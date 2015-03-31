package org.fisher.gui.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import org.fisher.fish.Fish.FishTypes;
import org.fisher.gui.Gui;

public class Mouse implements MouseListener, MouseMotionListener {
	
	private int index;
	
	public Mouse(int index) {
		this.index = index;
	}

	@Override
	public void mouseClicked(MouseEvent mouse) {
		updateLists();
	}
	
	@Override
	public void mousePressed(MouseEvent mouse) {
		updateLists();	
	}

	@Override
	public void mouseReleased(MouseEvent mouse) {
		updateLists();
	}

	@Override
	public void mouseEntered(MouseEvent mouse) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseExited(MouseEvent mouse) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseDragged(MouseEvent mouse) {
		updateLists();
	}

	@Override
	public void mouseMoved(MouseEvent mouse) {
		// TODO Auto-generated method stub
		
	}
	
	private void updateLists() {
		switch(index) {
		case 0: //when we click the fish list, updates location list.
			FishTypes fish = (FishTypes) Gui.fishList.getSelectedValue();
			Gui.locationModel.clear();
			Gui.lblFishType.setText("Fish type : "+fish);
			Gui.lblMethodType.setText("Method type : "+fish.getOption());
			for (int i = 0; i < fish.getLocations().length; i++) {
				Gui.locationModel.addElement(fish.getLocations()[i]);
			}
			break;
		case 1:
			Gui.lblFishLocation.setText("Location : "+Gui.locationList.getSelectedValue());//TODO shorten, or make gui bigger
			break;
		}
		return;
	}

}
