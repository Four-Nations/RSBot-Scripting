package org.arrow.actions;

import org.arrow.Settings;
import org.arrow.task.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.GroundItem;
import org.powerbot.script.rt6.Item;

public class Pickup extends Task<ClientContext> {

	private int MAX_TILE_DISTANCE = 150;
	private int[] objects = new int[] {33791, 45269};

	public Pickup(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean hasRequirements() {
		return !ctx.groundItems.select().id(Settings.FEATHER).isEmpty() && !ctx.players.local().inMotion();
	}

	@Override
	public void runTask() {
		Item chicken = ctx.backpack.select().id(2138).poll();
		Item bones = ctx.backpack.select().id(526).poll();
		GroundItem feather = ctx.groundItems.select().id(Settings.FEATHER).nearest().limit(2).shuffle().poll();
		GameObject bounds = ctx.objects.select().id(objects).nearest().poll();
		GameObject gate = ctx.objects.select().id(Settings.GATE).nearest().poll();
		if (chicken.valid()) {
			chicken.interact("Drop");
		}
		if (bones.valid()) {
			bones.interact("Bury");
		}
		if (ctx.movement.distance(ctx.players.local().tile(), feather.tile()) > MAX_TILE_DISTANCE) {
			System.out.println("Sleeping... ");
			Settings.STATUS = "Waiting for spawn.";
			Condition.sleep(500);
			return;
		}
		if (!ctx.objects.select().id(Settings.GATE).isEmpty() && ctx.movement.distance(ctx.players.local().tile(), feather.tile()) == -1 && 
			ctx.movement.distance(ctx.players.local().tile(), gate.tile()) < MAX_TILE_DISTANCE && ctx.movement.distance(ctx.players.local().tile(), bounds.tile()) == -1) {
			ctx.camera.turnTo(gate);
			gate.interact("Open");
			System.out.println("Opening gate, distance to gate --> "+ctx.movement.distance(ctx.players.local().tile(), gate.tile()));
			Settings.STATUS = "Opening gate.";
			Condition.sleep(1500);
			return;
		}
		if (feather.inViewport() && ctx.movement.distance(ctx.players.local().tile(), feather.tile()) != -1) {
			feather.interact("Take", feather.name());
			System.out.println("Taking feather");
			Settings.STATUS = "Taking feather.";
			Condition.sleep(750);
			return;
		} if (!feather.inViewport() && ctx.movement.distance(ctx.players.local().tile(), feather.tile()) != -1) {
			ctx.camera.turnTo(feather);
			Settings.STATUS = "Turning camera.";
			System.out.println("Turning camera - "+ctx.movement.distance(ctx.players.local().tile(), feather.tile()));
			return;
		} else {
			System.out.println("Sleeping... ");
			Settings.STATUS = "Waiting for spawn.";
			Condition.sleep(500);
			return;
		}
	}

}
