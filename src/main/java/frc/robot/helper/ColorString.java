package frc.robot.helper;

import edu.wpi.first.wpilibj.util.Color;

public class ColorString {
    private String colorString;

    public ColorString(Color mycolor) {
        if(mycolor != null) {
            colorString = mycolor.red + "," + mycolor.green + "," +mycolor.blue;
        } else {
            colorString = "0.0,0.0,0.0";
        }
    }

    @Override
    public String toString() {
        return colorString;
    }

    public static Color toColor(String text) {
        String[] values;
        values = text.split(",");
        try {
            double r,g,b;
            r = Double.parseDouble(values[0]);
            g = Double.parseDouble(values[1]);
            b = Double.parseDouble(values[2]);
            Color temp = new Color(r,g,b);
            return temp;
        } catch (Exception ex) {
            return null;
        }
    }

}