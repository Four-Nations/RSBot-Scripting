package org.fletcher.task;

import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;

public abstract class Task <Ctx extends ClientContext> extends ClientAccessor {
	
	public Task(Ctx ctx) {
		super(ctx);
	}
	
	public abstract boolean hasRequirements();
	
	public abstract void runTask();

}
