package BSWeb.models;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class User {
    private Integer access_level = null;

    public void setAccess_level(int value){
        access_level = value;
    }
    public void logout(){
        access_level = null;
    }
    public Integer getAccess_level() {
        return access_level;
    }
}
