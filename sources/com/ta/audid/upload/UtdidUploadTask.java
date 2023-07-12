package com.ta.audid.upload;

import android.content.Context;
import android.text.TextUtils;
import com.ta.audid.store.UtdidContentBuilder;
import com.ta.audid.store.UtdidContentUtil;
import com.ta.audid.utils.NetworkInfoUtils;
import com.ta.audid.utils.UtdidLogger;
import com.ta.utdid2.device.AppUtdid;
import com.ta.utdid2.device.UtdidResponse;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class UtdidUploadTask implements Runnable {
    private static final String POST_HTTP_URL = "https://audid-api.taobao.com/v2.0/a/audid/req/";
    private static volatile boolean bRunning;
    private Context mContext;

    public UtdidUploadTask(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    private String buildPostData() {
        String currentAppUtdid = AppUtdid.getInstance().getCurrentAppUtdid();
        if (TextUtils.isEmpty(currentAppUtdid)) {
            return null;
        }
        String buildUDID = UtdidContentBuilder.buildUDID(currentAppUtdid);
        if (UtdidLogger.isDebug()) {
            UtdidLogger.sd("", buildUDID);
        }
        return UtdidContentUtil.getEncodedContent(buildUDID);
    }

    private boolean reqServer(String str) {
        HttpResponse sendRequest = HttpUtils.sendRequest(POST_HTTP_URL, str, true);
        if (sendRequest == null) {
            return false;
        }
        return UtdidResponse.response(sendRequest);
    }

    private void upload() {
        UtdidLogger.d();
        if (NetworkInfoUtils.isConnectInternet(this.mContext) && !bRunning) {
            bRunning = true;
            try {
                uploadFromCache();
            } catch (Throwable unused) {
            }
            bRunning = false;
        }
    }

    private void uploadFromCache() {
        UtdidLogger.d();
        String buildPostData = buildPostData();
        if (TextUtils.isEmpty(buildPostData)) {
            UtdidLogger.d("postData is empty", new Object[0]);
        } else if (reqServer(buildPostData)) {
            UtdidLogger.d("", "upload success");
        } else {
            UtdidLogger.d("", "upload fail");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            upload();
        } catch (Throwable th) {
            UtdidLogger.e("", th, new Object[0]);
        }
    }
}
