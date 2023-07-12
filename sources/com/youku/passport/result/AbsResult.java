package com.youku.passport.result;

import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.fastjson.annotation.JSONField;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public abstract class AbsResult {
    public static final int ERROR_API_LIMIT = -103;
    public static final int ERROR_CANCEL = -105;
    public static final int ERROR_LOGOUT_TB = 889;
    public static final int ERROR_NOT_INSTALL_YOUKU = -107;
    public static final int ERROR_NOT_LOGIN = -106;
    public static final int ERROR_NO_NETWORK = -102;
    public static final int ERROR_PARAM_INVALID = -104;
    public static final int ERROR_SNS_UNBOUND = 628;
    public static final int ERROR_UNKNOWN = -101;
    public static final int ERROR_VERSION_NEED_UPDATE = -108;
    public static final int ERROR_WECHAT_UNINSTALLED = -1000;
    public static final String MSG_ERROR_API_LIMIT = "被挤爆了，请稍候再试";
    public static final String MSG_ERROR_PARAM_INVALID = "参数错误";
    public static final String MSG_ERROR_UNKNOWN = "系统开小差，请重试";
    public static final String MSG_NO_NETWORK = "当前没有网络，请检查网络连接是否正常";
    public static final String MSG_SUCCESS = "Success";
    public static final int SLIDER_CAPTCHA_ERROR = 314;
    public static final int SUCCESS = 0;
    protected transient SparseArray<String> mMsgMap;
    @JSONField(name = "resultCode")
    private int mResultCode = -101;
    @JSONField(name = "resultMsg")
    private String mResultMsg;

    public AbsResult() {
        SparseArray<String> sparseArray = new SparseArray<>();
        this.mMsgMap = sparseArray;
        sparseArray.put(0, MSG_SUCCESS);
        this.mMsgMap.put(-102, MSG_NO_NETWORK);
        this.mMsgMap.put(-101, MSG_ERROR_UNKNOWN);
        this.mMsgMap.put(-103, MSG_ERROR_API_LIMIT);
        this.mMsgMap.put(-104, "参数错误");
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public String getResultMsg() {
        SparseArray<String> sparseArray;
        int i;
        if (TextUtils.isEmpty(this.mResultMsg)) {
            if (this.mMsgMap.get(this.mResultCode) != null) {
                sparseArray = this.mMsgMap;
                i = this.mResultCode;
            } else {
                sparseArray = this.mMsgMap;
                i = -101;
            }
            return sparseArray.get(i);
        }
        return this.mResultMsg;
    }

    public void setResultCode(int i) {
        this.mResultCode = i;
    }

    public void setResultMsg(String str) {
        this.mResultMsg = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject;
        Throwable th;
        try {
            jSONObject = new JSONObject();
        } catch (Throwable th2) {
            jSONObject = null;
            th = th2;
        }
        try {
            jSONObject.put("resultCode", this.mResultCode);
            jSONObject.put("resultMsg", getResultMsg());
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }
}
