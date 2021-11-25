package task2.cars;

public class Car {
    private String name;
    private int releaseYear;
    private final String className = this.getClass().getSimpleName();
    private Driver driver;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }

    public void start() {
        System.out.println("Driver " + driver.getFirstName() + " started work on " + className + " " + name);
    }

    public void finish() {
        System.out.println("Driver " + driver.getFirstName() + " finished work on " + className + " " + name);
    }

    public Car(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;
        return name.equals(car.name) && releaseYear == (car.releaseYear);
    }
}