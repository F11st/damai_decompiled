package com.ali.user.open.tbauth.task;

import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.model.ResultCode;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.service.MemberExecutorService;
import com.ali.user.open.core.task.AbsAsyncTask;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.device.DeviceTokenManager;
import com.ali.user.open.history.AccountHistoryManager;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.service.impl.SessionManager;
import com.ali.user.open.tbauth.callback.LogoutCallback;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class LogoutTask extends AbsAsyncTask<Void, Void, Void> {
    private LogoutCallback mLogoutCallback;

    public LogoutTask(LogoutCallback logoutCallback) {
        this.mLogoutCallback = logoutCallback;
    }

    @Override // com.ali.user.open.core.task.AbsAsyncTask
    protected void doFinally() {
    }

    @Override // com.ali.user.open.core.task.AbsAsyncTask
    protected void doWhenException(Throwable th) {
        CommonUtils.onFailure(this.mLogoutCallback, ResultCode.create(10010, th.getMessage()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.open.core.task.AbsAsyncTask
    public Void asyncExecute(Void... voidArr) {
        ResultCode logout;
        MemberExecutorService memberExecutorService;
        Runnable runnable;
        try {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("into logout ");
                SessionManager sessionManager = SessionManager.INSTANCE;
                sb.append(sessionManager.getInternalSession().toString());
                SDKLogger.e("logout task", sb.toString());
                String str = sessionManager.getSession("taobao").hid;
                if (TextUtils.isEmpty(str)) {
                    str = sessionManager.getInternalSession().userId;
                }
                if (!TextUtils.isEmpty(str)) {
                    RpcRepository.logout(str, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.tbauth.task.LogoutTask.1
                        @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
                        public void onError(String str2, RpcResponse rpcResponse) {
                        }

                        @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
                        public void onSuccess(RpcResponse rpcResponse) {
                        }

                        @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
                        public void onSystemError(String str2, RpcResponse rpcResponse) {
                        }
                    });
                }
                AccountHistoryManager.getInstance().clearHistoryAccount();
                DeviceTokenManager.getInstance().clearDeviceToken();
                logout = ((SessionService) AliMemberSDK.getService(SessionService.class)).logout("taobao");
            } catch (Exception e) {
                e.printStackTrace();
                logout = ((SessionService) AliMemberSDK.getService(SessionService.class)).logout("taobao");
                if (ResultCode.SUCCESS.equals(logout)) {
                    memberExecutorService = (MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class);
                    runnable = new Runnable() { // from class: com.ali.user.open.tbauth.task.LogoutTask.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LogoutTask.this.mLogoutCallback != null) {
                                LogoutTask.this.mLogoutCallback.onSuccess();
                            }
                        }
                    };
                }
            }
            if (ResultCode.SUCCESS.equals(logout)) {
                memberExecutorService = (MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class);
                runnable = new Runnable() { // from class: com.ali.user.open.tbauth.task.LogoutTask.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LogoutTask.this.mLogoutCallback != null) {
                            LogoutTask.this.mLogoutCallback.onSuccess();
                        }
                    }
                };
                memberExecutorService.postUITask(runnable);
                return null;
            }
            CommonUtils.onFailure(this.mLogoutCallback, logout);
            return null;
        } catch (Throwable th) {
            ResultCode logout2 = ((SessionService) AliMemberSDK.getService(SessionService.class)).logout("taobao");
            if (ResultCode.SUCCESS.equals(logout2)) {
                ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.tbauth.task.LogoutTask.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LogoutTask.this.mLogoutCallback != null) {
                            LogoutTask.this.mLogoutCallback.onSuccess();
                        }
                    }
                });
            } else {
                CommonUtils.onFailure(this.mLogoutCallback, logout2);
            }
            throw th;
        }
    }
}
