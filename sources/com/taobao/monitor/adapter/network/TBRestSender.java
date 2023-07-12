package com.taobao.monitor.adapter.network;

import com.alibaba.motu.tbrest.SendService;
import com.taobao.monitor.network.INetworkSender;
import java.util.List;
import tb.e30;
import tb.pb1;
import tb.rj2;
import tb.vm2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TBRestSender implements INetworkSender {
    private final Integer a = 61004;
    private final String b = null;
    private boolean c = true;
    private ILiteDb d = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, String str2) {
        ILiteDb iLiteDb = this.d;
        iLiteDb.insert(str + "HA_APM_______HA_APM" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str, String str2) {
        return SendService.getInstance().sendRequest(this.b, System.currentTimeMillis(), null, this.a.intValue(), "AliHAMonitor", str2, str, null).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        List<String> select = this.d.select();
        if (select != null) {
            for (String str : select) {
                if (str != null) {
                    String[] split = str.split("HA_APM_______HA_APM");
                    if (split.length >= 2) {
                        g(split[0], split[1]);
                    }
                }
            }
        }
        this.d.delete();
    }

    @Override // com.taobao.monitor.network.INetworkSender
    public void send(final String str, final String str2) {
        if (rj2.c) {
            e30.a("TBRestSender", str, str2);
            vm2.d(new Runnable() { // from class: com.taobao.monitor.adapter.network.TBRestSender.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        pb1.d("TBRestSender", str2);
                        int i = 0;
                        boolean z = false;
                        while (true) {
                            int i2 = i + 1;
                            if (i >= 2) {
                                break;
                            }
                            z = TBRestSender.this.g(str, str2);
                            if (z) {
                                pb1.d("TBRestSender", "send success" + i2);
                                break;
                            }
                            i = i2;
                        }
                        if (!z) {
                            TBRestSender.this.f(str, str2);
                            TBRestSender.this.c = true;
                        }
                        if (z && TBRestSender.this.c) {
                            TBRestSender.this.h();
                            TBRestSender.this.c = false;
                        }
                    } catch (Throwable th) {
                        pb1.f(th);
                    }
                }
            });
        }
    }
}
