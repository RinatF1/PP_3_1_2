package RinatF1.PP_3_1_2.controller;

import RinatF1.PP_3_1_2.entity.User;
import RinatF1.PP_3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    private UserService userService;
    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showAllUsers(ModelMap model){
        model.addAttribute("allUsers", userService.getAllUsers());
    return "all_users";
    }


    @RequestMapping("/addNewUser")
    public String addNewUser(ModelMap model){
        model.addAttribute("user", new User());
        return "add_user";
    }
    @GetMapping("/updateUser/{userId}")
    public String updateUser(@PathVariable("userId") int id, ModelMap model){
        model.addAttribute("user", userService.getUserById(id));
        return "update_user";
    }

    @RequestMapping("/addUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }



    @RequestMapping (value="/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
    @PatchMapping(value="/updateUser/{getId}")
    public String saveUpdateUser(@PathVariable int getId, @ModelAttribute("user") User user){
        user.setId(getId);
        userService.updateUser(user);
        return "redirect:/";
    }

}
