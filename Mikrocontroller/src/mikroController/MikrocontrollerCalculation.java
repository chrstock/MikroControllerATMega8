package mikroController;

/**
 * Class to calculate Mikrocontroller - Image
 *
 * @author Christian Stock
 * @version 0.9
 *
 */
public class MikrocontrollerCalculation {
	private String[][] ledDisplay = new String[10][12];

	public void printDisplayMessage(String message) {
		MikroController mikroController = new MikroController(message);
		for (int i = 0; i <= message.length() - 7; i += 7) {
			translateASCII(message.substring(i, i + 7));
			printAnzeige();
		}
		mikroController.setLedDisplay(ledDisplay);
	}

	private void printAnzeige() {

		for (String[] ledRow : ledDisplay) {
			for (String led : ledRow) {
				System.out.print(led + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private void setAllBitLampsOff() {

		for (int i = 0; i < this.ledDisplay.length; i++) {
			for (int j = 0; j < this.ledDisplay[i].length; j++) {
				this.ledDisplay[i][j] = "x";
			}
		}
		this.ledDisplay[0][0] = "1";
		this.ledDisplay[0][11] = "1";
		this.ledDisplay[9][0] = "1";
		this.ledDisplay[9][11] = "1";
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
			value = letter;

			for (int j = 2; j < 10; j++) {
				if (value / teiler == 1) {
					this.ledDisplay[i + 1][j] = "1";
					value = value % teiler;
				} else {
					this.ledDisplay[i + 1][j] = "0";
				}
				teiler /= 2;
			}

		}
	}
}
