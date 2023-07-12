package tb;

import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.app.widget.WantSeeGuideDialog;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.homepage.util.window.bean.WantSeeActionBean;
import cn.damai.rank.view.WantSeePosterTips;
import cn.damai.rank.view.WantSeeTips;
import cn.damai.wantsee.GuideUtHelper;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.popupcenter.ut.UTHelperPopupCallback;
import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class b03 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: tb.b03$a */
    /* loaded from: classes5.dex */
    public static final class C8942a implements GuideUtHelper {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ws2 a;
        final /* synthetic */ b03 b;
        final /* synthetic */ String c;
        final /* synthetic */ Map<String, JSONObject> d;

        /* JADX WARN: Multi-variable type inference failed */
        C8942a(ws2 ws2Var, b03 b03Var, String str, Map<String, ? extends JSONObject> map) {
            this.a = ws2Var;
            this.b = b03Var;
            this.c = str;
            this.d = map;
        }

        @Override // cn.damai.wantsee.GuideUtHelper
        public void cancelUt() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "244077597")) {
                ipChange.ipc$dispatch("244077597", new Object[]{this});
            } else {
                UTHelperPopupCallback.C4028a.a(this.a, this.b.b(this.c), this.d, false, 4, null);
            }
        }

        @Override // cn.damai.wantsee.GuideUtHelper
        public void confirmUt() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1466346571")) {
                ipChange.ipc$dispatch("-1466346571", new Object[]{this});
            } else {
                this.a.confirmUt(this.b.b(this.c), this.d, true);
            }
        }

        @Override // cn.damai.wantsee.GuideUtHelper
        public void exposureUt(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-971699372")) {
                ipChange.ipc$dispatch("-971699372", new Object[]{this, Long.valueOf(j)});
            } else {
                UTHelperPopupCallback.C4028a.b(this.a, j, this.b.b(this.c), this.d, false, 8, null);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.b03$b */
    /* loaded from: classes5.dex */
    public static final class C8943b implements WantSeeGuideDialog.WantGuidePageSource {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WantSeeActionBean a;

        C8943b(WantSeeActionBean wantSeeActionBean) {
            this.a = wantSeeActionBean;
        }

        @Override // cn.damai.common.app.widget.WantSeeGuideDialog.WantGuidePageSource
        @NotNull
        public String getButtonName() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "372219360")) {
                return (String) ipChange.ipc$dispatch("372219360", new Object[]{this});
            }
            WantSeeActionBean wantSeeActionBean = this.a;
            if (wantSeeActionBean != null) {
                String str = wantSeeActionBean.buttonName;
                b41.h(str, "it.buttonName");
                return str;
            }
            return "";
        }

        @Override // cn.damai.common.app.widget.WantSeeGuideDialog.WantGuidePageSource
        @NotNull
        public String getSubTitle() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "758955899")) {
                return (String) ipChange.ipc$dispatch("758955899", new Object[]{this});
            }
            WantSeeActionBean wantSeeActionBean = this.a;
            if (wantSeeActionBean != null) {
                String str = wantSeeActionBean.subTitleOpenNotify;
                b41.h(str, "it.subTitleOpenNotify");
                return str;
            }
            return "";
        }

        @Override // cn.damai.common.app.widget.WantSeeGuideDialog.WantGuidePageSource
        @NotNull
        public String getTitle() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-561826453")) {
                return (String) ipChange.ipc$dispatch("-561826453", new Object[]{this});
            }
            WantSeeActionBean wantSeeActionBean = this.a;
            if (wantSeeActionBean != null) {
                String str = wantSeeActionBean.title;
                b41.h(str, "it.title");
                return str;
            }
            return "";
        }

        @Override // cn.damai.common.app.widget.WantSeeGuideDialog.WantGuidePageSource
        @NotNull
        public String lottieUrl() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2008453411")) {
                return (String) ipChange.ipc$dispatch("-2008453411", new Object[]{this});
            }
            WantSeeActionBean wantSeeActionBean = this.a;
            if (wantSeeActionBean != null) {
                String str = wantSeeActionBean.lottie;
                b41.h(str, "it.lottie");
                return str;
            }
            return "";
        }

        @Override // cn.damai.common.app.widget.WantSeeGuideDialog.WantGuidePageSource
        @NotNull
        public String schema() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1606227050")) {
                return (String) ipChange.ipc$dispatch("1606227050", new Object[]{this});
            }
            WantSeeActionBean wantSeeActionBean = this.a;
            if (wantSeeActionBean != null) {
                String str = wantSeeActionBean.jumpUrl;
                b41.h(str, "it.jumpUrl");
                return str;
            }
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, String> b(String str) {
        boolean s;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "36635627")) {
            return (HashMap) ipChange.ipc$dispatch("36635627", new Object[]{this, str});
        }
        HashMap<String, String> f = d23.f();
        if (str != null) {
            s = C8604o.s(str);
            if (!s) {
                z = false;
            }
        }
        if (!z) {
            b41.h(f, "map");
            f.put("item_id", str);
        }
        return f;
    }

    public final boolean c(@NotNull BaseActivity<?, ?> baseActivity, @NotNull String str, @NotNull WantSeeTips wantSeeTips, @NotNull WantSeePosterTips wantSeePosterTips) {
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-153885446")) {
            return ((Boolean) ipChange.ipc$dispatch("-153885446", new Object[]{this, baseActivity, str, wantSeeTips, wantSeePosterTips})).booleanValue();
        }
        b41.i(baseActivity, "activity");
        b41.i(str, "id");
        b41.i(wantSeeTips, "wantSeeTips");
        b41.i(wantSeePosterTips, "wantSeeProjectTips");
        ArrayList m = lt1.m(lt1.Companion.a(), baseActivity, null, null, 6, null);
        ws2 ws2Var = new ws2(baseActivity);
        if (m != null && m.size() > 0) {
            Iterator it = m.iterator();
            PopupDetailBean popupDetailBean = null;
            PopupDetailBean popupDetailBean2 = null;
            while (it.hasNext()) {
                PopupDetailBean popupDetailBean3 = (PopupDetailBean) it.next();
                if (b41.d("wantSeeFirst", popupDetailBean3.eventType)) {
                    popupDetailBean = popupDetailBean3;
                } else if (b41.d("wantSeeNonFirst", popupDetailBean3.eventType)) {
                    popupDetailBean2 = popupDetailBean3;
                }
                if (popupDetailBean != null && popupDetailBean2 != null) {
                    break;
                }
            }
            if (popupDetailBean != null && popupDetailBean2 != null) {
                PopupDetailBean.PopupItem popupItem = popupDetailBean.item;
                WantSeeActionBean wantSeeActionBean = (WantSeeActionBean) m61.d(popupItem != null ? popupItem.value : null, WantSeeActionBean.class);
                PopupDetailBean.PopupItem popupItem2 = popupDetailBean2.item;
                WantSeeActionBean wantSeeActionBean2 = (WantSeeActionBean) m61.d(popupItem2 != null ? popupItem2.value : null, WantSeeActionBean.class);
                PopupDetailBean.PopupItem popupItem3 = popupDetailBean.item;
                Object obj = (popupItem3 == null || (jSONObject = popupItem3.value) == null) ? null : jSONObject.get("action");
                if (!g03.INSTANCE.d(baseActivity, new C8942a(ws2Var, this, str, obj instanceof Map ? obj : null), new C8943b(wantSeeActionBean)) && wantSeePosterTips.getVisibility() == 8) {
                    if (wantSeeActionBean2 != null) {
                        WantSeeTips.AbstractC1562a.C1564b c1564b = WantSeeTips.AbstractC1562a.C1564b.INSTANCE;
                        c1564b.p(wantSeeActionBean2.title);
                        c1564b.o(PermissionsHelper.a(AppInfoProviderProxy.getAppContext()) ? wantSeeActionBean2.subTitleOpenNotify : wantSeeActionBean2.subTitleUnOpenNotify);
                        c1564b.m(wantSeeActionBean2.lottie);
                        c1564b.n(wantSeeActionBean2.jumpUrl);
                    }
                    wantSeeTips.setPageSource(WantSeeTips.AbstractC1562a.C1564b.INSTANCE);
                    wantSeeTips.showAnim();
                }
                return true;
            }
        }
        return false;
    }
}
