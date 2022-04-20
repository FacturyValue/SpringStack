package tiny.angular.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tiny.angular.server.model.Server;

/**
 * @version V1.0
 * @Description:
 * @author: rudy
 * @date: 2022/4/18 18:08
 */
public interface ServerRepository extends JpaRepository<Server,Long> {

    Server findByIpAddress(String ipAddress);
}
