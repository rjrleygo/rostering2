package employee;

import mySimpleGA.Constants.Shift;

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
		employee.setShift(5, Shift.DO);
		employee.setShift(6, Shift.DO);
		this.employees[0] = employee;
	}

	public String getHardConditionsFromShifts() {
		final StringBuffer solution = new StringBuffer();
		for (final Employee employee : this.employees) {
			solution.append(employee.getShiftGenes());
		}
		return solution.toString();
	}
}
