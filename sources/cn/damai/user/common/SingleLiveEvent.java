package cn.damai.user.common;

import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SingleLiveEvent<T> extends MutableLiveData<T> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "SingleLiveEvent";
    private final AtomicBoolean mPending = new AtomicBoolean(false);

    @MainThread
    public void call() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "471843554")) {
            ipChange.ipc$dispatch("471843554", new Object[]{this});
        } else {
            setValue(null);
        }
    }

    @Override // androidx.lifecycle.LiveData
    @MainThread
    public void observe(LifecycleOwner lifecycleOwner, final Observer<? super T> observer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1660344193")) {
            ipChange.ipc$dispatch("1660344193", new Object[]{this, lifecycleOwner, observer});
            return;
        }
        if (hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(lifecycleOwner, new Observer<T>() { // from class: cn.damai.user.common.SingleLiveEvent.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable T t) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1181396156")) {
                    ipChange2.ipc$dispatch("-1181396156", new Object[]{this, t});
                } else if (SingleLiveEvent.this.mPending.compareAndSet(true, false)) {
                    observer.onChanged(t);
                }
            }
        });
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    @MainThread
    public void setValue(@Nullable T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1976990323")) {
            ipChange.ipc$dispatch("-1976990323", new Object[]{this, t});
            return;
        }
        this.mPending.set(true);
        super.setValue(t);
    }
}
