package com.taomai.android.h5container.api;

import android.net.Uri;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taomai.android.h5container.api.base.TaoMaiApiPlugin;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.C8226x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.kh2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u001a\u0010\t\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\n\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¨\u0006\u000f"}, d2 = {"Lcom/taomai/android/h5container/api/TMUTPlugin;", "Lcom/taomai/android/h5container/api/base/TaoMaiApiPlugin;", "", "actionName", "params", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "", "execute", "userTrackSafe", "userTrack", "<init>", "()V", "Companion", "a", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public final class TMUTPlugin extends TaoMaiApiPlugin {
    @NotNull
    public static final String ACTION_USER_TRACK = "usertrack";
    @NotNull
    public static final C7000a Companion = new C7000a(null);

    /* compiled from: Taobao */
    /* renamed from: com.taomai.android.h5container.api.TMUTPlugin$a */
    /* loaded from: classes11.dex */
    public static final class C7000a {
        private C7000a() {
        }

        public /* synthetic */ C7000a(k50 k50Var) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        if (str != null && str.hashCode() == 358853728 && str.equals(ACTION_USER_TRACK)) {
            return userTrackSafe(str2, wVCallBackContext);
        }
        return false;
    }

    public final boolean userTrack(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        JSONObject a = str != null ? kh2.a(str) : null;
        if (a == null) {
            if (wVCallBackContext != null) {
                wVCallBackContext.error();
            }
            return true;
        }
        String string = a.getString("page");
        Integer integer = a.getInteger("eventId");
        String string2 = a.getString("arg1");
        String string3 = a.getString("arg2");
        String string4 = a.getString(UTDataCollectorNodeColumn.ARG3);
        JSONObject jSONObject = a.getJSONObject("args");
        Map t = jSONObject != null ? C8226x.t(jSONObject) : null;
        HashMap hashMap = t instanceof HashMap ? t : null;
        if (integer != null && integer.intValue() == 2101) {
            UTHitBuilders.UTControlHitBuilder uTControlHitBuilder = !(string == null || string.length() == 0) ? new UTHitBuilders.UTControlHitBuilder(string, string2) : new UTHitBuilders.UTControlHitBuilder(string2);
            if (hashMap != null) {
                uTControlHitBuilder.setProperties(hashMap);
            }
            UTAnalytics uTAnalytics = UTAnalytics.getInstance();
            b41.h(uTAnalytics, "UTAnalytics.getInstance()");
            uTAnalytics.getDefaultTracker().send(uTControlHitBuilder.build());
        } else if (integer != null && integer.intValue() == 2001) {
            UTAnalytics uTAnalytics2 = UTAnalytics.getInstance();
            b41.h(uTAnalytics2, "UTAnalytics.getInstance()");
            uTAnalytics2.getDefaultTracker().updatePageName(this.mContext, string);
            UTAnalytics uTAnalytics3 = UTAnalytics.getInstance();
            b41.h(uTAnalytics3, "UTAnalytics.getInstance()");
            uTAnalytics3.getDefaultTracker().updatePageProperties(this.mContext, hashMap);
            if (!TextUtils.isEmpty(string2)) {
                UTAnalytics uTAnalytics4 = UTAnalytics.getInstance();
                b41.h(uTAnalytics4, "UTAnalytics.getInstance()");
                uTAnalytics4.getDefaultTracker().updatePageUrl(this.mContext, Uri.parse(string2));
            }
        } else if ((integer != null && integer.intValue() == 2201) || (integer != null && integer.intValue() == 2202)) {
            UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(string, integer.intValue(), string2, string3, string4, hashMap);
            UTAnalytics uTAnalytics5 = UTAnalytics.getInstance();
            b41.h(uTAnalytics5, "UTAnalytics.getInstance()");
            uTAnalytics5.getDefaultTracker().send(uTOriginalCustomHitBuilder.build());
        } else {
            UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(string2);
            uTCustomHitBuilder.setEventPage(string);
            uTCustomHitBuilder.setProperties(hashMap);
            UTAnalytics uTAnalytics6 = UTAnalytics.getInstance();
            b41.h(uTAnalytics6, "UTAnalytics.getInstance()");
            uTAnalytics6.getDefaultTracker().send(uTCustomHitBuilder.build());
        }
        if (wVCallBackContext != null) {
            wVCallBackContext.success();
        }
        return true;
    }

    public final boolean userTrackSafe(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        try {
            return userTrack(str, wVCallBackContext);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
