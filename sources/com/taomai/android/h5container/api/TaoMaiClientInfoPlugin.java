package com.taomai.android.h5container.api;

import android.content.Context;
import android.content.res.Resources;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taomai.android.h5container.api.base.TaoMaiApiPlugin;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ea0;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J&\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u000e"}, d2 = {"Lcom/taomai/android/h5container/api/TaoMaiClientInfoPlugin;", "Lcom/taomai/android/h5container/api/base/TaoMaiApiPlugin;", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "", "getTitleAndStatusBarHeight", "", "actionName", "params", "execute", "<init>", "()V", "Companion", "a", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public final class TaoMaiClientInfoPlugin extends TaoMaiApiPlugin {
    @NotNull
    public static final String ACTION_STATUS_BAR_HEIGHT = "getTitleAndStatusbarHeight";
    @NotNull
    public static final String BRIDGE_NAME = "TMClient";
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

    private final boolean getTitleAndStatusBarHeight(WVCallBackContext wVCallBackContext) {
        Context context = getContext();
        b41.h(context, WPKFactory.INIT_KEY_CONTEXT);
        Resources resources = context.getResources();
        b41.h(resources, "context.resources");
        float f = resources.getDisplayMetrics().density;
        WVResult wVResult = new WVResult();
        wVResult.addData("titleBarHeight", (Object) 48);
        wVResult.addData("density", Float.valueOf(f));
        wVResult.addData("statusBarHeight", Float.valueOf(ea0.g() / f));
        if (wVCallBackContext != null) {
            wVCallBackContext.success(wVResult);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        if (str != null && str.hashCode() == 706163923 && str.equals(ACTION_STATUS_BAR_HEIGHT)) {
            return getTitleAndStatusBarHeight(wVCallBackContext);
        }
        return false;
    }
}
