package tb;

import cn.damai.tetris.v2.common.Addressable;
import cn.damai.tetris.v2.common.OnChildAttachStateChangeListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashSet;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ni<T extends Addressable> implements OnChildAttachStateChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    boolean a;

    public ni() {
        new HashSet();
        this.a = true;
    }

    public boolean a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1015594834") ? ((Boolean) ipChange.ipc$dispatch("-1015594834", new Object[]{this})).booleanValue() : this.a;
    }

    public void b(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "565637282")) {
            ipChange.ipc$dispatch("565637282", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.a = z;
        }
    }

    public void c(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1409192394")) {
            ipChange.ipc$dispatch("-1409192394", new Object[]{this, list});
        } else if (this.a && list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                T t = list.get(i);
                if (t != null) {
                    t.setIndex(i);
                }
            }
            this.a = false;
        }
    }

    @Override // cn.damai.tetris.v2.common.OnChildAttachStateChangeListener
    public void onChildAdded(Addressable addressable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-793864962")) {
            ipChange.ipc$dispatch("-793864962", new Object[]{this, addressable});
        } else {
            this.a = true;
        }
    }

    @Override // cn.damai.tetris.v2.common.OnChildAttachStateChangeListener
    public void onChildRemoved(Addressable addressable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "902612830")) {
            ipChange.ipc$dispatch("902612830", new Object[]{this, addressable});
        } else {
            this.a = true;
        }
    }
}
