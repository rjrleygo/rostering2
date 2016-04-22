package mySimpleGA;

import employee.Staff;

public class FitnessCalculator {

	public FitnessCalculator(Staff staff) {
		final String hardConditions = staff.getSolutionGuide();
		this.solution = new byte[hardConditions.length()];
		for (int i = 0; i < hardConditions.length(); i++) {
			final String character = hardConditions.substring(i, i + 1);
			if (character.contains("0") || character.contains("1")) {
				this.solution[i] = Byte.parseByte(character);
			} else if (character.contains("?")) {
				this.solution[i] = -1;
			} else {
				this.solution[i] = 0;
			}
		}
	}

	private final byte[] solution;

	// public void setSolution(Pool pool) {
	// solution = new byte[pool.getHardConditions().length()];
	// // Loop through each character of our string and save it in our byte
	// // array
	// for (int i = 0; i < pool.getHardConditions().length(); i++) {
	// final String character = pool.getHardConditions().substring(i, i + 1);
	// if (character.contains("0") || character.contains("1")) {
	// solution[i] = Byte.parseByte(character);
	// } else if (character.contains("?")) {
	// solution[i] = -1;
	// } else {
	// solution[i] = 0;
	// }
	// }
	// }

	// Calculate inidividuals fitness by comparing it to our candidate solution
	public int getFitness(Chromosome individual) {
		int fitness = 0;
		// Loop through our individuals genes and compare them to our cadidates
		for (int i = 0; i < individual.size() && i < this.solution.length; i++) {
			if (individual.getGene(i) == this.solution[i] || this.solution[i] == -1) {
				fitness++;
			}
		}
		return fitness;
	}

	// Get optimum fitness
	public int getMaxFitness() {
		final int maxFitness = this.solution.length;
		return maxFitness;
	}
}
