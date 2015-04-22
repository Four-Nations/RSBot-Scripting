package org.fisher.fish.actions;

import org.fisher.Settings;
import org.fisher.task.Task;
import org.powerbot.script.rt6.Action;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Item;

public class Dropper extends Task<ClientContext> {

	public Dropper(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean hasRequirements() {
		return ctx.backpack.select().count() == 28 || Settings.DROPPING;
	}

	@Override
	public void runTask() {
		for (int x = 0; x < Settings.INFO.getFishIds().length; x++ ) {
			Action fish = ctx.combatBar.select().id(Settings.INFO.getFishIds()[x]).poll();
			Component continueInterface = ctx.widgets.component(1186, 7);
			if (continueInterface.valid()) {
				continueInterface.click();
			} if (fish.valid()) {
				if (ctx.backpack.select().count() == 28 || ctx.backpack.select().id(Settings.INFO.getFishIds()).count() != 0) {
					Settings.DROPPING = true;
				} else {
					Settings.DROPPING = false;
				}
				if (ctx.backpack.select().id(Settings.INFO.getFishIds()[x]).count() != 0) {
					String slot = fish.slot()+1+"";
					ctx.input.send(slot.replaceAll("10", "0").replaceAll("11", "-").replaceAll("12", "="));
				}
			} else {
				for (Item i : ctx.backpack.items()) {
					if (i.id() == Settings.INFO.getFishIds()[x]) {
						i.interact("Drop");
					}
				}
			}
		}
	}

}
