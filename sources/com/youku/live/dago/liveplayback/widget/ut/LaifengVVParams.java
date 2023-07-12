package com.youku.live.dago.liveplayback.widget.ut;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.ClientType;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.pages.ILaifengManagerInterface;
import com.youku.live.dsl.usertrack.IUserTracker;
import com.youku.live.livesdk.wkit.utils.SdkChannel;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LaifengVVParams {
    private static transient /* synthetic */ IpChange $ipChange;
    private Map<String, String> sVVCommonParams;

    public Map<String, String> getVVCommonParams(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2077203129")) {
            return (Map) ipChange.ipc$dispatch("2077203129", new Object[]{this, context, str});
        }
        Map<String, String> map = this.sVVCommonParams;
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        LaifengVVParamsEnum laifengVVParamsEnum = LaifengVVParamsEnum.YOUKULIVE;
        if ("3".equals(str)) {
            if (SdkChannel.isLaifeng(context)) {
                laifengVVParamsEnum = LaifengVVParamsEnum.LAIFENG_LF;
            } else if (SdkChannel.isYouku(context)) {
                laifengVVParamsEnum = LaifengVVParamsEnum.LAIFENG_YK;
            } else if (SdkChannel.isUC(context)) {
                laifengVVParamsEnum = LaifengVVParamsEnum.LAIFENG_UC;
            } else if (SdkChannel.isXiami(context)) {
                laifengVVParamsEnum = LaifengVVParamsEnum.LAIFENG_XM;
            } else if (Utils.getClientType(context) == ClientType.DAMAI) {
                laifengVVParamsEnum = LaifengVVParamsEnum.DAMAI;
            }
        }
        String pageName = laifengVVParamsEnum.getPageName();
        String spm = laifengVVParamsEnum.getSPM();
        hashMap.put("pageName", pageName);
        hashMap.put("page", pageName);
        hashMap.put("pagename", pageName);
        hashMap.put("package", context.getApplicationInfo().packageName);
        hashMap.put("play_type", "1");
        hashMap.put("scm", "");
        hashMap.put("spm-cnt", spm);
        HashMap hashMap2 = new HashMap();
        try {
            ((ILaifengManagerInterface) Dsl.getService(ILaifengManagerInterface.class)).handleLaifengReoprtParmas(context, hashMap2);
            for (Map.Entry entry : hashMap2.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof String) {
                    hashMap.put(entry.getKey(), (String) value);
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Map<String, String> lastClickParams = ((IUserTracker) Dsl.getService(IUserTracker.class)).getLastClickParams();
            if (lastClickParams != null) {
                hashMap.putAll(lastClickParams);
            }
        } catch (Throwable unused2) {
        }
        this.sVVCommonParams = hashMap;
        return hashMap;
    }
}
