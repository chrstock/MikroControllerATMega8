package mikroController;

/**
 * Data class for MikroController-Display 
 * @author Christian Stock
 * @version 0.9
 * 
 *
 */
public class MikroController {
	private String message;
	private String[][] ledDisplay = new String[10][12];

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[][] getLedDisplay() {
		return ledDisplay;
	}

	public void setLedDisplay(String[][] ledDisplay) {
		this.ledDisplay = ledDisplay;
	}

	public MikroController(String message) {
		this.message = message;
	}
}
