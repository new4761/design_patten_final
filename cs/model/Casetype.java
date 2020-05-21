package cs.model;

import java.util.ArrayList;
import java.util.List;

public class Casetype {

    private String name;
    private List<Casetype> relation;
    private List<Case> cases;
    private Casetype parentObj;

    public Casetype(String name) {
        this.name = name;
        this.relation = new ArrayList<>();
        this.cases = new ArrayList<>();
        this.parentObj = null;

    }

    public List<Casetype> getRelation() {
        return relation;
    }

    public void addCase(Case _case) {
        _case.setCasetype(this);
        this.cases.add(_case);
    }

    public void addRelation(Casetype casetype) {
        casetype.setParentObj(this);
        this.relation.add(casetype);
    }

    public List<Case> getCases() {
        return cases;
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

    public void printAllChildCase() {
        printCase();
        this.relation.stream().forEach(obj -> {
            obj.printAllChildCase();
        });

    }

    public void printCase() {
        this.cases.stream().forEach(obj -> {
            System.out.println(obj.toString());
        });
    }

    public void removeCaseById(int id) {
        this.cases.remove(this.cases.stream().filter(obj -> obj.getId() == id).findFirst().orElse(null));

    }

    public void removeAllCase() {
        this.cases.forEach(obj -> {
            obj.setCasetype(null);
            this.cases.remove(obj);
        });
    }

    public void removeAllRelation() {
        removeAllCase();
        this.relation.forEach((obj) -> {
            obj.setParentObj(null);
            this.relation.remove(obj);
        });

    }

    public void setRelation(List<Casetype> relation) {
        this.relation = relation;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }
}