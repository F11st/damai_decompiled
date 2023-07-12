package com.youku.live.dago.widgetlib.view.usercard;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetRequest;
import com.youku.live.dsl.network.INetResponse;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class UserCardApi {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String USER_CARD_INFO_AND_VIDEO_LIST_URL = "mtop.youku.yklive.user.card.tab.get";
    private static final String USER_CARD_INFO_URL = "mtop.youku.yklive.user.card.info.get";
    private static final String USER_CARD_VIDEO_LIST_URL = "mtop.youku.yklive.rec.short.video.list";
    private UserCardInfoListener mListener;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface UserCardInfoListener {
        void onError(String str);

        void onUserInfo(UserCardInfo userCardInfo);

        void onUserTab(UserCardTabInfo userCardTabInfo);

        void onUserVideos(UserCardVideoList userCardVideoList);
    }

    public void requestUserInfo(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "296353259")) {
            ipChange.ipc$dispatch("296353259", new Object[]{this, Long.valueOf(j)});
            return;
        }
        INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
        HashMap hashMap = new HashMap();
        hashMap.put("uid", j + "");
        INetRequest createRequestWithMTop = iNetClient.createRequestWithMTop("mtop.youku.yklive.user.card.info.get", "1.0", hashMap, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.dago.widgetlib.view.usercard.UserCardApi.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1036193466")) {
                        ipChange2.ipc$dispatch("-1036193466", new Object[]{this, iNetResponse});
                    } else if (iNetResponse == null || !iNetResponse.isSuccess() || UserCardApi.this.mListener == null) {
                    } else {
                        UserCardApi.this.mListener.onUserInfo((UserCardInfo) ((UserCardInfoResponse) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(iNetResponse.getSource(), UserCardInfoResponse.class)).data);
                    }
                }
            });
        }
    }

    public void requestUserInfoAndVideos(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1595387852")) {
            ipChange.ipc$dispatch("1595387852", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("userId", str);
        hashMap.put("offset", i + "");
        hashMap.put("limit", i2 + "");
        hashMap.put("client", "ANDROID");
        INetRequest createRequestWithMTop = ((INetClient) Dsl.getService(INetClient.class)).createRequestWithMTop("mtop.youku.yklive.user.card.tab.get", "1.0", hashMap, true, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.dago.widgetlib.view.usercard.UserCardApi.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-995518716")) {
                        ipChange2.ipc$dispatch("-995518716", new Object[]{this, iNetResponse});
                    } else if (iNetResponse == null || !iNetResponse.isSuccess()) {
                        if (UserCardApi.this.mListener != null) {
                            UserCardApi.this.mListener.onError("");
                        }
                    } else {
                        UserCardTabInfo userCardTabInfo = (UserCardTabInfo) ((UserCardTabInfoResponse) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(iNetResponse.getSource(), UserCardTabInfoResponse.class)).data;
                        if (UserCardApi.this.mListener != null) {
                            UserCardApi.this.mListener.onUserTab(userCardTabInfo);
                        }
                    }
                }
            });
            return;
        }
        UserCardInfoListener userCardInfoListener = this.mListener;
        if (userCardInfoListener != null) {
            userCardInfoListener.onError("");
        }
    }

    public void requestUserVideos(long j, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "498664245")) {
            ipChange.ipc$dispatch("498664245", new Object[]{this, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
        HashMap hashMap = new HashMap();
        hashMap.put("userId", j + "");
        hashMap.put("offset", i + "");
        hashMap.put("limit", i2 + "");
        hashMap.put("client", "ANDROID");
        INetRequest createRequestWithMTop = iNetClient.createRequestWithMTop("mtop.youku.yklive.rec.short.video.list", "1.0", hashMap, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.dago.widgetlib.view.usercard.UserCardApi.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1015856091")) {
                        ipChange2.ipc$dispatch("-1015856091", new Object[]{this, iNetResponse});
                    } else if (iNetResponse == null || !iNetResponse.isSuccess()) {
                    } else {
                        UserCardVideoList userCardVideoList = (UserCardVideoList) ((UserCardVideoListResponse) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(iNetResponse.getSource(), UserCardVideoListResponse.class)).data;
                        if (UserCardApi.this.mListener != null) {
                            UserCardApi.this.mListener.onUserVideos(userCardVideoList);
                        }
                    }
                }
            });
        }
    }

    public void setListener(UserCardInfoListener userCardInfoListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1617444133")) {
            ipChange.ipc$dispatch("1617444133", new Object[]{this, userCardInfoListener});
        } else {
            this.mListener = userCardInfoListener;
        }
    }
}
