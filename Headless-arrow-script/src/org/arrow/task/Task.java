package org.arrow.task;

import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;

public abstract class Task <C extends ClientContext> extends ClientAccessor {

	public Task(ClientContext ctx) {
		super(ctx);
	}

	public abstract boolean hasRequirements();
	
	public abstract void runTask();

}