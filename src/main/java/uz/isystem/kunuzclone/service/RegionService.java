package uz.isystem.kunuzclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.kunuzclone.model.Region;
import uz.isystem.kunuzclone.repository.RegionRepository;

import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public Region create(Region region){
        regionRepository.save(region);
        return region;
    }

    public Region get(Integer id){
        Optional<Region>optional=regionRepository.findById(id);
        if (optional.isEmpty()){
            throw new IllegalArgumentException("User not found");
        }
        return optional.get();
    }

    public Region update(Integer id, Region region){
        Region old=get(id);
        old.setName(region.getName());
        regionRepository.save(old);
        return old;
    }
    public boolean delete(Integer id){
        Region region =get(id);
        regionRepository.delete(region);
        return true;
    }
}
