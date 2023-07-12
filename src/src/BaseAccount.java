package src;

public abstract class BaseAccount {
	/** 
	 * This class builds the basis for provider and member accounts
	 * 
	 * @author Jack Orear
	 */
	int id;
	String name;
	String address;
	String city;
	String state;
	int zip;
	
	/**
	 * @return id The member/provider id
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * @return name The member/provider name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return String address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}
	
	
	/** 
	 * @return String
	 */
	public String getState() {
		return state;
	}
	
	
	/** 
	 * @return int
	 */
	public int getZip() {
		return zip;
	}
	
	
	/** 
	 * @param newID
	 */
	public void setID(int newID) {
		this.id = newID;
	}
	
	/**
	 * @param newName Sets the name
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
	 * @param newAddress Sets the address
	 */
	public void setAddress(String newAddress) {
		this.address = newAddress;
	}
	
	/**
	 * @param newCity Sets the city
	 */
	public void setCity(String newCity) {
		this.city = newCity;
	}
	
	/**
	 * @param newState Sets the state
	 */
	public void setState(String newState) {
		this.state = newState;
	}
	
	/**
	 * @param newZip Sets the zip
	 */
	public void setZip(int newZip) {
		this.zip = newZip;
	}

}
