package org.runner.task;

import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;

/**
 * 
 * @author Cody
 * 
 */

public abstract class Task<C extends ClientContext> extends ClientAccessor {
	
	public Task(C ctx) {
		super(ctx);
	}

	public abstract boolean activate();

	public abstract void execute();
}
