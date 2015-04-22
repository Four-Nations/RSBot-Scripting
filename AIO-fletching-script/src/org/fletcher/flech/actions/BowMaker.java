package org.fletcher.flech.actions;

import org.fletcher.Settings;
import org.fletcher.task.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.Item;

public class BowMaker extends Task<ClientContext> {

	public BowMaker(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean hasRequirements() {
		return !ctx.widgets.widget(1251).valid() && ctx.backpack.select().id(Settings.TYPES.getLogId()).count() != 0; //fletching interface
	}

	@Override
	public void runTask() {
		Component selectToolInterface = ctx.widgets.component(1179, 33);
		Component methodSelector = ctx.widgets.component(1371, 44).component(Settings.TYPES.getComponentIds()[Settings.COMPONENT_INDEX]);
		Component startFletchInterface = ctx.widgets.component(1370, 33);
		Component subscribeInterface = ctx.widgets.component(1401, 31);
		if (subscribeInterface.valid()) {
			subscribeInterface.click();
		}
		if (selectToolInterface.valid()) {
			selectToolInterface.click();
		}
		else if (methodSelector.valid()) {
			if (!Settings.CLICKED_INTERFACE) {
				methodSelector.click();
				Settings.CLICKED_INTERFACE = true;
			}
			startFletchInterface.click();
			Condition.sleep(1000);
		} else {
			Item log = ctx.backpack.select().id(Settings.TYPES.getLogId()).poll();
			log.interact("Craft");
			Condition.sleep(1000);
		}
	}



}
