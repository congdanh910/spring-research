package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User {

    private Integer id;

    private String  name;
    public User() {}
    public User(String id, String name) {
    	if(!id.isEmpty())
    		this.id = Integer.parseInt(id);
    	this.name =name;
    	
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("{id=%s,name=%s}", id, name);
    }

}
