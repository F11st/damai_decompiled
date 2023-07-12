package android.taobao.windvane.jsbridge.api;

import android.app.Application;
import android.content.ContextWrapper;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.WVAPI;
import android.taobao.windvane.jsbridge.utils.DeviceInfo;
import android.taobao.windvane.jsbridge.utils.YearClass;
import android.taobao.windvane.util.TaoLog;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.application.common.C6673b;
import com.taobao.application.common.IAppPreferences;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.youku.live.dsl.config.IDynamicConfig;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVNativeDetector extends WVApiPlugin {
    private void detectYearClass(String str, WVCallBackContext wVCallBackContext) {
        int i = YearClass.get(this.mContext);
        if (i == -1) {
            wVCallBackContext.error();
            return;
        }
        WVResult wVResult = new WVResult();
        wVResult.addData("deviceYear", Integer.toString(i));
        wVCallBackContext.success(wVResult);
    }

    private void getCurrentUsage(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        Application application = GlobalConfig.context;
        if (application == null) {
            wVCallBackContext.error();
            return;
        }
        float totalMemory = (float) (DeviceInfo.getTotalMemory(application) / 1048576);
        float processCpuRate = DeviceInfo.getProcessCpuRate();
        float freeMemorySize = totalMemory - ((float) (DeviceInfo.getFreeMemorySize(GlobalConfig.context) / 1048576));
        wVResult.addData("cpuUsage", Float.toString(processCpuRate));
        wVResult.addData("memoryUsage", Float.toString(freeMemorySize / totalMemory));
        wVResult.addData("totalMemory", Float.toString(totalMemory));
        wVResult.addData("usedMemory", Float.toString(freeMemorySize));
        wVCallBackContext.success(wVResult);
    }

    private void getPerformanceInfo(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        try {
            IAppPreferences d = C6673b.d();
            d.getBoolean("isApm", false);
            int i = d.getInt(IDynamicConfig.KEY_DEVICE_SCORE, -1);
            int i2 = d.getInt("cpuScore", -1);
            int i3 = d.getInt("memScore", -1);
            wVResult.addData(IDynamicConfig.KEY_DEVICE_SCORE, Integer.valueOf(i));
            wVResult.addData("cpuScore", Integer.valueOf(i2));
            wVResult.addData("memScore", Integer.valueOf(i3));
            wVCallBackContext.success(wVResult);
        } catch (Throwable th) {
            wVResult.addData("errMsg", th.getMessage());
            wVCallBackContext.error(wVResult);
        }
    }

    private void isSimulator(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        try {
            boolean isSimulator = SecurityGuardManager.getInstance(new ContextWrapper(this.mContext)).getSimulatorDetectComp().isSimulator();
            TaoLog.i(WVAPI.PluginName.API_NATIVEDETECTOR, "Current phone is simulator: " + isSimulator);
            wVResult.addData("isSimulator", Boolean.valueOf(isSimulator));
            wVCallBackContext.success(wVResult);
        } catch (Throwable th) {
            wVResult.addData("errMsg", th.getMessage());
            wVCallBackContext.error(wVResult);
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("getDeviceYear".equals(str)) {
            detectYearClass(str2, wVCallBackContext);
            return true;
        } else if ("getCurrentUsage".equals(str)) {
            getCurrentUsage(str2, wVCallBackContext);
            return true;
        } else if ("getModelInfo".equals(str)) {
            getModelInfo(wVCallBackContext, str2);
            return true;
        } else if ("isSimulator".equals(str)) {
            isSimulator(str2, wVCallBackContext);
            return true;
        } else if ("getPerformanceInfo".equals(str)) {
            getPerformanceInfo(str2, wVCallBackContext);
            return true;
        } else {
            return false;
        }
    }

    public void getModelInfo(WVCallBackContext wVCallBackContext, String str) {
        WVResult wVResult = new WVResult();
        wVResult.addData("model", Build.getMODEL());
        wVResult.addData("brand", Build.getBRAND());
        wVCallBackContext.success(wVResult);
    }
}
