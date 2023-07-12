package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.view.PopupWindowController;
import android.text.TextUtils;
import android.view.View;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVUIActionSheet extends WVApiPlugin {
    private static final String TAG = "WVUIActionSheet";
    private String _index;
    private PopupWindowController mPopupWindowController;
    private WVCallBackContext mCallback = null;
    private View.OnClickListener popupClickListener = new View.OnClickListener() { // from class: android.taobao.windvane.jsbridge.api.WVUIActionSheet.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WVResult wVResult = new WVResult();
            wVResult.addData("type", (String) view.getTag());
            wVResult.addData("_index", WVUIActionSheet.this._index);
            if (TaoLog.getLogStatus()) {
                TaoLog.d("WVUIActionSheet", "ActionSheet: click: 8.5.0");
            }
            WVUIActionSheet.this.mPopupWindowController.hide();
            wVResult.setSuccess();
            WVUIActionSheet.this.mCallback.success(wVResult);
            WVUIActionSheet.this.mCallback.fireEvent("wv.actionsheet", wVResult.toJsonString());
        }
    };

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("show".equals(str)) {
            show(wVCallBackContext, str2);
            return true;
        }
        return false;
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onDestroy() {
        this.mCallback = null;
    }

    public synchronized void show(WVCallBackContext wVCallBackContext, String str) {
        String[] strArr;
        String str2;
        String[] strArr2 = null;
        if (TextUtils.isEmpty(str)) {
            str2 = null;
            strArr = null;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("title");
                this._index = jSONObject.optString("_index");
                JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
                if (optJSONArray != null) {
                    if (optJSONArray.length() > 8) {
                        TaoLog.w("WVUIActionSheet", "WVUIDialog: ActionSheet is too long, limit 8");
                        WVResult wVResult = new WVResult();
                        wVResult.setResult("HY_PARAM_ERR");
                        wVResult.addData("msg", "ActionSheet is too long. limit 8");
                        wVCallBackContext.error(wVResult);
                        return;
                    }
                    strArr2 = new String[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        strArr2[i] = optJSONArray.optString(i);
                    }
                }
                strArr = strArr2;
                str2 = optString;
            } catch (JSONException unused) {
                TaoLog.e("WVUIActionSheet", "WVUIDialog: param parse to JSON error, param=" + str);
                WVResult wVResult2 = new WVResult();
                wVResult2.setResult("HY_PARAM_ERR");
                wVCallBackContext.error(wVResult2);
                return;
            }
        }
        this.mCallback = wVCallBackContext;
        try {
            PopupWindowController popupWindowController = new PopupWindowController(this.mContext, this.mWebView.getView(), str2, strArr, this.popupClickListener);
            this.mPopupWindowController = popupWindowController;
            popupWindowController.show();
            TaoLog.d("WVUIActionSheet", "ActionSheet: show");
        } catch (Exception e) {
            TaoLog.w("WVUIActionSheet", e.getMessage());
            WVResult wVResult3 = new WVResult();
            wVResult3.addData("errMsg", e.getMessage());
            wVCallBackContext.error(wVResult3);
        }
    }
}
