package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;

public class TextDrawable extends ShapeDrawable {
    private String text;
    private Paint textPaint;

    public TextDrawable(Context context, String text) {
        super(new RectShape());
        this.text = text;

        // テキストのペイント設定
        textPaint = new Paint();
        textPaint.setColor(Color.WHITE); // テキスト色
        textPaint.setTextSize(40); // テキストサイズ
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
        super.onDraw(shape, canvas, paint);

        // テキストをキャンバスに描画
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        canvas.drawText(text, canvasWidth / 2, canvasHeight - 20, textPaint); // テキストを中心に描画
    }
}
