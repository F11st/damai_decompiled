package com.youku.live.dago.liveplayback;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SharelibCtx {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ConnectivityManager mConnMgr;
    @SuppressLint({"StaticFieldLeak"})
    private static Context mCtx;
    private static Handler mMainHandler;

    public static ConnectivityManager connMgr() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "529489922")) {
            return (ConnectivityManager) ipChange.ipc$dispatch("529489922", new Object[0]);
        }
        if (mConnMgr == null) {
            mConnMgr = (ConnectivityManager) mCtx.getSystemService("connectivity");
        }
        return mConnMgr;
    }

    @NonNull
    public static Context ctx() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1544341586") ? (Context) ipChange.ipc$dispatch("1544341586", new Object[0]) : mCtx;
    }

    public static boolean haveCtx() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1770274586") ? ((Boolean) ipChange.ipc$dispatch("-1770274586", new Object[0])).booleanValue() : mCtx != null;
    }

    @NonNull
    public static Handler mainHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-983852330")) {
            return (Handler) ipChange.ipc$dispatch("-983852330", new Object[0]);
        }
        if (mMainHandler == null) {
            mMainHandler = new Handler(Looper.getMainLooper());
        }
        return mMainHandler;
    }

    public static void setCtx(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1849980996")) {
            ipChange.ipc$dispatch("1849980996", new Object[]{context});
        } else {
            mCtx = context.getApplicationContext();
        }
    }
}
