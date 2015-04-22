package org.arrow.extras;

import java.awt.Point;

import org.arrow.Settings;
import org.arrow.task.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;

public class Antipattern extends Task<ClientContext> {

	public Antipattern(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean hasRequirements() {
		return Random.nextInt(0, 175) == 1;
	}

	@Override
	public void runTask() {
		switch (Random.nextInt(0, 4)) {
		case 0:
			Point m = ctx.input.getLocation();
			ctx.input.move(new Point(Random.nextInt(-50, 50) + m.x, Random.nextInt(-50, 50) + m.y));
			Settings.STATUS = "Antiban - Mouse wiggle.";
			break;
		case 1:
			Settings.STATUS = "Antiban - Afk.";
			Condition.sleep(5000);
			break;
		case 2:
			int random = Random.nextInt(1, 28);
			Component i = ctx.backpack.component().component(random);
			if (ctx.backpack.select().count() >= random) {
				Settings.STATUS = "Antiban - Item examining.";
				i.interact("Examine");
			}
			break;
		case 3:
			ctx.camera.angleTo(Random.nextInt(0, 360));
			ctx.camera.pitch(Random.nextInt(21, 39));
			Settings.STATUS = "Antiban - Camera movements.";
			break;
		}
	}
	
}
