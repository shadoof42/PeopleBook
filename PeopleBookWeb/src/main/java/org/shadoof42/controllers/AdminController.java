package org.shadoof42.controllers;

import org.shadoof42.models.Role;
import org.shadoof42.models.User;
import org.shadoof42.store.Storage;
import org.shadoof42.store.Storages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
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
        model.addAttribute("roles", storages.roleStorage.values());
        return "admin/roles";
    }
    
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveRole(@ModelAttribute Role role) throws UnsupportedEncodingException {
        role.setName(new String (role.getName().getBytes("ISO-8859-1"), "UTF-8"));
        System.out.println("Новая роль" + role.getName() + " " + role.getId());
        storages.roleStorage.add(role);
        return "redirect:roles";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteRole(@PathVariable Integer id) {
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
    public String editRole(@ModelAttribute Role role, @PathVariable Integer id) throws UnsupportedEncodingException {
        role.setId(id);
//        System.out.print(model.values());
        role.setName(new String (role.getName().getBytes("ISO-8859-1"), "UTF-8"));
        System.out.println("Новая роль"+role+" "+role.getId());
        storages.roleStorage.edit(role);
        return "redirect:/admin/roles";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String showUsers(ModelMap model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("users", storages.userStorage.values());
        return "admin/users";
    }

    @RequestMapping(value = "/new_user",method = RequestMethod.GET)
    public String createUser(ModelMap model) throws UnsupportedEncodingException {
        model.addAttribute("roles",storages.roleStorage.values());
        model.put("user",new User());
        model.addAttribute("create",true);
        return "admin/createUser";
    }

    @RequestMapping(value = "/new_user",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user, HttpServletRequest request, ModelMap model) throws UnsupportedEncodingException {
        System.out.println("Новый пользователь " + user);
        user.setLogin(new String (user.getLogin().getBytes("ISO-8859-1"), "UTF-8"));
        user.setEmail(new String(user.getEmail().getBytes("ISO-8859-1"), "UTF-8"));
        user.setPassword(new String(user.getPassword().getBytes("ISO-8859-1"), "UTF-8"));
        storages.userStorage.add(user);
        return "redirect:users";
    }

    @RequestMapping(value = "/user_delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id) {
        storages.userStorage.delete(id);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/user_edit/{id}", method = RequestMethod.GET)
    public String editUserView(@PathVariable Integer id, ModelMap model) {
        model.addAttribute("create",false);
        model.put("user",storages.userStorage.get(id));
        model.addAttribute("roles",storages.roleStorage.values());
        return "/admin/createUser";
    }
    @RequestMapping(value = "/user_edit/{id}", method = RequestMethod.POST)
    public String editUser(@PathVariable Integer id, ModelMap model, @ModelAttribute("user") User user) throws UnsupportedEncodingException {
        user.setId(id);
        System.out.println("Новый пользователь " + user);
        user.setLogin(new String (user.getLogin().getBytes("ISO-8859-1"), "UTF-8"));
        user.setEmail(new String(user.getEmail().getBytes("ISO-8859-1"), "UTF-8"));
        user.setPassword(new String(user.getPassword().getBytes("ISO-8859-1"), "UTF-8"));
        storages.userStorage.edit(user);
        return "redirect:/admin/users";
    }

}
