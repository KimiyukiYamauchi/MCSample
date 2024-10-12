package com.example.myapplication;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.format.DayFormatter;
import java.util.HashSet;

public class MedicineDayFormatter implements DayFormatter {

    private HashSet<CalendarDay> medicineTakenDates;

    // 服薬済みの日付をセット
    public MedicineDayFormatter(HashSet<CalendarDay> medicineTakenDates) {
        this.medicineTakenDates = medicineTakenDates;
    }

    @Override
    public String format(CalendarDay day) {
        // 服用済みの日付には「服用済」と表示
        if (medicineTakenDates.contains(day)) {
            return day.getDay() + "\n服用済";  // 日付と「服用済」を表示
        } else {
            // 通常の日付はそのまま表示
            return String.valueOf(day.getDay());
        }
    }
}
