package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import com.alibaba.pictures.dolores.time.TimeSyncer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tb.dp0;
import tb.s60;
import tb.ss;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DMCountDownView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int UPDATE_UI_CODE = 101;
    private String colon;
    private Context context;
    private CountDownEndListener countDownEndListener;
    private TextView dayTv;
    private FakeBoldTextView hourColonTv;
    private TextView hourTv;
    private boolean isContinue;
    private boolean isPaused;
    long lastTime;
    private ExecutorService mExecutorService;
    private FakeBoldTextView minuteColonTv;
    private TextView minuteTv;
    private Handler myHandler;
    private long originalTime;
    private TextView secondTv;
    private boolean showDayTv;
    long timeEnd;
    private volatile long timeStamp;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface CountDownEndListener {
        void onCountDownEnd();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum CountDownViewGravity {
        GRAVITY_CENTER,
        GRAVITY_LEFT,
        GRAVITY_RIGHT,
        GRAVITY_TOP,
        GRAVITY_BOTTOM
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.DMCountDownView$a */
    /* loaded from: classes7.dex */
    public static class HandlerC3573a extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        private final WeakReference<DMCountDownView> a;

        HandlerC3573a(DMCountDownView dMCountDownView) {
            this.a = new WeakReference<>(dMCountDownView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1767504152")) {
                ipChange.ipc$dispatch("-1767504152", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            DMCountDownView dMCountDownView = this.a.get();
            if (dMCountDownView != null && message.what == 101) {
                Object obj = message.obj;
                if (obj != null) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length == 3) {
                        if (dMCountDownView.dayTv != null) {
                            dMCountDownView.dayTv.setVisibility(8);
                        }
                        for (int i = 0; i < strArr.length; i++) {
                            if (i == 0) {
                                dMCountDownView.updateTvText(strArr[0], dMCountDownView.hourTv);
                            } else if (i == 1) {
                                dMCountDownView.updateTvText(strArr[1], dMCountDownView.minuteTv);
                            } else if (i == 2) {
                                dMCountDownView.updateTvText(strArr[2], dMCountDownView.secondTv);
                            }
                        }
                    } else if (strArr.length == 4) {
                        for (int i2 = 0; i2 < strArr.length; i2++) {
                            if (i2 != 0) {
                                if (i2 == 1) {
                                    dMCountDownView.updateTvText(strArr[i2], dMCountDownView.hourTv);
                                } else if (i2 == 2) {
                                    dMCountDownView.updateTvText(strArr[i2], dMCountDownView.minuteTv);
                                } else if (i2 == 3) {
                                    dMCountDownView.updateTvText(strArr[i2], dMCountDownView.secondTv);
                                }
                            } else if ("0".equals(strArr[i2]) || TextUtils.isEmpty(strArr[i2])) {
                                dMCountDownView.dayTv.setVisibility(8);
                            } else {
                                dMCountDownView.dayTv.setVisibility(0);
                                dMCountDownView.updateTvText(strArr[i2] + "天", dMCountDownView.dayTv);
                            }
                        }
                    }
                    Log.d("DMCountDownView", "handleMessage");
                }
                if (dMCountDownView.isContinue || dMCountDownView.timeStamp > 0 || dMCountDownView.countDownEndListener == null) {
                    return;
                }
                dMCountDownView.countDownEndListener.onCountDownEnd();
            }
        }
    }

    public DMCountDownView(Context context) {
        this(context, null);
    }

    static /* synthetic */ long access$210(DMCountDownView dMCountDownView) {
        long j = dMCountDownView.timeStamp;
        dMCountDownView.timeStamp = j - 1;
        return j;
    }

    private void countDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2020086397")) {
            ipChange.ipc$dispatch("2020086397", new Object[]{this});
            return;
        }
        Thread thread = new Thread(new Runnable() { // from class: com.alibaba.pictures.bricks.view.DMCountDownView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1730251158")) {
                    ipChange2.ipc$dispatch("1730251158", new Object[]{this});
                    return;
                }
                while (DMCountDownView.this.isContinue && !DMCountDownView.this.isPaused) {
                    try {
                        DMCountDownView dMCountDownView = DMCountDownView.this;
                        dMCountDownView.isContinue = DMCountDownView.access$210(dMCountDownView) > 1;
                        String[] a = DMCountDownView.this.showDayTv ? ss.a(DMCountDownView.this.timeStamp) : ss.c(DMCountDownView.this.timeStamp);
                        Message obtain = Message.obtain();
                        obtain.obj = a;
                        obtain.what = 101;
                        DMCountDownView.this.myHandler.sendMessage(obtain);
                        Thread.sleep(1000L);
                        Log.d("DMCountDownView", "timeStamp = " + DMCountDownView.this.timeStamp);
                        Log.e("subTitleView", "DMCountDownView timeStamp : " + DMCountDownView.this.timeStamp);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                DMCountDownView.this.isContinue = true;
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
        if (AndroidInstantRuntime.support(ipChange, "-428771892")) {
            ipChange.ipc$dispatch("-428771892", new Object[]{this});
            return;
        }
        setOrientation(0);
        setGravity(16);
        TextView textView = new TextView(this.context);
        this.dayTv = textView;
        textView.setTextColor(parseColor("#000000"));
        this.dayTv.setBackgroundColor(parseColor("#DEDEDE"));
        this.dayTv.setTextSize(1, 12.0f);
        this.dayTv.setGravity(17);
        addView(this.dayTv);
        TextView textView2 = new TextView(this.context);
        this.hourTv = textView2;
        textView2.setTextColor(parseColor("#000000"));
        this.hourTv.setBackgroundColor(parseColor("#DEDEDE"));
        this.hourTv.setTextSize(1, 12.0f);
        this.hourTv.setGravity(17);
        addView(this.hourTv);
        FakeBoldTextView fakeBoldTextView = new FakeBoldTextView(this.context);
        this.hourColonTv = fakeBoldTextView;
        fakeBoldTextView.setTextColor(parseColor("#000000"));
        this.hourColonTv.setTextSize(1, 12.0f);
        this.hourColonTv.setText(this.colon);
        this.hourColonTv.setGravity(17);
        addView(this.hourColonTv);
        ((LinearLayout.LayoutParams) this.hourColonTv.getLayoutParams()).gravity = 17;
        s60 s60Var = s60.INSTANCE;
        ((LinearLayout.LayoutParams) this.hourColonTv.getLayoutParams()).bottomMargin = s60Var.a(this.context, 0.5f);
        TextView textView3 = new TextView(this.context);
        this.minuteTv = textView3;
        textView3.setTextColor(parseColor("#000000"));
        this.minuteTv.setBackgroundColor(parseColor("#DEDEDE"));
        this.minuteTv.setTextSize(1, 12.0f);
        this.minuteTv.setGravity(17);
        addView(this.minuteTv);
        FakeBoldTextView fakeBoldTextView2 = new FakeBoldTextView(this.context);
        this.minuteColonTv = fakeBoldTextView2;
        fakeBoldTextView2.setTextColor(parseColor("#000000"));
        this.minuteColonTv.setTextSize(1, 12.0f);
        this.minuteColonTv.setText(this.colon);
        this.minuteColonTv.setGravity(17);
        addView(this.minuteColonTv);
        ((LinearLayout.LayoutParams) this.minuteColonTv.getLayoutParams()).gravity = 17;
        ((LinearLayout.LayoutParams) this.minuteColonTv.getLayoutParams()).bottomMargin = s60Var.a(this.context, 0.5f);
        TextView textView4 = new TextView(this.context);
        this.secondTv = textView4;
        textView4.setTextColor(parseColor("#000000"));
        this.secondTv.setBackgroundColor(parseColor("#DEDEDE"));
        this.secondTv.setTextSize(1, 12.0f);
        this.secondTv.setGravity(17);
        addView(this.secondTv);
    }

    private int parseColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "693899241")) {
            return ((Integer) ipChange.ipc$dispatch("693899241", new Object[]{this, str})).intValue();
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            Log.d("DMCountDownView", e.getMessage());
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTvText(String str, TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1544850602")) {
            ipChange.ipc$dispatch("-1544850602", new Object[]{this, str, textView});
        } else if (textView == null) {
        } else {
            textView.setText(str);
        }
    }

    public void destoryCountDownView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-174948422")) {
            ipChange.ipc$dispatch("-174948422", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-265828617")) {
            ipChange.ipc$dispatch("-265828617", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        super.dispatchVisibilityChanged(view, i);
        if (i == 4) {
            this.lastTime = TimeSyncer.INSTANCE.g();
            this.timeEnd = this.timeStamp;
            Log.e("DMCountDownView", "onVisibilityChanged INVISIBLE");
            pauseCountDown();
            return;
        }
        long g = TimeSyncer.INSTANCE.g() - this.lastTime;
        StringBuilder sb = new StringBuilder();
        sb.append("onVisibilityChanged VISIBLE");
        long j = g / 1000;
        sb.append(j);
        Log.e("DMCountDownView", sb.toString());
        this.timeStamp = this.timeEnd - j;
        startCountDown();
    }

    public long getCountTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1399281226") ? ((Long) ipChange.ipc$dispatch("1399281226", new Object[]{this})).longValue() : this.originalTime;
    }

    public long getTimeStamp() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1421702256") ? ((Long) ipChange.ipc$dispatch("-1421702256", new Object[]{this})).longValue() : this.timeStamp;
    }

    public DMCountDownView pauseCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1227867965")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1227867965", new Object[]{this});
        }
        this.isPaused = true;
        return this;
    }

    public DMCountDownView setColonTvBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-892144277")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-892144277", new Object[]{this, drawable});
        }
        if (drawable != null && Build.VERSION.SDK_INT >= 16) {
            this.hourColonTv.setBackground(drawable);
            this.minuteColonTv.setBackground(drawable);
        }
        return this;
    }

    public DMCountDownView setColonTvBackgroundColorHex(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950127459")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1950127459", new Object[]{this, str});
        }
        int parseColor = parseColor(str);
        this.hourColonTv.setBackgroundColor(parseColor);
        this.minuteColonTv.setBackgroundColor(parseColor);
        return this;
    }

    public DMCountDownView setColonTvBackgroundRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1186701174")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1186701174", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourColonTv.setBackgroundResource(i);
        this.minuteColonTv.setBackgroundResource(i);
        return this;
    }

    public DMCountDownView setColonTvGravity(CountDownViewGravity countDownViewGravity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1855657777")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1855657777", new Object[]{this, countDownViewGravity});
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

    public DMCountDownView setColonTvSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1595997082")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1595997082", new Object[]{this, Float.valueOf(f)});
        }
        this.hourColonTv.setTextSize(1, f);
        this.minuteColonTv.setTextSize(1, f);
        return this;
    }

    public DMCountDownView setColonTvTextColorHex(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "169409116")) {
            return (DMCountDownView) ipChange.ipc$dispatch("169409116", new Object[]{this, str});
        }
        int parseColor = parseColor(str);
        this.hourColonTv.setTextColor(parseColor);
        this.minuteColonTv.setTextColor(parseColor);
        return this;
    }

    public DMCountDownView setColonTvWH(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-17304270")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-17304270", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        this.hourColonTv.setLayoutParams(layoutParams);
        this.minuteColonTv.setLayoutParams(layoutParams);
        return this;
    }

    public void setCountDownEndListener(CountDownEndListener countDownEndListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1468570904")) {
            ipChange.ipc$dispatch("1468570904", new Object[]{this, countDownEndListener});
        } else {
            this.countDownEndListener = countDownEndListener;
        }
    }

    public DMCountDownView setCountTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1076873468")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1076873468", new Object[]{this, Long.valueOf(j)});
        }
        this.timeStamp = j;
        this.originalTime = j;
        return this;
    }

    public DMCountDownView setHourColonTvBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1748139111")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1748139111", new Object[]{this, drawable});
        }
        if (drawable != null && Build.VERSION.SDK_INT >= 16) {
            this.hourColonTv.setBackground(drawable);
        }
        return this;
    }

    public DMCountDownView setHourColonTvBackgroundColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "198434560") ? (DMCountDownView) ipChange.ipc$dispatch("198434560", new Object[]{this, str}) : setHourColonTvBackgroundColor(parseColor(str));
    }

    public DMCountDownView setHourColonTvBackgroundRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2065045106")) {
            return (DMCountDownView) ipChange.ipc$dispatch("2065045106", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourColonTv.setBackgroundResource(i);
        return this;
    }

    public DMCountDownView setHourColonTvBold(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898021510")) {
            return (DMCountDownView) ipChange.ipc$dispatch("898021510", new Object[]{this, Boolean.valueOf(z)});
        }
        this.hourColonTv.getPaint().setFakeBoldText(z);
        return this;
    }

    public DMCountDownView setHourColonTvGravity(CountDownViewGravity countDownViewGravity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1665159635")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1665159635", new Object[]{this, countDownViewGravity});
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

    public DMCountDownView setHourColonTvMargins(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "764368250")) {
            return (DMCountDownView) ipChange.ipc$dispatch("764368250", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, i2, i3, i4);
        this.hourColonTv.setLayoutParams(layoutParams);
        return this;
    }

    public DMCountDownView setHourColonTvPadding(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "13847814")) {
            return (DMCountDownView) ipChange.ipc$dispatch("13847814", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        this.hourColonTv.setPadding(i, i2, i3, i4);
        return this;
    }

    public DMCountDownView setHourColonTvSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1652361086")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1652361086", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
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

    public DMCountDownView setHourColonTvText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-105079936")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-105079936", new Object[]{this, str});
        }
        this.hourColonTv.setText(str);
        return this;
    }

    public DMCountDownView setHourColonTvTextColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1178176863") ? (DMCountDownView) ipChange.ipc$dispatch("-1178176863", new Object[]{this, str}) : setHourColonTvTextColor(parseColor(str));
    }

    public DMCountDownView setHourColonTvTextSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1810559375")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1810559375", new Object[]{this, Float.valueOf(f)});
        }
        this.hourColonTv.setTextSize(1, f);
        return this;
    }

    public DMCountDownView setHourTvBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1658984158")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1658984158", new Object[]{this, drawable});
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

    public DMCountDownView setHourTvBackgroundColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1706074523") ? (DMCountDownView) ipChange.ipc$dispatch("-1706074523", new Object[]{this, str}) : setHourTvBackgroundColor(parseColor(str));
    }

    public DMCountDownView setHourTvBackgroundColorWithRadius(String str, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1884903932") ? (DMCountDownView) ipChange.ipc$dispatch("1884903932", new Object[]{this, str, Integer.valueOf(i)}) : setHourTvBackgroundColorWithRadius(parseColor(str), i);
    }

    public DMCountDownView setHourTvBackgroundRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1647628499")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1647628499", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourTv.setBackgroundResource(i);
        return this;
    }

    public DMCountDownView setHourTvBold(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1507929749")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1507929749", new Object[]{this, Boolean.valueOf(z)});
        }
        this.hourTv.getPaint().setFakeBoldText(z);
        return this;
    }

    public DMCountDownView setHourTvGravity(CountDownViewGravity countDownViewGravity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1435594472")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1435594472", new Object[]{this, countDownViewGravity});
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
        if (this.showDayTv) {
            this.dayTv.setGravity(i);
        }
        return this;
    }

    public DMCountDownView setHourTvMargins(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1280807265")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1280807265", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, i2, i3, i4);
        this.minuteTv.setLayoutParams(layoutParams);
        return this;
    }

    public DMCountDownView setHourTvPadding(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2031327701")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-2031327701", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        this.hourTv.setPadding(i, i2, i3, i4);
        return this;
    }

    public DMCountDownView setHourTvSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "82316089")) {
            return (DMCountDownView) ipChange.ipc$dispatch("82316089", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
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

    public DMCountDownView setHourTvTextColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "756720070") ? (DMCountDownView) ipChange.ipc$dispatch("756720070", new Object[]{this, str}) : setHourTvTextColor(parseColor(str));
    }

    public DMCountDownView setHourTvTextSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1467755734")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1467755734", new Object[]{this, Float.valueOf(f)});
        }
        if (this.showDayTv) {
            this.dayTv.setTextSize(1, f);
        }
        this.hourTv.setTextSize(1, f);
        return this;
    }

    public DMCountDownView setMinuteColonTvBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "973066359")) {
            return (DMCountDownView) ipChange.ipc$dispatch("973066359", new Object[]{this, drawable});
        }
        if (drawable != null && Build.VERSION.SDK_INT >= 16) {
            this.minuteColonTv.setBackground(drawable);
        }
        return this;
    }

    public DMCountDownView setMinuteColonTvBackgroundColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2002833168") ? (DMCountDownView) ipChange.ipc$dispatch("-2002833168", new Object[]{this, str}) : setMinuteColonTvBackgroundColor(parseColor(str));
    }

    public DMCountDownView setMinuteColonTvBackgroundRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2058857090")) {
            return (DMCountDownView) ipChange.ipc$dispatch("2058857090", new Object[]{this, Integer.valueOf(i)});
        }
        this.minuteColonTv.setBackgroundResource(i);
        return this;
    }

    public DMCountDownView setMinuteColonTvBold(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1037783670")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1037783670", new Object[]{this, Boolean.valueOf(z)});
        }
        this.minuteColonTv.getPaint().setFakeBoldText(z);
        return this;
    }

    public DMCountDownView setMinuteColonTvGravity(CountDownViewGravity countDownViewGravity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1581727171")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1581727171", new Object[]{this, countDownViewGravity});
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

    public DMCountDownView setMinuteColonTvMargins(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-668681366")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-668681366", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, i2, i3, i4);
        this.minuteColonTv.setLayoutParams(layoutParams);
        return this;
    }

    public DMCountDownView setMinuteColonTvPadding(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1419201802")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1419201802", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        this.minuteColonTv.setPadding(i, i2, i3, i4);
        return this;
    }

    public DMCountDownView setMinuteColonTvSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1690020750")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1690020750", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
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

    public DMCountDownView setMinuteColonTvText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1664016496")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1664016496", new Object[]{this, str});
        }
        this.minuteColonTv.setText(str);
        return this;
    }

    public DMCountDownView setMinuteColonTvTextColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1043462289") ? (DMCountDownView) ipChange.ipc$dispatch("1043462289", new Object[]{this, str}) : setMinuteColonTvTextColor(parseColor(str));
    }

    public DMCountDownView setMinuteColonTvTextSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-877973407")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-877973407", new Object[]{this, Float.valueOf(f)});
        }
        this.minuteColonTv.setTextSize(1, f);
        return this;
    }

    public DMCountDownView setMinuteTvBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-969913582")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-969913582", new Object[]{this, drawable});
        }
        if (drawable != null && Build.VERSION.SDK_INT >= 16) {
            this.minuteTv.setBackground(drawable);
        }
        return this;
    }

    public DMCountDownView setMinuteTvBackgroundColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1554737547") ? (DMCountDownView) ipChange.ipc$dispatch("-1554737547", new Object[]{this, str}) : setMinuteTvBackgroundColor(parseColor(str));
    }

    public DMCountDownView setMinuteTvBackgroundColorWidthRadius(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "675822680")) {
            return (DMCountDownView) ipChange.ipc$dispatch("675822680", new Object[]{this, str, Integer.valueOf(i)});
        }
        if (i == 0) {
            return setMinuteTvBackgroundColor(str);
        }
        return setMinuteTvBackgroundColorWidthRadius(parseColor(str), i);
    }

    public DMCountDownView setMinuteTvBackgroundRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-715042531")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-715042531", new Object[]{this, Integer.valueOf(i)});
        }
        this.minuteTv.setBackgroundResource(i);
        return this;
    }

    public DMCountDownView setMinuteTvBold(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1424867707")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1424867707", new Object[]{this, Boolean.valueOf(z)});
        }
        this.minuteTv.getPaint().setFakeBoldText(z);
        return this;
    }

    public DMCountDownView setMinuteTvGravity(CountDownViewGravity countDownViewGravity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1864372440")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1864372440", new Object[]{this, countDownViewGravity});
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

    public DMCountDownView setMinuteTvMargins(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1243147601")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1243147601", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, i2, i3, i4);
        this.minuteTv.setLayoutParams(layoutParams);
        return this;
    }

    public DMCountDownView setMinuteTvPadding(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1993668037")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1993668037", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        this.minuteTv.setPadding(i, i2, i3, i4);
        return this;
    }

    public DMCountDownView setMinuteTvSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "804724009")) {
            return (DMCountDownView) ipChange.ipc$dispatch("804724009", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
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

    public DMCountDownView setMinuteTvTextColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-802216490") ? (DMCountDownView) ipChange.ipc$dispatch("-802216490", new Object[]{this, str}) : setMinuteTvTextColor(parseColor(str));
    }

    public DMCountDownView setMinuteTvTextSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "640980198")) {
            return (DMCountDownView) ipChange.ipc$dispatch("640980198", new Object[]{this, Float.valueOf(f)});
        }
        this.minuteTv.setTextSize(1, f);
        return this;
    }

    public DMCountDownView setSecondTvBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-511362702")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-511362702", new Object[]{this, drawable});
        }
        if (drawable != null && Build.VERSION.SDK_INT >= 16) {
            this.secondTv.setBackground(drawable);
        }
        return this;
    }

    public DMCountDownView setSecondTvBackgroundColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1555811349") ? (DMCountDownView) ipChange.ipc$dispatch("1555811349", new Object[]{this, str}) : setSecondTvBackgroundColor(parseColor(str));
    }

    public DMCountDownView setSecondTvBackgroundColorWidthRadius(String str, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "829161976") ? (DMCountDownView) ipChange.ipc$dispatch("829161976", new Object[]{this, str, Integer.valueOf(i)}) : setSecondTvBackgroundColorWidthRadius(parseColor(str), i);
    }

    public DMCountDownView setSecondTvBackgroundRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "621264765")) {
            return (DMCountDownView) ipChange.ipc$dispatch("621264765", new Object[]{this, Integer.valueOf(i)});
        }
        this.secondTv.setBackgroundResource(i);
        return this;
    }

    public DMCountDownView setSecondTvBold(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-662722789")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-662722789", new Object[]{this, Boolean.valueOf(z)});
        }
        this.secondTv.getPaint().setFakeBoldText(z);
        return this;
    }

    public DMCountDownView setSecondTvGravity(CountDownViewGravity countDownViewGravity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-64782536")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-64782536", new Object[]{this, countDownViewGravity});
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

    public DMCountDownView setSecondTvMargins(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1952563121")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1952563121", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, i2, i3, i4);
        this.secondTv.setLayoutParams(layoutParams);
        return this;
    }

    public DMCountDownView setSecondTvPadding(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1591883739")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1591883739", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        this.secondTv.setPadding(i, i2, i3, i4);
        return this;
    }

    public DMCountDownView setSecondTvSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "513928073")) {
            return (DMCountDownView) ipChange.ipc$dispatch("513928073", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
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

    public DMCountDownView setSecondTvTextColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1642654858") ? (DMCountDownView) ipChange.ipc$dispatch("-1642654858", new Object[]{this, str}) : setSecondTvTextColor(parseColor(str));
    }

    public DMCountDownView setSecondTvTextSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "488286854")) {
            return (DMCountDownView) ipChange.ipc$dispatch("488286854", new Object[]{this, Float.valueOf(f)});
        }
        this.secondTv.setTextSize(1, f);
        return this;
    }

    public DMCountDownView setTimeTvBackground(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "822934923")) {
            return (DMCountDownView) ipChange.ipc$dispatch("822934923", new Object[]{this, drawable});
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

    public DMCountDownView setTimeTvBackgroundColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1305105244") ? (DMCountDownView) ipChange.ipc$dispatch("1305105244", new Object[]{this, str}) : setTimeTvBackgroundColor(parseColor(str));
    }

    public DMCountDownView setTimeTvBackgroundColorWidthRadius(String str, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1010751167") ? (DMCountDownView) ipChange.ipc$dispatch("1010751167", new Object[]{this, str, Integer.valueOf(i)}) : setTimeTvBackgroundColorWidthRadius(parseColor(str), i);
    }

    public DMCountDownView setTimeTvBackgroundRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1579034518")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1579034518", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourTv.setBackgroundResource(i);
        this.minuteTv.setBackgroundResource(i);
        this.secondTv.setBackgroundResource(i);
        return this;
    }

    public DMCountDownView setTimeTvFontName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1322160847")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1322160847", new Object[]{this, str});
        }
        if (!TextUtils.isEmpty(str)) {
            if (this.showDayTv) {
                dp0.a(this.dayTv, str);
            }
            dp0.a(this.hourTv, str);
            dp0.a(this.minuteTv, str);
            dp0.a(this.secondTv, str);
        }
        return this;
    }

    public DMCountDownView setTimeTvGravity(CountDownViewGravity countDownViewGravity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-441671855")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-441671855", new Object[]{this, countDownViewGravity});
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
        if (this.showDayTv) {
            this.dayTv.setGravity(i);
        }
        this.hourTv.setGravity(i);
        this.minuteTv.setGravity(i);
        this.secondTv.setGravity(i);
        return this;
    }

    public DMCountDownView setTimeTvPadding(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-373985694")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-373985694", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        this.hourTv.setPadding(i, i2, i3, i4);
        this.minuteTv.setPadding(i, i2, i3, i4);
        this.secondTv.setPadding(i, i2, i3, i4);
        return this;
    }

    public DMCountDownView setTimeTvSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1260466310")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1260466310", new Object[]{this, Float.valueOf(f)});
        }
        if (this.showDayTv) {
            this.dayTv.setTextSize(1, f);
        }
        this.hourTv.setTextSize(1, f);
        this.minuteTv.setTextSize(1, f);
        this.secondTv.setTextSize(1, f);
        return this;
    }

    public DMCountDownView setTimeTvTextColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2125308931") ? (DMCountDownView) ipChange.ipc$dispatch("-2125308931", new Object[]{this, str}) : setTimeTvTextColor(parseColor(str));
    }

    public DMCountDownView setTimeTvWH(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "306193746")) {
            return (DMCountDownView) ipChange.ipc$dispatch("306193746", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (i > 0 && i2 > 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
            this.hourTv.setLayoutParams(layoutParams);
            this.minuteTv.setLayoutParams(layoutParams);
            this.secondTv.setLayoutParams(layoutParams);
        }
        return this;
    }

    public DMCountDownView showDayTv(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2056016215")) {
            return (DMCountDownView) ipChange.ipc$dispatch("2056016215", new Object[]{this, Boolean.valueOf(z)});
        }
        this.showDayTv = z;
        if (z) {
            this.dayTv.setVisibility(0);
        } else {
            this.dayTv.setVisibility(8);
        }
        return this;
    }

    public DMCountDownView startCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "695795793")) {
            return (DMCountDownView) ipChange.ipc$dispatch("695795793", new Object[]{this});
        }
        this.isPaused = false;
        this.isContinue = true;
        countDown();
        return this;
    }

    public DMCountDownView stopCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "565018911")) {
            return (DMCountDownView) ipChange.ipc$dispatch("565018911", new Object[]{this});
        }
        this.timeStamp = 0L;
        return this;
    }

    public DMCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMCountDownView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isContinue = false;
        this.isPaused = false;
        this.colon = ":";
        this.mExecutorService = Executors.newSingleThreadExecutor();
        this.showDayTv = false;
        this.myHandler = new HandlerC3573a(this);
        this.lastTime = 0L;
        this.timeEnd = 0L;
        this.context = context;
        init();
    }

    public DMCountDownView setHourColonTvBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "460657423")) {
            return (DMCountDownView) ipChange.ipc$dispatch("460657423", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourColonTv.setBackgroundColor(i);
        return this;
    }

    public DMCountDownView setHourColonTvTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "538404174")) {
            return (DMCountDownView) ipChange.ipc$dispatch("538404174", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourColonTv.setTextColor(i);
        return this;
    }

    public DMCountDownView setHourTvBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1699145994")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1699145994", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourTv.setBackgroundColor(i);
        if (this.showDayTv) {
            this.dayTv.setBackgroundColor(i);
        }
        return this;
    }

    public DMCountDownView setHourTvBackgroundColorWithRadius(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1701052455")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1701052455", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (i2 == 0) {
            return setHourTvBackgroundColor(i);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i2);
        gradientDrawable.setColor(i);
        if (Build.VERSION.SDK_INT >= 16) {
            this.hourTv.setBackground(gradientDrawable);
            if (this.showDayTv) {
                this.dayTv.setBackground(gradientDrawable);
            }
        } else {
            this.hourTv.setBackgroundDrawable(gradientDrawable);
            if (this.showDayTv) {
                this.dayTv.setBackgroundDrawable(gradientDrawable);
            }
        }
        return this;
    }

    public DMCountDownView setHourTvTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-913042551")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-913042551", new Object[]{this, Integer.valueOf(i)});
        }
        this.hourTv.setTextColor(i);
        if (this.showDayTv) {
            this.dayTv.setTextColor(i);
        }
        return this;
    }

    public DMCountDownView setMinuteColonTvBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1191058657")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1191058657", new Object[]{this, Integer.valueOf(i)});
        }
        this.minuteColonTv.setBackgroundColor(i);
        return this;
    }

    public DMCountDownView setMinuteColonTvTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-616201890")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-616201890", new Object[]{this, Integer.valueOf(i)});
        }
        this.minuteColonTv.setTextColor(i);
        return this;
    }

    public DMCountDownView setMinuteTvBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "266096378")) {
            return (DMCountDownView) ipChange.ipc$dispatch("266096378", new Object[]{this, Integer.valueOf(i)});
        }
        this.minuteTv.setBackgroundColor(i);
        return this;
    }

    public DMCountDownView setMinuteTvTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-773280391")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-773280391", new Object[]{this, Integer.valueOf(i)});
        }
        this.minuteTv.setTextColor(i);
        return this;
    }

    public DMCountDownView setSecondTvBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "262186330")) {
            return (DMCountDownView) ipChange.ipc$dispatch("262186330", new Object[]{this, Integer.valueOf(i)});
        }
        this.secondTv.setBackgroundColor(i);
        return this;
    }

    public DMCountDownView setSecondTvBackgroundColorWidthRadius(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-102240085")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-102240085", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
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

    public DMCountDownView setSecondTvTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1211806759")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1211806759", new Object[]{this, Integer.valueOf(i)});
        }
        this.secondTv.setTextColor(i);
        return this;
    }

    public DMCountDownView setTimeTvBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1555917619")) {
            return (DMCountDownView) ipChange.ipc$dispatch("1555917619", new Object[]{this, Integer.valueOf(i)});
        }
        if (this.showDayTv) {
            this.dayTv.setBackgroundColor(i);
        }
        this.hourTv.setBackgroundColor(i);
        this.minuteTv.setBackgroundColor(i);
        this.secondTv.setBackgroundColor(i);
        return this;
    }

    public DMCountDownView setTimeTvBackgroundColorWidthRadius(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2115352836")) {
            return (DMCountDownView) ipChange.ipc$dispatch("2115352836", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (i2 == 0) {
            return setTimeTvBackgroundColor(i);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i2);
        gradientDrawable.setColor(i);
        return setTimeTvBackground(gradientDrawable);
    }

    public DMCountDownView setTimeTvTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1275221902")) {
            return (DMCountDownView) ipChange.ipc$dispatch("-1275221902", new Object[]{this, Integer.valueOf(i)});
        }
        if (this.showDayTv) {
            this.dayTv.setTextColor(i);
        }
        this.hourTv.setTextColor(i);
        this.minuteTv.setTextColor(i);
        this.secondTv.setTextColor(i);
        return this;
    }

    public DMCountDownView setMinuteTvBackgroundColorWidthRadius(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "181545547")) {
            return (DMCountDownView) ipChange.ipc$dispatch("181545547", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
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
