
package domain.beans.application;

public class Effect extends Resource{
    
    private String code;
    
    public Effect(){
        code = "";
    }

    public Effect(int id, String name, String description) {
        super(id, name, description);
    }
    public Effect(int id, String name, String description, String code) {
        super(id, name, description);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
}
