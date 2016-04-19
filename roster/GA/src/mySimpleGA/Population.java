package mySimpleGA;

public class Population {

	Individual[] individuals;
	private final int geneSize;
	/*
	 * Constructors
	 */
	// Create a population
	public Population(int populationSize, int geneSize, boolean initialise) {
		this.geneSize = geneSize;
		this.individuals = new Individual[populationSize];
		// Initialise population
		if (initialise) {
			// Loop and create individuals
			for (int i = 0; i < this.size(); i++) {
				final Individual newIndividual = new Individual(geneSize);
				newIndividual.generateIndividual();
				this.saveIndividual(i, newIndividual);
			}
		}
	}

	/* Getters */
	public Individual getIndividual(int index) {
		return this.individuals[index];
	}

	public Individual getFittest() {
		Individual fittest = this.individuals[0];
		// Loop through individuals to find fittest
		for (int i = 0; i < this.size(); i++) {
			if (fittest.getFitness() <= this.getIndividual(i).getFitness()) {
				fittest = this.getIndividual(i);
			}
		}
		return fittest;
	}

	/* Public methods */
	// Get population size
	public int size() {
		return this.individuals.length;
	}

	public int getGeneSize() {
		return this.geneSize;
	}

	// Save individual
	public void saveIndividual(int index, Individual indiv) {
		this.individuals[index] = indiv;
	}
}
