package hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity 
public class UserDetails {
	@Id 
	@GeneratedValue
	private int id;
	private String name;
	private String pname;
	private Adress address;
	
	@AttributeOverrides(value = {
	@AttributeOverride(name="street", column = @Column(name="OFFICE_STREET")),
	@AttributeOverride(name="city", column = @Column(name="OFFICE_CITY")),
	@AttributeOverride(name="state", column = @Column(name="OFFICE_STATE")),
	@AttributeOverride(name="zipcode", column = @Column(name="OFFICE_ZIPCODE"))
	})
	
	private Adress officeAdress;
	/**
	 * @return the address
	 */
	public Adress getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Adress address) {
		this.address = address;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Adress getOfficeAdress() {
		return officeAdress;
	}
	public void setOfficeAdress(Adress officeAdress) {
		this.officeAdress = officeAdress;
	}

}
