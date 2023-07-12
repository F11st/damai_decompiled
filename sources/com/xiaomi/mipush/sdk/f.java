package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ho;
import com.xiaomi.push.service.ba;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class f implements AbstractPushManager {
    private static volatile f a;

    /* renamed from: a  reason: collision with other field name */
    private Context f70a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f71a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f73a = false;

    /* renamed from: a  reason: collision with other field name */
    private Map<e, AbstractPushManager> f72a = new HashMap();

    private f(Context context) {
        this.f70a = context.getApplicationContext();
    }

    public static f a(Context context) {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f(context);
                }
            }
        }
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.f.a():void");
    }

    public AbstractPushManager a(e eVar) {
        return this.f72a.get(eVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f71a = pushConfiguration;
        this.f73a = ba.a(this.f70a).a(ho.AggregatePushSwitch.a(), true);
        if (this.f71a.getOpenHmsPush() || this.f71a.getOpenFCMPush() || this.f71a.getOpenCOSPush() || this.f71a.getOpenFTOSPush()) {
            ba.a(this.f70a).a(new g(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m646a(e eVar) {
        this.f72a.remove(eVar);
    }

    public void a(e eVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f72a.containsKey(eVar)) {
                this.f72a.remove(eVar);
            }
            this.f72a.put(eVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m647a(e eVar) {
        return this.f72a.containsKey(eVar);
    }

    public boolean b(e eVar) {
        int i = h.a[eVar.ordinal()];
        boolean z = false;
        if (i == 1) {
            PushConfiguration pushConfiguration = this.f71a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        } else if (i == 2) {
            PushConfiguration pushConfiguration2 = this.f71a;
            if (pushConfiguration2 != null) {
                return pushConfiguration2.getOpenFCMPush();
            }
            return false;
        } else {
            if (i == 3) {
                PushConfiguration pushConfiguration3 = this.f71a;
                if (pushConfiguration3 != null) {
                    z = pushConfiguration3.getOpenCOSPush();
                }
            } else if (i != 4) {
                return false;
            }
            PushConfiguration pushConfiguration4 = this.f71a;
            return pushConfiguration4 != null ? pushConfiguration4.getOpenFTOSPush() : z;
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m586a("ASSEMBLE_PUSH : assemble push register");
        if (this.f72a.size() <= 0) {
            a();
        }
        if (this.f72a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f72a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            i.m649a(this.f70a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m586a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f72a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f72a.clear();
    }
}
