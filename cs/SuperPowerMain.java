package cs;

import java.util.List;

import cs.model.Case;
import cs.model.Casetype;

public class SuperPowerMain {

    public static void main(String[] argv) {
        Singleton instance = Singleton.getInstance();
        // init CaseType
   new Casetype("Bangkok");
      new Casetype("Thailand");
      new Casetype("Asia");

        // // add ratation
        instance.findCasetypeByName("Asia").addRelation(instance.findCasetypeByName("Thailand"));
        instance.findCasetypeByName("Thailand").addRelation(instance.findCasetypeByName("Bangkok"));
        Case case1 = new Case(1, 20, "10/10/41", 2, "prayut", "sea");
        Case case2 = new Case(2, 20, "10/10/41", 2, "prayut", "sea");
        Case case3 = new Case(3, 1, "10/10/41", 2, "prayut", "sea");
        Case case4 = new Case(4, 54, "10/10/41", 2, "prayut", "sea");
         printAll(instance.casetypes);
         System.out.println(instance.cases.size());
        instance.findCasetypeByName("Asia").addCase(case1);
         instance.findCasetypeByName("Asia").addCase(case2);
         instance.findCasetypeByName("Thailand").addCase(case3);
         instance.findCasetypeByName("Thailand").addCase(case4);
         instance.findCasetypeByName("Asia").printall();
         instance.findCasetypeByName("Asia").setName("ASSSSSIAS");
         instance.findCasetypeByName("ASSSSSIAS").printall();
         printAll(instance.casetypes);
        // System.out.println(instance.findCasetypeByName("Asia").getCases().toString());
        // System.out.println(instance.findCasetypeByName("Bangkok").getParentName());
        // System.out.println(instance.findCasetypeByName("Thailand").getParentName());
        // System.out.println(instance.findCasetypeByName("Asia").getParentName());
        // String name = "Bangkok";
        // while (true) {
        //     System.out.println(instance.findCasetypeByName(name).getName() + " : "
        //     + instance.findCasetypeByName(name).getParentName());
        //     name = instance.findCasetypeByName(name).getParentName();
        //     if(name == null) break;
        //     System.out.println("name:"+name);
        
        // }
        
    }

    public static void printAll(List<Casetype> _casetypes) {

        _casetypes.stream().forEach(obj -> {
            System.out.println(obj.getName());
        });
    }

}