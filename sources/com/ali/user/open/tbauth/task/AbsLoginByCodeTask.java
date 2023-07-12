package com.ali.user.open.tbauth.task;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.service.MemberExecutorService;
import com.ali.user.open.core.task.TaskWithDialog;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.session.Session;
import com.ali.user.open.tbauth.RequestCode;
import com.ali.user.open.tbauth.context.TbAuthContext;
import com.ali.user.open.tbauth.ui.TbAuthWebViewActivity;
import com.ali.user.open.tbauth.ui.context.CallbackContext;
import com.ali.user.open.tbauth.util.SessionConvert;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public abstract class AbsLoginByCodeTask extends TaskWithDialog<String, Void, Void> {
    private static final String TAG = "AbsLoginByCodeTask";

    public AbsLoginByCodeTask(Activity activity) {
        super(activity);
    }

    protected abstract void doWhenResultFail(int i, String str);

    protected abstract void doWhenResultOk(Session session);

    protected abstract RpcResponse<LoginReturnData> login(String[] strArr);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.open.core.task.AbsAsyncTask
    public Void asyncExecute(String... strArr) {
        final Session session;
        final RpcResponse<LoginReturnData> login = login(strArr);
        final int i = login.code;
        SDKLogger.d(TAG, "asyncExecute code = " + i);
        try {
            if (i == 3000) {
                LoginReturnData loginReturnData = login.returnValue;
                if (loginReturnData == null) {
                    session = null;
                } else if (TbAuthContext.needSession) {
                    ((SessionService) AliMemberSDK.getService(SessionService.class)).refreshWhenLogin("taobao", login.returnValue);
                    session = ((SessionService) AliMemberSDK.getService(SessionService.class)).getSession();
                } else {
                    session = SessionConvert.convertLoginDataToSeesion(loginReturnData);
                }
                ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.tbauth.task.AbsLoginByCodeTask.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AbsLoginByCodeTask.this.doWhenResultOk(session);
                    }
                });
            } else if (i == 13060) {
                String str = login.returnValue.h5Url;
                SDKLogger.d(TAG, "asyncExecute doubleCheckUrl = " + str);
                if (!TextUtils.isEmpty(str)) {
                    Activity activity = this.activity;
                    CallbackContext.setActivity(activity);
                    Intent intent = new Intent(activity, TbAuthWebViewActivity.class);
                    intent.putExtra("url", str);
                    intent.putExtra("token", login.returnValue.token);
                    intent.putExtra("scene", login.returnValue.scene);
                    LoginReturnData loginReturnData2 = login.returnValue;
                    TbAuthWebViewActivity.token = loginReturnData2.token;
                    TbAuthWebViewActivity.scene = loginReturnData2.scene;
                    this.activity.startActivityForResult(intent, RequestCode.OPEN_DOUBLE_CHECK);
                }
            } else {
                ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.tbauth.task.AbsLoginByCodeTask.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SDKLogger.d(AbsLoginByCodeTask.TAG, "15 : " + login.message);
                        AbsLoginByCodeTask absLoginByCodeTask = AbsLoginByCodeTask.this;
                        absLoginByCodeTask.doWhenResultFail(15, "login:code " + i + " " + login.message);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
