package com.taomai.android.h5container.api;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.alibaba.fastjson.JSONObject;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taomai.android.h5container.api.base.TaoMaiApiPlugin;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.kh2;
import tb.wt2;
import tb.yk2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u001a\u0010\t\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\n\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\f\u001a\u00020\u000b¨\u0006\u0011"}, d2 = {"Lcom/taomai/android/h5container/api/TMClipBoardPlugin;", "Lcom/taomai/android/h5container/api/base/TaoMaiApiPlugin;", "", "actionName", "params", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "", "execute", "getClipTextContent", "writeToClipBoard", "Ltb/wt2;", "clearClipTextContent", "<init>", "()V", "Companion", "a", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public final class TMClipBoardPlugin extends TaoMaiApiPlugin {
    @NotNull
    public static final String ACTION_GET_CLIPBOARD = "getClipboard";
    @NotNull
    public static final String ACTION_SET_CLIPBOARD = "setClipboard";
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

    public final void clearClipTextContent() {
        try {
            Application application = yk2.a;
            Object systemService = application != null ? application.getSystemService("clipboard") : null;
            if (systemService != null) {
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("taomai", ""));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1610002720) {
                if (hashCode == -61010092 && str.equals(ACTION_SET_CLIPBOARD)) {
                    return writeToClipBoard(str2, wVCallBackContext);
                }
            } else if (str.equals(ACTION_GET_CLIPBOARD)) {
                return getClipTextContent(str2, wVCallBackContext);
            }
        }
        return false;
    }

    public final boolean getClipTextContent(@Nullable String str, @Nullable WVCallBackContext wVCallBackContext) {
        try {
            Context context = this.mContext;
            Object obj = null;
            Object systemService = context != null ? context.getSystemService("clipboard") : null;
            if (systemService instanceof ClipboardManager) {
                obj = systemService;
            }
            ClipboardManager clipboardManager = (ClipboardManager) obj;
            if (clipboardManager != null && clipboardManager.hasPrimaryClip()) {
                ClipDescription primaryClipDescription = clipboardManager.getPrimaryClipDescription();
                b41.f(primaryClipDescription);
                if (primaryClipDescription.hasMimeType(IRequestConst.CONTENT_TYPE_TEXT_PLAIN)) {
                    ClipData primaryClip = com.alibaba.wireless.security.aopsdk.replace.android.content.ClipboardManager.getPrimaryClip(clipboardManager);
                    b41.f(primaryClip);
                    CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.mContext);
                    String obj2 = coerceToText != null ? coerceToText.toString() : "";
                    if (wVCallBackContext != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("result", (Object) obj2);
                        wt2 wt2Var = wt2.INSTANCE;
                        wVCallBackContext.success(jSONObject.toJSONString());
                        return true;
                    }
                    return true;
                }
            }
            if (wVCallBackContext != null) {
                wVCallBackContext.error();
                return true;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public final boolean writeToClipBoard(@Nullable String str, @Nullable final WVCallBackContext wVCallBackContext) {
        final JSONObject a2 = str != null ? kh2.a(str) : null;
        if (a2 == null || a2.containsKey("text")) {
            try {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.taomai.android.h5container.api.TMClipBoardPlugin$writeToClipBoard$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Context context;
                        context = ((WVApiPlugin) TMClipBoardPlugin.this).mContext;
                        Object systemService = context != null ? context.getSystemService("clipboard") : null;
                        if (!(systemService instanceof ClipboardManager)) {
                            systemService = null;
                        }
                        ClipboardManager clipboardManager = (ClipboardManager) systemService;
                        if (clipboardManager != null) {
                            JSONObject jSONObject = a2;
                            clipboardManager.setPrimaryClip(ClipData.newPlainText("taomai", jSONObject != null ? jSONObject.getString("text") : null));
                            WVCallBackContext wVCallBackContext2 = wVCallBackContext;
                            if (wVCallBackContext2 != null) {
                                wVCallBackContext2.success();
                            }
                        }
                    }
                });
            } catch (Exception unused) {
            }
            return true;
        }
        if (wVCallBackContext != null) {
            wVCallBackContext.error("text is requried for clipboard written");
        }
        return true;
    }
}
