public class Product {

    private String date,size,carrier;
    private double price, discount;

    public Product(String date,String size,String carrier){
        this.date = date;
        this.size = size;
        this.carrier = carrier;
    }

    public String getDate(){
        return date;
    }

    public void setDate(){
        this.date = date;
    }

    public String getSize(){
        return size;
    }

    public void setSize(){
        this.size = size;
    }
    public String getCarrier(){
        return carrier;
    }

    public void setCarrier(){
        this.carrier = carrier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return date + " "+ size+ " " + carrier + " " + price + " " + discount;
    }
}