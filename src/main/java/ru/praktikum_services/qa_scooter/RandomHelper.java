package ru.praktikum_services.qa_scooter;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class RandomHelper {

    public static String getString(int length) {
        byte[] array = new byte[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = (byte) (97 + random.nextInt(26));
        }

        return new String(array, StandardCharsets.UTF_8);
    }

    public static int getInt() {
        return new Random().nextInt();
    }

    public static String getFormattedDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, new Random().nextInt(10));
        return calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
    }
}
