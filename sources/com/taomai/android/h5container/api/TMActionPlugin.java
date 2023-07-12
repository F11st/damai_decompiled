package com.taomai.android.h5container.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taomai.android.h5container.api.base.TaoMaiApiPlugin;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\t\u0010\nJ&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¨\u0006\u000e"}, d2 = {"Lcom/taomai/android/h5container/api/TMActionPlugin;", "Lcom/taomai/android/h5container/api/base/TaoMaiApiPlugin;", "", "actionName", "params", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "", "execute", "<init>", "()V", "Companion", "a", "IWVAPIPlugin", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public final class TMActionPlugin extends TaoMaiApiPlugin {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final HashMap<String, IWVAPIPlugin> commonPluginMap = new HashMap<>();

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\t"}, d2 = {"Lcom/taomai/android/h5container/api/TMActionPlugin$IWVAPIPlugin;", "", "", "actionName", "params", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "", "execute", "h5container_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes11.dex */
    public interface IWVAPIPlugin {
        boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a {
        private a() {
        }

        @NotNull
        public final HashMap<String, IWVAPIPlugin> a() {
            return TMActionPlugin.commonPluginMap;
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        IWVAPIPlugin iWVAPIPlugin = commonPluginMap.get(str);
        if (iWVAPIPlugin != null) {
            iWVAPIPlugin.execute(str, str2, wVCallBackContext);
            return true;
        }
        if (wVCallBackContext != null) {
            WVResult wVResult = new WVResult();
            wVResult.addData("error", "bridge method not exist");
            wt2 wt2Var = wt2.INSTANCE;
            wVCallBackContext.error(wVResult);
        }
        return false;
    }
}
