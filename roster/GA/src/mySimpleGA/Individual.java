package mySimpleGA;

public class Individual {
	private final byte[] genes;

	public Individual(int geneLength) {
		this.genes = new byte[geneLength];
	}

	//	private static int defaultGeneLength = 64;

	// Cache
	private int fitness = 0;

	// Create a random individual
	public void generateIndividual() {
		for (int i = 0; i < this.size(); i++) {
			final byte gene = (byte) Math.round(Math.random());
			this.genes[i] = gene;
		}
	}

	/* Getters and setters */
	//	// Use this if you want to create individuals with different gene lengths
	//	public static void setDefaultGeneLength(int length) {
	//		defaultGeneLength = length;
	//	}

	public byte getGene(int index) {
		return this.genes[index];
	}

	public void setGene(int index, byte value) {
		this.genes[index] = value;
		this.fitness = 0;
	}

	/* Public methods */
	public int size() {
		return this.genes.length;
	}

	public int getFitness() {
		if (this.fitness == 0) {
			this.fitness = FitnessCalc.getFitness(this);
		}
		return this.fitness;
	}

	@Override
	public String toString() {
		String geneString = "";
		for (int i = 0; i < this.size(); i++) {
			geneString += this.getGene(i);
		}
		return geneString;
	}
}