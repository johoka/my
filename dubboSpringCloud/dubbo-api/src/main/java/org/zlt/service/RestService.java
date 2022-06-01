package org.zlt.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author zlt
 * @date 2020/6/26
 * <p>
 * Blog: https://zlt2000.gitee.io
 * Github: https://github.com/zlt2000
 */
@Path("/")
public interface RestService {
//    @Path("test/{p}")
//    @GET
//    String test(@PathParam("p") String param);    @Path("test/{p}")
//    @GET
//    String test(@PathParam("p") String param);

    @Path("test")
    @GET
    String test();
}
