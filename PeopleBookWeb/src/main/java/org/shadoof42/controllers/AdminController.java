package org.shadoof42.controllers;

import org.shadoof42.models.Role;
import org.shadoof42.store.Storage;
import org.shadoof42.store.Storages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * Created by Shadoof on 14.03.2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private Storages storages;

    @RequestMapping(value = "roles", method = RequestMethod.GET)
    public String showRoles(ModelMap model){
        model.addAttribute("roles", storages.roleStorage.values());
        return "admin/roles";
    }
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveRole(@ModelAttribute Role role, ModelMap model) throws UnsupportedEncodingException {
        role.setName(new String (role.getName().getBytes("ISO-8859-1"), "UTF-8"));
        storages.roleStorage.add(role);
        return "redirect:roles";
    }
}
