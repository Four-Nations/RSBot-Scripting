package org.fletcher.flech.extras;

import java.awt.Point;

import org.fletcher.task.Task;
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
		return Random.nextInt(0, 200) == 1 && !ctx.bank.opened();
	}

	@Override
	public void runTask() {
		switch (Random.nextInt(0, 5)) {
		case 0:
			Point m = ctx.input.getLocation();
			ctx.input.move(new Point(Random.nextInt(-50, 50) + m.x, Random.nextInt(-50, 50) + m.y));
			break;
		case 1:
			Condition.sleep(5000);
			break;
		case 2:
			int random = Random.nextInt(1, 28);
			Component i = ctx.backpack.component().component(random);
			if (ctx.backpack.select().count() >= random) {
				i.interact("Examine");
			}
			break;
		case 3:
		case 4:
			ctx.camera.angleTo(Random.nextInt(0, 360));
			ctx.camera.pitch(Random.nextInt(21, 39));
			break;
		}
	}

	
	
}
