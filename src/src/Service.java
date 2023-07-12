package src;


/**
 * Author: Marisa Gibbons
 * 
 * This class instantiates a service object.
 * Services are recorded to provider and member accounts.
 * They also make up the Provider Directory.
 */
public class Service {
	
	/**
	 * serviceName contains the name of the service as a String.
	 * serviceCode contains the service code as an int.
	 * serviceFee contains the service fee as an int.
	 */
    String serviceName;
    int serviceCode;
    int serviceFee;

    /**
     * Creates a new Service with default values.
     */
    public Service() {
        serviceName = "";
        serviceCode = 0;
        serviceFee = 0;
    }

    /**
     * Creates a new Service with the given name, service code, and service fee.
     * @param serviceName : This service's name.
     * @param serviceCode : This service's service code.
     * @param serviceFee : This service's service fee.
     */
    public Service(String serviceName, int serviceCode, int serviceFee) {
        this.serviceName = serviceName;
        this.serviceCode = serviceCode;
        this.serviceFee = serviceFee;
    }

    
    /** 
     * Gets the name of the Service as a String.
     * @return String : The name of the service.
     */
    public String getServiceName() {
        return serviceName;
    }

    
    /** 
     * Gets the service code of the Service as an int.
     * @return int : The service code of the service.
     */
    public int getServiceCode() {
        return serviceCode;
    }

    
    /** 
     * Gets the service fee of the Service as an int.
     * @return int : The service fee of the service.
     */
    public int getServiceFee() {
        return serviceFee;
    }

    
    /** 
     * Sets the name of the Service.
     * @param serviceName : The name of the Service as a String.
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    
    /** 
     * Sets the service code of the Service.
     * @param serviceCode : The service code of the Service as an int.
     */
    public void setServiceCode(int serviceCode) {
        this.serviceCode = serviceCode;
    }

    
    /** 
     * Sets the service fee of the Service.
     * @param serviceFee " The service fee of the Service as an int.
     */
    public void setServiceFee(int serviceFee) {
        this.serviceFee = serviceFee;
    }
}
