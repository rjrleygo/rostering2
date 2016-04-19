package mySimpleGA;

import employee.Pool;

public class GA {

	public static void main(String[] args) {

		// Set a candidate solution
		//final String solution = "1111000011110000111100001111";

		//FitnessCalc.setSolution(Pool.getInstance().getHardConditionsFromAssignments());
		FitnessCalc.setSolution(Pool.getInstance());

		// Create an initial population
		Population myPop = new Population(Constants.DEFAULT_POPULATION_SIZE, Pool.getInstance().getHardConditionsFromAssignments().length(), true);

		// Evolve our population until we reach an optimum solution
		int generationCount = 0;
		//while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()) {
		while (myPop.getFittest().getFitness() < Pool.getInstance().getHardConditionsFromAssignments().length()) {
			generationCount++;
			System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness() + ": " + myPop.getFittest());
			myPop = Algorithm.evolvePopulation(myPop);
		}
		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount);
		System.out.println("Genes:");
		System.out.println("Ideal: " + Pool.getInstance().getHardConditionsFromAssignments().toString());
		System.out.println("Solution: " + myPop.getFittest());

	}
}