package com.example.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Order;
import com.example.repository.OrderRepository;
import com.example.util.ExcelHelper;

@Service
public class ExcelSheetDownloaderServiceImpl implements ExcelSheetDownloaderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public ByteArrayInputStream getOrdersSheet() {
		List<Order> list = orderRepository.findAll();

		return ExcelHelper.ordersToExcel(list);
	}

}
