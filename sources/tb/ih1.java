package tb;

import android.text.TextUtils;
import cn.damai.solid.C1768a;
import cn.damai.solid.util.Constant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.monitor.IMonitor;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ih1 implements IMonitor {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: tb.ih1$a */
    /* loaded from: classes7.dex */
    static /* synthetic */ class C9262a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SolidMonitor.Stage.values().length];
            a = iArr;
            try {
                iArr[SolidMonitor.Stage.SOLID_LIB_START_DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[SolidMonitor.Stage.SOLID_LIB_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.youku.arch.solid.monitor.IMonitor
    public void reportStageResult(SolidMonitor.Stage stage, Map<SolidMonitor.Params, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "64385523")) {
            ipChange.ipc$dispatch("64385523", new Object[]{this, stage, map});
            return;
        }
        C1768a.f("reportStageResult stageName " + stage.name());
        try {
            int i = C9262a.a[stage.ordinal()];
            if (i == 1) {
                String str = map.get(SolidMonitor.Params.LIB_NAME);
                se2.e(str);
                C1768a.f("SOLID_LIB_START_DOWNLOAD start libName=" + str);
            } else if (i != 2) {
            } else {
                String str2 = map.get(SolidMonitor.Params.SUCCESS);
                String str3 = map.get(SolidMonitor.Params.LIB_NAME);
                if (str3 == null) {
                    str3 = "unknown.lib";
                }
                HashMap hashMap = new HashMap();
                hashMap.put("libName", str3);
                if (TextUtils.equals("1", str2)) {
                    se2.d(hashMap);
                } else {
                    String str4 = map.get(SolidMonitor.Params.ERROR_MSG);
                    if (str4 == null) {
                        str4 = "xcdn_download_fail";
                    }
                    se2.c(Constant.CODE_XCDN_DOWNLOAD_FAIL, str4, hashMap);
                }
                C1768a.f("SOLID_LIB_DOWNLOAD end libName=" + str3 + " status=" + str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
