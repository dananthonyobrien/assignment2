/**This page will not be accessible in the app interface,
 * but can be reached through address bar /admin.
 * It lists out all of the members and assessments.
 */

package controllers;
import java.util.List;
import models.Member;
import models.Assessment;
import play.mvc.Controller;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Controller
{
  public static void index()
  {
    List<Member> members = Member.findAll();
    List<Assessment> assessments = Assessment.findAll();
    render("admin.html", members, assessments);
  }

}




