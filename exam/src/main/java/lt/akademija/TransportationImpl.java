package lt.akademija;

import com.eisgroup.javaexam.factory.Color;
import com.eisgroup.javaexam.factory.Transportation;
import com.eisgroup.javaexam.factory.TransportationFactory;

public class TransportationImpl implements TransportationFactory {

    @Override
    public Transportation produceCar(String s, String s1, double v, Color color) {
        return new Car(s, s1, v, color);
    }

    @Override
    public Transportation produceBoat(String s, String s1, double v, Color color, double v1) {
        return new Boat(s, s1, v, color, v1);
    }
}
