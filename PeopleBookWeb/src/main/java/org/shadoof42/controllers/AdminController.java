package org.shadoof42.controllers;

import org.shadoof42.models.Role;
import org.shadoof42.store.Storage;
import org.shadoof42.store.Storages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();
        model.addAttribute("roles", storages.roleStorage.values());
        return "admin/roles";
    }
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveRole(@ModelAttribute Role role, ModelMap model) throws UnsupportedEncodingException {
        role.setName(new String (role.getName().getBytes("ISO-8859-1"), "UTF-8"));
        System.out.println("Новая роль" + role.getName() + " " + role.getId());
        storages.roleStorage.add(role);
        return "redirect:roles";
    }
//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public String deleteRole(@ModelAttribute Integer id, ModelMap model) {
////        Role role=storages.roleStorage.get(id);
//        System.out.println("Deletes "+storages.roleStorage.get(id));
//        storages.roleStorage.delete(id);
//        return "redirect:roles";
//    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteRole(@PathVariable Integer id, ModelMap model) {
//        Role role=storages.roleStorage.get(id);
        System.out.println("Deletes "+storages.roleStorage.get(id));
        storages.roleStorage.delete(id);
        return "redirect:/admin/roles";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editRolePage(@PathVariable Integer id, ModelMap model) {
        Role role=storages.roleStorage.get(id);
        System.out.println("Updates "+storages.roleStorage.get(id));
        model.addAttribute("role",role);
        return "/admin/editRole";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editRole(@ModelAttribute Role role,@PathVariable Integer id, ModelMap model) throws UnsupportedEncodingException {
        role.setId(id);
//        System.out.print(model.values());
        role.setName(new String (role.getName().getBytes("ISO-8859-1"), "UTF-8"));
        System.out.println("Новая роль"+role+" "+role.getId());
        storages.roleStorage.edit(role);
        return "redirect:/admin/roles";
    }


}
