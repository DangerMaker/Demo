package com.compass.common.utils;

import com.compass.common.R;

public class CalculateUtil {

    public static float decm(int price, int exp) {
        switch (exp) {
            case 0:
                return (float) (price / 0.01);
            case 1:
                return (float) (price / 0.1);
            case 2:
                return (float) (price / 1.0);
            case 3:
                return (float) (price / 10.0);
            case 4:
                return (float) (price / 100.0);
            case 5:
                return (float) (price / 1000.0);
            case 6:
                return (float) (price / 10000.0);
            case 7:
                return (float) (price / 100000.0);
            default:
                return 0;
        }
    }

    public static String prefix(float current,float lastclose){
        if(current > lastclose){
            return "+";
        }else if(current < lastclose){
            return "-";
        }else {
            return "";
        }
    }

}
