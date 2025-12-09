package com.desafioNelio.desafio;

import com.desafioNelio.desafio.entities.Order;
import com.desafioNelio.desafio.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {
    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Código do produto: ");
//        int code = sc.nextInt();
//
//        System.out.print("Valor básico: ");
//        double basic = sc.nextDouble();
//
//        System.out.print("Desconto (ex: 0.1 para 10%): ");
//        double discount = sc.nextDouble();

        Order order = new Order(1010, 200, 0.1);
        double finalTotal = orderService.total(order);

        System.out.printf("Código: %d%n", order.getCode());
        System.out.printf("Valor total: %.2f%n", finalTotal);
    }
	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

}
