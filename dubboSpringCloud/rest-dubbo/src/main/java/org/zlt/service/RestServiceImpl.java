package org.zlt.service;

import org.apache.dubbo.config.annotation.Service;

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
@Service(protocol = "rest",version = "xbh")
public class RestServiceImpl implements RestService {
    @Override
    public String test() {
        return "rest service: ";
    }
}
