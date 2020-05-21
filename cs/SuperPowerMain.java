package cs;


import cs.dao.CaseDAO;
import cs.dao.CasetypeDAO;
import cs.model.Case;
import cs.model.Casetype;

public class SuperPowerMain {
    static CaseDAO caseDAO;
    static CasetypeDAO casetypeDAO;

    public static void main(String[] argv) {
        caseDAO = new CaseDAO();
        casetypeDAO = new CasetypeDAO();
        casetypeDAO.printAllCasetype();
        caseDAO.printAllCase();
        addCaseToCasetype(1, "Thailand");
        addCaseToCasetype(2, "Thailand");
        addCaseToCasetype(5, "Asia");
        addCaseToCasetype(6, "Singapore");
        addCaseToCasetype(7, "Bangkok");
        addCaseToCasetype(9, "Bangkok");
        caseDAO.printAllCase();
        
        printAllCasetypePath("Bangkok");
        printAllCasePath(1);
       

    }

    public static void addCaseToCasetype(int id, String name) {
        casetypeDAO.findCasetypeByName(name).addCase(caseDAO.findCaseeById(id));
    }
    public static void printAllCasePath(int id){
        Case target =caseDAO.findCaseeById(id);
        System.out.print(" id: "+target.getId());
        while (target.getInfectedFrom()!=0){
            target = caseDAO.findCaseeById(target.getInfectedFrom());
            System.out.print(" => " +" id: " +target.getId());
        }
  
    }

    public static void printAllCasetypePath(String name) {

        Casetype target = casetypeDAO.findCasetypeByName(name);
        System.out.print(target.getName());
        while (target.getParentObj()!=null){
            target = target.getParentObj();
            System.out.print(" => " +target.getName());
        }
  
    }
    // }
}