package org.runner.actions;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.runner.Constants;
import org.runner.task.Task;

/**
 * 
 * @author Cody
 *
 */

public class AirRunner extends Task<ClientContext> {

	public AirRunner(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().count() == 28;
	}

	@Override
	public void execute() {
		final GameObject ruins = ctx.objects.select().id(2452).nearest().poll();
		final GameObject altar = ctx.objects.select().id(2478).nearest().poll();
		if (altar.inViewport()) {
			ctx.camera.turnTo(altar);
			altar.interact("Craft-rune");
			Condition.sleep(4000);
		} else {
			ctx.movement.newTilePath(Constants.toAltar).traverse();
			if (!ctx.players.local().inMotion() || ctx.players.local().tile().distanceTo(ruins) < 10) {
				if (ruins.inViewport()) {
					ruins.interact("Enter");
					Condition.sleep(2000);
				} else {
					ctx.camera.turnTo(ruins);
					ruins.interact("Enter");
					Condition.sleep(2000);
				}
			}
		}
	}
}
