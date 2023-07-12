package tb;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.callback.SpanClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class g91 extends ClickableSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String a;
    private final SpanClickListener b;

    public g91(String str, SpanClickListener spanClickListener) {
        this.a = str;
        this.b = spanClickListener;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787657693")) {
            ipChange.ipc$dispatch("-1787657693", new Object[]{this, view});
        } else if (this.b == null || (str = this.a) == null || str.isEmpty()) {
        } else {
            this.b.onSpanClick(14, this.a);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-587237260")) {
            ipChange.ipc$dispatch("-587237260", new Object[]{this, textPaint});
            return;
        }
        textPaint.setColor(-12552000);
        textPaint.setUnderlineText(false);
    }
}
