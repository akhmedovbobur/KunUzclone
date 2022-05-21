package uz.isystem.kunuzclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.kunuzclone.model.Category;
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
