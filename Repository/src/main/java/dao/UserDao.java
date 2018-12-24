package dao;


import dto.UserDto;

public interface UserDao {

    boolean createUser(UserDto userEntity);
    boolean isAuthenticated(UserDto userEntity);
}
