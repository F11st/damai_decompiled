package tb;

import android.view.View;
import android.widget.ScrollView;
import cn.damai.baseview.abcpullrefresh.library.viewdelegates.ViewDelegate;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class n72 implements ViewDelegate {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Class[] SUPPORTED_VIEW_CLASSES = {ScrollView.class};

    @Override // cn.damai.baseview.abcpullrefresh.library.viewdelegates.ViewDelegate
    public boolean isReadyForPull(View view, float f, float f2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "243091548") ? ((Boolean) ipChange.ipc$dispatch("243091548", new Object[]{this, view, Float.valueOf(f), Float.valueOf(f2)})).booleanValue() : view.getScrollY() <= 0;
    }
}
