package com.ali.user.open.ucc.alipay3;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.oauth.OauthService;
import com.ali.user.open.ucc.base.BaseUccServiceProvider;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AlipayUccServiceProviderImpl extends BaseUccServiceProvider {
    public static final String TAG = "AlipayUccServiceProviderImpl";

    @Override // com.ali.user.open.ucc.base.BaseUccServiceProvider, com.ali.user.open.ucc.UccServiceProvider
    public void cleanUp(Context context) {
        ((OauthService) AliMemberSDK.getService(OauthService.class)).logout(context, "alipay");
    }

    @Override // com.ali.user.open.ucc.base.BaseUccServiceProvider
    protected boolean isAuthByNative(Context context, String str, Map<String, String> map) {
        return map != null && TextUtils.equals(map.get(ParamsConstants.Key.PARAM_FORCE_NATIVE), "1");
    }
}
