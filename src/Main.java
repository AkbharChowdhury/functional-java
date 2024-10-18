import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Car> carList = getCars();
        var carMakeModelList = carList.stream().flatMap(car -> Stream.of(car.make(), car.model())).toList();
        System.out.println(carMakeModelList);

    }

    static List<Car> getCars() {
        List<Car> carList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/csv/cars.csv"))) {
            String line;
            var COMMA_DELIMITER = ",";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                if (values[0].contains("type")) continue;
                carList.add(new Car(values[0], values[1], values[2], Integer.parseInt(values[3])));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return carList;
    }

//    void car() {
//        List<Car> cars = List.of(
//                new Car("sedan", "BMW", "530", 1998),
//                new Car("sedan", "AUDI", "A5", 1998),
//                new Car("sedan", "Mercedes", "E-CLass", 2500),
//                new Car("hatchback", "Skoda", "Octavia", 1600),
//                new Car("hatchback", "Toyota", "TypeR", 1450)
//
//        );
//        var carMakeModelList = cars.stream().flatMap(car -> Stream.of(car.make(), car.model())).toList();
//        System.out.println(carMakeModelList);
//
//
//    }




}