package com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest;

import com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.CityWantRequest;
import com.alibaba.pictures.bricks.component.home.FollowStateBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.dc0;
import tb.rb0;
import tb.wt2;
import tb.x2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CityWantRequestKt {
    private static transient /* synthetic */ IpChange $ipChange;

    public static final void a(boolean z, @NotNull String str, @NotNull final ActionRelation<FollowStateBean> actionRelation, @NotNull CityWantRequest.PageName pageName) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-939467687")) {
            ipChange.ipc$dispatch("-939467687", new Object[]{Boolean.valueOf(z), str, actionRelation, pageName});
            return;
        }
        b41.i(str, "targetId");
        b41.i(actionRelation, "actionRelation");
        b41.i(pageName, "pageName");
        actionRelation.start();
        rb0.C9647a c9647a = rb0.Companion;
        CityWantRequest cityWantRequest = new CityWantRequest();
        cityWantRequest.setGroup(CityWantRequest.GroupType.ARTIST_GROUP.getValue());
        cityWantRequest.setTargetType(CityWantRequest.TargetType.ARTIST.getValue());
        cityWantRequest.setOperateType(z ? "1" : "0");
        cityWantRequest.setTargetId(str);
        cityWantRequest.setPageName(pageName.getValue());
        cityWantRequest.setReturnRelationStatus(1);
        c9647a.b(cityWantRequest).a().doOnKTSuccess(new Function1<FollowStateBean, wt2>() { // from class: com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.CityWantRequestKt$doRelationUpdate4Artist$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(FollowStateBean followStateBean) {
                invoke2(followStateBean);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FollowStateBean followStateBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1936200314")) {
                    ipChange2.ipc$dispatch("1936200314", new Object[]{this, followStateBean});
                    return;
                }
                b41.i(followStateBean, AdvanceSetting.NETWORK_TYPE);
                actionRelation.action(new x2<>(true, followStateBean, null, null, 12, null));
            }
        }).doOnKTFail(new Function1<dc0<FollowStateBean>, wt2>() { // from class: com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.CityWantRequestKt$doRelationUpdate4Artist$3
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(dc0<FollowStateBean> dc0Var) {
                invoke2(dc0Var);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull dc0<FollowStateBean> dc0Var) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1486861380")) {
                    ipChange2.ipc$dispatch("1486861380", new Object[]{this, dc0Var});
                    return;
                }
                b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                actionRelation.action(new x2<>(false, null, dc0Var.e(), dc0Var.f()));
            }
        }).doOnKTFinish(new Function0<wt2>() { // from class: com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.CityWantRequestKt$doRelationUpdate4Artist$4
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1447462307")) {
                    ipChange2.ipc$dispatch("1447462307", new Object[]{this});
                } else {
                    actionRelation.end();
                }
            }
        });
    }

    public static /* synthetic */ void b(boolean z, String str, ActionRelation actionRelation, CityWantRequest.PageName pageName, int i, Object obj) {
        if ((i & 8) != 0) {
            pageName = CityWantRequest.PageName.DM_ARTIST_DETAIL;
        }
        a(z, str, actionRelation, pageName);
    }
}
