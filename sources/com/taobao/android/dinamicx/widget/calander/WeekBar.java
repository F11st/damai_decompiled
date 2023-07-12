package com.taobao.android.dinamicx.widget.calander;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.taobao.android.dinamic.R$array;
import com.taobao.android.dinamic.R$layout;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WeekBar extends LinearLayout {
    private C6488b mDelegate;

    public WeekBar(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R$layout.datepicker_week_bar, (ViewGroup) this, true);
    }

    private String getWeekString(int i, int i2) {
        String[] stringArray = getContext().getResources().getStringArray(R$array.week_string_array);
        if (i2 == 1) {
            return stringArray[i];
        }
        if (i2 == 2) {
            return stringArray[i == 6 ? 0 : i + 1];
        }
        return stringArray[i != 0 ? i - 1 : 6];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDateSelected(@Nullable Calendar calendar, int i, boolean z) {
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        C6488b c6488b = this.mDelegate;
        if (c6488b != null) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(c6488b.B(), 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(C6487a.c(getContext(), 40.0f), 1073741824);
        }
        super.onMeasure(i, makeMeasureSpec);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onWeekStartChange(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ((TextView) getChildAt(i2)).setText(getWeekString(i2, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextColor(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ((TextView) getChildAt(i2)).setTextColor(i);
        }
    }

    protected void setTextSize(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ((TextView) getChildAt(i2)).setTextSize(0, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setup(C6488b c6488b) {
        this.mDelegate = c6488b;
        setTextSize(c6488b.G());
        setTextColor(c6488b.F());
        setBackgroundColor(c6488b.A());
        setPadding(c6488b.e(), 0, c6488b.f(), 0);
    }
}
