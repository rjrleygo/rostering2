package mySimpleGA;

import employee.Staff;

public class Population {

	private final Chromosome[] chromosomes;
	private final Staff staff;
	private final String solutionGuide;

	/*
	 * Constructors
	 */
	// Create a population
	// public Population(int size) {
	// this.chromosomes = new Chromosome[size];
	// }

	public Population(int size, Staff staff) {
		// this(size);
		this.chromosomes = new Chromosome[size];
		this.staff = staff;
		this.solutionGuide = staff.getSolutionGuide();

		// Initialise population
		// Loop and create chromosomes
		for (int i = 0; i < this.size(); i++) {
			final Chromosome chromosome = Chromosome.Factory.generate(this.solutionGuide);
			this.save(i, chromosome);
		}
	}

	/* Getters */
	public Chromosome getChromosome(int index) {
		return this.chromosomes[index];
	}

	public Chromosome getFittest() {
		Chromosome fittest = this.chromosomes[0];
		// Loop through chromosomes to find fittest
		for (final Chromosome chromosome : this.chromosomes) {
			if (fittest.getFitness() <= chromosome.getFitness()) {
				fittest = chromosome;
			}
		}
		return fittest;
	}

	/* Public methods */
	public Population evolve() {
		final Population newPopulation = new Population(this.size(), this.staff);

		// Keep our best chromosome
		if (Constants.ELITISM) {
			newPopulation.save(0, this.getFittest());
		}

		// Crossover population
		int elitismOffset;
		if (Constants.ELITISM) {
			elitismOffset = 1;
		} else {
			elitismOffset = 0;
		}
		// Loop over the population size and create new chromosomes with
		// crossover
		for (int i = elitismOffset; i < this.size(); i++) {
			final Chromosome fittest1 = this.runTournament();
			final Chromosome fittest2 = this.runTournament();
			final Chromosome newChromosome = this.crossover(fittest1, fittest2);
			newPopulation.save(i, newChromosome);
		}

		// Mutate population
		for (int i = elitismOffset; i < newPopulation.size(); i++) {
			newPopulation.getChromosome(i).mutate();
		}

		return newPopulation;
	}

	// Crossover chromosomes
	protected Chromosome crossover(Chromosome chromosome1, Chromosome chromosome2) {
		final Chromosome newChromosome = Chromosome.Factory.generate(this.solutionGuide);
		// Loop through genes
		for (int i = 0; i < chromosome1.size(); i++) {
			// Crossover
			if (Math.random() <= Constants.DEFAULT_UNIFORM_RATE) {
				newChromosome.setGene(i, chromosome1.getGene(i));
			} else {
				newChromosome.setGene(i, chromosome2.getGene(i));
			}
		}
		return newChromosome;
	}

	// Select chromosomes for crossover
	protected Chromosome runTournament() {
		// Create a tournament population
		final Population tournament = new Population(Constants.DEFAULT_TOURNAMENT_SIZE, this.staff);
		// For each place in the tournament get a random chromosome
		for (int i = 0; i < Constants.DEFAULT_TOURNAMENT_SIZE; i++) {
			final int randomID = (int) (Math.random() * this.size());
			tournament.save(i, this.getChromosome(randomID));
		}
		// Get the fittest
		final Chromosome fittest = tournament.getFittest();
		return fittest;
	}

	// Get population size
	public int size() {
		return this.chromosomes.length;
	}

	// Save chromosome
	public void save(int index, Chromosome chromosome) {
		this.chromosomes[index] = chromosome;
	}
}
