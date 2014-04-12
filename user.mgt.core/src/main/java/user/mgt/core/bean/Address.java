package user.mgt.core.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import user.mgt.core.Savable;

@Entity
@Table(name = "ADDRESS")
public class Address extends Savable {

	@Column(name = "STREET_ADDRESS")
	private String streetAddress;

	@Column(name = "CITY")
	private String city;

	@Column(name = "POSTAL_CODE")
	private String postalCode;

	@Column(name = "COUNTRY")
	private String country;

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
