package com.taobao.update.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.taobao.tao.update.common.R$id;
import tb.cw2;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class Button extends CustomView {
    static final String ANDROIDXML = "http://schemas.android.com/apk/res/android";
    int background;
    int backgroundColor;
    boolean clickAfterRipple;
    int minHeight;
    int minWidth;
    View.OnClickListener onClickListener;
    float radius;
    Integer rippleColor;
    int rippleSize;
    float rippleSpeed;
    TextView textButton;
    float x;
    float y;

    public Button(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rippleSpeed = 12.0f;
        this.rippleSize = 3;
        this.clickAfterRipple = true;
        this.backgroundColor = Color.parseColor("#1E88E5");
        this.x = -1.0f;
        this.y = -1.0f;
        this.radius = -1.0f;
        setDefaultProperties();
        this.clickAfterRipple = attributeSet.getAttributeBooleanValue(m80.RES_AUTO_NAMESPACE, "animate", true);
        setAttributes(attributeSet);
        this.beforeBackground = this.backgroundColor;
        if (this.rippleColor == null) {
            this.rippleColor = Integer.valueOf(makePressColor());
        }
    }

    public float getRippleSpeed() {
        return this.rippleSpeed;
    }

    public String getText() {
        return this.textButton.getText().toString();
    }

    public TextView getTextView() {
        return this.textButton;
    }

    public Bitmap makeCircle() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth() - cw2.dpToPx(6.0f, getResources()), getHeight() - cw2.dpToPx(7.0f, getResources()), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.rippleColor.intValue());
        canvas.drawCircle(this.x, this.y, this.radius, paint);
        if (this.radius > getHeight() / this.rippleSize) {
            this.radius += this.rippleSpeed;
        }
        if (this.radius >= getWidth()) {
            this.x = -1.0f;
            this.y = -1.0f;
            this.radius = getHeight() / this.rippleSize;
            View.OnClickListener onClickListener = this.onClickListener;
            if (onClickListener != null && this.clickAfterRipple) {
                onClickListener.onClick(this);
            }
        }
        return createBitmap;
    }

    protected int makePressColor() {
        int i = this.backgroundColor;
        int i2 = (i >> 8) & 255;
        int i3 = (i >> 0) & 255;
        int i4 = ((i >> 16) & 255) - 30;
        if (i4 < 0) {
            i4 = 0;
        }
        int i5 = i2 - 30;
        if (i5 < 0) {
            i5 = 0;
        }
        int i6 = i3 - 30;
        return Color.rgb(i4, i5, i6 >= 0 ? i6 : 0);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            return;
        }
        this.x = -1.0f;
        this.y = -1.0f;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        invalidate();
        if (isEnabled()) {
            this.isLastTouch = true;
            if (motionEvent.getAction() == 0) {
                this.radius = getHeight() / this.rippleSize;
                this.x = motionEvent.getX();
                this.y = motionEvent.getY();
            } else if (motionEvent.getAction() == 2) {
                this.radius = getHeight() / this.rippleSize;
                this.x = motionEvent.getX();
                this.y = motionEvent.getY();
                if (motionEvent.getX() > getWidth() || motionEvent.getX() < 0.0f || motionEvent.getY() > getHeight() || motionEvent.getY() < 0.0f) {
                    this.isLastTouch = false;
                    this.x = -1.0f;
                    this.y = -1.0f;
                }
            } else if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= getWidth() && motionEvent.getX() >= 0.0f && motionEvent.getY() <= getHeight() && motionEvent.getY() >= 0.0f) {
                    this.radius += 1.0f;
                    if (!this.clickAfterRipple && (onClickListener = this.onClickListener) != null) {
                        onClickListener.onClick(this);
                    }
                } else {
                    this.isLastTouch = false;
                    this.x = -1.0f;
                    this.y = -1.0f;
                }
            } else if (motionEvent.getAction() == 3) {
                this.isLastTouch = false;
                this.x = -1.0f;
                this.y = -1.0f;
            }
        }
        return true;
    }

    protected abstract void setAttributes(AttributeSet attributeSet);

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.backgroundColor = i;
        if (isEnabled()) {
            this.beforeBackground = this.backgroundColor;
        }
        try {
            ((GradientDrawable) ((LayerDrawable) getBackground()).findDrawableByLayerId(R$id.shape_bacground)).setColor(this.backgroundColor);
            this.rippleColor = Integer.valueOf(makePressColor());
        } catch (Exception unused) {
        }
    }

    protected void setDefaultProperties() {
        setMinimumHeight(cw2.dpToPx(this.minHeight, getResources()));
        setMinimumWidth(cw2.dpToPx(this.minWidth, getResources()));
        setBackgroundResource(this.background);
        setBackgroundColor(this.backgroundColor);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setRippleSpeed(float f) {
        this.rippleSpeed = f;
    }

    public void setText(String str) {
        this.textButton.setText(str);
    }

    public void setTextColor(int i) {
        this.textButton.setTextColor(i);
    }
}
