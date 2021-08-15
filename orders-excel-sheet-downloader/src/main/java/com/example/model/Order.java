package com.example.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private Long id;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "ORDERED_QUANTITY")
	private Integer orderedQunatity;

	@Column(name = "ORDERED_DATE")
	@Temporal(TemporalType.DATE)
	private Date orderDate;

	@Column(name = "ORDER_TOTAL")
	private BigDecimal orderTotal;

	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	@Column(name = "SELLER_NAME")
	private String sellerName;

	public Order(String productName, Integer orderedQunatity, Date orderDate, BigDecimal orderTotal,
			String customerName, String sellerName) {
		super();
		this.productName = productName;
		this.orderedQunatity = orderedQunatity;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
		this.customerName = customerName;
		this.sellerName = sellerName;
	}

}
