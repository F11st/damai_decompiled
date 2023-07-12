package com.youku.live.dago.widgetlib.interactive.gift.view.progressring;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ProgressRing extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MSG_START_COUNTDOWNNUM = 1;
    private boolean antiClockWise;
    private int bgEndColor;
    private int bgMidColor;
    private Paint bgPaint;
    private int bgStartColor;
    private int curProgress;
    private PaintFlagsDrawFilter filter;
    private int mDefaultInterval;
    private Handler mHandler;
    private int mMeasureHeight;
    private int mMeasureWidth;
    private RectF pRectF;
    private int progress;
    private int progressEndColor;
    private int progressMidColor;
    private Paint progressPaint;
    private int progressStartColor;
    private float progressWidth;
    private boolean showAnim;
    private int startAngle;
    private int sweepAngle;
    private float totalProgress;
    private float unitAngle;

    public ProgressRing(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bgPaint = new Paint(5);
        this.progressPaint = new Paint(5);
        this.curProgress = 0;
        this.antiClockWise = false;
        this.totalProgress = 100.0f;
        this.mDefaultInterval = 100;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Dago_Pgc_ProgressRing);
        this.progressStartColor = obtainStyledAttributes.getColor(R.styleable.Dago_Pgc_ProgressRing_pr_progress_start_color, InputDeviceCompat.SOURCE_ANY);
        this.progressMidColor = obtainStyledAttributes.getColor(R.styleable.Dago_Pgc_ProgressRing_pr_progress_mid_color, InputDeviceCompat.SOURCE_ANY);
        this.progressEndColor = obtainStyledAttributes.getColor(R.styleable.Dago_Pgc_ProgressRing_pr_progress_end_color, this.progressStartColor);
        int color = obtainStyledAttributes.getColor(R.styleable.Dago_Pgc_ProgressRing_pr_bg_start_color, -3355444);
        this.bgStartColor = color;
        this.bgMidColor = obtainStyledAttributes.getColor(R.styleable.Dago_Pgc_ProgressRing_pr_bg_mid_color, color);
        this.bgEndColor = obtainStyledAttributes.getColor(R.styleable.Dago_Pgc_ProgressRing_pr_bg_end_color, this.bgStartColor);
        this.progress = obtainStyledAttributes.getInt(R.styleable.Dago_Pgc_ProgressRing_pr_progress, 0);
        this.progressWidth = obtainStyledAttributes.getDimension(R.styleable.Dago_Pgc_ProgressRing_pr_progress_width, 8.0f);
        this.startAngle = obtainStyledAttributes.getInt(R.styleable.Dago_Pgc_ProgressRing_pr_start_angle, 150);
        this.sweepAngle = obtainStyledAttributes.getInt(R.styleable.Dago_Pgc_ProgressRing_pr_sweep_angle, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
        this.showAnim = obtainStyledAttributes.getBoolean(R.styleable.Dago_Pgc_ProgressRing_pr_show_anim, true);
        this.antiClockWise = obtainStyledAttributes.getBoolean(R.styleable.Dago_Pgc_ProgressRing_pr_anti_clock_wise, false);
        obtainStyledAttributes.recycle();
        this.unitAngle = this.sweepAngle / this.totalProgress;
        this.bgPaint.setStyle(Paint.Style.STROKE);
        this.bgPaint.setStrokeCap(Paint.Cap.ROUND);
        this.bgPaint.setAntiAlias(true);
        this.bgPaint.setStrokeWidth(this.progressWidth);
        this.progressPaint.setStyle(Paint.Style.STROKE);
        this.progressPaint.setStrokeCap(Paint.Cap.ROUND);
        this.progressPaint.setAntiAlias(true);
        this.progressPaint.setStrokeWidth(this.progressWidth);
        this.filter = new PaintFlagsDrawFilter(0, 7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCountDownNum() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950516213")) {
            ipChange.ipc$dispatch("-1950516213", new Object[]{this});
        } else if (this.progress != 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = this.mDefaultInterval;
            this.mHandler.sendEmptyMessageAtTime(1, uptimeMillis + (i - (uptimeMillis % i)));
            setProgress(this.progress);
            this.progress--;
        } else {
            reSet();
        }
    }

    private void drawBg(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1546588995")) {
            ipChange.ipc$dispatch("1546588995", new Object[]{this, canvas});
            return;
        }
        int i = this.sweepAngle;
        float f = i / 2;
        int i2 = (int) (this.curProgress * this.unitAngle);
        while (i > i2) {
            float f2 = i;
            float f3 = f2 - f;
            if (f3 > 0.0f) {
                this.bgPaint.setColor(getGradient(f3 / f, this.bgMidColor, this.bgEndColor));
            } else {
                this.bgPaint.setColor(getGradient((f - f2) / f, this.bgMidColor, this.bgStartColor));
            }
            canvas.drawArc(this.pRectF, this.startAngle + i, 1.0f, false, this.bgPaint);
            i--;
        }
    }

    private void drawProgress(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "50164395")) {
            ipChange.ipc$dispatch("50164395", new Object[]{this, canvas});
            return;
        }
        float f = this.sweepAngle / 2;
        int i = (int) (this.curProgress * this.unitAngle);
        for (int i2 = 0; i2 <= i; i2++) {
            float f2 = i2;
            float f3 = f2 - f;
            if (f3 > 0.0f) {
                this.progressPaint.setColor(getGradient(f3 / f, this.progressMidColor, this.progressStartColor));
            } else {
                this.progressPaint.setColor(getGradient((f - f2) / f, this.progressMidColor, this.progressEndColor));
            }
            if (this.antiClockWise) {
                canvas.drawArc(this.pRectF, this.startAngle + i2, 1.0f, false, this.progressPaint);
            } else {
                canvas.drawArc(this.pRectF, this.startAngle - i2, 1.0f, false, this.progressPaint);
            }
        }
    }

    private void initHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "58566821")) {
            ipChange.ipc$dispatch("58566821", new Object[]{this});
        } else {
            this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.progressring.ProgressRing.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "719250438")) {
                        ipChange2.ipc$dispatch("719250438", new Object[]{this, message});
                    } else if (message.what != 1) {
                    } else {
                        ProgressRing.this.doCountDownNum();
                    }
                }
            };
        }
    }

    private void reSet() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2099255024")) {
            ipChange.ipc$dispatch("2099255024", new Object[]{this});
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
    }

    public int getGradient(float f, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-277605158")) {
            return ((Integer) ipChange.ipc$dispatch("-277605158", new Object[]{this, Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        int alpha = Color.alpha(i);
        int red = Color.red(i);
        int blue = Color.blue(i);
        int green = Color.green(i);
        int alpha2 = Color.alpha(i2);
        return Color.argb((int) (alpha + ((alpha2 - alpha) * f)), (int) (red + ((Color.red(i2) - red) * f)), (int) (green + (f * (Color.green(i2) - green))), (int) (blue + ((Color.blue(i2) - blue) * f)));
    }

    public int getProgress() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1940736111") ? ((Integer) ipChange.ipc$dispatch("1940736111", new Object[]{this})).intValue() : this.progress;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653165731")) {
            ipChange.ipc$dispatch("-653165731", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (!this.showAnim) {
            this.curProgress = this.progress;
        }
        canvas.setDrawFilter(this.filter);
        drawProgress(canvas);
        int i = this.curProgress;
        if (i < this.progress) {
            this.curProgress = i + 1;
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1304987904")) {
            ipChange.ipc$dispatch("-1304987904", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        this.mMeasureWidth = measuredWidth;
        this.mMeasureHeight = measuredWidth;
        if (this.pRectF == null) {
            float f = this.progressWidth / 2.0f;
            this.pRectF = new RectF(getPaddingLeft() + f, getPaddingTop() + f, (this.mMeasureWidth - f) - getPaddingRight(), (this.mMeasureHeight - f) - getPaddingBottom());
        }
    }

    public void setAutoCountDown(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "68829099")) {
            ipChange.ipc$dispatch("68829099", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        initHandler();
        setMaxProgress(360.0f);
        float f = this.totalProgress;
        this.mDefaultInterval = (int) ((i * 1000) / f);
        this.progress = (int) ((i2 * f) / i);
        ((ILog) Dsl.getService(ILog.class)).i("countdown", "progress = " + this.progress);
        ((ILog) Dsl.getService(ILog.class)).i("countdown", "mDefaultInterval = " + this.mDefaultInterval);
        doCountDownNum();
    }

    public void setMaxProgress(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-127751196")) {
            ipChange.ipc$dispatch("-127751196", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.totalProgress = f;
        this.unitAngle = this.sweepAngle / f;
    }

    public void setProgress(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "944059667")) {
            ipChange.ipc$dispatch("944059667", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.progress = i;
        postInvalidate();
    }
}
