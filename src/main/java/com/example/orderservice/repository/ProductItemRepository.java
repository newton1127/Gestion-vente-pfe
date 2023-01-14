package com.example.orderservice.repository;

import com.example.orderservice.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;


@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<OrderItem,Long> {
    //public Optional<ProductItem> findById(Long id);
    @RestResource(path = "/byBillId")
    public Collection<OrderItem> findAllByBill_Id(Long id);

}
