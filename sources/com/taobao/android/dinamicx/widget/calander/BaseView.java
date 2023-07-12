package com.taobao.android.dinamicx.widget.calander;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.util.FontUtil;
import com.taobao.android.dinamicx.widget.calander.CalendarView;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class BaseView extends View implements View.OnClickListener, View.OnLongClickListener {
    static final int CALENDAR_INFO_TEXT_SIZE = 11;
    static final int CURRENT_DAY_TEXT_SIZE = 16;
    static final int TEXT_SIZE = 14;
    boolean isClick;
    protected Paint mCurMonthTextPaint;
    int mCurrentItem;
    C6488b mDelegate;
    protected int mItemHeight;
    protected int mItemWidth;
    protected List<Calendar> mItems;
    protected Paint mSelectTextPaint;
    protected Paint mSelectedPaint;
    protected float mTextBaseLine;
    int mWeekStartWidth;
    protected float mX;
    protected float mY;
    private Typeface typeface;

    public BaseView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initCommonPaint(Paint paint, @ColorInt int i, int i2) {
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(i);
        paint.setFakeBoldText(true);
        paint.setTextSize(C6487a.c(getContext(), i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initCommonPaintWithTypeFace(Paint paint, @ColorInt int i, int i2) {
        C6488b c6488b;
        initCommonPaint(paint, i, i2);
        try {
            if (this.typeface == null && (c6488b = this.mDelegate) != null && !TextUtils.isEmpty(c6488b.j())) {
                this.typeface = FontUtil.c().b(this.mDelegate.j(), 0);
            }
            if (this.typeface != null) {
                paint.setFakeBoldText(false);
                paint.setTypeface(this.typeface);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initPaint() {
        initCommonPaintWithTypeFace(this.mCurMonthTextPaint, -15658735, 14);
        initCommonPaintWithTypeFace(this.mSelectTextPaint, -1, 14);
        this.mSelectTextPaint.setStyle(Paint.Style.FILL);
        this.mSelectedPaint.setAntiAlias(true);
        this.mSelectedPaint.setStyle(Paint.Style.FILL);
        this.mSelectedPaint.setStrokeWidth(2.0f);
        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isInRange(Calendar calendar) {
        C6488b c6488b = this.mDelegate;
        return c6488b != null && C6487a.q(calendar, c6488b);
    }

    protected boolean isSelected(Calendar calendar) {
        List<Calendar> list = this.mItems;
        return list != null && list.indexOf(calendar) == this.mCurrentItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean onCalendarIntercept(Calendar calendar) {
        CalendarView.OnCalendarInterceptListener onCalendarInterceptListener = this.mDelegate.D;
        return onCalendarInterceptListener != null && onCalendarInterceptListener.onCalendarIntercept(calendar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onDestroy();

    protected void onPreviewHook() {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mX = motionEvent.getX();
            this.mY = motionEvent.getY();
            this.isClick = true;
        } else if (action != 1) {
            if (action == 2 && this.isClick) {
                this.isClick = Math.abs(motionEvent.getY() - this.mY) <= 50.0f;
            }
        } else {
            this.mX = motionEvent.getX();
            this.mY = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setup(C6488b c6488b) {
        this.mDelegate = c6488b;
        this.mWeekStartWidth = c6488b.E();
        initPaint();
        updateStyle();
        updateItemHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void update() {
        invalidate();
    }

    abstract void updateCurrentDate();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateItemHeight() {
        this.mItemHeight = this.mDelegate.d();
        Paint.FontMetrics fontMetrics = this.mCurMonthTextPaint.getFontMetrics();
        this.mTextBaseLine = ((this.mItemHeight / 2) - fontMetrics.descent) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateStyle() {
        C6488b c6488b = this.mDelegate;
        if (c6488b == null) {
            return;
        }
        this.mCurMonthTextPaint.setColor(c6488b.i());
        this.mSelectTextPaint.setColor(this.mDelegate.z());
        this.mCurMonthTextPaint.setTextSize(this.mDelegate.l());
        this.mSelectTextPaint.setTextSize(this.mDelegate.l());
        this.mSelectedPaint.setStyle(Paint.Style.FILL);
    }

    public BaseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurMonthTextPaint = new Paint();
        this.mSelectedPaint = new Paint();
        this.mSelectTextPaint = new Paint();
        this.isClick = true;
        this.mCurrentItem = -1;
    }
}
