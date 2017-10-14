package algo;

import javax.rmi.CORBA.Util;

import static algo.Utils.*;

/**
 * Created by alexey on 14.10.17.
 */
public class Adams {
    public static double[] solve(double h, double[] x) {
        double[] y = new double[x.length];

        for (int i = 0; i < 4; i++) {
            y[i] = solution(x[i]);
        }

        for (int i = 3; i < x.length - 1; i++) {
            y[i + 1] = y[i] + h * (55 * func(x[i], y[i]) - 59 * func(x[i - 1], y[i - 1])
                    + 37 * func(x[i - 2], y[i - 2]) - 9 * func(x[i - 3], y[i - 3])) / 24;
        }

        return y;
    }
}
