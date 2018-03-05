package lab1;

import java.util.Date;

/**
 * Fix the code in this class to do PROPERTY encapsulation correctly. Also
 * consider if any of the properties should be mandatory and use a 
 * constructor to enforce that. Review the tips in the document 
 * "EncapCheckList.pdf" if needed.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.02
 */
public class Employee {
    /*
        change to private, needs getter and setters
        getters do not need validation
        setters need validation
        remove setSsn (don't want to be able to set social security number)
        booleans do not need to be validated they are just true or false
    */
    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private Date orientationDate;

    public Employee(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public Employee(String firstName, String lastName, String ssn, boolean metWithHr, boolean metDeptStaff, boolean reviewedDeptPolicies, boolean movedIn, String cubeId, Date orientationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.metWithHr = metWithHr;
        this.metDeptStaff = metDeptStaff;
        this.reviewedDeptPolicies = reviewedDeptPolicies;
        this.movedIn = movedIn;
        this.cubeId = cubeId;
        this.orientationDate = orientationDate;
    }

    public String getFirstName() { return firstName; }



    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty() || firstName.length() < 3 ){
            throw new IllegalArgumentException("Sorry first name is mandatory and must be at least 3 characters.")
        }
        this.firstName = firstName;
    }

    public String getLastName() {return lastName; }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty() || lastName.length() < 3 ){
            throw new IllegalArgumentException("Sorry last name is mandatory and must be at least 3 characters.")
        }
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        //matches is a method returns a boolean.  use regular expression, 3 digits-2 digits-4digits
        if (ssn.matches("\\d{3}-\\d{2}-\\d{4}")){
            this.ssn = ssn;
        }else{
            throw new IllegalArgumentException("sorry first SSN must match legal SSN  format XXX-XX-XXXX")
        }
    }

    public boolean isMetWithHr() {
        return metWithHr;
    }

    public void setMetWithHr(boolean metWithHr) {
        this.metWithHr = metWithHr;
    }

    public boolean isMetDeptStaff() {
        return metDeptStaff;
    }

    public void setMetDeptStaff(boolean metDeptStaff) {
        this.metDeptStaff = metDeptStaff;
    }

    public boolean isReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }

    public void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {
        this.reviewedDeptPolicies = reviewedDeptPolicies;
    }

    public boolean isMovedIn() {
        return movedIn;
    }

    public void setMovedIn(boolean movedIn) {
        this.movedIn = movedIn;
    }

    public String getCubeId() {   return cubeId;  }

    public void setCubeId(String cubeId) {
       if (cubeID.length > 0) {
           this.cubeId = cubeId;
       } else {
           this.cubeId = "0000";
       }
    }

    public Date getOrientationDate() {
        return orientationDate;
    }

    public void setOrientationDate(Date orientationDate) {
        this.orientationDate = orientationDate;
    }




}
