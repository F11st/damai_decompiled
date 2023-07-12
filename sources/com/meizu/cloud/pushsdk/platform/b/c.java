package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class c<T extends BasicPushStatus> {
    protected final Context a;
    protected String b;
    protected String c;
    protected String d;
    protected final com.meizu.cloud.pushsdk.platform.a.a e;
    private ScheduledExecutorService h;
    protected boolean f = true;
    protected boolean g = true;
    private String i = null;

    public c(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this.h = scheduledExecutorService;
        this.a = context;
        this.b = str;
        this.c = str2;
        this.e = aVar;
    }

    private boolean a(int i) {
        return i >= 110000 && i <= 200000;
    }

    private boolean b(T t) {
        int intValue = Integer.valueOf(t.getCode()).intValue();
        return (intValue > 200 && intValue < 600) || (intValue > 1000 && intValue < 2000) || intValue == 0;
    }

    private boolean h() {
        return this.g && !this.a.getPackageName().equals(this.i);
    }

    protected String a(Context context, String str) {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(str), 0);
            if (queryIntentServices != null) {
                Iterator<ResolveInfo> it = queryIntentServices.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ResolveInfo next = it.next();
                    if (PushConstants.PUSH_PACKAGE_NAME.equals(next.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = next.serviceInfo;
                        this.i = serviceInfo.packageName;
                        str2 = serviceInfo.name;
                        break;
                    }
                }
                if (TextUtils.isEmpty(str2) && queryIntentServices.size() > 0) {
                    this.i = queryIntentServices.get(0).serviceInfo.packageName;
                    str2 = queryIntentServices.get(0).serviceInfo.name;
                }
            }
        }
        DebugLogger.i("Strategy", "current process packageName " + this.i);
        return str2;
    }

    protected void a(Intent intent) {
        try {
            intent.setPackage(this.i);
            intent.setAction(PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION);
            this.a.startService(intent);
        } catch (Exception e) {
            DebugLogger.e("Strategy", "start RemoteService error " + e.getMessage());
        }
    }

    protected abstract void a(T t);

    public void a(boolean z) {
        this.f = z;
    }

    protected abstract boolean a();

    protected abstract T b();

    public void b(String str) {
        this.b = str;
    }

    protected abstract Intent c();

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.d = str;
    }

    protected Intent[] d() {
        return null;
    }

    protected abstract T e();

    protected abstract T f();

    protected abstract int g();

    protected boolean k() {
        return this.g && this.f && !TextUtils.isEmpty(a(this.a, PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION));
    }

    protected boolean l() {
        return 2 == g() || 32 == g();
    }

    public boolean m() {
        ScheduledExecutorService scheduledExecutorService = this.h;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.platform.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.n();
                }
            });
            return true;
        }
        return n();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean n() {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.platform.b.c.n():boolean");
    }
}
