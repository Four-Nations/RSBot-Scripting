package org.fletcher.flech.actions;

import org.fletcher.Settings;
import org.fletcher.task.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Item;

public class BowStringer extends Task<ClientContext> {
	
	public BowStringer(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean hasRequirements() {
		return !ctx.widgets.widget(1251).valid() && ctx.backpack.select().id(Settings.TYPES.getUnstringBowId()[Settings.STRING_INDEX]).count() != 0
				&& ctx.backpack.select().id(1777).count() != 0;
	}

	@Override
	public void runTask() {
		Component startStringing = ctx.widgets.component(1370, 38);
		Component subscribeInterface = ctx.widgets.component(1401, 31);
		if (subscribeInterface.valid()) {
			subscribeInterface.click();
		}
		if (startStringing.valid()) {
			startStringing.click();
			Condition.sleep(1000);
		} else {
			Item bow = ctx.backpack.select().id(Settings.TYPES.getUnstringBowId()[Settings.STRING_INDEX]).poll();
			bow.interact("String");
			Condition.sleep(1000);
		}
	}

}
