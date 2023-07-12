package tb;

import android.app.Activity;
import cn.damai.commonbusiness.update.UpdateUtil;
import com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.kt1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class h81 extends PopupViewHandle {
    private static transient /* synthetic */ IpChange $ipChange;

    public h81(@NotNull Activity activity) {
        b41.i(activity, WPKFactory.INIT_KEY_CONTEXT);
    }

    private final void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "811952882")) {
            ipChange.ipc$dispatch("811952882", new Object[]{this});
        } else {
            UpdateUtil.e();
        }
    }

    @Override // com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandleCallback
    @Nullable
    public <T, K> Object popHandle(@Nullable T t, @Nullable K k, @NotNull Continuation<? super kt1> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "907477790")) {
            return ipChange.ipc$dispatch("907477790", new Object[]{this, t, k, continuation});
        }
        c();
        return kt1.C9375a.INSTANCE;
    }
}
