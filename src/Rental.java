class Rental {
    private Car car;
    private Customer customer;
    private int NoOfDays;
    private double totalPrice;

    public Rental(Car car, Customer customer,int NoOfDays ) {
        this.car = car;
        this.customer = customer;
        this.NoOfDays=NoOfDays;

    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getNoOfDays() {
        return NoOfDays;
    }

    public double calculatebill(){
        return NoOfDays*car.getBasePrice();
    }

}

