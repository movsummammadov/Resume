package com.mycompany.controller;

import com.mycompany.dto.ResponseDTO;
import com.mycompany.entity.User;
import com.mycompany.dto.UserDTO;
import com.mycompany.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
public class UserRestController {

    @Autowired
    private UserServiceInter userService;

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUsers(@RequestParam(name="name",required = false) String name,
                                               @RequestParam(name="surname",required = false) String surname,
                                               @RequestParam(name="nationalityId",required = false) Integer nId)
    {
        List<User> users=userService.getAllUser(name,surname,nId);
        List<UserDTO> userDTOS=new ArrayList<>();
        for (int i = 0; i <users.size() ; i++) {
            User u=users.get(i);
            userDTOS.add(new UserDTO(u));
        }
        return  ResponseEntity.ok(ResponseDTO.of(userDTOS));
//        return ResponseEntity.status( HttpStatus.OK).body(userDTOS);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") int id){
        User user=userService.getById(id);
        return  ResponseEntity.ok(ResponseDTO.of(new UserDTO(user)));
//        return ResponseEntity.status( HttpStatus.OK).body(userDTOS);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") int id){
        User user=userService.getById(id);
        userService.removeUser(id);
        return  ResponseEntity.ok(ResponseDTO.of(new UserDTO(user),"Succesfully deleted"));
//        return ResponseEntity.status( HttpStatus.OK).body(userDTOS);
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDto){
        User user=new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPassword(userDto.getPassword());
        userService.addUser(user);

        UserDTO userDTO=new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        return  ResponseEntity.ok(ResponseDTO.of(userDTO,"Succesfully added"));
//        return ResponseEntity.status( HttpStatus.OK).body(userDTOS);
    }
}
