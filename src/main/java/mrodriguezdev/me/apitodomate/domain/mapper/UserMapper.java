package mrodriguezdev.me.apitodomate.domain.mapper;

import mrodriguezdev.me.apitodomate.domain.model.orm.User;
import mrodriguezdev.me.apitodomate.domain.model.user.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "jakarta")
public interface UserMapper {

    UserDTO toDTO(User user);
    List<UserDTO> toLstDTO(List<User> lstUsers);

    User toEntity(UserDTO userDTO);
    List<User> toLstEntity(List<UserDTO> lstUsersDTO);
}
