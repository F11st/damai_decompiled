package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class pk1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;

    public String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1097536770") ? (String) ipChange.ipc$dispatch("-1097536770", new Object[]{this}) : this.d;
    }

    public String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "272790867") ? (String) ipChange.ipc$dispatch("272790867", new Object[]{this}) : this.e;
    }

    public String c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1088832489") ? (String) ipChange.ipc$dispatch("1088832489", new Object[]{this}) : this.a;
    }

    public String d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1961370326") ? (String) ipChange.ipc$dispatch("-1961370326", new Object[]{this}) : this.c;
    }

    public String e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-716605845") ? (String) ipChange.ipc$dispatch("-716605845", new Object[]{this}) : this.b;
    }

    public void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1629106376")) {
            ipChange.ipc$dispatch("-1629106376", new Object[]{this, str});
        } else {
            this.d = str;
        }
    }

    public void g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2051666155")) {
            ipChange.ipc$dispatch("2051666155", new Object[]{this, str});
        } else {
            this.e = str;
        }
    }

    public void h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "812616877")) {
            ipChange.ipc$dispatch("812616877", new Object[]{this, str});
        } else {
            this.a = str;
        }
    }

    public void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "745610124")) {
            ipChange.ipc$dispatch("745610124", new Object[]{this, str});
        } else {
            this.c = str;
        }
    }

    public void j(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "678603371")) {
            ipChange.ipc$dispatch("678603371", new Object[]{this, str});
        } else {
            this.b = str;
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-890802883")) {
            return (String) ipChange.ipc$dispatch("-890802883", new Object[]{this});
        }
        return "NfcReadResult{sid='" + this.a + "', uid='" + this.b + "', tid='" + this.c + "', challenge='" + this.d + "', cipherText='" + this.e + "'}";
    }
}
