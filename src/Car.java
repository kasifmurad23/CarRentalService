 class Car {
    private   String Carid;
    private String Model;
    private String Brand;
    private double  BasePrice;
    private boolean isAvailable=true;

     public Car(String carid, String model, String brand, double basePrice) {
         Carid = carid;
         Model = model;
         Brand = brand;
         BasePrice = basePrice;
         isAvailable = true;

     }
     public String getCarid() {
         return Carid;
     }

     public String getModel() {
         return Model;
     }

     public String getBrand() {
         return Brand;
     }

     public double getBasePrice() {
         return BasePrice;
     }

     public boolean isAvailable() {
         return isAvailable;
     }
     public void rent() {
         isAvailable = false;
     }

     public void returnCar() {
         isAvailable = true;
     }
     public double CalculatePrice(int NoOfDays){
         return getBasePrice()*NoOfDays;
     }
 }
