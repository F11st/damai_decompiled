package com.alibaba.wireless.security.open.lbsrisk;

import android.location.Location;
import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.SecException;
import java.util.HashMap;

/* compiled from: Taobao */
@InterfacePluginInfo(pluginName = "securitybody")
/* loaded from: classes8.dex */
public interface ILBSRiskComponent {
    boolean clearLocationData() throws SecException;

    String getLocationData(int i) throws SecException;

    boolean initLBSManager(HashMap<String, Object> hashMap) throws SecException;

    boolean putLocationData(Location location) throws SecException;
}
