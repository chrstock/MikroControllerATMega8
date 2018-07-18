package pack;

/**
<<<<<<< HEAD
 * Class to calculate Mikrocontroller - Image
=======
 * Blub blub blub
>>>>>>> refs/heads/develop
 * 
 * @author chrstock
 *
 */
public class Mikrocontroller {
  private char[][] ledDisplay = new char[10][12];

  private String message;

  public Mikrocontroller(String message) {

    this.message = message;
<<<<<<< HEAD
    //test message
    for (int i = 0; i <= message.length() - 7; i += 7) {
      translateASCII(message.substring(i, i + 7));
      printAnzeige();
    }
  }
=======
>>>>>>> refs/heads/develop

<<<<<<< HEAD
  public void setMessage(String message) {
=======
    for (int i = 0; i <= message.length() - 7; i += 7) {
      translateASCII(message.substring(i, i + 7));
      printAnzeige();
    }
  }
>>>>>>> refs/heads/develop

<<<<<<< HEAD
    this.message = message;
  }
=======
  public void setMessage(String message) {
>>>>>>> refs/heads/develop

<<<<<<< HEAD
  public String getMessage() {
=======
    this.message = message;
  }
>>>>>>> refs/heads/develop

<<<<<<< HEAD
    return this.message;
  }
=======
  public String getMessage() {
>>>>>>> refs/heads/develop

<<<<<<< HEAD
  public void printAnzeige() {
=======
    return this.message;
  }
>>>>>>> refs/heads/develop

<<<<<<< HEAD
    for (char[] ledRow : this.ledDisplay) {
      for (char led : ledRow) {
        System.out.print(led + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
=======
  public void printAnzeige() {
>>>>>>> refs/heads/develop

<<<<<<< HEAD
  private void setAllBitLampsOff() {
=======
    for (char[] ledRow : this.ledDisplay) {
      for (char led : ledRow) {
        System.out.print(led + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
>>>>>>> refs/heads/develop

<<<<<<< HEAD
=======
  private void setAllBitLampsOff() {

>>>>>>> refs/heads/develop
    for (int i = 0; i < this.ledDisplay.length; i++) {
      for (int j = 0; j < this.ledDisplay[i].length; j++) {
        this.ledDisplay[i][j] = 'x';
      }
    }
    this.ledDisplay[0][0] = '1';
    this.ledDisplay[0][11] = '1';
    this.ledDisplay[9][0] = '1';
    this.ledDisplay[9][11] = '1';
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
          this.ledDisplay[i + 1][j] = '1';
          value = value % teiler;
        } else {
          this.ledDisplay[i + 1][j] = '0';
        }
        teiler /= 2;
      }

    }
  }
}
