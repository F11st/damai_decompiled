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
    private b mDelegate;

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
        b bVar = this.mDelegate;
        if (bVar != null) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(bVar.B(), 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(a.c(getContext(), 40.0f), 1073741824);
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
    public void setup(b bVar) {
        this.mDelegate = bVar;
        setTextSize(bVar.G());
        setTextColor(bVar.F());
        setBackgroundColor(bVar.A());
        setPadding(bVar.e(), 0, bVar.f(), 0);
    }
}
