package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetResponse;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TrueLoveGroupInteractor {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "TrueLoveGroupInteractor";
    public static final String TRUE_LOVE_MEDAL_API = "mtop.youku.laifeng.papercrane.getUserMedalInfo";
    public static final String TRUE_LOVE_TAG_API = "mtop.youku.laifeng.papercrane.getGroupInfo";

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface getMedalDataListener {
        void onCompleted(String str);

        void onException(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface getOnlineDataListener {
        void onCompleted(String str);

        void onException(String str);
    }

    public static void getMedalData(Map<String, String> map, final getMedalDataListener getmedaldatalistener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1801538995")) {
            ipChange.ipc$dispatch("1801538995", new Object[]{map, getmedaldatalistener});
        } else {
            ((INetClient) Dsl.getService(INetClient.class)).createRequestWithMTop(TRUE_LOVE_MEDAL_API, "1.0", map, true, false).async(new INetCallback() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.TrueLoveGroupInteractor.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1416006607")) {
                        ipChange2.ipc$dispatch("-1416006607", new Object[]{this, iNetResponse});
                        return;
                    }
                    if (iNetResponse != null) {
                        try {
                            if (iNetResponse.getRetCode() != null && iNetResponse.getRetCode().startsWith("SUCCESS")) {
                                getMedalDataListener.this.onCompleted(new JSONObject(iNetResponse.getSource()).optJSONObject("data").toString());
                                ((ILog) Dsl.getService(ILog.class)).e(TrueLoveGroupInteractor.TAG, "MedalData= " + iNetResponse.getSource());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    getMedalDataListener.this.onException(iNetResponse.getRetCode());
                }
            });
        }
    }

    public static void getOnlineData(Map<String, String> map, final getOnlineDataListener getonlinedatalistener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-185758993")) {
            ipChange.ipc$dispatch("-185758993", new Object[]{map, getonlinedatalistener});
        } else {
            ((INetClient) Dsl.getService(INetClient.class)).createRequestWithMTop(TRUE_LOVE_TAG_API, "1.0", map, true, false).async(new INetCallback() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.TrueLoveGroupInteractor.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1436343982")) {
                        ipChange2.ipc$dispatch("-1436343982", new Object[]{this, iNetResponse});
                    } else if (iNetResponse != null && iNetResponse.getRetCode() != null && iNetResponse.getRetCode().startsWith("SUCCESS")) {
                        getOnlineDataListener.this.onCompleted(iNetResponse.getSource());
                        ((ILog) Dsl.getService(ILog.class)).e(TrueLoveGroupInteractor.TAG, "OnlineData= " + iNetResponse.getSource());
                    } else {
                        getOnlineDataListener.this.onException(iNetResponse.getRetCode());
                    }
                }
            });
        }
    }
}
