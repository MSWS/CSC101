package xyz.msws.csc.wk5;

public class Season {
    public static void main(String[] args) {

    }

    public static String season(int month, int day) {
        if (month == 12 && day >= 16)
            return "Winter";
        if (month == 3 && day <= 15)
            return "Winter";
        if (month < 3)
            return "Winter";

        if (month >= 3 && month <= 6) {
            if (month < 6)
                return "Spring";
            if (month == 6) {
                return day <= 15 ? "Spring" : "Summer";
            }

        }

        if (month >= 6 && month <= 9) {
            if (month == 9)
                return day <= 15 ? "Summer" : "Fall";
            return "Summer";
        }
        return "Fall";
    }

    public static int date(int month, int day) {
        return month * 30 + day;
    }
}
