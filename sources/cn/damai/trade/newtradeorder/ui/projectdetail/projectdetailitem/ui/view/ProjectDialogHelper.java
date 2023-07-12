package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.contacts.bean.IdCardTypes;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.login.LoginManager;
import cn.damai.trade.R$color;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectInformationBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticItemBaseBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.RealNameBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.ProjectDialogShowListener;
import cn.damai.uikit.view.DMThemeDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import tb.cs;
import tb.gb;
import tb.m61;
import tb.pp2;
import tb.yb;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectDialogHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private View b;
    private ProjectDialogListener c;
    private String d;
    private ProjectStaticDataBean e;
    private Map<String, String> f = new HashMap();
    private String g;
    private ProjectDialogShowListener h;
    private ProjectDialog i;
    private DMThemeDialog j;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface ProjectDialogListener {
        void excuteNATRequest(String str);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectDialogHelper$a */
    /* loaded from: classes16.dex */
    public class DialogInterface$OnClickListenerC2347a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        DialogInterface$OnClickListenerC2347a(String str) {
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1187658491")) {
                ipChange.ipc$dispatch("1187658491", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                ProjectDialogHelper.this.p(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectDialogHelper$b */
    /* loaded from: classes16.dex */
    public class DialogInterface$OnKeyListenerC2348b implements DialogInterface.OnKeyListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnKeyListenerC2348b() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1817178877")) {
                return ((Boolean) ipChange.ipc$dispatch("1817178877", new Object[]{this, dialogInterface, Integer.valueOf(i), keyEvent})).booleanValue();
            }
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                ProjectDialogHelper.this.a.finish();
                return true;
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectDialogHelper$c */
    /* loaded from: classes16.dex */
    public class DialogInterface$OnClickListenerC2349c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ long a;

        DialogInterface$OnClickListenerC2349c(long j) {
            this.a = j;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1168146759")) {
                ipChange.ipc$dispatch("-1168146759", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            ProjectDialogHelper.this.i();
            if (ProjectDialogHelper.this.e != null && ProjectDialogHelper.this.e.itemBase != null) {
                ProjectDialogHelper projectDialogHelper = ProjectDialogHelper.this;
                projectDialogHelper.k(this.a, projectDialogHelper.d);
                C0529c.e().x(pp2.u().W0(ProjectDialogHelper.this.d, "known_btn", false));
            }
            ProjectDialogHelper.this.j.dismiss();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectDialogHelper$d */
    /* loaded from: classes16.dex */
    public class DialogInterface$OnClickListenerC2350d implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ long a;

        DialogInterface$OnClickListenerC2350d(long j) {
            this.a = j;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-198565736")) {
                ipChange.ipc$dispatch("-198565736", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else if (ProjectDialogHelper.this.a == null || ProjectDialogHelper.this.a.isFinishing()) {
            } else {
                if (ProjectDialogHelper.this.e != null && ProjectDialogHelper.this.e.itemBase != null) {
                    ProjectDialogHelper projectDialogHelper = ProjectDialogHelper.this;
                    projectDialogHelper.k(this.a, projectDialogHelper.d);
                    C0529c.e().x(pp2.u().W0(ProjectDialogHelper.this.d, "fill_btn", false));
                }
                if (LoginManager.k().q()) {
                    ArrayList<IdCardTypes> b = yb.b(ProjectDialogHelper.this.e);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("contacts", b);
                    bundle.putString("bundleName", GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL);
                    bundle.putString("showtip", "true");
                    DMNav.from(ProjectDialogHelper.this.a).forResult(4121).withExtras(bundle).toUri(NavUri.b(cs.R));
                    return;
                }
                LoginManager.k().v(ProjectDialogHelper.this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectDialogHelper$e */
    /* loaded from: classes16.dex */
    public class C2351e implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2351e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1609352833")) {
                ipChange.ipc$dispatch("-1609352833", new Object[]{this, valueAnimator});
            } else {
                ProjectDialogHelper.this.b.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    public ProjectDialogHelper(Activity activity, View view, ProjectDialogListener projectDialogListener) {
        this.a = activity;
        this.b = view;
        this.c = projectDialogListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "505501783")) {
            ipChange.ipc$dispatch("505501783", new Object[]{this});
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 11) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(Color.parseColor("#FFF0E2")), Integer.valueOf(this.a.getResources().getColor(R$color.white)));
            if (i >= 11) {
                ofObject.setDuration(500L);
            }
            ofObject.setRepeatCount(3);
            ofObject.addUpdateListener(new C2351e());
            ofObject.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995668528")) {
            ipChange.ipc$dispatch("1995668528", new Object[]{this, Long.valueOf(j), str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        C0529c.e().C("fill_btn", AgooConstants.MESSAGE_POPUP, gb.PROJECT_PAGE, "1.0", System.currentTimeMillis() - j, hashMap, 2201);
    }

    private String l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-770046516")) {
            return (String) ipChange.ipc$dispatch("-770046516", new Object[]{this});
        }
        String y = z20.y();
        if (!TextUtils.isEmpty(y)) {
            this.f = (Map) m61.a(y, Map.class);
        }
        Map<String, String> map = this.f;
        return (map == null || !map.containsKey(this.d)) ? "" : this.f.get(this.d);
    }

    private boolean n() {
        RealNameBean realNameBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1669711534")) {
            return ((Boolean) ipChange.ipc$dispatch("-1669711534", new Object[]{this})).booleanValue();
        }
        ProjectStaticDataBean projectStaticDataBean = this.e;
        return (projectStaticDataBean == null || (realNameBean = projectStaticDataBean.realName) == null || realNameBean.getRealNamePopup() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1422600586")) {
            ipChange.ipc$dispatch("1422600586", new Object[]{this, str});
        } else if (this.i.isScrollBottom()) {
            v(str);
            this.i.dismiss();
            s();
        }
    }

    private void v(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445058449")) {
            ipChange.ipc$dispatch("-1445058449", new Object[]{this, str});
            return;
        }
        if (this.f == null) {
            this.f = new HashMap();
        }
        this.f.put(this.d, str);
        z20.t0(m61.e(this.f));
    }

    private void w() {
        ProjectStaticItemBaseBean projectStaticItemBaseBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "344211113")) {
            ipChange.ipc$dispatch("344211113", new Object[]{this});
            return;
        }
        ProjectStaticDataBean projectStaticDataBean = this.e;
        if (projectStaticDataBean == null || (projectStaticItemBaseBean = projectStaticDataBean.itemBase) == null) {
            return;
        }
        this.d = String.valueOf(projectStaticItemBaseBean.itemId);
    }

    public void j(ProjectStaticDataBean projectStaticDataBean, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1726964473")) {
            ipChange.ipc$dispatch("1726964473", new Object[]{this, projectStaticDataBean, Long.valueOf(j)});
        } else if (projectStaticDataBean == null) {
        } else {
            this.e = projectStaticDataBean;
            this.d = String.valueOf(j);
            w();
            this.g = l();
            if (!m()) {
                s();
            } else {
                this.c.excuteNATRequest(this.d);
            }
        }
    }

    public boolean m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-442429768")) {
            return ((Boolean) ipChange.ipc$dispatch("-442429768", new Object[]{this})).booleanValue();
        }
        ProjectStaticDataBean projectStaticDataBean = this.e;
        if (projectStaticDataBean == null || projectStaticDataBean.getItemBase() == null) {
            return false;
        }
        return this.e.getItemBase().isProjectNATType();
    }

    public boolean o() {
        RealNameBean realNameBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "891349844")) {
            return ((Boolean) ipChange.ipc$dispatch("891349844", new Object[]{this})).booleanValue();
        }
        ProjectStaticDataBean projectStaticDataBean = this.e;
        return (projectStaticDataBean == null || (realNameBean = projectStaticDataBean.realName) == null || !realNameBean.isRealName()) ? false : true;
    }

    public void q(ProjectInformationBean projectInformationBean) {
        Spanned fromHtml;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-747041408")) {
            ipChange.ipc$dispatch("-747041408", new Object[]{this, projectInformationBean});
            return;
        }
        Activity activity = this.a;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        ProjectDialog projectDialog = this.i;
        if (projectDialog == null || !projectDialog.isShowing()) {
            if (!TextUtils.isEmpty(projectInformationBean.content) && !TextUtils.isEmpty(projectInformationBean.title)) {
                String str = projectInformationBean.content;
                if (!str.equals(this.g)) {
                    ProjectDialog projectDialog2 = new ProjectDialog(this.a);
                    this.i = projectDialog2;
                    projectDialog2.setDMThemeDialogTitle(projectInformationBean.title);
                    if (Build.VERSION.SDK_INT >= 24) {
                        fromHtml = Html.fromHtml(str, 0);
                    } else {
                        fromHtml = Html.fromHtml(str);
                    }
                    this.i.setDMThemeDialogContent(fromHtml);
                    this.i.setDMThemeDialogConfirmButton("确认并知悉", new DialogInterface$OnClickListenerC2347a(str));
                    this.i.setOnKeyListener(new DialogInterface$OnKeyListenerC2348b());
                    this.i.setDMThemeDialogCancelable(false);
                    this.i.show();
                    ProjectDialogShowListener projectDialogShowListener = this.h;
                    if (projectDialogShowListener != null) {
                        projectDialogShowListener.dialogShowBack();
                        return;
                    }
                    return;
                }
                s();
                return;
            }
            s();
        }
    }

    public boolean r() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-73966419")) {
            return ((Boolean) ipChange.ipc$dispatch("-73966419", new Object[]{this})).booleanValue();
        }
        ProjectDialog projectDialog = this.i;
        return projectDialog != null && projectDialog.isShowing();
    }

    public void s() {
        Spanned fromHtml;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1083075675")) {
            ipChange.ipc$dispatch("-1083075675", new Object[]{this});
            return;
        }
        Activity activity = this.a;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        DMThemeDialog dMThemeDialog = this.j;
        if ((dMThemeDialog == null || !dMThemeDialog.isShowing()) && n()) {
            RealNameBean.RealNamePopup realNamePopup = this.e.realName.getRealNamePopup();
            long currentTimeMillis = System.currentTimeMillis();
            DMThemeDialog dMThemeDialog2 = new DMThemeDialog(this.a);
            this.j = dMThemeDialog2;
            dMThemeDialog2.r(DMThemeDialog.DMDialogTheme.THEME_REAL_NAME);
            if (!TextUtils.isEmpty(realNamePopup.getDesc())) {
                if (Build.VERSION.SDK_INT >= 24) {
                    fromHtml = Html.fromHtml(realNamePopup.getDesc(), 0);
                } else {
                    fromHtml = Html.fromHtml(realNamePopup.getDesc());
                }
                this.j.k(fromHtml);
            }
            if (!TextUtils.isEmpty(realNamePopup.getTitle())) {
                this.j.o(realNamePopup.getTitle());
            }
            this.j.e("知道了", new DialogInterface$OnClickListenerC2349c(currentTimeMillis));
            this.j.i("预填实名观演人", new DialogInterface$OnClickListenerC2350d(currentTimeMillis));
            this.j.f(false);
            this.j.show();
            ProjectDialogShowListener projectDialogShowListener = this.h;
            if (projectDialogShowListener != null) {
                projectDialogShowListener.dialogShowBack();
            }
        }
    }

    public boolean t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1731429422")) {
            return ((Boolean) ipChange.ipc$dispatch("1731429422", new Object[]{this})).booleanValue();
        }
        DMThemeDialog dMThemeDialog = this.j;
        return dMThemeDialog != null && dMThemeDialog.isShowing();
    }

    public void u(ProjectDialogShowListener projectDialogShowListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-117528595")) {
            ipChange.ipc$dispatch("-117528595", new Object[]{this, projectDialogShowListener});
        } else {
            this.h = projectDialogShowListener;
        }
    }
}
