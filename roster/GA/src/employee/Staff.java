package employee;

import mySimpleGA.Constants.Shift;

public class Staff {
	private static Staff instance;

	public static Staff getInstance() {
		if (instance == null) {
			instance = new Staff();
		}
		return instance;
	}

	private final Employee[] employees;

	private Staff() {
		this.employees = new Employee[1];
		final Employee employee = new Employee("Employee1", 1);
		employee.setShift(5, Shift.DO);
		employee.setShift(6, Shift.DO);
		this.employees[0] = employee;
	}

	public String getSolutionGuide() {
		final StringBuffer guide = new StringBuffer();
		for (final Employee employee : this.employees) {
			guide.append(employee.getShiftGuide());
		}
		return guide.toString();
	}
}
