package util;

public abstract class NativeQuery {

    public final static String ADD_USER = "INSERT into user (email, password) VALUES (:email, :password)";
    public final static String IS_AUTHENTIFIED = "SELECT * FROM user where email = :email and password = :password";

    public final static String ADD_ANNOUNCEMENT = "INSERT INTO announcements(title, description, brand, model, price, fabrication_date)" +
            " VALUES (:title, :description, :brand, :model, :price, :fabricationDate)";
    public final static String FIND_ANNOUNCEMENT = "SELECT * FROM announcements WHERE id = :id";
    public final static String FIND_ANNOUNCEMENTS = "SELECT * FROM announcements";
    public final static String FIND_IMAGES_FOR_ANNOUNCEMENT = "SELECT ai.image FROM announcement_images ai JOIN " +
            "announcements a on ai.announcement_id = a.id WHERE ai.announcement_id = :id";
    public final static String DELETE_ANNOUNCEMENT = "DELETE FROM announcements WHERE id = :id";

    public final static String ADD_IMAGE = "INSERT INTO announcement_images(image, announcement_id) VALUES (:image, :id)";

    public final static String LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";

}
