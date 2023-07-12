package com.youku.live.dsl.oss;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IConfig;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IXOSSProcessFormaterImp implements IXOSSProcessFormater {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String X_OSS_PROCESS = "x-oss-process=image";

    private static String replaceAccessTokenReg(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "40099000")) {
            return (String) ipChange.ipc$dispatch("40099000", new Object[]{str, str2, str3});
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str3)) {
            return str.replaceAll(jn1.BRACKET_START_STR + str2 + "=[^&]*)", str2 + "=" + str3);
        }
        return str;
    }

    @Override // com.youku.live.dsl.oss.IXOSSProcessFormater
    public String getImageFormat() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1345293585") ? (String) ipChange.ipc$dispatch("-1345293585", new Object[]{this}) : !isNeedOptimizeImageFormat() ? "" : "/format,webp";
    }

    @Override // com.youku.live.dsl.oss.IXOSSProcessFormater
    public String getImageResize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1851084748")) {
            return (String) ipChange.ipc$dispatch("1851084748", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (isNeedOptimizeImageResize() && i + i2 > 0) {
            return "/resize,m_fixed,w_" + i + ",h_" + i2;
        }
        return "";
    }

    @Override // com.youku.live.dsl.oss.IXOSSProcessFormater
    public String getUrlWithOriginUrl(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1737451165") ? (String) ipChange.ipc$dispatch("-1737451165", new Object[]{this, str}) : getUrlWithOriginUrl(str, 0, 0);
    }

    @Override // com.youku.live.dsl.oss.IXOSSProcessFormater
    public boolean isNeedOptimizeImageFormat() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-809735316") ? ((Boolean) ipChange.ipc$dispatch("-809735316", new Object[]{this})).booleanValue() : "1".equals(((IConfig) Dsl.getService(IConfig.class)).getString("dago_liveconfig", "isNeedOptimizeImageFormat", "1"));
    }

    @Override // com.youku.live.dsl.oss.IXOSSProcessFormater
    public boolean isNeedOptimizeImageResize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-476958321") ? ((Boolean) ipChange.ipc$dispatch("-476958321", new Object[]{this})).booleanValue() : "1".equals(((IConfig) Dsl.getService(IConfig.class)).getString("dago_liveconfig", "isNeedOptimizeImageResize", "1"));
    }

    public boolean isNoNeedOptimize(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "910325469") ? ((Boolean) ipChange.ipc$dispatch("910325469", new Object[]{this, str})).booleanValue() : TextUtils.isEmpty(str) || "0".equals(((IConfig) Dsl.getService(IConfig.class)).getString("dago_liveconfig", "image_format", "1"));
    }

    @Override // com.youku.live.dsl.oss.IXOSSProcessFormater
    public String getUrlWithOriginUrl(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1854726211")) {
            return (String) ipChange.ipc$dispatch("1854726211", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (isNoNeedOptimize(str)) {
            return str;
        }
        if (str.indexOf(X_OSS_PROCESS) > 0) {
            return str + getImageFormat() + getImageResize(i, i2);
        } else if (str.indexOf("?") > 0) {
            return str + "&" + X_OSS_PROCESS + getImageFormat() + getImageResize(i, i2);
        } else {
            return str + "?" + X_OSS_PROCESS + getImageFormat() + getImageResize(i, i2);
        }
    }
}
