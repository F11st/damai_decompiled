package mtopsdk.mtop.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.util.ErrorConstant;
import mtopsdk.mtop.util.MtopStatistics;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopResponse implements Serializable, IMTOPDataObject {
    private static final String SHARP = "::";
    private static final String TAG = "mtopsdk.MtopResponse";
    private static final long serialVersionUID = 1566423746968673499L;
    private String api;
    private byte[] bytedata;
    @Deprecated
    private byte[] data;
    private JSONObject dataJsonObject;
    private Map<String, List<String>> headerFields;
    public String mappingCode;
    public String mappingCodeSuffix;
    private MtopStatistics mtopStat;
    private int responseCode;
    @Deprecated
    private String[] ret;
    private String retCode;
    private String retMsg;
    private String v;
    private volatile boolean bParsed = false;
    private ResponseSource responseSource = ResponseSource.NETWORK_REQUEST;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum ResponseSource {
        FRESH_CACHE,
        EXPIRED_CACHE,
        NETWORK_REQUEST
    }

    public MtopResponse() {
    }

    public String getApi() {
        if (this.api == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.api;
    }

    public byte[] getBytedata() {
        return this.bytedata;
    }

    @Deprecated
    public byte[] getData() {
        return this.data;
    }

    public JSONObject getDataJsonObject() {
        if (this.dataJsonObject == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.dataJsonObject;
    }

    public String getFullKey() {
        if (StringUtils.isBlank(this.api) || StringUtils.isBlank(this.v)) {
            return null;
        }
        return StringUtils.concatStr2LowerCase(this.api, this.v);
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.headerFields;
    }

    public String getMappingCode() {
        return this.mappingCode;
    }

    public MtopStatistics getMtopStat() {
        return this.mtopStat;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getResponseLog() {
        StringBuilder sb = new StringBuilder(128);
        try {
            sb.append("MtopResponse[ api=");
            sb.append(this.api);
            sb.append(",v=");
            sb.append(this.v);
            sb.append(",retCode=");
            sb.append(this.retCode);
            sb.append(",retMsg=");
            sb.append(this.retMsg);
            sb.append(",mappingCode=");
            sb.append(this.mappingCode);
            sb.append(",mappingCodeSuffix=");
            sb.append(this.mappingCodeSuffix);
            sb.append(",ret=");
            sb.append(Arrays.toString(this.ret));
            sb.append(",responseCode=");
            sb.append(this.responseCode);
            sb.append(",headerFields=");
            sb.append(this.headerFields);
            sb.append(jn1.ARRAY_END_STR);
            return sb.toString();
        } catch (Throwable unused) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                TBSdkLog.e(TAG, "[getResponseLog]MtopResponse get log error, api=" + this.api + ",v=" + this.v);
            }
            return super.toString();
        }
    }

    @Deprecated
    public String[] getRet() {
        if (this.ret == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.ret;
    }

    public String getRetCode() {
        return this.retCode;
    }

    public String getRetMsg() {
        if (this.retMsg == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.retMsg;
    }

    public ResponseSource getSource() {
        return this.responseSource;
    }

    public String getV() {
        if (this.v == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.v;
    }

    public boolean is41XResult() {
        return ErrorConstant.is41XResult(getRetCode());
    }

    public boolean isApiLockedAndRequestQueued() {
        return 420 == this.responseCode && "FAIL_SYS_REQUEST_QUEUED".equalsIgnoreCase(getRetCode());
    }

    public boolean isApiLockedResult() {
        return 420 == this.responseCode || ErrorConstant.isApiLockedResult(getRetCode());
    }

    public boolean isApiSuccess() {
        return ErrorConstant.isSuccess(getRetCode()) && getBytedata() != null;
    }

    public boolean isExpiredRequest() {
        return ErrorConstant.isExpiredRequest(getRetCode());
    }

    @Deprecated
    public boolean isIllegelSign() {
        return ErrorConstant.isIllegelSign(getRetCode());
    }

    public boolean isMtopSdkError() {
        return ErrorConstant.isMtopSdkError(getRetCode());
    }

    public boolean isMtopServerError() {
        return ErrorConstant.isMtopServerError(getRetCode());
    }

    public boolean isNetworkError() {
        return ErrorConstant.isNetworkError(getRetCode());
    }

    public boolean isNoNetwork() {
        return ErrorConstant.isNoNetwork(getRetCode());
    }

    public boolean isSessionInvalid() {
        return ErrorConstant.isSessionInvalid(getRetCode());
    }

    @Deprecated
    public boolean isSystemError() {
        return ErrorConstant.isSystemError(getRetCode());
    }

    public void parseJsonByte() {
        String[] split;
        if (this.bParsed) {
            return;
        }
        synchronized (this) {
            if (this.bParsed) {
                return;
            }
            byte[] bArr = this.bytedata;
            if (bArr != null && bArr.length != 0) {
                String str = new String(bArr);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.d(TAG, "[parseJsonByte]MtopResponse bytedata : " + str);
                }
                JSONObject jSONObject = new JSONObject(str);
                if (this.api == null) {
                    this.api = jSONObject.getString("api");
                }
                if (this.v == null) {
                    this.v = jSONObject.getString("v");
                }
                JSONArray jSONArray = jSONObject.getJSONArray("ret");
                int length = jSONArray.length();
                this.ret = new String[length];
                for (int i = 0; i < length; i++) {
                    this.ret[i] = jSONArray.getString(i);
                }
                if (length > 0) {
                    String str2 = this.ret[0];
                    if (StringUtils.isNotBlank(str2) && (split = str2.split(SHARP)) != null && split.length > 1) {
                        if (StringUtils.isBlank(this.retCode)) {
                            this.retCode = split[0];
                        }
                        if (StringUtils.isBlank(this.retMsg)) {
                            this.retMsg = split[1];
                        }
                    }
                }
                this.dataJsonObject = jSONObject.optJSONObject("data");
                this.bParsed = true;
                return;
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                TBSdkLog.e(TAG, "[parseJsonByte]MtopResponse bytedata is blank,api=" + this.api + ",v=" + this.v);
            }
            if (StringUtils.isBlank(this.retCode)) {
                this.retCode = ErrorConstant.ERRCODE_JSONDATA_BLANK;
            }
            if (StringUtils.isBlank(this.retMsg)) {
                this.retMsg = ErrorConstant.ERRMSG_JSONDATA_BLANK;
            }
            this.bParsed = true;
        }
    }

    public void setApi(String str) {
        this.api = str;
    }

    public void setBytedata(byte[] bArr) {
        this.bytedata = bArr;
    }

    @Deprecated
    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setDataJsonObject(JSONObject jSONObject) {
        this.dataJsonObject = jSONObject;
    }

    public void setHeaderFields(Map<String, List<String>> map) {
        this.headerFields = map;
    }

    public void setMtopStat(MtopStatistics mtopStatistics) {
        this.mtopStat = mtopStatistics;
    }

    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    @Deprecated
    public void setRet(String[] strArr) {
        this.ret = strArr;
    }

    public void setRetCode(String str) {
        this.retCode = str;
    }

    public void setRetMsg(String str) {
        this.retMsg = str;
    }

    public void setSource(ResponseSource responseSource) {
        this.responseSource = responseSource;
    }

    public void setV(String str) {
        this.v = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        try {
            sb.append("MtopResponse[ api=");
            sb.append(this.api);
            sb.append(",v=");
            sb.append(this.v);
            sb.append(",retCode=");
            sb.append(this.retCode);
            sb.append(",retMsg=");
            sb.append(this.retMsg);
            sb.append(",mappingCode=");
            sb.append(this.mappingCode);
            sb.append(",mappingCodeSuffix=");
            sb.append(this.mappingCodeSuffix);
            sb.append(",ret=");
            sb.append(Arrays.toString(this.ret));
            sb.append(",data=");
            sb.append(this.dataJsonObject);
            sb.append(",responseCode=");
            sb.append(this.responseCode);
            sb.append(",headerFields=");
            sb.append(this.headerFields);
            sb.append(",bytedata=");
            byte[] bArr = this.bytedata;
            sb.append(bArr == null ? null : new String(bArr));
            sb.append(jn1.ARRAY_END_STR);
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return super.toString();
        }
    }

    public MtopResponse(String str, String str2) {
        this.retCode = str;
        this.retMsg = str2;
    }

    public MtopResponse(String str, String str2, String str3, String str4) {
        this.api = str;
        this.v = str2;
        this.retCode = str3;
        this.retMsg = str4;
    }
}
