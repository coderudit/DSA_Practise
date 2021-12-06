package com.dsa.app;

import com.dsa.app.level1._1_decimal_to_binary;
import com.dsa.app.level1._2_binary_to_decimal;
import com.dsa.app.level1._3_anybaseA_to_anybaseB;

public class Main {

    public static void main(String[] args) {
        //int baseNumber = _1_decimal_to_binary.convertDecimalToAnyBase(37, 2);
        //int decimalNumber = _2_binary_to_decimal.convertAnyBaseToDecimal(100101, 2, 10);

        _3_anybaseA_to_anybaseB.convertFromBaseAToBaseB("10B", 16, 10);
    }
}
