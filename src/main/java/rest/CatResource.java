package rest;

import com.google.gson.Gson;
import utils.HttpUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("cat")
public class CatResource
{

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