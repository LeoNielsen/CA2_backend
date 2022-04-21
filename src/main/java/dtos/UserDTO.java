package dtos;

import entities.AnimalImage;
import entities.Role;
import entities.User;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

public class UserDTO
{
    String userName;
    List<String> roles;
    String userPass;
    List<AnimalImageDTO> favoriteImages;

    public UserDTO(User user)
    {
        this.userName = user.getUserName();
        this.userPass = user.getUserPass();
        this.roles = getRoles(user.getRoleList());
        this.favoriteImages = getFavoriteImages(user.getFavoritesList());
    }

    public User toUser () {
        return new User(this.userName, this.userPass);
    }

    public List<String> getRoles(List<Role> roles){
        List<String> stringRoles = new ArrayList<>();
        for (Role role : roles)
        {
            stringRoles.add(role.getRoleName());
        }
        return stringRoles;
    }

    public List<AnimalImageDTO> getFavoriteImages(List<AnimalImage> images){
        List<AnimalImageDTO> fImages = new ArrayList<>();
        for (AnimalImage image : images) {
            fImages.add(new AnimalImageDTO(image.getId(), image.getURL()));
        }
        return fImages;
    }

    public List<AnimalImageDTO> getFavoriteImages() {
        return favoriteImages;
    }

    public void setFavoriteImages(List<AnimalImageDTO> favoriteImages) {
        this.favoriteImages = favoriteImages;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
