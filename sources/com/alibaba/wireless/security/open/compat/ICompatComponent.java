package com.alibaba.wireless.security.open.compat;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;
import tb.lu2;

/* compiled from: Taobao */
@InterfacePluginInfo(pluginName = lu2.MAIN)
/* loaded from: classes8.dex */
public interface ICompatComponent extends IComponent {
    String getCachedSecurityToken(int i) throws SecException;
}
