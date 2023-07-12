package cn.damai.tetris.page;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.AbstractC3289a;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.C3302c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class WrappedVirtualLayoutManager2 extends VirtualLayoutManager {
    private static transient /* synthetic */ IpChange $ipChange;

    public WrappedVirtualLayoutManager2(@NonNull Context context) {
        super(context);
    }

    @Override // com.alibaba.android.vlayout.VirtualLayoutManager
    @NonNull
    public List<AbstractC3289a> getLayoutHelpers() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-328556715")) {
            return (List) ipChange.ipc$dispatch("-328556715", new Object[]{this});
        }
        List<AbstractC3289a> layoutHelpers = super.getLayoutHelpers();
        if (layoutHelpers == null || layoutHelpers.size() <= 0) {
            return layoutHelpers;
        }
        ArrayList arrayList = new ArrayList(layoutHelpers);
        arrayList.remove(0);
        return arrayList;
    }

    @Override // com.alibaba.android.vlayout.VirtualLayoutManager
    public void setLayoutHelpers(@Nullable List<AbstractC3289a> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1305239215")) {
            ipChange.ipc$dispatch("1305239215", new Object[]{this, list});
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
