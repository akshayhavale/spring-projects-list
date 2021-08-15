package com.example.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.model.Order;

public class ExcelHelper {

	public static final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	public static final String[] HEADERS = { "ORDER ID", "ORDER DATE", "PRODUCT NAME", "QUANTITY", "TOTAL",
			"CUSTOMER NAME", "SELLER NAME" };
	public static final String SHEET = "ORDERS";

	public static ByteArrayInputStream ordersToExcel(List<Order> orders) {
		try {
			Workbook workbook = new XSSFWorkbook();
			ByteArrayOutputStream out = new ByteArrayOutputStream();

			Sheet sheet = workbook.createSheet(SHEET);

			// Style
//
//			CellStyle style = workbook.createCellStyle();
//			Font font = workbook.createFont();
//			font.setColor((short) 2);
//			font.setFontHeight((short) 16);
//			style.setFont(font);

			// HEADER

			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < HEADERS.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERS[col]);
			//	cell.setCellStyle(style);
			}

			int rowIdx = 1;

			for (Order order : orders) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(order.getId());
				row.createCell(1).setCellValue(order.getOrderDate());
				row.createCell(2).setCellValue(order.getProductName());
				row.createCell(3).setCellValue(order.getOrderedQunatity());
				row.createCell(4).setCellValue(order.getOrderTotal().doubleValue());
				row.createCell(5).setCellValue(order.getCustomerName());
				row.createCell(6).setCellValue(order.getSellerName());

			}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());

		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}

}
