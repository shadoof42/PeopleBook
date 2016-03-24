package org.shadoof42.models;

/**
 * Created by Shadoof on 23.03.2016.
 */
public class Group extends Base{
    private String name;
    private String image;

//    public Group(String name) {
//        this.name = name;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        return id==group.id && name.equals(group.name);

    }

    @Override
    public int hashCode() {
        return 31*id+name.hashCode();
    }
}
