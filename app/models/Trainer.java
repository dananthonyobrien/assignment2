/**
 * Trainer class is data model that takes in data about gym trainers from YML file.
 */

package models;

import controllers.TrainerAccounts;
import play.db.jpa.Model;
import models.Member;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trainer extends Model {
    public String firstname;
    public String lastname;
    public String email;
    public String password;

    /**
     * Constructor method
     */


    public Trainer(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;

    }

    /**
     * Getter methods
     *
     * @return
     */

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    /**
     * Methods for trainer authentication
     *
     * @param email
     * @return
     */
    public static Trainer findByEmail(String email) {
        return find("email", email).first();
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}


