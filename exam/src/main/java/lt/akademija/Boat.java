package lt.akademija;

import com.eisgroup.javaexam.factory.Color;
import com.eisgroup.javaexam.factory.Transportation;

public class Boat extends Transportation {
    private double length;

     Boat(String make, String model, double price, Color color, double length) {
        super(make, model, price, color);
        this.length = length;
    }

    @Override
    public double getFinalPrice() {
        return getPrice()* 1.21;
    }

    @Override
    public String getMake() {
        return super.getMake();
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }

    public double getLength() {
        return length;
    }
}
