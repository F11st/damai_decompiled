package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class f extends c<PushSwitchStatus> {
    private String h;
    private int i;
    private boolean j;
    private final Map<String, Boolean> k;

    public f(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public f(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.g = z;
    }

    public f(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.i = 0;
        this.k = new HashMap();
    }

    public f(Context context, String str, String str2, String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.h = str3;
    }

    private com.meizu.cloud.pushsdk.c.a.c<String> b(PushSwitchStatus pushSwitchStatus) {
        boolean z;
        boolean r;
        boolean p;
        int i = this.i;
        if (i != 0) {
            if (i == 1) {
                pushSwitchStatus.setMessage("SWITCH_THROUGH_MESSAGE");
                if (r() != this.j || t()) {
                    f(true);
                    d(this.j);
                    return this.e.a(this.b, this.c, this.h, this.i, this.j);
                }
                p = p();
            } else if (i != 2) {
                if (i == 3) {
                    pushSwitchStatus.setMessage("SWITCH_ALL");
                    if (p() != this.j || r() != this.j || t()) {
                        f(true);
                        e(this.j);
                        return this.e.a(this.b, this.c, this.h, this.j);
                    }
                    p = this.j;
                }
                return null;
            } else {
                pushSwitchStatus.setMessage("CHECK_PUSH");
                if (!q() || !s() || t()) {
                    f(true);
                    return this.e.c(this.b, this.c, this.h);
                }
                z = p();
                pushSwitchStatus.setSwitchNotificationMessage(z);
                r = r();
            }
            pushSwitchStatus.setSwitchNotificationMessage(p);
            r = this.j;
        } else {
            pushSwitchStatus.setMessage("SWITCH_NOTIFICATION");
            if (p() != this.j || t()) {
                f(true);
                c(this.j);
                return this.e.a(this.b, this.c, this.h, this.i, this.j);
            }
            z = this.j;
            pushSwitchStatus.setSwitchNotificationMessage(z);
            r = r();
        }
        pushSwitchStatus.setSwitchThroughMessage(r);
        return null;
    }

    private void c(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), z);
    }

    private void d(boolean z) {
        com.meizu.cloud.pushsdk.util.b.b(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), z);
    }

    private void e(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), z);
        com.meizu.cloud.pushsdk.util.b.b(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), z);
    }

    private void f(boolean z) {
        Map<String, Boolean> map = this.k;
        map.put(this.d + JSMethod.NOT_SET + this.i, Boolean.valueOf(z));
    }

    private void o() {
        int i = this.i;
        if (i == 0 || i == 1) {
            PlatformMessageSender.a(this.a, i, this.j, this.d);
        } else if (i != 3) {
        } else {
            PlatformMessageSender.a(this.a, 0, this.j, this.d);
            PlatformMessageSender.a(this.a, 1, this.j, this.d);
        }
    }

    private boolean p() {
        return com.meizu.cloud.pushsdk.util.b.e(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName());
    }

    private boolean q() {
        return com.meizu.cloud.pushsdk.util.b.f(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName());
    }

    private boolean r() {
        return com.meizu.cloud.pushsdk.util.b.h(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName());
    }

    private boolean s() {
        return com.meizu.cloud.pushsdk.util.b.i(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName());
    }

    private boolean t() {
        Map<String, Boolean> map = this.k;
        Boolean bool = map.get(this.d + JSMethod.NOT_SET + this.i);
        boolean z = bool == null || bool.booleanValue();
        DebugLogger.e("Strategy", "isSyncPushStatus " + this.d + " switch type->" + this.i + " flag->" + z);
        return z;
    }

    public void a(int i) {
        this.i = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(PushSwitchStatus pushSwitchStatus) {
        PlatformMessageSender.a(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), pushSwitchStatus);
    }

    public void a(String str) {
        this.h = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected boolean a() {
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.h)) ? false : true;
    }

    public void b(boolean z) {
        this.j = z;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra(com.alipay.sdk.m.l.b.h, this.c);
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra(PushConstants.REGISTER_STATUS_PUSH_ID, this.h);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.i);
        intent.putExtra("strategy_params", this.j ? "1" : "0");
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected int g() {
        return 16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public PushSwitchStatus b() {
        String str;
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setCode("20001");
        if (TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.c)) {
            if (TextUtils.isEmpty(this.h)) {
                str = "pushId not empty";
            }
            return pushSwitchStatus;
        } else {
            str = "appKey not empty";
        }
        pushSwitchStatus.setMessage(str);
        return pushSwitchStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    public PushSwitchStatus e() {
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setPushId(this.h);
        pushSwitchStatus.setCode("200");
        com.meizu.cloud.pushsdk.c.a.c<String> b = b(pushSwitchStatus);
        if (b != null) {
            if (b.b()) {
                PushSwitchStatus pushSwitchStatus2 = new PushSwitchStatus(b.a());
                DebugLogger.e("Strategy", "network pushSwitchStatus " + pushSwitchStatus2);
                if ("200".equals(pushSwitchStatus.getCode())) {
                    f(false);
                    DebugLogger.e("Strategy", "update local switch preference");
                    pushSwitchStatus.setSwitchNotificationMessage(pushSwitchStatus2.isSwitchNotificationMessage());
                    pushSwitchStatus.setSwitchThroughMessage(pushSwitchStatus2.isSwitchThroughMessage());
                    c(pushSwitchStatus2.isSwitchNotificationMessage());
                    d(pushSwitchStatus2.isSwitchThroughMessage());
                }
            } else {
                com.meizu.cloud.pushsdk.c.b.a c = b.c();
                if (c.a() != null) {
                    DebugLogger.e("Strategy", "status code=" + c.b() + " data=" + c.a());
                }
                pushSwitchStatus.setCode(String.valueOf(c.b()));
                pushSwitchStatus.setMessage(c.c());
                DebugLogger.e("Strategy", "pushSwitchStatus " + pushSwitchStatus);
            }
        }
        DebugLogger.e("Strategy", "enableRpc " + this.g + " isSupportRemoteInvoke " + this.f);
        if (this.g && !this.f) {
            o();
        }
        return pushSwitchStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public PushSwitchStatus f() {
        int i = this.i;
        if (i == 0) {
            c(this.j);
            return null;
        } else if (i == 1) {
            d(this.j);
            return null;
        } else if (i == 2 || i == 3) {
            e(this.j);
            return null;
        } else {
            return null;
        }
    }
}
