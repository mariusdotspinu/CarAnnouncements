package facade;

import dao.AnnouncementDao;
import dao.AnnouncementDaoImpl;
import db.DbAccess;
import dto.AnnouncementDto;
import entity.AnnouncementEntity;
import util.DbMapper;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementFacadeImpl implements AnnouncementFacade {
    public void createAnnouncement(AnnouncementDto announcementDto) {
        new AnnouncementDaoImpl().createAnnouncement(DbMapper.transformAnnouncementDtoToEntity(announcementDto),
                DbMapper.transformAnnouncementDtoImagesToAnnouncementImagesEntities(announcementDto.getImagesStreams()));
    }

    public void deleteAnnouncement(String id) {
        new AnnouncementDaoImpl().deleteAnnouncement(id);
    }

    public AnnouncementDto getAnnouncement(String announcementId) {
        return getDtoAnnouncement(new AnnouncementDaoImpl().getAnnouncement(announcementId));
    }


    public List<AnnouncementDto> getAllAnnouncements() {
        return getDtoAnnouncements(new AnnouncementDaoImpl().getAllAnnouncements());
    }

    public List<AnnouncementDto> getAnnouncementsByCriterias(AnnouncementDto announcementDto) {
        return getDtoAnnouncements(
                new AnnouncementDaoImpl().getAnnouncementByCriterias(DbMapper.transformAnnouncementDtoToEntity(announcementDto)));
    }

    private List<AnnouncementDto> getDtoAnnouncements(List<AnnouncementEntity> carAnnouncementEntities) {
        List<AnnouncementDto> announcementDtos = new ArrayList<AnnouncementDto>();

        for (AnnouncementEntity announcementEntity : carAnnouncementEntities) {
            announcementDtos.add(getDtoAnnouncement(announcementEntity));
        }
        return announcementDtos;
    }

    private AnnouncementDto getDtoAnnouncement(AnnouncementEntity announcementEntity){
        AnnouncementDao announcementDao = new AnnouncementDaoImpl();
        AnnouncementDto announcementDto = DbMapper.transformAnnouncementEntityToDto(announcementEntity);
        announcementDto.setImagesStreams(announcementDao.getImagesForAnnouncementEntity(announcementEntity));

        return announcementDto;
    }

}
