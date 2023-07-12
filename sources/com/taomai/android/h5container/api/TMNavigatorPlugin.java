package com.taomai.android.h5container.api;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.ui.component.WXWeb;
import com.taomai.android.h5container.TaoMaiH5Container;
import com.taomai.android.h5container.api.base.TaoMaiApiPlugin;
import com.taomai.android.h5container.utils.ActivityStackManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.kh2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\u0011"}, d2 = {"Lcom/taomai/android/h5container/api/TMNavigatorPlugin;", "Lcom/taomai/android/h5container/api/base/TaoMaiApiPlugin;", "", "params", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "", WXWeb.GO_BACK, "actionName", "execute", "pushWindow", TMNavigatorPlugin.ACTION_POP_WINDOW, TMNavigatorPlugin.ACTION_POP_TO, "<init>", "()V", "Companion", "a", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public final class TMNavigatorPlugin extends TaoMaiApiPlugin {
    @NotNull
    public static final String ACTION_GO_BACK = "back";
    @NotNull
    public static final String ACTION_POP_TO = "popTo";
    @NotNull
    public static final String ACTION_POP_WINDOW = "popWindow";
    @NotNull
    public static final String ACTION_PUSH_WINDOW = "pushWindow";
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    private final boolean goBack(String str, WVCallBackContext wVCallBackContext) {
        if (this.mWebView.back()) {
            if (wVCallBackContext != null) {
                wVCallBackContext.success();
                return true;
            }
            return true;
        } else if (wVCallBackContext != null) {
            wVCallBackContext.error();
            return true;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1480738399:
                    if (str.equals(ACTION_POP_WINDOW)) {
                        return popWindow(str2, wVCallBackContext);
                    }
                    break;
                case 3015911:
                    if (str.equals("back")) {
                        return goBack(str2, wVCallBackContext);
                    }
                    break;
                case 106851500:
                    if (str.equals(ACTION_POP_TO)) {
                        return popTo(str2, wVCallBackContext);
                    }
                    break;
                case 1703426986:
                    if (str.equals("pushWindow")) {
                        return pushWindow(str2, wVCallBackContext);
                    }
                    break;
            }
        }
        return false;
    }

    public final boolean popTo(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        JSONObject a2;
        if (str != null && (a2 = kh2.a(str)) != null) {
            if (ActivityStackManager.Companion.a().d(a2.getIntValue("index"), a2.getString("data"))) {
                if (wVCallBackContext != null) {
                    wVCallBackContext.success();
                }
            } else if (wVCallBackContext != null) {
                wVCallBackContext.error();
            }
        }
        return true;
    }

    public final boolean popWindow(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        JSONObject a2;
        if (str != null && (a2 = kh2.a(str)) != null) {
            String string = a2.getString("data");
            if (string != null && !b41.d("{}", string)) {
                if (ActivityStackManager.Companion.a().d(-1, string)) {
                    if (wVCallBackContext != null) {
                        wVCallBackContext.success();
                    }
                } else if (wVCallBackContext != null) {
                    wVCallBackContext.error();
                }
                return true;
            }
            Context context = this.mContext;
            if (!(context instanceof Activity)) {
                context = null;
            }
            Activity activity = (Activity) context;
            if (activity != null) {
                activity.finish();
            }
            if (wVCallBackContext != null) {
                wVCallBackContext.success();
            }
        }
        return true;
    }

    public final boolean pushWindow(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        JSONObject a2;
        String string;
        if (str != null && (a2 = kh2.a(str)) != null && (string = a2.getString("url")) != null) {
            TaoMaiH5Container.NavHandler b = TaoMaiH5Container.b();
            if (b != null) {
                Context context = this.mContext;
                b41.h(context, "mContext");
                b.handleUrl(context, string, false, this.mWebView);
            }
            if (wVCallBackContext != null) {
                wVCallBackContext.success();
            }
        }
        return true;
    }
}
