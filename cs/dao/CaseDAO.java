package cs.dao;

import java.util.ArrayList;
import java.util.List;

import cs.model.Case;


public class CaseDAO {
    private List<Case> cases;

    public CaseDAO() {
        cases = new ArrayList<>();

        Case case1 = new Case(1, 11, "11/11/11", 2, "some desc 1", "location1");
        Case case2 = new Case(2, 22, "22/10/41", 5, "some desc 2", "location2");
        Case case3 = new Case(3, 33, "33/10/41",  "some desc 3", "location3");
        Case case4 = new Case(4, 44, "44/10/41", "some desc 4", "location4");
        Case case5 = new Case(5, 55, "55/10/41",  "some desc 5", "location5");
        Case case6 = new Case(6, 66, "66/10/41", 1, "some desc 6", "location6");
        Case case7 = new Case(7, 77, "77/10/41", 2, "some desc 7", "location7");
        Case case8 = new Case(8, 88, "88/10/41", "some desc 8", "location8");
        Case case9 = new Case(9, 99, "99/10/41", 3, "some desc 9", "location9");
        Case case10 = new Case(10, 100, "100/10/41", 4, "some desc 10", "location10");

        addCase(case1);
        addCase(case2);
        addCase(case3);
        addCase(case4);
        addCase(case5);
        addCase(case6);
        addCase(case7);
        addCase(case8);
        addCase(case9);
        addCase(case10);
    }


    public void printAllCase() {
        this.cases.stream().forEach(obj -> {
            System.out.println(obj.toString());
        });
    }

    public void removeCaseeById(int id) {
        Case target = findCaseeById(id);
        if(target != null){
        target.getCasetype().removeCaseById(id);
        this.cases.remove(target);
        }
        else{
            System.out.println("Not have any CaseID:"+ id + "on database");
        }
    }

    public Case findCaseeById(int id) {
        return this.cases.stream().filter(obj -> obj.getId() == id).findFirst().orElse(null);
    }

    public List<Case> getAllCases() {
        return cases;
    }

    public void addCase(Case _case) {
        this.cases.add(_case);

    }

    public void updateCaseByID (int id,Case _case){
       Case target = findCaseeById(id);
       if(target != null){
       target.setId(_case.getId());
       target.setAge(_case.getAge());
       target.setDate(_case.getDate());
       target.setInfectedFrom(_case.getInfectedFrom());
       target.setDesc(_case.getDesc());
       target.setLocation(_case.getLocation());
       target.setCasetype(_case.getCasetype());
       }
       else {
        System.out.println("Not have any CaseID:"+ id + "on database");
       }
    }
}