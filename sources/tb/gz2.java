package tb;

import android.util.Log;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXJSExceptionInfo;
import com.taobao.weex.performance.IWXAnalyzer;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.taobao.weex.utils.WXUtils;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class gz2 {
    public static final String INTERACTION_TAG = "wxInteractionAnalyzer";
    public static boolean a;
    private static boolean b;

    public static boolean a() {
        return b;
    }

    public static void b(WXJSExceptionInfo wXJSExceptionInfo, String str) {
        List<IWXAnalyzer> C;
        WXSDKInstance y;
        String str2;
        if (!WXEnvironment.isApkDebugable() || (C = WXSDKManager.v().C()) == null || C.size() == 0 || (y = WXSDKManager.v().y(str)) == null) {
            return;
        }
        WXErrorCode errCode = wXJSExceptionInfo.getErrCode();
        try {
            str2 = new JSONObject().put("instanceId", str).put("url", y.getBundleUrl()).put("errorCode", errCode.getErrorCode()).put("errorMsg", errCode.getErrorMsg()).put("errorGroup", errCode.getErrorGroup()).toString();
        } catch (Exception e) {
            e.printStackTrace();
            str2 = "";
        }
        for (IWXAnalyzer iWXAnalyzer : C) {
            iWXAnalyzer.transfer("WXAnalyzer", "WXError", errCode.getErrorType().toString(), str2);
        }
    }

    public static void c(WXComponent wXComponent) {
        List<IWXAnalyzer> C;
        if (!a || (C = WXSDKManager.v().C()) == null || C.size() == 0) {
            return;
        }
        try {
            String jSONObject = new JSONObject().put("renderOriginDiffTime", WXUtils.getFixUnixTime() - wXComponent.getInstance().getWXPerformance().renderUnixTimeOrigin).put("type", wXComponent.getComponentType()).put("ref", wXComponent.getRef()).put("style", wXComponent.getStyles()).put(TemplateDom.KEY_ATTRS, wXComponent.getAttrs()).toString();
            for (IWXAnalyzer iWXAnalyzer : C) {
                iWXAnalyzer.transfer(oz2.WXAPM_CONFIG_GROUP, wXComponent.getInstanceId(), "wxinteraction", jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(String str, String str2, String str3, Object obj) {
        WXSDKInstance wXSDKInstance;
        if (a) {
            if (b && TLogEventConst.PARAM_UPLOAD_STAGE.equals(str2)) {
                Log.d(INTERACTION_TAG, "[client][stage]" + str + "," + str3 + "," + obj);
            }
            List<IWXAnalyzer> C = WXSDKManager.v().C();
            if (C == null || C.size() == 0 || (wXSDKInstance = WXSDKManager.v().i().get(str)) == null) {
                return;
            }
            try {
                String jSONObject = new JSONObject().put(str3, obj).toString();
                for (IWXAnalyzer iWXAnalyzer : C) {
                    iWXAnalyzer.transfer(oz2.WXAPM_CONFIG_GROUP, wXSDKInstance.getInstanceId(), str2, jSONObject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
