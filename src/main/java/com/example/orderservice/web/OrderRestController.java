package com.example.orderservice.web;

import com.example.orderservice.entities.Order;
import com.example.orderservice.feign.CustomerRestClient;
import com.example.orderservice.feign.ProductItemRestClient;
import com.example.orderservice.model.Customer;
import com.example.orderservice.model.Product;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.repository.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductItemRestClient productItemRestClient;

    public OrderRestController(OrderRepository orderRepository,ProductItemRepository productItemRepository,CustomerRestClient customerRestClient,ProductItemRestClient productItemRestClient){
        this.orderRepository=orderRepository;
        this.productItemRepository=productItemRepository;
        this.customerRestClient=customerRestClient;
        this.productItemRepository=productItemRepository;


    }
    @GetMapping(path = "/fullBill/{id}")
    public Order getOrder(@PathVariable(name="id") Long id ){
        Order order=orderRepository.findById(id).get();
        Customer customer=customerRestClient.getCustomerById(order.getId());
        order.setCustomer(customer);
        order.getProductItems().forEach(pi->{
            Product product=productItemRestClient.getProductById(pi.getProductID());
            pi.setProductName(product.getName());
        });

        return order;
    }
}
