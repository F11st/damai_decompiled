package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.ho;
import com.xiaomi.push.service.ba;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.mipush.sdk.f */
/* loaded from: classes11.dex */
public class C7569f implements AbstractPushManager {
    private static volatile C7569f a;

    /* renamed from: a  reason: collision with other field name */
    private Context f70a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f71a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f73a = false;

    /* renamed from: a  reason: collision with other field name */
    private Map<EnumC7568e, AbstractPushManager> f72a = new HashMap();

    private C7569f(Context context) {
        this.f70a = context.getApplicationContext();
    }

    public static C7569f a(Context context) {
        if (a == null) {
            synchronized (C7569f.class) {
                if (a == null) {
                    a = new C7569f(context);
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
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.C7569f.a():void");
    }

    public AbstractPushManager a(EnumC7568e enumC7568e) {
        return this.f72a.get(enumC7568e);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f71a = pushConfiguration;
        this.f73a = ba.a(this.f70a).a(ho.AggregatePushSwitch.a(), true);
        if (this.f71a.getOpenHmsPush() || this.f71a.getOpenFCMPush() || this.f71a.getOpenCOSPush() || this.f71a.getOpenFTOSPush()) {
            ba.a(this.f70a).a(new C7570g(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m646a(EnumC7568e enumC7568e) {
        this.f72a.remove(enumC7568e);
    }

    public void a(EnumC7568e enumC7568e, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f72a.containsKey(enumC7568e)) {
                this.f72a.remove(enumC7568e);
            }
            this.f72a.put(enumC7568e, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m647a(EnumC7568e enumC7568e) {
        return this.f72a.containsKey(enumC7568e);
    }

    public boolean b(EnumC7568e enumC7568e) {
        int i = C7571h.a[enumC7568e.ordinal()];
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
        AbstractC7535b.m586a("ASSEMBLE_PUSH : assemble push register");
        if (this.f72a.size() <= 0) {
            a();
        }
        if (this.f72a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f72a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            C7572i.m649a(this.f70a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        AbstractC7535b.m586a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f72a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f72a.clear();
    }
}
