package db;

import entity.AnnouncementEntity;
import entity.AnnouncementImagesEntity;
import entity.UserEntity;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.NativeQuery;

import util.HibernateSessionFactory;

import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

import static db.QueryManager.*;
import static util.NativeQuery.*;

public class DbAccess {

    static Session currentSession;

    public static AnnouncementEntity getAnnouncement(String id){
        startTransaction();

        NativeQuery query = currentSession.createNativeQuery(FIND_ANNOUNCEMENT);
        query.addEntity(AnnouncementEntity.class);
        query.setParameter(ID_PARAM, id);

        AnnouncementEntity announcementEntity = (AnnouncementEntity) query.getSingleResult();
        endTransaction();

        return announcementEntity;
    }

    @SuppressWarnings("unchecked")
    public static List<AnnouncementEntity> getAllAnnouncements() {
        startTransaction();

        List<AnnouncementEntity> announcements;
        NativeQuery query = currentSession.createNativeQuery(FIND_ANNOUNCEMENTS);
        query.addEntity(AnnouncementEntity.class);
        announcements = query.getResultList();

        endTransaction();
        return announcements;
    }

    public static List<AnnouncementEntity> getAnnouncementByCriterias(AnnouncementEntity announcementEntity) {
        startTransaction();
        List<AnnouncementEntity> announcements;
        Query query = currentSession.createQuery(QueryManager.buildSearchQuery(announcementEntity));
        announcements = query.getResultList();
        endTransaction();
        return announcements;
    }

    @SuppressWarnings("unchecked")
    public static List<byte[]> getImagesForAnnouncement(AnnouncementEntity announcementEntity) {
        startTransaction();
        List<byte[]> images;
        NativeQuery query = currentSession.createNativeQuery(FIND_IMAGES_FOR_ANNOUNCEMENT);
        query.setParameter(ID_PARAM, announcementEntity.getId());
        images = query.getResultList();

        endTransaction();
        return images;
    }

    public static boolean addUser(UserEntity userEntity) {
        startTransaction();
        NativeQuery query = currentSession.createNativeQuery(ADD_USER);
        query.setParameter(EMAIL_PARAM, userEntity.getEmailAddress());
        query.setParameter(PASSWORD_PARAM, userEntity.getPassword());
        boolean isCreated;
        try {
            isCreated = query.executeUpdate() == 1;
        } catch (ConstraintViolationException ve) {
            isCreated = false;
        } finally {
            endTransaction();
        }
        return isCreated;
    }

    public static boolean isAuthenticated(UserEntity userEntity) {
        startTransaction();
        NativeQuery query = currentSession.createNativeQuery(IS_AUTHENTIFIED);
        query.setParameter(EMAIL_PARAM, userEntity.getEmailAddress());
        query.setParameter(PASSWORD_PARAM, userEntity.getPassword());
        boolean isAuthenticated;
        try {
            isAuthenticated = query.getResultList().size() == 1;
        } catch (Exception e) {
            isAuthenticated = false;
        } finally {
            endTransaction();
        }

        return isAuthenticated;
    }

    public static void addAnnouncement(AnnouncementEntity announcementEntity, List<AnnouncementImagesEntity> imagesEntities) {
        startTransaction();
        persistAnnouncementEntity(announcementEntity);
        BigInteger newAnnouncementId = (BigInteger) currentSession.createSQLQuery(util.NativeQuery.LAST_INSERT_ID).uniqueResult();
        persistAnnouncementImages(newAnnouncementId, imagesEntities);
        endTransaction();
    }

    private static void persistAnnouncementEntity(AnnouncementEntity announcementEntity){
        NativeQuery query = currentSession.createNativeQuery(ADD_ANNOUNCEMENT);
        query.setParameter(TITLE_PARAM, announcementEntity.getTitle());
        query.setParameter(DESCRIPTION_PARAM, announcementEntity.getDescription());
        query.setParameter(BRAND_PARAM, announcementEntity.getBrand());
        query.setParameter(MODEL_PARAM, announcementEntity.getModel());
        query.setParameter(PRICE_PARAM, announcementEntity.getPrice());
        query.setParameter(FABRICATION_DATE_PARAM, announcementEntity.getFabricationDate());

        query.executeUpdate();
    }

    private static void persistAnnouncementImages(BigInteger newAnnouncementId, List<AnnouncementImagesEntity> imagesEntities){
        NativeQuery imageQuery = currentSession.createNativeQuery(ADD_IMAGE);
        imageQuery.setParameter(ID_PARAM, newAnnouncementId);

        for (AnnouncementImagesEntity announcementImagesEntity : imagesEntities) {
            imageQuery.setParameter(IMAGE_PARAM, announcementImagesEntity.getImage());
            imageQuery.executeUpdate();
        }
    }


    public static void deleteAnnouncement(String id) {
        startTransaction();
        NativeQuery query = currentSession.createNativeQuery(DELETE_ANNOUNCEMENT);
        query.setParameter(ID_PARAM, id);
        query.executeUpdate();
        endTransaction();
    }

    private static void startTransaction() {
        currentSession = HibernateSessionFactory.getInstance().openSession();
        currentSession.beginTransaction();
    }

    private static void endTransaction() {
        currentSession.getTransaction().commit();
        currentSession.close();
    }
}
