package com.alibaba.motu.tbrest.rest;

import com.alibaba.motu.tbrest.SendAsyncExecutor;
import com.alibaba.motu.tbrest.data.RestData;
import com.alibaba.motu.tbrest.request.BizResponse;
import com.alibaba.motu.tbrest.request.UrlWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RestSender {
    private static final SendAsyncExecutor sendExecutor = new SendAsyncExecutor();
    private UrlWrapperSender innerSender = new UrlWrapperSender();

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Callback {
        void onFailed(RestData restData);

        void onSuccess(RestData restData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class UrlWrapperSender {
        UrlWrapperSender() {
        }

        boolean innerSendRestData(String str, String str2, byte[] bArr) {
            BizResponse sendRequest;
            try {
                if (str != null) {
                    sendRequest = UrlWrapper.sendRequest(str2, bArr);
                } else {
                    sendRequest = UrlWrapper.sendRequest(str, str2, bArr);
                }
                return sendRequest.isSuccess();
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean innerSendRestData(String str, String str2, byte[] bArr) {
        return this.innerSender.innerSendRestData(str, str2, bArr);
    }

    public void sendRestDataAsync(final RestData restData, final Callback callback) {
        sendExecutor.start(new Runnable() { // from class: com.alibaba.motu.tbrest.rest.RestSender.1
            @Override // java.lang.Runnable
            public void run() {
                boolean innerSendRestData = RestSender.this.innerSendRestData(restData.getAppKey(), restData.getUrl(), restData.getPackRequest());
                Callback callback2 = callback;
                if (callback2 != null) {
                    if (innerSendRestData) {
                        callback2.onSuccess(restData);
                    } else {
                        callback2.onFailed(restData);
                    }
                }
            }
        });
    }

    public boolean sendRestDataSync(RestData restData) {
        return innerSendRestData(restData.getAppKey(), restData.getUrl(), restData.getPackRequest());
    }
}
