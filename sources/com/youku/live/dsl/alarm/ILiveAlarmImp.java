package com.youku.live.dsl.alarm;

import android.text.TextUtils;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.appalarm.AppAlarm;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.usercenter.passport.result.UserInfo;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ILiveAlarmImp implements ILiveAlarm {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String KEY_BIZ_TYPE = "bizType";
    private static final String KEY_DATA = "data";
    private static final String KEY_ERROR_CODE = "code";
    private static final String KEY_ERROR_MSG = "msg";

    @Override // com.youku.live.dsl.alarm.ILiveAlarm
    public void alarm(final String str, final String str2, final String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "385244689")) {
            ipChange.ipc$dispatch("385244689", new Object[]{this, str, str2, str3});
        } else {
            WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(new Runnable() { // from class: com.youku.live.dsl.alarm.ILiveAlarmImp.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-476507380")) {
                        ipChange2.ipc$dispatch("-476507380", new Object[]{this});
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("msg=" + str3);
                    UserInfo o = LoginManager.k().o();
                    if (o != null) {
                        sb.append(",nickname=" + o.mNickName);
                        sb.append(",uid=" + o.mUid);
                    }
                    AppAlarm.alarm(str, str2, sb.toString());
                }
            });
        }
    }

    @Override // com.youku.live.dsl.alarm.ILiveAlarm
    public void alarm(final String str, final String str2, final String str3, final Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "549681492")) {
            ipChange.ipc$dispatch("549681492", new Object[]{this, str, str2, str3, map});
        } else {
            WidgetSDKEngine.getInstance().getRenderMananger().postOnWorkerThread(new Runnable() { // from class: com.youku.live.dsl.alarm.ILiveAlarmImp.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-673020885")) {
                        ipChange2.ipc$dispatch("-673020885", new Object[]{this});
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("msg=" + str3);
                    UserInfo o = LoginManager.k().o();
                    if (o != null) {
                        sb.append(",nickname=" + o.mNickName);
                        sb.append(",uid=" + o.mUid);
                    }
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            String str4 = (String) entry.getKey();
                            String str5 = (String) entry.getValue();
                            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                                sb.append(",");
                                sb.append(str4 + "=" + str5);
                            }
                        }
                    }
                    AppAlarm.alarm(str, str2, sb.toString());
                }
            });
        }
    }
}
