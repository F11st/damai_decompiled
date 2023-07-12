package com.ali.user.open.ucc.icbu;

import android.content.Context;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.oauth.OauthService;
import com.ali.user.open.ucc.base.BaseUccServiceProvider;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class IcbuUccServiceProviderImpl extends BaseUccServiceProvider {
    @Override // com.ali.user.open.ucc.base.BaseUccServiceProvider
    protected boolean isAuthByNative(Context context, String str, Map<String, String> map) {
        return false;
    }

    @Override // com.ali.user.open.ucc.base.BaseUccServiceProvider, com.ali.user.open.ucc.UccServiceProvider
    public void refreshWhenLogin(String str, String str2, boolean z) {
        ((OauthService) AliMemberSDK.getService(OauthService.class)).refreshWhenLogin(Site.ICBU, str2, z);
    }
}
