package com.ali.user.open.oauth.wechat;

import android.app.Activity;
import com.ali.user.open.oauth.OauthCallback;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mtopsdk.security.util.SignConstants;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class WechatAuthRespHandler {
    private static volatile WechatAuthRespHandler sInstance;
    private List<OauthCallback> mOauthCallbackContainer = new ArrayList();

    private WechatAuthRespHandler() {
    }

    public static WechatAuthRespHandler getInstance() {
        if (sInstance == null) {
            synchronized (WechatAuthRespHandler.class) {
                if (sInstance == null) {
                    sInstance = new WechatAuthRespHandler();
                }
            }
        }
        return sInstance;
    }

    public void addOauthCallback(OauthCallback oauthCallback) {
        this.mOauthCallbackContainer.add(oauthCallback);
    }

    public void handleWechatAuthCode(String str) {
        List<OauthCallback> list = this.mOauthCallbackContainer;
        if (list == null || list.size() <= 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(SignConstants.MIDDLE_PARAM_AUTHCODE, str);
        this.mOauthCallbackContainer.get(0).onSuccess("wechat", hashMap);
        this.mOauthCallbackContainer.clear();
    }

    public void handleWechatAuthResp(Activity activity, BaseResp baseResp) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        int i = baseResp.errCode;
        if (i == -4) {
            List<OauthCallback> list = this.mOauthCallbackContainer;
            if (list != null && list.size() > 0) {
                this.mOauthCallbackContainer.get(0).onFail("wechat", 403, "");
                this.mOauthCallbackContainer.clear();
            }
        } else if (i == -2) {
            List<OauthCallback> list2 = this.mOauthCallbackContainer;
            if (list2 != null && list2.size() > 0) {
                this.mOauthCallbackContainer.get(0).onFail("wechat", 404, "");
                this.mOauthCallbackContainer.clear();
            }
        } else if (i == 0) {
            if (baseResp instanceof SendAuth.Resp) {
                String str = ((SendAuth.Resp) baseResp).code;
                List<OauthCallback> list3 = this.mOauthCallbackContainer;
                if (list3 != null && list3.size() > 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(SignConstants.MIDDLE_PARAM_AUTHCODE, str);
                    this.mOauthCallbackContainer.get(0).onSuccess("wechat", hashMap);
                    this.mOauthCallbackContainer.clear();
                }
            } else {
                List<OauthCallback> list4 = this.mOauthCallbackContainer;
                if (list4 != null && list4.size() > 0) {
                    this.mOauthCallbackContainer.get(0).onFail("wechat", 403, "");
                    this.mOauthCallbackContainer.clear();
                }
            }
        }
        activity.finish();
    }

    public void handleWechatFail() {
        List<OauthCallback> list = this.mOauthCallbackContainer;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mOauthCallbackContainer.get(0).onFail("wechat", 403, "");
        this.mOauthCallbackContainer.clear();
    }

    public boolean hasOauthCallback() {
        List<OauthCallback> list = this.mOauthCallbackContainer;
        return list != null && list.size() > 0;
    }
}
