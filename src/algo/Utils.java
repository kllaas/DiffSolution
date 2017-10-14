package algo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alexey on 14.10.17.
 */
public class Utils {

    public static double func(double x, double y) {
        return (2 * x + y - 3) / (x - 1);
//        return (x + y);
    }

    public static double solution(double x) {
        return 2 * (x - 1) * Math.log(x - 1) + 1;
//        return 2 * Math.pow(Math.E, x) - x - 1;
    }

    public static void printToFile(ArrayList<double[]> colums, String fileName) throws IOException {
        FileInputStream file = new FileInputStream(new File(fileName));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(fileName) == null ? workbook.createSheet(fileName)
                : workbook.getSheet(fileName);
        for (int colNum = 0; colNum < colums.size(); colNum++) {

            double[] currData = colums.get(colNum);

            for (int rowNum = 1; rowNum <= currData.length; rowNum++) {
                Row row = sheet.getRow(rowNum) == null ? sheet.createRow(rowNum) : sheet.getRow(rowNum);
                Cell cell = row.createCell(colNum);

                cell.setCellValue(currData[rowNum - 1]);
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double[] getError(double[] original, double[] achived) {
        double[] errors = new double[original.length];

        for (int i = 0; i < original.length; i++) {
            errors[i] += Math.abs(original[i] - achived[i]);
        }

        return errors;
    }
}
