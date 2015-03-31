package org.arrow.actions;

import org.arrow.Settings;
import org.arrow.task.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Item;

public class Fletcher extends Task<ClientContext> {

	public Fletcher(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean hasRequirements() {
		return !ctx.widgets.widget(1251).valid();
	}

	@Override
	public void runTask() {
		Item arrowShaft = ctx.backpack.select().id(Settings.ARROW_SHAFTS).poll();
		Component widget = ctx.widgets.component(1370, 20);
		Component subscribeInterface = ctx.widgets.component(1401, 31);
		if (subscribeInterface.valid()) {
			subscribeInterface.click();
		}
		if (ctx.backpack.select().id(Settings.FEATHER).count() == 0 || ctx.backpack.select().id(Settings.ARROW_SHAFTS).count() == 0) {
			ctx.controller.stop();
		} if (widget.valid()) {
			widget.click(true);
			Settings.STATUS = "Starting fletch.";
			Condition.sleep(1500);
			arrowShaft.hover();
			Settings.STATUS = "Hovering shaft.";
		} else {
			arrowShaft.interact("Feather");
			Settings.STATUS = "Clicking shaft.";
			Condition.sleep(750);
		}
		
	}

}
