package com.desafioNelio.desafio;

import com.desafioNelio.desafio.entities.Order;
import com.desafioNelio.desafio.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {
    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //System.out.print("Código do produto: ");
        int code = sc.nextInt();

        //System.out.print("Valor básico: ");
        double basic = sc.nextDouble();

        //System.out.print("Desconto (ex: 0.1 para 10%): ");
        double discount = sc.nextDouble();

        Order order = new Order(code, basic, discount);
        double finalTotal = orderService.total(order);

        System.out.printf("Pedido código %d \n", order.getCode());
        System.out.printf("Valor total: %.2f", finalTotal);
    }
	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

}
