package com.youku.upsplayer.data;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MTopUpsRequest {
    public static final String AD_PARAMS = "ad_params";
    public static final String BIZ_PARAMS = "biz_params";
    public static final String STEAL_PARAMS = "steal_params";
    public String API_NAME = "mtop.youku.play.ups.appinfo.get";
    public String VERSION = "1.0";
    public boolean NEED_ECODE = true;
    public boolean NEED_SESSION = false;
    public Map<String, String> stealParamsMap = new HashMap();
    public Map<String, String> bizParamsMap = new HashMap();
    public Map<String, String> adParamsMap = new HashMap();
}
