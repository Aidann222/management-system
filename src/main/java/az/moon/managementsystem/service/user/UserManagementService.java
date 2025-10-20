package az.moon.managementsystem.service.user;

import az.moon.managementsystem.dto.request.user.UserUpdateRequest;
import az.moon.managementsystem.dto.response.user.UserReadResponse;
import az.moon.managementsystem.dto.request.user.UserCreateRequest;
import az.moon.managementsystem.dto.response.user.UserCreateResponse;

import az.moon.managementsystem.dto.response.user.UserUpdateResponse;
import java.util.List;

public interface UserManagementService {

    UserCreateResponse createUserManagement(UserCreateRequest userCreateRequest);

    List<UserReadResponse> getAllUsers();

    UserReadResponse getUserById(Long userId);

    UserUpdateResponse updateUser(Long userId, UserUpdateRequest updateRequest);

    void deleteUser(Long userId);

}