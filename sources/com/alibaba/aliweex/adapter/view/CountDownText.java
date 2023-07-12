package com.alibaba.aliweex.adapter.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import cn.damai.common.util.ACache;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXResourceUtils;
import com.taobao.weex.utils.WXViewUtils;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class CountDownText implements Runnable {
    private String dataFormat;
    private long day;
    private long hour;
    private TextView mCountDownView;
    private Handler mHandler;
    private long min;
    private long remainingTime;
    private boolean reset;
    private long sec;
    private String textColor;
    private String timeColor;
    private int oneDay = 86400;
    private int oneHour = ACache.TIME_HOUR;
    private int oneMin = 60;
    private int dayIndex = -1;
    private int hourIndex = -1;
    private int minIndex = -1;
    private int secIndex = -1;
    private int textSize = 22;
    private int timeSize = 22;

    public CountDownText(Context context) {
        init(context);
    }

    private void computeTime() {
        long j = this.remainingTime;
        int i = this.oneDay;
        long j2 = j / i;
        this.day = j2;
        int i2 = this.oneHour;
        long j3 = (j - (i * j2)) / i2;
        this.hour = j3;
        int i3 = this.oneMin;
        long j4 = ((j - (i * j2)) - (i2 * j3)) / i3;
        this.min = j4;
        this.sec = (((j - (j2 * i)) - (j3 * i2)) - (j4 * i3)) % 60;
    }

    private void init(Context context) {
        this.mHandler = new Handler(Looper.getMainLooper());
        TextView textView = new TextView(context);
        this.mCountDownView = textView;
        textView.setGravity(17);
        this.mCountDownView.setIncludeFontPadding(false);
    }

    private void setCountTimeText() {
        String valueOf;
        String valueOf2;
        String valueOf3;
        if (TextUtils.isEmpty(this.dataFormat)) {
            return;
        }
        String str = new String(this.dataFormat);
        long j = this.day;
        String str2 = "00";
        if (j >= 0 && j < 10) {
            valueOf = "0" + this.day;
        } else {
            valueOf = j < 0 ? "00" : String.valueOf(j);
        }
        String replace = str.replace("dd", valueOf);
        long j2 = this.hour;
        if (j2 >= 0 && j2 < 10) {
            valueOf2 = "0" + this.hour;
        } else {
            valueOf2 = j2 < 0 ? "00" : String.valueOf(j2);
        }
        String replace2 = replace.replace("hh", valueOf2);
        long j3 = this.min;
        if (j3 >= 0 && j3 < 10) {
            valueOf3 = "0" + this.min;
        } else {
            valueOf3 = j3 < 0 ? "00" : String.valueOf(j3);
        }
        String replace3 = replace2.replace("mm", valueOf3);
        long j4 = this.sec;
        if (j4 >= 0 && j4 < 10) {
            str2 = "0" + this.sec;
        } else if (j4 >= 0) {
            str2 = String.valueOf(j4);
        }
        String replace4 = replace3.replace("ss", str2);
        SpannableString spannableString = new SpannableString(replace4);
        if (this.dayIndex > -1) {
            spannableString.setSpan(new ForegroundColorSpan(getTextColor()), 0, this.dayIndex, 34);
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(this.textSize, false);
            int i = this.dayIndex;
            spannableString.setSpan(absoluteSizeSpan, i, i + 2, 33);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getTimeColor());
            int i2 = this.dayIndex;
            spannableString.setSpan(foregroundColorSpan, i2, i2 + 2, 34);
            StyleSpan styleSpan = new StyleSpan(1);
            int i3 = this.dayIndex;
            spannableString.setSpan(styleSpan, i3, i3 + 2, 33);
            AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(this.timeSize, false);
            int i4 = this.dayIndex;
            spannableString.setSpan(absoluteSizeSpan2, i4, i4 + 2, 33);
            spannableString.setSpan(new ForegroundColorSpan(getTextColor()), this.dayIndex + 2, this.hourIndex, 34);
            spannableString.setSpan(new AbsoluteSizeSpan(this.textSize, false), this.dayIndex + 2, this.hourIndex, 33);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(getTextColor()), 0, this.hourIndex, 34);
            AbsoluteSizeSpan absoluteSizeSpan3 = new AbsoluteSizeSpan(this.textSize, false);
            int i5 = this.hourIndex;
            spannableString.setSpan(absoluteSizeSpan3, i5, i5 + 2, 33);
        }
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(getTimeColor());
        int i6 = this.hourIndex;
        spannableString.setSpan(foregroundColorSpan2, i6, i6 + 2, 34);
        StyleSpan styleSpan2 = new StyleSpan(1);
        int i7 = this.hourIndex;
        spannableString.setSpan(styleSpan2, i7, i7 + 2, 33);
        AbsoluteSizeSpan absoluteSizeSpan4 = new AbsoluteSizeSpan(this.timeSize);
        int i8 = this.hourIndex;
        spannableString.setSpan(absoluteSizeSpan4, i8, i8 + 2, 33);
        spannableString.setSpan(new ForegroundColorSpan(getTextColor()), this.hourIndex + 2, this.minIndex, 34);
        spannableString.setSpan(new AbsoluteSizeSpan(this.textSize, false), this.hourIndex + 2, this.minIndex, 33);
        ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(getTimeColor());
        int i9 = this.minIndex;
        spannableString.setSpan(foregroundColorSpan3, i9, i9 + 2, 34);
        StyleSpan styleSpan3 = new StyleSpan(1);
        int i10 = this.minIndex;
        spannableString.setSpan(styleSpan3, i10, i10 + 2, 33);
        AbsoluteSizeSpan absoluteSizeSpan5 = new AbsoluteSizeSpan(this.timeSize);
        int i11 = this.minIndex;
        spannableString.setSpan(absoluteSizeSpan5, i11, i11 + 2, 33);
        spannableString.setSpan(new ForegroundColorSpan(getTextColor()), this.minIndex + 2, this.secIndex, 34);
        spannableString.setSpan(new AbsoluteSizeSpan(this.textSize, false), this.minIndex + 2, this.secIndex, 33);
        ForegroundColorSpan foregroundColorSpan4 = new ForegroundColorSpan(getTimeColor());
        int i12 = this.secIndex;
        spannableString.setSpan(foregroundColorSpan4, i12, i12 + 2, 34);
        StyleSpan styleSpan4 = new StyleSpan(1);
        int i13 = this.secIndex;
        spannableString.setSpan(styleSpan4, i13, i13 + 2, 33);
        AbsoluteSizeSpan absoluteSizeSpan6 = new AbsoluteSizeSpan(this.timeSize, false);
        int i14 = this.secIndex;
        spannableString.setSpan(absoluteSizeSpan6, i14, i14 + 2, 33);
        spannableString.setSpan(new ForegroundColorSpan(getTextColor()), this.secIndex + 2, this.dataFormat.length(), 34);
        spannableString.setSpan(new AbsoluteSizeSpan(this.textSize, false), this.secIndex + 2, replace4.length(), 33);
        this.mCountDownView.setText(spannableString);
    }

    public void destroy() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler.removeCallbacks(null);
        }
    }

    public int getTextColor() {
        int color;
        if (TextUtils.isEmpty(this.textColor) || !this.textColor.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) || (color = WXResourceUtils.getColor(this.textColor)) == Integer.MIN_VALUE) {
            return 0;
        }
        return color;
    }

    public int getTimeColor() {
        int color;
        if (TextUtils.isEmpty(this.timeColor) || !this.timeColor.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) || (color = WXResourceUtils.getColor(this.timeColor)) == Integer.MIN_VALUE) {
            return 0;
        }
        return color;
    }

    public TextView getView() {
        return this.mCountDownView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.reset) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.reset = false;
            this.mHandler.post(this);
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.remainingTime--;
        if (!WXViewUtils.onScreenArea(this.mCountDownView)) {
            this.mHandler.postDelayed(this, 1000L);
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("countdown stop");
                return;
            }
            return;
        }
        computeTime();
        setCountTimeText();
        if (this.remainingTime < 0) {
            return;
        }
        this.mHandler.postDelayed(this, 1000L);
    }

    public void setCountDownTextColor(String str) {
        this.textColor = str;
    }

    public void setDateFormat(String str) {
        this.dataFormat = str;
        this.dayIndex = str.indexOf("dd");
        this.hourIndex = str.indexOf("hh");
        this.minIndex = str.indexOf("mm");
        this.secIndex = str.indexOf("ss");
    }

    public void setFontSize(int i, int i2) {
        this.textSize = i2;
    }

    public void setTime(String str) {
        this.reset = true;
        try {
            this.remainingTime = Long.parseLong(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void setTimeColor(String str) {
        this.timeColor = str;
    }

    public void setTimeFontSize(int i, int i2) {
        this.timeSize = i2;
    }

    public void start() {
        this.reset = false;
        run();
    }
}
