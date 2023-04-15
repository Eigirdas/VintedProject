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
    private double totaldisc =10;
    int LLPcounter = 0;

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

    private void productcost(Product p) {
        System.out.println(totaldisc);
        var dateasstr = p.getDate();
        var coupondate = LocalDate.parse(dateasstr);

        String size = p.getSize();
        String carrier = p.getCarrier();


            if (size.equals("L") && carrier.equals("LP")){
                LLPcounter++;
            }if (LLPcounter==3) {
                System.out.println("LLP COUNTER = "+LLPcounter);
                p.setDiscount(totaldisc=totaldisc-6.9);
                //totaldisc = totaldisc - 6.9;
            }if (size.equals("S") && carrier.equals("MR")) {
                p.setDiscount(totaldisc=totaldisc-0.5);
                //totaldisc = totaldisc - 0.5;
            }



    }

    public void summary(){
        for (Product p: productArrayList){
            System.out.println(p.toString());
            productcost(p);

        }
    }


}
