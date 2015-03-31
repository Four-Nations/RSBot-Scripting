package org.runner.extras;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.text.DecimalFormat;

import org.powerbot.script.rt6.ClientContext;

/**
 * 
 * @author Cody
 *
 */

public class PaintSettings {

	private static long startTime = System.currentTimeMillis();

	public static String getRunTime() {
		DecimalFormat nf = new DecimalFormat("00");
		long millis = System.currentTimeMillis() - startTime;
		long hours = millis / (1000 * 60 * 60);
		millis -= hours * (1000 * 60 * 60);
		long minutes = millis / (1000 * 60);
		millis -= minutes * (1000 * 60);
		long seconds = millis / 1000;
		return nf.format(hours) + ":" + nf.format(minutes) + ":"+ nf.format(seconds);
	}
	
	public static void drawMouse(Graphics graphics, ClientContext ctx) {
		final Graphics2D g = (Graphics2D) graphics;
		final Point mouseLoc = ctx.input.getLocation();
		g.drawRect(mouseLoc.x - 5, mouseLoc.y - 5, 10, 10);
		g.drawLine(mouseLoc.x - 10, mouseLoc.y, mouseLoc.x + 10, mouseLoc.y);
		g.drawLine(mouseLoc.x, mouseLoc.y - 10, mouseLoc.x, mouseLoc.y + 10);
	}

	public static String getXpPerHour(double gained) {
		return formatNumber(gained * 3600000.0 / (System.currentTimeMillis() - startTime));
	}

	private static String formatNumber(double d) {
		final DecimalFormat nf = new DecimalFormat("0.0");
		final double i = d;
		if (i >= 1000000.0) {
			return new StringBuilder(nf.format(i / 1000000.0)).append("m").toString();
		}
		if (i >= 1000.0) {
			return new StringBuilder(nf.format(i / 1000.0)).append("k").toString();
		}
		return new StringBuilder().append(d).toString();
	}
}
