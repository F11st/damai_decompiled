package cn.damai.message.observer;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import cn.damai.message.data.DMEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class BaseObserver<T> implements Observer<DMEvent<T>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Action<T> mAction;
    private int mVersion;

    public BaseObserver(Action<T> action) {
        this.mAction = action;
    }

    public abstract boolean canOperateChange(DMEvent dMEvent, int i);

    public boolean isAttachedTo(Action action) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "871542384") ? ((Boolean) ipChange.ipc$dispatch("871542384", new Object[]{this, action})).booleanValue() : this.mAction == action;
    }

    @Override // androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(@Nullable Object obj) {
        onChanged((DMEvent) ((DMEvent) obj));
    }

    public void updateVersion(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "948050266")) {
            ipChange.ipc$dispatch("948050266", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mVersion = i;
        }
    }

    public void onChanged(@Nullable DMEvent<T> dMEvent) {
        Action<T> action;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-654566545")) {
            ipChange.ipc$dispatch("-654566545", new Object[]{this, dMEvent});
        } else if (!canOperateChange(dMEvent, this.mVersion) || dMEvent == null || (action = this.mAction) == null) {
        } else {
            this.mVersion = dMEvent.version;
            action.call(dMEvent.extra);
        }
    }
}
