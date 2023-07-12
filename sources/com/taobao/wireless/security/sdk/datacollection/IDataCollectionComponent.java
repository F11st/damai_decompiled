package com.taobao.wireless.security.sdk.datacollection;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.taobao.wireless.security.sdk.IComponent;
import tb.lu2;

/* compiled from: Taobao */
@InterfacePluginInfo(pluginName = lu2.MAIN)
/* loaded from: classes11.dex */
public interface IDataCollectionComponent extends IComponent {
    @Deprecated
    String getEncryptedDevAndEnvInfo(int i, String str);

    String getNick();

    String getNickEx(int i);

    boolean setNick(String str);

    boolean setNickEx(int i, String str);
}
