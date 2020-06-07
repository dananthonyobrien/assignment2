/**
 * Dashboard class creates list of assessments for each instance of Member class.
 * Methods allow assessments to be added and deleted.
 */

package controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Member;
import models.Assessment;
import play.Logger;
import play.mvc.Controller;


public class Dashboard extends Controller {
    public float currentBMI;
    public long ts;

    public static void index() {
        Logger.info("Rendering Dashboard");
        Member member = Accounts.getLoggedInMember();
        List<Assessment> assessments = member.assessments;
        //if (assessments != null){
        //  double bmiValue = GymUtility.calculateBMI(member, assessments.get(0));
        //} else {double bmiValue = GymUtility.calculateBMI(member);};
        double bmiValue = GymUtility.calculateBMI(member, assessments.get(0));
        String determineBMICategory = GymUtility.determineBMICategory(bmiValue);
        render("dashboard.html", member, assessments, member.startingBMI, member.BMICategory, member.assessmentsNumber, bmiValue, determineBMICategory); //assessments.ts, assessments.currentBMI. must you add member here too?
    }


    public static void deleteAssessment(Long assessmentid) {
        Logger.info("Deleting an Assessment");
        Member member = Accounts.getLoggedInMember();
        Assessment assessment = Assessment.findById(assessmentid);
        member.assessments.remove(assessment);
        member.save();
        assessment.delete();
        redirect("/dashboard");
    }

    //Can take in the date as a string for moment, but would be better to take in
    // as date, or time stamp for ordering assessments by date
    public static void addAssessment(float weight_input, float chest_input, float thigh_input, float upperArm_input, float waist_input, float hips_input, String date_input) {
        Logger.info("Adding an Assessment");
        Member member = Accounts.getLoggedInMember();
        Assessment assessment = new Assessment(weight_input, chest_input, thigh_input, upperArm_input, waist_input, hips_input, date_input);
        member.assessments.add(assessment);
        member.save();
        //assessment.dateTime();
        redirect("/dashboard");
    }


}


