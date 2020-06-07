/**This class gives each assessment its own id,
 * making each one unique and searchable.
 *
 */

package controllers;

import java.util.List;
import models.Member;
import models.Assessment;
import play.Logger;
import play.mvc.Controller;

public class AssessmentCtrl extends Controller {
  public static void index(Long assessmentid) {
    Assessment assessment = Assessment.findById(assessmentid);
    Logger.info("Assessment id = " + assessmentid);
    render("assessment.html", assessment);
  }

}
