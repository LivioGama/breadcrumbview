package com.worldline.breadcrumbview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;


public class BreadcrumbView extends ViewGroup {

    private LabelDrawable.Sides startType = LabelDrawable.Sides.CLOSED;

    private LabelDrawable.Sides endType = LabelDrawable.Sides.CLOSED;

    private int margin;

    private int strokeColor = Color.WHITE;

    private int fillColor = Color.BLUE;

    private int enableFillColor = Color.BLUE;

    int viewHeight;

    private LayoutParams childLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

    public BreadcrumbView(Context context) {
        super(context);
        init(null);
    }

    public BreadcrumbView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public BreadcrumbView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BreadcrumbView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            //Load attributes from xml if any
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BreadcrumbView);
            fillColor = a.getColor(R.styleable.BreadcrumbView_fillColor, fillColor);
            enableFillColor = a.getColor(R.styleable.BreadcrumbView_enableFillColor, enableFillColor);
            strokeColor = a.getColor(R.styleable.BreadcrumbView_strokeColor, strokeColor);
            a.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int childCount = getChildCount();
        if (getLayoutParams().height == LayoutParams.WRAP_CONTENT) {
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                LabelDrawable label = new LabelDrawable();
                if (child.isFocusable()) {
                    label.setFillColor(fillColor);
                } else {
                    label.setFillColor(enableFillColor);
                }
                label.setStrokeColor(strokeColor);
                if (i == 0 && startType == LabelDrawable.Sides.CLOSED) {
                    label.setStart(LabelDrawable.Sides.CLOSED);
                } else {
                    label.setStart(LabelDrawable.Sides.OPEN);
                }
                if (i == getChildCount() - 1 && endType == LabelDrawable.Sides.CLOSED) {
                    label.setEnd(LabelDrawable.Sides.CLOSED);
                } else {
                    label.setEnd(LabelDrawable.Sides.OPEN);
                }
                child.setBackgroundDrawable(label);
                child.setLayoutParams(childLayoutParams);

                child.measure(widthMeasureSpec, heightMeasureSpec);
                if (child.getMeasuredHeight() > viewHeight) {
                    viewHeight = child.getMeasuredHeight();
                }
            }
        }
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec), viewHeight);
        margin = viewHeight / 2;
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            int viewWidth = getMeasuredWidth() / childCount + margin / 2;
            if (i > 0 && i < childCount - 1) {
                viewWidth = viewWidth + margin / 2;
            }
            int wspec = MeasureSpec.makeMeasureSpec(viewWidth, MeasureSpec.EXACTLY);
            int hspec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MeasureSpec.EXACTLY);
            child.setPadding(margin, 0, margin, 0);
            child.measure(wspec, hspec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed) {
            int viewLeft = 0;
            int viewRight;
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                viewRight = viewLeft + child.getMeasuredWidth();
                child.layout(viewLeft, 0, viewRight, viewHeight);
                viewLeft = viewRight - margin;
            }
        }
    }

    public void selectStep(int step) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.setFocusable(i != step);
        }
        requestLayout();
    }
}