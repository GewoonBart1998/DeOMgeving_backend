package org.example.resource;

import com.fasterxml.jackson.annotation.JsonView;
import org.example.View;
import org.example.model.Experiment;
import org.example.model.ExperimentDetails;
import org.example.service.ExperimentService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

/**
 * @author Stefan, Bart
 */
@Singleton
@Path("/experimenten")
@Produces(MediaType.APPLICATION_JSON)
public class ExperimentResource {

    private final ExperimentService service;

    @Inject
    public ExperimentResource(ExperimentService service) {
        this.service = service;
    }

    @GET
    @Path("/")
    public List<Experiment> retrieveAll() {
        System.out.println("called");
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public Experiment retrieve(@PathParam("id") int id)
    {
        return service.find(id);
    }

    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }

    @POST
    @Path("/")
    public int insert(Experiment experiment)
    {
        return service.add(experiment);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") int id, Experiment experiment)
    {
        service.update(id, experiment);
    }


    @GET
    @Path("/lastID")
    @JsonView(View.Public.class)
    public int lastID(){
        return service.getLastID();
    }

    //--------------------Order BY--------------------

    @GET
    @Path("/orderBy/{attribute}/{order}")
    @JsonView({View.Public.class})
    public List <Experiment> orderBy(@PathParam("attribute") String attribute, @PathParam("order") String order){
        return service.orderBy(attribute, order);
    }

    //--------------------FILTERS--------------------

        @GET
    @Path("/filter/{filter}/{value}")
    @JsonView(View.Public.class)
    public List<Experiment> filterIdee(@PathParam("filter") String filter, @PathParam("value") String value){
        if (!filter.equals("archive")) {
            return service.filter(filter, value);
        }
        else {
            return service.archive(value);
        }

    }

    //--------------------SEARCH--------------------

    @GET
    @Path("/filterSearch/{searchString}")
    @JsonView(View.Public.class)
    public List<Experiment> filterSearch(@PathParam("searchString") String searchString){
        return service.filterSearch(searchString);
    }







}
