package com.taobao.wireless.security.sdk.staticdatastore;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.taobao.wireless.security.sdk.IComponent;
import tb.lu2;

/* compiled from: Taobao */
@InterfacePluginInfo(pluginName = lu2.MAIN)
/* loaded from: classes11.dex */
public interface IStaticDataStoreComponent extends IComponent {
    String getAppKeyByIndex(int i);

    String getExtraData(String str);

    int getKeyType(String str);
}
