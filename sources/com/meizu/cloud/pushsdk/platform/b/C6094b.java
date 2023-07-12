package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.sdk.m.l.C4231b;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.b.C5927c;
import com.meizu.cloud.pushsdk.c.a.C5950c;
import com.meizu.cloud.pushsdk.c.b.C5953a;
import com.meizu.cloud.pushsdk.d.b.a.C6005b;
import com.meizu.cloud.pushsdk.platform.C6089a;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.a.C6090a;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.util.C6102b;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.platform.b.b */
/* loaded from: classes10.dex */
public class C6094b extends AbstractC6095c<RegisterStatus> {
    private Handler h;
    private ScheduledExecutorService i;
    private int j;

    public C6094b(Context context, C6090a c6090a, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, c6090a, scheduledExecutorService);
        this.i = (ScheduledExecutorService) C6005b.a();
        this.h = new Handler(context.getMainLooper()) { // from class: com.meizu.cloud.pushsdk.platform.b.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 0) {
                    C6094b.this.m();
                }
            }
        };
    }

    public C6094b(Context context, C6090a c6090a, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, c6090a, scheduledExecutorService);
        this.g = z;
    }

    public C6094b(Context context, String str, String str2, C6090a c6090a, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, c6090a, scheduledExecutorService);
        this.j = 0;
    }

    private boolean a(String str, String str2, int i) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str2.startsWith(str) || System.currentTimeMillis() / 1000 > ((long) i);
    }

    protected void a(long j) {
        this.i.schedule(new Runnable() { // from class: com.meizu.cloud.pushsdk.platform.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                C5927c.a(C6094b.this.a);
                C6094b.this.h.sendEmptyMessage(0);
            }
        }, j, TimeUnit.SECONDS);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    public void a(RegisterStatus registerStatus) {
        PlatformMessageSender.a(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), registerStatus);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    public boolean a() {
        DebugLogger.e("Strategy", "isBrandMeizu " + MzSystemUtils.isBrandMeizu(this.a));
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) ? false : true;
    }

    protected boolean a(String str, int i) {
        String a = C5927c.a(this.a);
        boolean a2 = a(a, str, i);
        return a2 ? a(a, C6089a.a(str), i) : a2;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra(C4231b.h, this.c);
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra("strategy_type", g());
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected int g() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    /* renamed from: h */
    public RegisterStatus b() {
        String str;
        RegisterStatus registerStatus = new RegisterStatus();
        registerStatus.setCode("20001");
        if (!TextUtils.isEmpty(this.b)) {
            str = TextUtils.isEmpty(this.c) ? "appKey not empty" : "appKey not empty";
            return registerStatus;
        }
        str = "appId not empty";
        registerStatus.setMessage(str);
        return registerStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    /* renamed from: i */
    public RegisterStatus f() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    /* renamed from: j */
    public RegisterStatus e() {
        RegisterStatus registerStatus = new RegisterStatus();
        String a = C6102b.a(this.a, this.d);
        int b = C6102b.b(this.a, this.d);
        if (a(a, b)) {
            C6102b.g(this.a, "", this.d);
            String a2 = C5927c.a(this.a);
            if (!TextUtils.isEmpty(a2) || this.j >= 3) {
                this.j = 0;
                C5950c a3 = this.e.a(this.b, this.c, a2);
                if (a3.b()) {
                    registerStatus = new RegisterStatus((String) a3.a());
                    DebugLogger.e("Strategy", "registerStatus " + registerStatus);
                    if (!TextUtils.isEmpty(registerStatus.getPushId())) {
                        C6102b.g(this.a, registerStatus.getPushId(), this.d);
                        C6102b.a(this.a, (int) ((System.currentTimeMillis() / 1000) + registerStatus.getExpireTime()), this.d);
                    }
                } else {
                    C5953a c = a3.c();
                    if (c.a() != null) {
                        DebugLogger.e("Strategy", "status code=" + c.b() + " data=" + c.a());
                    }
                    registerStatus.setCode(String.valueOf(c.b()));
                    registerStatus.setMessage(c.c());
                    DebugLogger.e("Strategy", "registerStatus " + registerStatus);
                }
            } else {
                DebugLogger.i("Strategy", "after " + (this.j * 10) + " seconds start register");
                a((long) (this.j * 10));
                this.j = this.j + 1;
                registerStatus.setCode("20000");
                registerStatus.setMessage("deviceId is empty");
            }
        } else {
            registerStatus.setCode("200");
            registerStatus.setMessage("already register PushId,don't register frequently");
            registerStatus.setPushId(a);
            registerStatus.setExpireTime((int) (b - (System.currentTimeMillis() / 1000)));
        }
        return registerStatus;
    }
}
