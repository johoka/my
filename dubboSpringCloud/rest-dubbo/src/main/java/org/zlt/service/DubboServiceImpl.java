package org.zlt.service;

import org.apache.dubbo.config.annotation.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author zlt
 * @date 2020/6/26
 * <p>
 * Blog: https://zlt2000.gitee.io
 * Github: https://github.com/zlt2000
 */
@Service(protocol = "rest",version = "xbh1")
@Path("/")
public class DubboServiceImpl implements DubboService {
    @Override
    @Path("xbh1/{p}")
    @GET
    public String test(String param) {
        return "dubbo service: " + param;
    }
}
