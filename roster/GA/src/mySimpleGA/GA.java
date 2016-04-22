package mySimpleGA;

import employee.Staff;

public class GA {

	public static void main(String[] args) {

		// Set a candidate solution
		// final String solution = "1111000011110000111100001111";

		final FitnessCalculator fitnessFunction = new FitnessCalculator(Staff.getInstance());
		// FitnessCalculator.setSolution(Pool.getInstance());

		// Create an initial population
		Population population = new Population(Constants.DEFAULT_POPULATION_SIZE, Staff.getInstance());

		// Evolve our population until we reach an optimum solution
		int generationCount = 0;
		while (population.getFittest().getFitness() < fitnessFunction.getMaxFitness()) {
			generationCount++;
			System.out.println("Generation: " + generationCount + " Fittest: " + population.getFittest().getFitness()
					+ ": " + population.getFittest());
			population = population.evolve();
		}
		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount);
		System.out.println("Genes:");
		System.out.println("Ideal: " + Staff.getInstance().getSolutionGuide().toString());
		System.out.println("Solution: " + population.getFittest());

	}
}