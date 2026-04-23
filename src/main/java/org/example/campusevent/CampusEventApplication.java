package org.example.campusevent;

import org.example.campusevent.model.Admin;
import org.example.campusevent.model.Event;
import org.example.campusevent.repository.AdminRepository;
import org.example.campusevent.repository.EventRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class CampusEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusEventApplication.class, args);
    }

    @Bean
    CommandLineRunner loadData(AdminRepository adminRepository,
                               EventRepository eventRepository) {

        return args -> {

            if (adminRepository.count() == 0) {

                adminRepository.save(new Admin(
                        "John",
                        "johnadmin@gmail.com",
                        "Manager"
                ));

                adminRepository.save(new Admin(
                        "James",
                        "jamesadmin@gmail.com",
                        "Coordinator"
                ));
            }

            if (eventRepository.count() == 0) {

                eventRepository.save(new Event(
                        "Hackathon",
                        "Coding competition",
                        "RIT Dubai",
                        "2026-06-01",
                        "John"
                ));

                eventRepository.save(new Event(
                        "Spring Fest",
                        "Sports activities",
                        "RIT Dubai",
                        "2026-05-20",
                        "James"
                ));
            }
        };
    }
}