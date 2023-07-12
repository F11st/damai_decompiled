package tb;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.monitor.IDXAppMonitor;

/* compiled from: Taobao */
/* renamed from: tb.ar */
/* loaded from: classes4.dex */
public class C8921ar implements IDXAppMonitor {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.taobao.android.dinamicx.monitor.IDXAppMonitor
    public void alarm_commitFail(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-646149351")) {
            ipChange.ipc$dispatch("-646149351", new Object[]{this, str, str2, str3, str4});
        } else {
            AppMonitor.Alarm.commitFail(str, str2, str3, str4);
        }
    }

    @Override // com.taobao.android.dinamicx.monitor.IDXAppMonitor
    public void alarm_commitSuccess(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1116086028")) {
            ipChange.ipc$dispatch("1116086028", new Object[]{this, str, str2});
        } else {
            AppMonitor.Alarm.commitSuccess(str, str2);
        }
    }

    @Override // com.taobao.android.dinamicx.monitor.IDXAppMonitor
    public void counter_commit(String str, String str2, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-8533296")) {
            ipChange.ipc$dispatch("-8533296", new Object[]{this, str, str2, Double.valueOf(d)});
        } else {
            AppMonitor.Counter.commit(str, str2, d);
        }
    }

    @Override // com.taobao.android.dinamicx.monitor.IDXAppMonitor
    public void stat_begin(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1342892204")) {
            ipChange.ipc$dispatch("-1342892204", new Object[]{this, str, str2, str3});
        } else {
            AppMonitor.Stat.begin(str, str2, str3);
        }
    }

    @Override // com.taobao.android.dinamicx.monitor.IDXAppMonitor
    public void stat_commit(String str, String str2, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1842144810")) {
            ipChange.ipc$dispatch("-1842144810", new Object[]{this, str, str2, Double.valueOf(d)});
        } else {
            AppMonitor.Stat.commit(str, str2, d);
        }
    }

    @Override // com.taobao.android.dinamicx.monitor.IDXAppMonitor
    public void stat_end(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206444002")) {
            ipChange.ipc$dispatch("206444002", new Object[]{this, str, str2, str3});
        } else {
            AppMonitor.Stat.end(str, str2, str3);
        }
    }

    @Override // com.taobao.android.dinamicx.monitor.IDXAppMonitor
    public void alarm_commitFail(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "234389667")) {
            ipChange.ipc$dispatch("234389667", new Object[]{this, str, str2, str3, str4, str5});
        } else {
            AppMonitor.Alarm.commitFail(str, str2, str3, str4, str5);
        }
    }

    @Override // com.taobao.android.dinamicx.monitor.IDXAppMonitor
    public void alarm_commitSuccess(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1247928874")) {
            ipChange.ipc$dispatch("-1247928874", new Object[]{this, str, str2, str3});
        } else {
            AppMonitor.Alarm.commitSuccess(str, str2, str3);
        }
    }

    @Override // com.taobao.android.dinamicx.monitor.IDXAppMonitor
    public void counter_commit(String str, String str2, String str3, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1480386106")) {
            ipChange.ipc$dispatch("-1480386106", new Object[]{this, str, str2, str3, Double.valueOf(d)});
        } else {
            AppMonitor.Counter.commit(str, str2, str3, d);
        }
    }
}
