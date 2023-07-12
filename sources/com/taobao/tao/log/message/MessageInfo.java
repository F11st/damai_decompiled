package com.taobao.tao.log.message;

import android.content.Context;
import com.taobao.tao.log.TLogInitializer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MessageInfo {
    public static String keyName = "content";
    public Context context = null;
    public String content = null;
    public String appKey = null;
    public String ttid = null;
    public String publicKeyDigest = null;
    public String deviceId = null;
    public String hostName = TLogInitializer.getInstance().messageHostName;
    public String accsServiceId = TLogInitializer.getInstance().accsServiceId;
    public String accsTag = TLogInitializer.getInstance().accsTag;
}
