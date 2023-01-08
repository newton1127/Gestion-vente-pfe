package org.sid.ProductSevice.repositories;

import org.sid.ProductSevice.entities.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ICatalog extends JpaRepository<Catalog,Long> {
}
