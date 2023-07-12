package com.youku.live.livesdk.wkit.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.uc.webview.export.media.MessageID;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class LiveWXAnalyzerDelegate {
    private static transient /* synthetic */ IpChange $ipChange;
    private Object mWXAnalyzer;

    public LiveWXAnalyzerDelegate(@Nullable Context context) {
        if (WXEnvironment.isApkDebugable() && context != null) {
            try {
                this.mWXAnalyzer = Class.forName("com.taobao.weex.analyzer.WeexDevOptions").getDeclaredConstructor(Context.class).newInstance(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onCreate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-850979600")) {
            ipChange.ipc$dispatch("-850979600", new Object[]{this});
            return;
        }
        Object obj = this.mWXAnalyzer;
        if (obj == null) {
            return;
        }
        try {
            obj.getClass().getDeclaredMethod("onCreate", new Class[0]).invoke(this.mWXAnalyzer, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-518376412")) {
            ipChange.ipc$dispatch("-518376412", new Object[]{this});
            return;
        }
        Object obj = this.mWXAnalyzer;
        if (obj == null) {
            return;
        }
        try {
            obj.getClass().getDeclaredMethod("onDestroy", new Class[0]).invoke(this.mWXAnalyzer, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onException(WXSDKInstance wXSDKInstance, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1748114483")) {
            ipChange.ipc$dispatch("1748114483", new Object[]{this, wXSDKInstance, str, str2});
        } else if (this.mWXAnalyzer == null) {
        } else {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                this.mWXAnalyzer.getClass().getDeclaredMethod("onException", WXSDKInstance.class, String.class, String.class).invoke(this.mWXAnalyzer, wXSDKInstance, str, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759916897")) {
            return ((Boolean) ipChange.ipc$dispatch("1759916897", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        Object obj = this.mWXAnalyzer;
        if (obj == null) {
            return false;
        }
        try {
            return ((Boolean) obj.getClass().getDeclaredMethod("onKeyUp", Integer.TYPE, KeyEvent.class).invoke(this.mWXAnalyzer, Integer.valueOf(i), keyEvent)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-989871384")) {
            ipChange.ipc$dispatch("-989871384", new Object[]{this});
            return;
        }
        Object obj = this.mWXAnalyzer;
        if (obj == null) {
            return;
        }
        try {
            obj.getClass().getDeclaredMethod(MessageID.onPause, new Class[0]).invoke(this.mWXAnalyzer, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1026544671")) {
            ipChange.ipc$dispatch("1026544671", new Object[]{this});
            return;
        }
        Object obj = this.mWXAnalyzer;
        if (obj == null) {
            return;
        }
        try {
            obj.getClass().getDeclaredMethod("onResume", new Class[0]).invoke(this.mWXAnalyzer, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-946766596")) {
            ipChange.ipc$dispatch("-946766596", new Object[]{this});
            return;
        }
        Object obj = this.mWXAnalyzer;
        if (obj == null) {
            return;
        }
        try {
            obj.getClass().getDeclaredMethod("onStart", new Class[0]).invoke(this.mWXAnalyzer, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1403217430")) {
            ipChange.ipc$dispatch("-1403217430", new Object[]{this});
            return;
        }
        Object obj = this.mWXAnalyzer;
        if (obj == null) {
            return;
        }
        try {
            obj.getClass().getDeclaredMethod(MessageID.onStop, new Class[0]).invoke(this.mWXAnalyzer, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onWeexRenderSuccess(@Nullable WXSDKInstance wXSDKInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076590308")) {
            ipChange.ipc$dispatch("-2076590308", new Object[]{this, wXSDKInstance});
            return;
        }
        Object obj = this.mWXAnalyzer;
        if (obj == null || wXSDKInstance == null) {
            return;
        }
        try {
            obj.getClass().getDeclaredMethod("onWeexRenderSuccess", WXSDKInstance.class).invoke(this.mWXAnalyzer, wXSDKInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public View onWeexViewCreated(WXSDKInstance wXSDKInstance, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1962816962")) {
            return (View) ipChange.ipc$dispatch("1962816962", new Object[]{this, wXSDKInstance, view});
        }
        Object obj = this.mWXAnalyzer;
        if (obj == null || wXSDKInstance == null || view == null) {
            return null;
        }
        try {
            return (View) obj.getClass().getDeclaredMethod("onWeexViewCreated", WXSDKInstance.class, View.class).invoke(this.mWXAnalyzer, wXSDKInstance, view);
        } catch (Exception e) {
            e.printStackTrace();
            return view;
        }
    }
}
