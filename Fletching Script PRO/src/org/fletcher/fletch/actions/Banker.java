package org.fletcher.fletch.actions;

import org.fletcher.Settings;
import org.fletcher.task.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;

public class Banker extends Task<ClientContext> {
	

	public Banker(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean hasRequirements() {
		if (Settings.stringing) {
			return ctx.backpack.select().id(Settings.method.getCutBowId()[Settings.methodIndex]).count() == 0 ||
					ctx.backpack.select().id(1777).count() == 0;
		}
		return ctx.backpack.select().id(Settings.method.getLogId()).count() == 0;
	}

	@Override
	public void runTask() {
		if (!ctx.bank.opened()) {
			if (!ctx.bank.inViewport()) {
				ctx.camera.turnTo(ctx.bank.nearest());
			}
			ctx.bank.open();
		}
		switch(Settings.bankIndex) {
		case 0:
			ctx.bank.depositInventory();
			if (Settings.stringing) {				
				ctx.bank.withdraw(Settings.method.getCutBowId()[Settings.methodIndex], 14);
				ctx.bank.withdraw(1777, 14);
			} else {
				ctx.bank.withdraw(Settings.method.getLogId(), 100000);
			}
			ctx.bank.close();
			break;
		case 1:
			Component preset1 = ctx.widgets.component(762, 40);
			if (preset1.valid()) {
				preset1.click();
				Condition.sleep(1500);
			}	
			break;
		case 2:
			Component preset2 = ctx.widgets.component(762, 48);
			if (preset2.valid()) {
				preset2.click();
				Condition.sleep(1500);
			}
			break;
		}
	}

}
