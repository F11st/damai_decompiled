package com.youku.live.dago.widgetlib.view.hongbao;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.securitybody.ISecurityBodyComponent;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetRequest;
import com.youku.live.dsl.network.INetResponse;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoHongbaoApi {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String HONGBAO_AWARD_GET = "mtop.youku.pugc.red.packet.award.get";
    private HongbaoResultCallback mCallback;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface HongbaoResultCallback {
        void onGetHongbaoResult(DagoHongbaoResultInfo dagoHongbaoResultInfo);
    }

    public static String getSecurityUMID() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2057727349")) {
            return (String) ipChange.ipc$dispatch("-2057727349", new Object[0]);
        }
        try {
            IUMIDComponent uMIDComp = SecurityGuardManager.getInstance(AppContextUtils.getApp()).getUMIDComp();
            uMIDComp.initUMIDSync(0);
            return uMIDComp.getSecurityToken(0);
        } catch (SecException | Exception unused) {
            return null;
        }
    }

    public static String getSecurityWUA() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "392028993")) {
            return (String) ipChange.ipc$dispatch("392028993", new Object[0]);
        }
        try {
            return ((ISecurityBodyComponent) SecurityGuardManager.getInstance(AppContextUtils.getApp()).getInterface(ISecurityBodyComponent.class)).getSecurityBodyDataEx(null, null, "", null, 4, 0);
        } catch (SecException | Exception unused) {
            return null;
        }
    }

    public void getHongbaoRequest(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1606930323")) {
            ipChange.ipc$dispatch("1606930323", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("hongbao-mtop", "packet id = " + str);
        INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
        HashMap hashMap = new HashMap();
        hashMap.put("packetId", str);
        hashMap.put("asac", "2A20708QZSKJ07AI5AVJ26");
        JSONObject jSONObject = new JSONObject();
        hashMap.put("systemInfo", jSONObject.toJSONString());
        hashMap.put("bizContext", jSONObject.toJSONString());
        hashMap.put("wua", getSecurityWUA());
        hashMap.put("umidToken", getSecurityUMID());
        INetRequest createRequestWithMTop = iNetClient.createRequestWithMTop(HONGBAO_AWARD_GET, "1.0", hashMap, false, true);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.dago.widgetlib.view.hongbao.DagoHongbaoApi.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-373634621")) {
                        ipChange2.ipc$dispatch("-373634621", new Object[]{this, iNetResponse});
                    } else if (iNetResponse == null || !iNetResponse.isSuccess()) {
                        if (DagoHongbaoApi.this.mCallback != null) {
                            DagoHongbaoApi.this.mCallback.onGetHongbaoResult(null);
                        }
                    } else if (DagoHongbaoApi.this.mCallback != null) {
                        ((ILog) Dsl.getService(ILog.class)).i("hongbao-mtop", "respone msg = " + iNetResponse.getRetMessage());
                        ((ILog) Dsl.getService(ILog.class)).i("hongbao-mtop", "respone code = " + iNetResponse.getRetCode());
                        ((ILog) Dsl.getService(ILog.class)).i("hongbao-mtop", "respone data = " + iNetResponse.getRawData());
                        ((ILog) Dsl.getService(ILog.class)).i("hongbao-mtop", "respone source = " + iNetResponse.getSource());
                        DagoHongbaoApi.this.mCallback.onGetHongbaoResult((DagoHongbaoResultInfo) ((HongbaoResultInfoResponse) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(iNetResponse.getSource(), HongbaoResultInfoResponse.class)).data);
                    }
                }
            });
        }
    }

    public void setCallback(HongbaoResultCallback hongbaoResultCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "473271085")) {
            ipChange.ipc$dispatch("473271085", new Object[]{this, hongbaoResultCallback});
        } else {
            this.mCallback = hongbaoResultCallback;
        }
    }
}
