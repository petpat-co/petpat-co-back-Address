package com.example.address.Address;


import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AddressDataService {

    @Autowired
    private AddressDataRepository repository;

    @PostConstruct
    public void saveDataFromExcel( ) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\장윤희\\Desktop\\Address\\src\\main\\resources\\addressdata.xlsx"));
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        rowIterator.next();
        rowIterator.next();

        while(rowIterator.hasNext()){
            Row row = rowIterator.next();

            String col4= row.getCell(3).getStringCellValue();
            if(col4.substring(col4.length()-1).equals("리")) continue;

            String col1 = row.getCell(0).getStringCellValue();
            String col2 = row.getCell(1).getStringCellValue();
            String col3 = row.getCell(2).getStringCellValue();
            AddressData data = new AddressData(col1,col2,col3,col4);
            


            if(!repository.existsByProvinceAndCityAndDistrictAndTown(col1,col2,col3,col4)) repository.save(data);
        }
    }
}
