package uz.isystem.kunuzclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.kunuzclone.model.User;
import uz.isystem.kunuzclone.model.Usertype;
import uz.isystem.kunuzclone.repository.UserTypeRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserTypeService {
    @Autowired
    private UserTypeRepository userTypeRepository;

    public Usertype create(Usertype usertype){
        usertype.setStatus(true);
        usertype.setCreatedAt(LocalDateTime.now());
        userTypeRepository.save(usertype);
        return usertype;
    }

    public Usertype get(Integer id){
        Optional<Usertype>optional =userTypeRepository.findById(id);
        if (optional.isEmpty()){
            throw new IllegalArgumentException("USER TYPE NOT FOUND");
        }
        return optional.get();
    }

    public Usertype update(Integer id, Usertype usertype){
        Usertype old=get(id);
        old.setName(usertype.getName());
        old.setUpdate(LocalDateTime.now());
        userTypeRepository.save(old);
        return old;
    }
     public boolean delete(Integer id){
        Usertype usertype=get(id);
         userTypeRepository.delete(usertype);
         return true;
     }
}
