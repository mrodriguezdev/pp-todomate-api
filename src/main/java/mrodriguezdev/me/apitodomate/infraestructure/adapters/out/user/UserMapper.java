package mrodriguezdev.me.apitodomate.infraestructure.adapters.out.user;

import mrodriguezdev.me.apitodomate.domain.model.user.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface UserMapper {

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
}
