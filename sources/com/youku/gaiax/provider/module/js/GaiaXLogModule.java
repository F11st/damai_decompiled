package com.youku.gaiax.provider.module.js;

import android.util.Log;
import androidx.annotation.Keep;
import com.ali.ha.fulltrace.dump.DumpManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.IExperiment;
import com.youku.gaiax.js.api.GaiaXBaseModule;
import com.youku.gaiax.js.api.annotation.GaiaXSyncMethod;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0016\u0010\u000b\u001a\u00020\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/youku/gaiax/provider/module/js/GaiaXLogModule;", "Lcom/youku/gaiax/js/api/GaiaXBaseModule;", "", "data", "Ltb/wt2;", DumpManager.LOG_PATH, "info", "warn", "error", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "Companion", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXLogModule extends GaiaXBaseModule {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "[GaiaX][JS][LOG]";

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/youku/gaiax/provider/module/js/GaiaXLogModule$Companion;", "", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "getLogMsg", "msg", "Ltb/wt2;", "sendMsgLog", "level", "sendSocketData", "argData", "errorLog", "TAG", "Ljava/lang/String;", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        private final String getLogMsg(JSONObject jSONObject) {
            String string = jSONObject.getString("data");
            return string == null ? "" : string;
        }

        private final void sendMsgLog(String str) {
            sendSocketData("error", str);
            Log.e(GaiaXLogModule.TAG, str);
            MotuJSErrorReportUtils.INSTANCE.sendError(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void sendSocketData(String str, String str2) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put((JSONObject) "jsonrpc", "2.0");
            jSONObject.put((JSONObject) "method", "template/jsDidChangedNotification");
            jSONObject.put((JSONObject) "id", (String) 103);
            jSONObject.put((JSONObject) "params", (String) jSONObject2);
            jSONObject2.put((JSONObject) "level", str);
            jSONObject2.put((JSONObject) "data", str2);
            IExperiment experiment = GaiaX.Companion.getInstance().experiment();
            if (experiment == null) {
                return;
            }
            experiment.onSendStudioMsg(jSONObject);
        }

        public final void errorLog(@NotNull String str) {
            b41.i(str, "data");
            sendMsgLog(getLogMsg(str));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getLogMsg(String str) {
            try {
                String string = JSON.parseObject(str).getString("data");
                return string == null ? "" : string;
            } catch (Exception e) {
                return String.valueOf(e.getMessage());
            }
        }

        public final void errorLog(@NotNull JSONObject jSONObject) {
            b41.i(jSONObject, "data");
            sendMsgLog(getLogMsg(jSONObject));
        }
    }

    @GaiaXSyncMethod
    public final void error(@NotNull String str) {
        b41.i(str, "data");
        Companion.errorLog(str);
    }

    @Override // com.youku.gaiax.js.api.IGaiaXModule
    @NotNull
    public String getName() {
        return "NativeLogger";
    }

    @GaiaXSyncMethod
    public final void info(@NotNull String str) {
        b41.i(str, "data");
        Companion companion = Companion;
        String logMsg = companion.getLogMsg(str);
        companion.sendSocketData("info", logMsg);
        Log.i(TAG, logMsg);
    }

    @GaiaXSyncMethod
    public final void log(@NotNull String str) {
        b41.i(str, "data");
        Companion companion = Companion;
        String logMsg = companion.getLogMsg(str);
        companion.sendSocketData(DumpManager.LOG_PATH, logMsg);
        Log.d(TAG, logMsg);
    }

    @GaiaXSyncMethod
    public final void warn(@NotNull String str) {
        b41.i(str, "data");
        Companion companion = Companion;
        String logMsg = companion.getLogMsg(str);
        companion.sendSocketData("warn", logMsg);
        Log.w(TAG, logMsg);
    }
}
