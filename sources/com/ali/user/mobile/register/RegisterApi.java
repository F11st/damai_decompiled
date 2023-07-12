package com.ali.user.mobile.register;

import com.ali.user.mobile.base.BaseView;
import com.ali.user.mobile.model.RegistParam;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.register.model.OceanRegisterParam;
import com.ali.user.mobile.register.tasks.BaseRegisterTask;
import com.ali.user.mobile.register.tasks.DirectRegisterTask;
import com.ali.user.mobile.rpc.register.model.OceanRegisterResult;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class RegisterApi {
    private static final String TAG = "LoginManager";

    public static void directRegister(RegistParam registParam, String str, OceanRegisterParam oceanRegisterParam, TrackingModel trackingModel, BaseView baseView, BaseRegisterTask.RegisterTasksCallback<OceanRegisterResult> registerTasksCallback) {
        new DirectRegisterTask(registParam, str).register(oceanRegisterParam, trackingModel, baseView, registerTasksCallback);
    }
}
