package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class StrokeTextView extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView borderText;

    public StrokeTextView(Context context) {
        super(context);
        this.borderText = null;
        this.borderText = new TextView(context);
        init();
    }

    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471185680")) {
            ipChange.ipc$dispatch("-471185680", new Object[]{this});
            return;
        }
        TextPaint paint = this.borderText.getPaint();
        paint.setStrokeWidth(DensityUtil.dip2px(getContext(), 3.0f));
        paint.setStyle(Paint.Style.STROKE);
        this.borderText.setTextColor(Color.parseColor("#FFB800"));
        this.borderText.setGravity(getGravity());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2021754728")) {
            ipChange.ipc$dispatch("2021754728", new Object[]{this, canvas});
            return;
        }
        this.borderText.draw(canvas);
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "992883197")) {
            ipChange.ipc$dispatch("992883197", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int i5 = i3 + 20;
        super.onLayout(z, i, i2, i5, i4);
        this.borderText.layout(i, i2, i5, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2110802293")) {
            ipChange.ipc$dispatch("-2110802293", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        CharSequence text = this.borderText.getText();
        if (text == null || !text.equals(getText())) {
            this.borderText.setText(getText());
            postInvalidate();
        }
        super.onMeasure(i, i2);
        this.borderText.measure(i, i2);
    }

    public void setBorderTextColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1635627746")) {
            ipChange.ipc$dispatch("1635627746", new Object[]{this, str});
        } else {
            this.borderText.setTextColor(Color.parseColor(str));
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1744612955")) {
            ipChange.ipc$dispatch("-1744612955", new Object[]{this, layoutParams});
            return;
        }
        super.setLayoutParams(layoutParams);
        this.borderText.setLayoutParams(layoutParams);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-496449459")) {
            ipChange.ipc$dispatch("-496449459", new Object[]{this, charSequence, bufferType});
            return;
        }
        if (charSequence != null) {
            str = charSequence.toString() + " ";
        } else {
            str = "";
        }
        super.setText(str, bufferType);
    }

    public StrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.borderText = null;
        this.borderText = new TextView(context, attributeSet);
        init();
    }

    public StrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.borderText = null;
        this.borderText = new TextView(context, attributeSet, i);
        init();
    }
}
