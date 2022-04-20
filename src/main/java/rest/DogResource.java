package rest;

import com.google.gson.Gson;
import dtos.*;
import utils.HttpUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("dog")
public class DogResource {

    Gson GSON = new Gson();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("dog")
    public String getDog() throws IOException
    {
        String fact = HttpUtils.fetchData("https://dog-api.kinduff.com/api/facts");
        DogFactDTO factDTO = GSON.fromJson(fact, DogFactDTO.class);
        String dogImage = HttpUtils.fetchData("https://api.thedogapi.com/v1/images/search");
        AnimalImageDTO[] dogImageDTO = GSON.fromJson(dogImage, AnimalImageDTO[].class);
        DogDTO dogDTO = new DogDTO(factDTO, dogImageDTO[0]);
        return GSON.toJson(dogDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("facts")
    public String getDogFact() throws IOException
    {
        String fact = HttpUtils.fetchData("https://dog-api.kinduff.com/api/facts");
        DogFactDTO factDTO = GSON.fromJson(fact, DogFactDTO.class);
        return GSON.toJson(factDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("dogs")
    public String getDogPictures() throws IOException
    {
        String dogImage = HttpUtils.fetchData("https://api.thedogapi.com/v1/images/search");
        AnimalImageDTO[] dogImageDTO = GSON.fromJson(dogImage, AnimalImageDTO[].class);
        return GSON.toJson(dogImageDTO);
    }



}
