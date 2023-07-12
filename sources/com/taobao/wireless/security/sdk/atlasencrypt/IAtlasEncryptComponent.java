package com.taobao.wireless.security.sdk.atlasencrypt;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.taobao.wireless.security.sdk.IComponent;
import tb.lu2;

/* compiled from: Taobao */
@InterfacePluginInfo(pluginName = lu2.MAIN)
/* loaded from: classes11.dex */
public interface IAtlasEncryptComponent extends IComponent {
    String atlasSafeEncrypt(String str);
}
