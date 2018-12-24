package dao;

import db.DbAccess;
import entity.AnnouncementEntity;
import entity.AnnouncementImagesEntity;

import java.util.List;

public class AnnouncementDaoImpl implements AnnouncementDao {
    @Override
    public List<AnnouncementEntity> getAllAnnouncements() {
        return DbAccess.getAllAnnouncements();
    }

    @Override
    public List<AnnouncementEntity> getAnnouncementByCriterias(AnnouncementEntity announcementEntity) {
        return DbAccess.getAnnouncementByCriterias(announcementEntity);
    }

    @Override
    public AnnouncementEntity getAnnouncement(String id) {
        return DbAccess.getAnnouncement(id);
    }

    @Override
    public List<byte[]> getImagesForAnnouncementEntity(AnnouncementEntity announcementEntity) {
        return DbAccess.getImagesForAnnouncement(announcementEntity);
    }

    @Override
    public void deleteAnnouncement(String id) {
        DbAccess.deleteAnnouncement(id);
    }

    @Override
    public void createAnnouncement(AnnouncementEntity announcementEntity, List<AnnouncementImagesEntity> announcementImagesEntities) {
        DbAccess.addAnnouncement(announcementEntity, announcementImagesEntities);
    }

}
