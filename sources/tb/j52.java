package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.SvgDecryptBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class j52 {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public final String g;
    public final long h;

    public j52(SvgDecryptBean svgDecryptBean, String str, long j) {
        this.a = svgDecryptBean.needDecrypt;
        this.b = svgDecryptBean.safeKey;
        this.c = svgDecryptBean.svgKeyHash;
        this.d = svgDecryptBean.safeToken;
        this.e = svgDecryptBean.svgHash;
        this.f = svgDecryptBean.timeStamp;
        this.g = str;
        this.h = j;
    }

    public String a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1084943964")) {
            return (String) ipChange.ipc$dispatch("1084943964", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(this.b)) {
            sb.append("safeKey=null");
            sb.append(",");
        }
        if (TextUtils.isEmpty(this.c)) {
            sb.append("svgKeyHash=null");
            sb.append(",");
        }
        if (TextUtils.isEmpty(this.e)) {
            sb.append("svgHash=null");
            sb.append(",");
        }
        if (TextUtils.isEmpty(this.f)) {
            sb.append("timeStamp=null");
            sb.append(",");
        }
        return sb.toString();
    }

    public boolean b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1608852536") ? ((Boolean) ipChange.ipc$dispatch("-1608852536", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.f)) ? false : true;
    }

    public boolean c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-112276534") ? ((Boolean) ipChange.ipc$dispatch("-112276534", new Object[]{this})).booleanValue() : this.a;
    }
}
