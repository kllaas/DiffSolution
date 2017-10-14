import algo.Adams;
import algo.RungeKutta;
import algo.Utils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alexey on 14.10.17.
 */
public class Main {

    private static final String FILE_NAME = "results.xlsx";

    public static void main(String[] args) {
        double xStart = 2, xEnd = 3, h = 0.1;

        int size = (int) ((xEnd - xStart) / h);

        double[] X = new double[size];
        double[] Y = new double[size];

        X[0] = xStart;
        Y[0] = Utils.solution(xStart);
        for (int i = 1; i < X.length; i++) {
            X[i] = X[i - 1] + h;
            Y[i] = Utils.solution(X[i]);
        }

        double[] yRungeKytta = RungeKutta.solve(h, X, Y[0]);
        double[] yAdams = Adams.solve(h, X);

        saveResults(X, Y, yRungeKytta, yAdams);
    }

    private static void saveResults(double[] x, double[] y, double[] yRungeKytta, double[] yAdams) {
        ArrayList<double[]> results = new ArrayList<>();
        results.add(x);
        results.add(y);
        results.add(yRungeKytta);
        results.add(yAdams);
        results.add(Utils.getError(y, yRungeKytta));
        results.add(Utils.getError(y, yAdams));

        try {
            Utils.printToFile(results, FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
