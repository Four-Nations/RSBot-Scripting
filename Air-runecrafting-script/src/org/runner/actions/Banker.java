package org.runner.actions;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.runner.Constants;
import org.runner.task.Task;

/**
 * 
 * @author Cody
 *
 */

public class Banker extends Task<ClientContext> {

	public Banker(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().count() != 28;
	}

	@Override
	public void execute() {
		final GameObject portal = ctx.objects.select().id(Constants.AIR_PORTAL).nearest().poll();
		final Tile player = ctx.players.local().tile();
		if ((player.x() >= 2839) && (player.x() <= 2849) && (player.y() >= 4828) && (player.y() <= 4840)) {
			ctx.camera.turnTo(portal);
			if (ctx.players.local().tile().distanceTo(portal) > 7) {
				ctx.movement.step(portal);
			}
			portal.interact("Enter");
			Condition.sleep(3500);
		} else {
			if (ctx.players.local().tile().distanceTo(ctx.bank.nearest()) > 6) {
				ctx.movement.newTilePath(Constants.toAltar).reverse().traverse();
			}
			if (ctx.bank.inViewport()) {
				ctx.bank.open();
				ctx.bank.depositInventory();
				if (ctx.bank.select().id(Constants.PURE_ESS ? Constants.PURE_ESSENCE: Constants.RUNE_ESSENCE).count(true) < 28 && ctx.bank.opened()) {
					ctx.controller.stop();
				}
				ctx.bank.withdraw(Constants.PURE_ESS ? Constants.PURE_ESSENCE : Constants.RUNE_ESSENCE, 28);
				ctx.bank.close();
			}
		}
	}
}
