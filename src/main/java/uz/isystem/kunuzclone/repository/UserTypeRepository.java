package uz.isystem.kunuzclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.kunuzclone.model.Usertype;

public interface UserTypeRepository extends JpaRepository<Usertype,Integer> {
}
