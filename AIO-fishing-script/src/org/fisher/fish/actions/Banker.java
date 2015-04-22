package org.fisher.fish.actions;

import org.fisher.Settings;
import org.fisher.task.Task;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;

public class Banker extends Task<ClientContext> {

	public Banker(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean hasRequirements() {
		return ctx.backpack.select().count() == 28;
	}

	@Override
	public void runTask() {
		if (ctx.backpack.select().count() == 28 && !ctx.bank.inViewport() || ctx.backpack.select().count() == 28 && getTaverlyBank()) {
			ctx.movement.newTilePath(Settings.INFO.getTileToSpot()[Settings.TILE_INDEX]).randomize(1, 1).reverse().traverse();
		}
		if (ctx.bank.inViewport() && !getTaverlyBank()) {
			ctx.camera.turnTo(ctx.bank.nearest());
			ctx.bank.open();
			if (!Settings.INFO.getRequiresMaterials()) {
				ctx.bank.depositInventory();
			} else {
				for (int i = 0; i < Settings.INFO.getFishIds().length; i++) {
					ctx.bank.deposit(Settings.INFO.getFishIds()[i], 500);
				}
			}
			ctx.bank.close();
		}
	}
	
	public boolean getTaverlyBank() {
		Tile tile = ctx.bank.nearest().tile();
		return tile.x() > 2866 && tile.x() < 2886 && tile.y() > 3406 && tile.y() < 3424;
	}

}
