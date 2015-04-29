package org.fletcher.fletch;

public class Info {
	
	public static enum Methods {
		
		REGULAR(1511, new String[] {"Arrow shaft", "Shortbow", "Wooden stock", "Shieldbow"}, new int[] {52, 50, 9440, 48}),
		OAK(1521, new String[] {"Arrow shaft", "Shortbow", "Oak stock", "Shieldbow"}, new int[] {52, 54, 9442, 56}),
		WILLOW(1519, new String[] {"Arrow shaft", "Shortbow", "Willow stock", "Shieldbow"}, new int[] {52, 60, 9444, 58}),
		MAPLE(1517, new String[] {"Arrow shaft", "Shortbow", "Maple stock", "Shieldbow"}, new int[] {52, 64, 9448, 62}),
		YEW(1515, new String[] {"Arrow shaft", "Shortbow", "Yew stock", "Shieldbow"}, new int[] {52, 68, 9452, 66}),
		MAGIC(1513, new String[] {"Arrow shaft", "Shortbow", "Shieldbow", "Magic stock"}, new int[] {52, 72, 70, 25483});
		//ELDER();
		
		private int logId;
		private String[] method;
		private int[] cutBowId;
		
		Methods(int logId, String[] method, int[] cutBowId) {
			this.logId = logId;
			this.method = method;
			this.cutBowId = cutBowId;
		}
		
		public int getLogId() {
			return logId;
		}
		
		public String[] getMethod() {
			return method;
		}
		
		public int[] getCutBowId() {
			return cutBowId;
		}
		
	}

}
