package controllers;

import facade.UserFacadeImpl;
import models.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import util.Mapper;
import util.MessageUtils;
import utils.ViewUtils;

import javax.validation.Valid;

import static utils.ViewUtils.EMAIL;
import static utils.ViewUtils.ENDPOINT_REGISTER;
import static utils.ViewUtils.ENDPOINT_REGISTER_PROCESS;

@Controller
public class RegisterController {

    @RequestMapping(value = ENDPOINT_REGISTER, method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView(ViewUtils.VIEW_REGISTER);
        modelAndView.addObject(ViewUtils.NEW_USER_ATTRIBUTE, new UserModel());
        return modelAndView;
    }

    @RequestMapping(value = ENDPOINT_REGISTER_PROCESS, method = RequestMethod.POST)
    public String registerAction(@ModelAttribute(ViewUtils.NEW_USER_ATTRIBUTE) @Valid UserModel user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ViewUtils.VIEW_REGISTER;
        }
        boolean isCreated = new UserFacadeImpl().createUser(Mapper.transformUserModelToDto(user));
        if (!isCreated) {
            bindingResult.rejectValue(EMAIL, MessageUtils.EXISTING_EMAIL_CODE);
            return ViewUtils.VIEW_REGISTER;
        }

        return ViewUtils.VIEW_REGISTER_SUCCESS;
    }
}
