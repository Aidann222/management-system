package az.moon.managementsystem.controller;



import az.moon.managementsystem.dto.UserReadResponse;
import az.moon.managementsystem.dto.request.UserCreateRequest;
import az.moon.managementsystem.dto.response.UserCreateResponse;
import az.moon.managementsystem.service.UserManagementService;
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
    public UserCreateResponse createUserManagement(@RequestBody UserCreateRequest userCreateRequest) {
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




}
