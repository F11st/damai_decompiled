package com.youku.live.livesdk.widgets.plugin;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.utils.MapUtils;
import com.youku.live.arch.utils.ObjectUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetRequest;
import com.youku.live.dsl.network.INetResponse;
import com.youku.live.livesdk.constants.DagoDataCenterConstants;
import com.youku.live.livesdk.constants.SDKConstants;
import com.youku.live.livesdk.constants.SchemaConstants;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.livesdk.widgets.helper.MtopDataHelper;
import com.youku.live.widgets.impl.BasePlugin;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IPluginData;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DagoLiveFullInfoV3Plugin extends BasePlugin implements IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private String mLiveId;

    private void initWithLiveFullInfo(LiveFullInfoData liveFullInfoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1887059322")) {
            ipChange.ipc$dispatch("1887059322", new Object[]{this, liveFullInfoData});
        }
    }

    private void initWithLiveId(String str, boolean z) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1118866280")) {
            ipChange.ipc$dispatch("1118866280", new Object[]{this, str, Boolean.valueOf(z)});
        } else if (z || (str2 = this.mLiveId) == null || str == null || !str2.equals(str)) {
            this.mLiveId = str;
            INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
            Map<String, String> build = MapUtils.build(MapUtils.build(new HashMap(), "liveId", str), "sdkVersion", ObjectUtils.asString(getEngineInstance().getData(SDKConstants.SDK_DEBUG_FULL_INFO_SDK_VERSION), SDKConstants.SDK_VERSION_NUMBER));
            Map<String, Object> map = getEngineInstance().getOptions().toMap();
            if (map.containsKey(SchemaConstants.SCHEMA_QUERY_TPL_TAG)) {
                String str3 = (String) map.get(SchemaConstants.SCHEMA_QUERY_TPL_TAG);
                if (!TextUtils.isEmpty(str3)) {
                    build = MapUtils.build(build, "tplTag", str3);
                }
            }
            INetRequest createRequestWithMTop = iNetClient.createRequestWithMTop("mtop.youku.live.com.livefullinfo", LiveFullInfo.VER, build, false, false);
            if (createRequestWithMTop != null) {
                createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.livesdk.widgets.plugin.DagoLiveFullInfoV3Plugin.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.dsl.network.INetCallback
                    public void onFinish(INetResponse iNetResponse) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1788989232")) {
                            ipChange2.ipc$dispatch("1788989232", new Object[]{this, iNetResponse});
                        } else if (iNetResponse != null) {
                            String source = iNetResponse.getSource();
                            DagoLiveFullInfoV3Plugin.this.getEngineInstance().asyncPutData("mtop.youku.live.com.livefullinfo", (LiveFullInfoData) MtopDataHelper.getDataDataWithModel(source, LiveFullInfo.class), MtopDataHelper.getDataDataWithJson(source, LiveFullInfo.class));
                        }
                    }
                });
            }
        }
    }

    private void initWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1866538412")) {
            ipChange.ipc$dispatch("-1866538412", new Object[]{this});
            return;
        }
        Object data = getEngineInstance().getData(DagoDataCenterConstants.DAGO_LIVE_ID);
        if (data instanceof String) {
            this.mLiveId = (String) data;
        }
        getEngineInstance().addDataHandlers(new String[]{DagoDataCenterConstants.DAGO_LIVE_ID, DagoDataCenterConstants.DAGO_LIVE_ID_RFRESH}, this);
    }

    private void releaseWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "770334431")) {
            ipChange.ipc$dispatch("770334431", new Object[]{this});
            return;
        }
        getEngineInstance().removeDataHandler(DagoDataCenterConstants.DAGO_LIVE_ID, this);
        getEngineInstance().removeDataHandler(DagoDataCenterConstants.DAGO_LIVE_ID_RFRESH, this);
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-514370959")) {
            ipChange.ipc$dispatch("-514370959", new Object[]{this});
            return;
        }
        super.destroy();
        releaseWithNothing();
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol.IPlugin
    public void initWithData(IEngineInstance iEngineInstance, IPluginData iPluginData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322889561")) {
            ipChange.ipc$dispatch("1322889561", new Object[]{this, iEngineInstance, iPluginData});
            return;
        }
        super.initWithData(iEngineInstance, iPluginData);
        initWithNothing();
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1070616190")) {
            ipChange.ipc$dispatch("-1070616190", new Object[]{this, str, obj, obj2});
        } else if (DagoDataCenterConstants.DAGO_LIVE_FULL_INFO_DATA.equals(str)) {
            if (obj instanceof LiveFullInfoData) {
                initWithLiveFullInfo((LiveFullInfoData) obj);
            }
        } else if (DagoDataCenterConstants.DAGO_LIVE_ID.equals(str)) {
            if (obj instanceof String) {
                initWithLiveId((String) obj, false);
            }
        } else if (DagoDataCenterConstants.DAGO_LIVE_ID_RFRESH.equals(str) && (obj instanceof String)) {
            initWithLiveId((String) obj, true);
        }
    }
}
