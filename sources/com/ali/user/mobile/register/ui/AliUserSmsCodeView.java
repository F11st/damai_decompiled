package com.ali.user.mobile.register.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.utils.ScreenUtil;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AliUserSmsCodeView extends View {
    protected boolean autoHideKeyboard;
    protected float mBorderWidth;
    protected float mBorderheight;
    protected float mDividerWidth;
    protected int mHeight;
    protected int mNextUnderLineColor;
    private OnCompletedListener mOnCompletedListener;
    private OnTextChangedListener mOnTextChangedListener;
    protected RectF[] mOuterRects;
    protected StringBuilder mTextBuilder;
    private int mTextColor;
    protected int mTextCount;
    protected Paint mTextPaint;
    protected PointF[] mTextPositions;
    protected RectF[] mTextRects;
    protected float mTextSize;
    protected int mUnderLineColor;
    protected Paint mUnderLinePaint;
    protected float mUnderLineStrokeWidth;
    protected int mWidth;
    protected int padding;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnCompletedListener {
        void onCompleted(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnTextChangedListener {
        void onTextChanged(String str);
    }

    public AliUserSmsCodeView(Context context) {
        super(context);
        this.mTextColor = -16777216;
        this.mTextSize = 36.0f;
        this.mTextCount = 6;
        this.padding = 10;
        this.mDividerWidth = 6.0f;
        this.mUnderLineColor = -16777216;
        this.mNextUnderLineColor = -16777216;
        this.mUnderLineStrokeWidth = 1.0f;
        this.mBorderWidth = ScreenUtil.dip2px(getContext(), 36.0f);
        this.mBorderheight = ScreenUtil.dip2px(getContext(), 40.0f);
        this.autoHideKeyboard = true;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AliUserSmsCodeView);
            this.mTextCount = obtainStyledAttributes.getInt(R.styleable.AliUserSmsCodeView_scTextCount, this.mTextCount);
            this.mTextColor = obtainStyledAttributes.getColor(R.styleable.AliUserSmsCodeView_scTextColor, this.mTextColor);
            this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.AliUserSmsCodeView_scTextSize, TypedValue.applyDimension(2, this.mTextSize, context.getResources().getDisplayMetrics()));
            setTextSize();
            this.mDividerWidth = obtainStyledAttributes.getDimension(R.styleable.AliUserSmsCodeView_scDividerWidth, TypedValue.applyDimension(1, this.mDividerWidth, context.getResources().getDisplayMetrics()));
            this.mUnderLineStrokeWidth = obtainStyledAttributes.getDimension(R.styleable.AliUserSmsCodeView_scUnderLineStrokeWidth, TypedValue.applyDimension(1, this.mUnderLineStrokeWidth, context.getResources().getDisplayMetrics()));
            this.mUnderLineColor = obtainStyledAttributes.getColor(R.styleable.AliUserSmsCodeView_scUnderLineColor, this.mUnderLineColor);
            this.mNextUnderLineColor = obtainStyledAttributes.getColor(R.styleable.AliUserSmsCodeView_scNextUnderLineColor, this.mNextUnderLineColor);
            obtainStyledAttributes.recycle();
        }
        this.mTextBuilder = new StringBuilder(this.mTextCount);
        int i = this.mTextCount;
        this.mTextPositions = new PointF[i];
        this.mOuterRects = new RectF[i];
        this.mTextRects = new RectF[i];
        if (i == 4) {
            this.mBorderWidth = ScreenUtil.dip2px(getContext(), 45.0f);
            this.mBorderheight = ScreenUtil.dip2px(getContext(), 50.0f);
        }
        initPaint();
        setFocusableInTouchMode(true);
    }

    private double measureChildPositions() {
        int i;
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        float measureText = this.mTextPaint.measureText("0");
        float f = (this.mHeight / 2) + this.padding + ((fontMetricsInt.bottom - fontMetricsInt.top) / 4.0f);
        float f2 = this.mBorderWidth;
        int i2 = 0;
        while (true) {
            if (i2 < this.mTextCount) {
                float f3 = i2;
                float f4 = f3 * f2;
                this.mTextPositions[i2] = new PointF((this.mDividerWidth * f3) + f4 + (f2 / 2.0f) + this.padding, f);
                RectF[] rectFArr = this.mOuterRects;
                float f5 = this.mDividerWidth;
                int i3 = this.padding;
                int i4 = i2 + 1;
                rectFArr[i2] = new RectF(f4 + (f3 * f5) + i3, 0.0f, (i4 * f2) + (f3 * f5) + i3, this.mHeight);
                RectF[] rectFArr2 = this.mTextRects;
                PointF[] pointFArr = this.mTextPositions;
                float f6 = measureText / 2.0f;
                rectFArr2[i2] = new RectF(pointFArr[i2].x - f6, pointFArr[i2].y + fontMetricsInt.top, pointFArr[i2].x + f6, pointFArr[i2].y + fontMetricsInt.bottom);
                i2 = i4;
            } else {
                return (i * f2) + (this.mDividerWidth * (i - 1)) + (this.padding * 2);
            }
        }
    }

    public void clearText() {
        if (this.mTextBuilder.length() == 0) {
            return;
        }
        StringBuilder sb = this.mTextBuilder;
        sb.delete(0, sb.length());
        OnTextChangedListener onTextChangedListener = this.mOnTextChangedListener;
        if (onTextChangedListener != null) {
            onTextChangedListener.onTextChanged(this.mTextBuilder.toString());
        }
        invalidate();
    }

    public void drawUnderLine(Canvas canvas, Paint paint, RectF rectF, RectF rectF2) {
        float f = rectF2.left;
        rectF2.width();
        float f2 = rectF.left;
        float f3 = rectF.bottom;
        canvas.drawLine(f2, f3, rectF.right, f3, paint);
    }

    public void focus() {
        requestFocus();
        postDelayed(new Runnable() { // from class: com.ali.user.mobile.register.ui.AliUserSmsCodeView.1
            @Override // java.lang.Runnable
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) AliUserSmsCodeView.this.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(AliUserSmsCodeView.this, 0);
                }
            }
        }, 100L);
    }

    public String getText() {
        StringBuilder sb = this.mTextBuilder;
        return sb != null ? sb.toString() : "";
    }

    public int getTextCount() {
        return this.mTextCount;
    }

    protected void initPaint() {
        if (this.mTextPaint == null) {
            this.mTextPaint = new Paint(1);
        }
        this.mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mTextPaint.setColor(this.mTextColor);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        if (this.mUnderLinePaint == null) {
            this.mUnderLinePaint = new Paint(1);
        }
        this.mUnderLinePaint.setStyle(Paint.Style.STROKE);
        this.mUnderLinePaint.setColor(this.mUnderLineColor);
        this.mUnderLinePaint.setStrokeWidth(this.mUnderLineStrokeWidth);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        BaseInputConnection baseInputConnection = new BaseInputConnection(this, false) { // from class: com.ali.user.mobile.register.ui.AliUserSmsCodeView.2
            @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
            public boolean deleteSurroundingText(int i, int i2) {
                return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
            }
        };
        editorInfo.actionLabel = null;
        editorInfo.inputType = 3;
        editorInfo.imeOptions = 5;
        return baseInputConnection;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint();
        int length = this.mTextBuilder.length();
        for (int i = 0; i < this.mTextCount; i++) {
            if (i < length) {
                PointF[] pointFArr = this.mTextPositions;
                canvas.drawText(this.mTextBuilder.toString(), i, i + 1, pointFArr[i].x, pointFArr[i].y, this.mTextPaint);
            }
            int i2 = this.mUnderLineColor;
            if (hasFocus() && i == length) {
                i2 = this.mNextUnderLineColor;
            } else if (i < length) {
                i2 = this.mNextUnderLineColor;
            }
            this.mUnderLinePaint.setColor(i2);
            drawUnderLine(canvas, this.mUnderLinePaint, this.mOuterRects[i], this.mTextRects[i]);
        }
        setBackgroundColor(-1);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 67 && this.mTextBuilder.length() > 0) {
            StringBuilder sb = this.mTextBuilder;
            sb.deleteCharAt(sb.length() - 1);
            OnTextChangedListener onTextChangedListener = this.mOnTextChangedListener;
            if (onTextChangedListener != null) {
                onTextChangedListener.onTextChanged(this.mTextBuilder.toString());
            }
            invalidate();
        } else if (i >= 7 && i <= 16 && this.mTextBuilder.length() < this.mTextCount) {
            this.mTextBuilder.append(keyEvent.getDisplayLabel());
            OnTextChangedListener onTextChangedListener2 = this.mOnTextChangedListener;
            if (onTextChangedListener2 != null) {
                onTextChangedListener2.onTextChanged(this.mTextBuilder.toString());
            }
            invalidate();
        }
        if (this.mTextBuilder.length() >= this.mTextCount && this.autoHideKeyboard) {
            OnCompletedListener onCompletedListener = this.mOnCompletedListener;
            if (onCompletedListener != null && i != 4) {
                onCompletedListener.onCompleted(this.mTextBuilder.toString());
            }
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        String characters = keyEvent.getCharacters();
        if (!TextUtils.isEmpty(characters) && TextUtils.isDigitsOnly(characters)) {
            this.mTextBuilder.append(characters);
            OnTextChangedListener onTextChangedListener = this.mOnTextChangedListener;
            if (onTextChangedListener != null) {
                onTextChangedListener.onTextChanged(this.mTextBuilder.toString());
            }
            invalidate();
            if (this.mTextBuilder.length() >= this.mTextCount && this.autoHideKeyboard) {
                OnCompletedListener onCompletedListener = this.mOnCompletedListener;
                if (onCompletedListener != null) {
                    onCompletedListener.onCompleted(this.mTextBuilder.toString());
                }
                InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                }
            }
            return false;
        }
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        double measureChildPositions = measureChildPositions();
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension((int) measureChildPositions, this.mHeight + (this.padding * 2));
        } else {
            setMeasuredDimension(this.mWidth, this.mHeight + (this.padding * 2));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            focus();
            return true;
        }
        return true;
    }

    public void setOnCompletedListener(OnCompletedListener onCompletedListener) {
        this.mOnCompletedListener = onCompletedListener;
    }

    public void setOnTextChangedListener(OnTextChangedListener onTextChangedListener) {
        this.mOnTextChangedListener = onTextChangedListener;
    }

    public void setTextCount(int i) {
        if (this.mTextCount == i) {
            return;
        }
        this.mTextCount = i;
        this.mTextBuilder = new StringBuilder(i);
        this.mTextPositions = new PointF[i];
        this.mOuterRects = new RectF[i];
        this.mTextRects = new RectF[i];
        if (i == 4) {
            this.mBorderWidth = ScreenUtil.dip2px(getContext(), 45.0f);
            this.mBorderheight = ScreenUtil.dip2px(getContext(), 50.0f);
        }
        setTextSize();
        invalidate();
    }

    protected void setTextSize() {
        if (this.mTextCount == 4) {
            this.mTextSize = (float) (this.mTextSize * 1.2d);
        }
    }

    public AliUserSmsCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextColor = -16777216;
        this.mTextSize = 36.0f;
        this.mTextCount = 6;
        this.padding = 10;
        this.mDividerWidth = 6.0f;
        this.mUnderLineColor = -16777216;
        this.mNextUnderLineColor = -16777216;
        this.mUnderLineStrokeWidth = 1.0f;
        this.mBorderWidth = ScreenUtil.dip2px(getContext(), 36.0f);
        this.mBorderheight = ScreenUtil.dip2px(getContext(), 40.0f);
        this.autoHideKeyboard = true;
        init(context, attributeSet);
    }

    public AliUserSmsCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextColor = -16777216;
        this.mTextSize = 36.0f;
        this.mTextCount = 6;
        this.padding = 10;
        this.mDividerWidth = 6.0f;
        this.mUnderLineColor = -16777216;
        this.mNextUnderLineColor = -16777216;
        this.mUnderLineStrokeWidth = 1.0f;
        this.mBorderWidth = ScreenUtil.dip2px(getContext(), 36.0f);
        this.mBorderheight = ScreenUtil.dip2px(getContext(), 40.0f);
        this.autoHideKeyboard = true;
        init(context, attributeSet);
    }
}
