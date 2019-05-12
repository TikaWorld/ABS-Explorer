package com.toyproject.abs_explorer.Repository;

import com.toyproject.abs_explorer.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository <Category, String> {
}
