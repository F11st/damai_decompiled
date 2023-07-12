package cn.damai.h5container.action;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import cn.damai.wxapi.ShareUtil;
import com.alibaba.security.common.track.model.C3834a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import tb.qw2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionWxShare extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionWxShare(Context context) {
        super(context);
    }

    private void getparam(String[] strArr, HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1101945217")) {
            ipChange.ipc$dispatch("-1101945217", new Object[]{this, strArr, hashMap});
            return;
        }
        for (String str : strArr) {
            String[] split = str.split("=");
            if (split != null && split.length >= 2) {
                try {
                    split[1] = URLDecoder.decode(split[1], "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                hashMap.put(split[0], split[1]);
            }
        }
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1264150538")) {
            return ((Boolean) ipChange.ipc$dispatch("-1264150538", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        String param = getParam("url");
        if (TextUtils.isEmpty(param)) {
            wVCallBackContext.error("error shareUrl");
            return false;
        }
        share(param);
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "493753124") ? (String) ipChange.ipc$dispatch("493753124", new Object[]{this}) : "weixinShare";
    }

    public void share(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1848908915")) {
            ipChange.ipc$dispatch("1848908915", new Object[]{this, str});
            return;
        }
        int i = (!str.contains("weixinshare") && str.contains("weixinfshare")) ? 1 : 0;
        String[] split = str.substring(str.indexOf("?") + 1).split("&");
        if (split == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        getparam(split, hashMap);
        String str2 = hashMap.get("title");
        String str3 = hashMap.get("content");
        String str4 = hashMap.get(SocialConstants.PARAM_IMAGE);
        String str5 = hashMap.get("rurl");
        if (str4.contains(",")) {
            str4 = str4.split(",")[0];
        }
        String str6 = str4;
        qw2.d("aa", "title--" + str2 + "content---" + str3 + "imageurl--" + str6 + "producturl--" + str5);
        shareByWchart(str2, str3, str6, str5, i);
    }

    public void shareByWchart(String str, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1222108368")) {
            ipChange.ipc$dispatch("-1222108368", new Object[]{this, str, str2, str3, str4, Integer.valueOf(i)});
            return;
        }
        qw2.d("aa", "weixin share click");
        ShareUtil shareUtil = new ShareUtil((Activity) this.contextReference, C3834a.C3837c.d);
        shareUtil.initShareData(str, str2, str3, str4, "");
        shareUtil.shareByWchart(i);
    }
}
