/**
 * Member class is data model that takes in data from signup.html view and from yml file.
 */
package models;

import controllers.Accounts;
import controllers.GymUtility;
import play.db.jpa.Model;
import models.Assessment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends Model {
    public String firstname;
    public String lastname;
    public String email;
    public String password;
    public String address;
    public boolean gender;
    public float height;
    public float startingweight;
    public float startingBMI;
    public float currentBMI;
    public String BMICategory;
    public boolean idealWeight;
    public int assessmentsNumber;
    public String comment;

    //OneToMany needed to assessments with particular members
    @OneToMany(cascade = CascadeType.ALL)
    public List<Assessment> assessments = new ArrayList<Assessment>();


    //Constructor method
    public Member(String firstname, String lastname, String email, String password, String address, boolean gender, float height, float startingweight) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.height = height;
        this.startingweight = startingweight;

    }

    //Getter methods
    public float getStartingWeight() {
        return startingweight;
    }

    public float getHeight() {
        return height;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    /** getStartingBMI calculated the starting BMI using member's starting weight and height.
     *
     * @return
     */
    public float getStartingBMI() {
        startingBMI = (startingweight / (height * height));
        return this.startingBMI;
    }


    /** Boolean method used to check whether weight is ideal or not.
     * This would work better as if statement with string.
     * @param BMICategory
     * @return
     */
    public boolean idealWeight(String BMICategory) {
        return this.BMICategory.equals("Ideal Weight");
    }

    /**
     * Methods for member authentication
     * @param email
     * @return
     */
    public static Member findByEmail(String email) {
        return find("email", email).first();
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Int method to count Assessments, using size method.
     * Error, always returning zero.
     */
    public int getAssessmentsNumber() {
        int assessmentsNumber = assessments.size();
        return this.assessmentsNumber;
    }

}
