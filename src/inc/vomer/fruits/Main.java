package inc.vomer.fruits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Enter fruit and price in the form: Apple:50");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        HashMap<Double, String> data = new HashMap<>();
        ArrayList<Double> priceList = new ArrayList<>();
        do {
            try {
                String input = bufferedReader.readLine();
                //Lets split input to price and fruit name
                String[] splitInput = input.split(":");
                String fruitName = splitInput[0];
                double price = Double.parseDouble(splitInput[1]);
                data.put(price, fruitName);
                priceList.add(price);
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
        while (i < 2);
        priceList.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if (o1 > o2) return -1;
                else if (o2 < o1) return 1;
                else return 0;
            }
        });

        System.out.println("The most expensive fruit is: " + data.get(priceList.get(0)) + " price: " + priceList.get(0));

    }
}
