package ait.wordcards.security.user;

import ait.wordcards.security.role.IRoleService;
import ait.wordcards.security.role.Role;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository repository;
    private final IRoleService roleService;
    private final BCryptPasswordEncoder encoder;
    private final ModelMapper mapper;

    @Override
    public List<UserResponseDto> getUsers() {
        return List.of();
    }

    @Override
    public UserResponseDto createUser(UserRequestDto dto) {

        //проверяем существование пользователя с таким именем, если он есть, то выкидываем exception
        repository.findUserByName(dto.getName()).ifPresent(u -> {
            throw new RuntimeException("User " + dto.getName() + "already exist");
        });

//        получаем роль из базы
        Role role = roleService.getRoleByTitle("ROLE_USER");

//        кодируем пароль
        String encodedPass = encoder.encode(dto.getPassword());

//        создаем пользователя
        User newUser = new User(null, dto.getName(), dto.getEmail(), encodedPass, Collections.singleton(role));

//        сохраняем его в репо
        repository.save(newUser);

        return mapper.map(newUser, UserResponseDto.class);
    }

    @Override
    public UserResponseDto setAdminRole(String username) {
        return null;
    }

    //как spring получает User по логину
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        return repository.findUserByName(name).orElseThrow(() -> new UsernameNotFoundException("User with name: " + name + " not found"));
    }


}
