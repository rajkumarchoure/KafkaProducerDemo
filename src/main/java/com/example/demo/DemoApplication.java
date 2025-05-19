package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Paths;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private KafkaProducer kafkaProducer;

    public static void main(String[] args) {
        System.out.println("Hello World");
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //"Users/u1061126/Documents"
        String filePath = "/Users/u1061126/Documents/kafkaProducerFile.txt"; // Update this path
        String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));

        System.out.println("Hello World");
        //"Hello, Kafka! My name is john doe!23"
        kafkaProducer.sendMessage(fileContent);
    }
}
