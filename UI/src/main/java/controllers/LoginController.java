package controllers;

import facade.UserFacadeImpl;
import models.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import util.Mapper;
import util.MessageUtils;
import utils.ViewUtils;

import javax.validation.Valid;

import static utils.ViewUtils.EMAIL;
import static utils.ViewUtils.ENDPOINT_LOGIN;
import static utils.ViewUtils.ENDPOINT_LOGIN_PROCESS;

@Controller
public class LoginController {

    @RequestMapping(value = ENDPOINT_LOGIN, method = RequestMethod.GET)
    public ModelAndView login() {

        ModelAndView modelAndView = new ModelAndView(ViewUtils.VIEW_LOGIN);
        modelAndView.addObject(ViewUtils.USER_ATTRIBUTE, new UserModel());
        return modelAndView;
    }

    @RequestMapping(value = ENDPOINT_LOGIN_PROCESS, method = RequestMethod.POST)
    public ModelAndView loginAction(@ModelAttribute(ViewUtils.USER_ATTRIBUTE) @Valid UserModel user,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView(ViewUtils.VIEW_LOGIN);
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }

        user.setLogged(new UserFacadeImpl().isAuthenticated(Mapper.transformUserModelToDto(user)));
        if (user.isLogged()){
            ModelAndView homeMav = new ModelAndView(ViewUtils.REDIRECT_HOME);
            redirectAttributes.addFlashAttribute(ViewUtils.USER_ATTRIBUTE, user);
            return homeMav;
        }

        bindingResult.rejectValue(EMAIL, MessageUtils.WRONG_CREDENTIALS);
        return  modelAndView;
    }
}