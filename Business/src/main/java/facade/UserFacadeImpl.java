package facade;

import dao.UserDaoImpl;
import dto.UserDto;

public class UserFacadeImpl implements UserFacade {
    public boolean createUser(UserDto userDto) {
        return new UserDaoImpl().createUser(userDto);
    }
    public boolean isAuthenticated(UserDto userDto) {
        return new UserDaoImpl().isAuthenticated(userDto);
    }
}
