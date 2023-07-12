package com.youku.live.livesdk.wkit.module;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.account.ILogin;
import com.youku.live.dsl.account.ILoginChangedListener;
import com.youku.live.dsl.account.IUser;
import com.youku.vpm.constants.TableField;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DagoUser extends WXModule implements Destroyable, ILoginChangedListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean mHasListenPassport;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class UserInfo implements Serializable {
        public boolean isLogin = false;
        public String userFace = "";
        public String userNickName = "";
        public String userNumberId = "";
        public String ytid = "";
        public String encodeUid = "";
        public String utdid = "";
        public boolean isVip = false;
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1317194528")) {
            ipChange.ipc$dispatch("1317194528", new Object[]{this});
            return;
        }
        try {
            ((ILogin) Dsl.getService(ILogin.class)).unregisterLoginChangedListener(this);
        } catch (Throwable unused) {
        }
    }

    @JSMethod
    public void getUser(JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132733039")) {
            ipChange.ipc$dispatch("132733039", new Object[]{this, jSCallback});
        } else if (jSCallback == null) {
        } else {
            JSONObject jSONObject = new JSONObject();
            UserInfo userInfo = new UserInfo();
            try {
                ILogin iLogin = (ILogin) Dsl.getService(ILogin.class);
                IUser iUser = (IUser) Dsl.getService(IUser.class);
                iUser.getExtra();
                userInfo.isLogin = iLogin.isLogined();
                userInfo.userFace = iUser.getAvatarUrl();
                userInfo.userNickName = iUser.getNickName();
                userInfo.userNumberId = iUser.getExtra().get("mUid");
                userInfo.ytid = iUser.getExtra().get("mUid");
                userInfo.encodeUid = iUser.getExtra().get("mUid");
                userInfo.utdid = iUser.getExtra().get("utdid");
                userInfo.isVip = false;
                jSONObject.put("isLogin", (Object) Boolean.valueOf(iLogin.isLogined()));
                jSONObject.put("userFace", (Object) iUser.getAvatarUrl());
                jSONObject.put("userNickName", (Object) iUser.getNickName());
                jSONObject.put("userNumberId", (Object) iUser.getExtra().get("mUid"));
                jSONObject.put("ytid", (Object) iUser.getExtra().get("mUid"));
                jSONObject.put("encodeUid", (Object) iUser.getExtra().get("mUid"));
                jSONObject.put("utdid", (Object) iUser.getExtra().get("utdid"));
                jSONObject.put(TableField.IS_VIP, (Object) Boolean.FALSE);
            } catch (Throwable unused) {
            }
            jSCallback.invoke(jSONObject);
        }
    }

    @JSMethod
    public void initModule() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1170778708")) {
            ipChange.ipc$dispatch("1170778708", new Object[]{this});
        } else if (this.mHasListenPassport) {
        } else {
            this.mHasListenPassport = true;
            try {
                ((ILogin) Dsl.getService(ILogin.class)).registerLoginChangedListener(this);
            } catch (Throwable unused) {
            }
        }
    }

    @JSMethod
    public void login(String str, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1331161971")) {
            ipChange.ipc$dispatch("-1331161971", new Object[]{this, str, jSCallback});
            return;
        }
        try {
            if (this.mWXSDKInstance != null) {
                ((ILogin) Dsl.getService(ILogin.class)).login(this.mWXSDKInstance.getContext());
            } else {
                ((ILogin) Dsl.getService(ILogin.class)).login();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (jSCallback != null) {
            jSCallback.invoke(new HashMap());
        }
    }

    @Override // com.youku.live.dsl.account.ILoginChangedListener
    public void onLoginChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-787930002")) {
            ipChange.ipc$dispatch("-787930002", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.fireGlobalEventCallback("DAGOUserLogin", new HashMap());
        }
    }
}
