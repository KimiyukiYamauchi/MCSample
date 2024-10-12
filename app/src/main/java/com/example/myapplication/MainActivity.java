package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialCalendarView calendarView = findViewById(R.id.calendarView);

        // 服用済みの日付を設定
        HashSet<CalendarDay> medicineTakenDates = new HashSet<>();
        medicineTakenDates.add(CalendarDay.from(2024, 10, 17)); // 例: 2024年10月10日
        medicineTakenDates.add(CalendarDay.from(2024, 10, 18)); // 例: 2024年10月11日

        // カスタムDayFormatterを適用
        calendarView.setDayFormatter(new MedicineDayFormatter(medicineTakenDates));

        // デコレーターで服用済みの日付をハイライト
        calendarView.addDecorator(new MedicineTakenDecorator(medicineTakenDates));

        // 現在の日付にデコレーターを適用する
        CalendarDay today = CalendarDay.today();
        calendarView.addDecorator(new MyDayDecorator(today));

        // 複数の日付にデコレーターを適用する
        CalendarDay anotherDay = CalendarDay.from(2024, 10, 5);
        MyDayDecorator myDayDecorator = new MyDayDecorator(anotherDay);
        calendarView.addDecorator(myDayDecorator);

        // 現在の日付より前を無効化
//        calendarView.addDecorator(new DisableDayDecorator());

        // 特定の日付に背景色を設定する
        CalendarDay anotherDay2 = CalendarDay.from(2024, 10, 24);
        calendarView.addDecorator(new CustomBackgroundDecorator(MainActivity.this, anotherDay2));



        // デコレータの削除
//        calendarView.removeDecorator(myDayDecorator);

        calendarView.invalidateDecorators();
    }
}
