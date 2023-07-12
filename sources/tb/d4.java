package tb;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import cn.damai.push.PushSwitcher;
import com.alibaba.pictures.accs.IAgooServiceDelegate;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class d4 implements IAgooServiceDelegate {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final String a = "AgooServiceDelegate";

    @Override // com.alibaba.pictures.accs.IAgooServiceDelegate
    public void onDataReceiver(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "362805924")) {
            ipChange.ipc$dispatch("362805924", new Object[]{this, context, str, str2, str3});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Log.i(this.a, "agoo onMessage ,msg=  DaMaiPushIntentService");
        try {
            String str4 = this.a;
            cb1.g(str4, "agoo onMessage ,msg=  DaMaiPushIntentService message = " + str3);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            new PushSwitcher.C1539a(context).d(PushSwitcher.PushChannel.AGOO).c(str).b(str3).a().d();
        } catch (Throwable th) {
            Log.w(this.a, th);
        }
    }

    @Override // com.alibaba.pictures.accs.IAgooServiceDelegate
    public void onError(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1770706517")) {
            ipChange.ipc$dispatch("-1770706517", new Object[]{this, context, str});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "s");
        String str2 = this.a;
        cb1.c(str2, "注册失败 " + str);
    }

    @Override // com.alibaba.pictures.accs.IAgooServiceDelegate
    public void onOriDataReceiver(@NotNull Context context, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "578371989")) {
            ipChange.ipc$dispatch("578371989", new Object[]{this, context, intent});
        } else {
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        }
    }

    @Override // com.alibaba.pictures.accs.IAgooServiceDelegate
    public void onRegistered(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-594387175")) {
            ipChange.ipc$dispatch("-594387175", new Object[]{this, context, str});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "s");
        String str2 = this.a;
        cb1.c(str2, "注册成功 " + str);
    }

    @Override // com.alibaba.pictures.accs.IAgooServiceDelegate
    public void onUnregistered(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-641634254")) {
            ipChange.ipc$dispatch("-641634254", new Object[]{this, context, str});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "s");
        String str2 = this.a;
        cb1.c(str2, "取消注册 " + str);
    }
}
