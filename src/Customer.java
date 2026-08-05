class Customer {
    private String CustomerId;
    private String Name;
    private String PhoneNo;
    private String Email;
    private String Address;
    private String DrivingLicense;


    public Customer(String customerId, String name, String phoneNo, String email, String address, String drivingLicense) {
        CustomerId = customerId;
        Name = name;
        PhoneNo = phoneNo;
        Email = email;
        Address = address;
        DrivingLicense = drivingLicense;
    }
    public String getCustomerId() {
        return CustomerId;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public String getDrivingLicense() {
        return DrivingLicense;
    }

}