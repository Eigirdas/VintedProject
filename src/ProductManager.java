import java.time.LocalDate;
import java.util.*;


/*
All S shipments should always match the lowest S package price among the providers.
The third L shipment via LP should be free, but only once a calendar month.
Accumulated discounts cannot exceed 10 € in a calendar month.
If there are not enough funds to fully cover a discount this calendar month, it should be covered partially.
*/


public class ProductManager {
    private ArrayList<Product> productArrayList;
    private HashMap<String, Double> prices = new HashMap<>();

    private int LPLTracker = 0;
    private HashMap<Integer,Double> discountTracker = new HashMap<>();
    private HashMap<Integer,Boolean> lplTracker = new HashMap<>();
    private LocalDate currentDate;
    public ProductManager(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
        setPrices();
        calculateDiscounts();
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
        for (Product p: productArrayList){
            LocalDate date = LocalDate.parse(p.getDate());
            discountTracker.put(date.getMonthValue(), 10.0);
        }
        for (Product p: productArrayList){
            LocalDate date = LocalDate.parse(p.getDate());
            lplTracker.put(date.getMonthValue(), true);
        }
    }

    private boolean isSmallShipment(Product p){
        if (p.getSize().equals("S")){
            return true;
        }
        return false;
    }

    private boolean isAvailableFreeShipment(LocalDate currentDate){
        boolean isAvailable = lplTracker.get(currentDate.getMonthValue());
        if (isAvailable){
            return true;
        }
        return false;
    }

    private boolean isFreeShipment(Product p, LocalDate currentDate){
        String cur = p.getCarrier()+p.getSize();
        if (isAvailableFreeShipment(currentDate)){
            if (cur.equals("LPL")){
                LPLTracker++;
                return true;
            }if (LPLTracker==3){
                LPLTracker=0;
                return true;
            }
        }
        return false;
    }

    private boolean canApplyDiscount(LocalDate currentDate, double discount){
        int cur = currentDate.getMonthValue();
        if ( (discountTracker.get(cur) - discount) > 0){
            discountTracker.put(cur, discountTracker.get(cur) - discount);
            return true;
        }
        return false;
    }

    private void calculateDiscounts(){
        for (Product p: productArrayList){
            this.currentDate = LocalDate.parse(p.getDate());
            if (isSmallShipment(p)){
                if (canApplyDiscount(currentDate, prices.get("LPS"))){
                    p.setDiscount(p.getPrice()-prices.get("LPS"));
                    p.setPrice(p.getPrice()-p.getDiscount());
                }
            }
            if (isFreeShipment(p, currentDate)){
                if (canApplyDiscount(currentDate, p.getPrice())){
                    p.setDiscount(p.getPrice());
                    p.setPrice(p.getPrice()-p.getDiscount());
                }
            }
        }
    }

    public void summary(){
        for (Product p: productArrayList){
            System.out.println(p.toString());
        }
    }


}
