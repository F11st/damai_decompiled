package com.alibaba.motu.tbrest;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.alibaba.motu.tbrest.rest.RestConstants;
import com.alibaba.motu.tbrest.rest.RestReqSend;
import com.alibaba.motu.tbrest.utils.LogUtil;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SendService {
    static final SendService instance = new SendService();
    public Context context = null;
    public String appId = null;
    public String appKey = null;
    public String appSecret = null;
    public String appVersion = null;
    public String channel = null;
    public String userNick = null;
    public String host = null;
    public Boolean openHttp = Boolean.FALSE;
    public String country = null;
    public String buildId = null;
    private SendAsyncExecutor sendAsyncExecutor = new SendAsyncExecutor();

    private Boolean canSend() {
        if (this.appId != null && this.appVersion != null && this.appKey != null && this.context != null) {
            return Boolean.TRUE;
        }
        LogUtil.e("have send args is null，you must init first. appId " + this.appId + " appVersion " + this.appVersion + " appKey " + this.appKey);
        return Boolean.FALSE;
    }

    public static SendService getInstance() {
        return instance;
    }

    public void changeHost(String str) {
        if (str != null) {
            this.host = str;
        }
    }

    public String getChangeHost() {
        return this.host;
    }

    public void init(Context context, String str, String str2, String str3, String str4, String str5) {
        String string;
        this.context = context;
        this.appId = str;
        this.appKey = str2;
        this.appVersion = str3;
        this.channel = str4;
        this.userNick = str5;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("build_id", "string", context.getPackageName());
        if (identifier > 0) {
            try {
                string = resources.getString(identifier);
            } catch (Exception e) {
                Log.e("SendService", e.getMessage());
            }
            this.buildId = string;
        }
        string = "unknown";
        this.buildId = string;
    }

    public Boolean sendRequest(String str, long j, String str2, int i, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        String str3;
        if (canSend().booleanValue()) {
            if (str == null) {
                String str4 = this.host;
                if (str4 == null) {
                    str4 = RestConstants.G_DEFAULT_ADASHX_HOST;
                }
                str3 = str4;
            } else {
                str3 = str;
            }
            return Boolean.valueOf(RestReqSend.sendLog(this.appKey, this.context, str3, j, str2, i, obj, obj2, obj3, map));
        }
        return Boolean.FALSE;
    }

    public void sendRequestAsyn(String str, long j, String str2, int i, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        String str3;
        if (canSend().booleanValue()) {
            if (str == null) {
                String str4 = this.host;
                if (str4 == null) {
                    str4 = RestConstants.G_DEFAULT_ADASHX_HOST;
                }
                str3 = str4;
            } else {
                str3 = str;
            }
            this.sendAsyncExecutor.start(new RestThread("rest thread", this.appKey, this.context, str3, j, str2, i, obj, obj2, obj3, map, Boolean.FALSE));
        }
    }

    public void sendRequestAsynByAppkeyAndUrl(String str, String str2, long j, String str3, int i, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        if (canSend().booleanValue()) {
            if (str == null) {
                Log.e(LogUtil.TAG, "need set url");
            } else {
                this.sendAsyncExecutor.start(new RestThread("rest thread", str2 == null ? this.appKey : str2, this.context, str, j, str3, i, obj, obj2, obj3, map, Boolean.TRUE));
            }
        }
    }

    @Deprecated
    public String sendRequestByUrl(String str, long j, String str2, int i, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        if (canSend().booleanValue()) {
            return RestReqSend.sendLogByUrl(str, this.appKey, this.context, j, str2, i, obj, obj2, obj3, map);
        }
        return null;
    }

    public void updateAppVersion(String str) {
        if (str != null) {
            this.appVersion = str;
        }
    }

    public void updateChannel(String str) {
        if (str != null) {
            this.channel = str;
        }
    }

    public void updateUserNick(String str) {
        if (str != null) {
            this.userNick = str;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class RestThread implements Runnable {
        private Object aArg1;
        private Object aArg2;
        private Object aArg3;
        private int aEventId;
        private Map<String, String> aExtData;
        private String aPage;
        private long aTimestamp;
        private String adashxServerHost;
        private String appKey;
        private Context context;
        private Boolean isUrl;

        public RestThread() {
            this.isUrl = Boolean.FALSE;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.isUrl.booleanValue()) {
                    RestReqSend.sendLogByUrl(this.appKey, this.context, this.adashxServerHost, this.aTimestamp, this.aPage, this.aEventId, this.aArg1, this.aArg2, this.aArg3, this.aExtData);
                } else {
                    RestReqSend.sendLog(this.appKey, this.context, this.adashxServerHost, this.aTimestamp, this.aPage, this.aEventId, this.aArg1, this.aArg2, this.aArg3, this.aExtData);
                }
            } catch (Exception e) {
                LogUtil.e("send log asyn error ", e);
            }
        }

        public RestThread(String str, String str2, Context context, String str3, long j, String str4, int i, Object obj, Object obj2, Object obj3, Map<String, String> map, Boolean bool) {
            this.isUrl = Boolean.FALSE;
            this.context = context;
            this.adashxServerHost = str3;
            this.aTimestamp = j;
            this.aPage = str4;
            this.aEventId = i;
            this.aArg1 = obj;
            this.aArg2 = obj2;
            this.aArg3 = obj3;
            this.aExtData = map;
            this.appKey = str2;
            this.isUrl = bool;
        }
    }
}
