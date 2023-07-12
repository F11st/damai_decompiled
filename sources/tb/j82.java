package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.util.MD5Util;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class j82 {
    private static transient /* synthetic */ IpChange $ipChange;
    private long a;
    private String b;
    private boolean c;
    private String d;
    private a e;
    private RegionSeat3DVrInfo f;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;
        private String a;
        private long b;
        private String c;
        private String d;

        public String a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "339217081")) {
                return (String) ipChange.ipc$dispatch("339217081", new Object[]{this});
            }
            if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
                return "";
            }
            return MD5Util.md5(this.c + this.d).toUpperCase();
        }

        public String b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-653735493") ? (String) ipChange.ipc$dispatch("-653735493", new Object[]{this}) : this.a;
        }

        public long c() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1861577538") ? ((Long) ipChange.ipc$dispatch("-1861577538", new Object[]{this})).longValue() : this.b;
        }

        public void d(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-186055805")) {
                ipChange.ipc$dispatch("-186055805", new Object[]{this, str});
            } else {
                this.a = str;
            }
        }

        public void e(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "374137129")) {
                ipChange.ipc$dispatch("374137129", new Object[]{this, str});
            } else {
                this.c = str;
            }
        }

        public void f(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-889450517")) {
                ipChange.ipc$dispatch("-889450517", new Object[]{this, str});
            } else {
                this.d = str;
            }
        }

        public void g(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "876941382")) {
                ipChange.ipc$dispatch("876941382", new Object[]{this, Long.valueOf(j)});
            } else {
                this.b = j;
            }
        }
    }

    public a a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1692412129") ? (a) ipChange.ipc$dispatch("-1692412129", new Object[]{this}) : this.e;
    }

    public String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "447387602") ? (String) ipChange.ipc$dispatch("447387602", new Object[]{this}) : this.b;
    }

    public RegionSeat3DVrInfo c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "594183472") ? (RegionSeat3DVrInfo) ipChange.ipc$dispatch("594183472", new Object[]{this}) : this.f;
    }

    public long d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-621422935") ? ((Long) ipChange.ipc$dispatch("-621422935", new Object[]{this})).longValue() : this.a;
    }

    public String e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1986565216") ? (String) ipChange.ipc$dispatch("-1986565216", new Object[]{this}) : this.d;
    }

    public boolean f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1430786878") ? ((Boolean) ipChange.ipc$dispatch("-1430786878", new Object[]{this})).booleanValue() : this.c;
    }

    public void g(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2095981167")) {
            ipChange.ipc$dispatch("2095981167", new Object[]{this, aVar});
        } else {
            this.e = aVar;
        }
    }

    public void h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-632139804")) {
            ipChange.ipc$dispatch("-632139804", new Object[]{this, str});
        } else {
            this.b = str;
        }
    }

    public void i(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2011227466")) {
            ipChange.ipc$dispatch("2011227466", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.c = z;
        }
    }

    public void j(RegionSeat3DVrInfo regionSeat3DVrInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1170794768")) {
            ipChange.ipc$dispatch("-1170794768", new Object[]{this, regionSeat3DVrInfo});
        } else {
            this.f = regionSeat3DVrInfo;
        }
    }

    public void k(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1310079813")) {
            ipChange.ipc$dispatch("-1310079813", new Object[]{this, Long.valueOf(j)});
        } else {
            this.a = j;
        }
    }

    public void l(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "875782870")) {
            ipChange.ipc$dispatch("875782870", new Object[]{this, str});
        } else {
            this.d = str;
        }
    }
}
