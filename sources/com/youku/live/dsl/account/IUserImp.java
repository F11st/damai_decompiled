package com.youku.live.dsl.account;

import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.device.UTDevice;
import com.youku.live.dsl.Dsl;
import com.youku.usercenter.passport.result.UserInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class IUserImp implements IUser {
    private static transient /* synthetic */ IpChange $ipChange;
    private static IUserImp sInstance;

    public static IUserImp getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1690291773")) {
            return (IUserImp) ipChange.ipc$dispatch("1690291773", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (IUserImp.class) {
                if (sInstance == null) {
                    sInstance = new IUserImp();
                }
            }
        }
        return sInstance;
    }

    @Override // com.youku.live.dsl.account.IUser
    public String getAvatarUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1317394968")) {
            return (String) ipChange.ipc$dispatch("-1317394968", new Object[]{this});
        }
        UserInfo o = LoginManager.k().o();
        if (o != null) {
            return o.mAvatarUrl;
        }
        return null;
    }

    @Override // com.youku.live.dsl.account.IUser
    public Map<String, String> getExtra() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "157332211")) {
            return (Map) ipChange.ipc$dispatch("157332211", new Object[]{this});
        }
        UserInfo o = LoginManager.k().o();
        HashMap hashMap = new HashMap();
        if (o != null) {
            hashMap.put("mUserName", o.mUserName);
            hashMap.put("mUid", o.mUid);
            hashMap.put("mYoukuUid", o.mYoukuUid);
            hashMap.put("mYid", o.mYid);
            hashMap.put("mNickName", o.mNickName);
            hashMap.put("mEmail", o.mEmail);
            hashMap.put("mRegion", o.mRegion);
            hashMap.put("mMobile", o.mMobile);
            hashMap.put("mAvatarUrl", o.mAvatarUrl);
            try {
                hashMap.put("utdid", UTDevice.getUtdid(Dsl.getContext()));
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    @Override // com.youku.live.dsl.account.IUser
    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "881404799") ? (String) ipChange.ipc$dispatch("881404799", new Object[]{this}) : LoginManager.k().n();
    }

    @Override // com.youku.live.dsl.account.IUser
    public String getNickName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584594254")) {
            return (String) ipChange.ipc$dispatch("-584594254", new Object[]{this});
        }
        UserInfo o = LoginManager.k().o();
        if (o != null) {
            return o.mNickName;
        }
        return null;
    }
}
