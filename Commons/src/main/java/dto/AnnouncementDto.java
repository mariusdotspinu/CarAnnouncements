package dto;

import java.util.Date;
import java.util.List;

public class AnnouncementDto {

    private String id;

    private String brand;

    private String model;

    private String description;

    private String title;

    private Date fabricationDate;

    private List<byte[]> imagesStreams;

    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getFabricationDate() {
        return fabricationDate;
    }

    public void setFabricationDate(Date fabricationDate) {
        this.fabricationDate = fabricationDate;
    }

    public List<byte[]> getImagesStreams() {
        return imagesStreams;
    }

    public void setImagesStreams(List<byte[]> imagesStreams) {
        this.imagesStreams = imagesStreams;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
