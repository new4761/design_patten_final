package cs.model;


// model data only override to string with handle null for display not use any patten is this onlu pojo
// on casetype get objref instead name for easy handle and to be obj reattion
public class Case { 

    private int id;
    private int age;
    private char gender;
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

    public Case(int id, int age, String date, int infectedFrom, String desc, String location,char gender) {
        this.id = id;
        this.age = age;
        this.date = date;
        this.infectedFrom = infectedFrom;
        this.desc = desc;
        this.location = location;
        this.gender = gender;
        this.casetype = null;

    }

    public Case(int id, int age, String date, String desc, String location,char gender) {
        this.id = id;
        this.age = age;
        this.date = date;
        this.desc = desc;
        this.location = location;
        this.infectedFrom = 0;
        this.casetype = null;
        this.gender = gender;

    }

    public Case() {

        this.infectedFrom = 0;
        this.casetype = null;

    }

    @Override
    public String toString() {
        String infectedFromText = (this.infectedFrom == 0) ? "Unknow" : Integer.toString(this.infectedFrom);
        String casetypeText = (this.casetype == null) ? "Unknow" : this.casetype.getName();
        return "id:" + this.id + " Age: " + this.age +" Gender: "+this.gender + " Infected date: " + this.date + " Desc: " + this.desc
                + " Location: " + this.location + " infected from caseId : " + infectedFromText + " Casetype: "
                + casetypeText;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}