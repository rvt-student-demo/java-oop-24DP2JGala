package rvt.IOU_8_2;
import java.util.*;

public class IOU {  
    private HashMap<String, Double> debtors;

    public IOU() {
        this.debtors = new HashMap<>();

    }

    public void setSum(String toWhom, double amount) {
        debtors.put(toWhom, amount);

    }

    public double howMuchDoIOweTo(String toWhom) {
        return debtors.getOrDefault(toWhom, 0.0);

    }

}