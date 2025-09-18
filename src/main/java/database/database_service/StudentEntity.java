package database.database_service;



public class StudentEntity {
    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_fname() {
        return student_fname;
    }

    public void setStudent_fname(String student_fname) {
        this.student_fname = student_fname;
    }

    public String getStudent_lname() {
        return student_lname;
    }

    public void setStudent_lname(String student_lname) {
        this.student_lname = student_lname;
    }

    public String getStudent_mname() {
        return student_mname;
    }

    public void setStudent_mname(String student_mname) {
        this.student_mname = student_mname;
    }

    public String getStudent_dep() {
        return student_dep;
    }

    public void setStudent_dep(String student_dep) {
        this.student_dep = student_dep;
    }

    public String getStudent_cource() {
        return student_cource;
    }

    public void setStudent_cource(String student_cource) {
        this.student_cource = student_cource;
    }

    public Double getStudent_salary() {
        return student_salary;
    }

    public void setStudent_salary(Double student_salary) {
        this.student_salary = student_salary;
    }

    public Integer getStudent_age() {
        return student_age;
    }

    public void setStudent_age(Integer student_age) {
        this.student_age = student_age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    Integer student_id;
    String student_fname;
    String student_lname;
    String student_mname;
    String student_dep;
    String student_cource;
    Double student_salary;
    Integer student_age;
    Integer id;
}