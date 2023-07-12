package com.vivo.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.AbstractC7498q;
import com.vivo.push.C7481e;
import com.vivo.push.b.C7436x;
import com.vivo.push.c.C7443d;
import com.vivo.push.util.C7508a;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7527t;
import com.vivo.push.util.C7528u;
import com.vivo.push.util.C7533z;
import com.vivo.push.util.ContextDelegate;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.sdk.a */
/* loaded from: classes11.dex */
public final class C7501a extends AbstractC7498q {
    private static C7501a c;
    private static final List<Integer> e = Arrays.asList(3);
    private String d;
    private String f = "";

    private C7501a() {
    }

    public static synchronized C7501a a() {
        C7501a c7501a;
        synchronized (C7501a.class) {
            if (c == null) {
                c = new C7501a();
            }
            c7501a = c;
        }
        return c7501a;
    }

    private boolean c(Intent intent) {
        if (Build.VERSION.SDK_INT < 18) {
            return true;
        }
        String c2 = C7533z.c(this.a, "com.vivo.pushservice");
        C7523p.d("CommandWorker", " 配置的验签参数 = ".concat(String.valueOf(c2)));
        if (TextUtils.equals(c2, "1")) {
            String stringExtra = intent.getStringExtra("security_avoid_pull_rsa");
            String stringExtra2 = intent.getStringExtra("security_avoid_rsa_public_key");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                try {
                    if (C7443d.a(this.a).a().a("com.vivo.pushservice".getBytes("UTF-8"), C7528u.a(stringExtra2), Base64.decode(stringExtra, 2))) {
                        C7523p.d("CommandWorker", " RSA验签通过  ");
                        return true;
                    }
                } catch (Exception e2) {
                    C7523p.a("CommandWorker", "checkIntentIsSecurity Exception: " + e2.getMessage());
                }
                C7523p.d("CommandWorker", " RSA验签 不通过  ");
                return false;
            }
            C7523p.a("CommandWorker", "!decrypt.equals, so securityContent == " + stringExtra + " or publickKey isempty ");
            return false;
        }
        return true;
    }

    private int d(Intent intent) {
        String stringExtra;
        if (!TextUtils.isEmpty(this.f) && this.f.contains("CommandService")) {
            if (!(intent != null && b(intent) && c(intent))) {
                C7523p.a("CommandWorker", " !checkIntentIsSecurity(intent)");
                return 2151;
            }
        }
        String packageName = this.a.getPackageName();
        try {
            stringExtra = intent.getStringExtra("command_type");
        } catch (Exception e2) {
            C7523p.a("CommandWorker", e2);
        }
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
            int intExtra = intent.getIntExtra("command", -1);
            if (intExtra < 0) {
                intExtra = intent.getIntExtra("method", -1);
            }
            if (e.contains(Integer.valueOf(intExtra)) && C7527t.c(this.a, packageName) && !C7527t.c(this.a)) {
                C7523p.a("CommandWorker", "METHOD_ON_MESSAGE is not support");
                return 2153;
            }
            String action = intent.getAction();
            if (TextUtils.isEmpty(this.d)) {
                String a = a(this.a, packageName, action);
                this.d = a;
                if (TextUtils.isEmpty(a)) {
                    C7523p.d("CommandWorker", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                    intent.setPackage(packageName);
                    this.a.sendBroadcast(intent);
                    return 2152;
                }
            }
            return 0;
        }
        C7523p.a("CommandWorker", "commandTypeStr is not satisfy == ".concat(String.valueOf(stringExtra)));
        return 2151;
    }

    public final void b() {
        this.d = null;
    }

    @Override // com.vivo.push.AbstractC7498q
    public final void b(Message message) {
        Context context;
        Intent intent = (Intent) message.obj;
        if (intent != null && (context = this.a) != null) {
            String packageName = context.getPackageName();
            int d = d(intent);
            if (d > 0) {
                C7436x c7436x = new C7436x(d);
                HashMap<String, String> hashMap = new HashMap<>();
                Bundle extras = intent.getExtras();
                hashMap.put("messageID", String.valueOf(extras != null ? extras.getLong("notify_id", 404000044642424832L) : 404000044642424832L));
                String b = C7533z.b(this.a, packageName);
                if (!TextUtils.isEmpty(b)) {
                    hashMap.put("remoteAppId", b);
                }
                c7436x.a(hashMap);
                C7481e.a().a(c7436x);
                return;
            }
            try {
                Class<?> cls = Class.forName(this.d);
                Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                Method method = cls.getMethod("onReceive", Context.class, Intent.class);
                intent.setClassName(packageName, this.d);
                method.invoke(newInstance, ContextDelegate.getContext(this.a).getApplicationContext(), intent);
                return;
            } catch (Exception e2) {
                C7523p.b("CommandWorker", "reflect e: ", e2);
                return;
            }
        }
        C7523p.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.a);
    }

    public final void a(String str) {
        this.f = str;
    }

    public final void a(Intent intent) {
        if (intent != null && this.a != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            a(obtain);
            return;
        }
        C7523p.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.a);
    }

    private static String a(Context context, String str, String str2) {
        List<ResolveInfo> queryBroadcastReceivers;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) == null || queryBroadcastReceivers.size() <= 0) {
                return null;
            }
            return queryBroadcastReceivers.get(0).activityInfo.name;
        } catch (Exception e2) {
            C7523p.a("CommandWorker", "error  " + e2.getMessage());
            return null;
        }
    }

    private boolean b(Intent intent) {
        String stringExtra = intent.getStringExtra("security_avoid_pull");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                String b = C7508a.a(this.a).b(stringExtra);
                if ("com.vivo.pushservice".equals(b)) {
                    return true;
                }
                C7523p.a("CommandWorker", "!decrypt.equals, so decrypt == ".concat(String.valueOf(b)));
                return false;
            } catch (Exception e2) {
                C7523p.a("CommandWorker", "checkIntentIsSecurity Exception: " + e2.getMessage());
                return false;
            }
        }
        C7523p.a("CommandWorker", "checkIntentIsSecurityTextUtils.isEmpty");
        return true;
    }
}
