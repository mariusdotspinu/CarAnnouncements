package util;

import dto.AnnouncementDto;
import dto.UserDto;
import entity.AnnouncementEntity;
import entity.AnnouncementImagesEntity;
import entity.UserEntity;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DbMapper {


    public static UserEntity transformUserDtoToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmailAddress(userDto.getEmailAddress());
        userEntity.setPassword(userDto.getPassword());

        return userEntity;
    }

    public static AnnouncementEntity transformAnnouncementDtoToEntity(AnnouncementDto announcementDto) {
        AnnouncementEntity announcementEntity = new AnnouncementEntity();

        announcementEntity.setId(announcementDto.getId());
        announcementEntity.setBrand(announcementDto.getBrand());
        announcementEntity.setDescription(announcementDto.getDescription());
        java.util.Date fabricationDateDto = announcementDto.getFabricationDate();
        if (fabricationDateDto != null) {
            announcementEntity.setFabricationDate(new Date(fabricationDateDto.getTime()));
        }
        announcementEntity.setModel(announcementDto.getModel());
        announcementEntity.setTitle(announcementDto.getTitle());
        announcementEntity.setPrice(announcementDto.getPrice());

        return announcementEntity;
    }

    public static AnnouncementDto transformAnnouncementEntityToDto(AnnouncementEntity announcementEntity) {
        AnnouncementDto announcementDto = new AnnouncementDto();

        announcementDto.setId(announcementEntity.getId());
        announcementDto.setBrand(announcementEntity.getBrand());
        announcementDto.setDescription(announcementEntity.getDescription());
        announcementDto.setFabricationDate(announcementEntity.getFabricationDate());
        announcementDto.setModel(announcementEntity.getModel());
        announcementDto.setTitle(announcementEntity.getTitle());
        announcementDto.setPrice(announcementEntity.getPrice());

        return announcementDto;
    }

    public static List<AnnouncementImagesEntity> transformAnnouncementDtoImagesToAnnouncementImagesEntities(List<byte[]> imageStreams) {
        List<AnnouncementImagesEntity> imagesEntities = new ArrayList<AnnouncementImagesEntity>();
        for (byte[] stream : imageStreams) {
            AnnouncementImagesEntity announcementImagesEntity = new AnnouncementImagesEntity();
            announcementImagesEntity.setImage(stream);
            imagesEntities.add(announcementImagesEntity);
        }
        return imagesEntities;
    }
}
