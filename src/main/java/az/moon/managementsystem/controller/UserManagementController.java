package az.moon.managementsystem.controller;

import az.moon.managementsystem.dto.request.user.UserUpdateRequest;
import az.moon.managementsystem.dto.response.user.UserReadResponse;
import az.moon.managementsystem.dto.request.user.UserCreateRequest;
import az.moon.managementsystem.dto.response.user.UserCreateResponse;
import az.moon.managementsystem.dto.response.user.UserUpdateResponse;
import az.moon.managementsystem.service.user.UserManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserManagementController {

    private final UserManagementService userManagementService;

    @PostMapping("/save")
   // @ResponseStatus()
    public UserCreateResponse createUserManagement(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        return userManagementService.createUserManagement(userCreateRequest);
    }

    @GetMapping("/all")
    public List<UserReadResponse> getAllUserManagement() {
        return userManagementService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserReadResponse getUserManagement(@PathVariable(name = "userId") Long userId) {
        return userManagementService.getUserById(userId);
    } // name = "userId" ile ferqi

    @PutMapping("/update/{userId}")
    public UserUpdateResponse updateUser(@PathVariable(name = "userId") Long userId,
                                         @RequestBody UserUpdateRequest updateRequest) {
        return userManagementService.updateUser(userId, updateRequest);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userManagementService.deleteUser(userId);
    }

}