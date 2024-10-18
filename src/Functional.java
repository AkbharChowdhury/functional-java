import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Functional {
    public static void main(String[] args) throws IOException {
        var cars = getCarCSVData();
        System.out.println("All cars");
        System.out.println(cars.stream().filter(car -> car.type().equalsIgnoreCase("Hatchback")).toList());
        var carMakeModelList = cars.stream().flatMap(car -> Stream.of(car.make(), car.model())).toList();
        System.out.println(carMakeModelList);

    }


    static List<Car> getCarCSVData() throws IOException {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/csv/cars.csv"))) {
            cars = reader.lines()
                    .map(line -> Arrays.asList(line.split(",")))
                    .skip(1)
                    .map(i -> new Car(i.getFirst(), i.get(1), i.get(2), Integer.parseInt(i.get(3)))).toList();


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return cars;

    }
}
