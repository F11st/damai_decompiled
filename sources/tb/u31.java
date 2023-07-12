package tb;

import android.app.Activity;
import cn.damai.homepage.util.window.PopupCallback;
import com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class u31 extends PopupViewHandle {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private PopupCallback b;

    public u31(@NotNull Activity activity) {
        b41.i(activity, WPKFactory.INIT_KEY_CONTEXT);
    }

    public final void c(@Nullable PopupCallback popupCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-920805190")) {
            ipChange.ipc$dispatch("-920805190", new Object[]{this, popupCallback});
        } else {
            this.b = popupCallback;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x008e, code lost:
        if (r0 == null) goto L37;
     */
    @Override // com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandleCallback
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T, K> java.lang.Object popHandle(@org.jetbrains.annotations.Nullable T r5, @org.jetbrains.annotations.Nullable K r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super tb.kt1> r7) {
        /*
            r4 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.u31.$ipChange
            java.lang.String r1 = "1381836172"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            if (r2 == 0) goto L1e
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            r5 = 2
            r2[r5] = r6
            r5 = 3
            r2[r5] = r7
            java.lang.Object r5 = r0.ipc$dispatch(r1, r2)
            return r5
        L1e:
            boolean r7 = r6 instanceof tb.kt1
            r0 = 0
            if (r7 == 0) goto L26
            tb.kt1 r6 = (tb.kt1) r6
            goto L27
        L26:
            r6 = r0
        L27:
            if (r6 == 0) goto L3b
            tb.kt1$b r7 = tb.kt1.C9376b.INSTANCE
            boolean r6 = tb.b41.d(r6, r7)
            if (r6 == 0) goto L3b
            cn.damai.homepage.util.window.PopupCallback r5 = r4.b
            if (r5 == 0) goto L38
            r5.loadFloat()
        L38:
            tb.kt1$c r5 = tb.kt1.C9377c.INSTANCE
            return r5
        L3b:
            boolean r6 = r5 instanceof com.alibaba.yymidservice.popup.request.bean.PopupResponseBean
            if (r6 == 0) goto L42
            com.alibaba.yymidservice.popup.request.bean.PopupResponseBean r5 = (com.alibaba.yymidservice.popup.request.bean.PopupResponseBean) r5
            goto L43
        L42:
            r5 = r0
        L43:
            if (r5 == 0) goto L90
            java.util.ArrayList<com.alibaba.yymidservice.popup.request.bean.PopupDetailBean> r5 = r5.show
            if (r5 == 0) goto L90
            int r6 = r5.size()
            if (r6 <= 0) goto L85
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.Object r7 = r5.get(r3)
            com.alibaba.yymidservice.popup.request.bean.PopupDetailBean r7 = (com.alibaba.yymidservice.popup.request.bean.PopupDetailBean) r7
            java.lang.String r7 = r7.sceneType
            r6.append(r7)
            r7 = 95
            r6.append(r7)
            java.lang.Object r5 = r5.get(r3)
            com.alibaba.yymidservice.popup.request.bean.PopupDetailBean r5 = (com.alibaba.yymidservice.popup.request.bean.PopupDetailBean) r5
            java.lang.String r5 = r5.eventType
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "MainActivity_wantSeeFloat"
            boolean r5 = tb.b41.d(r5, r6)
            if (r5 != 0) goto L82
            cn.damai.homepage.util.window.PopupCallback r5 = r4.b
            if (r5 == 0) goto L8e
            r5.loadFloat()
        L82:
            tb.wt2 r0 = tb.wt2.INSTANCE
            goto L8e
        L85:
            cn.damai.homepage.util.window.PopupCallback r5 = r4.b
            if (r5 == 0) goto L8e
            r5.loadFloat()
            tb.wt2 r0 = tb.wt2.INSTANCE
        L8e:
            if (r0 != 0) goto L99
        L90:
            cn.damai.homepage.util.window.PopupCallback r5 = r4.b
            if (r5 == 0) goto L99
            r5.loadFloat()
            tb.wt2 r5 = tb.wt2.INSTANCE
        L99:
            tb.kt1$c r5 = tb.kt1.C9377c.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.u31.popHandle(java.lang.Object, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
