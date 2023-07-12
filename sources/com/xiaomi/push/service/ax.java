package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7680j;
import com.xiaomi.push.C7688m;
import com.xiaomi.push.ho;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ax {
    private static Context a;

    /* renamed from: a  reason: collision with other field name */
    private static Object f904a;

    /* renamed from: a  reason: collision with other field name */
    private static WeakHashMap<Integer, ax> f905a = new WeakHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static boolean f906a;

    /* renamed from: a  reason: collision with other field name */
    private String f907a;
    private String b;

    private ax(String str) {
        this.f907a = str;
    }

    private static int a(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return a.getPackageManager().getPackageUid(str, 0);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    private static NotificationManager a() {
        return (NotificationManager) a.getSystemService("notification");
    }

    public static ax a(Context context, String str) {
        a(context);
        int hashCode = str.hashCode();
        ax axVar = f905a.get(Integer.valueOf(hashCode));
        if (axVar == null) {
            ax axVar2 = new ax(str);
            f905a.put(Integer.valueOf(hashCode), axVar2);
            return axVar2;
        }
        return axVar;
    }

    private static <T> T a(Object obj) {
        if (obj != null) {
            try {
                return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private static Object a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a2 = a("mipush|%s|%s", str2, "");
        return str.startsWith(a2) ? a("mipush_%s_%s", str2, str.replace(a2, "")) : str;
    }

    private static String a(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) ? "" : String.format(str, str2, str3);
    }

    private static void a(Context context) {
        if (a == null) {
            a = context.getApplicationContext();
            NotificationManager a2 = a();
            Boolean bool = (Boolean) com.xiaomi.push.bk.a((Object) a2, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m1179a("fwk is support.init:" + bool);
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            f906a = booleanValue;
            if (booleanValue) {
                f904a = com.xiaomi.push.bk.a((Object) a2, "getService", new Object[0]);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    static void m1179a(String str) {
        AbstractC7535b.m586a("NMHelper:" + str);
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m1180a() {
        if (C7688m.m1118a() && ba.a(a).a(ho.NotificationBelongToAppSwitch.a(), true)) {
            return f906a;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1181a(Context context) {
        a(context);
        return m1180a();
    }

    /* renamed from: a  reason: collision with other method in class */
    private StatusBarNotification[] m1182a() {
        if (C7688m.m1119a(m1184a())) {
            try {
                Object a2 = com.xiaomi.push.bk.a(f904a, "getActiveNotifications", m1184a().getPackageName());
                if (a2 instanceof StatusBarNotification[]) {
                    return (StatusBarNotification[]) a2;
                }
                return null;
            } catch (Throwable th) {
                m1179a("getAllNotifications error " + th);
                return null;
            }
        }
        return null;
    }

    private String b(String str) {
        return a(m1180a() ? "mipush|%s|%s" : "mipush_%s_%s", this.f907a, str);
    }

    @TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public NotificationChannel m1183a(String str) {
        NotificationChannel notificationChannel = null;
        try {
            if (m1180a()) {
                List<NotificationChannel> m1187a = m1187a();
                if (m1187a != null) {
                    for (NotificationChannel notificationChannel2 : m1187a) {
                        if (str.equals(notificationChannel2.getId())) {
                            notificationChannel = notificationChannel2;
                            break;
                        }
                    }
                }
            } else {
                notificationChannel = a().getNotificationChannel(str);
            }
        } catch (Exception e) {
            m1179a("getNotificationChannel error" + e);
        }
        return notificationChannel;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Context m1184a() {
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m1185a() {
        return this.f907a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m1186a(String str) {
        return TextUtils.isEmpty(str) ? b() : C7688m.m1119a(m1184a()) ? b(str) : str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0036
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @android.annotation.TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    java.util.List<android.app.NotificationChannel> m1187a() {
        /*
            r8 = this;
            java.lang.String r0 = r8.f907a
            r1 = 0
            boolean r2 = m1180a()     // Catch: java.lang.Exception -> L78
            if (r2 == 0) goto L3b
            int r2 = a(r0)     // Catch: java.lang.Exception -> L78
            r3 = -1
            if (r2 == r3) goto L39
            java.lang.Object r3 = com.xiaomi.push.service.ax.f904a     // Catch: java.lang.Exception -> L78
            java.lang.String r4 = "getNotificationChannelsForPackage"
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L78
            r6 = 0
            r5[r6] = r0     // Catch: java.lang.Exception -> L78
            r6 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L78
            r5[r6] = r2     // Catch: java.lang.Exception -> L78
            r2 = 2
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> L78
            r5[r2] = r6     // Catch: java.lang.Exception -> L78
            java.lang.Object r2 = com.xiaomi.push.bk.a(r3, r4, r5)     // Catch: java.lang.Exception -> L78
            java.lang.Object r2 = a(r2)     // Catch: java.lang.Exception -> L78
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Exception -> L78
            java.lang.String r1 = "mipush|%s|%s"
            r7 = r2
            r2 = r1
            r1 = r7
            goto L45
        L36:
            r0 = move-exception
            r1 = r2
            goto L79
        L39:
            r2 = r1
            goto L45
        L3b:
            android.app.NotificationManager r2 = a()     // Catch: java.lang.Exception -> L78
            java.util.List r1 = r2.getNotificationChannels()     // Catch: java.lang.Exception -> L78
            java.lang.String r2 = "mipush_%s_%s"
        L45:
            boolean r3 = com.xiaomi.push.C7688m.m1118a()     // Catch: java.lang.Exception -> L78
            if (r3 == 0) goto L8d
            if (r1 == 0) goto L8d
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Exception -> L78
            r3.<init>()     // Catch: java.lang.Exception -> L78
            java.lang.String r4 = ""
            java.lang.String r0 = a(r2, r0, r4)     // Catch: java.lang.Exception -> L78
            java.util.Iterator r2 = r1.iterator()     // Catch: java.lang.Exception -> L78
        L5c:
            boolean r4 = r2.hasNext()     // Catch: java.lang.Exception -> L78
            if (r4 == 0) goto L76
            java.lang.Object r4 = r2.next()     // Catch: java.lang.Exception -> L78
            android.app.NotificationChannel r4 = (android.app.NotificationChannel) r4     // Catch: java.lang.Exception -> L78
            java.lang.String r5 = r4.getId()     // Catch: java.lang.Exception -> L78
            boolean r5 = r5.startsWith(r0)     // Catch: java.lang.Exception -> L78
            if (r5 == 0) goto L5c
            r3.add(r4)     // Catch: java.lang.Exception -> L78
            goto L5c
        L76:
            r1 = r3
            goto L8d
        L78:
            r0 = move-exception
        L79:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getNotificationChannels error "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            m1179a(r0)
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ax.m1187a():java.util.List");
    }

    public void a(int i) {
        String str = this.f907a;
        try {
            if (!m1180a()) {
                a().cancel(i);
                return;
            }
            int a2 = C7680j.a();
            String packageName = m1184a().getPackageName();
            if (Build.VERSION.SDK_INT >= 30) {
                com.xiaomi.push.bk.b(f904a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i), Integer.valueOf(a2));
            } else {
                com.xiaomi.push.bk.b(f904a, "cancelNotificationWithTag", str, null, Integer.valueOf(i), Integer.valueOf(a2));
            }
            m1179a("cancel succ:" + i);
        } catch (Exception e) {
            m1179a("cancel error" + e);
        }
    }

    public void a(int i, Notification notification) {
        String str = this.f907a;
        NotificationManager a2 = a();
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (m1180a()) {
                if (i2 >= 19) {
                    notification.extras.putString("xmsf_target_package", str);
                }
                if (i2 >= 29) {
                    a2.notifyAsPackage(str, null, i, notification);
                    return;
                }
            }
            a2.notify(i, notification);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(26)
    public void a(NotificationChannel notificationChannel) {
        String str = this.f907a;
        try {
            if (m1180a()) {
                int a2 = a(str);
                if (a2 != -1) {
                    com.xiaomi.push.bk.b(f904a, "createNotificationChannelsForPackage", str, Integer.valueOf(a2), a(Arrays.asList(notificationChannel)));
                }
            } else {
                a().createNotificationChannel(notificationChannel);
            }
        } catch (Exception e) {
            m1179a("createNotificationChannel error" + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f907a;
        try {
            if (z) {
                int a2 = a(str);
                if (a2 != -1) {
                    com.xiaomi.push.bk.b(f904a, "updateNotificationChannelForPackage", str, Integer.valueOf(a2), notificationChannel);
                }
            } else {
                a(notificationChannel);
            }
        } catch (Exception e) {
            m1179a("updateNotificationChannel error " + e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1188a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(b(""));
    }

    String b() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = b("default");
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b(String str, String str2) {
        return m1180a() ? str : str2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public List<StatusBarNotification> m1189b() {
        String str = this.f907a;
        NotificationManager a2 = a();
        ArrayList arrayList = null;
        try {
            if (m1180a()) {
                int a3 = C7680j.a();
                if (a3 != -1) {
                    return (List) a(com.xiaomi.push.bk.a(f904a, "getAppActiveNotifications", str, Integer.valueOf(a3)));
                }
                return null;
            }
            StatusBarNotification[] activeNotifications = Build.VERSION.SDK_INT >= 23 ? a2.getActiveNotifications() : m1182a();
            boolean m1118a = C7688m.m1118a();
            if (activeNotifications == null || activeNotifications.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (!m1118a || str.equals(ay.c(statusBarNotification.getNotification()))) {
                        arrayList2.add(statusBarNotification);
                    }
                }
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                arrayList = arrayList2;
                m1179a("getActiveNotifications error " + th);
                return arrayList;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f907a + "}";
    }
}
