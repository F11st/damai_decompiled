package com.youku.live.livesdk.preloader.templates;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IRemoteConfig;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.livesdk.constants.SDKConstants;
import com.youku.live.widgets.model.template.TemplateModel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class OrangeTemplateCache {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String ORANGE_NAMESPACE_YKLIVEROOM_ABTEST = "YKLiveRoom_ABTest";
    private static OrangeTemplateCache sInstance;

    public static OrangeTemplateCache getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "902401979")) {
            return (OrangeTemplateCache) ipChange.ipc$dispatch("902401979", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (OrangeTemplateCache.class) {
                if (sInstance == null) {
                    sInstance = new OrangeTemplateCache();
                }
            }
        }
        return sInstance;
    }

    private static String getLayoutKey(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "842516657")) {
            return (String) ipChange.ipc$dispatch("842516657", new Object[]{str, str2, Boolean.valueOf(z)});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("new_layout_");
        sb.append("templateId_");
        sb.append(str);
        sb.append(JSMethod.NOT_SET);
        sb.append("sdkVersion_");
        sb.append(str2.replace(".", JSMethod.NOT_SET));
        sb.append(JSMethod.NOT_SET);
        sb.append("orientation_");
        sb.append(z ? "landscape" : "portrait");
        return sb.toString();
    }

    private static String getSdkVersionNumber() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1639698435") ? (String) ipChange.ipc$dispatch("1639698435", new Object[0]) : SDKConstants.SDK_VERSION_NUMBER;
    }

    public String[] getTemplateIdList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1983030976")) {
            return (String[]) ipChange.ipc$dispatch("1983030976", new Object[]{this});
        }
        String string = ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getString("YKLiveRoom_ABTest", "templateIds_" + getSdkVersionNumber().replace(".", JSMethod.NOT_SET), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string.split(",");
    }

    public void updateWithCaches(Map<String, Map<String, ITemplate>> map) {
        Map<String, ITemplate> concurrentHashMap;
        String str;
        TemplateModel templateModel;
        String str2;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1471836491")) {
            ipChange.ipc$dispatch("-1471836491", new Object[]{this, map});
            return;
        }
        String[] templateIdList = getTemplateIdList();
        if (templateIdList != null) {
            int length = templateIdList.length;
            int i = 0;
            while (i < length) {
                String str3 = templateIdList[i];
                if (!TextUtils.isEmpty(str3)) {
                    if (map.containsKey(str3)) {
                        concurrentHashMap = map.get(str3);
                    } else {
                        concurrentHashMap = new ConcurrentHashMap<>();
                        map.put(str3, concurrentHashMap);
                    }
                    TemplateModel templateModel2 = null;
                    try {
                        str = ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getString("YKLiveRoom_ABTest", getLayoutKey(str3, SDKConstants.SDK_VERSION_NUMBER, false), null);
                        try {
                            templateModel = (TemplateModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(str, TemplateModel.class);
                        } catch (Throwable unused) {
                            templateModel = null;
                            str2 = ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getString("YKLiveRoom_ABTest", getLayoutKey(str3, SDKConstants.SDK_VERSION_NUMBER, z), null);
                            templateModel2 = (TemplateModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(str2, TemplateModel.class);
                            if (!TextUtils.isEmpty(str)) {
                                concurrentHashMap.put(getSdkVersionNumber(), new AbsTemplate(str2, str, templateModel2, templateModel));
                            }
                            i++;
                            z = true;
                        }
                    } catch (Throwable unused2) {
                        str = null;
                    }
                    try {
                        str2 = ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getString("YKLiveRoom_ABTest", getLayoutKey(str3, SDKConstants.SDK_VERSION_NUMBER, z), null);
                        try {
                            templateModel2 = (TemplateModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(str2, TemplateModel.class);
                        } catch (Throwable unused3) {
                        }
                    } catch (Throwable unused4) {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && templateModel != null && templateModel2 != null) {
                        concurrentHashMap.put(getSdkVersionNumber(), new AbsTemplate(str2, str, templateModel2, templateModel));
                    }
                }
                i++;
                z = true;
            }
        }
    }
}
