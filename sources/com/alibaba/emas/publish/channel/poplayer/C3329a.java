package com.alibaba.emas.publish.channel.poplayer;

import android.content.Context;
import android.content.Intent;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.emas.publish.EmasPublishCallback;
import com.alibaba.emas.publish.EmasPublishService;
import com.alibaba.emas.publish.channel.ChannelService;
import com.alibaba.emas.publish.channel.mtop.PublishMtopUpdateInfo;
import com.alibaba.emas.publish.channel.ut.PublishUtRequest;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.poplayer.PopLayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.gn;

/* compiled from: Taobao */
/* renamed from: com.alibaba.emas.publish.channel.poplayer.a */
/* loaded from: classes15.dex */
public class C3329a {
    private List<PublishPopInfo> a = new ArrayList();
    private ChannelService b;
    private Boolean c;
    private Boolean d;

    private boolean b() {
        if (this.d == null) {
            try {
                Class.forName(PopLayer.class.getName());
                this.d = Boolean.TRUE;
            } catch (Throwable unused) {
                this.d = Boolean.FALSE;
            }
        }
        return this.d.booleanValue();
    }

    private boolean c() {
        if (this.c == null) {
            try {
                Class.forName(WVPluginManager.class.getName());
                this.c = Boolean.TRUE;
            } catch (Throwable unused) {
                this.c = Boolean.FALSE;
            }
        }
        return this.c.booleanValue();
    }

    public void a(String str, Boolean bool) throws Exception {
        PublishPopInfo publishPopInfo;
        Iterator<PublishPopInfo> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                publishPopInfo = null;
                break;
            }
            publishPopInfo = it.next();
            if (publishPopInfo.uri.equalsIgnoreCase(str)) {
                break;
            }
        }
        if (publishPopInfo != null) {
            PublishMtopUpdateInfo publishMtopUpdateInfo = publishPopInfo.updateInfo;
            if (publishMtopUpdateInfo == null) {
                Log.e("EPublish.Poplayer", "update info is null");
                return;
            }
            PublishUtRequest publishUtRequest = new PublishUtRequest();
            publishUtRequest.dimProductIdValue = String.valueOf(publishMtopUpdateInfo.productId);
            publishUtRequest.dimApplicationIdValue = String.valueOf(publishMtopUpdateInfo.applicationId);
            publishUtRequest.dimBatchIdValue = String.valueOf(publishMtopUpdateInfo.batchId);
            publishUtRequest.dimBizValue = publishMtopUpdateInfo.biz;
            publishUtRequest.dimStageValue = gn.u;
            publishUtRequest.dimNoticeTypeValue = gn.l;
            publishUtRequest.dimSuccessValue = "true";
            if (!bool.booleanValue()) {
                publishUtRequest.dimActionValue = gn.z;
                this.b.sendUtData(publishUtRequest);
                return;
            }
            publishUtRequest.dimActionValue = gn.y;
            this.b.sendUtData(publishUtRequest);
            EmasPublishCallback bizCallback = EmasPublishService.getInstance().getBizCallback(publishMtopUpdateInfo.biz);
            if (bizCallback != null) {
                bizCallback.updateCallback(publishMtopUpdateInfo);
                return;
            }
            Log.e("EPublish.Poplayer", "not regist callback: " + publishMtopUpdateInfo.biz);
            return;
        }
        PublishUtRequest publishUtRequest2 = new PublishUtRequest();
        publishUtRequest2.dimStageValue = gn.u;
        publishUtRequest2.dimSuccessValue = "false";
        publishUtRequest2.dimErrorCodeValue = gn.j;
        publishUtRequest2.dimErrorMsgValue = gn.k;
        this.b.sendUtData(publishUtRequest2);
        throw new RuntimeException("cannot find pop info");
    }

    public void d(ChannelService channelService) {
        try {
            this.b = channelService;
            if (c()) {
                WVPluginManager.registerPlugin("PublishPopJSBridge", (Class<? extends WVApiPlugin>) PublishPopJSBridge.class);
            }
        } catch (Exception e) {
            Log.e("EPublish.Poplayer", "init error", e);
        }
    }

    public void e(Context context, String str, JSONObject jSONObject, PublishMtopUpdateInfo publishMtopUpdateInfo) throws Exception {
        if (b()) {
            String string = jSONObject.containsKey("arg") ? jSONObject.getString("arg") : null;
            Intent intent = new Intent(PopLayer.ACTION_POP);
            intent.putExtra("event", str);
            if (string != null) {
                intent.putExtra("param", string);
            }
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            PublishPopInfo publishPopInfo = new PublishPopInfo();
            publishPopInfo.arg = string;
            publishPopInfo.updateInfo = publishMtopUpdateInfo;
            publishPopInfo.uri = str;
            this.a.add(publishPopInfo);
        }
    }
}
