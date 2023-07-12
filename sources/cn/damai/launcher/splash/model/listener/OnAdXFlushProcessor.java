package cn.damai.launcher.splash.model.listener;

import androidx.annotation.NonNull;
import cn.damai.launcher.splash.api.SplashResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class OnAdXFlushProcessor implements OnAdFetchListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isUseCache;
    private SplashResponse mResponse;

    public OnAdXFlushProcessor(boolean z) {
        this.isUseCache = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        if (r9 != 5) goto L13;
     */
    @Override // cn.damai.launcher.splash.model.listener.OnAdFetchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void dispatchAdFetchPhaseFail(int r9, java.lang.String r10, java.lang.String r11) {
        /*
            r8 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.launcher.splash.model.listener.OnAdXFlushProcessor.$ipChange
            java.lang.String r1 = "-660729261"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L21
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r6] = r8
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r2[r7] = r9
            r2[r5] = r10
            r2[r4] = r11
            r0.ipc$dispatch(r1, r2)
            return
        L21:
            if (r9 == r5) goto L5d
            java.lang.String r11 = ""
            if (r9 == r4) goto L46
            if (r9 == r3) goto L2f
            r10 = 5
            if (r9 == r10) goto L2d
            goto L68
        L2d:
            r6 = 1
            goto L68
        L2f:
            cn.damai.launcher.splash.api.SplashResponse r9 = r8.mResponse
            if (r9 != 0) goto L34
            goto L38
        L34:
            java.lang.String r11 = r9.getPic()
        L38:
            java.lang.String r9 = java.lang.String.valueOf(r10)
            java.lang.String r10 = tb.z20.c()
            java.lang.String r0 = "ad_file_turn_to_drawable_fail"
            cn.damai.launcher.utils.SplashXFlushHelper.b(r9, r0, r10, r11)
            goto L68
        L46:
            cn.damai.launcher.splash.api.SplashResponse r9 = r8.mResponse
            if (r9 != 0) goto L4b
            goto L4f
        L4b:
            java.lang.String r11 = r9.getPic()
        L4f:
            java.lang.String r9 = java.lang.String.valueOf(r10)
            java.lang.String r10 = tb.z20.c()
            java.lang.String r0 = "DMImageLoader.onFail"
            cn.damai.launcher.utils.SplashXFlushHelper.b(r9, r0, r10, r11)
            goto L2d
        L5d:
            java.lang.String r9 = tb.z20.c()
            java.lang.String r0 = "mtop.damai.wireless.home.welcome"
            java.lang.String r1 = "n/a"
            cn.damai.launcher.utils.SplashXFlushHelper.d(r0, r10, r11, r1, r9)
        L68:
            boolean r9 = r8.isUseCache
            if (r9 != 0) goto L8b
            if (r6 == 0) goto L8b
            cn.damai.launcher.splash.api.SplashResponse r9 = r8.mResponse
            if (r9 == 0) goto L8b
            boolean r9 = r9.isPicUrlValid()
            if (r9 == 0) goto L8b
            cn.damai.launcher.splash.api.SplashResponse r9 = r8.mResponse
            java.lang.String r9 = r9.getPic()
            cn.damai.launcher.splash.api.SplashResponse r10 = r8.mResponse
            java.lang.String r10 = r10.getSchema()
            cn.damai.launcher.ut.LauncherUTHelper r11 = cn.damai.launcher.ut.LauncherUTHelper.getInstance()
            r11.j(r9, r10)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.launcher.splash.model.listener.OnAdXFlushProcessor.dispatchAdFetchPhaseFail(int, java.lang.String, java.lang.String):void");
    }

    @Override // cn.damai.launcher.splash.model.listener.OnAdFetchListener
    public void dispatchAdFetchSuccess(@NonNull File file, @NonNull SplashResponse splashResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1419370945")) {
            ipChange.ipc$dispatch("-1419370945", new Object[]{this, file, splashResponse});
        } else {
            this.mResponse = splashResponse;
        }
    }
}
