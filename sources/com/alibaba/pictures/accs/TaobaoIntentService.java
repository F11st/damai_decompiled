package com.alibaba.pictures.accs;

import android.content.Context;
import android.content.Intent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.TaobaoBaseIntentService;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/alibaba/pictures/accs/TaobaoIntentService;", "Lcom/taobao/agoo/TaobaoBaseIntentService;", "<init>", "()V", "accs_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public class TaobaoIntentService extends TaobaoBaseIntentService {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String a = "AGOO." + TaobaoIntentService.class.getSimpleName();

    @Override // com.taobao.agoo.TaobaoBaseIntentService, org.android.agoo.control.BaseIntentService
    protected void onError(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "703107093")) {
            ipChange.ipc$dispatch("703107093", new Object[]{this, context, str});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "s");
        IAgooServiceDelegate e = PushAgent.INSTANCE.e();
        if (e != null) {
            e.onError(context, str);
        }
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService, org.android.agoo.control.BaseIntentService
    protected void onMessage(@NotNull Context context, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "98222663")) {
            ipChange.ipc$dispatch("98222663", new Object[]{this, context, intent});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        try {
            PushAgent pushAgent = PushAgent.INSTANCE;
            IAgooServiceDelegate e = pushAgent.e();
            if (e != null) {
                e.onOriDataReceiver(context, intent);
            }
            if (intent != null && intent.getExtras() != null) {
                String stringExtra = intent.getStringExtra("id");
                String stringExtra2 = intent.getStringExtra("body");
                String stringExtra3 = intent.getStringExtra("task_id");
                IAgooServiceDelegate e2 = pushAgent.e();
                if (e2 != null) {
                    e2.onDataReceiver(context, stringExtra, stringExtra3, stringExtra2);
                    return;
                }
                return;
            }
            ALog.e(this.a, "onMessage: TaobaoAgooService onMessage data is null or empty", new Object[0]);
        } catch (Exception e3) {
            ALog.e(this.a, e3.toString(), new Object[0]);
        }
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService, org.android.agoo.control.BaseIntentService
    protected void onRegistered(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1009806063")) {
            ipChange.ipc$dispatch("1009806063", new Object[]{this, context, str});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "s");
        IAgooServiceDelegate e = PushAgent.INSTANCE.e();
        if (e != null) {
            e.onRegistered(context, str);
        }
    }

    @Override // com.taobao.agoo.TaobaoBaseIntentService
    protected void onUnregistered(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-905191800")) {
            ipChange.ipc$dispatch("-905191800", new Object[]{this, context, str});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "s");
        IAgooServiceDelegate e = PushAgent.INSTANCE.e();
        if (e != null) {
            e.onUnregistered(context, str);
        }
    }
}
