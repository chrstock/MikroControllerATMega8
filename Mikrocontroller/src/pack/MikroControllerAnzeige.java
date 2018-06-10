package pack;

public class MikroControllerAnzeige {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] array = new char[10][12];

		array = translateASCII("HELLO");

		printAnzeige(array);

	}

	private static void printAnzeige(char[][] array) {

		for (char[] letterListe : array) {
			for (char letter : letterListe) {
				System.out.print((letter == ' ' ? 'x' : letter) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void setAllBitLampsOff(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = 'x';
			}
		}

		array[0][0] = '1';
		array[0][11] = '1';
		array[9][0] = '1';
		array[9][11] = '1';
	}

	private static char[][] translateASCII(String ascii) {
		int teiler;
		char letter;
		int value;
		char[][] array = new char[10][12];

		setAllBitLampsOff(array);

		StringBuilder newAscii = new StringBuilder(ascii);
		for (int i = 0; i < 8 - ascii.length(); i++) {
			newAscii.append(" ");
		}

		ascii = newAscii.toString();

		for (int i = 0; i < 8; i++) {
			teiler = 128;
			letter = ascii.charAt(i);
			value = (int) letter;

			for (int j = 2; j < 9; j++) {
				if (value / teiler == 1) {
					array[i + 1][j] = '0';
					value = value % teiler;
				} else {
					array[i + 1][j] = '1';
				}
				teiler /= 2;
			}

		}
		return array;
	}

}
