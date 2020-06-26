package com.sergey.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DataTemplates {
    private static final Pattern FOLDINGTEMPLATE = Pattern.compile("FOLDING BIKE \\D*; \\d*; \\d*; \\d*; (TRUE|FALSE); \\D*; \\d*");
    private static final Pattern SPEDELECTEMPLATE = Pattern.compile("(SPEEDELEC|E-BIKE) \\D*; \\d*; \\d*; (TRUE|FALSE); \\d*; \\D*; \\d*");
    private static List<Pattern> templates = new ArrayList<>();
    private final static String[] FOLDINGTOUSER = new String[7];
    private final static String[] SPEEDELECTOUSER = new String[7];
    private final static String PACKAGE = "com.sergey.pojo.";

    static {
        templates.add(FOLDINGTEMPLATE);
        templates.add(SPEDELECTEMPLATE);

        FOLDINGTOUSER[0] = "Input brand name";
        FOLDINGTOUSER[1] = "Input size of the wheels (in inch)";
        FOLDINGTOUSER[2] = "Input number of gears";
        FOLDINGTOUSER[3] = "Input weight of the bike(in grams)";
        FOLDINGTOUSER[4] = "Input availability of light at front and back. 'y' if it`s true, otherwise 'n' - false";
        FOLDINGTOUSER[5] = "Input color";
        FOLDINGTOUSER[6] = "Input price(in EURO)";

        SPEEDELECTOUSER[0] = "Input brand name";
        SPEEDELECTOUSER[1] = "Input maximum speed (in km/h)";
        SPEEDELECTOUSER[2] = "Input weight of the bike(in grams)";
        SPEEDELECTOUSER[3] = "Input availability of light at front and back. 'y' if it`s true, otherwise 'n' - false";
        SPEEDELECTOUSER[4] = "Input battery capacity";
        SPEEDELECTOUSER[5] = "Input color";
        SPEEDELECTOUSER[6] = "Input price(in EURO)";
    }

    public static List<Pattern> getTemplates() {
        return templates;
    }
    public static String getPackageName(){
        return PACKAGE;
    }
    public static String[] getFoldingtouser(){
        return FOLDINGTOUSER;
    }
    public static String[] getSpeedelectouser(){
        return SPEEDELECTOUSER;
    }
}
