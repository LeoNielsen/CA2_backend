package rest;

import com.google.gson.Gson;
import dtos.AnimalImageDTO;
import dtos.UserDTO;
import entities.AnimalImage;
import entities.User;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import facades.UserFacade;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class UserResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    @Context
    private UriInfo context;
    Gson GSON = new Gson();
    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    //Just to verify if the database is setup
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allUsers() {

        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("select u from User u", entities.User.class);
            List<User> users = query.getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed({"user"})
    public String getFromUser() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to User: " + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("userinfo")
    @RolesAllowed({"user", "admin"})
    public String getUserName() {
        String thisuser = securityContext.getUserPrincipal().getName();
        EntityManager em = EMF.createEntityManager();
        User currentUser = em.find(User.class, thisuser);
        UserDTO userDTO = new UserDTO(currentUser);
        return GSON.toJson(userDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("favorites")
    @RolesAllowed({"user", "admin"})
    public String getFavorites() {
        String thisuser = securityContext.getUserPrincipal().getName();
        EntityManager em = EMF.createEntityManager();
        User currentUser = em.find(User.class, thisuser);
        UserDTO userDTO = new UserDTO(currentUser);
        return GSON.toJson(userDTO.getFavoriteImages());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("newuser")
    public String addNewUser(String data) {
        UserDTO userDTO = GSON.fromJson(data, UserDTO.class);
        User user = userDTO.toUser();

        User user1 = UserFacade.getUserFacade(EMF).registerNewUser(user);
        return GSON.toJson(user1);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addfavorite")
    @RolesAllowed({"user", "admin"})
    public String addFavorite(String data) {
        //todo: overflowError?

        System.out.println("data: " + data);
        AnimalImageDTO animalImageDTO = GSON.fromJson(data, AnimalImageDTO.class);

        System.out.println(animalImageDTO.getId());

        String thisuser = securityContext.getUserPrincipal().getName();
        EntityManager em = EMF.createEntityManager();
        User currentUser = em.find(User.class, thisuser);

        User user = UserFacade.getUserFacade(EMF).addAnimalImage(currentUser, new AnimalImage(animalImageDTO.getId(), animalImageDTO.getUrl()));

        return GSON.toJson(user);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("removefavorite")
    @RolesAllowed({"user", "admin"})
    public String removeFavorite(String data) {
        System.out.println(data);
        AnimalImageDTO animalImageDTO = GSON.fromJson(data, AnimalImageDTO.class);
        System.out.println(animalImageDTO.getId());

        String thisuser = securityContext.getUserPrincipal().getName();
        EntityManager em = EMF.createEntityManager();
        User currentUser = em.find(User.class, thisuser);

        UserFacade.getUserFacade(EMF).removeFavorite(currentUser, new AnimalImage(animalImageDTO.getId(), animalImageDTO.getUrl()));

        return GSON.toJson(currentUser);
    }


}