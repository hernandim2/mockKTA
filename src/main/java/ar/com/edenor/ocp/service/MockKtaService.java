package ar.com.edenor.ocp.service;

import ar.com.edenor.ocp.model.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
public interface MockKtaService {
    @POST
    @Path("/mockKTA")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response mockService(ModelRequestKta modelRequestKta);
}


