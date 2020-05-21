package cs.model;

public class Case {

    private int id;
    private int age;
    private String date;
    private Casetype casetype;
    private int infectedFrom;
    private String desc;
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getInfectedFrom() {
        return infectedFrom;
    }

    public void setInfectedFrom(int infectedFrom) {
        this.infectedFrom = infectedFrom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Casetype getCasetype() {
        return casetype;
    }

    public void setCasetype(Casetype casetype) {
        this.casetype = casetype;
    }

    public Case(int id, int age, String date, int infectedFrom, String desc, String location) {
        this.id = id;
        this.age = age;
        this.date = date;
        this.infectedFrom = infectedFrom;
        this.desc = desc;
        this.location = location;
        this.casetype = null;

    }

    public Case(int id, int age, String date, String desc, String location) {
        this.id = id;
        this.age = age;
        this.date = date;
        this.desc = desc;
        this.location = location;
        this.infectedFrom = 0;
        this.casetype = null;

    }

    @Override
    public String toString() {

        String casetypeText = (this.casetype == null) ? "Unknow":this.casetype.getName();
        return "id:" + this.id + " Age: " + this.age + " Infected date: " + this.date + " Desc: " + this.desc
                + " Location: " + this.location + " infected from caseID:" + this.infectedFrom +" Casetype: "+ casetypeText;
    }
}