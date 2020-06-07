/**
 * Assessment is a data model class that takes in assessment data from the view assessment.html and the yml file.
 * One to Many is used as it is not only one member's assessments being stored, but potentially many assessments.
 */

package models;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Assessment extends Model {
    public float weight_input;
    public float chest_input;
    public float thigh_input;
    public float upperArm_input;
    public float waist_input;
    public float hips_input;
    public float currentBMI;
    public long ts;
    public String comment;
    public String date_input;

    //ArrayList of assessments
    @OneToMany(cascade = CascadeType.ALL)
    public List<Assessment> assessments = new ArrayList<Assessment>();

    /**
     * Constructor method for Assessment
     *
     * @param weight_input
     * @param chest_input
     * @param thigh_input
     * @param upperArm_input
     * @param waist_input
     * @param hips_input
     */
    public Assessment(float weight_input, float chest_input, float thigh_input, float upperArm_input, float waist_input, float hips_input, String date_input) {

        this.weight_input = weight_input;
        this.chest_input = chest_input;
        this.thigh_input = thigh_input;
        this.upperArm_input = upperArm_input;
        this.waist_input = waist_input;
        this.hips_input = hips_input;
        this.date_input = date_input;
    }


    /**
     * Timestamp method used to get time and date
     *
     * @return Not working. Follow back from view and try to spot issue.
     */
    //public long dateTime() {
    //    Date date = new Date();
    //    Timestamp ts = new Timestamp(date.getTime());
    //    return this.ts;
    //}

    /**
     * Getter Methods
     *
     * @return
     */
    public float getWeight_input() {
        return weight_input;
    }


    public float getChest_input() {
        return chest_input;
    }

    public float getThigh_input() {
        return thigh_input;
    }

    public float getUpperArm_input() {
        return upperArm_input;
    }

    public float getWaist_input() {
        return waist_input;
    }

    public float getHips_input() {
        return hips_input;
    }

    /**
     * Setter method
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}



