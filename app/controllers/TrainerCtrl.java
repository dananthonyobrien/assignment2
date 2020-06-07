/**
 * This method gives each trainer own unique id
 */

package controllers;

import java.util.List;
import models.Trainer;
import models.Assessment;
import play.Logger;
import play.mvc.Controller;

public class TrainerCtrl extends Controller {
    public static void index(Long trainerid) {
        Trainer trainer = Trainer.findById(trainerid);
        Logger.info("Trainer id = " + trainerid);
        render("trainerdashboard.html", trainer);
    }



}