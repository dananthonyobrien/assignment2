/**
 * A utility class (or helper class) is a "structure" that has
 * only static methods and encapsulates no state (fields).
 * Typically the functionality of the methods is reusable
 * across a range of applications.
 */

package controllers;

import models.Member;
import models.Assessment;

public class GymUtility {


    public static double calculateBMI(Member member) {
        return member.getStartingWeight() / (member.getHeight() * member.getHeight());
    }

    //This is returning IndexOutOfBoundsException for new members
    public static double calculateBMI(Member member, Assessment assessment) {
        float BMIWeight;
        if (assessment == null) {
            BMIWeight = member.getStartingWeight();
        } else BMIWeight = assessment.getWeight_input();
        double bmiValue = BMIWeight / (member.getHeight() * member.getHeight());
        return bmiValue;
    }

    //public static double calculateBMI(Member member) {
    //float BMIWeight;
    //double bmiValue =  member.getStartWeight()/(member.getHeight() * member.getHeight());
    //return bmiValue;
    //}


    public static String determineBMICategory(double bmiValue) {
        if (bmiValue < 16) {
            return "SEVERELY UNDERWEIGHT";
        } else if ((bmiValue >= 16) && (bmiValue < 18.5)) {
            return "UNDERWEIGHT";
        } else if ((bmiValue >= 18.5) && (bmiValue < 24.9)) {
            return "NORMAL";
        } else if ((bmiValue >= 25) && (bmiValue < 29.9)) {
            return "OVERWEIGHT";
        } else if ((bmiValue >= 30) && (bmiValue < 34.9)) {
            return "MODERATELY OBESE";
        } else if (bmiValue >= 35) {
            return "SEVERELY OBESE";
        }
        return null;
    }
}

