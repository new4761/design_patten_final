package cs;

import java.util.Scanner;

import cs.dao.CaseDAO;
import cs.dao.CasetypeDAO;
import cs.model.Case;
import cs.model.Casetype;

/* 60050143 kanisorn siripatkerdpong 


Use design patterns
 - Composite
 - Chain of Responsibility
Use DAO patten for demo database  and make something like querry Data
don't create mvc patten bc want don't use real db (use DAO to database)

All Class in main is do someting like client call and querry but DAO can't see other data 
on other DAO (IF is database is can do something like "SELECET WHEHE " or " UPDDATE WHERE")
that why on client (main class /this class ) have some method call though model (not mvc better way)
on main show only some method is good for use (Easy way to input/display in textbase)

Rate my selfcode 4/10 T T


*/
public class SuperPowerMain {
    static CaseDAO caseDAO;
    static CasetypeDAO casetypeDAO;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] argv) {
        // init some data for demo 
        caseDAO = new CaseDAO();
        casetypeDAO = new CasetypeDAO();
        casetypeDAO.printAllCasetype();
        // caseDAO.printAllCase();
        setCasetypeByID(1, "Thailand");
        setCasetypeByID(2, "Thailand");
        setCasetypeByID(5, "Asia");
        setCasetypeByID(6, "Singapore");
        setCasetypeByID(7, "Bangkok");
        setCasetypeByID(9, "Bangkok");
        int choice;

        // do loop for use input 
        do {
            System.out.println("Input number for pick command");
            System.out.println("1. Newcase");
            System.out.println("2. Newcasetype");
            System.out.println("3. Edit Case ByID");
            System.out.println("4. Edit Casetype ByName");
            System.out.println("5. Remove Case ByID");
            System.out.println("6. Remvoe Casetype ByName");
            System.out.println("7. Show  CasePath ByID");
            System.out.println("8. Show  AllCase in Casetype ByName");
            System.out.println("9. Show AllCase in database");
            System.out.println("10. Show  AllCasetype in database");
            System.out.println("0. Exit()");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createNewCase();
                    break;
                case 2:
                    createNewCasetype();
                    break;
                case 3:
                    editCaseData();
                    break;
                case 4:
                    editCasetypeData();
                    break;
                case 5:
                    removeCaseByid();
                    break;
                case 6:
                    removeCasetypeByName();
                    break;
                case 7:
                    printCasePath();
                    break;
                case 8:
                    System.out.print("Insert Casetype Name: ");
                    printAllCaseinCasetypeByName(sc.next());
                    break;
                    case 9:
                    System.out.println("**Show all case in database**");
                    caseDAO.printAllCase();
                    break;
                    case 10:
                    System.out.println("**Show all casetype in database**");
                  casetypeDAO.printAllCasetype();
                    break;
            }
        } while (choice != 0);

    }

    // ***** Method for Client can Do insert update delelet select" (Demo some) *****
    public static void removeCaseByid() {
        System.out.println("**RemoveCaseByid**");
        System.out.print("Insert CaseId: ");
        caseDAO.removeCaseeById(sc.nextInt());
    }

    public static void removeCasetypeByName() {
        System.out.println("**RemoveCasetypeByName**");
        System.out.print("Insert Casetype Name: ");
        String name = sc.next();
        Casetype target = casetypeDAO.findCasetypeByName(name);
        if (target != null) {
            caseDAO.getAllCases().stream().forEach(obj -> {
                if (obj.getCasetype() == target)
                    obj.setCasetype(null);
            });
            casetypeDAO.removeCasetypeByName(name);
            System.out.println("Removed Type name:" + name + " from database");
        } else {
            System.out.println("Not have any Type name:" + name + " on database");
        }
    }

    public static void setCasetypeRelation(String parent, String child) {
        Casetype parentObj = casetypeDAO.findCasetypeByName(parent);
        Casetype childObj = casetypeDAO.findCasetypeByName(child);
        if (parentObj != null || childObj != null)
            casetypeDAO.findCasetypeByName(parent).addRelation(casetypeDAO.findCasetypeByName(child));
        else
            System.out.println(" PLS check Type name:" + parent + " or " + child);
    }

    public static void setCasetypeByID(int id, String name) {
        caseDAO.findCaseById(id).setCasetype(casetypeDAO.findCasetypeByName(name));
    }

    public static void createNewCase() {
        System.out.println("**CreateNewCase**");
        Case _case = new Case();
        System.out.println("New Case");
        System.out.print("Insert CaseId: ");
        _case.setId(sc.nextInt());
        System.out.print("Insert Age: ");
        _case.setAge(sc.nextInt());
        System.out.print("Insert Infected date: ");
        _case.setDate((sc.next()));
        System.out.print("Insert Gender: ");
        _case.setDesc((sc.next().toUpperCase()));
        System.out.print("Insert Desc: ");
        _case.setDesc((sc.next()));
        System.out.print("Insert Location: ");
        _case.setLocation((sc.next()));
        System.out.print("Have  infectedFrom Data ? y/n");
        if (sc.next().equalsIgnoreCase("Y")) {
            System.out.print("Insert infectedFrom CaseID: ");
            int id = sc.nextInt();
            if (caseDAO.findCaseById(id) == null)
                System.out.print("Not have any CaseID : " + id);
            else
                _case.setInfectedFrom(id);
        }
        System.out.print("Have  Casetype Data ? y/n");
        if (sc.next().equalsIgnoreCase("Y")) {
            System.out.print("Insert Name Casetype: ");
            String name = sc.next();
            Casetype _casetype = casetypeDAO.findCasetypeByName(name);
            if (_casetype == null)
                System.out.print("Not have any Casetype name : " + name);
            else
                _case.setCasetype(_casetype);

        }
        caseDAO.addCase(_case);
        System.out.println("Inserted CaseData");
        System.out.println(_case.toString());
    }

    public static void createNewCasetype() {
        System.out.println("**CreateNewCasetype**");
        System.out.println("New Casetype");
        System.out.print("Insert Name: ");
        Casetype _casetype = new Casetype(sc.next());
        casetypeDAO.addCasetypes(_casetype);

    }

    public static void editCaseData() {
        System.out.println("**Edit CaseData**");
        System.out.print("Insert CaseId: ");
        int id = sc.nextInt();
        Case oldcase = caseDAO.findCaseById(id);
        Case newCase = new Case();
        if (oldcase == null)
            System.out.print("Not have any CaseID : " + id);
        else {
            System.out.println("Old casedata");
            System.out.println(oldcase.toString());
            System.out.print("Change  CaseID ? y/n");
            if (sc.next().equalsIgnoreCase("Y")) {
                System.out.println("Old CaseID: " + oldcase.getId());
                System.out.print("New CaseID: ");
                newCase.setId(sc.nextInt());
            } else {
                newCase.setId(oldcase.getId());
            }

            System.out.print("Change  Casetype ? y/n");
            if (sc.next().equalsIgnoreCase("Y")) {
                String casetypeText = (oldcase.getCasetype() == null) ? "Unknow" : oldcase.getCasetype().getName();
                System.out.println("Old Casetype name: " + casetypeText);
                System.out.print("New Casetype =>");
                String input = sc.next();
                newCase.setCasetype(casetypeDAO.findCasetypeByName(input));

            } else {
                newCase.setCasetype(oldcase.getCasetype());
            }
            newCase.setAge(oldcase.getAge());
            newCase.setGender(oldcase.getGender());
            newCase.setDate(oldcase.getDate());
            newCase.setDesc(oldcase.getDesc());
            newCase.setLocation(oldcase.getLocation());
            newCase.setInfectedFrom(oldcase.getInfectedFrom());
            caseDAO.updateCaseByID(id, newCase);
        }
    }

    public static void editCasetypeData() {
        System.out.println("**Edit CasetypeData**");
        System.out.print("Insert Casetype name: ");
        String name = sc.next();
        Casetype target = casetypeDAO.findCasetypeByName(name);
        System.out.println("1. to Edit name");
        System.out.println("2. for insert Relation");
        System.out.println("3. for Remove Relation");
        switch (sc.nextInt()) {
            case 1:
                System.out.println("Old name:" + target.getName());
                System.out.print("insert new name:");
                target.setName(sc.next());
                break;
            case 2:
                System.out.println("Current Relation");
                target.getRelation().stream().forEach(obj -> {
                    System.out.println(obj.getName());
                });
                System.out.print("insert new Relation with nam:");
                target.addRelation(casetypeDAO.findCasetypeByName(sc.next()));
                break;
            case 3:
                System.out.println("Current Relation");
                target.getRelation().stream().forEach(obj -> {
                    System.out.println(obj.getName());
                });
                System.out.print("Remove  Relation By name:");
                target.removeRelationByname(casetypeDAO.findCasetypeByName(sc.next()).getName());
                break;

        }
    }

    public static void printCasePath() {
        System.out.println("**PrintCasePath**");
        System.out.print("Insert CaseId: ");
        int id = sc.nextInt();
        caseDAO.printCasePathChildToParent(id);
    }

    public static void printAllCaseinCasetypeByName(String name) {
        System.out.println("**PrintAllCaseinCasetypeByName**");
        Casetype target = casetypeDAO.findCasetypeByName(name);
        if (target != null) {

            caseDAO.getAllCases().stream().forEach(obj -> {
                if (obj.getCasetype() == target)
                    System.out.println(obj.toString());
            });
        }

    }

    public static void printAllCaseinCasetypeByNameInPath(String name) {
        Casetype target = casetypeDAO.findCasetypeByName(name);
        printAllCaseinCasetypeByName(target.getName());
        target.getRelation().stream().forEach(obj -> {
            printAllCaseinCasetypeByNameInPath(obj.getName());
        });

    }
}