import java.util.ArrayList;
import java.util.HashMap;

public class Calculator {

    private HashMap<Double, Integer> physicalChange;

    public HashMap<Double, Integer> getChange(double change) {

        physicalChange = new HashMap<>();
        ArrayList<Double> values = createListOfCashValues();

        for (int i = 0; i < values.size(); i++) {

            int count = (int) (change / values.get(i));
            if (count != 0 && change != 0) {
                physicalChange.put(values.get(i), count);
                change = change - (values.get(i) * count);
                change = Math.round(change * 100.0) / 100.0;
            }
        }

        return physicalChange;
    }

    private ArrayList<Double> createListOfCashValues() {
        ArrayList<Double> values = new ArrayList<>();
        values.add(100.0);
        values.add(50.0);
        values.add(20.0);
        values.add(10.0);
        values.add(5.0);
        values.add(2.0);
        values.add(1.0);
        values.add(0.50);
        values.add(0.20);
        values.add(0.10);
        values.add(0.05);
        values.add(0.02);
        values.add(0.01);

        return values;
    }


}
