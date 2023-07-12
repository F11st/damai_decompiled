package me.ele.altriax.launcher.biz.strategy.intent;

import com.huawei.hms.support.api.entity.core.CommonCode;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AltriaXLaunchManagerUnder9 extends AltriaXLaunchManager {
    private static Field activityInfoField;
    private static Field intentField;
    private static Field referrerField;

    static {
        Class<?> cls = null;
        try {
            cls = Class.forName("android.app.ActivityThread$ActivityClientRecord");
            Field declaredField = cls.getDeclaredField(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            intentField = declaredField;
            declaredField.setAccessible(true);
        } catch (ClassNotFoundException | NoSuchFieldException unused) {
        }
        if (cls != null) {
            try {
                Field declaredField2 = cls.getDeclaredField("referrer");
                referrerField = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
            }
            try {
                Field declaredField3 = cls.getDeclaredField("activityInfo");
                activityInfoField = declaredField3;
                declaredField3.setAccessible(true);
            } catch (NoSuchFieldException unused3) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchContext resolveMessage(android.os.Message r5) {
        /*
            r4 = this;
            int r0 = r5.what
            r1 = 0
            r2 = 100
            if (r0 == r2) goto L8
            return r1
        L8:
            java.lang.reflect.Field r0 = me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchManagerUnder9.intentField
            if (r0 != 0) goto Ld
            return r1
        Ld:
            java.lang.Object r2 = r5.obj     // Catch: java.lang.IllegalAccessException -> L16
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.IllegalAccessException -> L16
            android.content.Intent r0 = (android.content.Intent) r0     // Catch: java.lang.IllegalAccessException -> L16
            goto L17
        L16:
            r0 = r1
        L17:
            java.lang.reflect.Field r2 = me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchManagerUnder9.referrerField
            if (r2 == 0) goto L24
            java.lang.Object r3 = r5.obj     // Catch: java.lang.IllegalAccessException -> L24
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.IllegalAccessException -> L24
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.IllegalAccessException -> L24
            goto L25
        L24:
            r2 = r1
        L25:
            java.lang.reflect.Field r3 = me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchManagerUnder9.activityInfoField
            if (r3 == 0) goto L3c
            java.lang.Object r5 = r5.obj     // Catch: java.lang.IllegalAccessException -> L38
            java.lang.Object r5 = r3.get(r5)     // Catch: java.lang.IllegalAccessException -> L38
            android.content.pm.ActivityInfo r5 = (android.content.pm.ActivityInfo) r5     // Catch: java.lang.IllegalAccessException -> L38
            if (r5 == 0) goto L3c
            java.lang.String r3 = r5.processName     // Catch: java.lang.IllegalAccessException -> L38
            java.lang.String r5 = r5.packageName     // Catch: java.lang.IllegalAccessException -> L39
            goto L3a
        L38:
            r3 = r1
        L39:
            r5 = r1
        L3a:
            r1 = r3
            goto L3d
        L3c:
            r5 = r1
        L3d:
            me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchContext r3 = new me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchContext
            r3.<init>(r1, r5, r2, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchManagerUnder9.resolveMessage(android.os.Message):me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchContext");
    }
}
