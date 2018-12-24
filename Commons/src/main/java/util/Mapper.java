package util;

import dto.AnnouncementDto;
import dto.UserDto;
import models.AnnouncementModel;
import models.UserModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Mapper {

    public static UserDto transformUserModelToDto(UserModel userModel){
        UserDto userDto = new UserDto();
        userDto.setEmailAddress(userModel.getEmailAddress());
        userDto.setPassword(userModel.getPassword());

        return userDto;
    }

    public static List<AnnouncementModel> transformAnnouncementsDtosToModels(List<AnnouncementDto> announcementDtos){
        List<AnnouncementModel> announcementModels = new ArrayList<AnnouncementModel>();

        for (AnnouncementDto announcementDto: announcementDtos){
            announcementModels.add(transformAnnouncementDtoToModel(announcementDto));
        }

        return announcementModels;
    }

    public static AnnouncementDto transformAnnouncementModelToDto(AnnouncementModel announcementModel){

        AnnouncementDto announcementDto = new AnnouncementDto();

        announcementDto.setId(announcementModel.getId());
        announcementDto.setBrand(announcementModel.getBrand());
        announcementDto.setDescription(announcementModel.getDescription());
        announcementDto.setFabricationDate(announcementModel.getFabricationDate());
        announcementDto.setModel(announcementModel.getModel());

        if(announcementModel.getPrice() == null) {
            announcementDto.setPrice(Double.NaN);
        }
        else{
            announcementDto.setPrice(announcementModel.getPrice());
        }
        announcementDto.setTitle(announcementModel.getTitle());

        return announcementDto;
    }

    public static AnnouncementModel transformAnnouncementDtoToModel(AnnouncementDto announcementDto){
        AnnouncementModel announcementModel = new AnnouncementModel();

        announcementModel.setId(announcementDto.getId());
        announcementModel.setBrand(announcementDto.getBrand());
        announcementModel.setDescription(announcementDto.getDescription());
        announcementModel.setFabricationDate(announcementDto.getFabricationDate());
        announcementModel.setModel(announcementDto.getModel());
        announcementModel.setPrice(announcementDto.getPrice());
        announcementModel.setTitle(announcementDto.getTitle());
        announcementModel.setImages(StringUtils.getEncodedStringImages(announcementDto.getImagesStreams()));

        return announcementModel;
    }

    public static List<byte[]> transformMultiPartFilesToByteStreams(List<MultipartFile> files){
        List<byte[]> byteStreams = new ArrayList<byte[]>();

        for (MultipartFile file : files){
            byteStreams.add(transformMultiPartFileToByteStream(file));
        }

        return byteStreams;
    }

    private static byte[] transformMultiPartFileToByteStream(MultipartFile file){
        try {
            return file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
