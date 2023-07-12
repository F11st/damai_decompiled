package cn.damai.discover.main.ui.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$id;
import cn.damai.discover.main.ui.bean.RankUserBean;
import cn.damai.discover.main.ui.bean.ThemeRankBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d13;
import tb.jm1;
import tb.m62;
import tb.mu0;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class CircleRankPanel implements WeakRefCountDownTimer.OnTickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private ViewStub b;
    private View c;
    private View d;
    private View e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private RelativeLayout k;
    private LinearLayout l;
    private TextView m;
    private ThemeRankAdapter n;
    private OnItemBindListener<RankUserBean> o;
    private d13 p;
    private String u;
    private long[] s = new long[4];
    private String[] t = new String[4];
    private View.OnClickListener v = new View$OnClickListenerC1065a();
    private int q = m62.a(mu0.a(), 11.0f);
    private int r = m62.a(mu0.a(), 6.0f);

    /* compiled from: Taobao */
    /* renamed from: cn.damai.discover.main.ui.adapter.CircleRankPanel$a */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC1065a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1065a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "230881267")) {
                ipChange.ipc$dispatch("230881267", new Object[]{this, view});
            } else if (TextUtils.isEmpty(CircleRankPanel.this.u)) {
            } else {
                DMNav.from(CircleRankPanel.this.a).toUri(CircleRankPanel.this.u);
            }
        }
    }

    public CircleRankPanel(Context context, ViewStub viewStub, OnItemBindListener<RankUserBean> onItemBindListener) {
        this.a = context;
        this.b = viewStub;
        this.o = onItemBindListener;
    }

    private void f(ThemeRankBean themeRankBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1290009121")) {
            ipChange.ipc$dispatch("-1290009121", new Object[]{this, themeRankBean});
        } else if (this.c == null) {
            View inflate = this.b.inflate();
            this.c = inflate;
            this.d = inflate.findViewById(R$id.theme_rank_end);
            this.e = this.c.findViewById(R$id.theme_rank_count_down_ui);
            this.f = (TextView) this.c.findViewById(R$id.theme_rank_day_num);
            this.g = (TextView) this.c.findViewById(R$id.theme_rank_day_text);
            this.h = (TextView) this.c.findViewById(R$id.theme_rank_hour_num);
            this.i = (TextView) this.c.findViewById(R$id.theme_rank_minute_num);
            this.j = (TextView) this.c.findViewById(R$id.theme_rank_second_num);
            this.m = (TextView) this.c.findViewById(R$id.tv_rank_title);
            this.k = (RelativeLayout) this.c.findViewById(R$id.rl_rank_head_layout);
            this.l = (LinearLayout) this.c.findViewById(R$id.ll_rank_mid_layout);
            RelativeLayout relativeLayout = this.k;
            int i = themeRankBean.cliquePrize;
            relativeLayout.setVisibility((i == 2 || i == 0) ? 8 : 0);
            LinearLayout linearLayout = this.l;
            int i2 = themeRankBean.cliquePrize;
            linearLayout.setVisibility((i2 == 2 || i2 == 0) ? 8 : 0);
            View findViewById = this.c.findViewById(R$id.rank_list_layout);
            View findViewById2 = this.c.findViewById(R$id.line);
            RecyclerView recyclerView = (RecyclerView) this.c.findViewById(R$id.theme_rank_lv);
            if (themeRankBean.getRankList().size() > 0) {
                findViewById.setVisibility(0);
                findViewById2.setVisibility(0);
                recyclerView.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
                ThemeRankAdapter themeRankAdapter = new ThemeRankAdapter(this.a, this.o);
                this.n = themeRankAdapter;
                recyclerView.setAdapter(themeRankAdapter);
                recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.discover.main.ui.adapter.CircleRankPanel.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView2, RecyclerView.State state) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "122041848")) {
                            ipChange2.ipc$dispatch("122041848", new Object[]{this, rect, view, recyclerView2, state});
                            return;
                        }
                        int childAdapterPosition = recyclerView2.getChildAdapterPosition(view);
                        boolean z = childAdapterPosition == 0;
                        boolean z2 = childAdapterPosition == CircleRankPanel.this.n.getItemCount() - 1;
                        if (z) {
                            rect.left = CircleRankPanel.this.q;
                        } else {
                            rect.left = CircleRankPanel.this.r;
                        }
                        if (z2) {
                            rect.right = CircleRankPanel.this.q;
                        } else {
                            rect.right = 0;
                        }
                    }
                });
                return;
            }
            ((LinearLayout.LayoutParams) this.m.getLayoutParams()).bottomMargin = t60.a(this.a, 14.0f);
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
        }
    }

    private void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1263947091")) {
            ipChange.ipc$dispatch("1263947091", new Object[]{this});
            return;
        }
        View view = this.c;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private boolean h(String str) {
        int length;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "657056516")) {
            return ((Boolean) ipChange.ipc$dispatch("657056516", new Object[]{this, str})).booleanValue();
        }
        if (TextUtils.isEmpty(str) || (length = str.length()) <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1854363319")) {
            ipChange.ipc$dispatch("-1854363319", new Object[]{this});
            return;
        }
        this.d.setVisibility(0);
        this.e.setVisibility(8);
    }

    private void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-150249458")) {
            ipChange.ipc$dispatch("-150249458", new Object[]{this});
            return;
        }
        View view = this.c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void k(@Nullable ThemeRankBean themeRankBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-937631425")) {
            ipChange.ipc$dispatch("-937631425", new Object[]{this, themeRankBean});
        } else if (themeRankBean == null) {
            g();
        } else {
            f(themeRankBean);
            j();
            this.m.setText(TextUtils.isEmpty(themeRankBean.name) ? "" : themeRankBean.name);
            this.u = themeRankBean.descUrl;
            this.k.setOnClickListener(this.v);
            this.l.setOnClickListener(this.v);
            d13 d13Var = this.p;
            if (d13Var != null) {
                d13Var.cancel();
            }
            long j = themeRankBean.countDown;
            if (j > 0) {
                this.d.setVisibility(8);
                this.e.setVisibility(8);
                d13 d13Var2 = new d13(j, 1000L, this);
                this.p = d13Var2;
                d13Var2.start();
            } else {
                i();
            }
            if (themeRankBean.getRankList().size() > 0) {
                this.n.d(themeRankBean.getRankList());
            }
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "410383331")) {
            ipChange.ipc$dispatch("410383331", new Object[]{this});
        } else {
            i();
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onTick(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "267105035")) {
            ipChange.ipc$dispatch("267105035", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.e.setVisibility(0);
        jm1.b(this.s, j);
        jm1.d(this.t, this.s);
        String[] strArr = this.t;
        String str = strArr[0];
        String str2 = strArr[1];
        String str3 = strArr[2];
        String str4 = strArr[3];
        if (!TextUtils.isEmpty(str) && !h(str)) {
            this.f.setVisibility(0);
            this.g.setVisibility(0);
            this.f.setText(str);
        } else {
            this.f.setVisibility(8);
            this.g.setVisibility(8);
        }
        this.h.setText(str2);
        this.i.setText(str3);
        this.j.setText(str4);
    }
}
