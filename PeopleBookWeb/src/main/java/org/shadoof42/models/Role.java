package org.shadoof42.models;

/**
 * Created by Shadoof on 09.03.2016.
 */
public class Role extends Base {
    private String name;

    public Role(){}

    public Role(final String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }
}