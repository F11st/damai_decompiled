package com.taobao.wireless.security.sdk.dynamicdataencrypt;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.taobao.wireless.security.sdk.IComponent;
import tb.lu2;

/* compiled from: Taobao */
@InterfacePluginInfo(pluginName = lu2.MAIN)
/* loaded from: classes11.dex */
public interface IDynamicDataEncryptComponent extends IComponent {
    @Deprecated
    String dynamicDecrypt(String str);

    String dynamicDecryptDDp(String str);

    @Deprecated
    String dynamicEncrypt(String str);

    String dynamicEncryptDDp(String str);
}
