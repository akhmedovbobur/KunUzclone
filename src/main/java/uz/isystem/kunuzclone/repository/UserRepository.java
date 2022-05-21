package uz.isystem.kunuzclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.kunuzclone.model.User;

public interface UserRepository  extends JpaRepository<User, Integer> {
}
