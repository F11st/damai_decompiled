package tb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.view.state.AbstractC2617a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class tr1 extends AbstractC2617a {
    private static transient /* synthetic */ IpChange $ipChange;

    public tr1(Context context) {
        super(context, R$drawable.state_color_shape_4);
    }

    @Override // cn.damai.uikit.view.state.AbstractC2617a
    public void b(@NonNull Drawable drawable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1852476883")) {
            ipChange.ipc$dispatch("-1852476883", new Object[]{this, drawable, Integer.valueOf(i)});
        } else {
            a(drawable, (int) ((i > 50 ? 1.0f - (((i - 50) * 1.0f) / 50.0f) : (i * 1.0f) / 50.0f) * 255.0f));
        }
    }
}
