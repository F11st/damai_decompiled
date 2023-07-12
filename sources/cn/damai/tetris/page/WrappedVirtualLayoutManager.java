package cn.damai.tetris.page;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.a;
import com.alibaba.android.vlayout.layout.c;
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
    public void setLayoutHelpers(@Nullable List<a> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1230156101")) {
            ipChange.ipc$dispatch("1230156101", new Object[]{this, list});
            return;
        }
        if (list != null) {
            c cVar = new c();
            cVar.setItemCount(2);
            list.add(0, cVar);
        }
        super.setLayoutHelpers(list);
    }
}
