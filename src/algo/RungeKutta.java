package algo;

import javax.rmi.CORBA.Util;

/**
 * Created by alexey on 14.10.17.
 */
public class RungeKutta {

    public static double[] solve(double h, double[] x, double y) {
        double[] result = new double[x.length];

        double k1, k2, k3, k4;

        for (int i = 0; i < x.length; i++) {
            result[i] = y;

            k1 = Utils.func(x[i], y);
            k2 = Utils.func(x[i] + h / 2 , y + h * k1 / 2);
            k3 = Utils.func(x[i] + h / 2 , y + h * k2 / 2);
            k4 = Utils.func(x[i] + h, y + h * k3);

            double yDelta = h / 6 * (k1 + 2 * k2 + 2 * k3 + k4);
            y = y + yDelta;
        }

        return result;
    }

}
