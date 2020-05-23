package cs.dao;

import java.util.ArrayList;
import java.util.List;

import cs.model.Casetype;

public class CasetypeDAO {
    private List<Casetype> casetypes;

    public CasetypeDAO() {

        casetypes = new ArrayList<>();
        Casetype Bangkok = new Casetype("Bangkok");
        Casetype Singapore = new Casetype("Singapore");
        Casetype   Thailand =   new Casetype("Thailand");
        Casetype  Asia = new Casetype("Asia");
        addCasetypes(Bangkok);
        addCasetypes(Thailand);
        addCasetypes(Singapore);
        addCasetypes(Asia);
        Asia.addRelation(Thailand);
        Asia.addRelation(Singapore);
        Thailand.addRelation(Bangkok);

    }

    public void removeCasetypeByName(String name) {
        Casetype target = findCasetypeByName(name);
        target.removeAllRelation();
        this.casetypes.remove(target);
    }

    public void updateCasetypeByName (String name,Casetype _casetype){
        Casetype target = findCasetypeByName(name);
        if(target != null){
        target.setName(_casetype.getName());
        target.setRelation(_casetype.getRelation());
        // target.setCases(_casetype.getCases());
        target.setParentObj(_casetype.getParentObj());
        }
        else {
            System.out.println("Not have any Type name:"+ name + "on database");
        }

    }


    public Casetype findCasetypeByName(String name) {
        return this.casetypes.stream().filter(obj -> obj.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public void addCasetypes(Casetype _casecasetype) {
        this.casetypes.add(_casecasetype);
    }



    public List<Casetype> getCasetypes() {
        return casetypes;
    }

    public void setCasetypes(List<Casetype> casetypes) {
        this.casetypes = casetypes;
    }
    public  void printAllCasetype( ){
        this.casetypes.stream().forEach(obj -> {
            System.out.println(obj.getName());
        });
    }
    public void printCasetypePathChildToParent(String name) {

        Casetype target = findCasetypeByName(name);
        System.out.print(target.getName());
        while (target.getParentObj()!=null){
            target = target.getParentObj();
            System.out.print(" in type => " +target.getName());
        }
        System.out.println();
    }

}