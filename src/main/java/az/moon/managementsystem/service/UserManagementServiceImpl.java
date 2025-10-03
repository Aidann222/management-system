package az.moon.managementsystem.service;


import az.moon.managementsystem.dto.UserReadResponse;
import az.moon.managementsystem.dto.request.UserCreateRequest;
import az.moon.managementsystem.dto.response.UserCreateResponse;
import az.moon.managementsystem.entity.User;
import az.moon.managementsystem.repository.UserManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManagementServiceImpl implements UserManagementService {
    private final UserManagementRepository userManagementRepository;

    @Override
    public UserCreateResponse createUserManagement(UserCreateRequest userCreateRequest) {
        User user = new User();
        user.setUsername(userCreateRequest.getUsername());
        user.setPassword(userCreateRequest.getPassword());
        user.setEmail(userCreateRequest.getEmail());
        user.setPhoneNumber(userCreateRequest.getPhoneNumber());
        user.setCreated(userCreateRequest.getCreated());
        user.setCreatedBy(userCreateRequest.getCreatedBy());
        user.setModifiedBy(userCreateRequest.getModifiedBy());
        user.setModified(userCreateRequest.getModified());

        User saveUser = userManagementRepository.save(user); // sual

        UserCreateResponse userCreateResponse = new UserCreateResponse();

        userCreateResponse.setId(saveUser.getId());
        userCreateResponse.setUsername(saveUser.getUsername());
        userCreateResponse.setPassword(saveUser.getPassword());
        userCreateResponse.setEmail(saveUser.getEmail());
        userCreateResponse.setPhoneNumber(saveUser.getPhoneNumber());
        userCreateResponse.setCreated(saveUser.getCreated());
        userCreateResponse.setCreatedBy(saveUser.getCreatedBy());
        userCreateResponse.setModified(saveUser.getModified());
        userCreateResponse.setModifiedBy(saveUser.getModifiedBy());


        return userCreateResponse;
    }

    @Override
    public List<UserReadResponse> getAllUsers() {
        List<User> users = userManagementRepository.findAll();

        List<UserReadResponse> result = new ArrayList<>();

        for(User user : users) {
            UserReadResponse userReadResponse = new UserReadResponse();
            userReadResponse.setUsername(user.getUsername());
            userReadResponse.setEmail(user.getEmail());
            userReadResponse.setCreated(user.getCreated());
            userReadResponse.setModified(user.getModified());

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
        response.setCreated(optionalUser.get().getCreated());
        response.setModified(optionalUser.get().getModified());

        return response;
    }
}
