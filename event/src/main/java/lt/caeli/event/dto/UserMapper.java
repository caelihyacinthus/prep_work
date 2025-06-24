package lt.caeli.event.dto;

import lt.caeli.event.model.User;

public class UserMapper {
    public static User toUser(UserRequestDTO userRequestDTO) {
        return new User(userRequestDTO.username(), userRequestDTO.password(), userRequestDTO.roles());
    }

//    public static UserEventResponseDTO toUserEventResponseDTO(User user) {
//        return new UserEventResponseDTO(user.getId(), user.getUsername());
//    }

//    public static List<UserEventResponseDTO> toUserEventResponseDTOList(List<User> users) {
//        List<UserEventResponseDTO> usersDTO = new ArrayList<>();
//        for (User u : users) {
//            usersDTO.add(toUserEventResponseDTO(u));
//        }
//        return usersDTO;
//    }

    public static UserResponseDTO toUserResponseDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getUsername(), user.getRoles());
    }
}
