package com.ali.user.mobile.app.init;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ali.user.mobile.app.LoginContext;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.app.dataprovider.IDataProvider;
import com.ali.user.mobile.info.AlipayInfo;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.service.FaceService;
import com.ali.user.mobile.service.FingerprintService;
import com.ali.user.mobile.service.HuaweiService;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.NumberAuthService;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.SNSBindService;
import com.ali.user.mobile.service.SNSService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.service.StorageService;
import com.ali.user.mobile.service.UIService;
import com.ali.user.mobile.service.UserTrackService;
import com.ali.user.open.core.model.Constants;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.taobao.login4android.session.SessionManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AliUserInit {
    private static AtomicBoolean INITED = new AtomicBoolean(false);
    private static final String TAG = "login.AliUserSdkInit";

    public static void init(IDataProvider iDataProvider) {
        TLogAdapter.e(TAG, "AliUserInit 初始化开始");
        if (INITED.compareAndSet(false, true)) {
            if (iDataProvider != null && iDataProvider.getContext() != null) {
                DataProviderFactory.setDataProvider(iDataProvider);
                AppInfo.getInstance().init();
                try {
                    APSecuritySdk aPSecuritySdk = APSecuritySdk.a;
                    AlipayInfo.getInstance().init();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                TLogAdapter.d(TAG, "AliUserInit 初始化结束");
                LocalBroadcastManager.getInstance(DataProviderFactory.getApplicationContext()).sendBroadcast(new Intent(AppInfo.INITED_ACTION));
                initACCSLogin();
                return;
            }
            TLogAdapter.e("login.LaunchInit", new RuntimeException("DataProvider object is null, Failed to initialize"));
            return;
        }
        TLogAdapter.e("AliUserSdkInit", "duplicate init");
    }

    private static void initACCSLogin() {
        String[] split;
        SharedPreferences sharedPreferences = DataProviderFactory.getApplicationContext().getSharedPreferences(SessionManager.USERINFO, 4);
        String string = sharedPreferences.getString("accs_login", "");
        if (!TextUtils.isEmpty(string) && (split = TextUtils.split(string, Constants.COOKIE_SPLIT)) != null && split.length == 2) {
            try {
                if (System.currentTimeMillis() - Long.parseLong(split[1]) <= 300000) {
                    LoginContext.NEED_ACCS_LOGIN = true;
                    return;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove("accs_login");
                edit.apply();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        LoginContext.NEED_ACCS_LOGIN = false;
    }

    public static void initSystemService() {
        ServiceFactory.registerService(RpcService.class);
        ServiceFactory.registerService(StorageService.class);
        ServiceFactory.registerService(NavigatorService.class);
        ServiceFactory.registerService(UIService.class);
        ServiceFactory.registerService(FaceService.class);
        ServiceFactory.registerService(SNSService.class);
        ServiceFactory.registerService(FingerprintService.class);
        ServiceFactory.registerService(SNSBindService.class);
        ServiceFactory.registerService(UserTrackService.class);
        ServiceFactory.registerService(NumberAuthService.class);
        ServiceFactory.registerService(HuaweiService.class);
    }
}
