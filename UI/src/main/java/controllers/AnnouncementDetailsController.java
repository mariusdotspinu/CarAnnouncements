package controllers;

import facade.AnnouncementFacadeImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import util.Mapper;
import utils.ViewUtils;

import static utils.ViewUtils.ANNOUNCEMENT_ENTRY;
import static utils.ViewUtils.ENDPOINT_DETAILS;

@Controller
public class AnnouncementDetailsController {

    @RequestMapping(value = ENDPOINT_DETAILS, method = RequestMethod.GET)
    public ModelAndView viewAnnouncementDetails(@PathVariable String announcementId, Model model){
        ModelAndView modelAndView = new ModelAndView(ViewUtils.VIEW_DETAILS);
        model.addAttribute(ANNOUNCEMENT_ENTRY, Mapper.transformAnnouncementDtoToModel(
                new AnnouncementFacadeImpl().getAnnouncement(announcementId)));
        return modelAndView;
    }

}
