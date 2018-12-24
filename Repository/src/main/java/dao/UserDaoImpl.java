package dao;

import db.DbAccess;
import dto.UserDto;
import util.DbMapper;

public class UserDaoImpl implements UserDao {

    public boolean createUser(UserDto userDto) {
        return DbAccess.addUser(DbMapper.transformUserDtoToEntity(userDto));
    }

    public boolean isAuthenticated(UserDto userDto) {
        return DbAccess.isAuthenticated(DbMapper.transformUserDtoToEntity(userDto));
    }
}
