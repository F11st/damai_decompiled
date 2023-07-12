package cn.damai.message.observer;

import cn.damai.message.data.DMEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class DefaultObserver<T> extends BaseObserver<T> {
    private static transient /* synthetic */ IpChange $ipChange;

    public DefaultObserver(Action<T> action) {
        super(action);
    }

    @Override // cn.damai.message.observer.BaseObserver
    public boolean canOperateChange(DMEvent dMEvent, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-551341617") ? ((Boolean) ipChange.ipc$dispatch("-551341617", new Object[]{this, dMEvent, Integer.valueOf(i)})).booleanValue() : dMEvent.version > i;
    }
}
