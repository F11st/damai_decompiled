package cn.damai.uikit.nav;

import android.net.Uri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class INavUri implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    protected Uri.Builder mBuilder = new Uri.Builder();

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface Schemed {
        INavUri host(String str);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.nav.INavUri$a */
    /* loaded from: classes8.dex */
    public static final class C2516a implements Schemed {
        private static transient /* synthetic */ IpChange $ipChange;

        C2516a() {
        }

        @Override // cn.damai.uikit.nav.INavUri.Schemed
        public INavUri host(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "505292933")) {
                return (INavUri) ipChange.ipc$dispatch("505292933", new Object[]{this, str});
            }
            INavUri.this.mBuilder.authority(str);
            return INavUri.this;
        }
    }

    public static INavUri host(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-578990798")) {
            return (INavUri) ipChange.ipc$dispatch("-578990798", new Object[]{str});
        }
        INavUri iNavUri = new INavUri();
        iNavUri.mBuilder.scheme("http").authority(str);
        return iNavUri;
    }

    public static INavUri page(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1302507545")) {
            return (INavUri) ipChange.ipc$dispatch("1302507545", new Object[]{str});
        }
        INavUri iNavUri = new INavUri();
        iNavUri.mBuilder.scheme("damai").authority(str);
        return iNavUri;
    }

    public static Schemed scheme(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1841391756")) {
            return (Schemed) ipChange.ipc$dispatch("-1841391756", new Object[]{str});
        }
        INavUri iNavUri = new INavUri();
        iNavUri.mBuilder.scheme(str);
        return new C2516a();
    }

    public Uri build() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-10019296") ? (Uri) ipChange.ipc$dispatch("-10019296", new Object[]{this}) : this.mBuilder.build();
    }

    public INavUri fragment(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1853139162")) {
            return (INavUri) ipChange.ipc$dispatch("1853139162", new Object[]{this, str});
        }
        this.mBuilder.fragment(str);
        return this;
    }

    public INavUri param(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2107865079")) {
            return (INavUri) ipChange.ipc$dispatch("-2107865079", new Object[]{this, str, str2});
        }
        this.mBuilder.appendQueryParameter(str, str2);
        return this;
    }

    public INavUri path(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1847792209")) {
            return (INavUri) ipChange.ipc$dispatch("-1847792209", new Object[]{this, str});
        }
        if (str != null && !str.startsWith("/")) {
            str = "/" + str;
        }
        this.mBuilder.path(str);
        return this;
    }

    public INavUri segment(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2102955577")) {
            return (INavUri) ipChange.ipc$dispatch("2102955577", new Object[]{this, str});
        }
        this.mBuilder.appendEncodedPath(str);
        return this;
    }

    public INavUri param(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1275462583")) {
            return (INavUri) ipChange.ipc$dispatch("1275462583", new Object[]{this, str, Long.valueOf(j)});
        }
        this.mBuilder.appendQueryParameter(str, String.valueOf(j));
        return this;
    }

    public INavUri segment(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1037703047")) {
            return (INavUri) ipChange.ipc$dispatch("1037703047", new Object[]{this, Long.valueOf(j)});
        }
        this.mBuilder.appendEncodedPath(String.valueOf(j));
        return this;
    }

    public static INavUri page(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-551884913")) {
            return (INavUri) ipChange.ipc$dispatch("-551884913", new Object[]{str, str2});
        }
        INavUri iNavUri = new INavUri();
        if (str2 != null && !str2.startsWith("/")) {
            str2 = "/" + str2;
        }
        iNavUri.mBuilder.scheme("damai").authority(str).path(str2);
        return iNavUri;
    }

    public INavUri param(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1264146456")) {
            return (INavUri) ipChange.ipc$dispatch("1264146456", new Object[]{this, str, Integer.valueOf(i)});
        }
        this.mBuilder.appendQueryParameter(str, String.valueOf(i));
        return this;
    }

    public INavUri segment(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1026386920")) {
            return (INavUri) ipChange.ipc$dispatch("1026386920", new Object[]{this, Integer.valueOf(i)});
        }
        this.mBuilder.appendEncodedPath(String.valueOf(i));
        return this;
    }
}
