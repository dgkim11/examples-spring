package example.spring.data.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Order Entity describes an order of products.
 * An order contains purchased products and who purchased.
 * Order entity has relationship with Product and Customer entities.
 * 
 * @author Dennis
 *
 */
@Entity
@Table(name = "spring_data_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToMany
	@JoinTable(
			name = "order_products",
			joinColumns = @JoinColumn(name = "orderId"),
			inverseJoinColumns = @JoinColumn(name = "productId"))
	private Set<Product> products = new HashSet<Product>();
	
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	private Date orderedAt;

	public long getId() {
		return id;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Date getOrderedAt() {
		return orderedAt;
	}

	public void setOrderedAt(Date orderedAt) {
		this.orderedAt = orderedAt;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
