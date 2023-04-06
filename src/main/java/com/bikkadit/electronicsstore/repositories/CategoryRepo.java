package com.bikkadit.electronicsstore.repositories;

import com.bikkadit.electronicsstore.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
