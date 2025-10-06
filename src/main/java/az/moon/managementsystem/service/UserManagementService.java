package az.moon.managementsystem.service;

import az.moon.managementsystem.dto.request.UserUpdateRequest;
import az.moon.managementsystem.dto.response.UserReadResponse;
import az.moon.managementsystem.dto.request.UserCreateRequest;
import az.moon.managementsystem.dto.response.UserCreateResponse;

import az.moon.managementsystem.dto.response.UserUpdateResponse;
import java.util.List;

public interface UserManagementService {

    UserCreateResponse createUserManagement(UserCreateRequest userCreateRequest);

    List<UserReadResponse> getAllUsers();

    UserReadResponse getUserById(Long userId);

    UserUpdateResponse updateUser(Long userId, UserUpdateRequest updateRequest);

    void deleteUser(Long userId);

}