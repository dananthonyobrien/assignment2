/**
 * This account gives every member unique id
 */

package controllers;

import java.util.List;
import models.Member;
import models.Assessment;
import play.Logger;
import play.mvc.Controller;

public class MemberCtrl extends Controller {
    public static void index(Long memberid) {
        Member member = Member.findById(memberid);
        Logger.info("Member id = " + memberid);
        render("dashboard.html", member);
    }
}