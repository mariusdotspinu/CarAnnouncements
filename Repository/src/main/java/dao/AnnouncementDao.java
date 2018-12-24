package dao;

import entity.AnnouncementEntity;
import entity.AnnouncementImagesEntity;

import java.util.List;

public interface AnnouncementDao {
    List<AnnouncementEntity> getAllAnnouncements();
    List<AnnouncementEntity> getAnnouncementByCriterias(AnnouncementEntity announcementEntity);
    AnnouncementEntity getAnnouncement(String id);
    List<byte[]> getImagesForAnnouncementEntity(AnnouncementEntity announcementEntity);
    void deleteAnnouncement(String id);
    void createAnnouncement(AnnouncementEntity announcementEntity, List<AnnouncementImagesEntity> announcementImagesEntities);
}
