package com.taobao.accs.windvane;

import android.taobao.windvane.extra.jsbridge.WVACCS;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ABAdapter;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.browser.ipc.IACCSExtensionProxy;
import com.taobao.browser.ipc.ProcessUtils;
import com.taobao.process.interaction.common.PRProxy;
import com.taobao.tao.Globals;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class TBACCS extends WVACCS {
    private static final String TAG = "TBWVACCS";
    private static final String serviceClassName = "com.taobao.accs.windvane.BrowserACCSService";
    private static final String serviceIdDefault = "windvane";

    private void bindService(WVCallBackContext wVCallBackContext, String str) {
        String str2;
        try {
            str2 = new JSONObject(str).optString("serviceId", "");
        } catch (JSONException unused) {
            wVCallBackContext.error(new WVResult("HY_PARAM_ERR"));
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            wVCallBackContext.error(new WVResult("HY_PARAM_ERR"));
            return;
        }
        if (this.serviceIdList == null) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                this.serviceIdList = arrayList;
                arrayList.add("windvane");
                ACCSManager.registerSerivce(this.mContext.getApplicationContext(), "windvane", serviceClassName);
                if (!ProcessUtils.isMainProcess(Globals.getApplication())) {
                    ((IACCSExtensionProxy) PRProxy.get(IACCSExtensionProxy.class)).registerSerivce("windvane", serviceClassName);
                }
            } catch (Exception unused2) {
            }
        }
        if (this.serviceIdList.contains(str2)) {
            wVCallBackContext.success();
        } else if (this.mContext != null) {
            this.serviceIdList.add(str2);
            ACCSManager.registerSerivce(this.mContext.getApplicationContext(), str2, serviceClassName);
            if (!ProcessUtils.isMainProcess(Globals.getApplication())) {
                ((IACCSExtensionProxy) PRProxy.get(IACCSExtensionProxy.class)).registerSerivce(str2, serviceClassName);
            }
            wVCallBackContext.success();
        } else {
            wVCallBackContext.error();
        }
    }

    @Override // android.taobao.windvane.extra.jsbridge.WVACCS, android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        boolean z;
        ALog.d(TAG, "execute", "action", str, "params", str2);
        if ("bindService".equals(str)) {
            bindService(wVCallBackContext, str2);
            return true;
        } else if ("isConnect".equals(str)) {
            try {
                WVResult wVResult = new WVResult();
                wVResult.addData("status", Boolean.valueOf(ACCSClient.getAccsClient().isAccsConnected()));
                wVCallBackContext.success(wVResult);
            } catch (Exception e) {
                ALog.e(TAG, "execute err", e, new Object[0]);
            }
            return true;
        } else if ("isFeatureOpened".equals(str)) {
            WVResult wVResult2 = new WVResult();
            if (TextUtils.isEmpty(str2)) {
                z = false;
            } else {
                z = (Constants.SP_KEY_NATIVE_ACCS_SWITCH.equals(str2) ? OrangeAdapter.isNativeAccsEnabledForWindvane() : false) | ABAdapter.isFeatureOpened(str2);
            }
            wVResult2.addData("status", Boolean.valueOf(z));
            wVCallBackContext.success(wVResult2);
            ALog.e(TAG, "execute isFeatureOpened", "params", str2, "opened", Boolean.valueOf(z));
            return true;
        } else {
            return super.execute(str, str2, wVCallBackContext);
        }
    }
}
