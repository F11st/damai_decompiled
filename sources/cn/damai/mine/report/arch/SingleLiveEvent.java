package cn.damai.mine.report.arch;

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
/* loaded from: classes6.dex */
public class SingleLiveEvent<T> extends MutableLiveData<T> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "SingleLiveEvent";
    private final AtomicBoolean mPending = new AtomicBoolean(false);

    @MainThread
    public void call() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469405382")) {
            ipChange.ipc$dispatch("1469405382", new Object[]{this});
        } else {
            setValue(null);
        }
    }

    @Override // androidx.lifecycle.LiveData
    @MainThread
    public void observe(LifecycleOwner lifecycleOwner, final Observer<? super T> observer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-180754659")) {
            ipChange.ipc$dispatch("-180754659", new Object[]{this, lifecycleOwner, observer});
            return;
        }
        if (hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(lifecycleOwner, new Observer<T>() { // from class: cn.damai.mine.report.arch.SingleLiveEvent.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable T t) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-22059552")) {
                    ipChange2.ipc$dispatch("-22059552", new Object[]{this, t});
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
        if (AndroidInstantRuntime.support(ipChange, "-2109876111")) {
            ipChange.ipc$dispatch("-2109876111", new Object[]{this, t});
            return;
        }
        this.mPending.set(true);
        super.setValue(t);
    }
}
