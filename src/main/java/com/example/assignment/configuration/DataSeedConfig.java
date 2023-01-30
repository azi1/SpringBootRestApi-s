package com.example.assignment.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.assignment.model.Car;
import com.example.assignment.model.Exterior;
import com.example.assignment.model.Feature;
import com.example.assignment.model.Interior;
import com.example.assignment.repository.CarRepository;
import com.example.assignment.repository.ExteriorRepository;
import com.example.assignment.repository.FeatureRepository;
import com.example.assignment.repository.InteriorRepository;


@Configuration
public class DataSeedConfig {		


    @Bean
    CommandLineRunner commandLineRunner(CarRepository carRepository, FeatureRepository featureRepository, InteriorRepository interiorRepository, ExteriorRepository exteriorRepository) {
        return args -> {
      
            Car car1 = new Car("Tesla", "Model 3", "84,000");
            Car car2 = new Car("Tesla", "Model Y", "29,000");
            Car car3 = new Car("Tesla", "Model S", "467,000");
            Car car4 = new Car("Tesla", "Model X", "477,000");
            Feature f1 = new Feature("235,000",  "215,000", car1 );
            Feature f2 = new Feature("269,000",  "246,000", car2 );
            Feature f3 = new Feature("467,000",  "", car3 );
            Feature f4 = new Feature("235,000",  "", car4 );

            Exterior e1 = new Exterior("Pearl White", "Included", car1);
            Exterior e2 = new Exterior("Solid Black", "4500", car1);
            Exterior e3 = new Exterior("Midnight Silver", "6000", car1);
            Exterior e4 = new Exterior("Deep Blue", "6000", car1);
            Exterior e5 = new Exterior("Red Multi-Coat", "7500", car1);

            Exterior e6 = new Exterior("Pearl White", "Included", car2);
            Exterior e7 = new Exterior("Solid Black", "4500", car2);
            Exterior e8 = new Exterior("Midnight Silver", "6000", car2);
            Exterior e9 = new Exterior("Deep Blue", "6000", car2);
            Exterior e10 = new Exterior("Red Multi-Coat", "7500", car2);


            Exterior e11 = new Exterior("Pearl White", "Included", car3);
            Exterior e12 = new Exterior("Solid Black", "6000", car3);
            Exterior e13 = new Exterior("Midnight Silver", "7500", car3);
            Exterior e14 = new Exterior("Deep Blue", "7500", car3);
            Exterior e15 = new Exterior("Red Multi-Coat", "7500", car3);

            Exterior e16 = new Exterior("Pearl White", "Included", car4);
            Exterior e17 = new Exterior("Solid Black", "6000", car4);
            Exterior e18 = new Exterior("Midnight Silver", "7500", car4);
            Exterior e19 = new Exterior("Deep Blue", "7500", car4);
            Exterior e20 = new Exterior("Red Multi-Coat", "7500", car4);



            Interior i1 = new Interior("All Black", "included", car1);
            Interior i2 = new Interior("All Black", "included", car2);
            Interior i3 = new Interior("All Black", "included", car3);
            Interior i4 = new Interior("All Black", "included", car4);

            Interior i6 = new Interior("Black & White", "4,500", car1);
            Interior i7 = new Interior("Black & White", "4,500", car2);
            Interior i8 = new Interior("Black & White", "8,500", car3);
            Interior i9 = new Interior("Black & White", "8,500", car4);



            carRepository.saveAll(List.of(car1,car2, car3, car4));
            featureRepository.saveAll(List.of(f1,f2,f3,f4));
            exteriorRepository.saveAll(List.of(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20));
            interiorRepository.saveAll(List.of(i1,i2,i3,i4,i6,i7,i8,i9));
        };
        

    } 
    
}
