package com.productservice.Roles;

import com.productservice.Utils.Shared.EntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/role")
@CrossOrigin

public class RoleController {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleService roleService;
    @PostMapping("/add")
    public EntityResponse add(@RequestBody Role role){
        return roleService.add(role);
    }
    @GetMapping("/roles/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable Long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if (roleOptional.isPresent()) {
            Role role = roleOptional.get();
            return ResponseEntity.ok().body(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return ResponseEntity.ok().body(roles);
    }
    @DeleteMapping("/roles/{id}")
    public ResponseEntity<EntityResponse> deleteRoleById(@PathVariable Long id) {
        try{
            EntityResponse response = roleService.deleteRole(id);
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            return null;
        }

    }
}
