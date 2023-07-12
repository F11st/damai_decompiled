package cn.damai.live.weex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.taobao.windvane.standardmodal.WVStandardEventCenter;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import java.util.HashMap;
import java.util.Map;
import tb.rb1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class YoukuEventCenterModule extends WXModule {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_ACTION = "action";
    public static final String KEY_H5_MSG = "h5_msg";
    public static final String KEY_WEEX_MSG = "weex_msg";
    public static final String KEY_WEEX_MSG_STRING = "weex_msg_string";
    public static final String MODULE_NAME = "YKNotification";
    private HashMap<String, Receiver> mReceivers = new HashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class Receiver extends BroadcastReceiver {
        private static transient /* synthetic */ IpChange $ipChange;
        private String a;
        private JSCallback b;

        private Receiver(YoukuEventCenterModule youkuEventCenterModule) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "869252239")) {
                ipChange.ipc$dispatch("869252239", new Object[]{this, context, intent});
                return;
            }
            String action = intent.getAction();
            if (TextUtils.isEmpty(this.a) || !this.a.equals(action)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            Bundle extras = intent.getExtras();
            if (extras != null && extras.get(YoukuEventCenterModule.KEY_WEEX_MSG) != null) {
                try {
                    HashMap hashMap = (HashMap) extras.get(YoukuEventCenterModule.KEY_WEEX_MSG);
                    for (String str : hashMap.keySet()) {
                        Object obj = hashMap.get(str);
                        if (obj instanceof Number) {
                            jSONObject.put(str, (Object) String.valueOf(obj));
                        } else if (obj instanceof String) {
                            jSONObject.put(str, obj);
                        }
                    }
                    JSCallback jSCallback = this.b;
                    if (jSCallback != null) {
                        jSCallback.invokeAndKeepAlive(jSONObject.toString());
                    }
                    WVStandardEventCenter.postNotificationToJS(this.a, jSONObject.toString());
                    rb1.a("YoukuEventCenterModule", "Receiver" + this.a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (extras != null && extras.get(YoukuEventCenterModule.KEY_H5_MSG) != null) {
                try {
                    HashMap hashMap2 = (HashMap) extras.get(YoukuEventCenterModule.KEY_H5_MSG);
                    for (String str2 : hashMap2.keySet()) {
                        Object obj2 = hashMap2.get(str2);
                        if (obj2 instanceof Number) {
                            jSONObject.put(str2, (Object) String.valueOf(obj2));
                        } else if (obj2 instanceof String) {
                            jSONObject.put(str2, obj2);
                        }
                    }
                    JSCallback jSCallback2 = this.b;
                    if (jSCallback2 != null) {
                        jSCallback2.invokeAndKeepAlive(jSONObject.toString());
                    }
                    WVStandardEventCenter.postNotificationToJS(this.a, jSONObject.toString());
                    rb1.a("YoukuEventCenterModule", "Receiver" + this.a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (extras != null && extras.get(YoukuEventCenterModule.KEY_WEEX_MSG_STRING) != null) {
                try {
                    String str3 = (String) extras.get(YoukuEventCenterModule.KEY_WEEX_MSG_STRING);
                    JSCallback jSCallback3 = this.b;
                    if (jSCallback3 != null) {
                        jSCallback3.invokeAndKeepAlive(str3);
                    }
                    WVStandardEventCenter.postNotificationToJS(this.a, str3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private void registerReceiver(BroadcastReceiver broadcastReceiver, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1814211538")) {
            ipChange.ipc$dispatch("-1814211538", new Object[]{this, broadcastReceiver, str});
            return;
        }
        try {
            LocalBroadcastManager.getInstance(this.mWXSDKInstance.getContext()).registerReceiver(broadcastReceiver, new IntentFilter(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendBroadcast(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-698858503")) {
            ipChange.ipc$dispatch("-698858503", new Object[]{this, intent});
        } else {
            LocalBroadcastManager.getInstance(this.mWXSDKInstance.getContext()).sendBroadcast(intent);
        }
    }

    private void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "819387709")) {
            ipChange.ipc$dispatch("819387709", new Object[]{this, broadcastReceiver});
        } else if (broadcastReceiver == null) {
        } else {
            try {
                LocalBroadcastManager.getInstance(this.mWXSDKInstance.getContext()).unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @JSMethod
    public void broadcast(String str, HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-776461419")) {
            ipChange.ipc$dispatch("-776461419", new Object[]{this, str, hashMap});
            return;
        }
        try {
            Intent intent = new Intent(str);
            intent.putExtra("action", str);
            intent.putExtra(KEY_WEEX_MSG, hashMap);
            sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JSMethod
    public void broadcastString(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-18469097")) {
            ipChange.ipc$dispatch("-18469097", new Object[]{this, str, str2});
            return;
        }
        try {
            Intent intent = new Intent(str);
            intent.putExtra("action", str);
            intent.putExtra(KEY_WEEX_MSG_STRING, str2);
            sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JSMethod(uiThread = false)
    public void off(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706328944")) {
            ipChange.ipc$dispatch("706328944", new Object[]{this, str});
            return;
        }
        try {
            Receiver receiver = this.mReceivers.get(str);
            if (receiver != null) {
                unregisterReceiver(receiver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JSMethod(uiThread = false)
    public void on(String str, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1800620920")) {
            ipChange.ipc$dispatch("-1800620920", new Object[]{this, str, jSCallback});
            return;
        }
        try {
            Receiver receiver = new Receiver();
            receiver.a = str;
            receiver.b = jSCallback;
            registerReceiver(receiver, str);
            this.mReceivers.put(str.toString(), receiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-159718551")) {
            ipChange.ipc$dispatch("-159718551", new Object[]{this});
            return;
        }
        super.onActivityDestroy();
        for (Map.Entry<String, Receiver> entry : this.mReceivers.entrySet()) {
            unregisterReceiver(entry.getValue());
        }
    }
}
