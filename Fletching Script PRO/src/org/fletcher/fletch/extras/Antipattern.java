package org.fletcher.fletch.extras;

import java.awt.Point;

import org.fletcher.Settings;
import org.fletcher.task.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;

/**
 *
 * @author Cody
 *
 */

public class Antipattern extends Task<ClientContext> {

	public Antipattern(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean hasRequirements() {
		return Random.nextInt(0, 750/Settings.antibanFreq) == 1 && !ctx.bank.opened();
	}

	@Override
	public void runTask() {
		switch (Random.nextInt(0, 6)) {
		case 0:
			if (Settings.mouseMovement) {
				Point m = ctx.input.getLocation();
				ctx.input.move(new Point(Random.nextInt(-55, 55) + m.x, Random.nextInt(-60, 60) + m.y));
			}
			break;
		case 1:
			if (Settings.breaks) {
				Condition.sleep(5000);
			}
			break;
		case 2:
			if (Settings.itemExamining) {
				int random = Random.nextInt(1, 28);
				Component i = ctx.backpack.component().component(random);
				if (ctx.backpack.select().count() >= random) {
					i.interact("Examine");
				}
			}
			break;
		case 3:
		case 4:
			if (Settings.cameraMovements) {
				ctx.camera.angleTo(Random.nextInt(0, 360));
				ctx.camera.pitch(Random.nextInt(20, 40));
			}
			break;
		}
	}

}