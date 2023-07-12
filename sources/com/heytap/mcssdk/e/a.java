package com.heytap.mcssdk.e;

import android.content.Context;
import com.heytap.mcssdk.constant.MessageConstant$CommandId;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import tb.d43;
import tb.iw2;
import tb.o73;
import tb.z53;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a implements c {
    /* JADX INFO: Access modifiers changed from: private */
    public void c(d43 d43Var, com.heytap.mcssdk.c cVar) {
        String str;
        if (d43Var == null) {
            str = "message is null , please check param of parseCommandMessage(2)";
        } else if (cVar == null) {
            str = "pushService is null , please check param of parseCommandMessage(2)";
        } else if (cVar.s() != null) {
            int f = d43Var.f();
            if (f == 12287) {
                ICallBackResultService s = cVar.s();
                if (s != null) {
                    s.onError(d43Var.j(), d43Var.h());
                    return;
                }
                return;
            } else if (f == 12298) {
                cVar.s().onSetPushTime(d43Var.j(), d43Var.h());
                return;
            } else if (f == 12306) {
                cVar.s().onGetPushStatus(d43Var.j(), iw2.i(d43Var.h()));
                return;
            } else if (f == 12309) {
                cVar.s().onGetNotificationStatus(d43Var.j(), iw2.i(d43Var.h()));
                return;
            } else if (f == 12289) {
                if (d43Var.j() == 0) {
                    cVar.setRegisterID(d43Var.h());
                }
                cVar.s().onRegister(d43Var.j(), d43Var.h());
                return;
            } else if (f == 12290) {
                cVar.s().onUnRegister(d43Var.j());
                return;
            } else {
                switch (f) {
                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                        ISetAppNotificationCallBackService u = cVar.u();
                        if (u != null) {
                            u.onSetAppNotificationSwitch(d43Var.j());
                            return;
                        }
                        return;
                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                        int i = 0;
                        try {
                            i = Integer.parseInt(d43Var.h());
                        } catch (Exception unused) {
                        }
                        IGetAppNotificationCallBackService t = cVar.t();
                        if (t != null) {
                            t.onGetAppNotificationSwitch(d43Var.j(), i);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } else {
            str = "pushService.getPushCallback() is null , please check param of parseCommandMessage(2)";
        }
        z53.b(str);
    }

    @Override // com.heytap.mcssdk.e.c
    public void a(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4105) {
            final d43 d43Var = (d43) baseMode;
            z53.a("mcssdk-CallBackResultProcessor:" + d43Var.toString());
            o73.b(new Runnable() { // from class: com.heytap.mcssdk.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.c(d43Var, com.heytap.mcssdk.c.m());
                }
            });
        }
    }
}
