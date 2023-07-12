package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alipay.sdk.m.l.C4231b;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.a.C6090a;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.util.C6102b;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.platform.b.d */
/* loaded from: classes10.dex */
public class C6096d extends AbstractC6095c<SubAliasStatus> {
    private String h;
    private int i;
    private String j;
    private final Map<String, Boolean> k;

    public C6096d(Context context, C6090a c6090a, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, c6090a, scheduledExecutorService);
    }

    public C6096d(Context context, C6090a c6090a, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, c6090a, scheduledExecutorService);
        this.g = z;
    }

    public C6096d(Context context, String str, String str2, C6090a c6090a, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, c6090a, scheduledExecutorService);
        this.k = new HashMap();
    }

    public C6096d(Context context, String str, String str2, String str3, C6090a c6090a, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, c6090a, scheduledExecutorService);
        this.h = str3;
    }

    private void b(boolean z) {
        Map<String, Boolean> map = this.k;
        map.put(this.d + JSMethod.NOT_SET + this.i, Boolean.valueOf(z));
    }

    private void f(String str) {
        C6102b.h(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), str);
    }

    private String o() {
        return C6102b.g(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName());
    }

    private boolean p() {
        Map<String, Boolean> map = this.k;
        Boolean bool = map.get(this.d + JSMethod.NOT_SET + this.i);
        return bool == null || bool.booleanValue();
    }

    private boolean q() {
        return !this.f && PushConstants.PUSH_PACKAGE_NAME.equals(this.d);
    }

    public void a(int i) {
        this.i = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    public void a(SubAliasStatus subAliasStatus) {
        PlatformMessageSender.a(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), subAliasStatus);
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
        if (this.i != 2) {
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
        return null;
    }

    public void e(String str) {
        this.h = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected int g() {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    /* renamed from: h */
    public SubAliasStatus b() {
        String str;
        SubAliasStatus subAliasStatus = new SubAliasStatus();
        subAliasStatus.setCode("20001");
        if (TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.c)) {
            if (TextUtils.isEmpty(this.h)) {
                str = "pushId not empty";
            }
            return subAliasStatus;
        } else {
            str = "appKey not empty";
        }
        subAliasStatus.setMessage(str);
        return subAliasStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0090  */
    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.meizu.cloud.pushsdk.platform.message.SubAliasStatus e() {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.platform.b.C6096d.e():com.meizu.cloud.pushsdk.platform.message.SubAliasStatus");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    /* renamed from: j */
    public SubAliasStatus f() {
        if (this.i == 2) {
            SubAliasStatus subAliasStatus = new SubAliasStatus();
            subAliasStatus.setCode("200");
            subAliasStatus.setPushId(this.h);
            subAliasStatus.setAlias(o());
            subAliasStatus.setMessage("check alias success");
            return subAliasStatus;
        }
        return null;
    }
}
