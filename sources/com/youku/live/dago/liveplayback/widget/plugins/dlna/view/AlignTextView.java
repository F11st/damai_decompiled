package com.youku.live.dago.liveplayback.widget.plugins.dlna.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AlignTextView extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean alignOnlyOneLine;

    public AlignTextView(Context context) {
        this(context, null);
    }

    private void drawScaledText(Canvas canvas, String str, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "352444073")) {
            ipChange.ipc$dispatch("352444073", new Object[]{this, canvas, str, Float.valueOf(f), Float.valueOf(f2)});
        } else if (str.length() >= 1) {
            float paddingLeft = getPaddingLeft();
            boolean z = str.charAt(str.length() - 1) == '\n';
            int length = str.length() - 1;
            if (!z && length != 0) {
                float measuredWidth = (((getMeasuredWidth() - f2) - getPaddingLeft()) - getPaddingRight()) / length;
                for (int i = 0; i < str.length(); i++) {
                    String valueOf = String.valueOf(str.charAt(i));
                    float desiredWidth = StaticLayout.getDesiredWidth(valueOf, getPaint());
                    canvas.drawText(valueOf, paddingLeft, f, getPaint());
                    paddingLeft += desiredWidth + measuredWidth;
                }
                return;
            }
            canvas.drawText(str, paddingLeft, f, getPaint());
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "475294951")) {
            ipChange.ipc$dispatch("475294951", new Object[]{this, context, attributeSet});
        } else {
            this.alignOnlyOneLine = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "868856727")) {
            ipChange.ipc$dispatch("868856727", new Object[]{this, canvas});
            return;
        }
        CharSequence text = getText();
        if (!(text instanceof String)) {
            super.onDraw(canvas);
            return;
        }
        String str = (String) text;
        Layout layout = getLayout();
        for (int i = 0; i < layout.getLineCount(); i++) {
            int lineBaseline = layout.getLineBaseline(i) + getPaddingTop();
            int lineStart = layout.getLineStart(i);
            int lineEnd = layout.getLineEnd(i);
            if (this.alignOnlyOneLine && layout.getLineCount() == 1) {
                drawScaledText(canvas, str.substring(lineStart, lineEnd), lineBaseline, StaticLayout.getDesiredWidth(str, lineStart, lineEnd, getPaint()));
            } else if (i == layout.getLineCount() - 1) {
                canvas.drawText(str.substring(lineStart), getPaddingLeft(), lineBaseline, getPaint());
                return;
            } else {
                drawScaledText(canvas, str.substring(lineStart, lineEnd), lineBaseline, StaticLayout.getDesiredWidth(str, lineStart, lineEnd, getPaint()));
            }
        }
    }

    public AlignTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlignTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
