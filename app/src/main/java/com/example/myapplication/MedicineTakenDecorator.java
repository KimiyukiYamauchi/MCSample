package com.example.myapplication;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import java.util.HashSet;

public class MedicineTakenDecorator implements DayViewDecorator {

    private HashSet<CalendarDay> dates;

    public MedicineTakenDecorator(HashSet<CalendarDay> dates) {
        this.dates = dates;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        // デコレーションを適用する日付を判定
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {

        // "服用済" を小さな青い文字で追加
        SpannableString spanString = new SpannableString("服用済");
        spanString.setSpan(new ForegroundColorSpan(Color.BLUE), 0, spanString.length(), 0);
        spanString.setSpan(new RelativeSizeSpan(0.6f), 0, spanString.length(), 0);  // 文字サイズを縮小
        Log.d("MedicineTakenDecorator", "decorate view = " + view + " spanString = " + spanString);
        view.addSpan(spanString);  // 日付の下にスパンとして追加
    }
}
