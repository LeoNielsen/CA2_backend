package rest;

import com.google.gson.Gson;
import dtos.CatImageDTO;
import utils.HttpUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("cat")
public class CatResource
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cat")
    public String getCat() throws IOException
    {
        Gson GSON = new Gson();
        String catImage = HttpUtils.fetchData("https://cataas.com/cat?json=true");
        System.out.println(catImage);
        CatImageDTO catImageDTO = GSON.fromJson(catImage, CatImageDTO.class);
        //CatDTO catDTO = new CatDTO(factDTO, catImageDTO);
        catImageDTO.setUrl("https://cataas.com"+catImageDTO.getUrl());
        String result = GSON.toJson(catImageDTO);
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("facts")
    public String getCatFact() throws IOException
    {
        return HttpUtils.fetchData("https://catfact.ninja/fact");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cats")
    public String getCatPictures() throws IOException
    {
        return HttpUtils.fetchData("https://api.thecatapi.com/v1/images/search");
    }
}