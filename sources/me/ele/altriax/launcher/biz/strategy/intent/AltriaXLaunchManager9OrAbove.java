package me.ele.altriax.launcher.biz.strategy.intent;

import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AltriaXLaunchManager9OrAbove extends AltriaXLaunchManager {
    private static final String NAME_CLIENT_TRANSACTION = "android.app.servertransaction.ClientTransaction";
    private static final String NAME_LAUNCH_ACTIVITY_ITEM = "android.app.servertransaction.LaunchActivityItem";
    private static Field activityCallbacksField;
    private static Field activityInfoField;
    private static Field intentField;
    private static Field referrerField;

    static {
        Class<?> cls;
        try {
            Field declaredField = Class.forName(NAME_CLIENT_TRANSACTION).getDeclaredField("mActivityCallbacks");
            activityCallbacksField = declaredField;
            declaredField.setAccessible(true);
            cls = Class.forName(NAME_LAUNCH_ACTIVITY_ITEM);
            Field declaredField2 = cls.getDeclaredField("mIntent");
            intentField = declaredField2;
            declaredField2.setAccessible(true);
        } catch (ClassNotFoundException | NoSuchFieldException unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                Field declaredField3 = cls.getDeclaredField("mReferrer");
                referrerField = declaredField3;
                declaredField3.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
            }
            try {
                Field declaredField4 = cls.getDeclaredField("mInfo");
                activityInfoField = declaredField4;
                declaredField4.setAccessible(true);
            } catch (NoSuchFieldException unused3) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchContext resolveMessage(android.os.Message r6) {
        /*
            r5 = this;
            int r0 = r6.what
            r1 = 0
            r2 = 159(0x9f, float:2.23E-43)
            if (r0 == r2) goto L8
            return r1
        L8:
            java.lang.reflect.Field r0 = me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchManager9OrAbove.activityCallbacksField
            if (r0 == 0) goto L6e
            java.lang.reflect.Field r2 = me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchManager9OrAbove.intentField
            if (r2 == 0) goto L6e
            java.lang.Object r6 = r6.obj     // Catch: java.lang.IllegalAccessException -> L6e
            java.lang.Object r6 = r0.get(r6)     // Catch: java.lang.IllegalAccessException -> L6e
            java.util.List r6 = (java.util.List) r6     // Catch: java.lang.IllegalAccessException -> L6e
            if (r6 == 0) goto L6e
            int r0 = r6.size()     // Catch: java.lang.IllegalAccessException -> L6e
            if (r0 <= 0) goto L6e
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.IllegalAccessException -> L6e
        L24:
            boolean r0 = r6.hasNext()     // Catch: java.lang.IllegalAccessException -> L6e
            if (r0 == 0) goto L6e
            java.lang.Object r0 = r6.next()     // Catch: java.lang.IllegalAccessException -> L6e
            java.lang.String r2 = "android.app.servertransaction.LaunchActivityItem"
            java.lang.Class r3 = r0.getClass()     // Catch: java.lang.IllegalAccessException -> L6e
            java.lang.String r3 = r3.getName()     // Catch: java.lang.IllegalAccessException -> L6e
            boolean r2 = r2.equals(r3)     // Catch: java.lang.IllegalAccessException -> L6e
            if (r2 == 0) goto L24
            java.lang.reflect.Field r6 = me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchManager9OrAbove.intentField     // Catch: java.lang.IllegalAccessException -> L6e
            java.lang.Object r6 = r6.get(r0)     // Catch: java.lang.IllegalAccessException -> L6e
            android.content.Intent r6 = (android.content.Intent) r6     // Catch: java.lang.IllegalAccessException -> L6e
            java.lang.reflect.Field r2 = me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchManager9OrAbove.activityInfoField     // Catch: java.lang.IllegalAccessException -> L6e
            if (r2 == 0) goto L5a
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.IllegalAccessException -> L57
            android.content.pm.ActivityInfo r2 = (android.content.pm.ActivityInfo) r2     // Catch: java.lang.IllegalAccessException -> L57
            if (r2 == 0) goto L5a
            java.lang.String r3 = r2.processName     // Catch: java.lang.IllegalAccessException -> L57
            java.lang.String r2 = r2.packageName     // Catch: java.lang.IllegalAccessException -> L58
            goto L5c
        L57:
            r3 = r1
        L58:
            r2 = r1
            goto L5c
        L5a:
            r2 = r1
            r3 = r2
        L5c:
            java.lang.reflect.Field r4 = me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchManager9OrAbove.referrerField     // Catch: java.lang.IllegalAccessException -> L6e
            if (r4 == 0) goto L67
            java.lang.Object r0 = r4.get(r0)     // Catch: java.lang.IllegalAccessException -> L67
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.IllegalAccessException -> L67
            goto L68
        L67:
            r0 = r1
        L68:
            me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchContext r4 = new me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchContext     // Catch: java.lang.IllegalAccessException -> L6e
            r4.<init>(r3, r2, r0, r6)     // Catch: java.lang.IllegalAccessException -> L6e
            return r4
        L6e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchManager9OrAbove.resolveMessage(android.os.Message):me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchContext");
    }
}
