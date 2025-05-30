package com.odigeo.rover.controller.provider;

import com.odigeo.rover.contract.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {

    private static final Logger logger = LoggerFactory.getLogger(RuntimeExceptionMapper.class);

    @Override
    public Response toResponse(RuntimeException e) {
        logger.error("Unhandled error: ", e);
        ErrorResponse error = new ErrorResponse(e.getClass().getSimpleName(), e.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }

}
