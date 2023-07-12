package com.taobao.orange.sync;

import android.text.TextUtils;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.OConstant;
import com.taobao.orange.impl.HmacSign;
import com.taobao.orange.impl.HurlNetConnection;
import com.taobao.orange.impl.TBGuardSign;
import com.taobao.orange.impl.TBNetConnection;
import com.taobao.orange.inner.INetConnection;
import com.taobao.orange.inner.ISign;
import com.taobao.orange.util.MD5Util;
import com.taobao.orange.util.OLog;
import com.taobao.orange.util.OrangeUtils;
import com.taobao.weex.annotation.JSMethod;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.jg1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class BaseAuthRequest<T> extends BaseRequest<T> {
    private static final String CURVER_SIGN = "1.0";
    private static final String REQUEST_APP_KEY = "o-app-key";
    private static final String REQUEST_APP_VERSION = "o-app-version";
    private static final String REQUEST_DEVICEID = "o-device-id";
    private static final String REQUEST_HOST = "host";
    private static final String REQUEST_NUMBER = "o-request-unique";
    private static final String REQUEST_SDK_VERSION = "o-sdk-version";
    private static final String REQUEST_SIGN_INFO = "o-sign";
    private static final String REQUEST_SIGN_VERSION = "o-sign-version";
    private static final String REQUEST_TIMESTAMP = "o-timestamp";
    private static final String REQUEST_USER_INFO = "o-user-info";
    private static final String RESPONSE_CODE = "o-code";
    private static final String RESPONSE_CODE_EXPIRED = "10002";
    private static final String RESPONSE_SERVER_TIMESTAMP = "o-server-timestamp";
    private static final String SIGN_SEPARETOR = "&";
    private static final String TAG = "AuthRequest";
    private long mCurTimestamp;
    private String mHost;
    private boolean mIsAckReq;
    private String mMD5;
    private long mRealCurTimestamp;
    private String mReqNo;
    private String mReqType;
    private ISign mSign;

    public BaseAuthRequest(String str, boolean z, String str2) {
        this.mMD5 = str;
        this.mIsAckReq = z;
        this.mHost = z ? GlobalOrange.ackHost : GlobalOrange.dcHost;
        this.mReqType = str2;
        updateReqTimestamp();
        if (TextUtils.isEmpty(GlobalOrange.appSecret)) {
            this.mSign = new TBGuardSign();
        } else {
            this.mSign = new HmacSign();
        }
    }

    private void checkResposeHeads(Map<String, List<String>> map) {
        if (map == null || map.isEmpty() || !"10002".equals(OrangeUtils.getDecodeValue(map.get(RESPONSE_CODE).get(0)))) {
            return;
        }
        OLog.w(TAG, "checkResposeHeads", "expired, correct timestamp");
        long parseLong = OrangeUtils.parseLong(OrangeUtils.getDecodeValue(map.get(RESPONSE_SERVER_TIMESTAMP).get(0)));
        if (parseLong != 0) {
            long j = this.mRealCurTimestamp;
            if (j != 0) {
                long j2 = parseLong - j;
                OLog.w(TAG, "checkResposeHeads update global", "reqTimestampOffset(s)", Long.valueOf(j2), "server", Long.valueOf(parseLong), "client", Long.valueOf(this.mCurTimestamp), "relClient", Long.valueOf(this.mRealCurTimestamp));
                GlobalOrange.reqTimestampOffset = j2;
                updateReqTimestamp();
            }
        }
    }

    private void formatNetConnection(INetConnection iNetConnection, String str) throws Throwable {
        String encodeValue = OrangeUtils.getEncodeValue(GlobalOrange.appKey);
        String encodeValue2 = OrangeUtils.getEncodeValue(GlobalOrange.appVersion);
        String encodeValue3 = OrangeUtils.getEncodeValue(GlobalOrange.deviceId);
        String reqPostBody = getReqPostBody();
        String encodeValue4 = OrangeUtils.getEncodeValue(getSignInfoHeader(reqPostBody));
        if (!TextUtils.isEmpty(encodeValue) && !TextUtils.isEmpty(encodeValue3) && !TextUtils.isEmpty(encodeValue2) && !TextUtils.isEmpty(encodeValue4)) {
            iNetConnection.setParams(getReqParams());
            iNetConnection.openConnection(str);
            if (this.mIsAckReq) {
                iNetConnection.addHeader(REQUEST_NUMBER, OrangeUtils.getEncodeValue(this.mReqNo));
            }
            iNetConnection.addHeader(REQUEST_TIMESTAMP, OrangeUtils.getEncodeValue(String.valueOf(this.mCurTimestamp)));
            iNetConnection.addHeader(REQUEST_SIGN_VERSION, OrangeUtils.getEncodeValue("1.0"));
            iNetConnection.addHeader(REQUEST_SDK_VERSION, OrangeUtils.getEncodeValue("1.6.5.2"));
            iNetConnection.addHeader(REQUEST_APP_KEY, encodeValue);
            iNetConnection.addHeader(REQUEST_APP_VERSION, encodeValue2);
            iNetConnection.addHeader(REQUEST_DEVICEID, encodeValue3);
            iNetConnection.addHeader(REQUEST_SIGN_INFO, encodeValue4);
            if (iNetConnection instanceof TBNetConnection) {
                iNetConnection.addHeader(HttpHeaderConstant.F_REFER, "orange");
            }
            String str2 = GlobalOrange.userId;
            if (!TextUtils.isEmpty(str2)) {
                iNetConnection.addHeader(REQUEST_USER_INFO, str2);
            }
            iNetConnection.addHeader("host", OrangeUtils.getEncodeValue(this.mHost));
            if (!TextUtils.isEmpty(reqPostBody)) {
                iNetConnection.setMethod("POST");
                iNetConnection.setBody(reqPostBody.getBytes());
            } else {
                iNetConnection.setMethod("GET");
            }
            iNetConnection.connect();
            return;
        }
        OLog.e(TAG, "getRequestImpl error", "signInfo", encodeValue4, "appKey", encodeValue, "appVersion", encodeValue2, "deviceId", encodeValue3);
    }

    private String formateReqUrl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(GlobalOrange.env == OConstant.ENV.ONLINE ? "https" : "http");
        sb.append(jg1.SCHEME_SLASH);
        sb.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        return sb.toString();
    }

    private String getSignInfoHeader(String str) {
        StringBuilder sb = new StringBuilder(this.mReqType);
        sb.append("&");
        sb.append(GlobalOrange.appKey);
        sb.append("&");
        sb.append(GlobalOrange.appVersion);
        sb.append("&");
        sb.append(GlobalOrange.deviceId);
        sb.append("&");
        sb.append(this.mCurTimestamp);
        if (this.mIsAckReq) {
            sb.append("&");
            sb.append(this.mReqNo);
            if (!TextUtils.isEmpty(str)) {
                sb.append("&");
                sb.append(str);
            }
        }
        return this.mSign.sign(GlobalOrange.context, GlobalOrange.appKey, GlobalOrange.appSecret, sb.toString(), GlobalOrange.authCode);
    }

    private void updateReqTimestamp() {
        this.mRealCurTimestamp = System.currentTimeMillis() / 1000;
        this.mCurTimestamp = (System.currentTimeMillis() / 1000) + GlobalOrange.reqTimestampOffset;
        this.mReqNo = GlobalOrange.deviceId + JSMethod.NOT_SET + this.mCurTimestamp;
    }

    protected abstract Map<String, String> getReqParams();

    protected abstract String getReqPostBody();

    protected abstract T parseResContent(String str);

    @Override // com.taobao.orange.sync.BaseRequest
    public T syncRequest() {
        String str;
        int responseCode;
        if (OLog.isPrintLog(1)) {
            OLog.d(TAG, "syncRequest start", "isAckReq", Boolean.valueOf(this.mIsAckReq), "reqType", this.mReqType);
        }
        if (TextUtils.isEmpty(GlobalOrange.deviceId)) {
            this.code = -6;
            this.message = "utdid is null";
            OLog.e(TAG, "syncRequest fail", "code", -6, "message", this.message);
            return null;
        }
        try {
            INetConnection newInstance = GlobalOrange.netConnection.newInstance();
            if (newInstance instanceof HurlNetConnection) {
                List<String> randomListFromSet = OrangeUtils.randomListFromSet(this.mIsAckReq ? GlobalOrange.ackVips : GlobalOrange.dcVips);
                randomListFromSet.add(0, this.mHost);
                for (String str2 : randomListFromSet) {
                    try {
                        formatNetConnection(newInstance, formateReqUrl(str2, this.mReqType));
                        responseCode = newInstance.getResponseCode();
                        this.code = responseCode;
                    } finally {
                        try {
                            if (OLog.isPrintLog(3)) {
                                OLog.w(TAG, "syncRequest fail", th, "host", str2);
                            }
                            newInstance.disconnect();
                        } finally {
                        }
                    }
                    if (responseCode == 200) {
                        checkResposeHeads(newInstance.getHeadFields());
                        str = newInstance.getResponse();
                        break;
                    }
                    continue;
                    newInstance.disconnect();
                }
                str = null;
            } else {
                try {
                    formatNetConnection(newInstance, formateReqUrl(this.mHost, this.mReqType));
                    int responseCode2 = newInstance.getResponseCode();
                    this.code = responseCode2;
                    if (responseCode2 == 200) {
                        checkResposeHeads(newInstance.getHeadFields());
                        str = newInstance.getResponse();
                    } else {
                        str = null;
                    }
                } catch (Throwable th) {
                    try {
                        if (OLog.isPrintLog(r4)) {
                            OLog.w(TAG, "syncRequest fail", th, "host", this.mHost);
                        }
                        this.message = th.getMessage();
                    } finally {
                    }
                }
            }
            if (this.mIsAckReq) {
                return null;
            }
            if (TextUtils.isEmpty(str)) {
                this.code = -2;
                this.message = "content is empty";
                OLog.e(TAG, "syncRequest fail", "code", -2, "message", this.message);
                return null;
            } else if (!TextUtils.isEmpty(this.mMD5) && !this.mMD5.equals(MD5Util.md5(str))) {
                this.code = -3;
                this.message = "content is broken";
                OLog.e(TAG, "syncRequest fail", "code", -3, "message", this.message);
                return null;
            } else {
                try {
                    return parseResContent(str);
                } catch (Throwable th2) {
                    this.code = -4;
                    this.message = th2.getMessage();
                    OLog.e(TAG, "syncRequest fail", th2, new Object[0]);
                    return null;
                }
            }
        } catch (Throwable th3) {
            OLog.e(TAG, "syncRequest", th3, new Object[0]);
            this.message = th3.getMessage();
            return null;
        }
    }
}
