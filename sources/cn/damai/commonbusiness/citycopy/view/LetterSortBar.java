package cn.damai.commonbusiness.citycopy.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.MotionEventCompat;
import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class LetterSortBar extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isUpdate;
    private int mActivePointerId;
    private float mAnimStep;
    private int mChoose;
    private String[] mDefaultLetters;
    private final float mDensity;
    private float mHalfHeight;
    private float mHalfWidth;
    private float mInitialDownY;
    private boolean mIsBeingDragged;
    private RectF mIsDownRect;
    private float mLetterHeight;
    private List<String> mLetters;
    private OnTouchingLetterChangedListener mOnTouchingLetterChangedListener;
    private Paint mPaint;
    private boolean mStartEndAnim;
    private int mTextColor;
    private int mTouchSlop;
    private float mY;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnTouchingLetterChangedListener {
        void onClickLetterChanged(String str, int i);

        void onDraggingLetterChanged(String str, int i);
    }

    public LetterSortBar(Context context) {
        this(context, null);
    }

    private int dip2px(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "879559741") ? ((Integer) ipChange.ipc$dispatch("879559741", new Object[]{this, Integer.valueOf(i)})).intValue() : (int) ((i * this.mDensity) + 0.5f);
    }

    private int getLettersSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "816501251") ? ((Integer) ipChange.ipc$dispatch("816501251", new Object[]{this})).intValue() : getListSize(this.mLetters);
    }

    public static <T> int getListSize(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-158712623")) {
            return ((Integer) ipChange.ipc$dispatch("-158712623", new Object[]{list})).intValue();
        }
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private float getMotionEventY(MotionEvent motionEvent, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-377334521")) {
            return ((Float) ipChange.ipc$dispatch("-377334521", new Object[]{this, motionEvent, Integer.valueOf(i)})).floatValue();
        }
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1383405478")) {
            ipChange.ipc$dispatch("-1383405478", new Object[]{this, motionEvent});
            return;
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex != 0 ? 0 : 1);
        }
    }

    private void onSizeChange() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1771331320")) {
            ipChange.ipc$dispatch("1771331320", new Object[]{this});
        } else if (this.isUpdate) {
            int width = getWidth();
            int height = getHeight();
            this.mHalfWidth = width - dip2px(10);
            this.mHalfHeight = (height - getPaddingTop()) - getPaddingBottom();
            this.mLetterHeight = this.mHalfHeight / getLettersSize();
            this.mPaint.setTextSize(dip2px(12));
            this.mIsDownRect.set(width - dip2px(40), 0.0f, width, height);
            this.isUpdate = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007b, code lost:
        if (r8 <= 1.0f) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
        if (r17.mIsBeingDragged == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
        r8 = 1.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0084, code lost:
        r10 = 50.0f * r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008c, code lost:
        if (r3 < r17.mY) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
        r4 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0090, code lost:
        r7 = r7 * 100.0f;
        r16 = r8;
        r8 = r4 * r10;
        r4 = r16;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.citycopy.view.LetterSortBar.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649328185")) {
            return ((Boolean) ipChange.ipc$dispatch("-1649328185", new Object[]{this, motionEvent})).booleanValue();
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.mActivePointerId;
                    if (i == -1) {
                        return false;
                    }
                    float motionEventY = getMotionEventY(motionEvent, i);
                    if (motionEventY == -1.0f) {
                        return false;
                    }
                    if (Math.abs(motionEventY - this.mInitialDownY) > this.mTouchSlop && !this.mIsBeingDragged) {
                        this.mIsBeingDragged = true;
                    }
                    if (this.mIsBeingDragged) {
                        this.mY = motionEventY;
                        int paddingTop = (int) ((((motionEventY - getPaddingTop()) - (this.mLetterHeight / 1.64f)) / this.mHalfHeight) * getLettersSize());
                        if (this.mChoose != paddingTop && paddingTop >= 0 && paddingTop < getLettersSize()) {
                            this.mChoose = paddingTop;
                            if (this.mOnTouchingLetterChangedListener != null && paddingTop >= 0 && paddingTop < getLettersSize()) {
                                this.mOnTouchingLetterChangedListener.onDraggingLetterChanged(this.mLetters.get(paddingTop), paddingTop);
                            }
                        }
                        invalidate();
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            if (this.mOnTouchingLetterChangedListener != null) {
                if (this.mIsBeingDragged) {
                    int i2 = this.mChoose;
                    if (i2 >= 0 && i2 < getLettersSize()) {
                        this.mOnTouchingLetterChangedListener.onDraggingLetterChanged(this.mLetters.get(this.mChoose), this.mChoose);
                    }
                } else {
                    int y = (int) (((motionEvent.getY() - getPaddingTop()) / this.mHalfHeight) * getLettersSize());
                    if (y >= 0 && y < getLettersSize()) {
                        this.mOnTouchingLetterChangedListener.onClickLetterChanged(this.mLetters.get(y), y);
                    }
                }
            }
            this.mStartEndAnim = this.mIsBeingDragged;
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            this.mChoose = -1;
            this.mAnimStep = 0.0f;
            invalidate();
            return false;
        }
        int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        this.mActivePointerId = pointerId;
        this.mIsBeingDragged = false;
        float motionEventY2 = getMotionEventY(motionEvent, pointerId);
        if (motionEventY2 == -1.0f || !this.mIsDownRect.contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        this.mInitialDownY = motionEventY2;
        return true;
    }

    public void setLetters(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "579122382")) {
            ipChange.ipc$dispatch("579122382", new Object[]{this, list});
        } else if (getListSize(list) > 0) {
            this.mLetters = list;
            this.isUpdate = true;
            invalidate();
        }
    }

    public void setOnTouchingLetterChangedListener(OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1909895632")) {
            ipChange.ipc$dispatch("1909895632", new Object[]{this, onTouchingLetterChangedListener});
        } else {
            this.mOnTouchingLetterChangedListener = onTouchingLetterChangedListener;
        }
    }

    public LetterSortBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LetterSortBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        String[] strArr = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, UTConstant.Args.UT_SUCCESS_F, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", "V", ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
        this.mDefaultLetters = strArr;
        this.mLetters = Arrays.asList(strArr);
        this.mChoose = -1;
        this.mActivePointerId = -1;
        this.mIsDownRect = new RectF();
        this.mPaint = getPaint();
        this.mTextColor = Color.parseColor("#349CEC");
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setColor(this.mTextColor);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mDensity = getContext().getResources().getDisplayMetrics().density;
        setPadding(0, dip2px(20), 0, dip2px(20));
    }
}
