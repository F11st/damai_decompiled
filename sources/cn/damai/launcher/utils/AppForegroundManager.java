package cn.damai.launcher.utils;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class AppForegroundManager {
    private static transient /* synthetic */ IpChange $ipChange;
    static final AppForegroundManager g = new AppForegroundManager();
    private int b;
    private ArrayList<IAppStateChangeListener> c;
    private String f;
    private boolean a = false;
    private AtomicBoolean d = new AtomicBoolean(false);
    private AtomicInteger e = new AtomicInteger(0);

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface IAppStateChangeListener {
        void onAppStateChanged(boolean z);
    }

    private AppForegroundManager() {
    }

    private void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "623539360")) {
            ipChange.ipc$dispatch("623539360", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ArrayList<IAppStateChangeListener> arrayList = this.c;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).onAppStateChanged(z);
        }
    }

    public static AppForegroundManager getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-209225861") ? (AppForegroundManager) ipChange.ipc$dispatch("-209225861", new Object[0]) : g;
    }

    public void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1645869361")) {
            ipChange.ipc$dispatch("1645869361", new Object[]{this, str});
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
        if (AndroidInstantRuntime.support(ipChange, "1438991963")) {
            ipChange.ipc$dispatch("1438991963", new Object[]{this});
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
        return AndroidInstantRuntime.support(ipChange, "742492485") ? ((Boolean) ipChange.ipc$dispatch("742492485", new Object[]{this})).booleanValue() : this.a;
    }

    public void setAppStateListener(IAppStateChangeListener iAppStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "265406415")) {
            ipChange.ipc$dispatch("265406415", new Object[]{this, iAppStateChangeListener});
            return;
        }
        if (this.c == null) {
            this.c = new ArrayList<>();
        }
        this.c.add(iAppStateChangeListener);
    }
}
