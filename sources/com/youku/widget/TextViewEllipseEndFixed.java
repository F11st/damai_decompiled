package com.youku.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TextViewEllipseEndFixed extends TextView {
    private static final String ELLIPSE_END = "...";
    private static final boolean HAS_BUG;
    private boolean mChecked;
    private int mELLIPSEWidth;
    private int mMaxLines;
    private CharSequence mOriText;
    private boolean mSingleLine;

    static {
        HAS_BUG = Integer.parseInt(Build.VERSION.SDK) < 14;
    }

    public TextViewEllipseEndFixed(Context context) {
        super(context);
        this.mChecked = !HAS_BUG;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        CharSequence charSequence = this.mOriText;
        return charSequence != null ? charSequence : super.getText();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (HAS_BUG && !this.mChecked) {
            this.mChecked = true;
            Layout layout = super.getLayout();
            int i = this.mMaxLines;
            if (i <= 0) {
                i = 1;
            }
            if (layout.getLineCount() > i) {
                if (this.mELLIPSEWidth == 0) {
                    this.mELLIPSEWidth = (int) getPaint().measureText(ELLIPSE_END);
                }
                this.mOriText = super.getText();
                int width = layout.getWidth();
                int i2 = i - 1;
                int lineWidth = (int) layout.getLineWidth(i2);
                int lineEnd = layout.getLineEnd(i2);
                int i3 = this.mELLIPSEWidth;
                if (i3 + lineWidth > width) {
                    float f = (i3 + lineWidth) - width;
                    int textSize = (int) (f / super.getTextSize());
                    if (f % super.getTextSize() != 0.0f) {
                        textSize++;
                    }
                    lineEnd -= textSize;
                }
                super.setText(((Object) this.mOriText.subSequence(0, lineEnd)) + ELLIPSE_END);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mChecked = !HAS_BUG;
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.mChecked = !HAS_BUG;
        super.onTextChanged(charSequence, i, i2, i3);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        boolean z = HAS_BUG;
        if (z && truncateAt.equals(TextUtils.TruncateAt.END)) {
            this.mChecked = !z;
            if (this.mSingleLine) {
                setSingleLine(false);
                return;
            }
            return;
        }
        super.setEllipsize(truncateAt);
        this.mChecked = true;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.mChecked = !HAS_BUG;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        this.mMaxLines = i;
        boolean z = true;
        if (i > 1 && HAS_BUG) {
            z = false;
        }
        this.mChecked = z;
        super.setMaxLines(i);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.mChecked = false;
        super.setPadding(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        this.mSingleLine = z;
        super.setSingleLine(z);
    }

    public TextViewEllipseEndFixed(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChecked = !HAS_BUG;
    }

    public TextViewEllipseEndFixed(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChecked = !HAS_BUG;
    }
}
