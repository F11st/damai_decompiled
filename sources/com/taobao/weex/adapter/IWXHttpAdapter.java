package com.taobao.weex.adapter;

import com.taobao.weex.common.WXRequest;
import com.taobao.weex.common.WXResponse;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IWXHttpAdapter {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnHttpListener {
        void onHeadersReceived(int i, Map<String, List<String>> map);

        void onHttpFinish(WXResponse wXResponse);

        void onHttpResponseProgress(int i);

        void onHttpStart();

        void onHttpUploadProgress(int i);
    }

    void sendRequest(WXRequest wXRequest, OnHttpListener onHttpListener);
}
