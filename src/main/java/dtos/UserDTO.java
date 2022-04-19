package dtos;

import entities.Role;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTO
{
    String userName;
    List<String> roles;

    public UserDTO(User user)
    {
        this.userName = user.getUserName();
        this.roles = getRoles(user.getRoleList());
    }

    public List<String> getRoles(List<Role> roles){
        List<String> stringRoles = new ArrayList<>();
        for (Role role : roles)
        {
            stringRoles.add(role.getRoleName());
        }
        return stringRoles;
    }
}
