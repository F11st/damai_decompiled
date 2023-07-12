package tb;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class rj extends ClickableSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context a;
    @Nullable
    private View.OnClickListener b;
    private final int c;

    @JvmOverloads
    public rj(@NotNull Context context, @Nullable View.OnClickListener onClickListener, int i) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
        this.b = onClickListener;
        this.c = i;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1140824532")) {
            ipChange.ipc$dispatch("-1140824532", new Object[]{this, view});
            return;
        }
        b41.i(view, "widget");
        View.OnClickListener onClickListener = this.b;
        if (onClickListener != null) {
            b41.f(onClickListener);
            onClickListener.onClick(view);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-68146421")) {
            ipChange.ipc$dispatch("-68146421", new Object[]{this, textPaint});
            return;
        }
        b41.i(textPaint, "ds");
        textPaint.setColor(this.a.getResources().getColor(this.c));
        textPaint.setUnderlineText(false);
    }
}
