package cn.damai.message.subscribe;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import cn.damai.message.data.DMEvent;
import cn.damai.message.observer.Action;
import cn.damai.message.observer.BaseObserver;
import cn.damai.message.observer.DefaultObserver;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class EventCenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a = -1;
    private Handler d = new Handler(Looper.getMainLooper());
    private MutableLiveData<DMEvent> c = new MutableLiveData<>();
    private List<BaseObserver> b = new ArrayList();

    private boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "32405683") ? ((Boolean) ipChange.ipc$dispatch("32405683", new Object[]{this})).booleanValue() : Looper.myLooper() == Looper.getMainLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(@NonNull BaseObserver baseObserver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1989807353")) {
            ipChange.ipc$dispatch("-1989807353", new Object[]{this, baseObserver});
        } else {
            this.c.observeForever(baseObserver);
        }
    }

    private void i(@NonNull final BaseObserver baseObserver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1818809577")) {
            ipChange.ipc$dispatch("-1818809577", new Object[]{this, baseObserver});
        } else if (e()) {
            this.c.removeObserver(baseObserver);
        } else {
            this.d.post(new Runnable() { // from class: cn.damai.message.subscribe.EventCenter.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "325651157")) {
                        ipChange2.ipc$dispatch("325651157", new Object[]{this});
                    } else {
                        EventCenter.this.c.removeObserver(baseObserver);
                    }
                }
            });
        }
    }

    public synchronized <T> boolean c(Action<T> action) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "821914718")) {
            return ((Boolean) ipChange.ipc$dispatch("821914718", new Object[]{this, action})).booleanValue();
        } else if (action == null) {
            return false;
        } else {
            if (!this.b.isEmpty()) {
                for (BaseObserver baseObserver : this.b) {
                    if (baseObserver.isAttachedTo(action)) {
                        return false;
                    }
                }
            }
            DefaultObserver defaultObserver = new DefaultObserver(action);
            defaultObserver.updateVersion(this.a);
            this.b.add(defaultObserver);
            f(defaultObserver);
            return true;
        }
    }

    public boolean d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1725074276")) {
            return ((Boolean) ipChange.ipc$dispatch("-1725074276", new Object[]{this})).booleanValue();
        }
        MutableLiveData<DMEvent> mutableLiveData = this.c;
        if (mutableLiveData == null) {
            return false;
        }
        return mutableLiveData.hasObservers();
    }

    public void f(final BaseObserver baseObserver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-279809276")) {
            ipChange.ipc$dispatch("-279809276", new Object[]{this, baseObserver});
        } else if (e()) {
            g(baseObserver);
        } else {
            this.d.post(new Runnable() { // from class: cn.damai.message.subscribe.EventCenter.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "522164662")) {
                        ipChange2.ipc$dispatch("522164662", new Object[]{this});
                    } else {
                        EventCenter.this.g(baseObserver);
                    }
                }
            });
        }
    }

    public <T> void h(Action<T> action) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643052667")) {
            ipChange.ipc$dispatch("-1643052667", new Object[]{this, action});
            return;
        }
        List<BaseObserver> list = this.b;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (BaseObserver baseObserver : this.b) {
            if (baseObserver.isAttachedTo(action)) {
                i(baseObserver);
                this.b.remove(baseObserver);
                return;
            }
        }
    }

    public synchronized <T> void j(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671754622")) {
            ipChange.ipc$dispatch("671754622", new Object[]{this, t});
            return;
        }
        this.a++;
        DMEvent dMEvent = new DMEvent();
        dMEvent.version = this.a;
        dMEvent.extra = t;
        this.c.postValue(dMEvent);
    }
}
