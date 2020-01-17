package com.example.tema3.tema3.Service;

import com.example.tema3.tema3.Util.ResourceDto;
import com.example.tema3.tema3.controllers.UserController;
import com.example.tema3.tema3.models.Resources;
import com.example.tema3.tema3.models.Users;
import com.example.tema3.tema3.repository.ResourcesRepository;
import com.example.tema3.tema3.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResourceService {
    @Autowired
    private ResourcesRepository resourceRepository;
    @Autowired
    private UsersRepository usersRepository;

    public Resources save(ResourceDto resourceDto) {
        Users currentUser = usersRepository.findByUsername(UserController.currentUserName());
        Resources resource = new Resources();
        resource.setName(resourceDto.getName());
        resource.setText("");
        currentUser.addResource(resource);
        return resourceRepository.save(resource);
    }

    public Resources update(ResourceDto resourceDto) {
        long id = resourceDto.getId();
        Optional<Resources> resource = resourceRepository.findById(id);
        resource.get().setText(resourceDto.getResourceText());

        return resourceRepository.save(resource.get());
    }

    public void  delete(String id){
        Optional<Resources> resource = resourceRepository.findById(Long.parseLong(id));
        Users user = usersRepository.findByUsername(UserController.currentUserName());
        user.getResources().remove(resource.get());
        resourceRepository.delete(resource.get());
    }
}
