package com.alibaba.emas.publish;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import com.alibaba.emas.publish.channel.C3327a;
import com.alibaba.emas.publish.channel.ChannelService;
import com.alibaba.emas.publish.channel.accs.PublishAccsResponse;
import com.alibaba.emas.publish.channel.mtop.C3328a;
import com.alibaba.emas.publish.channel.mtop.PublishMtopResponse;
import com.alibaba.emas.publish.channel.mtop.PublishMtopUpdateInfo;
import com.alibaba.emas.publish.channel.poplayer.C3329a;
import com.alibaba.emas.publish.channel.ut.C3330a;
import com.alibaba.emas.publish.channel.ut.PublishUtRequest;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import tb.gn;
import tb.lu2;
import tb.zd0;

/* compiled from: Taobao */
@Keep
/* loaded from: classes15.dex */
public class EmasPublishService {
    private static final String tag = "EPublish.Open";
    private Map<String, EmasPublishCallback> callbackMap;
    private ChannelService channelService;
    private Boolean isInit;
    private Context mContext;
    private Integer maxRegister;
    private C3328a publishMtopService;
    public C3329a publishPopService;
    private C3330a publishUtService;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.emas.publish.EmasPublishService$a */
    /* loaded from: classes15.dex */
    public static class C3326a {
        private static EmasPublishService a = new EmasPublishService();
    }

    private PublishUtRequest buildErrorUtRequest(String str, String str2, String str3, String str4) {
        PublishUtRequest publishUtRequest = new PublishUtRequest();
        publishUtRequest.dimSourceValue = str;
        publishUtRequest.dimStageValue = str2;
        publishUtRequest.dimSuccessValue = "false";
        publishUtRequest.dimErrorCodeValue = str3;
        publishUtRequest.dimErrorMsgValue = str4;
        return publishUtRequest;
    }

    private PublishUtRequest buildSuccessUtRequest(String str, long j, long j2, long j3, String str2, String str3, String str4) {
        PublishUtRequest publishUtRequest = new PublishUtRequest();
        publishUtRequest.dimSourceValue = str;
        publishUtRequest.dimProductIdValue = String.valueOf(j);
        publishUtRequest.dimApplicationIdValue = String.valueOf(j2);
        publishUtRequest.dimBatchIdValue = String.valueOf(j3);
        publishUtRequest.dimBizValue = str2;
        publishUtRequest.dimStageValue = str3;
        publishUtRequest.dimNoticeTypeValue = str4;
        publishUtRequest.dimSuccessValue = "true";
        return publishUtRequest;
    }

    public static EmasPublishService getInstance() {
        return C3326a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mtopUpdateChannel(PublishMtopResponse publishMtopResponse) {
        List<PublishMtopUpdateInfo> list;
        String str;
        if (publishMtopResponse == null) {
            try {
                this.channelService.sendUtData(buildErrorUtRequest(gn.o, gn.s, gn.a, "mtop parse response == null"));
            } catch (Exception e) {
                Log.e(tag, "send ut data error", e);
            }
        } else if (!publishMtopResponse.success.booleanValue()) {
            try {
                this.channelService.sendUtData(buildErrorUtRequest(publishMtopResponse.source, gn.s, publishMtopResponse.clientRetCode, publishMtopResponse.clientRetMsg));
            } catch (Exception e2) {
                Log.e(tag, "send ut data error", e2);
            }
        } else if (Boolean.valueOf(publishMtopResponse.hasUpdate).booleanValue() && (list = publishMtopResponse.updateInfo) != null && list.size() > 0) {
            for (PublishMtopUpdateInfo publishMtopUpdateInfo : list) {
                String str2 = publishMtopUpdateInfo.biz;
                JSONObject jSONObject = publishMtopUpdateInfo.payload;
                if (str2.equalsIgnoreCase(lu2.MAIN) && jSONObject != null && jSONObject.containsKey("noticeType")) {
                    str = jSONObject.getString("noticeType");
                    if (str.equalsIgnoreCase(gn.l)) {
                        try {
                            String string = jSONObject.getString("uri");
                            if (string == null) {
                                this.channelService.sendUtData(buildErrorUtRequest(publishMtopResponse.source, gn.s, gn.a, "uri is null"));
                            } else {
                                this.publishPopService.e(this.mContext, string, jSONObject, publishMtopUpdateInfo);
                                this.channelService.sendUtData(buildSuccessUtRequest(publishMtopResponse.source, publishMtopUpdateInfo.productId, publishMtopUpdateInfo.applicationId, publishMtopUpdateInfo.batchId, str2, gn.t, str));
                            }
                        } catch (Exception e3) {
                            Log.e(tag, "poplayer ", e3);
                        }
                    } else if (str.equalsIgnoreCase(gn.m)) {
                    }
                } else {
                    str = null;
                }
                EmasPublishCallback emasPublishCallback = this.callbackMap.get(str2);
                if (emasPublishCallback != null) {
                    emasPublishCallback.updateCallback(publishMtopUpdateInfo);
                    try {
                        this.channelService.sendUtData(buildSuccessUtRequest(publishMtopResponse.source, publishMtopUpdateInfo.productId, publishMtopUpdateInfo.applicationId, publishMtopUpdateInfo.batchId, str2, gn.t, str));
                    } catch (Exception e4) {
                        Log.e(tag, "send ut data error", e4);
                    }
                }
            }
        }
    }

    public void accsUpdateChannel(PublishAccsResponse publishAccsResponse) {
        if (!publishAccsResponse.success.booleanValue()) {
            try {
                String str = publishAccsResponse.serviceId;
                if (publishAccsResponse.clientRetCode != null) {
                    str = publishAccsResponse.clientRetCode + " serviceId=" + publishAccsResponse.serviceId;
                }
                this.channelService.sendUtData(buildErrorUtRequest(publishAccsResponse.source, gn.x, str, publishAccsResponse.clientRetMsg));
                return;
            } catch (Exception e) {
                Log.e(tag, "send ut data error", e);
                return;
            }
        }
        mtopUpdateChannel(publishAccsResponse);
    }

    public Boolean commitAppmonitor(PublishUtRequest publishUtRequest) {
        try {
            if (this.isInit.booleanValue()) {
                this.channelService.sendUtData(publishUtRequest);
                return Boolean.TRUE;
            }
        } catch (Exception e) {
            Log.e(tag, "send ut data error", e);
        }
        return Boolean.FALSE;
    }

    public EmasPublishCallback getBizCallback(String str) {
        return this.callbackMap.get(str);
    }

    public void init(Context context, Boolean bool, String str, String str2) {
        if (this.isInit.booleanValue()) {
            return;
        }
        this.mContext = context;
        this.publishMtopService = new C3328a();
        this.publishUtService = new C3330a();
        this.publishPopService = new C3329a();
        this.channelService = new C3327a(context, str, str2, this.publishMtopService, this.publishUtService, bool);
        new Timer().schedule(new TimerTask() { // from class: com.alibaba.emas.publish.EmasPublishService.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    EmasPublishService emasPublishService = EmasPublishService.this;
                    emasPublishService.publishPopService.d(emasPublishService.channelService);
                    EmasPublishService.this.channelService.registUt();
                    Log.e(EmasPublishService.tag, ">>>>>> send mtop start >>>>>> ");
                    EmasPublishService.this.mtopUpdateChannel(EmasPublishService.this.channelService.sendMtop());
                    Log.e(EmasPublishService.tag, ">>>>>> send mtop end >>>>>> ");
                } catch (Exception e) {
                    Log.e(EmasPublishService.tag, "update error: ", e);
                }
            }
        }, 10000L);
        this.isInit = Boolean.TRUE;
    }

    public Boolean registEmasPublish(EmasPublishRequest emasPublishRequest) {
        String str;
        if (!this.isInit.booleanValue()) {
            Log.e(tag, "please init first");
            return Boolean.FALSE;
        }
        if (emasPublishRequest != null && (str = emasPublishRequest.bizName) != null && emasPublishRequest.callback != null) {
            try {
                if (this.callbackMap.containsKey(str)) {
                    return Boolean.FALSE;
                }
                if (this.callbackMap.size() >= this.maxRegister.intValue()) {
                    Log.e(tag, "is max register, cannot regist");
                    return Boolean.FALSE;
                }
                this.callbackMap.put(emasPublishRequest.bizName, emasPublishRequest.callback);
                this.channelService.addVersionAndArgs(emasPublishRequest.bizName, emasPublishRequest.currentVersion, emasPublishRequest.args);
                return Boolean.TRUE;
            } catch (Exception e) {
                Log.e(tag, "addVersionAndArgs error: ", e);
            }
        }
        return Boolean.FALSE;
    }

    public PublishMtopResponse sendActiveMtop(EmasPublishRequest emasPublishRequest) {
        PublishMtopResponse publishMtopResponse = new PublishMtopResponse();
        publishMtopResponse.success = Boolean.FALSE;
        publishMtopResponse.retCode = gn.a;
        if (emasPublishRequest == null) {
            publishMtopResponse.retMsg = "request is null";
            return publishMtopResponse;
        } else if (emasPublishRequest.bizName == null) {
            publishMtopResponse.retMsg = "biz name is null";
            return publishMtopResponse;
        } else if (emasPublishRequest.currentVersion == null) {
            publishMtopResponse.retMsg = "current version is null";
            return publishMtopResponse;
        } else {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(emasPublishRequest.bizName);
                HashMap hashMap = new HashMap();
                hashMap.put(emasPublishRequest.bizName, emasPublishRequest.currentVersion);
                PublishMtopResponse sendActiveMtop = this.channelService.sendActiveMtop(emasPublishRequest.mtopApiName, emasPublishRequest.appVersion, arrayList, hashMap, emasPublishRequest.args);
                if (sendActiveMtop != null) {
                    try {
                        PublishUtRequest publishUtRequest = new PublishUtRequest();
                        publishUtRequest.dimStageValue = gn.v;
                        publishUtRequest.dimSuccessValue = "true";
                        publishUtRequest.dimBizValue = emasPublishRequest.bizName;
                        this.channelService.sendUtData(publishUtRequest);
                    } catch (Exception e) {
                        Log.e(tag, "send ut data error", e);
                    }
                    return sendActiveMtop;
                }
                publishMtopResponse.retMsg = "send error";
                return publishMtopResponse;
            } catch (Exception e2) {
                Log.e(tag, "send active mtop error", e2);
                publishMtopResponse.retMsg = "send error " + e2.getMessage();
                return publishMtopResponse;
            }
        }
    }

    public PublishMtopResponse sendCombineActiveMtop(zd0 zd0Var) {
        PublishMtopResponse publishMtopResponse = new PublishMtopResponse();
        publishMtopResponse.success = Boolean.FALSE;
        publishMtopResponse.retCode = gn.a;
        publishMtopResponse.retMsg = "request is null";
        return publishMtopResponse;
    }

    private EmasPublishService() {
        this.isInit = Boolean.FALSE;
        this.callbackMap = new HashMap();
        this.maxRegister = 30;
    }
}
