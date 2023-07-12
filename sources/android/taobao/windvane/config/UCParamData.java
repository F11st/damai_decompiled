package android.taobao.windvane.config;

import android.app.Application;
import android.os.Environment;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.youku.alixplayer.opensdk.AXPParamsProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.uj2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class UCParamData {
    private static final String DEFAULT_HOST_UCM_VERSIONS = "";
    private static final String LOAD_POLICY_CD_ONLY_LEGAL_VALUE = "sc_lshco";
    private static final String OTHER_APPS_CLIENT_UCM_VERSIONS = "";
    private static final String SECURITY_CLIENT_UCM_VERSIONS = "";
    public String hostUcmVersionsCd;
    public String scCopyToSdcardCd;
    public String scLoadPolicyCd;
    public String scPkgNames;
    public String scStillUpd;
    public String scWaitMilts;
    public String sdCopyPathCd;
    public String thirtyUcmVersionsCd;
    private static final String[] HOST_APP_PACKAGE_NAMES = {"com.taobao.taobao", AXPParamsProvider.ClientType.YOUKU};
    private static final String[] HIGH_SECURITY_CLIENT_APP_PACKAGE_NAMES = {"com.taobao.taobao"};
    private static final String[] COMMON_CLIENT_APP_PACKAGE_NAMES = {uj2.TMALLPACKAGENAME, AXPParamsProvider.ClientType.YOUKU, AXPParamsProvider.ClientType.YOUKU_HWBAIPAI, "cn.damai"};
    public String u4FocusAutoPopupInputHostList = "";
    public String cdResourceEmbedSurfaceEmbedViewEnableList = "0^^*,map,video,camera,ai-camera,canvas";
    public String cdResourceEmbedViewReAttachList = "map";
    public String ucPageTimerCount = "2000";
    public boolean openGPUWatchDogOptimize = false;
    public List<String> glLostReloadList = new ArrayList();
    public List<String> glLostUnreloadList = new ArrayList();
    public int cachePageNumber = 5;
    public int discardableLimitBytes = 134217728;
    public boolean discardableReleaseFreeAfterTimeSwitch = false;
    public int discardableReleaseFreeAfterSecond = 60;
    public int discardableReleaseFreeUntilByte = 8388608;
    public boolean discardableReleaseForAllocFailedSwitch = true;
    public int grDiscardableLimitByte = 100663296;
    public int grResourceCacheLimitByte = 100663296;
    public int webglErrorRate = 10;

    public UCParamData(String str) {
        parse(str);
    }

    private static boolean commonClientApp() {
        Application application = GlobalConfig.context;
        if (application != null) {
            return includedAppPackageName(application.getPackageName(), COMMON_CLIENT_APP_PACKAGE_NAMES);
        }
        return false;
    }

    private static String getClientUCMVersionConfig() {
        highSecurityClientApp();
        return "";
    }

    private String getSdCopyPathCd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(Environment.getExternalStorageDirectory().getAbsolutePath(), str).getAbsolutePath();
    }

    private static boolean highSecurityClientApp() {
        Application application = GlobalConfig.context;
        if (application != null) {
            return includedAppPackageName(application.getPackageName(), HIGH_SECURITY_CLIENT_APP_PACKAGE_NAMES);
        }
        return false;
    }

    public static boolean hostApp() {
        Application application = GlobalConfig.context;
        if (application != null) {
            return includedAppPackageName(application.getPackageName(), HOST_APP_PACKAGE_NAMES);
        }
        return false;
    }

    private static boolean includedAppPackageName(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean needLoadNeedShareCoreApp() {
        return commonClientApp() || highSecurityClientApp();
    }

    private boolean notEmpty(String str) {
        return !TextUtils.isEmpty(str);
    }

    private void obtainGLLostReloadList(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("glLostReloadArray");
        if (optJSONArray == null) {
            return;
        }
        if (this.glLostReloadList.size() > 0) {
            this.glLostReloadList.clear();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            this.glLostReloadList.add(optJSONArray.optString(i));
        }
    }

    private void obtainGLLostUnreloadList(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("glLostUnreloadArray");
            if (optJSONArray == null) {
                return;
            }
            if (this.glLostUnreloadList.size() > 0) {
                this.glLostUnreloadList.clear();
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.glLostUnreloadList.add(optJSONArray.optString(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
            TaoLog.e("UCParamData", "obtainGLLostUnreloadList: obtatin unreload url list error!");
        }
    }

    public void parse(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            TaoLog.d("UCParamData", str);
            JSONObject jSONObject = new JSONObject(str);
            this.sdCopyPathCd = getSdCopyPathCd(jSONObject.optString("sdCopyPathCd", ""));
            this.hostUcmVersionsCd = jSONObject.optString("hostUcmVersionsCd", "");
            this.scLoadPolicyCd = jSONObject.optString("scLoadPolicyCd", needLoadNeedShareCoreApp() ? "sc_lshco" : "");
            this.scCopyToSdcardCd = jSONObject.optString("scCopyToSdcardCd", "true");
            this.thirtyUcmVersionsCd = jSONObject.optString("thirtyUcmVersionsCd", getClientUCMVersionConfig());
            this.scPkgNames = jSONObject.optString("scPkgNames", "com.eg.android.AlipayGphone^^com.taobao.taobao");
            this.scStillUpd = jSONObject.optString("scStillUpd", "true");
            this.scWaitMilts = jSONObject.optString("scWaitMilts", needLoadNeedShareCoreApp() ? "1" : "600000");
            this.u4FocusAutoPopupInputHostList = jSONObject.optString("u4FocusAutoPopupInputHostList", this.u4FocusAutoPopupInputHostList);
            this.cachePageNumber = jSONObject.optInt("cachePageNumber", this.cachePageNumber);
            this.discardableLimitBytes = jSONObject.optInt("discardableLimitBytes", 134217728);
            this.discardableReleaseFreeAfterTimeSwitch = jSONObject.optBoolean("discardableReleaseFreeAfterTimeSwitch", false);
            this.discardableReleaseFreeAfterSecond = jSONObject.optInt("discardableReleaseFreeAfterSecond", 60);
            this.discardableReleaseFreeUntilByte = jSONObject.optInt("discardableReleaseFreeUntilByte", 8388608);
            this.discardableReleaseForAllocFailedSwitch = jSONObject.optBoolean("discardableReleaseForAllocFailedSwitch", true);
            this.grDiscardableLimitByte = jSONObject.optInt("grDiscardableLimitByte", 100663296);
            this.grResourceCacheLimitByte = jSONObject.optInt("grResourceCacheLimitByte", 100663296);
            this.cdResourceEmbedSurfaceEmbedViewEnableList = jSONObject.optString("cdResourceEmbedSurfaceEmbedViewEnableList", this.cdResourceEmbedSurfaceEmbedViewEnableList);
            this.cdResourceEmbedViewReAttachList = jSONObject.optString("cdResourceEmbedViewReAttachList", this.cdResourceEmbedViewReAttachList);
            this.ucPageTimerCount = jSONObject.optString("ucPageTimerCount", this.ucPageTimerCount);
            this.openGPUWatchDogOptimize = jSONObject.optBoolean("openGPUWatchDogOptimize", this.openGPUWatchDogOptimize);
            obtainGLLostReloadList(jSONObject);
            obtainGLLostUnreloadList(jSONObject);
            this.webglErrorRate = jSONObject.optInt("webglErrorRate", this.webglErrorRate);
        } catch (Throwable unused) {
            TaoLog.w("UCParamData", "failed to parse uc params", str);
        }
    }

    public boolean validShareCoreFromSdcardParams() {
        return notEmpty(this.sdCopyPathCd) && notEmpty(this.thirtyUcmVersionsCd) && notEmpty(this.scPkgNames) && "sc_lshco".equals(this.scLoadPolicyCd);
    }

    public boolean validShareCoreToSdcardParams() {
        return notEmpty(this.scCopyToSdcardCd) && notEmpty(this.sdCopyPathCd) && notEmpty(this.hostUcmVersionsCd);
    }
}
