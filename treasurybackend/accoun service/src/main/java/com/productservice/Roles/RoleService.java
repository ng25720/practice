package com.productservice.Roles;

import com.productservice.Utils.Shared.EntityResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j

public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    public EntityResponse add(Role role) {
        EntityResponse entityResponse = new EntityResponse<>();
        try {
            Role savedRole = roleRepository.save(role);
            entityResponse.setMessage("role created successfully");
            entityResponse.setStatusCode(HttpStatus.CREATED.value());
            entityResponse.setEntity(savedRole);
        }catch (Exception e){
            log.error("An error has occurred while trying to create a ROLE! {} ", e);
        }
        return entityResponse;
    }



    public EntityResponse deleteRole(Long id){
        EntityResponse response = new EntityResponse<>();
        try {
            Optional<Role> optRole = roleRepository.findById(id);
            if(optRole.isPresent()){
                Role role = optRole.get();
                roleRepository.delete(role);
                response.setMessage("successfully deleted role");
                response.setStatusCode(HttpStatus.OK.value());
            }else{
                response.setMessage("provided role Id does not exist!!");
                response.setStatusCode(HttpStatus.NOT_FOUND.value());
            }
        }catch (Exception e){
            log.info("caught error e{}",e.getMessage());
            response.setMessage("Failed to delete");
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return response;
    }

}
