package cn.damai.net;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MixTextView extends TextView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Paint paint1;

    public MixTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.paint1 = paint;
        paint.setTextSize(super.getTextSize());
        this.paint1.setColor(super.getTextColors().getColorForState(getDrawableState(), 0));
        this.paint1.setAntiAlias(true);
    }

    private ArrayList<String> autoSplit(String str, Paint paint, float f) {
        IpChange ipChange = $ipChange;
        int i = 0;
        int i2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "481111346")) {
            return (ArrayList) ipChange.ipc$dispatch("481111346", new Object[]{this, str, paint, Float.valueOf(f)});
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (paint.measureText(str) < f) {
            arrayList.add(str);
            return arrayList;
        }
        int length = str.length();
        while (true) {
            if (i >= length) {
                break;
            }
            int i3 = i2 + 1;
            if (paint.measureText(str, i, i3 > length ? length : i3) >= f && paint.measureText(str, i, i2) <= f) {
                arrayList.add((String) str.subSequence(i, i2));
                i = i2;
            }
            if (i2 == length) {
                arrayList.add((String) str.subSequence(i, i2));
                break;
            }
            if (str.charAt(i2) == '\n') {
                arrayList.add((String) str.subSequence(i, i2));
                i = i3;
            }
            i2 = i3;
        }
        return arrayList;
    }

    private int getFormatGravity(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1638361889") ? ((Integer) ipChange.ipc$dispatch("1638361889", new Object[]{this, Integer.valueOf(i)})).intValue() : (i & 112) == 0 ? i | 48 : i;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1485708942")) {
            ipChange.ipc$dispatch("-1485708942", new Object[]{this, canvas});
            return;
        }
        Paint.FontMetrics fontMetrics = this.paint1.getFontMetrics();
        float f = fontMetrics.descent - fontMetrics.ascent;
        float paddingLeft = getPaddingLeft();
        float width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        ArrayList<String> autoSplit = autoSplit(super.getText().toString(), this.paint1, width);
        float f2 = f;
        for (int i = 0; i < autoSplit.size(); i++) {
            String str = autoSplit.get(i);
            if (str != null) {
                if (getGravity() == getFormatGravity(17)) {
                    canvas.drawText(str, ((width - this.paint1.measureText(str, 0, str.length())) / 2.0f) + paddingLeft, f2, this.paint1);
                } else if (getGravity() == getFormatGravity(5)) {
                    canvas.drawText(str, (paddingLeft + width) - this.paint1.measureText(str, 0, str.length()), f2, this.paint1);
                } else {
                    canvas.drawText(str, paddingLeft, f2, this.paint1);
                }
                if (i != autoSplit.size() - 1) {
                    f2 += fontMetrics.leading + f;
                }
            }
        }
    }
}
