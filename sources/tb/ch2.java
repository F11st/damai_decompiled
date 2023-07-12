package tb;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ch2 extends CharacterStyle {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "929807228")) {
            ipChange.ipc$dispatch("929807228", new Object[]{this, textPaint});
        } else {
            textPaint.setStrikeThruText(true);
        }
    }
}
