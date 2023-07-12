package com.youku.live.dago.widgetlib.module;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.youku.live.dago.widgetlib.interactive.resource.resource.YKLDownloadBean;
import com.youku.live.dago.widgetlib.interactive.resource.utils.YKLMD5Utils;
import com.youku.live.dago.widgetlib.protocol.YKLDownloadProtocol;
import com.youku.live.dago.widgetlib.wedome.adapter.download.IDownloadCallback;
import com.youku.live.dago.widgetlib.wedome.framework.YKLAdapterFactory;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLDownloadModule extends WXModule {
    private static transient /* synthetic */ IpChange $ipChange;
    YKLDownloadProtocol adapter = getAdapter();

    private List<YKLDownloadBean> cast2List(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1950777339")) {
            return (List) ipChange.ipc$dispatch("1950777339", new Object[]{this, obj});
        }
        if (obj == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ((ILog) Dsl.getService(ILog.class)).d("ykl-download", "JSON = " + String.valueOf(obj));
        JSONArray parseArray = JSON.parseArray(String.valueOf(obj));
        if (parseArray != null) {
            for (int i = 0; i < parseArray.size(); i++) {
                JSONObject jSONObject = parseArray.getJSONObject(i);
                if (jSONObject != null) {
                    YKLDownloadBean yKLDownloadBean = new YKLDownloadBean();
                    yKLDownloadBean.url = jSONObject.getString("url");
                    ((ILog) Dsl.getService(ILog.class)).w("ykl-download", i + " == YKLDownloadBean= " + yKLDownloadBean.url);
                    if (!TextUtils.isEmpty(yKLDownloadBean.url)) {
                        yKLDownloadBean.isZip = "1".equals(jSONObject.getString("iszip"));
                        yKLDownloadBean.type = jSONObject.getString("type");
                        if (!TextUtils.isEmpty(yKLDownloadBean.url)) {
                            yKLDownloadBean.fileName = YKLMD5Utils.md5(yKLDownloadBean.url) + "_tag";
                        }
                        arrayList.add(yKLDownloadBean);
                    }
                }
            }
        }
        return arrayList;
    }

    private YKLDownloadProtocol getAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "762704169") ? (YKLDownloadProtocol) ipChange.ipc$dispatch("762704169", new Object[]{this}) : (YKLDownloadProtocol) YKLAdapterFactory.getInstance().createInterface(YKLDownloadModule.class);
    }

    @JSMethod(uiThread = false)
    public void checkList(Object obj, final JSCallback jSCallback) {
        List<YKLDownloadBean> cast2List;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "835628785")) {
            ipChange.ipc$dispatch("835628785", new Object[]{this, obj, jSCallback});
        } else if (obj == null || (cast2List = cast2List(obj)) == null || cast2List.size() <= 0) {
        } else {
            this.adapter.download(this.adapter.checkResourceList(cast2List), new IDownloadCallback() { // from class: com.youku.live.dago.widgetlib.module.YKLDownloadModule.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.wedome.adapter.download.IDownloadCallback
                public void onFailure(int i, String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-566930354")) {
                        ipChange2.ipc$dispatch("-566930354", new Object[]{this, Integer.valueOf(i), str, str2});
                    } else if (jSCallback != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("code", Integer.valueOf(i));
                        hashMap.put("msg", str2);
                        hashMap.put("url", str);
                        jSCallback.invokeAndKeepAlive(hashMap);
                    }
                }

                @Override // com.youku.live.dago.widgetlib.wedome.adapter.download.IDownloadCallback
                public void onSuccess(int i, String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1019000263")) {
                        ipChange2.ipc$dispatch("1019000263", new Object[]{this, Integer.valueOf(i), str, str2});
                    } else if (jSCallback != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("code", Integer.valueOf(i));
                        hashMap.put("msg", str2);
                        hashMap.put("url", str);
                        jSCallback.invokeAndKeepAlive(hashMap);
                    }
                }
            });
        }
    }
}
