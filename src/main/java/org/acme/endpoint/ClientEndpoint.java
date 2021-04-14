package org.acme.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.model.Client;
import org.acme.model.Client.Address;
import org.acme.model.Client.Car;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/clients")
@Tag(name = "Clients")
@RequestScoped
public class ClientEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(ClientEndpoint.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Operation(summary = "List Clients", description = "List all Clients")
    @APIResponse(responseCode = "200", description = "Clients", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Client[].class)) })
    public Response getClients() {

        LOG.debug("GET");

        List<Client> listClient = new ArrayList<>();

        listClient.add(new Client("John Smith", new Car("BMW", 2020), new Address("New York", 10)));

        listClient.add(new Client("Barbara", new Car("Porsche", 2018), new Address("Brasília", 22)));

        listClient.add(new Client("Karl", new Car("Fusca", 1990), new Address("London", 44)));

        Client[] response = listClient.toArray(new Client[0]);

        Jsonb jsonb = JsonbBuilder.create();
        String jsonString = jsonb.toJson(response);

        LOG.debug("GET - response: " + jsonString);

        return Response.status(Response.Status.OK).entity(response).build();

    }

}
