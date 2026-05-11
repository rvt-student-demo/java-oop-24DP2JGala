package rvt.OnlineShop_9_2;
import java.util.*;

public class Warehouse {
    private HashMap<String, Integer> produktuCenas;
    private HashMap<String, Integer> produktaSkaits;

    public Warehouse() {
        this.produktuCenas = new HashMap<>();
        this.produktaSkaits = new HashMap<>();

    }
    
    public void addProduct(String product, int price, int stock) {
        this.produktuCenas.put(product, price);
        this.produktaSkaits.put(product, stock);

    }

    public int price(String product) {
        return this.produktuCenas.getOrDefault(product, -99);

    }

    public int stock(String product) {
        return this.produktaSkaits.getOrDefault(product, 0);

    }

    public boolean take(String product) {
        if (this.produktaSkaits.containsKey(product)) {

            if (this.produktaSkaits.get(product) - 1 < 0) {
                return false;

            } else {
                this.produktaSkaits.put(product, this.produktaSkaits.get(product) - 1);
                return true;

            }

        } else {
            return false;

        }

    }

    public Set<String> products() {
        return this.produktuCenas.keySet();

    }

}