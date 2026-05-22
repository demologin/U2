package com.javarush.module2.lesson02.calc;

import com.javarush.module2.lesson02.calc.api.Add;
import com.javarush.module2.lesson02.calc.api.Div;
import com.javarush.module2.lesson02.calc.api.Mul;
import com.javarush.module2.lesson02.calc.api.Sub;

public interface Operation extends Add, Sub, Mul, Div {

}
