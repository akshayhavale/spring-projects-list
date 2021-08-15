package com.example.initializer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Order;
import com.example.repository.OrderRepository;

@Component
public class DatabaseIntializer {

	@Autowired
	private OrderRepository orderRepository;

	@PostConstruct
	public void createOrders() {

		Order o1 = new Order("Nike Shoe", 10, new Date(), new BigDecimal(10000), "Customer1", "Seller1");
		Order o2 = new Order("Fila Shoe", 2, new Date(), new BigDecimal(123), "Customer1", "Seller2");
		Order o3 = new Order("Roadster Shoe", 1, new Date(), new BigDecimal(300), "Customer2", "Seller2");
		Order o4 = new Order("Puma Shoe", 3, new Date(), new BigDecimal(4500), "Customer4", "Seller1");
		Order o5 = new Order("Rebook Shoe", 34, new Date(), new BigDecimal(545656.667), "Customer4", "Seller5");

		List<Order> list = Arrays.asList(o1, o2, o3, o4, o5);
		orderRepository.saveAll(list);
	}

}
