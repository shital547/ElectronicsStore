package com.bikkadit.electronicsstore.repositories;

import com.bikkadit.electronicsstore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,String> {

    //search
    List<Product> findByAllContaining(String subtitle);

    List<Product> findByLiveTrue();

    // other method
    //customFinderMethod

}
