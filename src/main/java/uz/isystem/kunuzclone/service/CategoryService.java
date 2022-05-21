package uz.isystem.kunuzclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.kunuzclone.model.Category;
import uz.isystem.kunuzclone.model.Post;
import uz.isystem.kunuzclone.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category create(Category category) {
        categoryRepository.save(category);
        return category;
    }

    public Category get(Integer id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        return optional.get();
    }

    public Category update(Integer id, Category category) {
        Category old = get(id);
        old.setName(category.getName());
        categoryRepository.save(old);
        return old;
    }

    public boolean delete(Integer id) {
        Category category = get(id);
        categoryRepository.delete(category);
        return true;
    }
}
