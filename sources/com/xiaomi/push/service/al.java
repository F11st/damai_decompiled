package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.weex.annotation.JSMethod;
import com.xiaomi.push.Cif;
import com.xiaomi.push.eo;
import com.xiaomi.push.ep;
import com.xiaomi.push.eq;
import com.xiaomi.push.er;
import com.xiaomi.push.h;
import com.xiaomi.push.hj;
import com.xiaomi.push.hw;
import com.xiaomi.push.service.aw;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class al {
    public static long a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile as f881a;

    /* renamed from: a  reason: collision with other field name */
    private static final LinkedList<Pair<Integer, Cif>> f882a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f883a = Executors.newCachedThreadPool();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements Callable<Bitmap> {
        private Context a;

        /* renamed from: a  reason: collision with other field name */
        private String f884a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f885a;

        public a(String str, Context context, boolean z) {
            this.a = context;
            this.f884a = str;
            this.f885a = z;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Bitmap call() {
            Bitmap bitmap = null;
            if (TextUtils.isEmpty(this.f884a)) {
                com.xiaomi.channel.commonutils.logger.b.m586a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            }
            if (this.f884a.startsWith("http")) {
                aw.b a = aw.a(this.a, this.f884a, this.f885a);
                if (a != null) {
                    return a.f903a;
                }
            } else {
                bitmap = aw.a(this.a, this.f884a);
                if (bitmap != null) {
                    return bitmap;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m586a("Failed get online picture/icon resource");
            return bitmap;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b {
        long a = 0;

        /* renamed from: a  reason: collision with other field name */
        Notification f886a;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class c {

        /* renamed from: a  reason: collision with other field name */
        public String f887a;
        public long a = 0;

        /* renamed from: a  reason: collision with other field name */
        public boolean f888a = false;
    }

    static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    private static int a(Context context, String str, Map<String, String> map, int i) {
        ComponentName a2;
        Intent b2 = b(context, str, map, i);
        if (b2 == null || (a2 = l.a(context, b2)) == null) {
            return 0;
        }
        return a2.hashCode();
    }

    private static int a(Map<String, String> map) {
        String str = map == null ? null : map.get("timeout");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static Notification a(Notification notification) {
        Object a2 = com.xiaomi.push.bk.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.push.bk.a(a2, "setCustomizedIcon", Boolean.TRUE);
        }
        return notification;
    }

    private static PendingIntent a(Context context, Cif cif, String str, byte[] bArr, int i) {
        return a(context, cif, str, bArr, i, 0, a(context, cif, str));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.app.PendingIntent a(android.content.Context r16, com.xiaomi.push.Cif r17, java.lang.String r18, byte[] r19, int r20, int r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.al.a(android.content.Context, com.xiaomi.push.if, java.lang.String, byte[], int, int, boolean):android.app.PendingIntent");
    }

    private static PendingIntent a(Context context, String str, Cif cif, byte[] bArr, int i, int i2) {
        Map<String, String> m989a = cif.m1022a().m989a();
        if (m989a == null) {
            return null;
        }
        boolean a2 = a(context, cif, str);
        if (a2) {
            return a(context, cif, str, bArr, i, i2, a2);
        }
        Intent m1162a = m1162a(context, str, m989a, i2);
        if (m1162a != null) {
            return PendingIntent.getActivity(context, 0, m1162a, Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728);
        }
        return null;
    }

    public static ComponentName a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Intent m1162a(Context context, String str, Map<String, String> map, int i) {
        if (m1172b(map)) {
            return a(context, str, map, String.format("cust_btn_%s_ne", Integer.valueOf(i)), String.format("cust_btn_%s_iu", Integer.valueOf(i)), String.format("cust_btn_%s_ic", Integer.valueOf(i)), String.format("cust_btn_%s_wu", Integer.valueOf(i)));
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return a(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
                }
                return a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
            }
            return a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
        }
        return a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.Intent a(android.content.Context r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.al.a(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.content.Intent");
    }

    private static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    private static Bitmap a(Context context, String str, boolean z) {
        Future submit = f883a.submit(new a(str, context, z));
        try {
            try {
                Bitmap bitmap = (Bitmap) submit.get(180L, TimeUnit.SECONDS);
                return bitmap == null ? bitmap : bitmap;
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                submit.cancel(true);
                return null;
            }
        } finally {
            submit.cancel(true);
        }
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight > 0 ? intrinsicHeight : 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static RemoteViews a(Context context, Cif cif, byte[] bArr) {
        hw m1022a = cif.m1022a();
        String a2 = a(cif);
        if (m1022a != null && m1022a.m989a() != null) {
            Map<String, String> m989a = m1022a.m989a();
            String str = m989a.get("layout_name");
            String str2 = m989a.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a2);
                    int identifier = resourcesForApplication.getIdentifier(str, "layout", a2);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(a2, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has("text")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", a2);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has("image")) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                            Iterator<String> keys2 = jSONObject3.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                String string2 = jSONObject3.getString(next2);
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", a2);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", a2);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has("time")) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                            Iterator<String> keys3 = jSONObject4.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                String string3 = jSONObject4.getString(next3);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", a2);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (JSONException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
        }
        return null;
    }

    @TargetApi(16)
    private static eq a(Context context, Cif cif, byte[] bArr, String str, int i) {
        PendingIntent a2;
        String a3 = a(cif);
        Map<String, String> m989a = cif.m1022a().m989a();
        String str2 = m989a.get("notification_style_type");
        eq a4 = (!com.xiaomi.push.m.m1119a(context) || f881a == null) ? null : f881a.a(context, i, a3, m989a);
        if (a4 != null) {
            a4.a(m989a);
            return a4;
        } else if ("2".equals(str2)) {
            eq eqVar = new eq(context);
            Bitmap a5 = TextUtils.isEmpty(m989a.get("notification_bigPic_uri")) ? null : a(context, m989a.get("notification_bigPic_uri"), false);
            if (a5 == null) {
                com.xiaomi.channel.commonutils.logger.b.m586a("can not get big picture.");
                return eqVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(eqVar);
            bigPictureStyle.bigPicture(a5);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            eqVar.setStyle(bigPictureStyle);
            return eqVar;
        } else if ("1".equals(str2)) {
            eq eqVar2 = new eq(context);
            eqVar2.setStyle(new Notification.BigTextStyle().bigText(str));
            return eqVar2;
        } else if ("4".equals(str2) && com.xiaomi.push.m.m1118a()) {
            ep epVar = new ep(context, a3);
            if (!TextUtils.isEmpty(m989a.get("notification_banner_image_uri"))) {
                epVar.a(a(context, m989a.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty(m989a.get("notification_banner_icon_uri"))) {
                epVar.b(a(context, m989a.get("notification_banner_icon_uri"), false));
            }
            epVar.a(m989a);
            return epVar;
        } else if ("3".equals(str2) && com.xiaomi.push.m.m1118a()) {
            er erVar = new er(context, i, a3);
            if (!TextUtils.isEmpty(m989a.get("notification_colorful_button_text")) && (a2 = a(context, a3, cif, bArr, i, 4)) != null) {
                erVar.a(m989a.get("notification_colorful_button_text"), a2).mo863a(m989a.get("notification_colorful_button_bg_color"));
            }
            if (!TextUtils.isEmpty(m989a.get("notification_colorful_bg_color"))) {
                erVar.b(m989a.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty(m989a.get("notification_colorful_bg_image_uri"))) {
                erVar.a(a(context, m989a.get("notification_colorful_bg_image_uri"), false));
            }
            erVar.a(m989a);
            return erVar;
        } else {
            return new eq(context);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x025c  */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v50 */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.xiaomi.push.service.al.b a(android.content.Context r26, com.xiaomi.push.Cif r27, byte[] r28, android.widget.RemoteViews r29, android.app.PendingIntent r30, int r31) {
        /*
            Method dump skipped, instructions count: 1213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.al.a(android.content.Context, com.xiaomi.push.if, byte[], android.widget.RemoteViews, android.app.PendingIntent, int):com.xiaomi.push.service.al$b");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static c m1163a(Context context, Cif cif, byte[] bArr) {
        int i;
        Map<String, String> map;
        String str;
        c cVar = new c();
        h.a a2 = com.xiaomi.push.h.a(context, a(cif), true);
        hw m1022a = cif.m1022a();
        if (m1022a != null) {
            i = m1022a.c();
            map = m1022a.m989a();
        } else {
            i = 0;
            map = null;
        }
        int b2 = com.xiaomi.push.w.b(a(cif), i);
        if (com.xiaomi.push.m.m1119a(context) && a2 == h.a.NOT_ALLOWED) {
            if (m1022a != null) {
                eo.a(context.getApplicationContext()).a(cif.b(), b(cif), m1022a.m988a(), "10:" + a(cif));
            }
            str = "Do not notify because user block " + a(cif) + "‘s notification";
        } else if (com.xiaomi.push.m.m1119a(context) && f881a != null && f881a.m1174a(context, b2, a(cif), map)) {
            if (m1022a != null) {
                eo.a(context.getApplicationContext()).a(cif.b(), b(cif), m1022a.m988a(), "14:" + a(cif));
            }
            str = "Do not notify because card notification is canceled or sequence incorrect";
        } else {
            RemoteViews a3 = a(context, cif, bArr);
            PendingIntent a4 = a(context, cif, cif.b(), bArr, b2);
            if (a4 != null) {
                b a5 = a(context, cif, bArr, a3, a4, b2);
                cVar.a = a5.a;
                cVar.f887a = a(cif);
                Notification notification = a5.f886a;
                if (com.xiaomi.push.m.m1118a()) {
                    if (!TextUtils.isEmpty(m1022a.m988a())) {
                        notification.extras.putString("message_id", m1022a.m988a());
                    }
                    notification.extras.putString("local_paid", cif.m1023a());
                    ay.a(map, notification.extras, "msg_busi_type");
                    ay.a(map, notification.extras, "disable_notification_flags");
                    String str2 = m1022a.m994b() == null ? null : m1022a.m994b().get("score_info");
                    if (!TextUtils.isEmpty(str2)) {
                        notification.extras.putString("score_info", str2);
                    }
                    notification.extras.putString("pushUid", a(m1022a.f532a, "n_stats_expose"));
                    int i2 = -1;
                    if (c(cif)) {
                        i2 = 1000;
                    } else if (m1167a(cif)) {
                        i2 = 3000;
                    }
                    notification.extras.putString("eventMessageType", String.valueOf(i2));
                    notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, a(cif));
                }
                String str3 = m1022a.m989a() != null ? m1022a.m989a().get("message_count") : null;
                if (com.xiaomi.push.m.m1118a() && str3 != null) {
                    try {
                        ay.a(notification, Integer.parseInt(str3));
                    } catch (NumberFormatException e) {
                        eo.a(context.getApplicationContext()).b(cif.b(), b(cif), m1022a.m988a(), "8");
                        com.xiaomi.channel.commonutils.logger.b.d("fail to set message count. " + e);
                    }
                }
                String a6 = a(cif);
                if (!com.xiaomi.push.m.m1123c() && com.xiaomi.push.m.m1119a(context)) {
                    ay.m1190a(notification, a6);
                }
                ax a7 = ax.a(context, a6);
                if (com.xiaomi.push.m.m1119a(context) && f881a != null) {
                    f881a.a(cif, m1022a.m989a(), b2, notification);
                }
                if (com.xiaomi.push.m.m1119a(context) && f881a != null && f881a.a(m1022a.m989a(), b2, notification)) {
                    com.xiaomi.channel.commonutils.logger.b.b("consume this notificaiton by agent");
                } else {
                    a7.a(b2, notification);
                    cVar.f888a = true;
                    com.xiaomi.channel.commonutils.logger.b.m586a("notification: " + m1022a.m988a() + " is notifyied");
                }
                if (com.xiaomi.push.m.m1118a() && com.xiaomi.push.m.m1119a(context)) {
                    au.a().a(context, b2, notification);
                    cc.m1214a(context, a6, b2, m1022a.m988a(), notification);
                }
                if (m1167a(cif)) {
                    eo.a(context.getApplicationContext()).a(cif.b(), b(cif), m1022a.m988a(), 3002, null);
                }
                if (c(cif)) {
                    eo.a(context.getApplicationContext()).a(cif.b(), b(cif), m1022a.m988a(), 1002, null);
                }
                if (Build.VERSION.SDK_INT < 26) {
                    String m988a = m1022a.m988a();
                    com.xiaomi.push.al a8 = com.xiaomi.push.al.a(context);
                    int a9 = a(m1022a.m989a());
                    if (a9 > 0 && !TextUtils.isEmpty(m988a)) {
                        String str4 = "n_timeout_" + m988a;
                        a8.m665a(str4);
                        a8.b(new am(str4, a7, b2), a9);
                    }
                }
                Pair<Integer, Cif> pair = new Pair<>(Integer.valueOf(b2), cif);
                LinkedList<Pair<Integer, Cif>> linkedList = f882a;
                synchronized (linkedList) {
                    linkedList.add(pair);
                    if (linkedList.size() > 100) {
                        linkedList.remove();
                    }
                }
                return cVar;
            }
            if (m1022a != null) {
                eo.a(context.getApplicationContext()).a(cif.b(), b(cif), m1022a.m988a(), "11");
            }
            str = "The click PendingIntent is null. ";
        }
        com.xiaomi.channel.commonutils.logger.b.m586a(str);
        return cVar;
    }

    private static String a(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? com.xiaomi.push.h.m944b(context, str) : map.get("channel_name");
    }

    public static String a(Cif cif) {
        hw m1022a;
        if ("com.xiaomi.xmsf".equals(cif.f624b) && (m1022a = cif.m1022a()) != null && m1022a.m989a() != null) {
            String str = m1022a.m989a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return cif.f624b;
    }

    public static String a(Map<String, String> map, int i) {
        String format = i == 0 ? "notify_effect" : m1172b(map) ? String.format("cust_btn_%s_ne", Integer.valueOf(i)) : i == 1 ? "notification_style_button_left_notify_effect" : i == 2 ? "notification_style_button_mid_notify_effect" : i == 3 ? "notification_style_button_right_notify_effect" : i == 4 ? "notification_colorful_button_notify_effect" : null;
        if (map == null || format == null) {
            return null;
        }
        return map.get(format);
    }

    private static String a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    private static void a(Context context, Intent intent, Cif cif, hw hwVar, String str, int i) {
        if (cif == null || hwVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = a(hwVar.m989a(), i);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (bk.a.equals(a2) || bk.b.equals(a2) || bk.c.equals(a2)) {
            intent.putExtra("messageId", str);
            intent.putExtra("local_paid", cif.f620a);
            if (!TextUtils.isEmpty(cif.f624b)) {
                intent.putExtra(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, cif.f624b);
            }
            intent.putExtra("job_key", a(hwVar.m989a(), "jobkey"));
            intent.putExtra(i + JSMethod.NOT_SET + "target_component", a(context, cif.f624b, hwVar.m989a(), i));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m1164a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i) {
        a(context, str, i, -1);
    }

    public static void a(Context context, String str, int i, int i2) {
        int hashCode;
        if (context == null || TextUtils.isEmpty(str) || i < -1) {
            return;
        }
        ax a2 = ax.a(context, str);
        List<StatusBarNotification> m1189b = a2.m1189b();
        if (com.xiaomi.push.w.a(m1189b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        if (i == -1) {
            hashCode = 0;
            z = true;
        } else {
            hashCode = ((str.hashCode() / 10) * 10) + i;
        }
        Iterator<StatusBarNotification> it = m1189b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StatusBarNotification next = it.next();
            if (!TextUtils.isEmpty(String.valueOf(next.getId()))) {
                int id = next.getId();
                if (z) {
                    linkedList.add(next);
                    a2.a(id);
                } else if (hashCode == id) {
                    d.a(context, next, i2);
                    linkedList.add(next);
                    a2.a(id);
                    break;
                }
            }
        }
        a(context, linkedList);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        ax a2 = ax.a(context, str);
        List<StatusBarNotification> m1189b = a2.m1189b();
        if (com.xiaomi.push.w.a(m1189b)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (StatusBarNotification statusBarNotification : m1189b) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                int id = statusBarNotification.getId();
                String a3 = ay.a(notification);
                String b2 = ay.b(notification);
                if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(b2) && a(a3, str2) && a(b2, str3)) {
                    linkedList.add(statusBarNotification);
                    a2.a(id);
                }
            }
        }
        a(context, linkedList);
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        bz.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    private static void a(Intent intent) {
        try {
            Method declaredMethod = intent.getClass().getDeclaredMethod("addMiuiFlags", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(intent, 2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.b("insert flags error " + e);
        }
    }

    @TargetApi(16)
    private static void a(eq eqVar, Context context, String str, Cif cif, byte[] bArr, int i) {
        PendingIntent a2;
        PendingIntent a3;
        PendingIntent a4;
        PendingIntent a5;
        Map<String, String> m989a = cif.m1022a().m989a();
        if (TextUtils.equals("3", m989a.get("notification_style_type")) || TextUtils.equals("4", m989a.get("notification_style_type"))) {
            return;
        }
        if (m1172b(m989a)) {
            for (int i2 = 1; i2 <= 3; i2++) {
                String str2 = m989a.get(String.format("cust_btn_%s_n", Integer.valueOf(i2)));
                if (!TextUtils.isEmpty(str2) && (a5 = a(context, str, cif, bArr, i, i2)) != null) {
                    eqVar.addAction(0, str2, a5);
                }
            }
            return;
        }
        if (!TextUtils.isEmpty(m989a.get("notification_style_button_left_name")) && (a4 = a(context, str, cif, bArr, i, 1)) != null) {
            eqVar.addAction(0, m989a.get("notification_style_button_left_name"), a4);
        }
        if (!TextUtils.isEmpty(m989a.get("notification_style_button_mid_name")) && (a3 = a(context, str, cif, bArr, i, 2)) != null) {
            eqVar.addAction(0, m989a.get("notification_style_button_mid_name"), a3);
        }
        if (TextUtils.isEmpty(m989a.get("notification_style_button_right_name")) || (a2 = a(context, str, cif, bArr, i, 3)) == null) {
            return;
        }
        eqVar.addAction(0, m989a.get("notification_style_button_right_name"), a2);
    }

    private static boolean a(Context context, Cif cif, String str) {
        if (cif != null && cif.m1022a() != null && cif.m1022a().m989a() != null && !TextUtils.isEmpty(str)) {
            return Boolean.parseBoolean(cif.m1022a().m989a().get("use_clicked_activity")) && l.a(context, a(str));
        }
        com.xiaomi.channel.commonutils.logger.b.m586a("should clicked activity params are null.");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1165a(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1166a(Context context, String str, boolean z) {
        return com.xiaomi.push.m.m1118a() && !z && m1165a(context, str);
    }

    private static boolean a(hw hwVar) {
        if (hwVar != null) {
            String m988a = hwVar.m988a();
            return !TextUtils.isEmpty(m988a) && m988a.length() == 22 && "satuigmo".indexOf(m988a.charAt(0)) >= 0;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1167a(Cif cif) {
        hw m1022a = cif.m1022a();
        return a(m1022a) && m1022a.l();
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1168a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0050, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0074, code lost:
        r1 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String[] a(android.content.Context r3, com.xiaomi.push.hw r4) {
        /*
            java.lang.String r0 = r4.m996c()
            java.lang.String r1 = r4.d()
            java.util.Map r4 = r4.m989a()
            if (r4 == 0) goto L75
            android.content.res.Resources r2 = r3.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(r2)
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            float r2 = (float) r2
            float r2 = r2 / r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            int r3 = r3.intValue()
            r2 = 320(0x140, float:4.48E-43)
            if (r3 > r2) goto L53
            java.lang.String r3 = "title_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L44
            r0 = r3
        L44:
            java.lang.String r3 = "description_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L75
            goto L74
        L53:
            r2 = 360(0x168, float:5.04E-43)
            if (r3 <= r2) goto L75
            java.lang.String r3 = "title_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L66
            r0 = r3
        L66:
            java.lang.String r3 = "description_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L75
        L74:
            r1 = r3
        L75:
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            r3[r4] = r0
            r4 = 1
            r3[r4] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.al.a(android.content.Context, com.xiaomi.push.hw):java.lang.String[]");
    }

    private static int b(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return a2 == 0 ? context.getApplicationInfo().logo : a2;
    }

    private static int b(Map<String, String> map) {
        if (map != null) {
            String str = map.get("channel_importance");
            if (TextUtils.isEmpty(str)) {
                return 3;
            }
            try {
                com.xiaomi.channel.commonutils.logger.b.c("importance=" + str);
                return Integer.parseInt(str);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("parsing channel importance error: " + e);
                return 3;
            }
        }
        return 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent b(android.content.Context r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, int r8) {
        /*
            Method dump skipped, instructions count: 427
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.al.b(android.content.Context, java.lang.String, java.util.Map, int):android.content.Intent");
    }

    public static String b(Cif cif) {
        return m1167a(cif) ? "E100002" : c(cif) ? "E100000" : m1171b(cif) ? "E100001" : d(cif) ? "E100003" : "";
    }

    /* renamed from: b  reason: collision with other method in class */
    public static void m1169b(Context context, String str) {
        if (!com.xiaomi.push.m.m1119a(context) || f881a == null || TextUtils.isEmpty(str)) {
            return;
        }
        f881a.a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    private static void b(Intent intent) {
        if (intent == null) {
            return;
        }
        int flags = intent.getFlags() & (-2) & (-3) & (-65);
        if (Build.VERSION.SDK_INT >= 21) {
            flags &= -129;
        }
        intent.setFlags(flags);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public static boolean m1170b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m1171b(Cif cif) {
        hw m1022a = cif.m1022a();
        return a(m1022a) && m1022a.f534b == 1 && !m1167a(cif);
    }

    /* renamed from: b  reason: collision with other method in class */
    private static boolean m1172b(Map<String, String> map) {
        if (map == null) {
            com.xiaomi.channel.commonutils.logger.b.m586a("meta extra is null");
            return false;
        }
        return "6".equals(map.get("notification_style_type"));
    }

    private static int c(Map<String, String> map) {
        if (map != null) {
            String str = map.get("notification_priority");
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                com.xiaomi.channel.commonutils.logger.b.c("priority=" + str);
                return Integer.parseInt(str);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("parsing notification priority error: " + e);
                return 0;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static boolean c(Cif cif) {
        hw m1022a = cif.m1022a();
        return a(m1022a) && m1022a.f534b == 0 && !m1167a(cif);
    }

    public static boolean d(Cif cif) {
        return cif.a() == hj.Registration;
    }

    public static boolean e(Cif cif) {
        return m1167a(cif) || c(cif) || m1171b(cif);
    }
}
