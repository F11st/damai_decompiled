package cn.damai.seatdecoder.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public abstract class BaseDecodeResult<T> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DECODE_DECOMPRESS_ERROR = -4033;
    public static final int DECODE_OK = 1;
    public static final int DECODE_OTHER_ERROR = -1;
    public static final int DECODE_SERIALIZE_ERROR = -4037;
    public String message;
    protected T result;
    private int resultCode = -1;

    public String getMessage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1772967374") ? (String) ipChange.ipc$dispatch("-1772967374", new Object[]{this}) : this.message;
    }

    public T getResult() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-983814630") ? (T) ipChange.ipc$dispatch("-983814630", new Object[]{this}) : this.result;
    }

    public int getResultCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2076645726") ? ((Integer) ipChange.ipc$dispatch("2076645726", new Object[]{this})).intValue() : this.resultCode;
    }

    public void setMessage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-743667324")) {
            ipChange.ipc$dispatch("-743667324", new Object[]{this, str});
        } else {
            this.message = str;
        }
    }

    public void setResult(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1424375448")) {
            ipChange.ipc$dispatch("-1424375448", new Object[]{this, t});
        } else {
            this.result = t;
        }
    }

    public void setResultCode(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-988614908")) {
            ipChange.ipc$dispatch("-988614908", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.resultCode = i;
        }
    }
}
