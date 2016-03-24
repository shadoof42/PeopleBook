package org.shadoof42.controllers;

import org.shadoof42.store.Storages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Shadoof on 23.03.2016.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private Storages storages;

    @RequestMapping(value = "abonent_list", method = RequestMethod.GET)
    public String showRoles(ModelMap model){

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("", storages.roleStorage.values());

        return "/user/abonent_list";
    }

}
