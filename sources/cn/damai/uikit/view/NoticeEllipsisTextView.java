package cn.damai.uikit.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class NoticeEllipsisTextView extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int OFFSET_DP = 12;
    private int color;
    private StaticLayout mInnerLayout;
    private int mLastCharPadding;
    private String mLastDisplayText;
    private int mLastWidth;
    private StaticLayout mOverLinesLayout;
    private int spaceAdd;

    public NoticeEllipsisTextView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "884302886")) {
            ipChange.ipc$dispatch("884302886", new Object[]{this, context});
            return;
        }
        this.mLastCharPadding = l62.a(context, 12.0f);
        int a = l62.a(context, 6.0f);
        this.spaceAdd = a;
        setLineSpacing(a, 1.0f);
    }

    public int getColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2040163944") ? ((Integer) ipChange.ipc$dispatch("-2040163944", new Object[]{this})).intValue() : this.color;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-563946186")) {
            ipChange.ipc$dispatch("-563946186", new Object[]{this, canvas});
            return;
        }
        try {
            CharSequence text = getText();
            int lineCount = getLineCount();
            Layout layout = getLayout();
            int width = getWidth();
            if (!TextUtils.isEmpty(text) && lineCount > 0 && layout != null) {
                int i3 = lineCount - 1;
                if (layout.getEllipsisCount(i3) > 0) {
                    String charSequence = layout.getText().toString();
                    int indexOf = charSequence.indexOf("…");
                    if (indexOf >= 1) {
                        if (!TextUtils.isEmpty(String.valueOf(charSequence.charAt(indexOf - 1)).trim())) {
                            charSequence = charSequence.substring(0, i2) + "…";
                        }
                    }
                    if (this.mOverLinesLayout != null && this.mLastWidth == width && TextUtils.equals(this.mLastDisplayText, charSequence)) {
                        i = width;
                        this.mOverLinesLayout.draw(canvas);
                        this.mLastDisplayText = charSequence;
                    }
                    TextPaint paint = getPaint();
                    paint.setColor(this.color);
                    i = width;
                    this.mOverLinesLayout = new StaticLayout(charSequence, paint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, this.spaceAdd, true);
                    this.mOverLinesLayout.draw(canvas);
                    this.mLastDisplayText = charSequence;
                } else {
                    i = width;
                    if (layout.getLineWidth(i3) > ((i - getPaddingLeft()) - getPaddingRight()) - this.mLastCharPadding) {
                        String charSequence2 = getText().toString();
                        if (charSequence2.length() > 2) {
                            charSequence2 = charSequence2.substring(0, charSequence2.length() - 2) + "…";
                        }
                        if (this.mInnerLayout == null || this.mLastWidth != i || !TextUtils.equals(this.mLastDisplayText, charSequence2)) {
                            TextPaint paint2 = getPaint();
                            paint2.setColor(this.color);
                            this.mInnerLayout = new StaticLayout(charSequence2, paint2, i, Layout.Alignment.ALIGN_NORMAL, 1.0f, this.spaceAdd, true);
                        }
                        this.mInnerLayout.draw(canvas);
                        this.mLastDisplayText = charSequence2;
                    } else {
                        super.onDraw(canvas);
                    }
                }
                this.mLastWidth = i;
            }
            i = width;
            super.onDraw(canvas);
            this.mLastWidth = i;
        } catch (Exception e) {
            e.printStackTrace();
            super.onDraw(canvas);
        }
    }

    public void setColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1566517646")) {
            ipChange.ipc$dispatch("-1566517646", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.color = i;
        }
    }

    public NoticeEllipsisTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoticeEllipsisTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.color = -1;
        init(context);
    }
}
