package token.cysewskaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import token.cysewskaa.entities.PersonEntity;
import token.cysewskaa.entities.UserDao;
import token.cysewskaa.implementation.PersonRepo;
import token.cysewskaa.implementation.UserRepo;

import java.util.List;

/**
 * Created by cysewskaa on 2016-08-18.
 */
@Controller

public class HelloWorldController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model) {
        return "hello";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyLogin(@RequestParam String login, @RequestParam String password)
    {
        List<UserDao> personListByLogin = userRepo.getPersonListByLogin(login);
    if (personListByLogin.size()>1)
    {
        return "success";
    }
        else
        return "error";
    }


}
