package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectItemDataBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.pp2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectItemStatusHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BUY_TYPE_BUY_RIGHT_NOW = 300;
    public static final int BUY_TYPE_CHOOSE_SEAT = 200;
    public static final int BUY_TYPE_SCHEDULE_RIGHT_NOW = 500;
    public static final int ON_SALE_REGISTER = 600;
    public static final int OUT_OF_STORE_REGISTER = 601;
    private View a;
    private TextView b;
    private TextView c;
    private ProjectItemDataBean d;
    private String e;
    private boolean f;
    private OnBottomViewClickListener g;
    private OnBuyBtnUTListener h;
    private OnProjectNotExistsListener i;
    private boolean j = false;
    private boolean k = true;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnBottomViewClickListener {
        void onBuyRightNow(int i);

        void onNeedPrivilege(int i);

        void onRegister(int i);

        void onSelectSeat();

        void onSoldOut();

        void onTimingCountDown();
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnBuyBtnUTListener {
        void onReportBuyRightNow(boolean z, int i);

        void onReportFollowRemind();

        void onReportPrivilege(int i);

        void onReportRegisterRemind(int i);

        void onReportSelectSeat();
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnProjectNotExistsListener {
        void onProjectNotExists();
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class a implements OnBuyBtnUTListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private long a;

        private a(long j) {
            this.a = j;
        }

        public static OnBuyBtnUTListener a(long j) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1772466206") ? (OnBuyBtnUTListener) ipChange.ipc$dispatch("1772466206", new Object[]{Long.valueOf(j)}) : new a(j);
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBuyBtnUTListener
        public void onReportBuyRightNow(boolean z, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1591450016")) {
                ipChange.ipc$dispatch("-1591450016", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i)});
            } else if (i == 300) {
                if (z) {
                    cn.damai.common.user.c.e().x(pp2.u().K0(this.a));
                } else {
                    cn.damai.common.user.c.e().x(pp2.u().j0(this.a));
                }
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBuyBtnUTListener
        public void onReportFollowRemind() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1815086365")) {
                ipChange.ipc$dispatch("-1815086365", new Object[]{this});
            } else {
                cn.damai.common.user.c.e().x(pp2.u().M0(this.a));
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBuyBtnUTListener
        public void onReportPrivilege(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1385587549")) {
                ipChange.ipc$dispatch("-1385587549", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 300) {
                cn.damai.common.user.c.e().x(pp2.u().H0(this.a));
            } else if (i == 200) {
                cn.damai.common.user.c.e().x(pp2.u().J0(this.a));
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBuyBtnUTListener
        public void onReportRegisterRemind(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1765023246")) {
                ipChange.ipc$dispatch("-1765023246", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 600) {
                cn.damai.common.user.c.e().x(pp2.u().z0(String.valueOf(this.a), "bottom", "onsale_checkin"));
            } else if (i == 601) {
                cn.damai.common.user.c.e().x(pp2.u().z0(String.valueOf(this.a), "bottom", "stock_checkin"));
            } else if (i == 500) {
                cn.damai.common.user.c.e().x(pp2.u().z0(String.valueOf(this.a), "bottom", "rightawayreserve"));
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.ProjectItemStatusHelper.OnBuyBtnUTListener
        public void onReportSelectSeat() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1535540488")) {
                ipChange.ipc$dispatch("-1535540488", new Object[]{this});
            } else {
                cn.damai.common.user.c.e().x(pp2.u().h(this.a));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;

        public b(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1444917046")) {
                ipChange.ipc$dispatch("-1444917046", new Object[]{this, view});
            } else if (ProjectItemStatusHelper.this.g != null) {
                if (ProjectItemStatusHelper.this.h != null && !ProjectItemStatusHelper.this.f) {
                    ProjectItemStatusHelper.this.h.onReportBuyRightNow(ProjectItemStatusHelper.this.k(), this.a);
                }
                ProjectItemStatusHelper.this.g.onBuyRightNow(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;

        public c(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-995278910")) {
                ipChange.ipc$dispatch("-995278910", new Object[]{this, view});
            } else if (ProjectItemStatusHelper.this.g != null) {
                if (ProjectItemStatusHelper.this.h != null && !ProjectItemStatusHelper.this.f) {
                    ProjectItemStatusHelper.this.h.onReportPrivilege(this.a);
                }
                ProjectItemStatusHelper.this.g.onNeedPrivilege(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;

        public d(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1677752043")) {
                ipChange.ipc$dispatch("-1677752043", new Object[]{this, view});
            } else if (ProjectItemStatusHelper.this.g != null) {
                if (ProjectItemStatusHelper.this.h != null && !ProjectItemStatusHelper.this.f) {
                    ProjectItemStatusHelper.this.h.onReportRegisterRemind(this.a);
                }
                ProjectItemStatusHelper.this.g.onRegister(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1470717943")) {
                ipChange.ipc$dispatch("1470717943", new Object[]{this, view});
            } else if (ProjectItemStatusHelper.this.g != null) {
                if (ProjectItemStatusHelper.this.h != null && !ProjectItemStatusHelper.this.f) {
                    ProjectItemStatusHelper.this.h.onReportSelectSeat();
                }
                ProjectItemStatusHelper.this.g.onSelectSeat();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-282979179")) {
                ipChange.ipc$dispatch("-282979179", new Object[]{this, view});
            } else if (ProjectItemStatusHelper.this.g != null) {
                ProjectItemStatusHelper.this.g.onSoldOut();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private boolean a;

        public g(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "251246059")) {
                ipChange.ipc$dispatch("251246059", new Object[]{this, view});
            } else if (ProjectItemStatusHelper.this.g != null) {
                if (this.a && ProjectItemStatusHelper.this.h != null) {
                    ProjectItemStatusHelper.this.h.onReportFollowRemind();
                }
                ProjectItemStatusHelper.this.g.onTimingCountDown();
            }
        }
    }

    public ProjectItemStatusHelper(Context context, ProjectItemDataBean projectItemDataBean, long j, ViewGroup viewGroup) {
        this.d = projectItemDataBean;
        this.e = String.valueOf(j);
        i(context, viewGroup);
        m();
    }

    private void d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "996102355")) {
            ipChange.ipc$dispatch("996102355", new Object[]{this, str});
            return;
        }
        q(str, false);
        String buyBtnTip = this.d.getBuyBtnTip();
        if (!TextUtils.isEmpty(buyBtnTip)) {
            this.c.setVisibility(0);
            this.c.setText(buyBtnTip);
            return;
        }
        this.c.setVisibility(8);
    }

    private void e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1972521202")) {
            ipChange.ipc$dispatch("1972521202", new Object[]{this, str});
            return;
        }
        q(str, true);
        String buyBtnTip = this.d.getBuyBtnTip();
        if (!TextUtils.isEmpty(buyBtnTip)) {
            this.c.setVisibility(0);
            this.c.setText(buyBtnTip);
            return;
        }
        this.c.setVisibility(8);
    }

    private int f(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1192669210")) {
            return ((Integer) ipChange.ipc$dispatch("1192669210", new Object[]{this, Boolean.valueOf(z)})).intValue();
        }
        if (z) {
            return R$drawable.project_buy_btn_usable_bg_selector;
        }
        return R$drawable.project_buy_btn_unusable_bg;
    }

    private String g(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-343410802") ? (String) ipChange.ipc$dispatch("-343410802", new Object[]{this, str, str2}) : TextUtils.isEmpty(str) ? str2 : str;
    }

    private View i(Context context, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "370156452")) {
            return (View) ipChange.ipc$dispatch("370156452", new Object[]{this, context, viewGroup});
        }
        View inflate = LayoutInflater.from(context).inflate(R$layout.project_item_buy_btn_status_view, viewGroup, false);
        this.a = inflate;
        this.b = (TextView) inflate.findViewById(R$id.tv_left_main_text);
        this.c = (TextView) this.a.findViewById(R$id.tv_left_sub_text);
        this.a.setVisibility(8);
        return this.a;
    }

    private void m() {
        String str;
        String str2;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1636362060")) {
            ipChange.ipc$dispatch("1636362060", new Object[]{this});
            return;
        }
        ProjectItemDataBean projectItemDataBean = this.d;
        if (projectItemDataBean != null) {
            i = projectItemDataBean.getBuyBtnStatus();
            str = this.d.getBuyBtnText();
            str2 = this.d.getBuyBtnTip();
        } else {
            str = "";
            str2 = str;
            i = 99;
        }
        this.a.setOnClickListener(null);
        if (i == 87) {
            d(g(str, "选座购买"));
        } else if (i == 88) {
            d(g(str, "立即购买"));
            pp2.u().n2(this.b, this.e);
        } else if (i == 99) {
            p(str, "暂不可售", str2, false, null);
        } else if (i == 100) {
            p(str, "该渠道不支持购买", str2, false, null);
        } else if (i == 106) {
            p(str, "即将开售", str2, true, new g(false));
        } else if (i == 204) {
            this.a.setOnClickListener(new b(300));
            q(g(str, "立即购买"), true);
            pp2.u().G1(this.b, this.e);
        } else if (i == 206) {
            this.a.setOnClickListener(new e());
            q(g(str, "选座购买"), true);
            pp2.u().g2(this.b, this.e);
        } else if (i == 401) {
            this.k = false;
            n();
        } else if (i == 216) {
            this.j = true;
            this.a.setOnClickListener(new b(300));
            e(g(str, "立即购买"));
        } else if (i == 217) {
            this.j = true;
            this.a.setOnClickListener(new e());
            e(g(str, "选座购买"));
        } else if (i == 223) {
            d(g(str, "立即购买"));
        } else if (i == 224) {
            d(g(str, "选座购买"));
        } else if (i == 230) {
            this.a.setOnClickListener(new c(300));
            e(g(str, "立即购买"));
        } else if (i == 231) {
            this.a.setOnClickListener(new c(200));
            e(g(str, "选座购买"));
        } else if (i == 303) {
            p(str, "已下架", str2, false, null);
        } else if (i != 304) {
            switch (i) {
                case 90:
                    p(str, "开售登记", str2, true, new d(600));
                    pp2.u().K1(this.b, this.e);
                    return;
                case 91:
                    p(str, "缺货登记", str2, true, new d(601));
                    pp2.u().k2(this.b, this.e);
                    return;
                case 92:
                    p(str, "售罄", str2, false, new f());
                    return;
                default:
                    p(str, "暂不可售", str2, false, null);
                    return;
            }
        } else {
            p(str, "已取消", str2, false, null);
        }
    }

    private void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1662873207")) {
            ipChange.ipc$dispatch("-1662873207", new Object[]{this});
            return;
        }
        OnProjectNotExistsListener onProjectNotExistsListener = this.i;
        if (onProjectNotExistsListener != null) {
            onProjectNotExistsListener.onProjectNotExists();
        }
    }

    private void p(String str, String str2, String str3, boolean z, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "192090434")) {
            ipChange.ipc$dispatch("192090434", new Object[]{this, str, str2, str3, Boolean.valueOf(z), onClickListener});
            return;
        }
        this.a.setVisibility(0);
        this.a.setBackgroundResource(f(z));
        this.a.setOnClickListener(onClickListener);
        this.a.setClickable(onClickListener != null);
        this.b.setText(g(str, str2));
        if (!TextUtils.isEmpty(str3)) {
            this.c.setText(str3);
            this.c.setVisibility(0);
            return;
        }
        this.c.setText("");
        this.c.setVisibility(8);
    }

    private void q(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1358674885")) {
            ipChange.ipc$dispatch("1358674885", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        this.b.setText(str);
        this.c.setVisibility(8);
        this.a.setVisibility(0);
        this.a.setBackgroundResource(f(z));
        this.a.setClickable(z);
    }

    public View h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1429941925") ? (View) ipChange.ipc$dispatch("-1429941925", new Object[]{this}) : this.a;
    }

    public boolean j(ProjectItemDataBean projectItemDataBean) {
        int buyBtnStatus;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1343219194") ? ((Boolean) ipChange.ipc$dispatch("-1343219194", new Object[]{this, projectItemDataBean})).booleanValue() : (projectItemDataBean == null || (buyBtnStatus = projectItemDataBean.getBuyBtnStatus()) == 90 || buyBtnStatus == 91 || buyBtnStatus == 106 || buyBtnStatus == 204 || buyBtnStatus == 206 || buyBtnStatus == 216 || buyBtnStatus == 217 || buyBtnStatus == 230 || buyBtnStatus == 231) ? false : true;
    }

    public boolean k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "241895126") ? ((Boolean) ipChange.ipc$dispatch("241895126", new Object[]{this})).booleanValue() : this.j;
    }

    public boolean l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2072398518") ? ((Boolean) ipChange.ipc$dispatch("-2072398518", new Object[]{this})).booleanValue() : this.k;
    }

    public void o(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601618948")) {
            ipChange.ipc$dispatch("1601618948", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.f = z;
        }
    }

    public void r(OnBottomViewClickListener onBottomViewClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1613304666")) {
            ipChange.ipc$dispatch("1613304666", new Object[]{this, onBottomViewClickListener});
        } else {
            this.g = onBottomViewClickListener;
        }
    }

    public void s(OnBuyBtnUTListener onBuyBtnUTListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1062279558")) {
            ipChange.ipc$dispatch("1062279558", new Object[]{this, onBuyBtnUTListener});
        } else {
            this.h = onBuyBtnUTListener;
        }
    }

    public void t(OnProjectNotExistsListener onProjectNotExistsListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1438324228")) {
            ipChange.ipc$dispatch("1438324228", new Object[]{this, onProjectNotExistsListener});
        } else {
            this.i = onProjectNotExistsListener;
        }
    }

    public void u(ProjectItemDataBean projectItemDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "783861310")) {
            ipChange.ipc$dispatch("783861310", new Object[]{this, projectItemDataBean});
            return;
        }
        this.j = false;
        this.k = true;
        this.d = projectItemDataBean;
        m();
    }
}
