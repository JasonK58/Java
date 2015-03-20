package q3;

/**
 * <p>This class sets up address objects and descriptors.</p>
 *
 * @author Jason Kolenosky
 * @version 1.0
 */
public class Address {
    
    /** 
     * <p>Street address.</p>
     */
    private String streetAddress;
    /** 
     * <p>city.</p> 
     */
    private String city;
    /** 
     * <p>Province.</p>
     */
    private String province;
    
    /** 
     * <p>Postal code, any country.</p>
     */
    private String postalCode;

    /**
     * <p>Constructor: Sets up this address with the specified data.</p>
     *
     * @param street Holds new streetAddress
     * @param town Holds new city
     * @param pr Holds new province
     * @param code Holds new postalCode
     */
    public Address(String street, String town, String pr, String code) {
        streetAddress = street;
        city = town;
        province = pr;
        postalCode = code;
    }

    /**
     * <p>Returns a description of the Address object.</p>
     *
     * @return formatted value of address information.
     */
    public String toString() {
        return streetAddress + "\n"
        		+ city + ", " + province + "  " + postalCode;
    }
}
