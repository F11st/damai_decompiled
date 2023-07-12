package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alipay.sdk.m.l.C4231b;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.b.C5927c;
import com.meizu.cloud.pushsdk.c.a.C5950c;
import com.meizu.cloud.pushsdk.c.b.C5953a;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.a.C6090a;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.C6102b;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.platform.b.g */
/* loaded from: classes10.dex */
public class C6099g extends AbstractC6095c<UnRegisterStatus> {
    public C6099g(Context context, C6090a c6090a, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, c6090a, scheduledExecutorService);
    }

    public C6099g(Context context, C6090a c6090a, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, c6090a, scheduledExecutorService);
        this.g = z;
    }

    public C6099g(Context context, String str, String str2, C6090a c6090a, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, c6090a, scheduledExecutorService);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    public void a(UnRegisterStatus unRegisterStatus) {
        PlatformMessageSender.a(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), unRegisterStatus);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected boolean a() {
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) ? false : true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra(C4231b.h, this.c);
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra("strategy_type", g());
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected int g() {
        return 32;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    /* renamed from: h */
    public UnRegisterStatus b() {
        String str;
        UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
        unRegisterStatus.setCode("20001");
        if (!TextUtils.isEmpty(this.b)) {
            str = TextUtils.isEmpty(this.c) ? "appKey not empty" : "appKey not empty";
            return unRegisterStatus;
        }
        str = "appId not empty";
        unRegisterStatus.setMessage(str);
        return unRegisterStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    /* renamed from: i */
    public UnRegisterStatus e() {
        UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
        if (TextUtils.isEmpty(C6102b.a(this.a, this.d))) {
            unRegisterStatus.setCode("200");
            unRegisterStatus.setMessage("already unRegister PushId,don't unRegister frequently");
            unRegisterStatus.setIsUnRegisterSuccess(true);
        } else {
            C5950c b = this.e.b(this.b, this.c, C5927c.a(this.a));
            if (b.b()) {
                unRegisterStatus = new UnRegisterStatus((String) b.a());
                DebugLogger.e("Strategy", "network unRegisterStatus " + unRegisterStatus);
                if ("200".equals(unRegisterStatus.getCode())) {
                    C6102b.g(this.a, "", this.d);
                }
            } else {
                C5953a c = b.c();
                if (c.a() != null) {
                    DebugLogger.e("Strategy", "status code=" + c.b() + " data=" + c.a());
                }
                unRegisterStatus.setCode(String.valueOf(c.b()));
                unRegisterStatus.setMessage(c.c());
                DebugLogger.e("Strategy", "unRegisterStatus " + unRegisterStatus);
            }
        }
        return unRegisterStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    /* renamed from: j */
    public UnRegisterStatus f() {
        return null;
    }
}
