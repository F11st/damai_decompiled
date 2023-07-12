package tb;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.im.AliMeUtil;
import cn.damai.login.LoginManager;
import cn.damai.mine.activity.CustomersActivity;
import cn.damai.mine.bean.UserCenterDynamicMenu;
import cn.damai.mine.userinfo.help.MineUserCenterBadeListener;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.ali.user.mobile.rpc.ApiConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class zf1 implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private View b;
    private MineUserCenterBadeListener c;
    private LinearLayout d;
    private LinearLayout e;
    private RelativeLayout f;
    private TextView g;
    private FrameLayout h;
    private RelativeLayout i;
    private TextView j;
    private FrameLayout k;
    private FlowLayout l;
    private View m;
    private TextView n;
    private DMIconFontTextView o;
    private UserCenterDynamicMenu p;
    private boolean q = true;
    private View.OnClickListener r = new View$OnClickListenerC10021a();

    /* compiled from: Taobao */
    /* renamed from: tb.zf1$a */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC10021a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC10021a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1461630806")) {
                ipChange.ipc$dispatch("-1461630806", new Object[]{this, view});
            } else if (zf1.this.a == null || zf1.this.a.isFinishing() || !(view.getTag() instanceof UserCenterDynamicMenu.DynamicMenuItem)) {
            } else {
                UserCenterDynamicMenu.DynamicMenuItem dynamicMenuItem = (UserCenterDynamicMenu.DynamicMenuItem) view.getTag();
                zf1.this.o(dynamicMenuItem);
                if (dynamicMenuItem != null) {
                    if (!zf1.this.n(dynamicMenuItem.getTitle())) {
                        String targetUrl = dynamicMenuItem.getTargetUrl();
                        if (TextUtils.isEmpty(targetUrl)) {
                            return;
                        }
                        DMNav.from(zf1.this.a).toUri(targetUrl);
                    } else if (LoginManager.k().q()) {
                        AliMeUtil.k(zf1.this.a, AliMeUtil.FROM_MINE);
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putInt("from", 1);
                        DMNav.from(zf1.this.a).withExtras(bundle).toUri(cs.f());
                    }
                }
            }
        }
    }

    public zf1(Activity activity, View view) {
        this.a = activity;
        this.b = view.findViewById(R$id.ll_mine_service_container);
        k();
        j();
    }

    private void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883431112")) {
            ipChange.ipc$dispatch("883431112", new Object[]{this});
            return;
        }
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.b.findViewById(R$id.ll_mine_common_orderlist).setOnClickListener(this);
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "369912503")) {
            ipChange.ipc$dispatch("369912503", new Object[]{this});
            return;
        }
        this.d = (LinearLayout) this.b.findViewById(R$id.ll_mine_common_purchase);
        this.e = (LinearLayout) this.b.findViewById(R$id.ll_mine_user_center_address);
        this.f = (RelativeLayout) this.b.findViewById(R$id.ll_mine_evaluate);
        this.g = (TextView) this.b.findViewById(R$id.tv_mine_evaluated_count);
        FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R$id.fl_mine_evaluated_badge);
        this.h = frameLayout;
        frameLayout.setVisibility(8);
        this.i = (RelativeLayout) this.b.findViewById(R$id.ll_mine_coupon);
        this.j = (TextView) this.b.findViewById(R$id.tv_mine_coupon_count);
        FrameLayout frameLayout2 = (FrameLayout) this.b.findViewById(R$id.fl_mine_coupon_badge);
        this.k = frameLayout2;
        frameLayout2.setVisibility(8);
        FlowLayout flowLayout = (FlowLayout) this.b.findViewById(R$id.fl_dynamic_menu_layout_container);
        this.l = flowLayout;
        flowLayout.setVisibility(8);
        this.m = this.b.findViewById(R$id.ll_extend_state);
        this.n = (TextView) this.b.findViewById(R$id.tv_extend_state);
        this.o = (DMIconFontTextView) this.b.findViewById(R$id.tv_extend_arrow);
        this.m.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-907710418") ? ((Boolean) ipChange.ipc$dispatch("-907710418", new Object[]{this, str})).booleanValue() : !TextUtils.isEmpty(str) && str.contains("客服");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(UserCenterDynamicMenu.DynamicMenuItem dynamicMenuItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-776485660")) {
            ipChange.ipc$dispatch("-776485660", new Object[]{this, dynamicMenuItem});
        } else if (dynamicMenuItem == null || this.p == null) {
        } else {
            String targetUrl = dynamicMenuItem.getTargetUrl();
            try {
                Uri parse = Uri.parse(targetUrl);
                if (parse != null) {
                    String queryParameter = parse.getQueryParameter("scm");
                    List<UserCenterDynamicMenu.DynamicMenuItem> itemList = this.p.getItemList();
                    if (wh2.e(itemList) > 0) {
                        C0529c.e().x(vf1.x().q(queryParameter, targetUrl, itemList.indexOf(dynamicMenuItem) + 4));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void p(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-262692096")) {
            ipChange.ipc$dispatch("-262692096", new Object[]{this, str, Integer.valueOf(i)});
        } else {
            C0529c.e().x(vf1.x().q("", str, i));
        }
    }

    private void r(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-800400488")) {
            ipChange.ipc$dispatch("-800400488", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            tf1.a = tf1.c;
        } else {
            tf1.a = tf1.d;
        }
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1183823314")) {
            ipChange.ipc$dispatch("-1183823314", new Object[]{this});
        } else if (this.a == null) {
        } else {
            String simpleName = CustomersActivity.class.getSimpleName();
            if (!LoginManager.k().q()) {
                Bundle bundle = new Bundle();
                bundle.putInt("from", 1);
                bundle.putString("activity_name", simpleName);
                DMNav.from(this.a).withExtras(bundle).toUri(cs.f());
                return;
            }
            DMNav.from(this.a).toUri(NavUri.b(cs.R));
        }
    }

    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-589296428")) {
            ipChange.ipc$dispatch("-589296428", new Object[]{this});
        } else if (this.a == null) {
        } else {
            if (wf1.d()) {
                if ("1".equals(OrangeConfigCenter.c().b(on1.b, "myCouponDowngrade", "0"))) {
                    DMNav.from(this.a).toUri(cs.d());
                    return;
                } else {
                    DMNav.from(this.a).toUri("damai://V1/Flutter?flutter_path=dm_coupon_list&bizType=0");
                    return;
                }
            }
            wf1.c(this.a);
        }
    }

    public void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-889938426")) {
            ipChange.ipc$dispatch("-889938426", new Object[]{this});
        } else if (LoginManager.k().q()) {
            if (this.a != null) {
                Bundle bundle = new Bundle();
                bundle.putString("from_where", "damai");
                DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(cs.f));
            }
        } else {
            wf1.c(this.a);
        }
    }

    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401589864")) {
            ipChange.ipc$dispatch("-401589864", new Object[]{this});
        } else if (this.a == null) {
        } else {
            Bundle bundle = new Bundle();
            if (wf1.d()) {
                bundle.putLong(ApiConstants.ApiField.MEMBER_ID, wh2.n(z20.E()));
                bundle.putString("type", "morenpeisong");
                DMNav.from(this.a).withExtras(bundle).toUri(cs.g());
                return;
            }
            bundle.putInt("from", 1);
            DMNav.from(this.a).withExtras(bundle).toUri(cs.f());
        }
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1588772999")) {
            ipChange.ipc$dispatch("-1588772999", new Object[]{this});
        } else if (this.a == null) {
        } else {
            if (wf1.d()) {
                DMNav.from(this.a).toUri(cs.l());
            } else {
                wf1.c(this.a);
            }
        }
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1677393238")) {
            ipChange.ipc$dispatch("1677393238", new Object[]{this});
            return;
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public boolean l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "997817527")) {
            return ((Boolean) ipChange.ipc$dispatch("997817527", new Object[]{this})).booleanValue();
        }
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            return frameLayout.isShown();
        }
        return false;
    }

    public boolean m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "222285976")) {
            return ((Boolean) ipChange.ipc$dispatch("222285976", new Object[]{this})).booleanValue();
        }
        FrameLayout frameLayout = this.h;
        if (frameLayout != null) {
            return frameLayout.isShown();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-614664995")) {
            ipChange.ipc$dispatch("-614664995", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (R$id.ll_mine_common_orderlist == id) {
            p("damai://" + cs.f, 0);
            f();
        } else if (R$id.ll_mine_common_purchase == id) {
            p("damai://" + cs.R, 1);
            d();
        } else if (R$id.ll_mine_user_center_address == id) {
            p("damai://" + cs.g(), 2);
            g();
        } else if (R$id.ll_mine_evaluate == id) {
            MineUserCenterBadeListener mineUserCenterBadeListener = this.c;
            if (mineUserCenterBadeListener != null) {
                mineUserCenterBadeListener.markBadgeData("DM_USER_MY_EVALUATE");
            }
            p("damai://" + cs.l(), 3);
            h();
        } else if (R$id.ll_mine_coupon == id) {
            MineUserCenterBadeListener mineUserCenterBadeListener2 = this.c;
            if (mineUserCenterBadeListener2 != null) {
                mineUserCenterBadeListener2.markBadgeData("DM_USER_MY_COUPON");
            }
            p("damai://" + cs.d(), 4);
            e();
        } else if (R$id.ll_extend_state == id) {
            boolean z = !this.q;
            this.q = z;
            r(z);
            t();
            C0529c.e().x(vf1.x().r());
        }
    }

    public void q(MineUserCenterBadeListener mineUserCenterBadeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1212594103")) {
            ipChange.ipc$dispatch("1212594103", new Object[]{this, mineUserCenterBadeListener});
        } else {
            this.c = mineUserCenterBadeListener;
        }
    }

    public void s(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925081219")) {
            ipChange.ipc$dispatch("925081219", new Object[]{this, Integer.valueOf(i)});
        } else if (i <= 0) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
        }
    }

    public void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "275313456")) {
            ipChange.ipc$dispatch("275313456", new Object[]{this});
        } else if (this.q) {
            this.l.setVisibility(8);
            this.n.setText("展开");
            Activity activity = this.a;
            if (activity != null) {
                this.o.setText(activity.getString(R$string.iconfont_xiangxiajiantou_));
            }
        } else {
            this.l.setVisibility(0);
            this.n.setText("收起");
            Activity activity2 = this.a;
            if (activity2 != null) {
                this.o.setText(activity2.getString(R$string.iconfont_xiangshangjiantou_));
            }
        }
    }

    public void u(UserCenterDynamicMenu userCenterDynamicMenu) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584348883")) {
            ipChange.ipc$dispatch("-584348883", new Object[]{this, userCenterDynamicMenu});
            return;
        }
        this.p = userCenterDynamicMenu;
        if (userCenterDynamicMenu != null && wh2.e(userCenterDynamicMenu.getItemList()) != 0 && this.a != null) {
            if (tf1.a == tf1.c) {
                this.q = true;
            } else if (tf1.a == tf1.d) {
                this.q = false;
            } else {
                if (wf1.d()) {
                    this.q = true;
                } else {
                    this.q = false;
                }
                r(this.q);
            }
            this.l.removeAllViews();
            DisplayMetrics c = m62.c(this.a);
            List<UserCenterDynamicMenu.DynamicMenuItem> itemList = userCenterDynamicMenu.getItemList();
            int size = itemList.size();
            for (int i = 0; i < size; i++) {
                RelativeLayout relativeLayout = (RelativeLayout) View.inflate(this.a, R$layout.layout_user_center_dynamic_menu, null);
                relativeLayout.setMinimumWidth(((com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(c) - t60.a(this.a, 50.0f)) - 1) / 5);
                UserCenterDynamicMenu.DynamicMenuItem dynamicMenuItem = itemList.get(i);
                ((TextView) relativeLayout.findViewById(R$id.tv_title)).setText(dynamicMenuItem.getTitle());
                ImageView imageView = (ImageView) relativeLayout.findViewById(R$id.iv_icon);
                if (!TextUtils.isEmpty(dynamicMenuItem.getIconUrl())) {
                    DMImageCreator c2 = C0504a.b().c(dynamicMenuItem.getIconUrl());
                    int i2 = R$drawable.user_center_dynamic_menu_bg;
                    c2.i(i2).c(i2).g(imageView);
                } else {
                    imageView.setImageResource(R$drawable.user_center_dynamic_menu_bg);
                }
                View findViewById = relativeLayout.findViewById(R$id.bubble_layout);
                TextView textView = (TextView) relativeLayout.findViewById(R$id.tv_dynamic_menu_item_tag);
                if (!TextUtils.isEmpty(dynamicMenuItem.getBubbleText())) {
                    findViewById.setVisibility(0);
                    textView.setText(dynamicMenuItem.getBubbleText());
                } else {
                    findViewById.setVisibility(8);
                }
                relativeLayout.setTag(dynamicMenuItem);
                relativeLayout.setOnClickListener(this.r);
                this.l.addView(relativeLayout);
            }
            this.m.setVisibility(0);
            t();
            return;
        }
        this.l.setVisibility(8);
        this.m.setVisibility(8);
    }

    public void v(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2077173688")) {
            ipChange.ipc$dispatch("2077173688", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        String a = wf1.a(i);
        String a2 = wf1.a(i2);
        if (i > 0 && !TextUtils.isEmpty(a)) {
            this.g.setVisibility(0);
            this.g.setText(a);
            this.f.setTag(String.valueOf(i));
        } else {
            this.g.setVisibility(8);
            this.f.setTag("0");
        }
        if (i2 > 0 && !TextUtils.isEmpty(a2)) {
            this.j.setVisibility(0);
            this.j.setText(a2);
            this.i.setTag(String.valueOf(i2));
            return;
        }
        this.j.setVisibility(8);
        this.i.setTag("0");
    }

    public void w(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454211952")) {
            ipChange.ipc$dispatch("454211952", new Object[]{this, Integer.valueOf(i)});
        } else if (i <= 0) {
            this.h.setVisibility(8);
        } else {
            this.h.setVisibility(0);
        }
    }
}
