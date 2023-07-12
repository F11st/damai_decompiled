package com.alient.oneservice.provider.impl.userinfo;

import cn.damai.im.UserInfoUtil;
import com.alibaba.fastjson.JSONObject;
import com.alient.oneservice.userinfo.MemberProvider;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MemberProviderImpl implements MemberProvider {
    @Override // com.alient.oneservice.userinfo.MemberProvider
    public JSONObject getCurrentUserInfo() {
        if (UserInfoUtil.a() == null || UserInfoUtil.a().getUserBaseInfo() == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("nickname", (Object) UserInfoUtil.a().getUserBaseInfo().getNickname());
        jSONObject.put("avatarUrl", (Object) UserInfoUtil.a().getUserBaseInfo().getHeadImg());
        return jSONObject;
    }
}
