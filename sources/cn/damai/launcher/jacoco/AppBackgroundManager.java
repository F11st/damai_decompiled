package cn.damai.launcher.jacoco;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class AppBackgroundManager {
    private static transient /* synthetic */ IpChange $ipChange;
    static final AppBackgroundManager g = new AppBackgroundManager();
    private int b;
    private IAppStateChangeListener c;
    private String f;
    private boolean a = false;
    private AtomicBoolean d = new AtomicBoolean(false);
    private AtomicInteger e = new AtomicInteger(0);

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface IAppStateChangeListener {
        void onAppStateChanged(boolean z);
    }

    private AppBackgroundManager() {
    }

    private void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1328922839")) {
            ipChange.ipc$dispatch("-1328922839", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        IAppStateChangeListener iAppStateChangeListener = this.c;
        if (iAppStateChangeListener == null) {
            return;
        }
        iAppStateChangeListener.onAppStateChanged(z);
    }

    public static AppBackgroundManager getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1884783969") ? (AppBackgroundManager) ipChange.ipc$dispatch("-1884783969", new Object[0]) : g;
    }

    public void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "921643706")) {
            ipChange.ipc$dispatch("921643706", new Object[]{this, str});
            return;
        }
        if (!(!TextUtils.isEmpty(str) && str.equals(this.f)) && this.d.get()) {
            this.e.incrementAndGet();
        }
        this.f = str;
        this.d.set(true);
        if (!this.a) {
            this.b = 0;
            c(true);
        } else {
            this.b = 1;
        }
        this.a = true;
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1874986972")) {
            ipChange.ipc$dispatch("-1874986972", new Object[]{this});
        } else if (this.e.get() > 1) {
            this.e.decrementAndGet();
        } else {
            this.d.set(false);
            if (this.b == 1) {
                this.b = 2;
            } else if (this.a) {
                this.e.set(0);
                this.a = false;
                c(false);
            }
        }
    }

    public boolean isAppOnForeground() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1723480846") ? ((Boolean) ipChange.ipc$dispatch("1723480846", new Object[]{this})).booleanValue() : this.a;
    }

    public void setAppStateListener(IAppStateChangeListener iAppStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1881084735")) {
            ipChange.ipc$dispatch("-1881084735", new Object[]{this, iAppStateChangeListener});
        } else {
            this.c = iAppStateChangeListener;
        }
    }
}
