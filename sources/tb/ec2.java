package tb;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.bean.BottomAction;
import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.alibaba.pictures.bricks.gaiaxholder.GaiaXUtParamsGenerator;
import com.alibaba.pictures.bricks.gaiaxholder.UtParam;
import com.alibaba.pictures.bricks.gaiaxholder.UtType;
import com.alibaba.pictures.bricks.view.BottomActionDialog;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.IStable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ec2 extends y0 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a implements BottomActionDialog.OnActionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // com.alibaba.pictures.bricks.view.BottomActionDialog.OnActionListener
        public void onClick(@NotNull BottomAction bottomAction, @NotNull View view, @NotNull Dialog dialog) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1575413735")) {
                ipChange.ipc$dispatch("-1575413735", new Object[]{this, bottomAction, view, dialog});
                return;
            }
            b41.i(bottomAction, "action");
            b41.i(view, "v");
            b41.i(dialog, "dialog");
            ap2.INSTANCE.h(this.a, bottomAction.getExtra());
        }
    }

    public ec2() {
        super("damai", "damai_script_play_apply_store");
    }

    private final void h(String str, boolean z, GaiaXUtParamsGenerator gaiaXUtParamsGenerator) {
        UtParam generate;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-480661417")) {
            ipChange.ipc$dispatch("-480661417", new Object[]{this, str, Boolean.valueOf(z), gaiaXUtParamsGenerator});
        } else if (gaiaXUtParamsGenerator == null || (generate = gaiaXUtParamsGenerator.generate(UtType.click, b(), c(), str)) == null) {
        } else {
            qo1.INSTANCE.q(generate, z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
        if (r3 != false) goto L29;
     */
    @Override // tb.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(@org.jetbrains.annotations.NotNull android.view.View r12, @org.jetbrains.annotations.NotNull android.app.Activity r13, @org.jetbrains.annotations.NotNull com.youku.gaiax.api.data.EventParams r14, @org.jetbrains.annotations.Nullable com.alibaba.fastjson.JSONObject r15, int r16, @org.jetbrains.annotations.Nullable com.alibaba.pictures.bricks.gaiaxholder.GaiaXUtParamsGenerator r17) {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r17
            com.android.alibaba.ip.runtime.IpChange r6 = tb.ec2.$ipChange
            java.lang.String r7 = "-2070260784"
            boolean r8 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r6, r7)
            r9 = 0
            r10 = 1
            if (r8 == 0) goto L31
            r8 = 7
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r9] = r0
            r8[r10] = r1
            r1 = 2
            r8[r1] = r2
            r1 = 3
            r8[r1] = r3
            r1 = 4
            r8[r1] = r4
            r1 = 5
            java.lang.Integer r2 = java.lang.Integer.valueOf(r16)
            r8[r1] = r2
            r1 = 6
            r8[r1] = r5
            r6.ipc$dispatch(r7, r8)
            return
        L31:
            java.lang.String r6 = "itemView"
            tb.b41.i(r12, r6)
            java.lang.String r1 = "activity"
            tb.b41.i(r13, r1)
            java.lang.String r1 = "eventParams"
            tb.b41.i(r14, r1)
            boolean r1 = r13.isFinishing()
            if (r1 != 0) goto Lc6
            if (r4 != 0) goto L4a
            goto Lc6
        L4a:
            tb.ap2 r1 = tb.ap2.INSTANCE
            java.lang.Class<com.alibaba.pictures.bricks.bean.ShopInfoBean> r6 = com.alibaba.pictures.bricks.bean.ShopInfoBean.class
            java.lang.Object r1 = r1.j(r15, r6)
            com.alibaba.pictures.bricks.bean.ShopInfoBean r1 = (com.alibaba.pictures.bricks.bean.ShopInfoBean) r1
            if (r1 == 0) goto Lc6
            com.alibaba.fastjson.JSONObject r3 = r14.getData()
            if (r3 == 0) goto Lc6
            java.lang.String r4 = "eventName"
            java.lang.Object r3 = r3.get(r4)
            if (r3 == 0) goto Lc6
            java.lang.String r4 = "telephones"
            boolean r4 = tb.b41.d(r4, r3)
            if (r4 != 0) goto Laa
            java.lang.String r4 = "telephone"
            boolean r4 = tb.b41.d(r4, r3)
            if (r4 == 0) goto L75
            goto Laa
        L75:
            java.lang.String r4 = "map"
            boolean r3 = tb.b41.d(r4, r3)
            if (r3 == 0) goto Lc6
            java.lang.String r3 = r1.getMapUrl()
            if (r3 == 0) goto L89
            boolean r3 = kotlin.text.g.s(r3)
            if (r3 == 0) goto L8a
        L89:
            r9 = 1
        L8a:
            if (r9 != 0) goto Lc6
            java.lang.String r3 = "UT_APPLY_STORE_ADDR_CLICK"
            r11.h(r3, r10, r5)
            com.alient.oneservice.nav.NavProvider r3 = com.alient.oneservice.nav.NavProviderProxy.getProxy()
            com.alient.oneservice.nav.Action r4 = new com.alient.oneservice.nav.Action
            r4.<init>()
            r4.setActionType(r10)
            java.lang.String r1 = r1.getMapUrl()
            r4.setActionUrl(r1)
            tb.wt2 r1 = tb.wt2.INSTANCE
            r3.toUri(r13, r4)
            goto Lc6
        Laa:
            java.lang.String r3 = "UT_APPLY_STORE_CALL_CLICK"
            r11.h(r3, r9, r5)
            com.alibaba.pictures.bricks.view.BottomActionDialog r8 = new com.alibaba.pictures.bricks.view.BottomActionDialog
            java.util.ArrayList r3 = r1.getCallActionList()
            tb.ec2$a r4 = new tb.ec2$a
            r4.<init>(r13)
            r5 = 0
            r6 = 8
            r7 = 0
            r1 = r8
            r2 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r8.show()
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ec2.e(android.view.View, android.app.Activity, com.youku.gaiax.api.data.EventParams, com.alibaba.fastjson.JSONObject, int, com.alibaba.pictures.bricks.gaiaxholder.GaiaXUtParamsGenerator):void");
    }

    @Override // tb.y0
    public void f(@NotNull View view, @NotNull Activity activity, @Nullable JSONObject jSONObject, int i, @Nullable GaiaXUtParamsGenerator gaiaXUtParamsGenerator) {
        String id;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "281631595")) {
            ipChange.ipc$dispatch("281631595", new Object[]{this, view, activity, jSONObject, Integer.valueOf(i), gaiaXUtParamsGenerator});
            return;
        }
        b41.i(view, "itemView");
        b41.i(activity, "activity");
        ShopInfoBean shopInfoBean = (ShopInfoBean) ap2.INSTANCE.j(jSONObject, ShopInfoBean.class);
        if (shopInfoBean == null || (id = shopInfoBean.getId()) == null) {
            return;
        }
        Action action = new Action();
        action.setActionUrl("damai://V1/ScriptPlay?storeId=" + id);
        action.setActionType(1);
        NavProviderProxy.getProxy().toUri(activity, action);
    }

    @Override // tb.y0
    public void g(@NotNull GaiaX.Params params, @NotNull View view, @NotNull View view2, @NotNull Activity activity, @Nullable JSONObject jSONObject, int i, @Nullable GaiaXUtParamsGenerator gaiaXUtParamsGenerator) {
        View findViewById;
        UtParam generate;
        View findViewById2;
        UtParam generate2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1326405177")) {
            ipChange.ipc$dispatch("-1326405177", new Object[]{this, params, view, view2, activity, jSONObject, Integer.valueOf(i), gaiaXUtParamsGenerator});
            return;
        }
        b41.i(params, "params");
        b41.i(view, "resultView");
        b41.i(view2, "itemView");
        b41.i(activity, "activity");
        try {
            GaiaX.Companion companion = GaiaX.Companion;
            IStable stable = companion.getInstance().stable();
            if (stable != null && (findViewById2 = stable.findViewById(params, "loc_holder")) != null && gaiaXUtParamsGenerator != null && (generate2 = gaiaXUtParamsGenerator.generate(UtType.expose, b(), c(), "UT_APPLY_STORE_ADDR_EXPOSE")) != null) {
                qo1.INSTANCE.d(findViewById2, generate2);
            }
            IStable stable2 = companion.getInstance().stable();
            if (stable2 == null || (findViewById = stable2.findViewById(params, "tele_holder")) == null || gaiaXUtParamsGenerator == null || (generate = gaiaXUtParamsGenerator.generate(UtType.expose, b(), c(), "UT_APPLY_STORE_CALL_EXPOSE")) == null) {
                return;
            }
            qo1.INSTANCE.d(findViewById, generate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
