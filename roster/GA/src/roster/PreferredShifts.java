package roster;

import java.util.ArrayList;
import java.util.List;

import mySimpleGA.Constants.Shift;

public class PreferredShifts {
	private static PreferredShifts instance = null;

	private PreferredShifts() {
		// initialize
		final List<Shift[]> list = new ArrayList<>();
		final Shift[] array = {Shift.getRandomShift()};
		list.add(array);
	}

	public static PreferredShifts getInstance() {
		if (instance == null) {
			instance = new PreferredShifts();
		}
		return instance;
	}
}
