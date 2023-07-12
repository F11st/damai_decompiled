package com.alibaba.wireless.security.open.opensdk;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;
import tb.lu2;

/* compiled from: Taobao */
@InterfacePluginInfo(pluginName = lu2.MAIN)
/* loaded from: classes8.dex */
public interface IOpenSDKComponent extends IComponent {
    public static final byte[] OPEN_BIZ_UID = {0, 1};
    public static final byte[] OPEN_BIZ_IID = {0, 2};
    public static final byte[] OPEN_BIZ_TID = {0, 3};

    Long analyzeOpenId(String str, String str2, String str3, byte[] bArr, String str4) throws SecException;
}
