package tb;

import com.alibaba.motu.crashreporter.MotuCrashReporter;
import com.taobao.hotpatch.monitor.IPatchVersionMonitor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class zq1 implements IPatchVersionMonitor {
    public zq1() {
        vb.c().d();
    }

    @Override // com.taobao.hotpatch.monitor.IPatchVersionMonitor
    public void patchVersion(String str, String str2) {
        vb.c().b(str, str2);
        vb.c().a(str, str2);
        MotuCrashReporter.getInstance().addNativeHeaderInfo(str, str2);
    }

    @Override // com.taobao.hotpatch.monitor.IPatchVersionMonitor
    public void versionChange(String str, String str2, String str3) {
        vb.c().b(str, str2);
        vb.c().a(str, str2);
        MotuCrashReporter.getInstance().addNativeHeaderInfo(str, str2);
    }
}
