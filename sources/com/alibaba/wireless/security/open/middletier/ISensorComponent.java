package com.alibaba.wireless.security.open.middletier;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;
import java.util.HashMap;

/* compiled from: Taobao */
@InterfacePluginInfo(pluginName = "middletier")
/* loaded from: classes8.dex */
public interface ISensorComponent extends IComponent {
    public static final int PROCESS_GET = 3;
    public static final int PROCESS_RESET = 4;
    public static final int PROCESS_START = 1;
    public static final int PROCESS_STOP = 2;

    void init(HashMap<String, Object> hashMap) throws SecException;

    HashMap<String, Object> process(int i) throws SecException;
}
