package com.youku.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TriangleView extends ImageView {
    public static int BOTTOM_LEFT = 2;
    public static int BOTTOM_RIGHT = 3;
    public static int TOP_LEFT = 0;
    public static int TOP_LEFT_1_3 = 4;
    public static int TOP_LEFT_4_9 = 5;
    public static int TOP_RIGHT = 1;
    private int color;
    private int direction;

    public TriangleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.color = -16776961;
        this.direction = TOP_LEFT;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.color == -16776961) {
            return;
        }
        Path path = new Path();
        int i = this.direction;
        if (i == TOP_LEFT) {
            path.moveTo(0.0f, 0.0f);
            path.lineTo(getWidth(), 0.0f);
            path.lineTo(0.0f, getHeight());
            path.lineTo(0.0f, 0.0f);
        } else if (i == TOP_RIGHT) {
            path.moveTo(0.0f, 0.0f);
            path.lineTo(getWidth(), 0.0f);
            path.lineTo(getWidth(), getHeight());
            path.lineTo(0.0f, 0.0f);
        } else if (i == BOTTOM_LEFT) {
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, getHeight());
            path.lineTo(getWidth(), getHeight());
            path.lineTo(0.0f, 0.0f);
        } else if (i == BOTTOM_RIGHT) {
            path.moveTo(getWidth(), 0.0f);
            path.lineTo(getWidth(), getHeight());
            path.lineTo(0.0f, getHeight());
            path.lineTo(getWidth(), 0.0f);
        } else if (i == TOP_LEFT_1_3) {
            path.moveTo(getWidth() / 3, 0.0f);
            path.lineTo(getWidth(), 0.0f);
            path.lineTo(0.0f, getHeight());
            path.lineTo(0.0f, getHeight() / 3);
            path.lineTo(getWidth() / 3, 0.0f);
        } else if (i == TOP_LEFT_4_9) {
            path.moveTo((getWidth() * 4) / 9, 0.0f);
            path.lineTo(getWidth(), 0.0f);
            path.lineTo(0.0f, getHeight());
            path.lineTo(0.0f, (getHeight() * 4) / 9);
            path.lineTo((getWidth() * 4) / 9, 0.0f);
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new PathShape(path, getWidth(), getHeight()));
        shapeDrawable.getPaint().setColor(this.color);
        shapeDrawable.setBounds(0, 0, getWidth(), getHeight());
        shapeDrawable.setAlpha(192);
        shapeDrawable.draw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.color = i;
        postInvalidate();
    }

    public void setDirection(int i) {
        this.direction = i;
    }

    public TriangleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.color = -16776961;
        this.direction = TOP_LEFT;
    }

    public TriangleView(Context context) {
        super(context);
        this.color = -16776961;
        this.direction = TOP_LEFT;
    }
}
