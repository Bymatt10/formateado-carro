package com.rapidfix;

import com.rapidfix.dto.FormatDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/format")
public class FormatController {

    @Inject
    FormatServices formatService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/text")
    public String format(FormatDto formatDto) {
        return formatService.formatText(formatDto);
    }


}
