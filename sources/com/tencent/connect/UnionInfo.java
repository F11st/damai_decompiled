package com.tencent.connect;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.SocialOperation;
import com.tencent.open.utils.C7119g;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IUiListener;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UnionInfo extends BaseApi {
    public static final String URL_GET_UNION_ID = "https://openmobile.qq.com/oauth2.0/me";

    public UnionInfo(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void getUnionId(IUiListener iUiListener) {
        Bundle a = a();
        a.putString(SocialOperation.GAME_UNION_ID, "1");
        HttpUtils.requestAsync(this.c, C7119g.a(), URL_GET_UNION_ID, a, "GET", new BaseApi.TempRequestListener(iUiListener));
    }
}
