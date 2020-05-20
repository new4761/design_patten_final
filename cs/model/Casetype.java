package cs.model;

import java.util.ArrayList;
import java.util.List;

import cs.Singleton;

public class Casetype {
    Singleton instance = Singleton.getInstance();
    private String name;
    private List<Casetype> relation;
    private List<Case> cases;
    private String parentName;

    public List<Casetype> getRelation() {
        return relation;
    }

    public void addCase(Case _case) {
        _case.setCasetype(this.name);
        this.cases.add(_case);
    }

    public void addRelation(Casetype casetype) {
        casetype.setParentName(this.name);
        this.relation.add(casetype);
    }

    public void printall() {
        printCase();
        this.relation.stream().forEach(obj -> { obj.printall();});  

    }

    public void printCase() {
        this.cases.stream().forEach(obj -> {
            System.out.println("Case ID:" + obj.getId() + " Age:" + obj.getAge());
        });
    }

    public boolean removeCaseById(int id) {

        return this.cases.stream().anyMatch(obj -> {
            if (obj.getId() == id) {
                System.out.println("Remove case from " + this.name + "Case Id :" + obj.getId());
                this.cases.remove(obj);
                return true;

            }
            return false;
        });
    }

    public void removeAllCase() {
        this.cases.forEach(obj -> {
            this.cases.remove(obj);
        });
    }

    public void removeCaseTypeChilden() {
        this.relation.forEach((obj) -> {
            obj.removeAllCase();
            this.relation.remove(obj);
        });

    }

    public List<Case> getCases() {
        return cases;
    }

    public String getName() {
        return name;
    }

    public Casetype(String name) {
        this.name = name;
        this.relation = new ArrayList<>();
        this.cases = new ArrayList<>();
        this.parentName = null;
        instance.addCasetypes(this);

    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void setName(String name) {
        this.name = name;
        this.relation.stream().forEach(obj -> {
            obj.setParentName(name);
        });
    }

}