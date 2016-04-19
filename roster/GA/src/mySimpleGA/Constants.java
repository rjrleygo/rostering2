package mySimpleGA;

public class Constants {
	public static final int DEFAULT_POPULATION_SIZE = 10;
	public static final int DEFAULT_TOURNAMENT_SIZE = 5;

	public enum Assignment {
		M8 ("0000", "Morning 8"),
		A8 ("0001", "Afternoon 8"),
		N8 ("0010", "Night 8"),
		D12("0011", "Day 12"),
		N12("0100", "Night 12"),
		SD ("0101", "Study Day"),
		AL ("0110", "Annual Leave"),
		R  ("0111", "Request Day"),
		Z1 ("1000", "Unassigned1"),
		Z2 ("1001", "Unassigned2"),
		Z3 ("1010", "Unassigned3"),
		Z4 ("1011", "Unassigned4"),
		Z5 ("1100", "Unassigned5"),
		Z6 ("1101", "Unassigned6"),
		Z7 ("1110", "Unassigned7"),
		DO ("1111", "Day Off");
		private Assignment(String genes, String desc) {
			//			this.gene = new byte[4];
			//			for (int i = 0; i < gene.length(); i++) {
			//				this.gene[i] = (byte) (gene.charAt(i) - '0');
			//			}
			this.genes = genes;
			this.desc = desc;
		}
		//private final byte[] gene;
		private final String genes;
		private final String desc;
		//		public byte[] getGene() {
		//			return this.gene;
		//		}
		public String getGenes() {
			return this.genes;
		}

		public String getDesc() {
			return this.desc;
		}
	}
}
