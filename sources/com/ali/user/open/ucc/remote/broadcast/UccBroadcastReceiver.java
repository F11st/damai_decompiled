package com.ali.user.open.ucc.remote.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.open.cookies.CookieManagerWrapper;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.service.MemberExecutorService;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.core.util.FileUtils;
import com.ali.user.open.oauth.OauthService;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "login.LoginBroadcastReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.equals(action, UccResultAction.NOTIFY_UCC_LOGIN_SUCCESS.name())) {
            final String stringExtra = intent.getStringExtra("site");
            String stringExtra2 = intent.getStringExtra("process");
            if (!ConfigManager.getInstance().isMultiProcessEnable || TextUtils.isEmpty(stringExtra) || TextUtils.equals(stringExtra2, CommonUtils.getProcessName(context))) {
                return;
            }
            ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postTask(new Runnable() { // from class: com.ali.user.open.ucc.remote.broadcast.UccBroadcastReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    CookieManagerWrapper.INSTANCE.refreshCookie(stringExtra);
                }
            });
        } else if (ConfigManager.getInstance().isMultiProcessEnable && TextUtils.equals(action, UccResultAction.NOTIFY_UCC_LOGOUT.name())) {
            final String stringExtra3 = intent.getStringExtra("site");
            ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postTask(new Runnable() { // from class: com.ali.user.open.ucc.remote.broadcast.UccBroadcastReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    CookieManagerWrapper.INSTANCE.clearCookies(stringExtra3);
                }
            });
        } else if (!TextUtils.equals(action, "NOTIFY_LOGIN_SUCCESS") && TextUtils.equals(action, "NOTIFY_LOGOUT")) {
            ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postTask(new Runnable() { // from class: com.ali.user.open.ucc.remote.broadcast.UccBroadcastReceiver.3
                @Override // java.lang.Runnable
                public void run() {
                    CookieManagerWrapper cookieManagerWrapper = CookieManagerWrapper.INSTANCE;
                    cookieManagerWrapper.clearCookies(Site.ELEME, FileUtils.readFileData(KernelContext.getApplicationContext(), cookieManagerWrapper.getCoookieBackupFileNameBySite(Site.ELEME)));
                    ((OauthService) AliMemberSDK.getService(OauthService.class)).logoutAll(KernelContext.getApplicationContext());
                }
            });
        }
    }
}
