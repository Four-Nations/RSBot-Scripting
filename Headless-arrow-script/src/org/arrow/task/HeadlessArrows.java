package org.arrow.task;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.arrow.Settings;
import org.arrow.extras.Paint;
import org.arrow.gui.Gui;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Constants;

@Script.Manifest(name = "FN Headless-Arrows", description = "Crafts headless arrows or picks up feathers.", properties = "topic=1250649;client=6;vip=false;hidden=false;")
public class HeadlessArrows extends PollingScript<ClientContext> implements PaintListener {

	@SuppressWarnings("rawtypes")
	public static List<Task> taskList = new ArrayList<Task>();

	private final int START_XP = ctx.skills.experience(Constants.SKILLS_FLETCHING);
	private final int headlessArrow = ctx.backpack.select().id(Settings.HEADLESS_ARROW).count(true);
	private final int featherAmount = ctx.backpack.select().id(Settings.FEATHER).count(true);

	@Override
	public void start() {
		Gui.init(ctx);
	}

	@Override
	public void poll() {
		for (Task<?> task : taskList) {
			if (task.hasRequirements()) {
				task.runTask();
			}
		}
	}

	@Override
	public void repaint(Graphics graphics) {
		int featherCount;
		if (Settings.TAKING) {
			featherCount = ctx.backpack.select().id(Settings.FEATHER).count(true) - featherAmount;
		} else {
			featherCount = ctx.backpack.select().id(Settings.HEADLESS_ARROW).count(true) - headlessArrow;
		}
		final int GAINED_XP = ctx.skills.experience(Constants.SKILLS_FLETCHING) - START_XP;
		Paint.drawMouse(graphics, ctx);
		graphics.setColor(Color.DARK_GRAY);
		graphics.fillRect(10, 10, 235, 155);
		graphics.setColor(Color.BLUE);
		graphics.drawRect(10, 10, 235, 155);
		graphics.setColor(Color.YELLOW);
		graphics.drawLine(125, 42, 20, 42);
		graphics.drawLine(125, 62, 20, 62); 
		graphics.drawLine(125, 82, 20, 82); 
		graphics.drawLine(125, 102, 20, 102);
		graphics.drawLine(165, 122, 20, 122);
		graphics.drawLine(165, 142, 20, 142);
		graphics.setColor(Color.GREEN);
		graphics.drawString("Runtime: " + Paint.getRunTime(), 20, 40);
		graphics.drawString("XP gained: " + GAINED_XP, 20, 60);
		graphics.drawString("XP per hour: " + Paint.getXpPerHour(GAINED_XP), 20, 80);
		graphics.drawString("Current level: " + ctx.skills.level(Constants.SKILLS_FLETCHING), 20, 100);
		graphics.drawString((Settings.TAKING ? "Feathers plucked: ":"Headless arrows made: ") + featherCount+" ("+ Paint.getXpPerHour(featherCount)+")", 20, 120);
		graphics.drawString("Status: " + Settings.STATUS, 20, 140);
	}

}
