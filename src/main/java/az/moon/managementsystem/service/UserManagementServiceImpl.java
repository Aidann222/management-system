package az.moon.managementsystem.service;

import az.moon.managementsystem.contains.ManagementContains;
import az.moon.managementsystem.dto.request.UserCreateRequest;
import az.moon.managementsystem.dto.request.UserUpdateRequest;
import az.moon.managementsystem.dto.response.UserCreateResponse;
import az.moon.managementsystem.dto.response.UserReadResponse;
import az.moon.managementsystem.dto.response.UserUpdateResponse;
import az.moon.managementsystem.entity.User;
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
            // todo :  burada normal already adinda exception atmaq lazimdir..
            throw new RuntimeException("User already exists");
    }

    @Override
    public List<UserReadResponse> getAllUsers() {
        List<User> users = userManagementRepository.findAll();

        List<UserReadResponse> result = new ArrayList<>();

        for(User user : users) {
            // todo : burada mapper istifade et.. user entity`den (source) userReadResponse (target) tipine..
            UserReadResponse userReadResponse = new UserReadResponse();
            userReadResponse.setUsername(user.getUsername());
            userReadResponse.setEmail(user.getEmail());
//            userReadResponse.setCreated(user.getCreated());
//            userReadResponse.setModified(user.getModified());

            result.add(userReadResponse);
        }
        return result;
    }

    @Override
    public UserReadResponse getUserById(Long userId) {
        Optional<User> optionalUser = userManagementRepository.findById(userId);
        if(optionalUser.isEmpty())
            return new UserReadResponse();
        UserReadResponse response = new UserReadResponse();
        response.setUsername(optionalUser.get().getUsername());
        response.setEmail(optionalUser.get().getEmail());
//        response.setCreated(optionalUser.get().getCreated());
//        response.setModified(optionalUser.get().getModified());

        return response;
    }

    @Override
    public UserUpdateResponse updateUser(Long userId, UserUpdateRequest updateRequest) {
        // todo : mapping tetbiq et..
        User user = userManagementRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(ManagementContains.USER_NOT_FOUND));

        user.setUsername(updateRequest.getUsername());
        user.setPassword(updateRequest.getPassword());
        user.setEmail(updateRequest.getEmail());
        user.setPhoneNumber(updateRequest.getPhoneNumber());

        User savedUser = userManagementRepository.save(user);

        return UserUpdateResponse.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .username(savedUser.getUsername())
                .password(savedUser.getPassword())
                .phoneNumber(savedUser.getPhoneNumber())
//                .modified(savedUser.getModified())
//                .modifiedBy(savedUser.getModifiedBy())
                .build();
    }

    @Override
    public void deleteUser(Long userId) { // 3
        User foundedUser = userManagementRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(ManagementContains.USER_NOT_FOUND));
        userManagementRepository.deleteById(foundedUser.getId()); // 3
    }

}