package org.sid.ProductSevice;

import org.sid.ProductSevice.entities.Catalog;
import org.sid.ProductSevice.entities.Product;
import org.sid.ProductSevice.repositories.ICatalog;
import org.sid.ProductSevice.repositories.IProduct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProductSeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductSeviceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(IProduct iProduct, ICatalog iCatalog, RepositoryRestConfiguration restConfiguration){
		restConfiguration.exposeIdsFor(Product.class, Catalog.class);
		return args -> {
			Catalog c1=new Catalog();
			Catalog c2=new Catalog();
			Catalog c3=new Catalog();
			c1.setLibelle("Espadrilles");
			c2.setLibelle("Haltère");
			c3.setLibelle("Montre connectée");
			iCatalog.save(c1);
			iCatalog.save(c2);
			iCatalog.save(c3);
			iProduct.save(new Product(null,"Nike","",120,200,"",c1));
			iProduct.save(new Product(null,"Proiron","",120,150,"",c2));
			iProduct.save(new Product(null,"Montre connectée Iphone","",3000,1000,"",c3));
			iProduct.findAll().forEach(p->{
				System.out.println(p.getDesignation());
				System.out.println(p.getDescription());
				System.out.println(p.getQuantite_stock());
				System.out.println(p.getPrix());
				//System.out.println(p.getCatalog())
			});
		};
	}

}
