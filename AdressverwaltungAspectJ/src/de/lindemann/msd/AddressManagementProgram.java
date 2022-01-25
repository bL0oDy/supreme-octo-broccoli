package de.lindemann.msd;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 234575
 * 
 */
public class AddressManagementProgram {

	private static Scanner _scanner = new Scanner(System.in);
	private static AddressManagement _addressManagement = new AddressManagement(_scanner);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AtomicInteger v_choice = new AtomicInteger(0);

		while (v_choice.intValue() != 3) {
			try {
				readUserChoice(v_choice);
				executeUserAction(v_choice);
			} catch (NoSuchElementException v_nseEx) {
				v_nseEx.printStackTrace();
			}
		}
	}

	private static void readUserChoice(AtomicInteger a_choice) {
		a_choice.set(_scanner.nextInt());
	}
	
	private static void executeUserAction(AtomicInteger a_choice) {
		switch (a_choice.intValue()) {
		case 0: {
			_addressManagement.changeAddress();
			break;
		}
		case 1: {
			_addressManagement.showAddress();
			break;
		}
		case 2: {
			_addressManagement.readAddress();
			break;
		}
		}
	}
}
