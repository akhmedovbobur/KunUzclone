package uz.isystem.kunuzclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.kunuzclone.model.Post;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post>findAllByCategoryId(Integer categoryId);
    List<Post>findAllByRegionId(Integer categoryId);
}
