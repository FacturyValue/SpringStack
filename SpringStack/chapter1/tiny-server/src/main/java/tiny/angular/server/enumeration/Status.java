package tiny.angular.server.enumeration;

/**
 * @version V1.0
 * @Description:
 * @author: rudy
 * @date: 2022/4/18 18:00
 */
public enum Status {
    SERVER_UP("SERVER_UP"),
    SERVER_DOWN("SERVER_DOWN");

    private final String status;
    Status(String status) {
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

}
