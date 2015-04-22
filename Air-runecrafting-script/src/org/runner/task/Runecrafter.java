package org.runner.task;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt6.ClientContext;
import org.runner.extras.PaintSettings;
import org.runner.gui.Gui;

/**
 * 
 * @author Cody
 *
 */

@Script.Manifest(name = "FN Air-Runner", description = "Runs air runes, start at varrock west bank.",
properties = "topic=1243313; client=6;")
public class Runecrafter extends PollingScript<ClientContext> implements PaintListener {
	
	public static final List<Task> taskList = new ArrayList<Task>();
	private final int START_XP = ctx.skills.experience(20);

	@Override
	public void start() {
		Gui.init(ctx);
	}

	@Override
	public void poll() {
		for (final Task<?> task : taskList) {
			if (task.activate()) {
				task.execute();
			}
		}
	}

	@Override
	public void repaint(Graphics graphics) {
		final int GAINED_XP = ctx.skills.experience(20) - START_XP;
		PaintSettings.drawMouse(graphics, ctx);
		graphics.setColor(Color.RED);
		graphics.drawRect(10, 10, 235, 110);
		graphics.drawString("Runtime: " + PaintSettings.getRunTime(), 20, 40);
		graphics.drawString("XP gained: " + GAINED_XP, 20, 60);
		graphics.drawString("XP per hour: " + PaintSettings.getXpPerHour(GAINED_XP), 20, 80);
		graphics.drawString("Current level: " + ctx.skills.level(20), 20, 100);
	}
}
