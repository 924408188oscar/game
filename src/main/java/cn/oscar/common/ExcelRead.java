package cn.oscar.common;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelRead {
    private static final short SHEET_CELL_ENCODING = HSSFCell.ENCODING_UTF_16;


    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("werrrrrrrrrrrrrrr");

        File file=new File("d:\\0908.xlsx");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader reader = new InputStreamReader(fis,"GBK");

//        try {
//            InputStream inputStream = new FileInputStream("file.xml");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


        XSSFWorkbook workbook = null;
        InputStream inStream = null;

        try {
            inStream=new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            workbook = new XSSFWorkbook(inStream);

            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row cells : sheet) {

                for (Cell cell : cells) {

                    if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.print(String.valueOf(cell.getNumericCellValue())+ '\t');
                    } else if (cell.getCellType() == CellType.STRING) {
                        //System.out.print(cell.getStringCellValue() + '\t');
                        String str=cell.getStringCellValue();
                        System.out.print(str+ '\t');


                    }
                }
                System.out.println();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("sssssssss33333333sssssssssss");
            try {
                //关闭资源
                if (workbook != null) {
                    workbook.close();
                    System.out.println("ssssssssssssssssssss");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}



