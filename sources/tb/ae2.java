package tb;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import cn.damai.baseview.abcpullrefresh.smoothprogressbar.ColorsShape;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ae2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Drawable a(int[] iArr, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1813032265")) {
            return (Drawable) ipChange.ipc$dispatch("1813032265", new Object[]{iArr, Float.valueOf(f)});
        }
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        return new ShapeDrawable(new ColorsShape(f, iArr));
    }
}
