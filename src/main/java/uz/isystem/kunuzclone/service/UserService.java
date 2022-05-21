package uz.isystem.kunuzclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.kunuzclone.model.User;
import uz.isystem.kunuzclone.repository.UserRepository;
import uz.isystem.kunuzclone.repository.UserTypeRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTypeService userTypeService;

    public User create(User user){
        user.setStatus(true);
        userTypeService.get(user.getUserTypeId());
        userRepository.save(user);
        return user;

    }

    public  User get(Integer id){
        Optional<User> optional=userRepository.findById(id);
        if (optional.isEmpty()){
            throw new IllegalArgumentException("USER NOT FOUND");
        }
        return optional.get();
    }
    public User update(Integer id, User user){
        User old =get(id);
        userTypeService.get(user.getUserTypeId());
        old.setName(user.getName());
        old.setSurname(user.getSurname());
        old.setContact(user.getContact());
        old.setPassword(user.getPassword());
        old.setUserTypeId(user.getUserTypeId());
        userRepository.save(old);
        return old;
    }

    public boolean delete(Integer id){
        User user = get(id);
        userRepository.delete(user);
        return true;
    }
}
