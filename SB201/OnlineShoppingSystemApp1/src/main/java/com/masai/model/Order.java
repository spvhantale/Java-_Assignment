package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import com.masai.dto.AddressDTO;
import com.masai.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	private LocalDate orderDate;
	
	private String orderStatus;
	
	private Double total;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_order",joinColumns = @JoinColumn(name="order_id", referencedColumnName = "orderId"))
	private Customer customer;
	
	@ElementCollection
	@CollectionTable(name="product_order",joinColumns=@JoinColumn(name="order_id",referencedColumnName = "orderId"))
	private List<ProductDTO> productList = new ArrayList<>();
	
	@Embedded
	private AddressDTO orderAddress;
	 	
	
	
}
