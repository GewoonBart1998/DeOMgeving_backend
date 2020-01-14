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
    public List<Experiment> retrieveAll(
            @QueryParam("filter") int from,
            @QueryParam("orderBy") String orderBy,
            @QueryParam("direction") String direction,
            @QueryParam("search") String search)

    {
        System.out.println("called");
        return service.getAll(from, orderBy, direction, search);
    }

    @GET
    @Path("/{id}")
    public Experiment retrieve(@PathParam("id") int id) {
        return service.find(id);
    }

    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") int id) {
        service.delete(id);
    }

    @POST
    @Path("/")
    public int insert(Experiment experiment) {
        return service.add(experiment);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") int id, Experiment experiment) {
        service.update(id, experiment);
    }


    // TODO improve this.
    //--------------------Order BY--------------------
    @GET
    @Path("/lastID")
    @JsonView(View.Public.class)
    public int lastID() {
        return service.getLastID();
    }

    @GET
    @Path("/orderNameAsc")
    @JsonView(View.Public.class)
    public List<Experiment> orderNameAsc() {
        return service.orderNameAsc();
    }

    @GET
    @Path("/orderNameDesc")
    @JsonView(View.Public.class)
    public List<Experiment> orderNameDesc() {
        return service.orderNameDesc();
    }

    @GET
    @Path("/orderLiederAsc")
    @JsonView(View.Public.class)
    public List<Experiment> orderLiederAsc() {
        return service.orderLiederAsc();
    }

    @GET
    @Path("/orderLiederDesc")
    @JsonView(View.Public.class)
    public List<Experiment> orderLiederDesc() {
        return service.orderLiederDesc();
    }

    @GET
    @Path("/orderEditedAsc")
    @JsonView(View.Public.class)
    public List<Experiment> orderEditedAsc() {
        return service.orderEditedAsc();
    }

    @GET
    @Path("/orderEditedDesc")
    @JsonView(View.Public.class)
    public List<Experiment> orderEditedDesc() {
        return service.orderEditedDesc();
    }

    //--------------------FILTERS--------------------

    @GET
    @Path("/filterIdee")
    @JsonView(View.Public.class)
    public List<Experiment> filterIdee() {
        return service.filterIdee();
    }

    @GET
    @Path("/filterLabIn")
    @JsonView(View.Public.class)
    public List<Experiment> filterLabIn() {
        return service.filterLabIn();
    }

    @GET
    @Path("/filterLabUit")
    @JsonView(View.Public.class)
    public List<Experiment> filterLabUit() {
        return service.filterLabUit();
    }

    @GET
    @Path("/filterGreen")
    @JsonView(View.Public.class)
    public List<Experiment> filterGreen() {
        return service.filterGreen();
    }

    @GET
    @Path("/filterOrange")
    @JsonView(View.Public.class)
    public List<Experiment> filterOrange() {
        return service.filterOrange();
    }

    @GET
    @Path("/filterRed")
    @JsonView(View.Public.class)
    public List<Experiment> filterRed() {
        return service.filterRed();
    }

    @GET
    @Path("/filterHoF")
    @JsonView(View.Public.class)
    public List<Experiment> filterHoF() {
        return service.filterHoF();
    }

    @GET
    @Path("/filterGY")
    @JsonView(View.Public.class)
    public List<Experiment> filterGY() {
        return service.filterGY();
    }

    @GET
    @Path("/filterSearch/{searchString}")
    @JsonView(View.Public.class)
    public List<Experiment> filterSearch(@PathParam("searchString") String searchString) {
        return service.filterSearch(searchString);
    }


}
