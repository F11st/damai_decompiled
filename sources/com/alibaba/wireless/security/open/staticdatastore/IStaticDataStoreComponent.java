package com.alibaba.wireless.security.open.staticdatastore;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;
import tb.lu2;

/* compiled from: Taobao */
@InterfacePluginInfo(pluginName = lu2.MAIN)
/* loaded from: classes8.dex */
public interface IStaticDataStoreComponent extends IComponent {
    String getAppKeyByIndex(int i, String str) throws SecException;

    String getExtraData(String str, String str2) throws SecException;

    int getKeyType(String str, String str2) throws SecException;
}
