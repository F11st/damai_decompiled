package android.taobao.windvane.extra.jsbridge;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVACCS extends WVApiPlugin {
    private static final String serviceClassName = "android.taobao.windvane.extra.jsbridge.WVACCSService";
    private static final String serviceIdDefault = "windvane";
    private ArrayList<String> serviceIdList = new ArrayList<>();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class ACCSWVEventListener implements WVEventListener {
        private WeakReference<IWVWebView> webview;

        public ACCSWVEventListener(IWVWebView iWVWebView) {
            this.webview = new WeakReference<>(iWVWebView);
        }

        @Override // android.taobao.windvane.service.WVEventListener
        public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
            IWVWebView iWVWebView = this.webview.get();
            if (iWVWebView == null) {
                if (TaoLog.getLogStatus()) {
                    TaoLog.e("ACCS", "webview is recycled");
                }
                return null;
            }
            switch (i) {
                case 5001:
                    String str = (String) objArr[0];
                    String str2 = new String((byte[]) objArr[1]);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("serviceId", str);
                        jSONObject.put("resultData", str2);
                        String jSONObject2 = jSONObject.toString();
                        iWVWebView.fireEvent("WV.Event.ACCS.OnData", jSONObject2);
                        if (TaoLog.getLogStatus()) {
                            TaoLog.i("ACCS", jSONObject2);
                            break;
                        }
                    } catch (Throwable unused) {
                        break;
                    }
                    break;
                case 5002:
                    iWVWebView.fireEvent("WV.Event.ACCS.OnConnected", "{}");
                    if (TaoLog.getLogStatus()) {
                        TaoLog.e("ACCS", "ACCS connect");
                        break;
                    }
                    break;
                case 5003:
                    iWVWebView.fireEvent("WV.Event.ACCS.OnDisConnected", "{}");
                    if (TaoLog.getLogStatus()) {
                        TaoLog.e("ACCS", "ACCS disconnect");
                        break;
                    }
                    break;
            }
            return null;
        }
    }

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
            } catch (Exception unused2) {
            }
        }
        if (this.serviceIdList.contains(str2)) {
            wVCallBackContext.success();
        } else if (this.mContext != null) {
            this.serviceIdList.add(str2);
            ACCSManager.registerSerivce(this.mContext.getApplicationContext(), str2, serviceClassName);
            wVCallBackContext.success();
        } else {
            wVCallBackContext.error();
        }
    }

    private void connectionState(WVCallBackContext wVCallBackContext, String str) {
        WVResult wVResult = new WVResult();
        try {
            if (ACCSManager.getChannelState(this.mContext) == null) {
                wVResult.addData("status", "false");
                wVCallBackContext.error();
            }
        } catch (Exception unused) {
            wVResult.addData("status", "false");
            wVCallBackContext.error();
        }
        wVResult.addData("status", "true");
        wVCallBackContext.success(wVResult);
    }

    private void init(Context context) {
        WVEventService.getInstance().addEventListener(new ACCSWVEventListener(this.mWebView));
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setData(android.taobao.windvane.jsbridge.WVCallBackContext r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.jsbridge.WVACCS.setData(android.taobao.windvane.jsbridge.WVCallBackContext, java.lang.String):void");
    }

    private void unBindService(WVCallBackContext wVCallBackContext, String str) {
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
            this.serviceIdList = new ArrayList<>();
        }
        if (!this.serviceIdList.contains(str2)) {
            wVCallBackContext.success();
        } else if (this.mContext != null) {
            this.serviceIdList.remove(str2);
            ACCSManager.unregisterService(this.mContext.getApplicationContext(), str2);
            wVCallBackContext.success();
        } else {
            wVCallBackContext.error();
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("bindService".equals(str)) {
            bindService(wVCallBackContext, str2);
            return true;
        } else if ("unBindService".equals(str)) {
            unBindService(wVCallBackContext, str2);
            return true;
        } else if ("setData".equals(str)) {
            setData(wVCallBackContext, str2);
            return true;
        } else if ("connectionState".equals(str)) {
            connectionState(wVCallBackContext, str2);
            return true;
        } else {
            return false;
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void initialize(Context context, IWVWebView iWVWebView) {
        super.initialize(context, iWVWebView);
        init(context);
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onDestroy() {
        if (this.mContext != null && this.serviceIdList != null) {
            for (int i = 0; i < this.serviceIdList.size(); i++) {
                ACCSManager.unregisterService(this.mContext.getApplicationContext(), this.serviceIdList.get(i));
            }
            this.serviceIdList.clear();
            this.serviceIdList = null;
        }
        super.onDestroy();
    }
}
