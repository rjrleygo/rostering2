package mySimpleGA;

public class Chromosome {
	public static class Factory {
		public static Chromosome generate(int size) {
			final Chromosome chromosome = new Chromosome(size);
			for (int i = 0; i < chromosome.genes.length; i++) {
				final byte gene = (byte) Math.round(Math.random());
				chromosome.genes[i] = gene;
			}
			return chromosome;
		}
	}
	private final byte[] genes;

	private Chromosome(int size) {
		this.genes = new byte[size];
	}

	private int fitness = 0;

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
			this.fitness = FitnessCalculator.getFitness(this);
		}
		return this.fitness;
	}

	public void mutate() {
		// Loop through genes
		for (int i = 0; i < this.size(); i++) {
			if (Math.random() <= Constants.DEFAULT_MUTATION_RATE) {
				// Create random gene
				final byte gene = (byte) Math.round(Math.random());
				this.setGene(i, gene);
			}
		}
	}

	@Override
	public String toString() {
		String geneString = "";
		for (final byte gene : this.genes) {
			geneString += gene;
		}
		return geneString;
	}
}