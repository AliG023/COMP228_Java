package application;

public class Applicant {
    private String firstName;
    private String lastName;
    private String email;
    private String website;
    private String position;
    private int salary;
    private String startDate;
    private int phone;
    private int fax;
    private String company;

    // Constructor
    public Applicant(String firstName, String lastName, String email, String website,
            String position, int salary, String startDate, int phone,
            int fax, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.website = website;
        this.position = position;
        this.salary = salary;
        this.startDate = startDate;
        this.phone = phone;
        this.fax = fax;
        this.company = company;
    }

    public Applicant() {
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public String getStartDate() {
        return startDate;
    }

    public int getPhone() {
        return phone;
    }

    public int getFax() {
        return fax;
    }

    public String getCompany() {
        return company;
    }
}
