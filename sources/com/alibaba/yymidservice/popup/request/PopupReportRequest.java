package com.alibaba.yymidservice.popup.request;

import android.content.Context;
import com.alibaba.yymidservice.popup.request.bean.PopupReportResponseBean;
import com.alibaba.yymidservice.popup.request.requestparam.PopupReportRequestParam;
import com.alibaba.yymidservice.popup.request.requestparam.PopupRequestParam;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tb.a23;
import tb.b41;
import tb.dc0;
import tb.rb0;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class PopupReportRequest {
    public final void a(@NotNull Context context, @NotNull final String str, @Nullable final String str2, @Nullable final JSONObject jSONObject) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "comboCityId");
        rb0.C9647a c9647a = rb0.Companion;
        PopupReportRequestParam popupReportRequestParam = new PopupReportRequestParam();
        popupReportRequestParam.setComboCityId(str);
        popupReportRequestParam.setPkId(str2);
        popupReportRequestParam.setArgs(jSONObject);
        c9647a.b(popupReportRequestParam).c(context).a().doOnKTSuccess(new Function1<PopupReportResponseBean, wt2>() { // from class: com.alibaba.yymidservice.popup.request.PopupReportRequest$popupReportRequest$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(PopupReportResponseBean popupReportResponseBean) {
                invoke2(popupReportResponseBean);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PopupReportResponseBean popupReportResponseBean) {
                b41.i(popupReportResponseBean, AdvanceSetting.NETWORK_TYPE);
            }
        }).doOnKTFail(new Function1<dc0<PopupReportResponseBean>, wt2>() { // from class: com.alibaba.yymidservice.popup.request.PopupReportRequest$popupReportRequest$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(dc0<PopupReportResponseBean> dc0Var) {
                invoke2(dc0Var);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull dc0<PopupReportResponseBean> dc0Var) {
                b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                a23 a23Var = a23.INSTANCE;
                String str3 = new PopupRequestParam().API_NAME;
                String e = dc0Var.e();
                if (e == null) {
                    e = null;
                }
                String f = dc0Var.f();
                a23Var.a(a23Var.b(str3, "弹窗上报请求", e, f, "comboCityId: " + str + "  pkId: " + str2 + "  args : " + jSONObject), "-107", "弹窗上报请求");
            }
        }).doOnKTFinish(new Function0<wt2>() { // from class: com.alibaba.yymidservice.popup.request.PopupReportRequest$popupReportRequest$4
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        });
    }
}
