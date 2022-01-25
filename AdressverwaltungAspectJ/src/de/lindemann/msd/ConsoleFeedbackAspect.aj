package de.lindemann.msd;

import java.util.concurrent.atomic.AtomicInteger;

public aspect ConsoleFeedbackAspect {
	pointcut userDataEntry(AtomicInteger a_choice) : call(void AddressManagementProgram.readUserChoice(AtomicInteger)) && args(a_choice);
	pointcut userAction() : execution(* AddressManagementProgram.executeUserAction(..));
	
	before() : userDataEntry(AtomicInteger) {
		System.out.println("Menü");
		System.out.println("0 - Adresse wechseln");
		System.out.println("1 - Adresse anzeigen");
		System.out.println("2 - Adresse überschreiben");
		System.out.println("3 - Beenden");
		System.out.print("Auswahl:");
	}
	
	after(AtomicInteger a_choice) returning() : userDataEntry(a_choice) {
		System.out.println("Eingabe: " + a_choice.toString());
	}
	
	after() returning() : userAction() {
		System.out.println("Benutzeraktion abgeschlossen.");
		System.out.println();
		System.out.println();
	}
}
