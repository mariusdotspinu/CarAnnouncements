package db;

import entity.AnnouncementEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static db.DbAccess.currentSession;

class QueryManager {

    static final String TITLE_PARAM = "title";
    static final String DESCRIPTION_PARAM = "description";
    static final String BRAND_PARAM ="brand";
    static final String MODEL_PARAM = "model";
    static final String PRICE_PARAM = "price";
    static final String FABRICATION_DATE_PARAM = "fabricationDate";

    static final String EMAIL_PARAM = "email";
    static final String PASSWORD_PARAM = "password";

    static final String ID_PARAM = "id";
    static final String IMAGE_PARAM = "image";

    private static final String WILDCARD = "%";


    static CriteriaQuery<AnnouncementEntity> buildSearchQuery(AnnouncementEntity announcementEntity) {

        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<AnnouncementEntity> criteriaQuery = criteriaBuilder.createQuery(AnnouncementEntity.class);
        Root<AnnouncementEntity> root = criteriaQuery.from(AnnouncementEntity.class);

        String brand = announcementEntity.getBrand();
        String model = announcementEntity.getModel();
        Date fabricationDate = announcementEntity.getFabricationDate();

        double price = announcementEntity.getPrice();

        criteriaQuery.select(root);
        List<Predicate> predicates = new ArrayList<Predicate>();

        if (!brand.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.<String>get(BRAND_PARAM), brand + WILDCARD));
        }
        if (!model.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.<String>get(MODEL_PARAM), model + WILDCARD));
        }
        if (!Double.isNaN(price)) {
            predicates.add(criteriaBuilder.lt(root.<Double>get(PRICE_PARAM), price));
        }

        if (fabricationDate != null) {
            predicates.add(criteriaBuilder.equal(root.get(FABRICATION_DATE_PARAM), fabricationDate));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        return criteriaQuery;
    }


}
