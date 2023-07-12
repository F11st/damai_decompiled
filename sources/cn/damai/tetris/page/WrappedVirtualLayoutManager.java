package cn.damai.tetris.page;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.AbstractC3289a;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.C3302c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class WrappedVirtualLayoutManager extends VirtualLayoutManager {
    private static transient /* synthetic */ IpChange $ipChange;

    public WrappedVirtualLayoutManager(@NonNull Context context) {
        super(context);
    }

    @Override // com.alibaba.android.vlayout.VirtualLayoutManager
    public void setLayoutHelpers(@Nullable List<AbstractC3289a> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1230156101")) {
            ipChange.ipc$dispatch("1230156101", new Object[]{this, list});
            return;
        }
        if (list != null) {
            C3302c c3302c = new C3302c();
            c3302c.setItemCount(2);
            list.add(0, c3302c);
        }
        super.setLayoutHelpers(list);
    }
}
