package com.youku.live.dago.widgetlib.module;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;
import com.youku.live.dago.widgetlib.util.OrangeUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LivePlayLogUploadModule extends WXModule {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String AUTO_PLAY = "autoPlay";
    private static final String CATEGORY = "category";
    private static final String DEFINITION = "hd";
    private static final String DURATION = "duration";
    private static final String FOLDER_ID = "folderId";
    private static final String FOLDER_PLACE = "folderPlace";
    private static final String HAS_NEXT = "hasNext";
    private static final String LANGUAGE = "lang";
    private static final String LAST_UPDATE = "lastUpdate";
    private static final String LOG_TYPE = "logType";
    private static final String POINT = "point";
    private static final String SHOW_ID = "showId";
    private static final String SHOW_IMG = "showImg";
    private static final String SHOW_KIND = "showKind";
    private static final String SHOW_NAME = "showName";
    private static final String SHOW_VER_IMG = "showVImg";
    private static final String STAGE = "stage";
    private static final String TITLE = "title";
    private static final String TP = "tp";
    private static final String VIDEO_ID = "videoId";

    @JSMethod
    public void uploadLiveInfo(String str, String str2, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1165076673")) {
            ipChange.ipc$dispatch("-1165076673", new Object[]{this, str, str2, Long.valueOf(j)});
        } else {
            "0".equals(OrangeUtil.getLiveLogUpload());
        }
    }

    @JSMethod
    public void uploadLiveInfoParamsMap(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337765918")) {
            ipChange.ipc$dispatch("-1337765918", new Object[]{this, map});
        } else if (map == null || map.size() <= 0) {
            ((ILog) Dsl.getService(ILog.class)).d("LivePlayLogUploadModule", "paramsMap is invalid - -！, Please check it carefully.");
        }
    }
}
