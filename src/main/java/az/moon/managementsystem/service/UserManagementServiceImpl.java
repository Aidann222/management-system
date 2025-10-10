package az.moon.managementsystem.service;

import az.moon.managementsystem.contains.ManagementContains;
import az.moon.managementsystem.dto.request.UserCreateRequest;
import az.moon.managementsystem.dto.request.UserUpdateRequest;
import az.moon.managementsystem.dto.response.UserCreateResponse;
import az.moon.managementsystem.dto.response.UserReadResponse;
import az.moon.managementsystem.dto.response.UserUpdateResponse;
import az.moon.managementsystem.entity.User;
import az.moon.managementsystem.exception.exits.AlreadyExistsException;
import az.moon.managementsystem.exception.notfound.UserNotFoundException;
import az.moon.managementsystem.mapper.UserMapper;
import az.moon.managementsystem.repository.UserManagementRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManagementServiceImpl implements UserManagementService {

    private final UserManagementRepository userManagementRepository;
    private final UserMapper userMapper;

    @Override
    public UserCreateResponse createUserManagement(UserCreateRequest userCreateRequest) {
        Optional<User> optionalUser = userManagementRepository.findByEmail(userCreateRequest.getUserEmail());
        if(optionalUser.isEmpty()){

            User user = userMapper.createRequestToEntity(userCreateRequest);

            User saveUser = userManagementRepository.save(user);

            return userMapper.entityToCreateResponse(saveUser);

        }
            throw new AlreadyExistsException(ManagementContains.ALREADY_EXISTS);
    }

    @Override
    public List<UserReadResponse> getAllUsers() {
        List<User> users = userManagementRepository.findAll();

        return userMapper.toReadResponse(users);
    }

    @Override
    public UserReadResponse getUserById(Long userId) {
        User user = userManagementRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(ManagementContains.USER_NOT_FOUND));

        return userMapper.toReadResponse(user);
    }

    @Override
    public UserUpdateResponse updateUser(Long userId, UserUpdateRequest updateRequest) {

        // todo : burada tapmaq istediyim user idi ve tapdim...
        User user = userManagementRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(ManagementContains.USER_NOT_FOUND));

        // todo : deyismeye calisdigim idi deyisdim...
        User updatedUser = userMapper.updateUserFromRequest(updateRequest);

        // todo ; tam hazir ve deyisdiyim user
        updatedUser.setId(user.getId());

        // todo : save icinde olan user nedir ?
        User savedUser = userManagementRepository.save(updatedUser);

        return userMapper.entityToUpdateResponse(savedUser);
    }

    @Override
    public void deleteUser(Long userId) { // 3
        User foundedUser = userManagementRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(ManagementContains.USER_NOT_FOUND));
        userManagementRepository.deleteById(foundedUser.getId()); // 3
    }

}