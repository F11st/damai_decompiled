package com.taobao.monitor.adapter.procedure.getter;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import com.ali.user.open.core.util.ParamsConstants;
import com.alibaba.fastjson.JSON;
import com.taobao.android.tlog.protocol.model.joint.point.StartupJointPoint;
import com.taobao.monitor.network.a;
import com.taobao.monitor.procedure.IProcedure;
import tb.dq1;
import tb.e30;
import tb.uu1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class H5ProcedureGetterBridge extends WVApiPlugin {
    private static final String ACTION_PROCEDURE_GETTER = "procedureGetter";
    private static final String TAG = "H5ProcedureGetterBridge";

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        String string;
        if (ACTION_PROCEDURE_GETTER.equals(str)) {
            try {
                e30.a(TAG, ACTION_PROCEDURE_GETTER);
                string = JSON.parseObject(str2).getString(ParamsConstants.Key.PARAM_H5URL);
            } catch (Exception e) {
                wVCallBackContext.error(e.getMessage());
            }
            if (!TextUtils.isEmpty(string)) {
                dq1 dq1Var = uu1.PROCEDURE_MANAGER;
                IProcedure launcherProcedure = dq1Var.getLauncherProcedure();
                String str3 = "";
                if (launcherProcedure != null && launcherProcedure.isAlive()) {
                    str3 = a.a(dq1Var.g(launcherProcedure));
                }
                String f = dq1Var.f(string);
                WVResult wVResult = new WVResult();
                wVResult.addData("content", f);
                wVResult.addData(StartupJointPoint.TYPE, str3);
                wVCallBackContext.success(wVResult);
                e30.a(TAG, "content", f);
                e30.a(TAG, StartupJointPoint.TYPE, str3);
                return true;
            }
            throw new IllegalArgumentException("no h5 URL param");
        }
        return false;
    }
}
