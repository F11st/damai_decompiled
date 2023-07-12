package com.alibaba.wireless.security.open.middletier.fc;

import android.content.Context;
import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;
import java.util.HashMap;

/* compiled from: Taobao */
@InterfacePluginInfo(pluginName = "middletier")
/* loaded from: classes8.dex */
public interface IFCComponent extends IComponent {
    public static final String KEY_BX_SLEEP = "bx-sleep";
    public static final String KEY_LOGIN_MODULE = "key_login_module";
    public static final String KEY_RESEND_DATA = "key-resend-data";

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum ResponseHeaderType {
        KVO,
        KVL
    }

    String getFCPluginVersion() throws SecException;

    boolean needFCProcessOrNot(int i, HashMap hashMap, ResponseHeaderType responseHeaderType) throws SecException;

    boolean needFCProcessOrNotV2(int i, String str) throws SecException;

    void processFCContent(int i, HashMap hashMap, IFCActionCallback iFCActionCallback, ResponseHeaderType responseHeaderType) throws SecException;

    void processFCContentV2(String str, IFCActionCallback iFCActionCallback) throws SecException;

    void setUp(Context context, HashMap hashMap) throws SecException;
}
