import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public record Car(String type, String make, String model, int engineCapacity) {

    public static Map<String, Map<String, Integer>> getGroupedCars(List<Car> cars) {
        return cars.stream().collect(
                Collectors.groupingBy(Car::type, Collectors.toMap(Car::model, Car::engineCapacity))
        );
    }

    public static Function<List<Car>, Map<String, Map<String, Integer>>> getGroupedCars2 = cars -> cars.stream().collect(
            Collectors.groupingBy(Car::type, Collectors.toMap(Car::model, Car::engineCapacity))
    );




}
