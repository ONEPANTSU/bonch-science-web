package BSWeb.models;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class User {
    private Integer access_level = null;

    public void setAccess_level(int value){
        if (access_level == null){
            access_level = value;
        }
    }
    public Integer getAccess_level() {
        return access_level;
    }
}
