package cs.model;

import cs.Singleton;

public class Case {
    Singleton instance = Singleton.getInstance();
    private int id;
    private int age;
    private String date;
    private String casetype;
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

    public Case(int id, int age, String date, int infectedFrom, String desc, String location) {
        this.id = id;
        this.age = age;
        this.date = date;
        this.infectedFrom = infectedFrom;
        this.desc = desc;
        this.location = location;
        instance.addCases(this);
    }

    public Case(int id, int age, String date,  String desc, String location) {
        this.id = id;
        this.age = age;
        this.date = date;
        this.desc = desc;
        this.location = location;
        this.infectedFrom = 0;
        instance.addCases(this);
    }

    public String getCasetype() {
        return casetype;
    }

    public void setCasetype(String casetype) {
        this.casetype = casetype;
    }

}