package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.register.RegistConstants;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.huawei.hms.opendevice.m */
/* loaded from: classes10.dex */
public class C5669m extends Thread {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public C5669m(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean b;
        boolean d;
        String c;
        if (AbstractC5674p.b()) {
            b = C5670n.b(this.a);
            if (b) {
                return;
            }
            String a = C5673o.a(this.a);
            if (!TextUtils.isEmpty(a)) {
                d = C5670n.d(this.a, a, this.b);
                if (!d) {
                    HMSLog.d("ReportAaidToken", "This time need not report.");
                    return;
                }
                String string = AGConnectServicesConfig.fromContext(this.a).getString(RegistConstants.REGION_INFO);
                if (TextUtils.isEmpty(string)) {
                    HMSLog.i("ReportAaidToken", "The data storage region is empty.");
                    return;
                }
                String a2 = AbstractC5661e.a(this.a, "com.huawei.hms.opendevicesdk", "ROOT", null, string);
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                c = C5670n.c(this.a, a, this.b);
                Context context = this.a;
                C5670n.b(this.a, AbstractC5659d.a(context, a2 + "/rest/appdata/v1/aaid/report", c, (Map<String, String>) null), a, this.b);
                return;
            }
            HMSLog.w("ReportAaidToken", "AAID is empty.");
            return;
        }
        HMSLog.d("ReportAaidToken", "Not HW Phone.");
    }
}
