package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alipay.sdk.m.l.C4231b;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.c.a.C5950c;
import com.meizu.cloud.pushsdk.c.b.C5953a;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.a.C6090a;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.platform.b.e */
/* loaded from: classes10.dex */
public class C6097e extends AbstractC6095c<SubTagsStatus> {
    private String h;
    private int i;
    private String j;

    public C6097e(Context context, C6090a c6090a, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, c6090a, scheduledExecutorService);
    }

    public C6097e(Context context, C6090a c6090a, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, c6090a, scheduledExecutorService);
        this.g = z;
    }

    public C6097e(Context context, String str, String str2, C6090a c6090a, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, c6090a, scheduledExecutorService);
        this.i = 3;
    }

    public C6097e(Context context, String str, String str2, String str3, C6090a c6090a, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, c6090a, scheduledExecutorService);
        this.h = str3;
    }

    public void a(int i) {
        this.i = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    public void a(SubTagsStatus subTagsStatus) {
        PlatformMessageSender.a(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), subTagsStatus);
    }

    public void a(String str) {
        this.j = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected boolean a() {
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.h)) ? false : true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra(C4231b.h, this.c);
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra(PushConstants.REGISTER_STATUS_PUSH_ID, this.h);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.i);
        intent.putExtra("strategy_params", this.j);
        return intent;
    }

    public void e(String str) {
        this.h = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected int g() {
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    /* renamed from: h */
    public SubTagsStatus b() {
        String str;
        SubTagsStatus subTagsStatus = new SubTagsStatus();
        subTagsStatus.setCode("20001");
        if (TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.c)) {
            if (TextUtils.isEmpty(this.h)) {
                str = "pushId not empty";
            }
            return subTagsStatus;
        } else {
            str = "appKey not empty";
        }
        subTagsStatus.setMessage(str);
        return subTagsStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    /* renamed from: i */
    public SubTagsStatus e() {
        StringBuilder sb;
        String str;
        SubTagsStatus subTagsStatus = new SubTagsStatus();
        int i = this.i;
        C5950c e = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : this.e.e(this.b, this.c, this.h) : this.e.d(this.b, this.c, this.h) : this.e.b(this.b, this.c, this.h, this.j) : this.e.a(this.b, this.c, this.h, this.j);
        if (e == null) {
            DebugLogger.e("Strategy", "network anResponse is null");
            return null;
        }
        if (e.b()) {
            subTagsStatus = new SubTagsStatus((String) e.a());
            sb = new StringBuilder();
            str = "network subTagsStatus ";
        } else {
            C5953a c = e.c();
            if (c.a() != null) {
                DebugLogger.e("Strategy", "status code=" + c.b() + " data=" + c.a());
            }
            subTagsStatus.setCode(String.valueOf(c.b()));
            subTagsStatus.setMessage(c.c());
            sb = new StringBuilder();
            str = "subTagsStatus ";
        }
        sb.append(str);
        sb.append(subTagsStatus);
        DebugLogger.e("Strategy", sb.toString());
        return subTagsStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    /* renamed from: j */
    public SubTagsStatus f() {
        return null;
    }
}
