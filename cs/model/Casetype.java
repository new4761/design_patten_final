package cs.model;

import java.util.ArrayList;
import java.util.List;

/* Use design patterns
 - Composite
 - Chain of Responsibility 
 
 have some print method for display  and have parentObj for can run back from child to parent
 */
public class Casetype {

    private String name;
    private List<Casetype> relation;
    private Casetype parentObj;

    public Casetype(String name) {
        this.name = name;
        this.relation = new ArrayList<>();

        this.parentObj = null;

    }

    public List<Casetype> getRelation() {
        return relation;
    }

    public void addRelation(Casetype casetype) {
        casetype.setParentObj(this);
        this.relation.add(casetype);
    }

    public String getName() {
        return name;
    }

    public Casetype getParentObj() {
        return parentObj;
    }

    public void setParentObj(Casetype parentObj) {
        this.parentObj = parentObj;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void removeRelationByname(String name) {
        // removeAllCase();
        this.relation.forEach((obj) -> {
            if (obj.getName().equalsIgnoreCase(name)) {
                obj.setParentObj(null);
                this.relation.remove(obj);
            }
        });

    }

    public void removeAllRelation() {
        // removeAllCase();
        this.relation.forEach((obj) -> {
            obj.setParentObj(null);
            this.relation.remove(obj);
        });

    }

    public void setRelation(List<Casetype> relation) {
        this.relation = relation;
    }

}