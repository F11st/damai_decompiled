package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7784t;
import com.xiaomi.push.C7786v;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bj;
import com.xiaomi.push.bk;
import com.xiaomi.push.bo;
import com.xiaomi.push.service.ba;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.mipush.sdk.i */
/* loaded from: classes11.dex */
public class C7572i {
    private static HashMap<String, String> a = new HashMap<>();

    public static int a() {
        Integer num = (Integer) bk.a("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int a(Context context, EnumC7568e enumC7568e, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(enumC7568e);
        String string = sharedPreferences.getString(a2, "");
        String m637c = C7564b.m629a(context).m637c();
        String string2 = sharedPreferences.getString("last_check_token", "");
        if (TextUtils.isEmpty(a2)) {
            AbstractC7535b.m586a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return 0;
        } else if (TextUtils.isEmpty(string)) {
            return 1;
        } else {
            if (string.equals(str)) {
                if (TextUtils.equals(m637c, string2)) {
                    if (m654a(enumC7568e)) {
                        if (a() != sharedPreferences.getInt(b(enumC7568e), 0)) {
                            return 4;
                        }
                    }
                    return 0;
                }
                return 3;
            }
            return 2;
        }
    }

    public static MiPushMessage a(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.setMessageId(jSONObject.getString("messageId"));
                }
                if (jSONObject.has(SocialConstants.PARAM_COMMENT)) {
                    miPushMessage.setDescription(jSONObject.getString(SocialConstants.PARAM_COMMENT));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has("content")) {
                    miPushMessage.setContent(jSONObject.getString("content"));
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.setPassThrough(jSONObject.getInt("passThrough"));
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.setNotifyType(jSONObject.getInt("notifyType"));
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has("alias")) {
                    miPushMessage.setAlias(jSONObject.getString("alias"));
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.setTopic(jSONObject.getString("topic"));
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.setUserAccount(jSONObject.getString("user_account"));
                }
                if (jSONObject.has(RemoteMessageConst.Notification.NOTIFY_ID)) {
                    miPushMessage.setNotifyId(jSONObject.getInt(RemoteMessageConst.Notification.NOTIFY_ID));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.setNotified(jSONObject.getBoolean("isNotified"));
                }
                if (jSONObject.has("extra")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    if (hashMap.size() > 0) {
                        miPushMessage.setExtra(hashMap);
                    }
                }
            } catch (Exception e) {
                AbstractC7535b.d(e.toString());
            }
        }
        return miPushMessage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static PushMessageReceiver a(Context context) {
        ResolveInfo resolveInfo;
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                while (it.hasNext()) {
                    resolveInfo = it.next();
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null && activityInfo.packageName.equals(context.getPackageName())) {
                        break;
                    }
                }
            }
            resolveInfo = null;
            if (resolveInfo != null) {
                return (PushMessageReceiver) C7786v.a(context, resolveInfo.activityInfo.name).newInstance();
            }
            return null;
        } catch (Exception e) {
            AbstractC7535b.d(e.toString());
            return null;
        }
    }

    static String a(Context context, EnumC7568e enumC7568e) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(enumC7568e);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return sharedPreferences.getString(a2, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized String a(Context context, String str) {
        String str2;
        synchronized (C7572i.class) {
            str2 = a.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
        }
        return str2;
    }

    public static String a(EnumC7568e enumC7568e) {
        int i = C7574k.a[enumC7568e.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return "ftos_push_token";
                }
                return "cos_push_token";
            }
            return "fcm_push_token_v2";
        }
        return "hms_push_token";
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
        if (r12 != 0) goto L15;
     */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.HashMap<java.lang.String, java.lang.String> m648a(android.content.Context r11, com.xiaomi.mipush.sdk.EnumC7568e r12) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.C7572i.m648a(android.content.Context, com.xiaomi.mipush.sdk.e):java.util.HashMap");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public static void m649a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(EnumC7568e.ASSEMBLE_PUSH_HUAWEI);
        String a3 = a(EnumC7568e.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(a2, "")) && TextUtils.isEmpty(sharedPreferences.getString(a3, ""))) {
            z = true;
        }
        if (z) {
            ao.a(context).a(2, a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m650a(Context context, EnumC7568e enumC7568e) {
        String a2 = a(enumC7568e);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        C7784t.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, ""));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m651a(Context context, EnumC7568e enumC7568e, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int a2 = a(context, enumC7568e, str);
        if (a2 == 0) {
            AbstractC7535b.m586a("ASSEMBLE_PUSH : do not need to send token");
            return;
        }
        AbstractC7535b.m586a("ASSEMBLE_PUSH : send token upload, check:" + a2);
        a(enumC7568e, str);
        au a3 = C7575l.a(enumC7568e);
        if (a3 == null) {
            return;
        }
        ao.a(context).a((String) null, a3, enumC7568e);
    }

    public static void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra(PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
    }

    private static synchronized void a(EnumC7568e enumC7568e, String str) {
        synchronized (C7572i.class) {
            String a2 = a(enumC7568e);
            if (TextUtils.isEmpty(a2)) {
                AbstractC7535b.m586a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            } else if (TextUtils.isEmpty(str)) {
                AbstractC7535b.m586a("ASSEMBLE_PUSH : token is null");
            } else {
                a.put(a2, str);
            }
        }
    }

    public static void a(String str, int i) {
        MiTinyDataClient.upload("hms_push_error", str, 1L, "error code = " + i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m652a(Context context) {
        if (context == null) {
            return false;
        }
        return bj.b(context);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m653a(Context context, EnumC7568e enumC7568e) {
        if (C7575l.m656a(enumC7568e) != null) {
            return ba.a(context).a(C7575l.m656a(enumC7568e).a(), true);
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m654a(EnumC7568e enumC7568e) {
        return enumC7568e == EnumC7568e.ASSEMBLE_PUSH_FTOS || enumC7568e == EnumC7568e.ASSEMBLE_PUSH_FCM;
    }

    public static boolean a(Cif cif, EnumC7568e enumC7568e) {
        if (cif == null || cif.m1022a() == null || cif.m1022a().m989a() == null) {
            return false;
        }
        return (enumC7568e == EnumC7568e.ASSEMBLE_PUSH_FCM ? "FCM" : "").equalsIgnoreCase(cif.m1022a().m989a().get("assemble_push_type"));
    }

    public static byte[] a(Context context, Cif cif, EnumC7568e enumC7568e) {
        if (a(cif, enumC7568e)) {
            return bo.m702a(a(context, enumC7568e));
        }
        return null;
    }

    public static String b(EnumC7568e enumC7568e) {
        return a(enumC7568e) + "_version";
    }

    public static void b(Context context) {
        C7569f.a(context).register();
    }

    public static void b(Context context, EnumC7568e enumC7568e, String str) {
        com.xiaomi.push.al.a(context).a(new RunnableC7573j(str, context, enumC7568e));
    }

    public static String c(EnumC7568e enumC7568e) {
        int i = C7574k.a[enumC7568e.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return "ftos_push_error";
                }
                return "cos_push_error";
            }
            return "fcm_push_error";
        }
        return "hms_push_error";
    }

    public static void c(Context context) {
        C7569f.a(context).unregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(Context context, EnumC7568e enumC7568e, String str) {
        synchronized (C7572i.class) {
            String a2 = a(enumC7568e);
            if (TextUtils.isEmpty(a2)) {
                AbstractC7535b.m586a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(a2, str).putString("last_check_token", C7564b.m629a(context).m637c());
            if (m654a(enumC7568e)) {
                edit.putInt(b(enumC7568e), a());
            }
            C7784t.a(edit);
            AbstractC7535b.m586a("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }
}
