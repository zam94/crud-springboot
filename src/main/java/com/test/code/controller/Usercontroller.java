package com.test.code.controller;

import com.test.code.Model.Users;
import com.test.code.dto.BaseDTO;
import com.test.code.dto.UsersDTO;
import com.test.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Usercontroller {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/addemail",
            method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addemail(@RequestBody UsersDTO usersDTO) {
        Users users = userService.addemail(usersDTO);
        BaseDTO base = new BaseDTO();
        base.setId(users.getId());
        base.setRandomId(users.getRandomId());
        return new ResponseEntity(base, HttpStatus.OK);
    }

    @RequestMapping(value = "/edituser/{id}",
            method = RequestMethod.PUT)
    @ResponseBody
    // bisa juga tidak menggunakan PathVariable, jadi Id nya di input dalam JSON. kalau pakai PathVariable id tidak perlu di masukan dalam JSON cukup dalam url saja (http://localhost:8060/users/edituser/4).. karena kan id tidak dapat di edit.
    public ResponseEntity updateuser(@RequestBody UsersDTO usersDTO, @PathVariable (value = "id") Integer id) {
        String message = "";
        message = userService.updateuser(usersDTO, id);
        return new ResponseEntity(message, HttpStatus.OK);
    }

    @RequestMapping(value = "/listuser",
            method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity listUsers(@RequestParam(value = "id") Integer id) {
        Users users = userService.listUsers(id);
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/alluser",
            method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity alluser() {
        List<Users> users = userService.alluser();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteuser/{id}",
            method = RequestMethod.DELETE)
    @ResponseBody
    // bisa juga tdak menggunakan PathVariable, jadi Id nya di input dalam JSON. kalau pakai PathVariable id tidak perlu di masukan dalam JSON cukup dalam url saja.
    public ResponseEntity deleteuser(@RequestBody UsersDTO usersDTO, @PathVariable (value = "id") Integer id) {
        String message = "";
        message = userService.deleteuser(usersDTO, id);
        return new ResponseEntity(message, HttpStatus.OK);

    }

}

