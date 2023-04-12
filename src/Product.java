import java.util.ArrayList;

public class Product {

    static ArrayList<Product> productArrayList = new ArrayList<>();

    private String date,size,carrier;
    private int price;

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

}