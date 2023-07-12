package com.youku.live.dago.widgetlib.ailproom.adapter.mclient;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.powermsg.common.IPowerMsgCallback;
import com.taobao.tao.powermsg.common.IPowerMsgDispatcher;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.ailproom.adapter.mclient.AILPMClientConfig;
import com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.wt1;
import tb.xt1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPMClientPmAdapter implements AILPMClientProtocol {
    private static transient /* synthetic */ IpChange $ipChange;
    private String mTopicId;
    private final String TAG = "YKLMClientPmAdapter";
    private int mBizCode = 13;
    private AILPMClientConfig mConfig = new AILPMClientConfig.Builder().build();
    private Map<String, List<AILPMClientProtocol.MsgReceiver>> mReceiverMap = new HashMap();
    private IPowerMsgDispatcher mPowerMsgDispatcher = new IPowerMsgDispatcher() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.mclient.AILPMClientPmAdapter.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.tao.powermsg.common.IPowerMsgDispatcher
        public void onDispatch(wt1 wt1Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "58629985")) {
                ipChange.ipc$dispatch("58629985", new Object[]{this, wt1Var});
            } else if (AILPMClientPmAdapter.this.mReceiverMap.get(String.valueOf(wt1Var.a)) != null) {
                String str = new String(wt1Var.f);
                Map map = AILPMClientPmAdapter.this.mReceiverMap;
                if (map.containsKey(wt1Var.a + "")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", str);
                    List list = (List) AILPMClientPmAdapter.this.mReceiverMap.get(String.valueOf(wt1Var.a));
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        ((AILPMClientProtocol.MsgReceiver) list.get(i)).onReceive(hashMap);
                    }
                }
            }
        }

        @Override // com.taobao.tao.powermsg.common.IPowerMsgDispatcher
        public void onError(int i, Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "3461284")) {
                ipChange.ipc$dispatch("3461284", new Object[]{this, Integer.valueOf(i), obj});
            }
        }
    };

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol
    public void connect(@Nullable Map<String, Object> map, @Nullable final AILPMClientProtocol.ResultCallback resultCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1151129139")) {
            ipChange.ipc$dispatch("1151129139", new Object[]{this, map, resultCallback});
            return;
        }
        if (map != null) {
            this.mTopicId = (String) map.get("topicId");
            int intValue = ((Integer) map.get("bizCode")).intValue();
            if (intValue > 0) {
                this.mBizCode = intValue;
            }
        }
        xt1.b(this.mBizCode, this.mPowerMsgDispatcher);
        xt1.e(this.mBizCode, this.mTopicId, 3);
        xt1.f(this.mBizCode, this.mTopicId, "youku-android", new IPowerMsgCallback() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.mclient.AILPMClientPmAdapter.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.powermsg.common.IPowerMsgCallback
            public void onResult(int i, Map<String, Object> map2, Object... objArr) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1008613635")) {
                    ipChange2.ipc$dispatch("1008613635", new Object[]{this, Integer.valueOf(i), map2, objArr});
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("code", Integer.valueOf(i));
                if (i == 1000) {
                    hashMap.put("msg", "success");
                    resultCallback.onSuccess(hashMap);
                    return;
                }
                map2.put("msg", "failed, and check the error code");
                resultCallback.onFail(hashMap);
            }
        }, new Object[0]);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol
    public void disconnect() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1230671933")) {
            ipChange.ipc$dispatch("1230671933", new Object[]{this});
            return;
        }
        xt1.h(this.mBizCode, this.mTopicId, "youku-android", new IPowerMsgCallback() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.mclient.AILPMClientPmAdapter.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.powermsg.common.IPowerMsgCallback
            public void onResult(int i, Map<String, Object> map, Object... objArr) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "768073506")) {
                    ipChange2.ipc$dispatch("768073506", new Object[]{this, Integer.valueOf(i), map, objArr});
                }
            }
        }, new Object[0]);
        this.mTopicId = null;
        this.mConfig = null;
        this.mReceiverMap.clear();
        this.mReceiverMap = null;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol
    public void register(@NonNull String str, @Nullable Map<String, Object> map, @Nullable AILPMClientProtocol.MsgReceiver msgReceiver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1625428636")) {
            ipChange.ipc$dispatch("-1625428636", new Object[]{this, str, map, msgReceiver});
            return;
        }
        Map<String, List<AILPMClientProtocol.MsgReceiver>> map2 = this.mReceiverMap;
        if (map2 != null) {
            if (map2.containsKey(str)) {
                if (this.mReceiverMap.get(str) != null) {
                    this.mReceiverMap.get(str).add(msgReceiver);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(msgReceiver);
            this.mReceiverMap.put(str, arrayList);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol
    public void sendMessage(@NonNull Map<String, Object> map, @Nullable final AILPMClientProtocol.Dispatcher dispatcher) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1665129123")) {
            ipChange.ipc$dispatch("1665129123", new Object[]{this, map, dispatcher});
            return;
        }
        wt1 wt1Var = new wt1();
        if (map != null) {
            String str = (String) map.get("subType");
            String str2 = (String) map.get("bizCode");
            String str3 = (String) map.get("bizCode");
            String str4 = (String) map.get("data");
            String str5 = (String) map.get("userId");
            if (TextUtils.isEmpty(str3)) {
                wt1Var.d = this.mTopicId;
            } else {
                wt1Var.d = str3;
            }
            if (!TextUtils.isEmpty(str4)) {
                wt1Var.f = str4.getBytes();
            }
            TextUtils.isEmpty(str5);
            if (!TextUtils.isEmpty(str)) {
                wt1Var.a = ParseUtils.parse2Int(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                wt1Var.c = ParseUtils.parse2Int(str2);
            } else {
                wt1Var.c = this.mBizCode;
            }
            xt1.d(this.mBizCode, wt1Var, new IPowerMsgCallback() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.mclient.AILPMClientPmAdapter.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.tao.powermsg.common.IPowerMsgCallback
                public void onResult(int i, Map<String, Object> map2, Object... objArr) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1249153764")) {
                        ipChange2.ipc$dispatch("1249153764", new Object[]{this, Integer.valueOf(i), map2, objArr});
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("code", Integer.valueOf(i));
                    if (i == 1000) {
                        hashMap.put("msg", "success");
                        dispatcher.onSucess(hashMap);
                        return;
                    }
                    hashMap.put("msg", "ailed, and check the error code");
                    dispatcher.onFail(hashMap);
                }
            }, new Object[0]);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol
    public void setConfig(@Nullable AILPMClientConfig aILPMClientConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-403763644")) {
            ipChange.ipc$dispatch("-403763644", new Object[]{this, aILPMClientConfig});
        } else {
            this.mConfig = aILPMClientConfig;
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol
    public void unregister(@NonNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-302691033")) {
            ipChange.ipc$dispatch("-302691033", new Object[]{this, str});
        } else {
            this.mReceiverMap.remove(str);
        }
    }
}
