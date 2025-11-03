package az.moon.managementsystem.mapper;

import az.moon.managementsystem.dto.request.user.UserCreateRequest;
import az.moon.managementsystem.dto.request.user.UserUpdateRequest;
import az.moon.managementsystem.dto.response.user.UserCreateResponse;
import az.moon.managementsystem.dto.response.user.UserReadResponse;
import az.moon.managementsystem.dto.response.user.UserUpdateResponse;
import az.moon.managementsystem.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    // todo mapping response case... response request -> entity / entity -> response response

    // todo requestin icindeki userEmail -> email
    @Mapping(source = "userEmail", target = "email")
    User createRequestToEntity(UserCreateRequest createRequest);

    UserCreateResponse entityToCreateResponse(User user);

    List<UserReadResponse> toReadResponse(List<User> users);

    User updateUserFromRequest(UserUpdateRequest updateRequest);

    UserUpdateResponse entityToUpdateResponse(User user);

    UserReadResponse toReadResponse(User user);





}