package lt.akademija;

import com.eisgroup.javaexam.factory.TransportationFactory;
import com.eisgroup.javaexam.factory.test.BaseTransportationFactoryTest;

public class BaseTransportationTestImpl extends BaseTransportationFactoryTest {

    @Override
    protected TransportationFactory getTransportationFactory() {
        return new TransportationImpl();
    }
}
