package org.example.exporter;

import org.example.model.Teacher;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {
    public void export(List<Teacher> teachers, String fileName)throws IOException{
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("计算机学院教师信息");

        createHeaderRow(sheet);
        fillDataRows(sheet,teachers);
        autoSizeColumns(sheet);

        try(FileOutputStream fileOut = new FileOutputStream(fileName)){
            workbook.write(fileOut);
        }
        workbook.close();
        System.out.println("Excel 文件已生成：" + fileName);
    }
    private void createHeaderRow(Sheet sheet){
        Row headerRow = sheet.createRow(0);
        String[] headers = {"姓名","个人主页链接","个人简介","邮箱","研究方向"};
        for(int i = 0; i < headers.length; i++){
            headerRow.createCell(i).setCellValue(headers[i]);
        }
    }

    private void fillDataRows(Sheet sheet,List<Teacher> teachers){
        int rowNum = 1;
        for(Teacher teacher: teachers){
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(teacher.getName());
            row.createCell(1).setCellValue(teacher.getProfileUrl());
            row.createCell(2).setCellValue(teacher.getBio());
            row.createCell(3).setCellValue(teacher.getEmail());
            row.createCell(4).setCellValue(teacher.getResearch());
        }
    }
    private void autoSizeColumns(Sheet sheet){
        for(int i = 0; i < 5; i++){
            sheet.autoSizeColumn(i);
            if(sheet.getColumnWidth(i) > 20000){
                sheet.setColumnWidth(i,20000);
            }
        }
    }

}
