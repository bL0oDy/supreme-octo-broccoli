import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author 234575
 * 
 */
public class AddressManagementProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner v_sc = new Scanner(System.in);
		AddressManagement v_adm = new AddressManagement(v_sc);

		int v_choice = 0;

		while (v_choice != 3) {
			System.out.println("Menü");
			System.out.println("0 - Adresse wechseln");
			System.out.println("1 - Adresse anzeigen");
			System.out.println("2 - Adresse überschreiben");
			System.out.println("3 - Beenden");

			try {
				System.out.print("Auswahl:");
				v_choice = v_sc.nextInt();

				switch (v_choice) {
				case 0: {
					v_adm.changeAddress();
					break;
				}
				case 1: {
					v_adm.showAddress();
					break;
				}
				case 2: {
					v_adm.readAddress();
					break;
				}
				}
			} catch (NoSuchElementException v_nseEx) {
				v_nseEx.printStackTrace();
			}
		}
	}

}
