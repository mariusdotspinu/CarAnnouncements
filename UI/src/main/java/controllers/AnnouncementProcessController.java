package controllers;

import dto.AnnouncementDto;
import facade.AnnouncementFacadeImpl;
import models.AnnouncementModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import util.Mapper;
import utils.ViewUtils;

import javax.validation.Valid;

import static utils.ViewUtils.*;

@Controller
public class AnnouncementProcessController {

    @RequestMapping(value = ENDPOINT_ADD, method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute(NEW_ANNOUNCEMENT) @Valid AnnouncementModel announcementModel,
                            BindingResult bindingResult, MultipartRequest request) {

        ModelAndView modelAndView = new ModelAndView(REDIRECT_HOME);
        if (bindingResult.hasErrors()){
            modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        }

        AnnouncementDto announcementDto = Mapper.transformAnnouncementModelToDto(announcementModel);
        announcementDto.setImagesStreams(Mapper.transformMultiPartFilesToByteStreams(request.getMultiFileMap()
                .get(UPLOAD_IMAGES_KEY)));

        new AnnouncementFacadeImpl().createAnnouncement(announcementDto);
        return modelAndView;
    }

    @RequestMapping(value = ENDPOINT_DELETE, method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView(ViewUtils.REDIRECT_HOME);
        new AnnouncementFacadeImpl().deleteAnnouncement(id);
        return modelAndView;
    }

    @RequestMapping(value = ENDPOINT_SEARCH, method = RequestMethod.POST)
    public ModelAndView search(@ModelAttribute(SEARCH_ANNOUNCEMENT_ATTRIBUTE) AnnouncementModel announcementModel,
                               BindingResult result, RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView(ViewUtils.REDIRECT_HOME);
        redirectAttributes.addFlashAttribute(ANNOUNCEMENT_ENTRIES,
                Mapper.transformAnnouncementsDtosToModels(
                new AnnouncementFacadeImpl()
                        .getAnnouncementsByCriterias(Mapper.transformAnnouncementModelToDto(announcementModel))));
        return modelAndView;
    }
}