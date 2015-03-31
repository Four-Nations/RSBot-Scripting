package org.fletcher.flech.actions;

import org.fletcher.Settings;
import org.fletcher.task.Task;
import org.powerbot.script.rt6.ClientContext;

public class Banker extends Task<ClientContext >{
	
	public Banker(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean hasRequirements() {
		if (Settings.STRINGING) {
			return ctx.backpack.select().id(Settings.TYPES.getUnstringBowId()[Settings.STRING_INDEX]).count() == 0
			&& ctx.backpack.select().id(1777).count() == 0;
		}
		return ctx.backpack.select().id(Settings.TYPES.getLogId()).count() == 0;
	}

	@Override
	public void runTask() {
		if (ctx.bank.opened()) {
			ctx.bank.depositInventory();
			if (Settings.STRINGING) {
				if (ctx.bank.select().id(Settings.TYPES.getUnstringBowId()[Settings.STRING_INDEX]).count(true) == 0 || ctx.bank.select().id(1777).count(true) == 0 ) {
					ctx.controller.stop();
				}
				ctx.bank.withdraw(1777, 14);
				ctx.bank.withdraw(Settings.TYPES.getUnstringBowId()[Settings.STRING_INDEX], 14);
			} else {
				if (ctx.bank.select().id(Settings.TYPES.getLogId()).count(true) == 0) {
					ctx.controller.stop();
				}
				ctx.bank.withdraw(Settings.TYPES.getLogId(), 28);
			}
			ctx.bank.close();
		}
		if (ctx.bank.inViewport() && hasRequirements()) {
			ctx.bank.open();
		} else {
			ctx.camera.turnTo(ctx.bank.nearest());
		}
	}

}
