//package mySimpleGA;
//
//public class Algorithm {
//
//	/* GA parameters */
//
//	/* Public methods */
//
//	// Evolve a population
//	public static Population evolvePopulation(Population pop) {
//		final Population newPopulation = new Population(pop.size(), pop.getGenesLength(), false);
//
//		// Keep our best individual
//		if (Constants.ELITISM) {
//			newPopulation.saveIndividual(0, pop.getFittest());
//		}
//
//		// Crossover population
//		int elitismOffset;
//		if (Constants.ELITISM) {
//			elitismOffset = 1;
//		} else {
//			elitismOffset = 0;
//		}
//		// Loop over the population size and create new individuals with
//		// crossover
//		for (int i = elitismOffset; i < pop.size(); i++) {
//			final Chromosome indiv1 = tournamentSelection(pop);
//			final Chromosome indiv2 = tournamentSelection(pop);
//			final Chromosome newIndiv = crossover(indiv1, indiv2);
//			newPopulation.saveIndividual(i, newIndiv);
//		}
//
//		// Mutate population
//		for (int i = elitismOffset; i < newPopulation.size(); i++) {
//			mutate(newPopulation.getIndividual(i));
//		}
//
//		return newPopulation;
//	}
//
//	// Crossover individuals
//	private static Chromosome crossover(Chromosome indiv1, Chromosome indiv2) {
//		final Chromosome newSol = Chromosome.Factory.generate(indiv1.size());
//		// Loop through genes
//		for (int i = 0; i < indiv1.size(); i++) {
//			// Crossover
//			if (Math.random() <= Constants.DEFAULT_UNIFORM_RATE) {
//				newSol.setGene(i, indiv1.getGene(i));
//			} else {
//				newSol.setGene(i, indiv2.getGene(i));
//			}
//		}
//		return newSol;
//	}
//
//	// Mutate an individual
//	private static void mutate(Chromosome indiv) {
//		// Loop through genes
//		for (int i = 0; i < indiv.size(); i++) {
//			if (Math.random() <= Constants.DEFAULT_MUTATION_RATE) {
//				// Create random gene
//				final byte gene = (byte) Math.round(Math.random());
//				indiv.setGene(i, gene);
//			}
//		}
//	}
//
//	// Select individuals for crossover
//	private static Chromosome tournamentSelection(Population pop) {
//		// Create a tournament population
//		final Population tournament = new Population(Constants.DEFAULT_TOURNAMENT_SIZE, pop.getGenesLength(), false);
//		// For each place in the tournament get a random individual
//		for (int i = 0; i < Constants.DEFAULT_TOURNAMENT_SIZE; i++) {
//			final int randomId = (int) (Math.random() * pop.size());
//			tournament.saveIndividual(i, pop.getIndividual(randomId));
//		}
//		// Get the fittest
//		final Chromosome fittest = tournament.getFittest();
//		return fittest;
//	}
//}