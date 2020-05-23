package cs.dao;

import java.util.ArrayList;
import java.util.List;

import cs.model.Case;


// DAO Patten of Case but try to be database  some method use for show data only like try to select 
public class CaseDAO {
    private List<Case> cases;

    public CaseDAO() {
        cases = new ArrayList<>();

        Case case1 = new Case(1, 11, "11/11/11", 2, "some desc 1", "location1",'M');
        Case case2 = new Case(2, 22, "22/10/41", 5, "some desc 2", "location2",'M');
        Case case3 = new Case(3, 33, "33/10/41", "some desc 3", "location3",'W');
        Case case4 = new Case(4, 44, "44/10/41", "some desc 4", "location4",'W');
        Case case5 = new Case(5, 55, "55/10/41", "some desc 5", "location5",'M');
        Case case6 = new Case(6, 66, "66/10/41", 1, "some desc 6", "location6",'W');
        Case case7 = new Case(7, 77, "77/10/41", 2, "some desc 7", "location7",'M');
        Case case8 = new Case(8, 88, "88/10/41", "some desc 8", "location8",'W');
        Case case9 = new Case(9, 99, "99/10/41", 3, "some desc 9", "location9",'M');
        Case case10 = new Case(10, 100, "100/10/41", 4, "some desc 10", "location10",'W');

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
  // want to be select  all in case
    public void printAllCase() {
        this.cases.stream().forEach(obj -> {
            System.out.println(obj.toString());
        });
    }
  // want to be select with con
    public void printCasePathChildToParent(int id) {
        Case target = findCaseById(id);
        System.out.print(" Case id: " + target.getId());
        while (target.getInfectedFrom() != 0) {
            target = findCaseById(target.getInfectedFrom());
            System.out.print(" infectedFrom  => " + " id: " + target.getId());
        }
        System.out.println();

    }
  // want to be select with con
    public void printCasePathParentToChild(int id) {

        this.cases.stream().forEach(obj -> {
            if (obj.getInfectedFrom() == id) {
                System.out.print(" Case id: " + id);
                System.out.print(" infectedTo => ");
                System.out.println(" Case id: " + obj.getId());
                printCasePathParentToChild(obj.getId());
            }
        });

        // System.out.print("new line from id:" + id);
    }
  // want to be delete
    public void removeCaseeById(int id) {
        Case target = findCaseById(id);
        if (target != null) {
            this.cases.stream().forEach(obj -> {
                if (obj.getInfectedFrom() == id)
                    obj.setInfectedFrom(0);
            });
            this.cases.remove(target);
            System.out.println("Removed Case ID");
        } else {
            System.out.println("Not have any CaseID:" + id + "on database");
        }
    }
  // want to be select
    public Case findCaseById(int id) {
        return this.cases.stream().filter(obj -> obj.getId() == id).findFirst().orElse(null);
    }

    public List<Case> getAllCases() {
        return cases;
    }
  // want to be insert
    public void addCase(Case _case) {
        this.cases.add(_case);

    }

    // Bad update bc is not Real Database
    public void updateCaseByID(int id, Case _case) {
        Case target = findCaseById(id);
        if (target != null) {
            target.setId(_case.getId());
            this.cases.stream().forEach(obj -> {
                if (obj.getInfectedFrom() == id) {
                    obj.setInfectedFrom(_case.getId());
                }
            });
            target.setAge(_case.getAge());
            target.setDate(_case.getDate());
            target.setInfectedFrom(_case.getInfectedFrom());
            target.setDesc(_case.getDesc());
            target.setLocation(_case.getLocation());
            target.setCasetype(_case.getCasetype());
            System.out.println("Updated");
            System.out.println(target.toString());
        } else {
            System.out.println("Not have any CaseID:" + id + "on database");
        }
    }
}