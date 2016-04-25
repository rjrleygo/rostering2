package mySimpleGA;

import employee.Staff;

public class FitnessCalculator {

	public FitnessCalculator(Staff staff) {
		final String solutionGuide = staff.getSolutionGuide();
		this.solutionGuide = new byte[solutionGuide.length()];
		for (int i = 0; i < solutionGuide.length(); i++) {
			final String character = solutionGuide.substring(i, i + 1);
			if (character.contains("0") || character.contains("1")) {
				this.solutionGuide[i] = Byte.parseByte(character);
			} else if (character.contains("?")) {
				this.solutionGuide[i] = -1;
			} else {
				this.solutionGuide[i] = 0;
			}
		}
	}

	private final byte[] solutionGuide;

	// Calculate inidividuals fitness by comparing it to our candidate solution
	public int getFitness(Chromosome chromosome) {
		int fitness = 0;
		// Loop through our individuals genes and compare them to our cadidates
		for (int i = 0; (i < chromosome.size()) && (i < this.solutionGuide.length); i++) {
			if ((chromosome.getGene(i) == this.solutionGuide[i]) || (this.solutionGuide[i] == -1)) {
				fitness++;
			}
		}
		return fitness;
	}

	// Get optimum fitness
	public int getMaxFitness() {
		final int maxFitness = this.solutionGuide.length;
		return maxFitness;
	}
}
