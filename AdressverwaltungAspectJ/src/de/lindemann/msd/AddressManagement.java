package de.lindemann.msd;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressManagement {

	@SuppressWarnings("rawtypes")
	private ArrayList[] m_addressStorage;
	private Address m_activeAddress;

	private Scanner m_sc;

	public AddressManagement(Scanner a_scanner) {
		this.m_sc = a_scanner;
		this.fillAddressStorage();
		this.m_activeAddress = (Address) this.m_addressStorage[0].get(0);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void fillAddressStorage() {
		this.m_addressStorage = new ArrayList[10];

		int[] v_amountPerIndex = new int[10];
		v_amountPerIndex[0] = 3;
		v_amountPerIndex[1] = 3;
		v_amountPerIndex[2] = 3;
		v_amountPerIndex[3] = 3;
		v_amountPerIndex[4] = 3;
		v_amountPerIndex[5] = 4;
		v_amountPerIndex[6] = 5;
		v_amountPerIndex[7] = 6;
		v_amountPerIndex[8] = 5;
		v_amountPerIndex[9] = 4;

		for (int i = 0; i < 10; i++) {
			this.m_addressStorage[i] = new ArrayList();
			for (int j = 0; j < v_amountPerIndex[i]; j++) {
				this.m_addressStorage[i].add(new Address());
			}
		}
	}

	private int getAddressStorageLength() {
		int v_result = 0;

		for (@SuppressWarnings("rawtypes")
		ArrayList v_ar : this.m_addressStorage) {
			v_result += v_ar.size();
		}

		return v_result;
	}

	public void changeAddress() {
		System.out.print("Adresse wählen (1 bis "
				+ Integer.toString(this.getAddressStorageLength()) + ") : ");
		int v_newAddressIndex = this.m_sc.nextInt() - 1;

		if (v_newAddressIndex < this.getAddressStorageLength()) {
			for (@SuppressWarnings("rawtypes")
			ArrayList v_ar : this.m_addressStorage) {
				if (v_newAddressIndex < v_ar.size()) {
					this.m_activeAddress = (Address) v_ar
							.get(v_newAddressIndex);
					break;
				} else {
					v_newAddressIndex -= v_ar.size();
				}
			}
		} else {
			System.out.println("Element nicht gefunden");
		}

	}

	public void showAddress() {
		System.out.print("Name : ");
		System.out.print(this.m_activeAddress.getFirstName());
		System.out.print(" ");
		System.out.println(this.m_activeAddress.getSurName());
		System.out.print("Adresse : ");
		System.out.print(this.m_activeAddress.getStreet());
		System.out.print(" ");
		System.out.println(this.m_activeAddress.getStreetNumber());
		System.out.print(this.m_activeAddress.getZip());
		System.out.print(" ");
		System.out.println(this.m_activeAddress.getCity());
	}

	public void readAddress() {
		System.out.println("Bitte Vornamen eingeben : ");
		this.m_activeAddress.setFirstName(this.m_sc.next());
		System.out.println("Bitte Nachnamen eingeben : ");
		this.m_activeAddress.setSurName(this.m_sc.next());
		System.out.println("Bitte Strasse eingeben : ");
		this.m_activeAddress.setStreet(this.m_sc.next());
		System.out.println("Bitte Hausnummer eingeben : ");
		this.m_activeAddress.setStreetNumber(this.m_sc.next());
		System.out.println("Bitte Postleitzahl eingeben : ");
		this.m_activeAddress.setZip(this.m_sc.next());
		System.out.println("Bitte Ort eingeben : ");
		this.m_activeAddress.setCity(this.m_sc.next());
	}
}
