package com.youku.style.impl;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.youku.middlewareservice.provider.youku.YoukuSkinManagerProviderProxy;
import com.youku.middlewareservice.provider.youku.analytics.YoukuAnalyticsProviderProxy;
import com.youku.skinmanager.entity.SkinConstant;
import com.youku.style.IStyle;
import com.youku.style.IStyleManager;
import com.youku.style.StyleVisitor;
import com.youku.style.core.StyleFactory;
import com.youku.style.core.StyleStack;
import com.youku.style.vo.AtmosphereStyle;
import com.youku.style.vo.SkinStyle;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DefaultStyleManager<STYLE extends Map> implements IStyleManager<STYLE>, LifecycleObserver {
    private static final String CHANGE_SKIN_ACTION = "com.youku.skinmanager.action.changeskin";
    protected boolean enableSkin;
    BroadcastReceiver mBroadcastReceiver;
    protected Context mContext;
    protected STYLE mCurrentStyle;
    protected LifecycleOwner mHost;
    protected StyleStack<STYLE> mStack;
    protected List<IStyle> mSupports;
    private ActivityTopStatusBarColorSupport mTopStatusBarColorSupport;
    protected String skinPath;

    public DefaultStyleManager(LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, "", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void changeSkin() {
        if (this.enableSkin) {
            if (TextUtils.isEmpty(YoukuSkinManagerProviderProxy.getSkinPath())) {
                resetSkin();
            } else {
                setStyle(getSkinMap(this.skinPath));
            }
        }
    }

    public static StyleVisitor getGlobalStyleVisitor() {
        return null;
    }

    public static StyleVisitor getGlobalStyleVisitor(Activity activity) {
        if (activity == null) {
            return null;
        }
        return getGlobalStyleVisitor(activity.getClass().getSimpleName());
    }

    public static StyleVisitor getGlobalStyleVisitor(String str) {
        return null;
    }

    public static Map getSceneStyleMap(boolean z, String str, String str2) {
        return null;
    }

    public static Map getSkinMap(String str) {
        String str2;
        File[] listFiles;
        File[] listFiles2;
        String skinPath = YoukuSkinManagerProviderProxy.getSkinPath();
        if (TextUtils.isEmpty(skinPath)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String json = YoukuSkinManagerProviderProxy.getJson(skinPath + "/home/home.json");
        File file = new File(skinPath + "/home");
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile() && !TextUtils.isEmpty(file2.getName()) && !file2.getName().startsWith(".") && !file2.getName().endsWith(".json")) {
                    hashMap.put(file2.getName(), file2.getAbsolutePath());
                }
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "home")) {
            str2 = "";
        } else {
            str2 = YoukuSkinManagerProviderProxy.getJson(skinPath + "/" + str + "/" + str + ".json");
            StringBuilder sb = new StringBuilder();
            sb.append(skinPath);
            sb.append("/");
            sb.append(str);
            File file3 = new File(sb.toString());
            if (file3.exists()) {
                for (File file4 : file3.listFiles()) {
                    if (file4.isFile() && !TextUtils.isEmpty(file4.getName()) && !file4.getName().startsWith(".") && !file4.getName().endsWith(".json")) {
                        hashMap.put(file4.getName(), file4.getAbsolutePath());
                    }
                }
            }
        }
        try {
            if (!TextUtils.isEmpty(json)) {
                JSONObject parseObject = JSON.parseObject(json);
                if (!TextUtils.isEmpty(str2)) {
                    parseObject.putAll(JSON.parseObject(str2));
                }
                parseObject.putAll(hashMap);
                parseObject.put("type", (Object) "skin");
                return parseObject;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void sendCustomStatics() {
        HashMap hashMap = new HashMap(8);
        hashMap.put(AbstractC3893a.V, this.skinPath);
        hashMap.put("enable", String.valueOf(this.enableSkin));
        try {
            if (this.mContext == null) {
                LifecycleOwner lifecycleOwner = this.mHost;
                this.mContext = lifecycleOwner instanceof Activity ? (Activity) lifecycleOwner : lifecycleOwner instanceof Fragment ? ((Fragment) lifecycleOwner).getActivity() : null;
            }
            Context context = this.mContext;
            hashMap.put("source", context != null ? context.getClass().getName() : "");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        YoukuAnalyticsProviderProxy.utCustomEvent("style_skin", 19999, SkinConstant.SKIN_PATH_KEY, (String) null, (String) null, (Map) null);
    }

    private void setOrResetStyle(IStyle<STYLE> iStyle) {
        if (iStyle != null) {
            STYLE style = this.mCurrentStyle;
            if (style != null) {
                iStyle.setStyle(style);
            } else {
                iStyle.resetStyle();
            }
        }
    }

    @Override // com.youku.style.IStyleManager
    public STYLE getCurrentStyle() {
        return this.mCurrentStyle;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        if (this.mContext == null) {
            LifecycleOwner lifecycleOwner = this.mHost;
            this.mContext = lifecycleOwner instanceof Activity ? (Activity) lifecycleOwner : lifecycleOwner instanceof Fragment ? ((Fragment) lifecycleOwner).getActivity() : null;
        }
        if (this.mHost instanceof Activity) {
            this.mTopStatusBarColorSupport = new ActivityTopStatusBarColorSupport((Activity) this.mHost);
        }
        if (this.mContext == null || !this.enableSkin) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.youku.skinmanager.action.changeskin");
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.mBroadcastReceiver, intentFilter);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        Context context = this.mContext;
        if (context != null && this.enableSkin) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.mBroadcastReceiver);
        }
        ActivityTopStatusBarColorSupport activityTopStatusBarColorSupport = this.mTopStatusBarColorSupport;
        if (activityTopStatusBarColorSupport != null) {
            unregisterStyleSupports(activityTopStatusBarColorSupport);
            this.mTopStatusBarColorSupport = null;
        }
        List<IStyle> list = this.mSupports;
        if (list != null && list.size() > 0) {
            this.mSupports.clear();
        }
        StyleStack<STYLE> styleStack = this.mStack;
        if (styleStack != null) {
            styleStack.clear();
        }
        LifecycleOwner lifecycleOwner = this.mHost;
        if (lifecycleOwner != null) {
            lifecycleOwner.getLifecycle().removeObserver(this);
            this.mHost = null;
        }
        if (this.mContext != null) {
            this.mContext = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume() {
        ActivityTopStatusBarColorSupport activityTopStatusBarColorSupport = this.mTopStatusBarColorSupport;
        if (activityTopStatusBarColorSupport != null) {
            registerStyleSupports(activityTopStatusBarColorSupport);
        }
        changeSkin();
    }

    @Override // com.youku.style.IStyleManager
    public void registerStyleSupports(IStyle iStyle) {
        if (this.mSupports == null) {
            this.mSupports = new ArrayList();
        }
        if (this.mSupports.contains(iStyle)) {
            return;
        }
        this.mSupports.add(iStyle);
    }

    public void resetSkin() {
        List<IStyle> list = this.mSupports;
        if (list == null || list.size() == 0 || !this.enableSkin) {
            return;
        }
        this.mCurrentStyle = null;
        this.mStack.removeAll(SkinStyle.class);
        if (!this.mStack.isEmpty() && this.mStack.peek() != null) {
            this.mCurrentStyle = (STYLE) this.mStack.peek().getStyle();
        }
        STYLE style = this.mCurrentStyle;
        if (style != null && style.size() == 0) {
            this.mCurrentStyle = null;
        }
        for (IStyle iStyle : this.mSupports) {
            setOrResetStyle(iStyle);
        }
    }

    @Override // com.youku.style.IStyleManager
    public void resetStyleManager() {
        List<IStyle> list = this.mSupports;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mSupports.clear();
    }

    public void setSkinPath(String str) {
        this.skinPath = str;
        sendCustomStatics();
    }

    @Override // com.youku.style.IStyleManager
    public void setStyle(STYLE style) {
        List<IStyle> list = this.mSupports;
        if (list == null || list.size() == 0) {
            return;
        }
        if (style == null) {
            this.mStack.removeAll(AtmosphereStyle.class);
        } else {
            this.mStack.push(StyleFactory.getInstance().create(style));
        }
        if (!this.mStack.isEmpty() && this.mStack.peek() != null) {
            this.mCurrentStyle = (STYLE) this.mStack.peek().getStyle();
        } else {
            this.mCurrentStyle = null;
        }
        STYLE style2 = this.mCurrentStyle;
        if (style2 != null && style2.size() == 0) {
            this.mCurrentStyle = null;
        }
        for (IStyle iStyle : this.mSupports) {
            setOrResetStyle(iStyle);
        }
    }

    @Override // com.youku.style.IStyleManager
    public void unregisterStyleSupports(IStyle<STYLE> iStyle) {
        List<IStyle> list = this.mSupports;
        if (list == null || list.size() <= 0 || !this.mSupports.contains(iStyle)) {
            return;
        }
        this.mSupports.remove(iStyle);
    }

    public DefaultStyleManager(LifecycleOwner lifecycleOwner, boolean z) {
        this(lifecycleOwner, "", z);
    }

    public DefaultStyleManager(LifecycleOwner lifecycleOwner, String str, boolean z) {
        this.mCurrentStyle = null;
        this.mBroadcastReceiver = new BroadcastReceiver() { // from class: com.youku.style.impl.DefaultStyleManager.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if ("com.youku.skinmanager.action.changeskin".equals(intent.getAction())) {
                    DefaultStyleManager.this.changeSkin();
                }
            }
        };
        this.skinPath = str;
        this.enableSkin = z;
        this.mHost = lifecycleOwner;
        this.mStack = new StyleStack<>();
        LifecycleOwner lifecycleOwner2 = this.mHost;
        if (lifecycleOwner2 != null) {
            lifecycleOwner2.getLifecycle().addObserver(this);
        }
        sendCustomStatics();
    }
}
