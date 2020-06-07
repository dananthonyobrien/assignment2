/**
 * TrainerDashboard class creates list of all members for each instance of Trainer class.
 * Methods allow members to be added and deleted, and comments to be made on assessments.
 */

package controllers;

import java.util.ArrayList;
import java.util.List;
import controllers.Accounts;
import controllers.TrainerAccounts;
import models.Trainer;
import models.Member;
import models.Assessment;
import play.Logger;
import play.mvc.Controller;


public class TrainerDashboard extends Controller {

    /**
     * This method renders the trainerdashboard.html page
     */
    public static void index() {
        Logger.info("Rendering Trainer Dashboard");
        Trainer trainer = TrainerAccounts.getLoggedInTrainer();
        List<Member> members = Member.findAll();
        //List<Member> members = trainer.members;
        List<Assessment> assessments = Assessment.findAll();
        render("trainerdashboard.html", members, assessments); //assessments, member.startingBMI, member.BMICategory); //assessments.currentBMI. must you add member here too?
    }

    /**
     * This method allows a trainer to delete a member
     *
     * @param id
     */
    public static void deleteMember(Long id) {
        Member member = Member.findById(id);
        Logger.info("Removing" + member);
        member.delete();
        redirect("/trainerdashboard");
    }

    /**
     * This method adds a comment to a specific member's specific assessment.
     * It is not working. Trace back route through Model, Controller, Route, View.
     * Also, refer to playlist for multiple ids.
     * @param id
     * @param assessmentid
     * @param comment
     */

    /*
    public static void addComment(String comment) {
        Logger.info ("Adding a Comment");
        Member member = Member.findById(id);
        member.comment = comment;
        member.save();
        render ("trainerdashboard.html", member);
    */

    /*
    public static void addComment(Long id, Long assessmentid, String comment) {
        Logger.info ("Adding a Comment");
        Member member = Member.findById(id);
        Assessment assessment = Assessment.findById(assessmentid);
        assessment.comment = comment;
        assessment.save();
        Trainer trainer = TrainerAccounts.getLoggedInTrainer();
        List<Assessment> assessments = member.assessments;
        render ("trainerdashboard.html", trainer, member, assessments);

    }
    */


}
