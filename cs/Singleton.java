package cs;

import java.util.ArrayList;
import java.util.List;

import cs.model.Case;
import cs.model.Casetype;

public class Singleton {
    public List<Case> cases = new ArrayList<>();
    public List<Casetype> casetypes = new ArrayList<>();

    private static Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public Singleton() {

    }

    public void addCases(Case _case) {
        this.cases.add(_case);

    }

    public Casetype findCasetypeByName(String name) {
        return this.casetypes.stream().filter(obj -> obj.getName().equals(name)).findFirst().orElse(null);
    }

    public void addCasetypes(Casetype _casecasetype) {
        this.casetypes.add(_casecasetype);
    }

}