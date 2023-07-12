package cn.damai.tetris.page;

import androidx.annotation.NonNull;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class WrappedDelegateAdapter extends DelegateAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean a;

    public WrappedDelegateAdapter(VirtualLayoutManager virtualLayoutManager, boolean z) {
        super(virtualLayoutManager, z);
        this.a = virtualLayoutManager instanceof WrappedVirtualLayoutManager;
    }

    @Override // com.alibaba.android.vlayout.VirtualLayoutAdapter
    @NonNull
    public List<a> getLayoutHelpers() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1292890021")) {
            return (List) ipChange.ipc$dispatch("1292890021", new Object[]{this});
        }
        List<a> layoutHelpers = super.getLayoutHelpers();
        if (!this.a || layoutHelpers == null || layoutHelpers.size() <= 0) {
            return layoutHelpers;
        }
        ArrayList arrayList = new ArrayList(layoutHelpers);
        arrayList.remove(0);
        return arrayList;
    }
}
