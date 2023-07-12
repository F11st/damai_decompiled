package tb;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class gk extends CharacterStyle {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C9176a Companion = new C9176a(null);

    /* compiled from: Taobao */
    /* renamed from: tb.gk$a */
    /* loaded from: classes7.dex */
    public static final class C9176a {
        private C9176a() {
        }

        public /* synthetic */ C9176a(k50 k50Var) {
            this();
        }
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-619373731")) {
            ipChange.ipc$dispatch("-619373731", new Object[]{this, textPaint});
            return;
        }
        b41.i(textPaint, "tp");
        textPaint.bgColor = -921103;
        textPaint.setTextSize(textPaint.getTextSize() * 0.85f);
        textPaint.setTypeface(Typeface.MONOSPACE);
    }
}
