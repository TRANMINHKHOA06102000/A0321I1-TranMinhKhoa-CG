package b5_accessmodifier_staticmethod_staticproperty.thuchanh.staticproperty;

public class Car {
    private String name;

    private String engine;

    public static int numberOfCars;

    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCars++;
    }
    // getters and setters
}
