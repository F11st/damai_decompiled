package com.taobao.android.dinamic.constructor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.property.DAttrConstant;
import com.taobao.android.dinamic.view.DCountDownTimerView;
import java.util.ArrayList;
import java.util.Map;
import tb.oq;
import tb.p62;
import tb.v80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DCountDownTimerConstructor extends DinamicViewAdvancedConstructor {
    public static final int DEFAULT_TEXT_COLOR = -16777216;
    public static final String TAG = "DCountDownTimerConstructor";
    private final int MARGIN_LEFT = 0;
    private final int MARGIN_TOP = 1;
    private final int MARGIN_RIGHT = 2;
    private final int MARGIN_BOTTOM = 3;
    private final int TEXT_SIZE = 6;
    private final int TEXT_COLOR = 7;
    private final int[] seeMoreTextDefaults = {0, 0, 0, 0, -1, -1, 12, -16777216};
    private final int[] timerTextDefaults = {0, 0, 0, 0, 20, 20, 12, -1};
    private final int[] colonTextDefaults = {0, 0, 0, 0, -1, -1, 10, -16777216};

    private int[] getTextViewMargin(Context context, String str, String str2, String str3, String str4, int[] iArr) {
        int b = p62.b(context, str, iArr[0]);
        int b2 = p62.b(context, str2, iArr[1]);
        int b3 = p62.b(context, str3, iArr[2]);
        int b4 = p62.b(context, str4, iArr[3]);
        if (b == iArr[0] && b2 == iArr[1] && b3 == iArr[2] && b4 == iArr[3]) {
            return null;
        }
        return new int[]{b, b2, b3, b4};
    }

    private void setTextViewMarginAndColorAndSize(TextView textView, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        marginLayoutParams.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        textView.setLayoutParams(marginLayoutParams);
        textView.setTextColor(iArr[7]);
        textView.setTextSize(1, iArr[6]);
    }

    private void setTextViewStyle(TextView textView, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int[] iArr) {
        int d;
        if (!TextUtils.isEmpty(str7)) {
            textView.setTextSize(0, p62.b(textView.getContext(), str7, 0));
        }
        if (!TextUtils.isEmpty(str8) && (d = oq.d(str8, -16777216)) != -16777216) {
            textView.setTextColor(d);
        }
        int[] textViewMargin = getTextViewMargin(textView.getContext(), str, str2, str3, str4, iArr);
        if (textViewMargin == null && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str6)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        if (!TextUtils.isEmpty(str5)) {
            marginLayoutParams.width = p62.b(textView.getContext(), str5, 0);
        }
        if (!TextUtils.isEmpty(str6)) {
            marginLayoutParams.height = p62.b(textView.getContext(), str6, 0);
        }
        if (textViewMargin != null) {
            marginLayoutParams.setMargins(textViewMargin[0], textViewMargin[1], textViewMargin[2], textViewMargin[3]);
        }
        textView.setLayoutParams(marginLayoutParams);
    }

    private void setTimerTextBackground(TextView textView, TextView textView2, TextView textView3, String str, String str2) {
        int d = !TextUtils.isEmpty(str) ? oq.d(str, -16777216) : -16777216;
        int b = p62.b(textView.getContext(), str2, 0);
        if (d == -16777216 && b == 0) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(b);
        gradientDrawable.setColor(d);
        textView.setBackgroundDrawable(gradientDrawable);
        textView2.setBackgroundDrawable(gradientDrawable);
        textView3.setBackgroundDrawable(gradientDrawable);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void applyDefaultProperty(View view, Map<String, Object> map, v80 v80Var) {
        super.applyDefaultProperty(view, map, v80Var);
        DCountDownTimerView dCountDownTimerView = (DCountDownTimerView) view;
        TextView seeMoreView = dCountDownTimerView.getSeeMoreView();
        TextView hour = dCountDownTimerView.getHour();
        TextView minute = dCountDownTimerView.getMinute();
        TextView second = dCountDownTimerView.getSecond();
        TextView colonFirst = dCountDownTimerView.getColonFirst();
        TextView colonSecond = dCountDownTimerView.getColonSecond();
        setTextViewMarginAndColorAndSize(seeMoreView, this.seeMoreTextDefaults);
        seeMoreView.setText("");
        setTextViewMarginAndColorAndSize(hour, this.timerTextDefaults);
        setTextViewMarginAndColorAndSize(minute, this.timerTextDefaults);
        setTextViewMarginAndColorAndSize(second, this.timerTextDefaults);
        hour.setPadding(0, 0, 0, 0);
        minute.setPadding(0, 0, 0, 0);
        second.setPadding(0, 0, 0, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(0.0f);
        gradientDrawable.setColor(-16777216);
        hour.setBackgroundDrawable(gradientDrawable);
        minute.setBackgroundDrawable(gradientDrawable);
        second.setBackgroundDrawable(gradientDrawable);
        setTextViewMarginAndColorAndSize(colonFirst, this.colonTextDefaults);
        setTextViewMarginAndColorAndSize(colonSecond, this.colonTextDefaults);
        colonFirst.setText(":");
        colonSecond.setText(":");
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        return new DCountDownTimerView(context, attributeSet);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, v80 v80Var) {
        super.setAttributes(view, map, arrayList, v80Var);
        DCountDownTimerView dCountDownTimerView = (DCountDownTimerView) view;
        if (arrayList.contains(DAttrConstant.CV_TIMER_TEXT_MARGIN_LEFT) || arrayList.contains(DAttrConstant.CV_TIMER_TEXT_MARGIN_TOP) || arrayList.contains(DAttrConstant.CV_TIMER_TEXT_MARGIN_RIGHT) || arrayList.contains(DAttrConstant.CV_TIMER_TEXT_MARGIN_BOTTOM) || arrayList.contains(DAttrConstant.CV_TIMER_TEXT_WIDTH) || arrayList.contains(DAttrConstant.CV_TIMER_TEXT_HEIGHT) || arrayList.contains(DAttrConstant.CV_TIMER_TEXT_SIZE) || arrayList.contains(DAttrConstant.CV_TIMER_TEXT_COLOR) || arrayList.contains(DAttrConstant.CV_TIMER_BACKGROUND_COLOR) || arrayList.contains(DAttrConstant.CV_TIMER_CORNER_RADIUS)) {
            setTimerTextViewStyle(dCountDownTimerView, (String) map.get(DAttrConstant.CV_TIMER_TEXT_MARGIN_LEFT), (String) map.get(DAttrConstant.CV_TIMER_TEXT_MARGIN_TOP), (String) map.get(DAttrConstant.CV_TIMER_TEXT_MARGIN_RIGHT), (String) map.get(DAttrConstant.CV_TIMER_TEXT_MARGIN_BOTTOM), (String) map.get(DAttrConstant.CV_TIMER_TEXT_WIDTH), (String) map.get(DAttrConstant.CV_TIMER_TEXT_HEIGHT), (String) map.get(DAttrConstant.CV_TIMER_TEXT_SIZE), (String) map.get(DAttrConstant.CV_TIMER_TEXT_COLOR), (String) map.get(DAttrConstant.CV_TIMER_BACKGROUND_COLOR), (String) map.get(DAttrConstant.CV_TIMER_CORNER_RADIUS));
        }
        if (arrayList.contains(DAttrConstant.CV_COLON_TEXT_MARGIN_LEFT) || arrayList.contains(DAttrConstant.CV_COLON_TEXT_MARGIN_TOP) || arrayList.contains(DAttrConstant.CV_COLON_TEXT_MARGIN_RIGHT) || arrayList.contains(DAttrConstant.CV_COLON_TEXT_MARGIN_BOTTOM) || arrayList.contains(DAttrConstant.CV_COLON_TEXT_WIDTH) || arrayList.contains(DAttrConstant.CV_COLON_TEXT_HEIGHT) || arrayList.contains(DAttrConstant.CV_COLON_TEXT_SIZE) || arrayList.contains(DAttrConstant.CV_COLON_TEXT_COLOR) || arrayList.contains(DAttrConstant.CV_COLON_TEXT)) {
            setColonTextViewStyle(dCountDownTimerView, (String) map.get(DAttrConstant.CV_COLON_TEXT_MARGIN_LEFT), (String) map.get(DAttrConstant.CV_COLON_TEXT_MARGIN_TOP), (String) map.get(DAttrConstant.CV_COLON_TEXT_MARGIN_RIGHT), (String) map.get(DAttrConstant.CV_COLON_TEXT_MARGIN_BOTTOM), (String) map.get(DAttrConstant.CV_COLON_TEXT_WIDTH), (String) map.get(DAttrConstant.CV_COLON_TEXT_HEIGHT), (String) map.get(DAttrConstant.CV_COLON_TEXT_SIZE), (String) map.get(DAttrConstant.CV_COLON_TEXT_COLOR), (String) map.get(DAttrConstant.CV_COLON_TEXT));
        }
        if (arrayList.contains(DAttrConstant.CV_FUTURE_TIME) || arrayList.contains(DAttrConstant.CV_CURRENT_TIME)) {
            setFutureTime(dCountDownTimerView, (String) map.get(DAttrConstant.CV_FUTURE_TIME), (String) map.get(DAttrConstant.CV_CURRENT_TIME));
        }
        if (arrayList.contains(DAttrConstant.CV_SEE_MORE_TEXT) || arrayList.contains(DAttrConstant.CV_SEE_MORE_TEXT_MARGIN_LEFT) || arrayList.contains(DAttrConstant.CV_SEE_MORE_TEXT_MARGIN_TOP) || arrayList.contains(DAttrConstant.CV_SEE_MORE_TEXT_MARGIN_RIGHT) || arrayList.contains(DAttrConstant.CV_SEE_MORE_TEXT_MARGIN_BOTTOM) || arrayList.contains(DAttrConstant.CV_SEE_MORE_TEXT_WIDTH) || arrayList.contains(DAttrConstant.CV_SEE_MORE_TEXT_HEIGHT) || arrayList.contains(DAttrConstant.CV_SEE_MORE_TEXT_SIZE) || arrayList.contains(DAttrConstant.CV_SEE_MORE_TEXT_COLOR)) {
            setSeeMoreTextViewStyle(dCountDownTimerView, (String) map.get(DAttrConstant.CV_SEE_MORE_TEXT), (String) map.get(DAttrConstant.CV_SEE_MORE_TEXT_MARGIN_LEFT), (String) map.get(DAttrConstant.CV_SEE_MORE_TEXT_MARGIN_TOP), (String) map.get(DAttrConstant.CV_SEE_MORE_TEXT_MARGIN_RIGHT), (String) map.get(DAttrConstant.CV_SEE_MORE_TEXT_MARGIN_BOTTOM), (String) map.get(DAttrConstant.CV_SEE_MORE_TEXT_WIDTH), (String) map.get(DAttrConstant.CV_SEE_MORE_TEXT_HEIGHT), (String) map.get(DAttrConstant.CV_SEE_MORE_TEXT_SIZE), (String) map.get(DAttrConstant.CV_SEE_MORE_TEXT_COLOR));
        }
    }

    public void setColonTextViewStyle(DCountDownTimerView dCountDownTimerView, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        TextView colonFirst = dCountDownTimerView.getColonFirst();
        TextView colonSecond = dCountDownTimerView.getColonSecond();
        setTextViewStyle(colonFirst, str, str2, str3, str4, str5, str6, str7, str8, this.colonTextDefaults);
        setTextViewStyle(colonSecond, str, str2, str3, str4, str5, str6, str7, str8, this.colonTextDefaults);
        if (TextUtils.isEmpty(str9)) {
            return;
        }
        colonFirst.setText(str9);
        colonSecond.setText(str9);
    }

    public void setFutureTime(DCountDownTimerView dCountDownTimerView, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            dCountDownTimerView.hideCountDown();
            dCountDownTimerView.setFutureTime(-1L);
            dCountDownTimerView.getTimer().stop();
            return;
        }
        dCountDownTimerView.setFutureTime(Long.valueOf(str).longValue());
        if (!TextUtils.isEmpty(str2)) {
            dCountDownTimerView.setCurrentTime(Long.valueOf(str2).longValue());
        }
        if (dCountDownTimerView.getLastTime() > 0) {
            dCountDownTimerView.showCountDown();
            dCountDownTimerView.updateCountDownViewTime();
            dCountDownTimerView.getTimer().start();
            return;
        }
        dCountDownTimerView.hideCountDown();
        dCountDownTimerView.getTimer().stop();
    }

    public void setSeeMoreTextViewStyle(DCountDownTimerView dCountDownTimerView, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        TextView seeMoreView = dCountDownTimerView.getSeeMoreView();
        seeMoreView.setText(str);
        setTextViewStyle(seeMoreView, str2, str3, str4, str5, str6, str7, str8, str9, this.seeMoreTextDefaults);
    }

    public void setTimerTextViewStyle(DCountDownTimerView dCountDownTimerView, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        TextView hour = dCountDownTimerView.getHour();
        TextView minute = dCountDownTimerView.getMinute();
        TextView second = dCountDownTimerView.getSecond();
        setTextViewStyle(hour, str, str2, str3, str4, str5, str6, str7, str8, this.timerTextDefaults);
        setTextViewStyle(minute, str, str2, str3, str4, str5, str6, str7, str8, this.timerTextDefaults);
        setTextViewStyle(second, str, str2, str3, str4, str5, str6, str7, str8, this.timerTextDefaults);
        setTimerTextBackground(hour, minute, second, str9, str10);
    }
}
