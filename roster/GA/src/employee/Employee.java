package employee;

import mySimpleGA.Constants.Assignment;

public class Employee {
	private final String name;
	private final double fte;
	private final Assignment[] assignments;
	public Employee(String name, double fte) {
		this.name = name;
		this.fte = fte;
		this.assignments = new Assignment[7];
		for (int i = 0; i < this.assignments.length; i++) {
			this.assignments[i] = null;
		}
	}

	public String getName() {
		return this.name;
	}

	public double getFte() {
		return this.fte;
	}

	public void setAssignment(int i, Assignment assignment) {
		this.assignments[i] = assignment;
	}

	public Assignment[] getAssignments() {
		return this.assignments;
	}

	public String getAssignmentGenes() {
		final StringBuffer buf = new StringBuffer();
		for (final Assignment assignment : this.assignments) {
			if (assignment == null) {
				buf.append("????");
			} else {
				buf.append(assignment.getGenes());
			}
		}
		return buf.toString();
	}
}
