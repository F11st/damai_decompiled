package com.amap.api.mapcore.util;

import android.content.Context;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class hl {
    private hg a;
    private Context b;

    public hl(Context context, boolean z) {
        this.b = context;
        this.a = a(context, z);
    }

    private hg a(Context context, boolean z) {
        try {
            return new hg(context, hg.a((Class<? extends hf>) hk.class));
        } catch (Throwable th) {
            if (!z) {
                hd.c(th, "sd", "gdb");
            }
            return null;
        }
    }

    public void a(gm gmVar) {
        if (gmVar == null) {
            return;
        }
        try {
            if (this.a == null) {
                this.a = a(this.b, false);
            }
            String a = gm.a(gmVar.a());
            List<gm> b = this.a.b(a, gm.class);
            if (b != null && b.size() != 0) {
                if (a(b, gmVar)) {
                    this.a.a(a, gmVar);
                    return;
                }
                return;
            }
            this.a.a((hg) gmVar);
        } catch (Throwable th) {
            hd.c(th, "sd", AdvanceSetting.NETWORK_TYPE);
        }
    }

    private boolean a(List<gm> list, gm gmVar) {
        for (gm gmVar2 : list) {
            if (gmVar2.equals(gmVar)) {
                return false;
            }
        }
        return true;
    }

    public List<gm> a() {
        try {
            return this.a.a(gm.h(), gm.class, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
