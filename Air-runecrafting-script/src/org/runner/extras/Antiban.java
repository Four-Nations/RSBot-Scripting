package org.runner.extras;

import java.awt.Point;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;
import org.powerbot.script.rt6.GameObject;
import org.runner.task.Task;

/**
 *
 * @author Cody
 *
 */

@SuppressWarnings("deprecation")
public class Antiban extends Task<ClientContext> {

	public Antiban(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return Random.nextInt(0, 200) == 1 && !ctx.bank.opened();
	}

	@Override
	public void execute() {
		switch (Random.nextInt(0, 7)) {
		case 0:
			Point m = ctx.input.getLocation();
			ctx.input.move(new Point(Random.nextInt(-50, 50) + m.x, Random.nextInt(-50, 50) + m.y));
			break;
		case 1:
			Condition.sleep(5000);
			break;
		case 2:
			int random = Random.nextInt(1, 28);
			Component i = ctx.backpack.component().component(random);
			if (ctx.backpack.select().count() >= random) {
				i.interact("Examine");
			}
			break;
		case 3:
		case 4:
			ctx.camera.angleTo(Random.nextInt(0, 360));
			ctx.camera.pitch(Random.nextInt(20, 40));
			break;
		case 5:
			Component rcInterface = ctx.widgets.component(1213,36);
			if (rcInterface.valid()) {
				rcInterface.hover();
				Condition.sleep(2000);
			}
			break;
		case 6:
			GameObject object = ctx.objects.select().nearest().poll();
			if (object.inViewport()) {
				object.interact("Examine");
			}
		}
	}

	public static String getInfo() {
		return "Thanks for choosing Four-Nations Woodcutting script! \n"
				+ "Here's just a quick list of features which is optional \n"
				+ "for you to use in this script, you can enable the below \n"
				+ "features by clicking the Antiban checkbox before starting \n"
				+ "the script! \n\n"
				+ "* Random mouse movements \n"
				+ "* Random camera actions \n"
				+ "* Random afking \n"
				+ "* Hovering over stats \n"
				+ "* Random examining of a random item in your inventory \n\n"
				+ "Please feel free to suggest more antibans via the script thread (s)\n"
				+ "on powerbot.org, Have fun botting!";
	}

}