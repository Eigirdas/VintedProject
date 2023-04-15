import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Product> productArrayList = new ArrayList<>();

        try {
            BufferedReader in = new BufferedReader((new FileReader("C:\\Users\\Eigirtas\\IdeaProjects\\VintedProject\\src\\doc.txt")));
            String line;
            String[] vals;
            while ((line = in.readLine()) != null) {
                vals = line.split(" ");

                // input validation
                if ((vals[1].contains("S") || vals[1].contains("L") || vals[1].contains("M")) && vals[1].length() == 1) {
                    String date = vals[0];
                    String size = vals[1];
                    String carrier = vals[2];
                    Product p = new Product(date, size, carrier);
                    productArrayList.add(p);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ProductManager productManager = new ProductManager(productArrayList);
        productManager.summary();

    }
}

