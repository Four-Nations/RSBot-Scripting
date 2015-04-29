package org.fletcher.fletch.actions;

import org.fletcher.Settings;
import org.fletcher.task.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Item;

public class BowCrafter extends Task<ClientContext> {

	public BowCrafter(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean hasRequirements() {
		return !ctx.widgets.widget(1251).valid() && ctx.backpack.select().id(Settings.method.getLogId()).count() != 0;
	}

	@Override
	public void runTask() {
		Component toolChooser = ctx.widgets.component(1179, 34);
		Component method = ctx.widgets.component(1371, 44).component(Settings.methodIndex*4);
		Component startFletch = ctx.widgets.component(1370, 20);
		if (toolChooser.valid()) {
			toolChooser.click();
			Condition.sleep(1000);
		}
		if (method.valid()) {
			if (Settings.firstFletch) {
				method.click();
				Settings.firstFletch = false;
			}
			startFletch.click();
			Condition.sleep(1500);
		} else {
			Item log = ctx.backpack.select().id(Settings.method.getLogId()).poll();
			log.interact("Craft");
			Condition.sleep(1000);
		}
	}

}
