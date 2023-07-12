package com.youku.android.liveservice.utils;

import android.text.TextUtils;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.util.ReflectUtil;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MTopHelper {
    private static Mtop sMtop;

    public static void buildMtopBusiness(MtopBusiness mtopBusiness, String str, Map<String, String> map, boolean z, IRemoteBaseListener iRemoteBaseListener) {
        mtopBusiness.reqMethod(z ? MethodEnum.GET : MethodEnum.POST);
        mtopBusiness.headers(buildRequestHeader(str, map));
        if (iRemoteBaseListener != null) {
            mtopBusiness.registerListener((IRemoteListener) iRemoteBaseListener);
        } else {
            mtopBusiness.registerListener((IRemoteListener) new IRemoteBaseListener() { // from class: com.youku.android.liveservice.utils.MTopHelper.1
                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onError(int i, MtopResponse mtopResponse, Object obj) {
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
                public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                }
            });
        }
    }

    public static void buildMtopRequest(MtopRequest mtopRequest, String str, String str2, boolean z, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mtopRequest.setApiName(str);
        if (TextUtils.isEmpty(str2)) {
            mtopRequest.setVersion("1.0");
        } else {
            mtopRequest.setVersion(str2);
        }
        mtopRequest.setNeedEcode(z);
        if (map == null) {
            map = new HashMap<>();
        }
        mtopRequest.setData(ReflectUtil.converMapToDataStr(map));
    }

    public static Map<String, String> buildRequestHeader(String str, Map<String, String> map) {
        return new HashMap();
    }

    public static Mtop getMtop() {
        return sMtop;
    }

    public static void setMtop(Mtop mtop) {
        sMtop = mtop;
    }
}
