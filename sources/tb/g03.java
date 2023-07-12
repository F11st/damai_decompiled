package tb;

import android.app.Activity;
import cn.damai.common.app.widget.WantSeeGuideDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.a;
import cn.damai.uikit.util.TDialog;
import cn.damai.wantsee.GuideUtHelper;
import cn.damai.wantsee.GuideUtProvider;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class g03 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final g03 INSTANCE = new g03();

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class a implements WantSeeGuideDialog.Listener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ GuideUtProvider b;

        a(Activity activity, GuideUtProvider guideUtProvider) {
            this.a = activity;
            this.b = guideUtProvider;
        }

        @Override // cn.damai.common.app.widget.WantSeeGuideDialog.Listener
        public void onCloseBtnClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "420408351")) {
                ipChange.ipc$dispatch("420408351", new Object[]{this});
                return;
            }
            GuideUtProvider guideUtProvider = this.b;
            if (guideUtProvider != null) {
                cn.damai.common.user.c.e().x(g03.INSTANCE.c(guideUtProvider.getSpmB(), "pop", "close", guideUtProvider.getGuideCloseBtnArgMap(), false));
            }
        }

        @Override // cn.damai.common.app.widget.WantSeeGuideDialog.Listener
        public void onWantSeeBtnClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2016894356")) {
                ipChange.ipc$dispatch("2016894356", new Object[]{this});
                return;
            }
            DMNav.from(this.a).setTransition(0, 0).toUri(cs.m().d("key_want_see_tips_page_name", "WantedPage"));
            GuideUtProvider guideUtProvider = this.b;
            if (guideUtProvider != null) {
                cn.damai.common.user.c.e().x(g03.INSTANCE.c(guideUtProvider.getSpmB(), "pop", "see", guideUtProvider.getGuideGoMineBtnArgMap(), true));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class b implements WantSeeGuideDialog.Listener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WantSeeGuideDialog.WantGuidePageSource a;
        final /* synthetic */ GuideUtHelper b;
        final /* synthetic */ Activity c;

        b(WantSeeGuideDialog.WantGuidePageSource wantGuidePageSource, GuideUtHelper guideUtHelper, Activity activity) {
            this.a = wantGuidePageSource;
            this.b = guideUtHelper;
            this.c = activity;
        }

        @Override // cn.damai.common.app.widget.WantSeeGuideDialog.Listener
        public void onCloseBtnClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "639263069")) {
                ipChange.ipc$dispatch("639263069", new Object[]{this});
                return;
            }
            GuideUtHelper guideUtHelper = this.b;
            if (guideUtHelper != null) {
                guideUtHelper.cancelUt();
            }
        }

        @Override // cn.damai.common.app.widget.WantSeeGuideDialog.Listener
        public void onWantSeeBtnClick() {
            String schema;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1882880850")) {
                ipChange.ipc$dispatch("1882880850", new Object[]{this});
                return;
            }
            WantSeeGuideDialog.WantGuidePageSource wantGuidePageSource = this.a;
            if (wantGuidePageSource != null && (schema = wantGuidePageSource.schema()) != null) {
                DMNav.from(this.c).toUri(schema);
            }
            GuideUtHelper guideUtHelper = this.b;
            if (guideUtHelper != null) {
                guideUtHelper.confirmUt();
            }
        }
    }

    private g03() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(GuideUtProvider guideUtProvider, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1443205292")) {
            ipChange.ipc$dispatch("1443205292", new Object[]{guideUtProvider, Long.valueOf(j)});
        } else if (guideUtProvider != null) {
            cn.damai.common.user.c.e().C("pop", "pop", guideUtProvider.getSpmB(), "1.0", j, guideUtProvider.getGuideExposeArgMap(), 2201);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(GuideUtHelper guideUtHelper, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885857033")) {
            ipChange.ipc$dispatch("885857033", new Object[]{guideUtHelper, Long.valueOf(j)});
        } else if (guideUtHelper != null) {
            guideUtHelper.exposureUt(j);
        }
    }

    @NotNull
    public final a.b c(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Map<String, String> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-984602842")) {
            return (a.b) ipChange.ipc$dispatch("-984602842", new Object[]{this, str, str2, str3, map, Boolean.valueOf(z)});
        }
        b41.i(str, "spmB");
        b41.i(str2, "spmC");
        b41.i(str3, "spmD");
        a.b e = new cn.damai.common.user.b().e(str, str2, str3, map, Boolean.valueOf(z));
        b41.h(e, "ManageUTHelper().getDama…mC, spmD, args, openPage)");
        return e;
    }

    public final boolean d(@Nullable Activity activity, @Nullable final GuideUtHelper guideUtHelper, @Nullable WantSeeGuideDialog.WantGuidePageSource wantGuidePageSource) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-118686606")) {
            return ((Boolean) ipChange.ipc$dispatch("-118686606", new Object[]{this, activity, guideUtHelper, wantGuidePageSource})).booleanValue();
        }
        if (activity != null && !activity.isFinishing()) {
            String B = z20.B("key_want_see");
            if (B == null || B.length() == 0) {
                z20.T("key_want_see", "key_want_see");
                WantSeeGuideDialog wantSeeGuideDialog = new WantSeeGuideDialog(activity, new b(wantGuidePageSource, guideUtHelper, activity), wantGuidePageSource);
                wantSeeGuideDialog.g(new TDialog.OnDialogShowTimeListener() { // from class: tb.e03
                    @Override // cn.damai.uikit.util.TDialog.OnDialogShowTimeListener
                    public final void exposureTime(long j) {
                        g03.g(GuideUtHelper.this, j);
                    }
                });
                wantSeeGuideDialog.show();
                return true;
            }
        }
        return false;
    }

    public final boolean e(@Nullable Activity activity, @Nullable final GuideUtProvider guideUtProvider) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-916946739")) {
            return ((Boolean) ipChange.ipc$dispatch("-916946739", new Object[]{this, activity, guideUtProvider})).booleanValue();
        }
        if (activity != null && !activity.isFinishing()) {
            String B = z20.B("key_want_see");
            if (B == null || B.length() == 0) {
                z20.T("key_want_see", "key_want_see");
                WantSeeGuideDialog wantSeeGuideDialog = new WantSeeGuideDialog(activity, new a(activity, guideUtProvider));
                wantSeeGuideDialog.g(new TDialog.OnDialogShowTimeListener() { // from class: tb.f03
                    @Override // cn.damai.uikit.util.TDialog.OnDialogShowTimeListener
                    public final void exposureTime(long j) {
                        g03.f(GuideUtProvider.this, j);
                    }
                });
                wantSeeGuideDialog.show();
                return true;
            }
        }
        return false;
    }
}
