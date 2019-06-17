package com.badminton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookingManager {


    static HashMap<Room, HashMap<SimpleDate, User>> bookedMap = new HashMap<>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        String line = "";
        while (line.length() != 1 && line != " ") {
            line = sc.nextLine();
            if (line.length() != 1 && line != " "){

            }
               // mainProcess(line);
        }

        //printResult();

//		链接：https://www.nowcoder.com/questionTerminal/4c3d325a70fd4fb4909e2fe1c42fba71?toCommentId=1352361
//			来源：牛客网
//
//			// String [] line = new String[6];
//			 
//			// line[0] = "U002 2017-08-01 19:00~22:00 A";
//			 
//			// line[1] = "U003 2017-08-01 18:00~20:00 A";
//			 
//			// line[2] = "U002 2017-08-01 19:00~22:00 A C";
//			 
//			// line[3] = "U002 2017-08-01 19:00~22:00 A C";
//			 
//			// line[4] = "U003 2017-08-01 18:00~20:00 A";
//			 "(U) (\\d{3}) (\\s) (\\d{4) (-) (\\d{2}) (-) (\\d{2}) (\\s) (\\d{2})(:)(00)(~)(\\d{2}(:)(00) (\\s) ([A-D])) "
//			// line[5] = "U003 2017-08-02 13:00~17:00 B";
//			 
//			// for (String l:line) {
//			 
//			// mainProcess(l);;
//			 
//			// }
//			 
//			// printResult();
    }

}