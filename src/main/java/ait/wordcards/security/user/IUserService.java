package ait.wordcards.security.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public List<UserResponseDto> getUsers();
    public UserResponseDto createUser(UserRequestDto dto);
    public UserResponseDto setAdminRole(String username);
}
