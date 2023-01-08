package org.sid.ProductSevice.repositories;

import org.sid.ProductSevice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IProduct extends JpaRepository<Product,Long> {
}
