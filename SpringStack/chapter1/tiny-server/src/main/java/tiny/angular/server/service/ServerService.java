package tiny.angular.server.service;

import tiny.angular.server.model.Server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;

/**
 * @version V1.0
 * @Description:
 * @author: rudy
 * @date: 2022/4/18 18:10
 */
public interface ServerService {

    Server create(Server server);

    Server ping(String ipAddress) throws UnknownHostException, IOException;

    Collection<Server> list(int limit);

    Server get(Long id);

    Server update(Server server);

    Boolean delete(Long id);
}
