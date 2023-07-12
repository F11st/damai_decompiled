package com.youku.gaiax.provider.module;

import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.k.b;
import com.youku.gaiax.api.proxy.IProxyMonitor;
import com.youku.gaiax.common.utils.Log;
import com.youku.gaiax.provider.module.util.PicXflushMonitorPoint;
import com.youku.uplayer.FileUtils;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016JP\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J8\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¨\u0006\u001a"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxyMonitor;", "Lcom/youku/gaiax/api/proxy/IProxyMonitor;", "Ltb/wt2;", "monitorInit", "", "scene", b.l, "id", "type", "state", "", "value", "module", "api", "apiType", "monitor", "monitorLocalAndRemote", "code", "version", "message", "Lcom/alibaba/fastjson/JSONObject;", "bizData", NotificationCompat.CATEGORY_ALARM, "<init>", "()V", "Companion", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXProxyMonitor implements IProxyMonitor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String DIM_API = "api";
    @NotNull
    private static final String DIM_API_TYPE = "api_type";
    @NotNull
    private static final String DIM_BIZ = "template_biz";
    @NotNull
    private static final String DIM_ID = "template_id";
    @NotNull
    private static final String DIM_MODULE = "module";
    @NotNull
    private static final String DIM_SCENE = "scene";
    @NotNull
    private static final String DIM_STATE = "state";
    @NotNull
    private static final String DIM_TYPE = "type";
    @NotNull
    private static final String DIM_VALUE = "value";
    @NotNull
    private static final String ERROR_CODE = "-800";
    @NotNull
    private static final String MODULE = "GaiaX";
    @NotNull
    private static final String MONITOR_CODE = "-801";
    @NotNull
    private static final String MONITOR_POINT = "GaiaXMonitor";
    @NotNull
    private static final String TAG = "[GaiaX][Monitor]";

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b(\u0010)J@\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\nJ@\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0012J^\u0010\u0018\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0002R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001aR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u001aR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u001aR\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\u001aR\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\u001aR\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\u001a¨\u0006*"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxyMonitor$Companion;", "", "", "code", b.l, "id", "version", "message", "Lcom/alibaba/fastjson/JSONObject;", "bizData", "Ltb/wt2;", "sAlarm", "sMonitorLocalAndRemote", "scene", "templateBiz", "templateId", "type", "state", "", "value", "sMonitor", "module", "api", "apiType", "sMonitor2", "DIM_API", "Ljava/lang/String;", "DIM_API_TYPE", "DIM_BIZ", "DIM_ID", "DIM_MODULE", "DIM_SCENE", "DIM_STATE", "DIM_TYPE", "DIM_VALUE", "ERROR_CODE", "MODULE", "MONITOR_CODE", "MONITOR_POINT", "TAG", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        public static /* synthetic */ void sAlarm$default(Companion companion, String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, int i, Object obj) {
            companion.sAlarm(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) == 0 ? str5 : "", (i & 32) != 0 ? new JSONObject() : jSONObject);
        }

        public static /* synthetic */ void sMonitor2$default(Companion companion, String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, int i, Object obj) {
            companion.sMonitor2(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? -1L : j, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? "" : str7, (i & 256) == 0 ? str8 : "");
        }

        public final void sAlarm(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull JSONObject jSONObject) {
            b41.i(str, "code");
            b41.i(str2, b.l);
            b41.i(str3, "id");
            b41.i(str4, "version");
            b41.i(str5, "message");
            b41.i(jSONObject, "bizData");
            try {
                String str6 = "alarm() called with: code = " + str + ", biz = " + str2 + ", id = " + str3 + ", message = " + str5 + ", bizData = " + jSONObject;
                Log log = Log.INSTANCE;
                if (log.isMonitorLog()) {
                    log.d(GaiaXProxyMonitor.TAG, str6);
                }
                try {
                    PicXflushMonitorPoint picXflushMonitorPoint = new PicXflushMonitorPoint();
                    if (str6 != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("arg", str6);
                        wt2 wt2Var = wt2.INSTANCE;
                        picXflushMonitorPoint.setExtral(hashMap);
                    }
                    picXflushMonitorPoint.setBizCode(GaiaXProxyMonitor.ERROR_CODE);
                    picXflushMonitorPoint.setBizMsg("Gaiax报错");
                    picXflushMonitorPoint.setBizScene(GaiaXProxyMonitor.TAG);
                    picXflushMonitorPoint.setResultExpected(false);
                    picXflushMonitorPoint.release();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println((Object) String.valueOf(wt2.INSTANCE));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void sMonitor(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j) {
            b41.i(str, "scene");
            b41.i(str2, "templateBiz");
            b41.i(str3, "templateId");
            b41.i(str4, "type");
            b41.i(str5, "state");
            sMonitor2$default(this, str, str2, str3, str4, str5, j, null, null, null, FileUtils.S_IRWXU, null);
        }

        public final void sMonitor2(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
            b41.i(str, "scene");
            b41.i(str2, "templateBiz");
            b41.i(str3, "templateId");
            b41.i(str4, "type");
            b41.i(str5, "state");
            b41.i(str6, "module");
            b41.i(str7, "api");
            b41.i(str8, "apiType");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("scene", (Object) str);
                if (str3.length() > 0) {
                    jSONObject.put("template_id", (Object) str3);
                }
                if (str2.length() > 0) {
                    jSONObject.put(GaiaXProxyMonitor.DIM_BIZ, (Object) str2);
                }
                if (str4.length() > 0) {
                    jSONObject.put("type", (Object) str4);
                }
                if (str5.length() > 0) {
                    jSONObject.put("state", (Object) str5);
                }
                if (str6.length() > 0) {
                    jSONObject.put("module", (Object) str5);
                }
                if (str7.length() > 0) {
                    jSONObject.put("api", (Object) str5);
                }
                if (str8.length() > 0) {
                    jSONObject.put(GaiaXProxyMonitor.DIM_API_TYPE, (Object) str5);
                }
                if (j >= 0) {
                    jSONObject.put("value", (Object) String.valueOf(j));
                }
                Log.INSTANCE.d(GaiaXProxyMonitor.TAG, b41.r("monitor() called with: ", JSON.toJSONString(jSONObject)));
                String jSONString = JSON.toJSONString(jSONObject);
                try {
                    PicXflushMonitorPoint picXflushMonitorPoint = new PicXflushMonitorPoint();
                    if (jSONString != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("arg", jSONString);
                        wt2 wt2Var = wt2.INSTANCE;
                        picXflushMonitorPoint.setExtral(hashMap);
                    }
                    picXflushMonitorPoint.setBizCode(GaiaXProxyMonitor.MONITOR_CODE);
                    picXflushMonitorPoint.setBizScene(GaiaXProxyMonitor.TAG);
                    picXflushMonitorPoint.setResultExpected(true);
                    picXflushMonitorPoint.release();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println((Object) String.valueOf(wt2.INSTANCE));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                sAlarm$default(this, "5001", null, null, null, b41.r("monitor msg = ", e2.getMessage()), null, 46, null);
            }
        }

        public final void sMonitorLocalAndRemote() {
        }
    }

    @Override // com.youku.gaiax.api.proxy.IProxyMonitor
    public void alarm(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull JSONObject jSONObject) {
        b41.i(str, "code");
        b41.i(str2, b.l);
        b41.i(str3, "id");
        b41.i(str4, "version");
        b41.i(str5, "message");
        b41.i(jSONObject, "bizData");
        Companion.sAlarm(str, str2, str3, str4, str5, jSONObject);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyMonitor
    public void monitor(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
        b41.i(str, "scene");
        b41.i(str2, b.l);
        b41.i(str3, "id");
        b41.i(str4, "type");
        b41.i(str5, "state");
        b41.i(str6, "module");
        b41.i(str7, "api");
        b41.i(str8, "apiType");
        Companion.sMonitor2(str, str2, str3, str4, str5, j, str6, str7, str8);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyMonitor
    public void monitorInit() {
        IProxyMonitor.DefaultImpls.monitorInit(this);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyMonitor
    public void monitorLocalAndRemote() {
        Companion.sMonitorLocalAndRemote();
    }
}
