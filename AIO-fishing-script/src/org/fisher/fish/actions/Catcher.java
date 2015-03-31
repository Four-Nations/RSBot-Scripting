package org.fisher.fish.actions;

import org.fisher.Settings;
import org.fisher.task.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Npc;

public class Catcher extends Task<ClientContext> {

	public Catcher(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean hasRequirements() {
		return !ctx.players.local().interacting().valid() && ctx.backpack.select().count() != 28 && !Settings.DROPPING;
	}

	@Override
	public void runTask() {
		Npc fishSpot = ctx.npcs.select().id(Settings.INFO.getSpotIds()).nearest().poll();
		if (ctx.movement.distance(fishSpot) == -1 && Settings.TILE_INDEX != -1 && !fishSpot.inViewport()) {
			ctx.movement.newTilePath(Settings.INFO.getTileToSpot()[Settings.TILE_INDEX]).randomize(1, 1).traverse();
		}
		if (!fishSpot.inViewport()) {
			ctx.movement.step(fishSpot);
			ctx.camera.turnTo(fishSpot);
		}
		fishSpot.interact(Settings.INFO.getOption());
		Condition.sleep(2000);
	}
}
