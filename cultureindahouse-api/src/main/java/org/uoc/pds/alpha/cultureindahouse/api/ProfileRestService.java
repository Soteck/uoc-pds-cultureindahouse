package org.uoc.pds.alpha.cultureindahouse.api;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.ProfileLocal;

@Path("/profile")
@Produces(MediaType.APPLICATION_JSON)
public class ProfileRestService {

    @EJB
    private ProfileLocal profileLocal;

    

}
