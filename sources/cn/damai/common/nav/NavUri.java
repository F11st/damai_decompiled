package cn.damai.common.nav;

import android.net.Uri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class NavUri {
    private static transient /* synthetic */ IpChange $ipChange;
    protected Uri.Builder a = new Uri.Builder();

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface Schemed {
        NavUri host(String str);
    }

    public static NavUri b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1587413401")) {
            return (NavUri) ipChange.ipc$dispatch("1587413401", new Object[]{str});
        }
        NavUri navUri = new NavUri();
        navUri.a.scheme("damai").authority(str);
        return navUri;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Uri a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2094571808") ? (Uri) ipChange.ipc$dispatch("-2094571808", new Object[]{this}) : this.a.build();
    }

    public NavUri c(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1475312024")) {
            return (NavUri) ipChange.ipc$dispatch("1475312024", new Object[]{this, str, Integer.valueOf(i)});
        }
        this.a.appendQueryParameter(str, String.valueOf(i));
        return this;
    }

    public NavUri d(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086496759")) {
            return (NavUri) ipChange.ipc$dispatch("-1086496759", new Object[]{this, str, str2});
        }
        this.a.appendQueryParameter(str, str2);
        return this;
    }

    public NavUri e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1562886353")) {
            return (NavUri) ipChange.ipc$dispatch("-1562886353", new Object[]{this, str});
        }
        if (str != null && !str.startsWith("/")) {
            str = "/" + str;
        }
        this.a.path(str);
        return this;
    }
}
