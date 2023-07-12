package com.taobao.orange.sync;

import android.text.TextUtils;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.impl.HurlNetConnection;
import com.taobao.orange.impl.TBNetConnection;
import com.taobao.orange.inner.INetConnection;
import com.taobao.orange.util.MD5Util;
import com.taobao.orange.util.OLog;
import mtopsdk.common.util.HttpHeaderConstant;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class BaseCdnRequest<T> extends BaseRequest<T> {
    private static final String TAG = "CdnRequest";
    private String mMD5;
    private String mUrl;

    public BaseCdnRequest(String str, String str2) {
        this.mUrl = str;
        this.mMD5 = str2;
    }

    protected abstract T parseResContent(String str);

    @Override // com.taobao.orange.sync.BaseRequest
    public T syncRequest() {
        String str;
        int responseCode;
        if (OLog.isPrintLog(1)) {
            OLog.d(TAG, "syncRequest start", "cdn url", this.mUrl);
        }
        try {
            INetConnection newInstance = GlobalOrange.netConnection.newInstance();
            int i = newInstance instanceof HurlNetConnection ? GlobalOrange.reqRetryNum : 1;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    str = null;
                    break;
                }
                try {
                    newInstance.openConnection(this.mUrl);
                    newInstance.setMethod("GET");
                    if (newInstance instanceof TBNetConnection) {
                        newInstance.addHeader(HttpHeaderConstant.F_REFER, "orange");
                    }
                    newInstance.connect();
                    responseCode = newInstance.getResponseCode();
                    this.code = responseCode;
                } finally {
                    try {
                        newInstance.disconnect();
                        i2++;
                    } finally {
                    }
                }
                if (responseCode == 200) {
                    str = newInstance.getResponse();
                    break;
                }
                continue;
                newInstance.disconnect();
                i2++;
            }
            if (TextUtils.isEmpty(str)) {
                this.code = -2;
                this.message = "content is empty";
                OLog.e(TAG, "syncRequest fail", "code", -2, "msg", this.message);
                return null;
            } else if (!TextUtils.isEmpty(this.mMD5) && !this.mMD5.equals(MD5Util.md5(str))) {
                this.code = -3;
                this.message = "content is broken";
                OLog.e(TAG, "syncRequest fail", "code", -3, "msg", this.message);
                return null;
            } else {
                try {
                    return parseResContent(str);
                } catch (Throwable th) {
                    this.code = -4;
                    this.message = th.getMessage();
                    OLog.e(TAG, "syncRequest fail", th, new Object[0]);
                    return null;
                }
            }
        } catch (Throwable th2) {
            OLog.e(TAG, "syncRequest", th2, new Object[0]);
            this.message = th2.getMessage();
            return null;
        }
    }
}
