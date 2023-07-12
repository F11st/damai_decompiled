package com.alibaba.pictures.bricks.util.toast;

import android.app.Application;
import android.content.Context;
import androidx.annotation.RawRes;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.yo2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class BricksToastUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final BricksToastUtil INSTANCE = new BricksToastUtil();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum ToastLottieType {
        TYPE_SUCCESS(0, "成功");

        ToastLottieType(int i, String str) {
        }
    }

    private BricksToastUtil() {
    }

    private final Context a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1646601821")) {
            return (Context) ipChange.ipc$dispatch("-1646601821", new Object[]{this});
        }
        Application application = AppInfoProviderProxy.getApplication();
        b41.h(application, "getApplication()");
        return application;
    }

    public final void b(@Nullable CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "339653058")) {
            ipChange.ipc$dispatch("339653058", new Object[]{this, charSequence});
        } else {
            c(a(), null, charSequence);
        }
    }

    public final void c(@Nullable Context context, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2027326954")) {
            ipChange.ipc$dispatch("-2027326954", new Object[]{this, context, charSequence, charSequence2});
            return;
        }
        yo2 yo2Var = yo2.INSTANCE;
        yo2Var.j(a(), yo2Var.b(context, charSequence, charSequence2), 0, 17, 0, 0);
    }

    public final void d(@Nullable String str, @Nullable String str2, @RawRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1068373992")) {
            ipChange.ipc$dispatch("1068373992", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
    }
}
