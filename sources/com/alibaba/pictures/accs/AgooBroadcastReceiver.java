package com.alibaba.pictures.accs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.agoo.TaobaoRegister;
import io.flutter.wpkbridge.WPKFactory;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.e4;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/alibaba/pictures/accs/AgooBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "accs_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class AgooBroadcastReceiver extends BroadcastReceiver {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "159943458")) {
            ipChange.ipc$dispatch("159943458", new Object[]{this, context, intent});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        String action = intent.getAction();
        if ((action == null || action.length() == 0) ? true : true) {
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra(e4.AGOO_MSG);
        if (!(serializableExtra instanceof AgooMessage)) {
            serializableExtra = null;
        }
        AgooMessage agooMessage = (AgooMessage) serializableExtra;
        if (agooMessage != null) {
            if (b41.d("com.taobao.movie.action.PUSH_NOTIFY_ACTION", action)) {
                INotifyActionHandler h = PushAgent.INSTANCE.h();
                if (h == null || !h.onInterceptAlarmMsg(agooMessage)) {
                    e4.e(context, agooMessage);
                }
            } else if (b41.d("com.taobao.movie.action.PUSH_CLICK_ACTION", action)) {
                INotifyActionHandler h2 = PushAgent.INSTANCE.h();
                if (h2 != null) {
                    h2.onNotifyCLick(agooMessage);
                }
            } else if (b41.d("com.taobao.movie.action.PUSH_DELETE_ACTION", action)) {
                TaobaoRegister.dismissMessage(context, agooMessage.getMsgId(), agooMessage.getMsgTaskId());
                INotifyActionHandler h3 = PushAgent.INSTANCE.h();
                if (h3 != null) {
                    h3.onNotifyDelete(agooMessage);
                }
            }
        }
    }
}
