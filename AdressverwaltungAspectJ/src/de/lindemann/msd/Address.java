package de.lindemann.msd;

public class Address {
	private String m_surName = "Mustermann";
	private String m_firstName = "Max";

	private String m_zip = "31134";
	private String m_streetNumber = "18b";

	private String m_street = "Rathausstrasse";
	private String m_city = "Hildesheim";

	public String getSurName() {
		return this.m_surName;
	}

	public void setSurName(String a_surName) {
		this.m_surName = a_surName;
	}

	public String getFirstName() {
		return this.m_firstName;
	}

	public void setFirstName(String a_firstName) {
		this.m_firstName = a_firstName;
	}

	public String getZip() {
		return this.m_zip;
	}

	public void setZip(String a_zip) {
		this.m_zip = a_zip;
	}

	public String getStreet() {
		return this.m_street;
	}

	public void setStreet(String a_street) {
		this.m_street = a_street;
	}

	public String getStreetNumber() {
		return this.m_streetNumber;
	}

	public void setStreetNumber(String a_streetNumber) {
		this.m_streetNumber = a_streetNumber;
	}

	public String getCity() {
		return this.m_city;
	}

	public void setCity(String a_city) {
		this.m_city = a_city;
	}
}
