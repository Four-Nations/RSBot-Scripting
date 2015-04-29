package org.fletcher.task;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.fletcher.Settings;
import org.fletcher.fletch.extras.Paint;
import org.fletcher.gui.Gui;
import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Constants;

@Script.Manifest(name = "FN Fletcher PRO",
description = "Fletchers all major logs, cuts and strings, supports bank presets.",
properties = "topic=1250649;client=6;vip=false;")
public class Fletcher extends PollingScript<ClientContext> implements PaintListener {

	public static final List<Task<ClientContext>> taskList = new ArrayList<Task<ClientContext>>();
	
	private final int START_XP = ctx.skills.experience(Constants.SKILLS_FLETCHING);
	
	@Override
	public void start() {
		Gui.init(ctx);
	}

	@Override
	public void poll() {
		Component subscribeInterface = ctx.widgets.component(1401, 31);
		if (subscribeInterface.valid()) {
			subscribeInterface.click();
		}
		for (Task<ClientContext> task : taskList) {
			if (task.hasRequirements()) {
				task.runTask();
			}
		}
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

	@Override
	public void repaint(Graphics graphics) {
		final int GAINED_XP = ctx.skills.experience(Constants.SKILLS_FLETCHING) - START_XP;
		Paint.drawMouse(graphics, ctx);
		graphics.setColor(Color.DARK_GRAY);
		graphics.fillRect(10, 10, 235, 130);
		graphics.setColor(Color.BLUE);
		graphics.drawRect(10, 10, 235, 130);
		graphics.setColor(Color.PINK);
		graphics.drawLine(125, 42, 20, 42);
		graphics.drawLine(125, 62, 20, 62); 
		graphics.drawLine(125, 82, 20, 82); 
		graphics.drawLine(125, 102, 20, 102); 
		graphics.drawLine(125, 122, 20, 122);
		graphics.setColor(Color.GREEN);
		graphics.drawString("Runtime: " + Paint.getRunTime(), 20, 40);
		graphics.drawString("XP gained: " + GAINED_XP, 20, 60);
		graphics.drawString("XP per hour: " + Paint.getXpPerHour(GAINED_XP), 20, 80);
		graphics.drawString("Current level: " + ctx.skills.level(Constants.SKILLS_FLETCHING), 20, 100);
		graphics.drawString("Method: " + Settings.method, 20, 120);
	}

}
