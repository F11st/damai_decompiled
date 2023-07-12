package tb;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import cn.damai.evaluate.ui.EvaluateListFragment;
import cn.damai.homepage.R$dimen;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$string;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.repertoite.view.AttentionView;
import cn.damai.user.show.view.ShowFragment;
import cn.damai.user.userprofile.FeedsFragment;
import cn.damai.user.userprofile.FragmentAdapter;
import cn.damai.user.userprofile.UnDestoryAdapter;
import cn.damai.user.userprofile.UserIndexActivity;
import cn.damai.user.userprofile.UserIndexViewModel;
import cn.damai.user.userprofile.bean.FeedsRequest;
import cn.damai.user.userprofile.bean.UserData;
import cn.damai.user.userprofile.bean.UserResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class kw0 implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private UserResponse a;
    private UserIndexActivity b;
    private UserData c;
    UserIndexViewModel d;
    int e;
    FragmentAdapter f;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1302050436")) {
                ipChange.ipc$dispatch("-1302050436", new Object[]{this, view});
            } else {
                kw0.this.d.getClickEvent().setValue(15);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "809239933")) {
                ipChange.ipc$dispatch("809239933", new Object[]{this, view});
            } else {
                kw0.this.d.getClickEvent().setValue(6);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1374436994")) {
                ipChange.ipc$dispatch("-1374436994", new Object[]{this, view});
            } else {
                kw0.this.d.getClickEvent().setValue(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "736853375")) {
                ipChange.ipc$dispatch("736853375", new Object[]{this, view});
            } else if (kw0.this.c == null || kw0.this.c.focusNum <= 0) {
            } else {
                kw0.this.d.getClickEvent().setValue(10);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1446823552")) {
                ipChange.ipc$dispatch("-1446823552", new Object[]{this, view});
            } else if (kw0.this.c == null || kw0.this.c.fansNum <= 0) {
            } else {
                kw0.this.d.getClickEvent().setValue(11);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "664466817")) {
                ipChange.ipc$dispatch("664466817", new Object[]{this, view});
            } else if (kw0.this.c == null || kw0.this.c.fansNum <= 0 || !kw0.this.c.vaccount || !kw0.this.c.mySelf) {
            } else {
                kw0.this.d.getClickEvent().setValue(11);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1519210110")) {
                ipChange.ipc$dispatch("-1519210110", new Object[]{this, view});
            } else if (kw0.this.c == null || kw0.this.c.focusNum <= 0 || !kw0.this.c.vaccount || !kw0.this.c.mySelf) {
            } else {
                kw0.this.d.getClickEvent().setValue(10);
            }
        }
    }

    public kw0(UserResponse userResponse, UserIndexActivity userIndexActivity, int i) {
        this.e = -1;
        this.a = userResponse;
        this.b = userIndexActivity;
        this.c = userResponse.data;
        this.d = (UserIndexViewModel) ViewModelProviders.of(userIndexActivity).get(UserIndexViewModel.class);
        this.e = i;
    }

    private <T extends View> T e(@IdRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-601572169")) {
            return (T) ipChange.ipc$dispatch("-601572169", new Object[]{this, Integer.valueOf(i)});
        }
        UserIndexActivity userIndexActivity = this.b;
        if (userIndexActivity != null) {
            return (T) userIndexActivity.findViewById(i);
        }
        return null;
    }

    private int h(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2126454221") ? ((Integer) ipChange.ipc$dispatch("-2126454221", new Object[]{this, Integer.valueOf(i)})).intValue() : this.b.getResources().getDimensionPixelOffset(i);
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-281520068")) {
            ipChange.ipc$dispatch("-281520068", new Object[]{this});
            return;
        }
        ViewPager viewPager = (ViewPager) e(R$id.view_pager);
        UnDestoryAdapter unDestoryAdapter = new UnDestoryAdapter(this.b.getSupportFragmentManager());
        this.f = unDestoryAdapter;
        viewPager.setAdapter(unDestoryAdapter);
        UserData userData = this.c;
        int i = userData.type;
        if (i == 1) {
            this.f.a(FeedsFragment.newInstance(i, userData.userId, userData.bid, FeedsRequest.FEED_TYPE_DONGTAI));
        } else if (i == 5) {
            Bundle bundle = new Bundle();
            RepertoireDetailFragment repertoireDetailFragment = new RepertoireDetailFragment();
            bundle.putString(RepertoireDetailFragment.REPERTOIREID, this.c.bid + "");
            bundle.putString(RepertoireDetailFragment.USERTYPE, this.c.type + "");
            bundle.putBoolean(RepertoireDetailFragment.MYSELF, this.c.mySelf);
            repertoireDetailFragment.setArguments(bundle);
            UserData userData2 = this.c;
            FeedsFragment newInstance = FeedsFragment.newInstance(userData2.type, userData2.userId, userData2.bid, FeedsRequest.FEED_TYPE_QUANZI);
            EvaluateListFragment evaluateListFragment = new EvaluateListFragment();
            evaluateListFragment.setEvalutateItemClickUTData(this.b);
            Bundle bundle2 = new Bundle();
            bundle2.putString(g41.ISSUE_PARAM_IPID, this.c.bid + "");
            bundle2.putBoolean("refreshAble", false);
            bundle2.putInt("fromWhere", EvaluateListFragment.EVALUATELIST_REPERTOIRE);
            evaluateListFragment.setArguments(bundle2);
            this.f.a(repertoireDetailFragment);
            this.f.a(newInstance);
            this.f.a(evaluateListFragment);
        } else {
            ShowFragment showFragment = new ShowFragment();
            Bundle bundle3 = new Bundle();
            bundle3.putInt("type", this.c.type);
            bundle3.putString("id", this.c.bid + "");
            showFragment.setArguments(bundle3);
            UserData userData3 = this.c;
            FeedsFragment newInstance2 = FeedsFragment.newInstance(userData3.type, userData3.userId, userData3.bid, FeedsRequest.FEED_TYPE_QUANZI);
            this.f.a(showFragment);
            this.f.a(newInstance2);
        }
        if (this.f.getCount() > 1) {
            int i2 = this.e;
            if (i2 > -1) {
                viewPager.setCurrentItem(i2);
            } else if (this.d.isShowCircle()) {
                viewPager.setCurrentItem(1);
            } else if (this.d.showComment && this.f.getCount() == 3) {
                viewPager.setCurrentItem(2);
            } else {
                UserData userData4 = this.c;
                if (userData4.type != 5) {
                    if (userData4 == null || userData4.projectCount != 0) {
                        return;
                    }
                    viewPager.setCurrentItem(1);
                    return;
                }
                viewPager.setCurrentItem(0);
            }
        }
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-844240461")) {
            ipChange.ipc$dispatch("-844240461", new Object[]{this});
        } else if (this.f != null) {
            FragmentTransaction beginTransaction = this.b.getSupportFragmentManager().beginTransaction();
            for (Fragment fragment : this.f.b()) {
                beginTransaction.remove(fragment);
            }
            beginTransaction.commitAllowingStateLoss();
        }
    }

    public void d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "3976370")) {
            ipChange.ipc$dispatch("3976370", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        UserData userData = this.c;
        if (userData.type != 1) {
            if (userData.mySelf) {
                iw0.h(this.b, userData, e(R$id.rl_header_b), i);
                return;
            } else {
                iw0.h(this.b, userData, e(R$id.rl_header_b_other), i);
                return;
            }
        }
        iw0.h(this.b, userData, e(R$id.rl_header_c), i);
    }

    public void f(int i) {
        int a2;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1061056384")) {
            ipChange.ipc$dispatch("-1061056384", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        View e2 = e(R$id.toolbar);
        if (this.c.type != 1) {
            i2 = h(R$dimen.USER_HEADER_HB) + h(R$dimen.NAVBAR_H) + i;
            if (this.c.mySelf) {
                e(R$id.rl_header_b).setVisibility(0);
                e(R$id.rl_header_b_other).setVisibility(8);
            } else {
                e(R$id.rl_header_b).setVisibility(8);
                int i3 = R$id.rl_header_b_other;
                e(i3).setVisibility(0);
                UserData userData = this.c;
                if (userData.lat > 0.0d && userData.lng > 0.0d) {
                    e(i3).findViewById(R$id.user_tv_desc).setOnClickListener(new a());
                }
            }
            e(R$id.rl_header_c).setVisibility(8);
        } else {
            View e3 = e(R$id.user_iv_header);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) e3.getLayoutParams();
            if (!this.c.mySelf) {
                a2 = h(R$dimen.USER_HEADER_HC) + h(R$dimen.NAVBAR_H) + i;
                layoutParams.setMargins(0, 0, 0, 0);
            } else {
                a2 = t60.a(this.b, 322.0f);
                e(R$id.user_tv_add).setVisibility(8);
                e(R$id.ll_div).setVisibility(8);
                int i4 = R$id.rl_header_c;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) e(i4).getLayoutParams();
                layoutParams2.setMargins(0, h(R$dimen.NAVBAR_H) + i + t60.a(this.b, 6.0f), 0, 0);
                layoutParams2.height = a2;
                e(i4).setLayoutParams(layoutParams2);
            }
            e(R$id.rl_header_b).setVisibility(8);
            e(R$id.rl_header_b_other).setVisibility(8);
            e(R$id.rl_header_c).setVisibility(0);
            e3.setLayoutParams(layoutParams);
            i2 = a2;
        }
        AppBarLayout.LayoutParams layoutParams3 = (AppBarLayout.LayoutParams) e2.getLayoutParams();
        ((LinearLayout.LayoutParams) layoutParams3).height = i2;
        e2.setLayoutParams(layoutParams3);
    }

    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-274795518")) {
            ipChange.ipc$dispatch("-274795518", new Object[]{this});
            return;
        }
        if (this.c.mySelf) {
            e(R$id.tv_publish).setVisibility(0);
            int i = R$id.tv_share;
            e(i).setVisibility(0);
            int i2 = R$id.tv_attention;
            e(i2).setVisibility(8);
            e(R$id.tv_navchat).setVisibility(8);
            e(i2).setClickable(false);
            ((TextView) e(i)).setText(this.b.getResources().getString(R$string.iconfont_bianji24));
        } else {
            e(R$id.tv_publish).setVisibility(8);
            int i3 = R$id.tv_share;
            e(i3).setVisibility(0);
            ((TextView) e(i3)).setText(this.b.getResources().getString(R$string.iconfont_fenxiang18));
            AttentionView attentionView = (AttentionView) e(R$id.tv_attention);
            if (this.d.getUserInfoValue() != null) {
                UserIndexViewModel userIndexViewModel = this.d;
                attentionView.setUser(userIndexViewModel.userid, userIndexViewModel.usertype, userIndexViewModel.getUserInfoValue().mySelf);
            }
            UserData userData = this.c;
            if (userData.type != 1 && !TextUtils.isEmpty(userData.userId)) {
                e(R$id.tv_navchat).setVisibility(8);
            } else {
                e(R$id.tv_navchat).setVisibility(8);
            }
            iw0.g(this.c, attentionView);
        }
        e(R$id.tv_share).setOnClickListener(this);
        e(R$id.tv_publish).setOnClickListener(this);
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "450299706")) {
            ipChange.ipc$dispatch("450299706", new Object[]{this});
            return;
        }
        b bVar = new b();
        if (this.c.type != 1) {
            e(R$id.rl_header_b).findViewById(R$id.user_iv_header).setOnClickListener(bVar);
        } else {
            e(R$id.rl_header_c).findViewById(R$id.user_iv_header).setOnClickListener(bVar);
        }
        e(R$id.toolbar).setOnClickListener(new c());
        int i = R$id.rl_header_c;
        e(i).findViewById(R$id.user_c_follow).setOnClickListener(new d());
        e(i).findViewById(R$id.user_c_fans).setOnClickListener(new e());
        int i2 = R$id.rl_header_b;
        e(i2).findViewById(R$id.ll_left).setOnClickListener(new f());
        e(i2).findViewById(R$id.ll_mid).setOnClickListener(new g());
    }

    public void j(UserResponse userResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1453499611")) {
            ipChange.ipc$dispatch("1453499611", new Object[]{this, userResponse});
            return;
        }
        this.a = userResponse;
        this.c = userResponse.data;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "82706991")) {
            ipChange.ipc$dispatch("82706991", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.tv_publish) {
            this.d.getClickEvent().setValue(2);
        } else if (id == R$id.tv_share) {
            if (this.c.mySelf) {
                this.d.getClickEvent().setValue(5);
            } else {
                this.d.getClickEvent().setValue(4);
            }
        }
    }
}
