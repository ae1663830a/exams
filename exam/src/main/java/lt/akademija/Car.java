package lt.akademija;

import com.eisgroup.javaexam.factory.Color;
import com.eisgroup.javaexam.factory.Transportation;

public class Car extends Transportation {
    Car(String make, String model, double price, Color color) {
        super(make, model, price, color);
    }

    @Override
    public double getFinalPrice() {
        double withTax = 1.21;
        return getPrice() * withTax;
    }
}
