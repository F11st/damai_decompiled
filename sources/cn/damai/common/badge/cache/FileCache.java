package cn.damai.common.badge.cache;

import android.app.Application;
import android.content.SharedPreferences;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z9;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class FileCache {
    private static transient /* synthetic */ IpChange $ipChange;
    SharedPreferences a;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface FileCacheLoadCallback {
        void finished();
    }

    public FileCache() {
        b();
    }

    public String a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1092763657")) {
            return (String) ipChange.ipc$dispatch("-1092763657", new Object[]{this, str, str2});
        }
        b();
        synchronized (this) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences != null) {
                sharedPreferences.getString(str, str2);
            }
        }
        return str2;
    }

    void b() {
        Application a;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-609082955")) {
            ipChange.ipc$dispatch("-609082955", new Object[]{this});
            return;
        }
        synchronized (this) {
            if (this.a == null && (a = z9.a()) != null) {
                this.a = a.getSharedPreferences("sp_damai_badge", 0);
            }
        }
    }

    public void c(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1700314408")) {
            ipChange.ipc$dispatch("-1700314408", new Object[]{this, str, str2});
            return;
        }
        b();
        synchronized (this) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(str, str2).apply();
            }
        }
    }
}
