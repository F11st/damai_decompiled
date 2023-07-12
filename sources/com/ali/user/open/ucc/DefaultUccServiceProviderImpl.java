package com.ali.user.open.ucc;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.model.LoginDataModel;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.core.util.JSONUtils;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.ucc.base.BaseUccServiceProvider;
import com.alibaba.fastjson.JSON;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DefaultUccServiceProviderImpl extends BaseUccServiceProvider {
    public static final String TAG = "AlipayUccServiceProviderImpl";

    @Override // com.ali.user.open.ucc.base.BaseUccServiceProvider
    protected boolean isAuthByNative(Context context, String str, Map<String, String> map) {
        return false;
    }

    @Override // com.ali.user.open.ucc.base.BaseUccServiceProvider, com.ali.user.open.ucc.UccServiceProvider
    public void refreshWhenLogin(String str, String str2, boolean z) {
        LoginReturnData loginReturnData = (LoginReturnData) JSON.parseObject(str2, LoginReturnData.class);
        try {
            LoginDataModel loginDataModel = (LoginDataModel) JSONUtils.toPOJO(new JSONObject(loginReturnData.data), LoginDataModel.class);
            if (TextUtils.isEmpty(loginDataModel.sid)) {
                if (loginDataModel.loginServiceExt == null) {
                    z = true;
                }
            }
        } catch (Throwable unused) {
        }
        if (z) {
            ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshCookie(str, loginReturnData);
        } else {
            ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshWhenLogin(str, loginReturnData);
        }
    }
}
