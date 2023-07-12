package com.youku.live.dago.widgetlib.module;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.nav.Nav;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.youku.live.dago.widgetlib.util.LiveAppUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IProps;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoPrivateChatModule extends WXModule implements Destroyable, IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoPrivateChatModule";
    private String mRoomId = "";
    private String mScreenId = "";

    @JSMethod
    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "827019605")) {
            ipChange.ipc$dispatch("827019605", new Object[]{this});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.removeDataHandler("mtop.youku.live.com.livefullinfo", this);
            LocalBroadcastManager.getInstance(widgetEngineInstance.getContext()).sendBroadcast(new Intent("live_chat_finish"));
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-523443693")) {
            ipChange.ipc$dispatch("-523443693", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295798820")) {
            ipChange.ipc$dispatch("1295798820", new Object[]{this, str, obj, obj2});
        } else if ("mtop.youku.live.com.livefullinfo".equals(str) && (obj instanceof LiveFullInfoData)) {
            LiveFullInfoData liveFullInfoData = (LiveFullInfoData) obj;
            this.mRoomId = liveFullInfoData.liveId + "";
            this.mScreenId = liveFullInfoData.screenId + "";
        }
    }

    @JSMethod
    public void open(Map<String, Object> map, JSCallback jSCallback) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-769533130")) {
            ipChange.ipc$dispatch("-769533130", new Object[]{this, map, jSCallback});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        String str2 = "";
        String valueOf = (map == null || map.size() <= 0 || !map.containsKey("id")) ? "" : String.valueOf(map.get("id"));
        if (widgetEngineInstance != null) {
            widgetEngineInstance.addDataHandler("mtop.youku.live.com.livefullinfo", this);
            ((ILog) Dsl.getService(ILog.class)).d(TAG, "ytid : " + valueOf);
            IProps options = widgetEngineInstance.getOptions();
            if (options != null) {
                String string = options.getString("pagename", "");
                str = options.getString("spm-cnt", "");
                str2 = string;
            } else {
                str = "";
            }
            String str3 = "youku://messageCenterHalfScreen";
            if (!LiveAppUtil.isStarLive()) {
                str3 = "youku://messageCenterHalfScreen?uid=" + valueOf;
            }
            Bundle bundle = new Bundle();
            bundle.putString("from", LiveAppUtil.getFromeName());
            bundle.putString("pageName", str2);
            bundle.putString("direction", LiveAppUtil.getDirection());
            bundle.putString("spm-cnt", str);
            bundle.putString("anchor-id", valueOf);
            bundle.putString("roomid", this.mRoomId);
            bundle.putString("screenid", this.mScreenId);
            Nav.from(widgetEngineInstance.getContext()).withExtras(bundle).toUri(Uri.parse(str3));
        }
    }
}
