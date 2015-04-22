package org.fletcher.flech;

public class Fletch {
	
	public enum FletchTypes {
		
		NORMAL(1511, new String[] {"Shafts", "Shortbow", "Stock", "Shieldbow"}, new int[] {0, 4, 8, 12}, new int[] {52, 50, 9440, 48}),
		OAK(1521, new String[] {"Shortbow", "Stock", "Shieldbow"}, new int[] {0, 4, 8}, new int[] {54, 9442, 56}), //done
		WILLOW(1519, new String[] {"Shortbow", "Stock", "Shieldbow"}, new int[] {0, 4, 8}, new int[] {60, 9444, 58}), //done
		MAPLE(1517, new String[] {"Shortbow", "Stock", "Shieldbow"}, new int[] {0, 4, 8}, new int[] {64, 9448, 62}), //done
		YEW(1515, new String[] {"Shortbow", "Stock", "Shieldbow"}, new int[] {0, 4, 8}, new int[] {68, 9452, 66}), //done
		MAGIC(1513, new String[] {"Shortbow", "Shieldbow", "Stock"}, new int[] {0, 4, 8}, new int[] {72, 70, 25483}); //done
		
		private int logId;
		private String[] methods;
		private int[] componentIds;
		private int[] cutBowId;//unstring bow id for component
		
		public int getLogId() {
			return logId;
		}
		
		public String[] getMethods() {
			return methods;
		}
		
		public int[] getComponentIds() {
			return componentIds;
		}
		
		public int[] getUnstringBowId() {
			return cutBowId;
		}
		
		FletchTypes(int logId, String[] methods, int[] componentIds, int[] cutBowId) {
			this.logId = logId;
			this.methods = methods;
			this.componentIds = componentIds;
			this.cutBowId = cutBowId;
		}
		
	}

}
