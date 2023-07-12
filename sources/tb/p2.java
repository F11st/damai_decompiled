package tb;

import android.database.DataSetObserver;
import cn.damai.uikit.wheel.adapters.WheelViewAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class p2 implements WheelViewAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DataSetObserver> a;

    @Override // cn.damai.uikit.wheel.adapters.WheelViewAdapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1397380314")) {
            ipChange.ipc$dispatch("1397380314", new Object[]{this, dataSetObserver});
            return;
        }
        if (this.a == null) {
            this.a = new LinkedList();
        }
        this.a.add(dataSetObserver);
    }

    @Override // cn.damai.uikit.wheel.adapters.WheelViewAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-780542669")) {
            ipChange.ipc$dispatch("-780542669", new Object[]{this, dataSetObserver});
            return;
        }
        List<DataSetObserver> list = this.a;
        if (list != null) {
            list.remove(dataSetObserver);
        }
    }
}
