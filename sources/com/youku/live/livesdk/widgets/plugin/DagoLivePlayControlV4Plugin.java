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
import com.youku.live.livesdk.model.mtop.LiveFullInfoV4;
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
public class DagoLivePlayControlV4Plugin extends BasePlugin implements IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private String mLiveId;

    private void initWithLiveFullInfo(LiveFullInfoData liveFullInfoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1434066591")) {
            ipChange.ipc$dispatch("1434066591", new Object[]{this, liveFullInfoData});
        }
    }

    private void initWithLiveId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1819633753")) {
            ipChange.ipc$dispatch("-1819633753", new Object[]{this, str});
            return;
        }
        String str2 = this.mLiveId;
        if (str2 == null || str == null || !str2.equals(str)) {
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
            INetRequest createRequestWithMTop = iNetClient.createRequestWithMTop("mtop.youku.live.com.livefullinfo", "4.0", build, false, false);
            if (createRequestWithMTop != null) {
                perfMonitorPoint("LiveFullInfoCost", Thread.currentThread().getName() + "::DagoLivePlayControlV4Plugin initWithLiveId:" + this + ",mLiveId：" + this.mLiveId + ", 1 before reqLiveFullInfo;");
                createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.livesdk.widgets.plugin.DagoLivePlayControlV4Plugin.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.dsl.network.INetCallback
                    public void onFinish(INetResponse iNetResponse) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-655207275")) {
                            ipChange2.ipc$dispatch("-655207275", new Object[]{this, iNetResponse});
                        } else if (iNetResponse != null) {
                            DagoLivePlayControlV4Plugin dagoLivePlayControlV4Plugin = DagoLivePlayControlV4Plugin.this;
                            dagoLivePlayControlV4Plugin.perfMonitorPoint("LiveFullInfoCost", Thread.currentThread().getName() + "::DagoLivePlayControlV4Plugin initWithLiveId onFinish:" + DagoLivePlayControlV4Plugin.this + ",mLiveId：" + DagoLivePlayControlV4Plugin.this.mLiveId + ", 2 after reqLiveFullInfo;");
                            String source = iNetResponse.getSource();
                            DagoLivePlayControlV4Plugin dagoLivePlayControlV4Plugin2 = DagoLivePlayControlV4Plugin.this;
                            dagoLivePlayControlV4Plugin2.perfMonitorPoint("LiveFullInfoCost", Thread.currentThread().getName() + "::DagoLivePlayControlV4Plugin initWithLiveId onFinish parse:" + DagoLivePlayControlV4Plugin.this + ",mLiveId：" + DagoLivePlayControlV4Plugin.this.mLiveId + ", 3 after reqLiveFullInfo;");
                            DagoLivePlayControlV4Plugin.this.getEngineInstance().asyncPutData("mtop.youku.live.com.livefullinfo", (LiveFullInfoData) MtopDataHelper.getDataDataWithModel(source, LiveFullInfoV4.class), MtopDataHelper.getDataDataWithJson(source, LiveFullInfoV4.class));
                            DagoLivePlayControlV4Plugin dagoLivePlayControlV4Plugin3 = DagoLivePlayControlV4Plugin.this;
                            dagoLivePlayControlV4Plugin3.perfMonitorPoint("LiveFullInfoCost", Thread.currentThread().getName() + "::DagoLivePlayControlV4Plugin initWithLiveId onFinish parse:" + DagoLivePlayControlV4Plugin.this + ",mLiveId：" + DagoLivePlayControlV4Plugin.this.mLiveId + ", 4 after reqLiveFullInfo;");
                        }
                    }
                });
            }
        }
    }

    private void initWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1092400697")) {
            ipChange.ipc$dispatch("1092400697", new Object[]{this});
        } else {
            getEngineInstance().addDataHandlers(new String[]{DagoDataCenterConstants.DAGO_LIVE_ID}, this);
        }
    }

    private void releaseWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "616547546")) {
            ipChange.ipc$dispatch("616547546", new Object[]{this});
        } else {
            getEngineInstance().removeDataHandler(DagoDataCenterConstants.DAGO_LIVE_ID, this);
        }
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1551508650")) {
            ipChange.ipc$dispatch("-1551508650", new Object[]{this});
            return;
        }
        super.destroy();
        releaseWithNothing();
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol.IPlugin
    public void initWithData(IEngineInstance iEngineInstance, IPluginData iPluginData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1173995948")) {
            ipChange.ipc$dispatch("-1173995948", new Object[]{this, iEngineInstance, iPluginData});
            return;
        }
        super.initWithData(iEngineInstance, iPluginData);
        initWithNothing();
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1579496217")) {
            ipChange.ipc$dispatch("-1579496217", new Object[]{this, str, obj, obj2});
        } else if (DagoDataCenterConstants.DAGO_LIVE_FULL_INFO_DATA.equals(str)) {
            if (obj instanceof LiveFullInfoData) {
                initWithLiveFullInfo((LiveFullInfoData) obj);
            }
        } else if (DagoDataCenterConstants.DAGO_LIVE_ID.equals(str) && (obj instanceof String)) {
            initWithLiveId((String) obj);
        }
    }
}
