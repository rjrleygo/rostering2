package mySimpleGA;

import employee.Staff;
import mySimpleGA.Constants.Shift;

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

		public static Chromosome generate(String solutionGuide) {
			if ((solutionGuide.length() % Constants.DEFAULT_SHIFT_CODE_LENGTH) != 0) {
				throw new RuntimeException("Solution guide is not divisible by " + Constants.DEFAULT_SHIFT_CODE_LENGTH);
			}

			int index = 0;
			final StringBuffer buf = new StringBuffer();
			while (index < solutionGuide.length()) {
				final String code = solutionGuide.substring(index, index + Constants.DEFAULT_SHIFT_CODE_LENGTH);
				final Shift shift = Shift.getByCode(code);
				if (shift == null) {
					throw new RuntimeException("Unable to identify shift for code: " + code);
				}
				if (Shift.UNKNOWN.equals(shift)) {
					buf.append(Shift.getRandomShift().getCode());
				} else {
					buf.append(shift.getCode());
				}
				index += Constants.DEFAULT_SHIFT_CODE_LENGTH;
			}

			final Chromosome chromosome = new Chromosome(solutionGuide.length());
			final byte[] array = Utilities.toByteArray(buf.toString());
			for (int i = 0; i < array.length; i++) {
				chromosome.genes[i] = array[i];
			}
			//			for (int i = 0; i < chromosome.genes.length; i++) {
			//				final byte gene = (byte) Math.round(Math.random());
			//				chromosome.genes[i] = gene;
			//			}
			return chromosome;
		}
	}

	private final byte[] genes;

	private Chromosome(int size) {
		this.genes = new byte[size];
	}

	private int fitness = Constants.DEFAULT_FITNESS;


	public byte[] getGenes() {
		return this.genes;
	}

	public byte getGene(int index) {
		return this.genes[index];
	}

	public void setGene(int index, byte value) {
		this.genes[index] = value;
		this.fitness = Constants.DEFAULT_FITNESS;
	}

	/* Public methods */
	public int size() {
		return this.genes.length;
	}

	public int getFitness() {
		if (this.fitness == Constants.DEFAULT_FITNESS) {
			final FitnessCalculator fitnessFunction = new FitnessCalculator(Staff.getInstance());
			this.fitness = fitnessFunction.getFitness(this);
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