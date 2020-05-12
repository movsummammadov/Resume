package com.mycompany.controller;

import com.mycompany.entity.User;
import com.mycompany.form.UserForm;
import com.mycompany.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceInter userService;

//    @RequestMapping(method = RequestMethod.GET)
//    public String index(HttpServletRequest request){
//        String name=request.getParameter("name");
//        String surname=request.getParameter("surname");
//        String nationalityIdStr=request.getParameter("nid");
//        Integer nationalityId=null;
//        if(nationalityIdStr!=null && !nationalityIdStr.trim().isEmpty()){
//            nationalityId=Integer.parseInt(nationalityIdStr);
//        }
//        List<User> users=userService.getAllUser(name,surname,nationalityId);
//        request.setAttribute("users",users);
//        return "usersJ"  ;
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView index(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "surname",required = false) String surname,
                        @RequestParam(value = "nid",required = false) Integer nationalityId){
        List<User> users=userService.getAllUser(name,surname,nationalityId);
        ModelAndView mv=new ModelAndView("users");
        mv.addObject("users",users);
        return mv  ;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usersm")
    public ModelAndView indexM(@Valid @ModelAttribute("user") UserForm u, BindingResult bindingResult){
        ModelAndView mv=new ModelAndView("users");
        if(bindingResult.hasErrors()){
            return mv;
        }
        List<User> users=userService.getAllUser(u.getName(), u.getSurname(), u.getNationalityId());
        mv.addObject("users",users);
        return mv  ;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/login")
    public String loginPost(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logoutPage(){
        return "logout";
    }
    //Spring tags sehife her defe yuklenende inputlara deyer yuklemek uchun bu bosh obyekt istifade edecek
    //Eger bele bir obyekt olmasa idi inputlara yuklenecek deyer tapilmadigi uchun biz error alacaqdiq
    @ModelAttribute("user")
    public UserForm getEmptyUserForm(){
        return new UserForm();
    }
}
