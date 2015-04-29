package org.fletcher.fletch.actions;

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
		System.out.println("Bow stringer.. "+Settings.method.getCutBowId()[Settings.methodIndex]);
		return !ctx.widgets.widget(1251).valid() && 
				ctx.backpack.select().id(Settings.method.getCutBowId()[Settings.methodIndex]).count() != 0 &&
				ctx.backpack.select().id(1777).count() != 0;
	}

	@Override
	public void runTask() {
		Component startStringing = ctx.widgets.component(1370, 38);
		if (startStringing.valid()) {
			startStringing.click();
			Condition.sleep(1000);
		} else {
			Item bow = ctx.backpack.select().id(Settings.method.getCutBowId()[Settings.methodIndex]).poll();
			bow.interact("String");
			Condition.sleep(1000);
		}
	}

}
