/**
 * This class allows for  trainers to login, and logs this as a
 * particular session.
 */
package controllers;

import models.Trainer;
import models.Member;
import play.Logger;
import play.mvc.Controller;


public class TrainerAccounts extends Controller {

    public static void login() {

        render("login.html");
    }

    /**
     * This method takes in parameters email and password,
     * check first to see it exists, and second if it matches.
     * This allows user to login.
     *
     * @param email
     * @param password
     */
    public static void trainerAuthenticate(String email, String password) {
        Logger.info("Attempting to authenticate with " + email + ":" + password);

        Trainer trainer = Trainer.findByEmail(email);
        if ((trainer != null) && (trainer.checkPassword(password) == true)) {
            Logger.info("Authentication successful");
            session.put("logged_in_Trainerid", trainer.id);
            redirect("/trainerdashboard");
        } else {
            Logger.info("Authentication failed");
            redirect("/login");
        }
    }

    public static void logout() {
        session.clear();
        redirect("/");
    }


    public static Trainer getLoggedInTrainer() {
        Trainer trainer = null;
        if (session.contains("logged_in_Trainerid")) {
            String trainerId = session.get("logged_in_Trainerid");
            trainer = Trainer.findById(Long.parseLong(trainerId));
        } else {
            login();
        }
        return trainer;
    }

}

