package facade;

import dto.AnnouncementDto;

import java.util.List;

public interface AnnouncementFacade {
    List<AnnouncementDto> getAllAnnouncements();
    List<AnnouncementDto> getAnnouncementsByCriterias(AnnouncementDto announcementDto);
    AnnouncementDto getAnnouncement(String announcementId);
    void deleteAnnouncement(String id);
    void createAnnouncement(AnnouncementDto announcementDto);

}
