package com.codeclan.DiveLog.DiveLog.components;

import com.codeclan.DiveLog.DiveLog.Utility;
import com.codeclan.DiveLog.DiveLog.models.Cylinder;
import com.codeclan.DiveLog.DiveLog.models.Dive;
import com.codeclan.DiveLog.DiveLog.models.SamplePoint;
import com.codeclan.DiveLog.DiveLog.models.ValveType;
import com.codeclan.DiveLog.DiveLog.repositories.CylinderRepository;
import com.codeclan.DiveLog.DiveLog.repositories.DiveRepository;
import com.codeclan.DiveLog.DiveLog.repositories.RegulatorRepository;
import com.codeclan.DiveLog.DiveLog.repositories.SamplePointRepository;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DiveRepository diveRepository;

    @Autowired
    SamplePointRepository samplePointRepository;

    @Autowired
    CylinderRepository cylinderRepository;

    @Autowired
    RegulatorRepository regulatorRepository;

    public DataLoader() {

    }

    private static double parseStringToDouble(String value) {
        return value == null || value.trim().isEmpty() ? 0 : Double.parseDouble(value);
    }

    private static Boolean parseStringToBoolean(String value) {
        return value == null || value.trim().isEmpty() ? false : Boolean.parseBoolean(value);
    }

    public void run(ApplicationArguments args) {
        //TODO: Put this line back if you want to load from a local file
//        readFromLocalExcelFile();
    }

    public void readFromLocalExcelFile() {

        try {
            FileInputStream file = new FileInputStream(new File("/Users/user/FinalProject/Gavin_dives.xls"));
            Workbook workbook = new HSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            Map<Integer, List<String>> data = new HashMap<>();
            int i = 0;
            for (Row row : sheet) {
                data.put(i, new ArrayList<String>());
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING: data.get(i).add(cell.getRichStringCellValue().getString()); break;
                        case NUMERIC: if (DateUtil.isCellDateFormatted(cell)) {
                            data.get(i).add(cell.getDateCellValue() + "");
                        } else {
                            data.get(i).add(cell.getNumericCellValue() + "");
                        } break;
                        case BOOLEAN: data.get(i).add(cell.getBooleanCellValue() + "");
                             break;
                        default: data.get(i).add(" ");
                    }
                }
                i++;
            }
            Utility utiilities = new Utility(diveRepository,samplePointRepository,cylinderRepository);
            utiilities.createAndSaveDive(data);
        }
        catch(FileNotFoundException fne) {
            fne.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*public void createAndSaveDive(Map<Integer, List<String>> data) throws ParseException {
//        for each key-value pair
//        get the values(arraylist)
//        construct object using index values
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat(pattern);

        int index = 0;
        for (List value : data.values()) {
            index++;
            if(index == 1){
                continue;
            }

            int diveNum = (int) Double.parseDouble(value.get(0).toString());
            Date startDate = simpleDateFormatDate.parse(value.get(1)+" "+value.get(2));
            int surfaceInterval = (int) Double.parseDouble(value.get(4).toString());
            int duration = (int) Double.parseDouble(value.get(3).toString());

            Calendar endTime = Calendar.getInstance();
            endTime.setTime(startDate);
            endTime.add(Calendar.SECOND, duration);
//            to split up the profile list use string.split(",")
//            this will return an array of strings which i can then cast to doubles.
            System.out.println(startDate.getTime()+" "+endTime.getTime());
            System.out.println(simpleDateFormatDate.format(endTime.getTime()));
            String[] profileArray = value.get(29).toString().split(",");

//            Dive object data
            int maxDepth = (int) parseStringToDouble(value.get(5).toString());
            int averageDepth = (int) parseStringToDouble(value.get(6).toString());
            String place = value.get(7).toString();
            String diveSite = value.get(8).toString();
            Double latitude = parseStringToDouble(value.get(9).toString());
            Double longitude = parseStringToDouble(value.get(10).toString());
            String weather = value.get(11).toString();
            int airTemp = (int) parseStringToDouble(value.get(13).toString());
            int bottomTemp = (int) parseStringToDouble(value.get(14).toString());
            int surfaceTemp = (int) parseStringToDouble(value.get(15).toString());
            String buddy = value.get(16).toString();
            String boat = value.get(17).toString();
            double weight = parseStringToDouble(value.get(15).toString());
            String notes = value.get(27).toString();
            int sampleRate = (int) parseStringToDouble(value.get(28).toString());
//            Cylinder object data
            int cylinderVolume = (int) parseStringToDouble(value.get(19).toString());
            int workingPressure = (int) parseStringToDouble(value.get(20).toString());
            Boolean twinSet = (Boolean) parseStringToBoolean(value.get(21).toString());
            int barStart = (int) parseStringToDouble(value.get(22).toString());
            int barEnd = (int) parseStringToDouble(value.get(23).toString());
            int o2Mix = (int) parseStringToDouble(value.get(24).toString());

//            Creates a dive every iteration and saves it
            Dive dive = new Dive(diveNum, startDate, endTime, surfaceInterval, maxDepth, averageDepth, place, diveSite, latitude, longitude, weather, airTemp, bottomTemp, surfaceTemp, buddy, boat, weight, notes, sampleRate);
            diveRepository.save(dive);

//            Splits the list of sample points by , and creates new SamplePoint objects with the values
            for (String sample: profileArray){
                SamplePoint samplePoint = new SamplePoint(parseStringToDouble(sample), dive);
                samplePointRepository.save(samplePoint);
            }
//            Creates a new cylinder object related to every dive per iteration
            Cylinder cylinder = new Cylinder(dive, null, null, null, null, ValveType.DIN, cylinderVolume, workingPressure, twinSet, barStart, barEnd, o2Mix, null);
            cylinderRepository.save(cylinder);
        }

    }*/
}
