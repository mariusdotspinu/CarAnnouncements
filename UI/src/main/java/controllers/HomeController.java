package controllers;

import facade.AnnouncementFacadeImpl;
import models.AnnouncementModel;
import models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import util.Mapper;
import utils.ViewUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

import static utils.ViewUtils.*;

@Controller
public class HomeController {

    @Autowired
    private UserModel userHolder;

    @RequestMapping(value = ENDPOINT_HOME, method = RequestMethod.GET)
    public ModelAndView home(Model model) {
        initAuthenticatedUser(model);
        ModelAndView modelAndView = new ModelAndView(ViewUtils.VIEW_HOME);
        initAnnouncementEntries(model, modelAndView);

        return modelAndView;
    }

    private void initAuthenticatedUser(Model model) {
        if (model.containsAttribute(USER_ATTRIBUTE)) {

            UserModel userModel = (UserModel) model.asMap().get(USER_ATTRIBUTE);
            userHolder.setLogged(userModel.isLogged());
            userHolder.setEmailAddress(userModel.getEmailAddress());
        }
        model.addAttribute(USER_ATTRIBUTE, userHolder);
    }

    private void initAnnouncementEntries(Model model, ModelAndView modelAndView) {
        List<AnnouncementModel> announcementModels;
        if (model.containsAttribute(ANNOUNCEMENT_ENTRIES)) {
            announcementModels = (List<AnnouncementModel>) model.asMap().get(ANNOUNCEMENT_ENTRIES);
        } else {
            announcementModels = Mapper.transformAnnouncementsDtosToModels(new AnnouncementFacadeImpl().getAllAnnouncements());
        }
        model.addAttribute(SEARCH_ANNOUNCEMENT_ATTRIBUTE, new AnnouncementModel());
        model.addAttribute(NEW_ANNOUNCEMENT, new AnnouncementModel());
        modelAndView.addObject(ANNOUNCEMENT_ENTRIES, announcementModels);
    }

    @RequestMapping(value = ENDPOINT_LOGOUT, method = RequestMethod.POST)
    public ModelAndView logout(Model model, HttpSession session) {
        session.invalidate();
        model.addAttribute(USER_ATTRIBUTE, new UserModel());
        return new ModelAndView(VIEW_LOGIN);
    }
}
