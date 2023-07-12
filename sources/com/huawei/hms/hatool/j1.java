package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class j1 {
    public String a;
    public C5632m b;

    public j1(String str) {
        this.a = str;
        this.b = new C5632m(str);
        C5624i.c().a(this.a, this.b);
    }

    public void a(int i) {
        C5653y.d("hmsSdk", "onReport. TAG: " + this.a + ", TYPE: " + i);
        i1.a().a(this.a, i);
    }

    public void a(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        C5653y.d("hmsSdk", "onEvent. TAG: " + this.a + ", TYPE: " + i + ", eventId : " + str);
        if (s0.a(str) || !c(i)) {
            C5653y.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.a + ", TYPE: " + i);
            return;
        }
        if (!s0.a(linkedHashMap)) {
            C5653y.e("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.a + ", TYPE: " + i);
            linkedHashMap = null;
        }
        i1.a().a(this.a, i, str, linkedHashMap);
    }

    public void a(Context context, String str, String str2) {
        C5653y.d("hmsSdk", "onEvent(context). TAG: " + this.a + ", eventId : " + str);
        if (context == null) {
            C5653y.e("hmsSdk", "context is null in onevent ");
        } else if (s0.a(str) || !c(0)) {
            C5653y.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.a);
        } else {
            if (!s0.a("value", str2, 65536)) {
                C5653y.e("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.a);
                str2 = "";
            }
            i1.a().a(this.a, context, str, str2);
        }
    }

    public void a(C5628k c5628k) {
        C5653y.c("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.a);
        if (c5628k != null) {
            this.b.a(c5628k);
            return;
        }
        C5653y.e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
        this.b.a((C5628k) null);
    }

    public final C5628k b(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return this.b.a();
                }
                return this.b.d();
            }
            return this.b.b();
        }
        return this.b.c();
    }

    public void b(C5628k c5628k) {
        C5653y.c("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.a);
        if (c5628k != null) {
            this.b.b(c5628k);
            return;
        }
        this.b.b(null);
        C5653y.e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
    }

    public final boolean c(int i) {
        String str;
        if (i != 2) {
            C5628k b = b(i);
            if (b != null && !TextUtils.isEmpty(b.h())) {
                return true;
            }
            str = "verifyURL(): URL check failed. type: " + i;
        } else if ("_default_config_tag".equals(this.a)) {
            return true;
        } else {
            str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        C5653y.e("hmsSdk", str);
        return false;
    }
}
