package facade;

import dto.UserDto;

public interface UserFacade {
    boolean createUser(UserDto userDto);
    boolean isAuthenticated(UserDto userDto);
}
