package Rinda_Queue;

public class Cilveks {
	
		// Atribūti
		private int rindasId = 60;
		private String vards, darbiba;
		
		// Konstruktors
		public Cilveks(int rindasId, String vards, String darbiba) {
			this.rindasId = rindasId;
			this.vards = vards;
			this.darbiba = darbiba;
		}
		
		// Getter metodes
		public String getVards() {
			return vards;
		}
		
		public String getDarbiba() {
			return darbiba;
		}
		
		public int getRindasId() {
			return rindasId;
		}
		
		// Setter metodes
		public void setVards(String vards) {
			this.vards = vards;
		}
		
		public void setDarbiba(String darbiba) {
			this.darbiba = darbiba;
		}
		
		public void setRindasId(int rindasId) {
			this.rindasId = rindasId;
		}
}
