package pack;

public class Mikrocontroller {
	private char[][] ledDisplay = new char[10][12];
	private String message;

	public Mikrocontroller(String message) {
		this.message = message;
		
		for(int i = 0; i <= message.length() - 7;i+=7 ) {
			translateASCII(message.substring(i, i+7));
			printAnzeige();
		}
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void printAnzeige() {

		for (char[] ledRow : ledDisplay) {
			for (char led : ledRow) {
				System.out.print(led + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private void setAllBitLampsOff() {
		for (int i = 0; i < ledDisplay.length; i++) {
			for (int j = 0; j < ledDisplay[i].length; j++) {
				ledDisplay[i][j] = 'x';
			}
		}
		ledDisplay[0][0] = '1';
		ledDisplay[0][11] = '1';
		ledDisplay[9][0] = '1';
		ledDisplay[9][11] = '1';
	}

	private void translateASCII(String ascii) {
		int teiler;
		char letter;
		int value;

		setAllBitLampsOff();

		StringBuilder newAscii = new StringBuilder(ascii);
		for (int i = 0; i < 8 - ascii.length(); i++) {
			newAscii.append(" ");
		}

		ascii = newAscii.toString();

		for (int i = 0; i < 8; i++) {
			teiler = 128;
			letter = ascii.charAt(i);
			value = (int) letter;

			for (int j = 2; j < 10; j++) {
				if (value / teiler == 1) {
					ledDisplay[i + 1][j] = '1';
					value = value % teiler;
				} else {
					ledDisplay[i + 1][j] = '0';
				}
				teiler /= 2;
			}

		}
	}
}
