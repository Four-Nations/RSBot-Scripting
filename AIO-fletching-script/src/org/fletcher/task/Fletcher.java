package org.fletcher.task;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.fletcher.Settings;
import org.fletcher.flech.extras.Paint;
import org.fletcher.gui.Gui;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Constants;

@Script.Manifest(name= "FN Fletcher", description = "Fletches all major logs, cuts and strings.", properties = "topic=1250649;client=6")
public class Fletcher extends PollingScript<ClientContext> implements PaintListener {

	private final int START_XP = ctx.skills.experience(Constants.SKILLS_FLETCHING);
	
	public static List<Task<ClientContext>> taskList = new ArrayList<Task<ClientContext>>();
	
	@Override
	public void start() {
		Gui.init(ctx);
	}
	
	@Override
	public void poll() {
		for (Task<ClientContext> task : taskList) {
			if (task.hasRequirements()) {
				task.runTask();
			}
		}
	}
	
	@Override
	public void repaint(Graphics graphics) {
		final int GAINED_XP = ctx.skills.experience(Constants.SKILLS_FLETCHING) - START_XP;
		Paint.drawMouse(graphics, ctx);
		graphics.setColor(Color.DARK_GRAY);
		graphics.fillRect(10, 10, 235, 130);
		graphics.setColor(Color.BLUE);
		graphics.drawRect(10, 10, 235, 130);
		graphics.setColor(Color.YELLOW);
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
		graphics.drawString("Method: " + Settings.TYPES, 20, 120);	
	}

}
