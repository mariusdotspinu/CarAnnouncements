package util;

import entity.AnnouncementImagesEntity;
import entity.AnnouncementEntity;
import entity.UserEntity;
import org.hibernate.cfg.Configuration;

abstract class ConfigurationUtil {
    static void loadEntityClasses(Configuration configuration){

        configuration.addAnnotatedClass(AnnouncementEntity.class);
        configuration.addAnnotatedClass(AnnouncementImagesEntity.class);
        configuration.addAnnotatedClass(UserEntity.class);
    }
}
