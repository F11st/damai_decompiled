package com.ali.user.open.oauth.alipay3.model;

import com.ali.user.open.core.model.UccBaseRequest;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccMtopGenerateAlipayAuthUrlRequest extends UccBaseRequest {
    public String redirectUri;
    public String scope = "auth_user";
    public String site;
    public String userToken;
}
