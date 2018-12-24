package entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "announcement_images")
public class AnnouncementImagesEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Lob
    @Column(name = "image")
    private byte[] image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
