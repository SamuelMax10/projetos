package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable {
    private Integer id;
    private String name;

    public  Department(){

    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department departament = (Department) o;
        return Objects.equals(id, departament.id) && Objects.equals(name, departament.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Department [" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ']';
    }
}
