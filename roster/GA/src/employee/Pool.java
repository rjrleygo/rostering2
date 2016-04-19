package employee;

import mySimpleGA.Constants.Assignment;

public class Pool {
	private static Pool instance;

	public static Pool getInstance() {
		if (instance == null) {
			instance = new Pool();
		}
		return instance;
	}

	private final Employee[] employees;

	private Pool() {
		this.employees = new Employee[1];
		final Employee employee = new Employee("Employee1", 1);
		employee.setAssignment(5, Assignment.DO);
		employee.setAssignment(6, Assignment.DO);
		this.employees[0] = employee;
	}

	public String getHardConditionsFromAssignments() {
		final StringBuffer solution = new StringBuffer();
		for (final Employee employee : this.employees) {
			solution.append(employee.getAssignmentGenes());
		}
		return solution.toString();
	}
}
