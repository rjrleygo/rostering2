package mySimpleGA;

import java.util.Arrays;

import employee.Staff;
import mySimpleGA.Constants.Shift;

public class FitnessCalculator {

	//private final byte[] solutionGuide;
	private final String solutionGuide;

	public FitnessCalculator(Staff staff) {
		this.solutionGuide = staff.getSolutionGuide();
		//		final String solutionGuide = staff.getSolutionGuide();
		//		this.solutionGuide = new byte[solutionGuide.length()];
		//		for (int i = 0; i < solutionGuide.length(); i++) {
		//			final String character = solutionGuide.substring(i, i + 1);
		//			if (character.contains("0") || character.contains("1")) {
		//				this.solutionGuide[i] = Byte.parseByte(character);
		//			} else if (character.contains("?")) {
		//				this.solutionGuide[i] = -1;
		//			} else {
		//				this.solutionGuide[i] = 0;
		//			}
		//		}
	}


	// Calculate inidividuals fitness by comparing it to our candidate solution
	public int getFitness(Chromosome chromosome) {
		int fitness = 0;
		//		// Loop through our individuals genes and compare them to our cadidates
		//		for (int i = 0; (i < chromosome.size()) && (i < this.solutionGuide.length); i++) {
		//			if ((chromosome.getGene(i) == this.solutionGuide[i]) || (this.solutionGuide[i] == -1)) {
		//				fitness++;
		//			}
		//		}
		int index = 0;
		while (index < this.solutionGuide.length()) {
			final Shift guide = Shift.getByCode(this.solutionGuide.substring(index, index + Constants.DEFAULT_SHIFT_CODE_LENGTH));
			if (guide == null) {
				throw new RuntimeException("Unable to identify shift for code: " + this.solutionGuide.substring(index, index + Constants.DEFAULT_SHIFT_CODE_LENGTH));
			} else {
				final Shift generated = Shift.getByCode(Arrays.copyOfRange(chromosome.getGenes(), index, (index + Constants.DEFAULT_SHIFT_CODE_LENGTH)));
				if (Shift.UNKNOWN.equals(guide)) {

				} else if (guide.equals(generated) == false){
					fitness++;
				}
			}
			index += Constants.DEFAULT_SHIFT_CODE_LENGTH;
		}
		return fitness;
	}

	// Get acceptable fitness
	public int getAcceptableFitness() {
		//		final int maxFitness = this.solutionGuide.length();
		//		return maxFitness;
		return 0;
	}
}
