package com.ihsan.useralbum.mvc;

import com.ihsan.useralbum.dto.request.LoginRequestDto;
import com.ihsan.useralbum.dto.request.UserSaveRequestDto;
import com.ihsan.useralbum.repository.entity.EUserType;
import com.ihsan.useralbum.repository.entity.User;
import com.ihsan.useralbum.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserMvcController {

    private final UserService userService;

    @GetMapping("/")
    public ModelAndView getRegisterPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("register");
        return  modelAndView;
    }

    @PostMapping("/saveuser")
    public ModelAndView saveUser(UserSaveRequestDto dto){
        userService.saveWithRequestDto(dto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }


    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/doLogin")
    public ModelAndView doLogin(LoginRequestDto dto){

        ModelAndView modelAndView = new ModelAndView();

        Optional<User> user = userService.login(dto.getEmail(), dto.getPassword());

        if(user.isPresent()){
            if(user.get().getUserType()== EUserType.Erkek){
                modelAndView.setViewName("erkeksayfasi");
            }else {
                modelAndView.setViewName("kizsayfasi");
            }
        }else {
            modelAndView.setViewName("register");
        }

        return modelAndView;
    }


    @GetMapping("/erkeksayfasi")
    public ModelAndView erkeksayfasi(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("erkeksayfasi");
        return modelAndView;
    }


    @GetMapping("/kizsayfasi")
    public ModelAndView kizsayfasi(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("kizsayfasi");
        return modelAndView;
    }

}
