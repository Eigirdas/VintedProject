import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


/*
All S shipments should always match the lowest S package price among the providers.
The third L shipment via LP should be free, but only once a calendar month.
Accumulated discounts cannot exceed 10 € in a calendar month.
If there are not enough funds to fully cover a discount this calendar month, it should be covered partially.
*/


public class ProductManager {
    private ArrayList<Product> productArrayList;
    private HashMap<String, Double> prices = new HashMap<>();
    private HashMap<LocalDate, Double> discounts = new HashMap<>();
    public ProductManager(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;

        setPrices();
    }
    private void setPrices(){
        prices.put("LPS", 1.50);
        prices.put("LPM", 4.90);
        prices.put("LPL", 6.90);
        prices.put("MRS", 2.0);
        prices.put("MRM", 3.0);
        prices.put("MRL", 4.0);
        for (Product p : productArrayList){
            String cur = p.getCarrier() + p.getSize();
            p.setPrice(prices.get(cur));
        }
    }



        // check the ammount of data has the same year ->
        // if it's the same year, continue to check if it's the same month
        // if it's the same month apply a 5% discount, check the days
        // if it's different month apply 10% discount

//    private void calcdisc(Product p){
//        var dateAsString = p.getDate();
//        var couponDate = LocalDate.parse(dateAsString);
//        var currentDate = LocalDate.now();
//
//        if (couponDate.getMonth() == currentDate.getMonth()) {
//
//        } else if (couponDate.getYear() == currentDate.getYear()) {
//
//        } else if (couponDate.getDayOfMonth() == currentDate.getDayOfMonth()) {
//
//        }
//    }


    private void isFreeShipment(Product p){
        double lptotal = 0;

        String size = p.getSize();
        String carrier = p.getCarrier();
        LocalDate date = LocalDate.parse(p.getDate());
        double discount = p.getDiscount();
        double price = p.getPrice();

//        if (size != "L" || carrier != "LP"){
//            return false;
//        } else if (size) {
//
//        }
//
//        return false;
        for(int i = 0;i<)

    }

    public void summary(){
        for (Product p: productArrayList){
            System.out.println(p.toString());
        }
    }


}
