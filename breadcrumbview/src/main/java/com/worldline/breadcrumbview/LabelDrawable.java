package com.worldline.breadcrumbview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * Created by a511218 on 11/01/2016.
 */
public class LabelDrawable extends Drawable {

    public enum Sides {OPEN, CLOSED}

    private Paint fillPaint;

    private Paint strokePaint;

    private Path path;

    private Sides start = Sides.CLOSED;

    private Sides end = Sides.OPEN;

    private int fillColor = Color.RED;

    private int strokeColor = Color.BLUE;

    public LabelDrawable() {
        fillPaint = new Paint();
        fillPaint.setAntiAlias(true);
        fillPaint.setStyle(Paint.Style.FILL);

        strokePaint = new Paint();
        strokePaint.setAntiAlias(true);
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setStrokeWidth(1);

        path = new Path();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawPath(path, fillPaint);
        canvas.drawPath(path, strokePaint);
    }

    private void updatePath(Rect bounds) {
        int h = bounds.bottom - bounds.top;
        fillPaint.setColor(fillColor);
        strokePaint.setColor(strokeColor);

        path.reset();

        path.moveTo(bounds.left, bounds.top);

        if (end == Sides.OPEN) {
            path.lineTo(bounds.right - h / 2, 0);
            path.lineTo(bounds.right, bounds.top + h / 2);
            path.lineTo(bounds.right - h / 2, bounds.bottom);
        } else {
            path.lineTo(bounds.right, bounds.top);
            path.lineTo(bounds.right, bounds.bottom);
        }
        path.lineTo(bounds.left, bounds.bottom);
        if (start == Sides.OPEN) {
            path.lineTo(bounds.left + h / 2, bounds.top + h / 2);
        }
        path.close();
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        updatePath(bounds);
    }

    public void setStart(Sides start) {
        this.start = start;
        this.invalidateSelf();
    }

    public void setEnd(Sides end) {
        this.end = end;
        this.invalidateSelf();
    }

    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
        invalidateSelf();
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }

    @Override
    public void setAlpha(int alpha) {
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
    }
}