package com.badminton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyClass {
    static String str[] = new String[21];
    /**
     * str[1] =user id
     * start year
     * start month
     * start day
     * start clock
     * end clock
     * accept
     * cancel
     */

    static int minStartClock = 9;
    static int maxStartClock = 22;
    static List<Customer> booklist = new LinkedList<>();
    static List<Customer> cancellist = new ArrayList<>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        String line = "";
        while (line.length() != 1 && line != " ") {
            line = sc.nextLine();
            if (line.length() != 1 && line != " ")
                mainProcess(line);
        }

        printResult();

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


    private static void mainProcess(String line) {
        // TODO Auto-generated method stub
        String userID;
        int year;
        int month;
        int day;
        int startClock;
        int endClock;
        String place;

        String bookPattern = "(U)(\\d{3})(\\s)(\\d{4})(-)(\\d{2})(-)(\\d{2})(\\s)(\\d{2})(:)(00)(~)(\\d{2})(:)(00)(\\s)([A-D])";
        String cancelPattern = "(U)(\\d{3})(\\s)(\\d{4})(-)(\\d{2})(-)(\\d{2})(\\s)(\\d{2})(:)(00)(~)(\\d{2})(:)(00)(\\s)([A-D])(\\s)([C])";
        boolean isBook = Pattern.matches(bookPattern, line);
        boolean isCancel = Pattern.matches(cancelPattern, line);

        if (isBook) {
            Pattern p = Pattern.compile(bookPattern);
            Matcher m = p.matcher(line);
            m.find();
            //save to str
            for (int j = 0; j < m.groupCount() + 1; j++) {
                str[j] = m.group(j);

            }
            userID = str[2];
            year = Integer.valueOf(str[4]);
            month = Integer.valueOf(str[6]);
            day = Integer.valueOf(str[8]);
            startClock = Integer.valueOf(str[10]);
            endClock = Integer.valueOf(str[14]);
            place = str[18];

            if (Integer.valueOf(startClock) == Integer.valueOf(endClock)
                    || Integer.valueOf(startClock) < minStartClock
                    || Integer.valueOf(endClock) > maxStartClock

            )
                printInvalidError();
            else {
                Customer cus = new Customer(userID, year, month, day, startClock, endClock, place);
                book(cus);
            }
        } else if (isCancel) {
            Pattern p = Pattern.compile(cancelPattern);
            Matcher m = p.matcher(line);
            m.find();

            for (int j = 0; j < m.groupCount() + 1; j++) {
                str[j] = m.group(j);
            }
            userID = str[2];
            year = Integer.valueOf(str[4]);
            month = Integer.valueOf(str[6]);
            day = Integer.valueOf(str[8]);
            startClock = Integer.valueOf(str[10]);
            endClock = Integer.valueOf(str[14]);
            place = str[18];

            Customer cus = new Customer(userID, year, month, day, startClock, endClock, place);
            cancelBook(cus);
        } else
            printInvalidError();

    }

    private static void cancelBook(Customer cus) {
        // TODO Auto-generated method stub
        boolean rem = false;
        for (Customer c : booklist) {
            if (cus.equals(c)) {
                booklist.remove(c);
                printBookSuccess();
                rem = true;
            }
        }
        if (!rem)
            printCancelError();
    }

    public static void printResult() {
        String[] placeIncome = new String[4];
        int[] placePrice = new int[4];
        int bookIncome;
        int CancelIncome;
        for (int j = 'A', k = 0; j <= 'D'; j++, k++) {
            placeIncome[k] = "场地" + String.valueOf((char) (j)) + ":\n";
        }
        System.out.println("\n" + "收入汇总\n" + "---");
        for (Customer c : booklist) {
            bookIncome = calPrice(c);
            for (int j = 'A', k = 0; j <= 'D'; j++, k++) {
                if (String.valueOf((char) (j)).equals(c.place)) {
                    placePrice[k] += bookIncome;
                    placeIncome[k] += (c.year + "-" + (c.month < 10 ? ("0" + c.month) : c.month)
                            + (c.startClock < 10 ? ("0" + c.startClock) : c.startClock + ":" + "00~")
                            + (c.endClock < 10 ? ("0" + c.endClock) : c.endClock + ":00" + " " + bookIncome + "元" + "\n")
                    );
                }
            }
        }

        for (Customer c : cancellist) {
            CancelIncome = calCancel(c);
            for (int j = 'A', k = 0; j <= 'D'; j++, k++) {
                if (String.valueOf((char) (j)).equals(c.place)) {
                    placeIncome[k] += (c.year + "-" + (c.month < 10 ? ("0" + c.month) : c.month)
                            + (c.startClock < 10 ? ("0" + c.startClock) : c.startClock) + ":00~"
                            + (c.endClock < 10 ? ("0" + c.endClock) : c.endClock) + ":00"
                            + " 违约金 " + CancelIncome + "元\n")
                    ;
                }
            }

        }
        int i = 0;
        int sumPrice = 0;
        for (String p : placeIncome) {
            sumPrice += placePrice[i];
            System.out.print(p);
            System.out.println("小计：" + placePrice[i++] + "元");
            System.out.println();
        }
        System.out.println("---\n" + "总计：" + sumPrice + "元");
    }

    private static int calCancel(Customer c) {
        // TODO Auto-generated method stub
        return (int) (calPrice(c));
    }

    private static int calPrice(Customer c) {
        // TODO Auto-generated method stub
        int[] workdayPrice = {30, 50, 80, 60};
        int[] weekdayPrice = {40, 50, 60};
        int week = getWeek(c);
        int price = 0;

        if (week <= 5) {
            if (c.startClock >= 9 && c.startClock <= 12) {
                if (c.endClock >= 9 && c.endClock <= 12) {
                    price = (c.endClock - c.startClock) * workdayPrice[0];

                } else if (c.endClock > 12 && c.endClock <= 18) {
                    price = (12 - c.startClock) * workdayPrice[0] + (c.endClock - 12) * workdayPrice[1];
                } else if (c.endClock > 18 && c.endClock <= 20) {
                    price = (12 - c.startClock) * workdayPrice[0] + (18 - 12) * workdayPrice[1] + (c.endClock - 18) * workdayPrice[2];

                } else if (c.endClock > 20 && c.endClock <= 22) {
                    price = (12 - c.startClock) * workdayPrice[0] + (18 - 12) * workdayPrice[1] + (20 - 18) * workdayPrice[2] + (c.endClock - 20) * workdayPrice[3];
                }
            } else if (c.startClock > 12 && c.startClock <= 18) {
                if (c.endClock >= 12 && c.endClock <= 18)
                    price = (c.endClock - c.startClock) * workdayPrice[1];
                else if (c.endClock > 18 && c.endClock <= 20)
                    price = (18 - c.startClock) * workdayPrice[1]
                            + (c.endClock - 18) * workdayPrice[2];
                else if (c.endClock > 20 && c.endClock <= 22)
                    price = (18 - c.startClock) * workdayPrice[1] + (20 - 18) * workdayPrice[2]
                            + (c.endClock - 20) * workdayPrice[3];
            } else if (c.startClock > 18 && c.startClock <= 20) {

                if (c.endClock >= 18 && c.endClock <= 20)
                    price = (c.endClock - c.startClock) * workdayPrice[2];
                else if (c.endClock > 20 && c.endClock <= 22) {
                    price = (20 - c.startClock) * workdayPrice[2] + (c.endClock - 20) * workdayPrice[3];
                }
            } else if (c.startClock > 20 && c.startClock <= 22) {
                price = (c.endClock - c.startClock) * workdayPrice[3];
            }
        } else {
            if (c.startClock >= 9 && c.endClock <= 12) {
                if (c.endClock > 9 && c.endClock <= 12) {
                    price = (c.endClock - c.startClock) * weekdayPrice[0];
                } else if (c.endClock > 12 && c.endClock <= 18) {
                    price = (12 - c.startClock) * weekdayPrice[0] + (c.endClock - 12) * weekdayPrice[1];
                } else if (c.endClock > 18 && c.endClock <= 22) {
                    price = (12 - c.startClock) * weekdayPrice[0] + (18 - 12) * weekdayPrice[1]
                            + (c.endClock - 18) * weekdayPrice[2];
                }
            } else if (c.startClock > 12 && c.startClock <= 18) {
                if (c.endClock > 12 && c.endClock <= 18)
                    price = (c.endClock - c.startClock) * weekdayPrice[1];
                else if (c.endClock > 18 && c.endClock <= 22)
                    price = (18 - c.startClock) * weekdayPrice[1] + (c.endClock - 18) * weekdayPrice[2];
            } else if (c.startClock > 18 && c.startClock <= 22) {
                price = (c.endClock - c.startClock) * weekdayPrice[2];
            }
        }
        return price;
    }

    private static int getWeek(Customer c) {
        // TODO Auto-generated method stub
        String[] weeks = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        String strDate = c.year + "-" + c.month + "-" + c.day;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = f.parse(strDate);
        } catch (ParseException e) {
            System.out.println("输入的日期格式不合理");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String week = sdf.format(date);
        for (int i = 0; i < weeks.length; i++) {
            if (week.equals(weeks[i]))
                return ++i;
        }
        return 0;
    }

    private static void printCancelError() {
        // TODO Auto-generated method stub
        System.out.println("Error: the booking being cancelled does not exist!");
    }

    private static void book(Customer cus) {
        // TODO Auto-generated method stub
        for (Customer c : booklist) {
            if (c.isTimeConflict(cus)) {
                printConfictError();
                return;
            }
        }
        booklist.add(cus);
        printBookSuccess();

    }

    private static void printBookSuccess() {
        // TODO Auto-generated method stub
        System.out.println("Success: the booking is accepted!");
    }

    private static void printConfictError() {
        // TODO Auto-generated method stub
        System.out.println("Error: the booking conflicts with existing bookings!");
    }

    private static void printInvalidError() {
        // TODO Auto-generated method stub
        System.out.println("Error: the booking is invalid!");
    }
}