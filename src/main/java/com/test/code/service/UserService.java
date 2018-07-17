package com.test.code.service;

import com.test.code.Model.Users;
import com.test.code.dto.UsersDTO;
import com.test.code.exception.NewException;
import com.test.code.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.*;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UsersRepository usersRepository;


    public Users addemail(UsersDTO usersDTO) throws NumberFormatException {

        // Menggunakan tipe data varchar dengan lenght 25.. dengan melakukan looping sebanyak 25 kali, untuk mendapatkan randomId dengan lenght  25
        final String  randomid= "abcdefghijklmnopqrstuvwxyz01234567891011121314151617181920";
        int lenght = 25;

        StringBuilder stringBuilder = new StringBuilder(lenght);
        Random random = new Random();

        for(int i = 0; i < lenght; i++){
            stringBuilder.append(randomid.charAt(random.nextInt(randomid.length())));
        }
        //------BATAS

        // ini mengunakan tipe integer untuk randomId hanya saja lenght nya sampai 10 saja
        //  dan memproduksi angka random dengan batas 0 - 900000000 dengan ditambah angka 100000000

//        users.setRandomId(random.nextInt(900000000) + 100000000);
        //---BATAS

        Users users = new Users();

        users.setRandomId(stringBuilder.toString());

        if (StringUtils.isEmpty(usersDTO.getUsername())) {
            throw new NewException("Mohon input username");
        } else{
            users.setUsername(usersDTO.getUsername());
        }
        if (StringUtils.isEmpty(usersDTO.getEmail())) {
            throw new NewException("Mohon Input email");
        } else{
            users.setEmail(usersDTO.getEmail());
        }

        users = usersRepository.save(users);
        return users;
    }


    public String updateuser(UsersDTO usersDTO, Integer id) {

        // update data user berdasarkan id user
        Users users = new Users();

        users = usersRepository.findById(id);
        if(users == null ){
            throw  new NewException("user not found");
        }

        users.setUsername(usersDTO.getUsername());
        users.setEmail(usersDTO.getEmail());
        users = usersRepository.save(users);

        String message = "data berhasil di update";
        return message;
    }


    public Users listUsers(Integer id) {
        // get list berdasarkan ID user
        Users users = usersRepository.findById(id);
        if(users == null){
            throw  new NewException("Not found");
        }

        return users;
    }

    public List<Users> alluser() {

        // list semua user
        List<Users> users = usersRepository.findAll();
        return users;
    }

    public String deleteuser(UsersDTO usersDTO, Integer id) {
        // delete user berdasarkan id user

        Users users = new Users();
        users = usersRepository.findById(id);

        if (users == null) {
            throw new NewException("Users not found");
        }
        users.setUsername(usersDTO.getUsername());
        users.setEmail(usersDTO.getEmail());

        usersRepository.delete(users);
        String message = "Data berhasil di hapus";
        return message;
    }

}
