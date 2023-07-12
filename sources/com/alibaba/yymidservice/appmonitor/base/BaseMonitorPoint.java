package com.alibaba.yymidservice.appmonitor.base;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class BaseMonitorPoint {
    public String mPointName;
    @Nullable
    private MonitorType mPointType;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum MonitorType {
        UT_PAGE(2001),
        UT_CLICK(2101),
        UT_EXPOSURE(2201),
        UT_CUSTOM(3001),
        APP_MONITOR(4001);
        
        private final int eventId;

        MonitorType(int i) {
            this.eventId = i;
        }

        public final int getEventId() {
            return this.eventId;
        }
    }

    public BaseMonitorPoint() {
        onCreate();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007c A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.util.Map<java.lang.String, java.lang.String> checkAndCreateParamsMap() {
        /*
            r7 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.Class r1 = r7.getClass()
            java.lang.reflect.Field[] r1 = r1.getDeclaredFields()
            java.lang.String r2 = "fields"
            tb.b41.h(r1, r2)
            int r2 = r1.length
            r3 = 0
        L14:
            if (r3 >= r2) goto L7f
            r4 = r1[r3]
            if (r4 != 0) goto L1b
            goto L7c
        L1b:
            java.lang.Class<com.alibaba.yymidservice.appmonitor.base.MonitorKeyMark> r5 = com.alibaba.yymidservice.appmonitor.base.MonitorKeyMark.class
            java.lang.annotation.Annotation r5 = r4.getAnnotation(r5)
            com.alibaba.yymidservice.appmonitor.base.MonitorKeyMark r5 = (com.alibaba.yymidservice.appmonitor.base.MonitorKeyMark) r5
            if (r5 != 0) goto L26
            goto L7c
        L26:
            r5 = 1
            r4.setAccessible(r5)     // Catch: java.lang.Exception -> L64
            java.lang.Object r5 = r4.get(r7)     // Catch: java.lang.Exception -> L64
            if (r5 == 0) goto L68
            boolean r6 = r5 instanceof java.lang.Byte     // Catch: java.lang.Exception -> L64
            if (r6 != 0) goto L5f
            boolean r6 = r5 instanceof java.lang.Character     // Catch: java.lang.Exception -> L64
            if (r6 != 0) goto L5f
            boolean r6 = r5 instanceof java.lang.Boolean     // Catch: java.lang.Exception -> L64
            if (r6 != 0) goto L5f
            boolean r6 = r5 instanceof java.lang.Short     // Catch: java.lang.Exception -> L64
            if (r6 != 0) goto L5f
            boolean r6 = r5 instanceof java.lang.Integer     // Catch: java.lang.Exception -> L64
            if (r6 != 0) goto L5f
            boolean r6 = r5 instanceof java.lang.Long     // Catch: java.lang.Exception -> L64
            if (r6 != 0) goto L5f
            boolean r6 = r5 instanceof java.lang.Float     // Catch: java.lang.Exception -> L64
            if (r6 != 0) goto L5f
            boolean r6 = r5 instanceof java.lang.Double     // Catch: java.lang.Exception -> L64
            if (r6 == 0) goto L51
            goto L5f
        L51:
            boolean r6 = r5 instanceof java.lang.String     // Catch: java.lang.Exception -> L64
            if (r6 == 0) goto L58
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L64
            goto L6a
        L58:
            tb.yh0 r6 = tb.yh0.INSTANCE     // Catch: java.lang.Exception -> L64
            java.lang.String r5 = r6.e(r5)     // Catch: java.lang.Exception -> L64
            goto L6a
        L5f:
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L64
            goto L6a
        L64:
            r5 = move-exception
            r5.printStackTrace()
        L68:
            java.lang.String r5 = ""
        L6a:
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L7c
            java.lang.String r4 = r4.getName()
            java.lang.String r6 = "field.name"
            tb.b41.h(r4, r6)
            r0.put(r4, r5)
        L7c:
            int r3 = r3 + 1
            goto L14
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.yymidservice.appmonitor.base.BaseMonitorPoint.checkAndCreateParamsMap():java.util.Map");
    }

    @NotNull
    public final String getMPointName() {
        String str = this.mPointName;
        if (str != null) {
            return str;
        }
        b41.A("mPointName");
        return null;
    }

    @Nullable
    public final MonitorType getMPointType() {
        return this.mPointType;
    }

    @NotNull
    public abstract String getPointName();

    @NotNull
    public abstract MonitorType getPointType();

    protected void onCreate() {
        setMPointName(getPointName());
        this.mPointType = getPointType();
    }

    public abstract void release();

    public final void setMPointName(@NotNull String str) {
        b41.i(str, "<set-?>");
        this.mPointName = str;
    }

    public final void setMPointType(@Nullable MonitorType monitorType) {
        this.mPointType = monitorType;
    }
}
