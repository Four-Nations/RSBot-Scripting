package org.fisher.fish;

import org.powerbot.script.Tile;

public class Fish {

	public enum FishTypes {
		
		SHRIMP(new int[] { 330, 4908, 327, 320 } , new int[] { 317, 321 }, "Net", false, new String[] {"Catherby", "Al Kharid",  "Draynor"},
				new Tile[] { new Tile(2809, 3440, 0), new Tile(2816, 3435, 0), new Tile(2824, 3437, 0), new Tile(2832, 3436, 0), new Tile(2840, 3434, 0), new Tile(2848, 3431, 0), new Tile(2855, 3427, 0), },
				new Tile[] {new Tile(3270, 3166, 0), new Tile(3277, 3170, 0), new Tile(3277, 3178, 0), new Tile(3269, 3180, 0), new Tile(3263, 3174, 0)},
				new Tile[] {new Tile(3092, 3248, 0), new Tile(3088, 3237, 0), new Tile(3089, 3230, 0)}),
		CRAYFISH(new int[] { 6267 } , new int[] { 13435 }, "Cage", false, new String[] {"Lumbridge"},
				new Tile[] { new Tile(3271, 3168, 0), new Tile(3276, 3168, 0), new Tile(3278, 3173, 0), new Tile(3275, 3177, 0), new Tile(3270, 3178, 0),
				new Tile(3265, 3178, 0), new Tile(3262, 3174, 0),new Tile(3257, 3173, 0), new Tile(3252, 3173, 0), new Tile(3249, 3169, 0),
				new Tile(3244, 3169, 0), new Tile(3240, 3172, 0), new Tile(3240, 3177, 0), new Tile(3240, 3182, 0), new Tile(3243, 3186, 0),
				new Tile(3248, 3187, 0), new Tile(3253, 3189, 0), new Tile(3253, 3194, 0), new Tile(3254, 3199, 0), new Tile(3257, 3203, 0) }),
		//MINNOW(new int[] { -1, -1}, new int[] { -1, -1}, "", new String[] {""}, new Tile[] { new Tile (-1, -1) }),
	 	//KARAMBWANJI(new int[] { -1, -1}, new int[] { -1, -1}, "", new String[] {"Tai Bwo Wannai", "Shilo Village"}, new Tile[] { new Tile (-1, -1) }),
		SARDINE(new int[] { 330, 4908, 327 }, new int[] { 345, 327 }, "Bait", true, new String[] {"Catherby", "Al Kharid",  "Draynor Village"},
				new Tile[] { new Tile(2809, 3442, 0), new Tile(2815, 3436, 0), new Tile(2823, 3436, 0), new Tile(2831, 3436, 0), new Tile(2839, 3435, 0), new Tile(2846, 3430, 0), new Tile(2850, 3430, 0), new Tile(2854, 3426, 0) },
				new Tile[] {new Tile(3270, 3166, 0), new Tile(3277, 3170, 0), new Tile(3277, 3178, 0), new Tile(3269, 3180, 0), new Tile(3263, 3174, 0)},
				new Tile[] {new Tile(3092, 3248, 0), new Tile(3088, 3237, 0), new Tile(3089, 3230, 0)}),
		HERRING(new int[] { 330, 4908, 327 }, new int[] { 345, 327 }, "Bait", true, new String[] {"Catherby", "Al Kharid",  "Draynor Village"},
				new Tile[] { new Tile(2809, 3442, 0), new Tile(2815, 3436, 0), new Tile(2823, 3436, 0), new Tile(2831, 3436, 0), new Tile(2839, 3435, 0), new Tile(2846, 3430, 0), new Tile(2850, 3430, 0), new Tile(2854, 3426, 0) },
				new Tile[] {new Tile(3270, 3166, 0), new Tile(3277, 3170, 0), new Tile(3277, 3178, 0), new Tile(3269, 3180, 0), new Tile(3263, 3174, 0)},
				new Tile[] {new Tile(3092, 3248, 0), new Tile(3088, 3237, 0), new Tile(3089, 3230, 0)}),
		ANCHOVIES(new int[] { 330, 4908, 327, 320 }, new int[] { 317, 321 }, "Net", false, new String[] {"Catherby", "Al Kharid",  "Draynor"},
				new Tile[] { new Tile(2809, 3440, 0), new Tile(2816, 3435, 0), new Tile(2824, 3437, 0), new Tile(2832, 3436, 0), new Tile(2840, 3434, 0), new Tile(2848, 3431, 0), new Tile(2855, 3427, 0), },
				new Tile[] {new Tile(3270, 3166, 0), new Tile(3277, 3170, 0), new Tile(3277, 3178, 0), new Tile(3269, 3180, 0), new Tile(3263, 3174, 0)},
				new Tile[] {new Tile(3092, 3248, 0), new Tile(3088, 3237, 0), new Tile(3089, 3230, 0)}),
		MACKEREL(new int[] { 322, 313}, new int[] {  405, 353, 363, 1059, 1061, 407, 345, 401, 341}, "Net", false, new String[] {"Catherby", "Fishing guild"},
				new Tile[] { new Tile(2809, 3441, 0), new Tile(2817, 3435, 0), new Tile(2827, 3437, 0), new Tile(2837, 3434, 0), new Tile(2847, 3430, 0), new Tile(2857, 3426, 0)},
				new Tile[] { new Tile(2585, 3422, 0), new Tile(2595, 3420, 0), new Tile(2602, 3421, 0)}),
		TROUT(new int[] { 328, 329 }, new int[] { 335, 331 }, "Lure", true, new String[] {"Lumbridge", "Barbarian village", "Ardougne", "Shilo village", "Seers village"},
				new Tile[] { new Tile(3211, 3254, 0), new Tile(3216, 3254, 0), new Tile(3220, 3257, 0), new Tile(3224, 3260, 0), new Tile(3228, 3263, 0), new Tile(3233, 3262, 0), new Tile(3238, 3262, 0), new Tile(3243, 3262, 0), new Tile(3246, 3258, 0), new Tile(3242, 3255, 0), new Tile(3241, 3250, 0), new Tile(3241, 3245, 0), new Tile(3241, 3240, 0) },
				new Tile[] { new Tile(3093, 3493, 0), new Tile(3083, 3493, 0), new Tile(3083, 3483, 0), new Tile(3081, 3473, 0), new Tile(3086, 3464, 0), new Tile(3092, 3456, 0), new Tile(3097, 3447, 0), new Tile(3102, 3438, 0), new Tile(3104, 3428, 0)},
				new Tile[] { new Tile(2614, 3334, 0), new Tile(2612, 3344, 0), new Tile(2602, 3347, 0), new Tile(2594, 3353, 0), new Tile(2593, 3363, 0), new Tile(2587, 3371, 0), new Tile(2581, 3363, 0), new Tile(2582, 3353, 0), new Tile(2573, 3358, 0), new Tile(2565, 3364, 0), new Tile(2560, 3370, 0)},
				new Tile[] { new Tile(2852, 2955, 0), new Tile(2849, 2965, 0), new Tile(2855, 2973, 0), new Tile(2856, 2979, 0)},
				new Tile[] { new Tile(2726, 3492, 0), new Tile(2732, 3484, 0), new Tile(2738, 3492, 0), new Tile(2743, 3501, 0), new Tile(2743, 3511, 0), new Tile(2737, 3519, 0), new Tile(2732, 3528, 0), new Tile(2722, 3530, 0)}),
		COD(new int[] { 322, 313 }, new int[] { 405, 353, 363, 1059, 1061, 407, 345, 401, 341 }, "Net", false, new String[] {"Catherby", "Fishing guild"},
				new Tile[] { new Tile(2809, 3441, 0), new Tile(2817, 3435, 0), new Tile(2827, 3437, 0), new Tile(2837, 3434, 0), new Tile(2847, 3430, 0), new Tile(2857, 3426, 0)},
				new Tile[] { new Tile(2585, 3422, 0), new Tile(2595, 3420, 0), new Tile(2602, 3421, 0)}),
		PIKE(new int[] { 329 }, new int[] { 349 }, "Bait", true, new String[] {"Lumbridge", "Barbarian village", "Ardougne", "Shilo village", "Seers village"},
				new Tile[] { new Tile(3211, 3254, 0), new Tile(3216, 3254, 0), new Tile(3220, 3257, 0), new Tile(3224, 3260, 0), new Tile(3228, 3263, 0), new Tile(3233, 3262, 0), new Tile(3238, 3262, 0), new Tile(3243, 3262, 0), new Tile(3246, 3258, 0), new Tile(3242, 3255, 0), new Tile(3241, 3250, 0), new Tile(3241, 3245, 0), new Tile(3241, 3240, 0) },
				new Tile[] { new Tile(3093, 3493, 0), new Tile(3083, 3493, 0), new Tile(3083, 3483, 0), new Tile(3081, 3473, 0), new Tile(3086, 3464, 0), new Tile(3092, 3456, 0), new Tile(3097, 3447, 0), new Tile(3102, 3438, 0), new Tile(3104, 3428, 0)},
				new Tile[] { new Tile(2614, 3334, 0), new Tile(2612, 3344, 0), new Tile(2602, 3347, 0), new Tile(2594, 3353, 0), new Tile(2593, 3363, 0), new Tile(2587, 3371, 0), new Tile(2581, 3363, 0), new Tile(2582, 3353, 0), new Tile(2573, 3358, 0), new Tile(2565, 3364, 0), new Tile(2560, 3370, 0)},
				new Tile[] { new Tile(2852, 2955, 0), new Tile(2849, 2965, 0), new Tile(2855, 2973, 0), new Tile(2856, 2979, 0)},
				new Tile[] { new Tile(2726, 3492, 0), new Tile(2732, 3484, 0), new Tile(2738, 3492, 0), new Tile(2743, 3501, 0), new Tile(2743, 3511, 0), new Tile(2737, 3519, 0), new Tile(2732, 3528, 0), new Tile(2722, 3530, 0)}),
		//SLIMY_EEL(new int[] { -1, -1}, new int[] { -1, -1}, "", new String[] {"Mort Myre Swamp", "Lumbridge swamp cave"}, new Tile[] { new Tile (-1, -1) }),
		SALMON(new int[] { 328, 329 }, new int[] { 335, 331 }, "Lure", true, new String[] {"Lumbridge", "Barbarian village", "Ardougne", "Shilo village", "Seers village"},
				new Tile[] { new Tile(3211, 3254, 0), new Tile(3216, 3254, 0), new Tile(3220, 3257, 0), new Tile(3224, 3260, 0), new Tile(3228, 3263, 0), new Tile(3233, 3262, 0), new Tile(3238, 3262, 0), new Tile(3243, 3262, 0), new Tile(3246, 3258, 0), new Tile(3242, 3255, 0), new Tile(3241, 3250, 0), new Tile(3241, 3245, 0), new Tile(3241, 3240, 0) },
				new Tile[] { new Tile(3093, 3493, 0), new Tile(3083, 3493, 0), new Tile(3083, 3483, 0), new Tile(3081, 3473, 0), new Tile(3086, 3464, 0), new Tile(3092, 3456, 0), new Tile(3097, 3447, 0), new Tile(3102, 3438, 0), new Tile(3104, 3428, 0)},
				new Tile[] { new Tile(2614, 3334, 0), new Tile(2612, 3344, 0), new Tile(2602, 3347, 0), new Tile(2594, 3353, 0), new Tile(2593, 3363, 0), new Tile(2587, 3371, 0), new Tile(2581, 3363, 0), new Tile(2582, 3353, 0), new Tile(2573, 3358, 0), new Tile(2565, 3364, 0), new Tile(2560, 3370, 0)},
				new Tile[] { new Tile(2852, 2955, 0), new Tile(2849, 2965, 0), new Tile(2855, 2973, 0), new Tile(2856, 2979, 0)},
				new Tile[] { new Tile(2726, 3492, 0), new Tile(2732, 3484, 0), new Tile(2738, 3492, 0), new Tile(2743, 3501, 0), new Tile(2743, 3511, 0), new Tile(2737, 3519, 0), new Tile(2732, 3528, 0), new Tile(2722, 3530, 0)}),
		//FROG_SPAWN(new int[] { -1, -1}, new int[] { -1, -1}, "", new String[] {"Lumbridge swamp cave"}, new Tile[] { new Tile (-1, -1) }),
		TUNA(new int[] { 321, 324, 3848, 312 }, new int[] { 359, 371 }, "Harpoon", false, new String[] {"Catherby", "Fishing guild"},
				new Tile[] { new Tile(2809, 3441, 0), new Tile(2817, 3435, 0), new Tile(2827, 3437, 0), new Tile(2837, 3434, 0), new Tile(2847, 3430, 0), new Tile(2857, 3426, 0)},
				new Tile[] { new Tile(2585, 3422, 0), new Tile(2595, 3420, 0), new Tile(2602, 3421, 0)}),
		RAINBOW_FISH(new int[] { -1, -1}, new int[] { -1, -1}, "Lure", true, new String[] {"Lumbridge", "Barbarian village", "Ardougne", "Shilo village", "Seers village"},
				new Tile[] { new Tile(3211, 3254, 0), new Tile(3216, 3254, 0), new Tile(3220, 3257, 0), new Tile(3224, 3260, 0), new Tile(3228, 3263, 0), new Tile(3233, 3262, 0), new Tile(3238, 3262, 0), new Tile(3243, 3262, 0), new Tile(3246, 3258, 0), new Tile(3242, 3255, 0), new Tile(3241, 3250, 0), new Tile(3241, 3245, 0), new Tile(3241, 3240, 0) },
				new Tile[] { new Tile(3093, 3493, 0), new Tile(3083, 3493, 0), new Tile(3083, 3483, 0), new Tile(3081, 3473, 0), new Tile(3086, 3464, 0), new Tile(3092, 3456, 0), new Tile(3097, 3447, 0), new Tile(3102, 3438, 0), new Tile(3104, 3428, 0)},
				new Tile[] { new Tile(2614, 3334, 0), new Tile(2612, 3344, 0), new Tile(2602, 3347, 0), new Tile(2594, 3353, 0), new Tile(2593, 3363, 0), new Tile(2587, 3371, 0), new Tile(2581, 3363, 0), new Tile(2582, 3353, 0), new Tile(2573, 3358, 0), new Tile(2565, 3364, 0), new Tile(2560, 3370, 0)},
				new Tile[] { new Tile(2852, 2955, 0), new Tile(2849, 2965, 0), new Tile(2855, 2973, 0), new Tile(2856, 2979, 0)},
				new Tile[] { new Tile(2726, 3492, 0), new Tile(2732, 3484, 0), new Tile(2738, 3492, 0), new Tile(2743, 3501, 0), new Tile(2743, 3511, 0), new Tile(2737, 3519, 0), new Tile(2732, 3528, 0), new Tile(2722, 3530, 0)}),
		//CAVE_EEL(new int[] { -1, -1}, new int[] { -1, -1}, "", new String[] {"Lumbridge swamp cave"}, new Tile[] { new Tile (-1, -1) }),
		LOBSTER(new int[] { 321, 324, 312 }, new int[] { 377 }, "Cage", false, new String[] { "Catherby", "Fishing Guild"},
				new Tile[] { new Tile(2809, 3441, 0), new Tile(2817, 3435, 0), new Tile(2827, 3437, 0), new Tile(2837, 3434, 0), new Tile(2847, 3430, 0), new Tile(2857, 3426, 0)},
				new Tile[] { new Tile(2585, 3422, 0), new Tile(2595, 3420, 0), new Tile(2602, 3421, 0)}),
		BASS(new int[] { 322, 313 }, new int[] { 405, 353, 363, 1059, 1061, 407, 345, 401, 341 }, "Net", false, new String[] {"Catherby", "Fishing guild"},
				new Tile[] { new Tile(2809, 3441, 0), new Tile(2817, 3435, 0), new Tile(2827, 3437, 0), new Tile(2837, 3434, 0), new Tile(2847, 3430, 0), new Tile(2857, 3426, 0)},
				new Tile[] { new Tile(2585, 3422, 0), new Tile(2595, 3420, 0), new Tile(2602, 3421, 0)}),
		LEAPING_TROUT(new int[] { 2722 }, new int[] { 11328, 11330, 11332}, "Use-rod", true, new String[] {"Barbarian outpost"}, new Tile[] { new Tile (-1, -1) }),
		SWORDFISH(new int[] { 321, 324, 3848, 312 }, new int[] { 359, 371 }, "Harpoon", false, new String[] {"Catherby", "Fishing guild"},
				new Tile[] { new Tile(2809, 3441, 0), new Tile(2817, 3435, 0), new Tile(2827, 3437, 0), new Tile(2837, 3434, 0), new Tile(2847, 3430, 0), new Tile(2857, 3426, 0)},
				new Tile[] { new Tile(2585, 3422, 0), new Tile(2595, 3420, 0), new Tile(2602, 3421, 0)}),
		//LAVA_EEL(new int[] { -1, -1}, new int[] { -1, -1}, "", new String[] {"Taverly dungeon", "Lava maze"}, new Tile[] { new Tile (-1, -1) }),
		LEAPING_SALMON(new int[] { 2722 }, new int[] { 11328, 11330, 11332}, "Use-rod", true, new String[] {"Barbarian outpost"}, new Tile[] { new Tile (-1, -1) }),
		MONKFISH(new int[] { 3848 }, new int[] { 7944 }, "Net", false, new String[] {"Piscatoris Fishing Colony"},
				new Tile[] {new Tile(2330, 3689, 0), new Tile(2340, 3689, 0), new Tile(2343, 3699, 0)}),
		//KARAMBWAN(new int[] { -1, -1}, new int[] { -1, -1}, "", new String[] {""}, new Tile[] { new Tile (-1, -1) }),
		LEAPING_STURGEON(new int[] { 2722 }, new int[] { 11328, 11330, 11332}, "Use-rod", true, new String[] {"Barbarian outpost"}, new Tile[] { new Tile (-1, -1) }),
		SHARK(new int[] {322, 313}, new int[] { 383 }, "Harpoon", false, new String[] {"Catherby", "Fishing guild"},
				new Tile[] { new Tile(2809, 3441, 0), new Tile(2817, 3435, 0), new Tile(2827, 3437, 0), new Tile(2837, 3434, 0), new Tile(2847, 3430, 0), new Tile(2857, 3426, 0)},
				new Tile[] { new Tile(2585, 3422, 0), new Tile(2595, 3420, 0), new Tile(2602, 3421, 0)});
		//SEA_TURTLE(new int[] { -1, -1}, new int[] { -1, -1}, "", new String[] {"Port Khazard"}, new Tile[] { new Tile (-1, -1) }),
		//MANTA_RAY(new int[] { -1, -1}, new int[] { -1, -1}, "", new String[] {"Port Khazard"}, new Tile[] { new Tile (-1, -1) }),
		//CAVEFISH(new int[] { -1, -1}, new int[] { 15264 }, "", new String[] {"Living Rock Caverns"}, new Tile[] { new Tile (-1, -1) }),
		//ROCKTAIL(new int[] { -1, -1}, new int[] { 15270 }, "", new String[] {"Living Rock Caverns"}, new Tile[] { new Tile (-1, -1) });
		//TIGER_SHARK(new int[] { -1, -1}, new int[] { -1, -1}, "", new String[] {"Port Khazard"}, new Tile[] { new Tile (-1, -1) }),
		
		private int[] spotIds;
		private int[] fishIds;
		private String option;
		private boolean requiresMaterials;
		private String[] locations;
		private Tile[][] tileToSpot; //Route to spot from nearest bank.
		
		FishTypes(int[] spotIds, int[] fishIds, String option, boolean requiresMaterials, String[] locations, Tile[]... tileToSpot) {
			this.spotIds = spotIds;
			this.fishIds = fishIds;
			this.option = option;
			this.requiresMaterials = requiresMaterials;
			this.locations = locations;
			this.tileToSpot = tileToSpot;
		}
		
		public int[] getSpotIds() {
			return spotIds;
		}
		
		public int[] getFishIds() {
			return fishIds;
		}
		
		public String getOption() {
			return option;
		}
		
		public boolean getRequiresMaterials() {
			return requiresMaterials;
		}
		
		public String[] getLocations() {
			return locations;
		}
		
		public Tile[][] getTileToSpot() {
			return tileToSpot;
		}
		
	}

}
