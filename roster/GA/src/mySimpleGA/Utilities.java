package mySimpleGA;

public class Utilities {
	public static byte[] toByteArray(String string) {
		final byte[] array = new byte[string.length()];
		for (int i = 0; i < string.length(); i++) {
			final String character = string.substring(i, i + 1);
			if (character.contains("0") || character.contains("1")) {
				array[i] = Byte.parseByte(character);
			} else if (character.contains("?")) {
				array[i] = -1;
			} else {
				array[i] = 0;
			}
		}
		return array;
	}
}
