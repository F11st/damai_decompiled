package cn.damai.commonbusiness.dynamicx.customwidget.temp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tb.cb1;
import tb.ep0;
import tb.ts;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMDXCountDownView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int UPDATE_UI_CODE = 101;
    private String colon;
    private Context context;
    private CountDownEndListener countDownEndListener;
    private TextView hourColonTv;
    private TextView hourTv;
    private boolean isContinue;
    long lastTime;
    private ExecutorService mExecutorService;
    private TextView minuteColonTv;
    private TextView minuteTv;
    private Handler myHandler;
    private long originalTime;
    private TextView secondTv;
    long timeEnd;
    private volatile long timeStamp;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface CountDownEndListener {
        void onCountDownEnd();
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public enum CountDownViewGravity {
        GRAVITY_CENTER,
        GRAVITY_LEFT,
        GRAVITY_RIGHT,
        GRAVITY_TOP,
        GRAVITY_BOTTOM
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.dynamicx.customwidget.temp.DMDXCountDownView$a */
    /* loaded from: classes14.dex */
    public static class HandlerC0668a extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        private final WeakReference<DMDXCountDownView> a;

        HandlerC0668a(DMDXCountDownView dMDXCountDownView) {
            this.a = new WeakReference<>(dMDXCountDownView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-309159452")) {
                ipChange.ipc$dispatch("-309159452", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            DMDXCountDownView dMDXCountDownView = this.a.get();
            if (dMDXCountDownView != null && message.what == 101) {
                Object obj = message.obj;
                if (obj != null) {
                    String[] strArr = (String[]) obj;
                    for (int i = 0; i < strArr.length; i++) {
                        if (i == 0) {
                            dMDXCountDownView.updateTvText(strArr[0], dMDXCountDownView.hourTv);
                        } else if (i == 1) {
                            dMDXCountDownView.updateTvText(strArr[1], dMDXCountDownView.minuteTv);
                        } else if (i == 2) {
                            dMDXCountDownView.updateTvText(strArr[2], dMDXCountDownView.secondTv);
                        }
                    }
                    cb1.b("DMDXCountDownView", "handleMessage");
                }
                if (dMDXCountDownView.isContinue || dMDXCountDownView.countDownEndListener == null) {
                    return;
                }
                dMDXCountDownView.countDownEndListener.onCountDownEnd();
            }
        }
    }

    public DMDXCountDownView(Context context) {
        this(context, null);
    }

    static /* synthetic */ long access$110(DMDXCountDownView dMDXCountDownView) {
        long j = dMDXCountDownView.timeStamp;
        dMDXCountDownView.timeStamp = j - 1;
        return j;
    }

    private void countDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1573116807")) {
            ipChange.ipc$dispatch("-1573116807", new Object[]{this});
            return;
        }
        Thread thread = new Thread(new Runnable() { // from class: cn.damai.commonbusiness.dynamicx.customwidget.temp.DMDXCountDownView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-387581550")) {
                    ipChange2.ipc$dispatch("-387581550", new Object[]{this});
                    return;
                }
                while (DMDXCountDownView.this.isContinue) {
                    try {
                        DMDXCountDownView dMDXCountDownView = DMDXCountDownView.this;
                        dMDXCountDownView.isContinue = DMDXCountDownView.access$110(dMDXCountDownView) > 1;
                        String[] b = ts.b(DMDXCountDownView.this.timeStamp);
                        Message message = new Message();
                        message.obj = b;
                        message.what = 101;
                        DMDXCountDownView.this.myHandler.sendMessage(message);
                        Thread.sleep(1000L);
                        cb1.b("DMDXCountDownView", "timeStamp = " + DMDXCountDownView.this.timeStamp);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                DMDXCountDownView.this.isContinue = true;
            }
        });
        ExecutorService executorService = this.mExecutorService;
        if (executorService == null || executorService.isShutdown()) {
            this.mExecutorService = Executors.newCachedThreadPool();
        }
        this.mExecutorService.execute(thread);
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-358541744")) {
            ipChange.ipc$dispatch("-358541744", new Object[]{this});
            return;
        }
        setOrientation(0);
        setGravity(16);
        TextView textView = new TextView(this.context);
        this.hourTv = textView;
        textView.setTextColor(parseColor("#000000"));
        this.hourTv.setBackgroundColor(parseColor("#DEDEDE"));
        this.hourTv.setTextSize(1, 12.0f);
        this.hourTv.setGravity(17);
        addView(this.hourTv);
        TextView textView2 = new TextView(this.context);
        this.hourColonTv = textView2;
        textView2.setTextColor(parseColor("#000000"));
        this.hourColonTv.setTextSize(1, 12.0f);
        this.hourColonTv.setText(this.colon);
        this.hourColonTv.setGravity(17);
        addView(this.hourColonTv);
        TextView textView3 = new TextView(this.context);
        this.minuteTv = textView3;
        textView3.setTextColor(parseColor("#000000"));
        this.minuteTv.setBackgroundColor(parseColor("#DEDEDE"));
        this.minuteTv.setTextSize(1, 12.0f);
        this.minuteTv.setGravity(17);
        addView(this.minuteTv);
        TextView textView4 = new TextView(this.context);
        this.minuteColonTv = textView4;
        textView4.setTextColor(parseColor("#000000"));
        this.minuteColonTv.setTextSize(1, 12.0f);
        this.minuteColonTv.setText(this.colon);
        this.minuteColonTv.setGravity(17);
        addView(this.minuteColonTv);
        TextView textView5 = new TextView(this.context);
        this.secondTv = textView5;
        textView5.setTextColor(parseColor("#000000"));
        this.secondTv.setBackgroundColor(parseColor("#DEDEDE"));
        this.secondTv.setTextSize(1, 12.0f);
        this.secondTv.setGravity(17);
        addView(this.secondTv);
    }

    private int parseColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1449958291")) {
            return ((Integer) ipChange.ipc$dispatch("-1449958291", new Object[]{this, str})).intValue();
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            cb1.b("DMDXCountDownView", e.getMessage());
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTvText(String str, TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2072472658")) {
            ipChange.ipc$dispatch("2072472658", new Object[]{this, str, textView});
        } else if (textView == null) {
        } else {
            textView.setText(str);
        }
    }

    public void destoryCountDownView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2115541054")) {
            ipChange.ipc$dispatch("2115541054", new Object[]{this});
            return;
        }
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        Handler handler = this.myHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.myHandler = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchVisibilityChanged(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1044089587")) {
            ipChange.ipc$dispatch("1044089587", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        super.dispatchVisibilityChanged(view, i);
        if (i == 4) {
            this.lastTime = System.currentTimeMillis();
            this.timeEnd = this.timeStamp;
            cb1.c("DMDXCountDownView", "onVisibilityChanged INVISIBLE");
            pauseCountDown();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.lastTime;
        StringBuilder sb = new StringBuilder();
        sb.append("onVisibilityChanged VISIBLE");
        long j = currentTimeMillis / 1000;
        sb.append(j);
        cb1.c("DMDXCountDownView", sb.toString());
        this.timeStamp = this.timeEnd - j;
        startCountDown();
    }

    public long getCountTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-247450930") ? ((Long) ipChange.ipc$dispatch("-247450930", new Object[]{this})).longValue() : this.originalTime;
    }

    public DMDXCountDownView pauseCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-191963979")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-191963979", new Object[]{this});
        }
        this.isContinue = false;
        return this;
    }

    public DMDXCountDownView setColonTvBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1496624355")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1496624355", new Object[]{this, drawable});
        }
        if (drawable != null && Build.VERSION.SDK_INT >= 16) {
            this.hourColonTv.setBackground(drawable);
            this.minuteColonTv.setBackground(drawable);
        }
        return this;
    }

    public DMDXCountDownView setColonTvBackgroundColorHex(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1869340651")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1869340651", new Object[]{this, str});
        }
        int parseColor = parseColor(str);
        this.hourColonTv.setBackgroundColor(parseColor);
        this.minuteColonTv.setBackgroundColor(parseColor);
        return this;
    }

    public DMDXCountDownView setColonTvBackgroundRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-226110610")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-226110610", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourColonTv.setBackgroundResource(i);
        this.minuteColonTv.setBackgroundResource(i);
        return this;
    }

    public DMDXCountDownView setColonTvGravity(CountDownViewGravity countDownViewGravity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1749645915")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1749645915", new Object[]{this, countDownViewGravity});
        }
        int i = 17;
        if (countDownViewGravity == CountDownViewGravity.GRAVITY_BOTTOM) {
            i = 80;
        } else if (countDownViewGravity != CountDownViewGravity.GRAVITY_CENTER) {
            if (countDownViewGravity == CountDownViewGravity.GRAVITY_LEFT) {
                i = GravityCompat.START;
            } else if (countDownViewGravity == CountDownViewGravity.GRAVITY_RIGHT) {
                i = GravityCompat.END;
            } else if (countDownViewGravity == CountDownViewGravity.GRAVITY_TOP) {
                i = 48;
            }
        }
        this.hourColonTv.setGravity(i);
        this.minuteColonTv.setGravity(i);
        return this;
    }

    public DMDXCountDownView setColonTvSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-288206310")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-288206310", new Object[]{this, Float.valueOf(f)});
        }
        this.hourColonTv.setTextSize(1, f);
        this.minuteColonTv.setTextSize(1, f);
        return this;
    }

    public DMDXCountDownView setColonTvTextColorHex(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-62961836")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-62961836", new Object[]{this, str});
        }
        int parseColor = parseColor(str);
        this.hourColonTv.setTextColor(parseColor);
        this.minuteColonTv.setTextColor(parseColor);
        return this;
    }

    public DMDXCountDownView setColonTvWH(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-404652502")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-404652502", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        this.hourColonTv.setLayoutParams(layoutParams);
        this.minuteColonTv.setLayoutParams(layoutParams);
        return this;
    }

    public void setCountDownEndListener(CountDownEndListener countDownEndListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-564544864")) {
            ipChange.ipc$dispatch("-564544864", new Object[]{this, countDownEndListener});
        } else {
            this.countDownEndListener = countDownEndListener;
        }
    }

    public DMDXCountDownView setCountTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1978854268")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1978854268", new Object[]{this, Long.valueOf(j)});
        }
        this.timeStamp = j;
        this.originalTime = j;
        return this;
    }

    public DMDXCountDownView setHourColonTvBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2032631841")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-2032631841", new Object[]{this, drawable});
        }
        if (drawable != null && Build.VERSION.SDK_INT >= 16) {
            this.hourColonTv.setBackground(drawable);
        }
        return this;
    }

    public DMDXCountDownView setHourColonTvBackgroundColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "444888704") ? (DMDXCountDownView) ipChange.ipc$dispatch("444888704", new Object[]{this, str}) : setHourColonTvBackgroundColor(parseColor(str));
    }

    public DMDXCountDownView setHourColonTvBackgroundRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2069141098")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("2069141098", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourColonTv.setBackgroundResource(i);
        return this;
    }

    public DMDXCountDownView setHourColonTvBold(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-393445626")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-393445626", new Object[]{this, Boolean.valueOf(z)});
        }
        this.hourColonTv.getPaint().setFakeBoldText(z);
        return this;
    }

    public DMDXCountDownView setHourColonTvGravity(CountDownViewGravity countDownViewGravity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1966871201")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1966871201", new Object[]{this, countDownViewGravity});
        }
        int i = 17;
        if (countDownViewGravity == CountDownViewGravity.GRAVITY_BOTTOM) {
            i = 80;
        } else if (countDownViewGravity != CountDownViewGravity.GRAVITY_CENTER) {
            if (countDownViewGravity == CountDownViewGravity.GRAVITY_LEFT) {
                i = GravityCompat.START;
            } else if (countDownViewGravity == CountDownViewGravity.GRAVITY_RIGHT) {
                i = GravityCompat.END;
            } else if (countDownViewGravity == CountDownViewGravity.GRAVITY_TOP) {
                i = 48;
            }
        }
        this.hourColonTv.setGravity(i);
        return this;
    }

    public DMDXCountDownView setHourColonTvMargins(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305715462")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-305715462", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, i2, i3, i4);
        this.hourColonTv.setLayoutParams(layoutParams);
        return this;
    }

    public DMDXCountDownView setHourColonTvPadding(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-99622778")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-99622778", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        this.hourColonTv.setPadding(i, i2, i3, i4);
        return this;
    }

    public DMDXCountDownView setHourColonTvSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2087732598")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("2087732598", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        ViewGroup.LayoutParams layoutParams = this.hourColonTv.getLayoutParams();
        if (layoutParams != null) {
            if (i > 0) {
                layoutParams.width = i;
            }
            if (i2 > 0) {
                layoutParams.height = i2;
            }
            this.hourColonTv.setLayoutParams(layoutParams);
        }
        return this;
    }

    public DMDXCountDownView setHourColonTvText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2046053496")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("2046053496", new Object[]{this, str});
        }
        this.hourColonTv.setText(str);
        return this;
    }

    public DMDXCountDownView setHourColonTvTextColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-594828639") ? (DMDXCountDownView) ipChange.ipc$dispatch("-594828639", new Object[]{this, str}) : setHourColonTvTextColor(parseColor(str));
    }

    public DMDXCountDownView setHourColonTvTextSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1196478321")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1196478321", new Object[]{this, Float.valueOf(f)});
        }
        this.hourColonTv.setTextSize(1, f);
        return this;
    }

    public DMDXCountDownView setHourTvBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1533585502")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1533585502", new Object[]{this, drawable});
        }
        if (drawable != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.hourTv.setBackground(drawable);
            } else {
                this.hourTv.setBackgroundDrawable(drawable);
            }
        }
        return this;
    }

    public DMDXCountDownView setHourTvBackgroundColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1596768803") ? (DMDXCountDownView) ipChange.ipc$dispatch("-1596768803", new Object[]{this, str}) : setHourTvBackgroundColor(parseColor(str));
    }

    public DMDXCountDownView setHourTvBackgroundColorWithRadius(String str, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-310171524") ? (DMDXCountDownView) ipChange.ipc$dispatch("-310171524", new Object[]{this, str, Integer.valueOf(i)}) : setHourTvBackgroundColorWithRadius(parseColor(str), i);
    }

    public DMDXCountDownView setHourTvBackgroundRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1190446547")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1190446547", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourTv.setBackgroundResource(i);
        return this;
    }

    public DMDXCountDownView setHourTvBold(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1055849501")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1055849501", new Object[]{this, Boolean.valueOf(z)});
        }
        this.hourTv.getPaint().setFakeBoldText(z);
        return this;
    }

    public DMDXCountDownView setHourTvGravity(CountDownViewGravity countDownViewGravity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1362977052")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1362977052", new Object[]{this, countDownViewGravity});
        }
        int i = 17;
        if (countDownViewGravity == CountDownViewGravity.GRAVITY_BOTTOM) {
            i = 80;
        } else if (countDownViewGravity != CountDownViewGravity.GRAVITY_CENTER) {
            if (countDownViewGravity == CountDownViewGravity.GRAVITY_LEFT) {
                i = GravityCompat.START;
            } else if (countDownViewGravity == CountDownViewGravity.GRAVITY_RIGHT) {
                i = GravityCompat.END;
            } else if (countDownViewGravity == CountDownViewGravity.GRAVITY_TOP) {
                i = 48;
            }
        }
        this.hourTv.setGravity(i);
        return this;
    }

    public DMDXCountDownView setHourTvMargins(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1264987625")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1264987625", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, i2, i3, i4);
        this.minuteTv.setLayoutParams(layoutParams);
        return this;
    }

    public DMDXCountDownView setHourTvPadding(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1058894941")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1058894941", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        this.hourTv.setPadding(i, i2, i3, i4);
        return this;
    }

    public DMDXCountDownView setHourTvSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1266918343")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1266918343", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        ViewGroup.LayoutParams layoutParams = this.hourTv.getLayoutParams();
        if (layoutParams != null) {
            if (i > 0) {
                layoutParams.width = i;
            }
            if (i2 > 0) {
                layoutParams.height = i2;
            }
            this.hourTv.setLayoutParams(layoutParams);
        }
        return this;
    }

    public DMDXCountDownView setHourTvTextColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1508275134") ? (DMDXCountDownView) ipChange.ipc$dispatch("1508275134", new Object[]{this, str}) : setHourTvTextColor(parseColor(str));
    }

    public DMDXCountDownView setHourTvTextSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1910661682")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1910661682", new Object[]{this, Float.valueOf(f)});
        }
        this.hourTv.setTextSize(1, f);
        return this;
    }

    public DMDXCountDownView setMinuteColonTvBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1669882641")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1669882641", new Object[]{this, drawable});
        }
        if (drawable != null && Build.VERSION.SDK_INT >= 16) {
            this.minuteColonTv.setBackground(drawable);
        }
        return this;
    }

    public DMDXCountDownView setMinuteColonTvBackgroundColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-179609744") ? (DMDXCountDownView) ipChange.ipc$dispatch("-179609744", new Object[]{this, str}) : setMinuteColonTvBackgroundColor(parseColor(str));
    }

    public DMDXCountDownView setMinuteColonTvBackgroundRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1881928570")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1881928570", new Object[]{this, Integer.valueOf(i)});
        }
        this.minuteColonTv.setBackgroundResource(i);
        return this;
    }

    public DMDXCountDownView setMinuteColonTvBold(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1756024842")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1756024842", new Object[]{this, Boolean.valueOf(z)});
        }
        this.minuteColonTv.getPaint().setFakeBoldText(z);
        return this;
    }

    public DMDXCountDownView setMinuteColonTvGravity(CountDownViewGravity countDownViewGravity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1021196367")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1021196367", new Object[]{this, countDownViewGravity});
        }
        int i = 17;
        if (countDownViewGravity == CountDownViewGravity.GRAVITY_BOTTOM) {
            i = 80;
        } else if (countDownViewGravity != CountDownViewGravity.GRAVITY_CENTER) {
            if (countDownViewGravity == CountDownViewGravity.GRAVITY_LEFT) {
                i = GravityCompat.START;
            } else if (countDownViewGravity == CountDownViewGravity.GRAVITY_RIGHT) {
                i = GravityCompat.END;
            } else if (countDownViewGravity == CountDownViewGravity.GRAVITY_TOP) {
                i = 48;
            }
        }
        this.minuteColonTv.setGravity(i);
        return this;
    }

    public DMDXCountDownView setMinuteColonTvMargins(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1193501674")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1193501674", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, i2, i3, i4);
        this.minuteColonTv.setLayoutParams(layoutParams);
        return this;
    }

    public DMDXCountDownView setMinuteColonTvPadding(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1399594358")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1399594358", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        this.minuteColonTv.setPadding(i, i2, i3, i4);
        return this;
    }

    public DMDXCountDownView setMinuteColonTvSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1497517434")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1497517434", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        ViewGroup.LayoutParams layoutParams = this.minuteColonTv.getLayoutParams();
        if (layoutParams != null) {
            if (i > 0) {
                layoutParams.width = i;
            }
            if (i2 > 0) {
                layoutParams.height = i2;
            }
            this.minuteColonTv.setLayoutParams(layoutParams);
        }
        return this;
    }

    public DMDXCountDownView setMinuteColonTvText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-932865656")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-932865656", new Object[]{this, str});
        }
        this.minuteColonTv.setText(str);
        return this;
    }

    public DMDXCountDownView setMinuteColonTvTextColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1831862161") ? (DMDXCountDownView) ipChange.ipc$dispatch("1831862161", new Object[]{this, str}) : setMinuteColonTvTextColor(parseColor(str));
    }

    public DMDXCountDownView setMinuteColonTvTextSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "259491937")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("259491937", new Object[]{this, Float.valueOf(f)});
        }
        this.minuteColonTv.setTextSize(1, f);
        return this;
    }

    public DMDXCountDownView setMinuteTvBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1579045010")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1579045010", new Object[]{this, drawable});
        }
        if (drawable != null && Build.VERSION.SDK_INT >= 16) {
            this.minuteTv.setBackground(drawable);
        }
        return this;
    }

    public DMDXCountDownView setMinuteTvBackgroundColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "616201965") ? (DMDXCountDownView) ipChange.ipc$dispatch("616201965", new Object[]{this, str}) : setMinuteTvBackgroundColor(parseColor(str));
    }

    public DMDXCountDownView setMinuteTvBackgroundColorWidthRadius(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-421119152")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-421119152", new Object[]{this, str, Integer.valueOf(i)});
        }
        if (i == 0) {
            return setMinuteTvBackgroundColor(str);
        }
        return setMinuteTvBackgroundColorWidthRadius(parseColor(str), i);
    }

    public DMDXCountDownView setMinuteTvBackgroundRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2127432931")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-2127432931", new Object[]{this, Integer.valueOf(i)});
        }
        this.minuteTv.setBackgroundResource(i);
        return this;
    }

    public DMDXCountDownView setMinuteTvBold(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1492745459")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1492745459", new Object[]{this, Boolean.valueOf(z)});
        }
        this.minuteTv.getPaint().setFakeBoldText(z);
        return this;
    }

    public DMDXCountDownView setMinuteTvGravity(CountDownViewGravity countDownViewGravity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340000724")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("340000724", new Object[]{this, countDownViewGravity});
        }
        int i = 17;
        if (countDownViewGravity == CountDownViewGravity.GRAVITY_BOTTOM) {
            i = 80;
        } else if (countDownViewGravity != CountDownViewGravity.GRAVITY_CENTER) {
            if (countDownViewGravity == CountDownViewGravity.GRAVITY_LEFT) {
                i = GravityCompat.START;
            } else if (countDownViewGravity == CountDownViewGravity.GRAVITY_RIGHT) {
                i = GravityCompat.END;
            } else if (countDownViewGravity == CountDownViewGravity.GRAVITY_TOP) {
                i = 48;
            }
        }
        this.minuteTv.setGravity(i);
        return this;
    }

    public DMDXCountDownView setMinuteTvMargins(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-555270361")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-555270361", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, i2, i3, i4);
        this.minuteTv.setLayoutParams(layoutParams);
        return this;
    }

    public DMDXCountDownView setMinuteTvPadding(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-349177677")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-349177677", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        this.minuteTv.setPadding(i, i2, i3, i4);
        return this;
    }

    public DMDXCountDownView setMinuteTvSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "430114089")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("430114089", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        ViewGroup.LayoutParams layoutParams = this.minuteTv.getLayoutParams();
        if (layoutParams != null) {
            if (i > 0) {
                layoutParams.width = i;
            }
            if (i2 > 0) {
                layoutParams.height = i2;
            }
            this.minuteTv.setLayoutParams(layoutParams);
        }
        return this;
    }

    public DMDXCountDownView setMinuteTvTextColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1470644018") ? (DMDXCountDownView) ipChange.ipc$dispatch("-1470644018", new Object[]{this, str}) : setMinuteTvTextColor(parseColor(str));
    }

    public DMDXCountDownView setMinuteTvTextSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677521186")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1677521186", new Object[]{this, Float.valueOf(f)});
        }
        this.minuteTv.setTextSize(1, f);
        return this;
    }

    public DMDXCountDownView setSecondTvBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1963740914")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1963740914", new Object[]{this, drawable});
        }
        if (drawable != null && Build.VERSION.SDK_INT >= 16) {
            this.secondTv.setBackground(drawable);
        }
        return this;
    }

    public DMDXCountDownView setSecondTvBackgroundColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1357994867") ? (DMDXCountDownView) ipChange.ipc$dispatch("-1357994867", new Object[]{this, str}) : setSecondTvBackgroundColor(parseColor(str));
    }

    public DMDXCountDownView setSecondTvBackgroundColorWidthRadius(String str, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1794182928") ? (DMDXCountDownView) ipChange.ipc$dispatch("-1794182928", new Object[]{this, str, Integer.valueOf(i)}) : setSecondTvBackgroundColorWidthRadius(parseColor(str), i);
    }

    public DMDXCountDownView setSecondTvBackgroundRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189697667")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-189697667", new Object[]{this, Integer.valueOf(i)});
        }
        this.secondTv.setBackgroundResource(i);
        return this;
    }

    public DMDXCountDownView setSecondTvBold(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "490754707")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("490754707", new Object[]{this, Boolean.valueOf(z)});
        }
        this.secondTv.getPaint().setFakeBoldText(z);
        return this;
    }

    public DMDXCountDownView setSecondTvGravity(CountDownViewGravity countDownViewGravity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1328443852")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1328443852", new Object[]{this, countDownViewGravity});
        }
        int i = 17;
        if (countDownViewGravity == CountDownViewGravity.GRAVITY_BOTTOM) {
            i = 80;
        } else if (countDownViewGravity != CountDownViewGravity.GRAVITY_CENTER) {
            if (countDownViewGravity == CountDownViewGravity.GRAVITY_LEFT) {
                i = GravityCompat.START;
            } else if (countDownViewGravity == CountDownViewGravity.GRAVITY_RIGHT) {
                i = GravityCompat.END;
            } else if (countDownViewGravity == CountDownViewGravity.GRAVITY_TOP) {
                i = 48;
            }
        }
        this.secondTv.setGravity(i);
        return this;
    }

    public DMDXCountDownView setSecondTvMargins(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1977572551")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1977572551", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, i2, i3, i4);
        this.secondTv.setLayoutParams(layoutParams);
        return this;
    }

    public DMDXCountDownView setSecondTvPadding(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2111302061")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-2111302061", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        this.secondTv.setPadding(i, i2, i3, i4);
        return this;
    }

    public DMDXCountDownView setSecondTvSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-566828151")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-566828151", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        ViewGroup.LayoutParams layoutParams = this.secondTv.getLayoutParams();
        if (layoutParams != null) {
            if (i > 0) {
                layoutParams.width = i;
            }
            if (i2 > 0) {
                layoutParams.height = i2;
            }
            this.secondTv.setLayoutParams(layoutParams);
        }
        return this;
    }

    public DMDXCountDownView setSecondTvTextColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-140468626") ? (DMDXCountDownView) ipChange.ipc$dispatch("-140468626", new Object[]{this, str}) : setSecondTvTextColor(parseColor(str));
    }

    public DMDXCountDownView setSecondTvTextSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1884941186")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1884941186", new Object[]{this, Float.valueOf(f)});
        }
        this.secondTv.setTextSize(1, f);
        return this;
    }

    public DMDXCountDownView setTimeTvBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "150019467")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("150019467", new Object[]{this, drawable});
        }
        if (drawable != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.hourTv.setBackground(drawable);
                this.minuteTv.setBackground(drawable);
                this.secondTv.setBackground(drawable);
            } else {
                this.hourTv.setBackgroundDrawable(drawable);
                this.minuteTv.setBackgroundDrawable(drawable);
                this.secondTv.setBackgroundDrawable(drawable);
            }
        }
        return this;
    }

    public DMDXCountDownView setTimeTvBackgroundColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-991882924") ? (DMDXCountDownView) ipChange.ipc$dispatch("-991882924", new Object[]{this, str}) : setTimeTvBackgroundColor(parseColor(str));
    }

    public DMDXCountDownView setTimeTvBackgroundColorWidthRadius(String str, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "779709239") ? (DMDXCountDownView) ipChange.ipc$dispatch("779709239", new Object[]{this, str, Integer.valueOf(i)}) : setTimeTvBackgroundColorWidthRadius(parseColor(str), i);
    }

    public DMDXCountDownView setTimeTvBackgroundRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1961813014")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1961813014", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourTv.setBackgroundResource(i);
        this.minuteTv.setBackgroundResource(i);
        this.secondTv.setBackgroundResource(i);
        return this;
    }

    public DMDXCountDownView setTimeTvFontName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "44804145")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("44804145", new Object[]{this, str});
        }
        if (!TextUtils.isEmpty(str)) {
            ep0.b(this.hourTv, str);
            ep0.b(this.minuteTv, str);
            ep0.b(this.secondTv, str);
        }
        return this;
    }

    public DMDXCountDownView setTimeTvGravity(CountDownViewGravity countDownViewGravity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2107601485")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("2107601485", new Object[]{this, countDownViewGravity});
        }
        int i = 17;
        if (countDownViewGravity == CountDownViewGravity.GRAVITY_BOTTOM) {
            i = 80;
        } else if (countDownViewGravity != CountDownViewGravity.GRAVITY_CENTER) {
            if (countDownViewGravity == CountDownViewGravity.GRAVITY_LEFT) {
                i = GravityCompat.START;
            } else if (countDownViewGravity == CountDownViewGravity.GRAVITY_RIGHT) {
                i = GravityCompat.END;
            } else if (countDownViewGravity == CountDownViewGravity.GRAVITY_TOP) {
                i = 48;
            }
        }
        this.hourTv.setGravity(i);
        this.minuteTv.setGravity(i);
        this.secondTv.setGravity(i);
        return this;
    }

    public DMDXCountDownView setTimeTvPadding(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1639207514")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1639207514", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        this.hourTv.setPadding(i, i2, i3, i4);
        this.minuteTv.setPadding(i, i2, i3, i4);
        this.secondTv.setPadding(i, i2, i3, i4);
        return this;
    }

    public DMDXCountDownView setTimeTvSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2061263986")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("2061263986", new Object[]{this, Float.valueOf(f)});
        }
        this.hourTv.setTextSize(1, f);
        this.minuteTv.setTextSize(1, f);
        this.secondTv.setTextSize(1, f);
        return this;
    }

    public DMDXCountDownView setTimeTvTextColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1138355317") ? (DMDXCountDownView) ipChange.ipc$dispatch("1138355317", new Object[]{this, str}) : setTimeTvTextColor(parseColor(str));
    }

    public DMDXCountDownView setTimeTvWH(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744505134")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-744505134", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (i > 0 && i2 > 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
            this.hourTv.setLayoutParams(layoutParams);
            this.minuteTv.setLayoutParams(layoutParams);
            this.secondTv.setLayoutParams(layoutParams);
        }
        return this;
    }

    public DMDXCountDownView startCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-520830007")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-520830007", new Object[]{this});
        }
        this.isContinue = true;
        countDown();
        return this;
    }

    public DMDXCountDownView stopCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615737887")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1615737887", new Object[]{this});
        }
        this.timeStamp = 0L;
        return this;
    }

    public DMDXCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMDXCountDownView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isContinue = false;
        this.colon = ":";
        this.mExecutorService = Executors.newSingleThreadExecutor();
        this.myHandler = new HandlerC0668a(this);
        this.lastTime = 0L;
        this.timeEnd = 0L;
        this.context = context;
        init();
    }

    public DMDXCountDownView setHourColonTvBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1684312967")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1684312967", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourColonTv.setBackgroundColor(i);
        return this;
    }

    public DMDXCountDownView setHourColonTvTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-430162618")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-430162618", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourColonTv.setTextColor(i);
        return this;
    }

    public DMDXCountDownView setHourTvBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "251744906")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("251744906", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourTv.setBackgroundColor(i);
        return this;
    }

    public DMDXCountDownView setHourTvBackgroundColorWithRadius(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2083924065")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-2083924065", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (i2 == 0) {
            return setHourTvBackgroundColor(i);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i2);
        gradientDrawable.setColor(i);
        if (Build.VERSION.SDK_INT >= 16) {
            this.hourTv.setBackground(gradientDrawable);
        } else {
            this.hourTv.setBackgroundDrawable(gradientDrawable);
        }
        return this;
    }

    public DMDXCountDownView setHourTvTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2032745097")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("2032745097", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourTv.setTextColor(i);
        return this;
    }

    public DMDXCountDownView setMinuteColonTvBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2133267305")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-2133267305", new Object[]{this, Integer.valueOf(i)});
        }
        this.minuteColonTv.setBackgroundColor(i);
        return this;
    }

    public DMDXCountDownView setMinuteColonTvTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "588030550")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("588030550", new Object[]{this, Integer.valueOf(i)});
        }
        this.minuteColonTv.setTextColor(i);
        return this;
    }

    public DMDXCountDownView setMinuteTvBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1750962042")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1750962042", new Object[]{this, Integer.valueOf(i)});
        }
        this.minuteTv.setBackgroundColor(i);
        return this;
    }

    public DMDXCountDownView setMinuteTvTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "670165881")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("670165881", new Object[]{this, Integer.valueOf(i)});
        }
        this.minuteTv.setTextColor(i);
        return this;
    }

    public DMDXCountDownView setSecondTvBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-101255718")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-101255718", new Object[]{this, Integer.valueOf(i)});
        }
        this.secondTv.setBackgroundColor(i);
        return this;
    }

    public DMDXCountDownView setSecondTvBackgroundColorWidthRadius(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902510421")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-902510421", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (i2 == 0) {
            return setSecondTvBackgroundColor(i);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i2);
        gradientDrawable.setColor(i);
        if (Build.VERSION.SDK_INT >= 16) {
            this.secondTv.setBackground(gradientDrawable);
        } else {
            this.secondTv.setBackgroundDrawable(gradientDrawable);
        }
        return this;
    }

    public DMDXCountDownView setSecondTvTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1464886823")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-1464886823", new Object[]{this, Integer.valueOf(i)});
        }
        this.secondTv.setTextColor(i);
        return this;
    }

    public DMDXCountDownView setTimeTvBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1621239347")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("1621239347", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourTv.setBackgroundColor(i);
        this.minuteTv.setBackgroundColor(i);
        this.secondTv.setBackgroundColor(i);
        return this;
    }

    public DMDXCountDownView setTimeTvBackgroundColorWidthRadius(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86326148")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("86326148", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (i2 == 0) {
            return setTimeTvBackgroundColor(i);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i2);
        gradientDrawable.setColor(i);
        return setTimeTvBackground(gradientDrawable);
    }

    public DMDXCountDownView setTimeTvTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-96976654")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("-96976654", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourTv.setTextColor(i);
        this.minuteTv.setTextColor(i);
        this.secondTv.setTextColor(i);
        return this;
    }

    public DMDXCountDownView setMinuteTvBackgroundColorWidthRadius(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "811725387")) {
            return (DMDXCountDownView) ipChange.ipc$dispatch("811725387", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (i2 == 0) {
            return setMinuteTvBackgroundColor(i);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i2);
        gradientDrawable.setColor(i);
        if (Build.VERSION.SDK_INT >= 16) {
            this.minuteTv.setBackground(gradientDrawable);
        } else {
            this.minuteTv.setBackgroundDrawable(gradientDrawable);
        }
        return this;
    }
}
