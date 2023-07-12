package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.notification.c.C6082b;
import com.meizu.cloud.pushsdk.platform.a.C6090a;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.platform.b.a */
/* loaded from: classes10.dex */
public class C6093a extends AbstractC6095c {
    private int[] h;
    private int i;
    private String j;

    public C6093a(Context context, String str, String str2, C6090a c6090a, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, c6090a, scheduledExecutorService);
        this.f = MinSdkChecker.isSupportSetDrawableSmallIcon();
    }

    public C6093a(Context context, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, null, null, null, scheduledExecutorService);
        this.g = z;
    }

    public void a(int i) {
        this.i = i;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected void a(BasicPushStatus basicPushStatus) {
    }

    public void a(String str) {
        this.j = str;
    }

    public void a(int... iArr) {
        this.h = iArr;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected boolean a() {
        int i = this.i;
        if (i != 0) {
            int[] iArr = this.h;
            if (iArr == null || iArr.length <= 0 || i != 1) {
                return i == 2 && !TextUtils.isEmpty(this.j);
            }
            return true;
        }
        return true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected BasicPushStatus b() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected Intent c() {
        Intent intent = new Intent();
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.i);
        int i = this.i;
        if (i == 2) {
            intent.putExtra("strategy_params", this.j);
            return intent;
        } else if (i == 1) {
            return null;
        } else {
            return intent;
        }
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected Intent[] d() {
        int[] iArr = this.h;
        if (iArr != null) {
            Intent[] intentArr = new Intent[iArr.length];
            for (int i = 0; i < this.h.length; i++) {
                DebugLogger.i("Strategy", "send notifyId " + this.h[i] + " to PushManagerService");
                Intent intent = new Intent();
                intent.putExtra("strategy_package_name", this.a.getPackageName());
                intent.putExtra("strategy_type", g());
                intent.putExtra("strategy_child_type", this.i);
                intent.putExtra("strategy_params", "" + this.h[i]);
                intentArr[i] = intent;
            }
            return intentArr;
        }
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected BasicPushStatus e() {
        int i = this.i;
        if (i == 0) {
            if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
                DebugLogger.e("Strategy", "android 6.0 blow so cancel all by context");
                C6082b.a(this.a);
            }
            C6082b.a(this.a, this.d);
            return null;
        } else if (i != 1) {
            if (i != 2) {
                return null;
            }
            C6082b.a(this.a, this.d, this.j);
            return null;
        } else {
            int[] iArr = this.h;
            if (iArr != null) {
                for (int i2 : iArr) {
                    DebugLogger.e("Strategy", "clear notifyId " + i2);
                    C6082b.a(this.a, this.d, i2);
                }
                return null;
            }
            return null;
        }
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected BasicPushStatus f() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.AbstractC6095c
    protected int g() {
        return 64;
    }
}
