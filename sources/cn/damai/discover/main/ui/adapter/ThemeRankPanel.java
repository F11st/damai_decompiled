package cn.damai.discover.main.ui.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ThemeRankPanel implements WeakRefCountDownTimer.OnTickListener {
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
    private ThemeRankAdapter k;
    private OnItemBindListener<RankUserBean> l;
    private d13 m;
    private long[] p = new long[4];
    private String[] q = new String[4];
    private int n = m62.a(mu0.a(), 11.0f);
    private int o = m62.a(mu0.a(), 6.0f);

    public ThemeRankPanel(Context context, ViewStub viewStub, OnItemBindListener<RankUserBean> onItemBindListener) {
        this.a = context;
        this.b = viewStub;
        this.l = onItemBindListener;
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1281070343")) {
            ipChange.ipc$dispatch("1281070343", new Object[]{this});
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
            RecyclerView recyclerView = (RecyclerView) this.c.findViewById(R$id.theme_rank_lv);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
            ThemeRankAdapter themeRankAdapter = new ThemeRankAdapter(this.a, this.l);
            this.k = themeRankAdapter;
            recyclerView.setAdapter(themeRankAdapter);
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.discover.main.ui.adapter.ThemeRankPanel.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView2, RecyclerView.State state) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2074566294")) {
                        ipChange2.ipc$dispatch("2074566294", new Object[]{this, rect, view, recyclerView2, state});
                        return;
                    }
                    int childAdapterPosition = recyclerView2.getChildAdapterPosition(view);
                    boolean z = childAdapterPosition == 0;
                    boolean z2 = childAdapterPosition == ThemeRankPanel.this.k.getItemCount() - 1;
                    if (z) {
                        rect.left = ThemeRankPanel.this.n;
                    } else {
                        rect.left = ThemeRankPanel.this.o;
                    }
                    if (z2) {
                        rect.right = ThemeRankPanel.this.n;
                    } else {
                        rect.right = 0;
                    }
                }
            });
        }
    }

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-61643372")) {
            ipChange.ipc$dispatch("-61643372", new Object[]{this});
            return;
        }
        View view = this.c;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private boolean g(String str) {
        int length;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1538011899")) {
            return ((Boolean) ipChange.ipc$dispatch("-1538011899", new Object[]{this, str})).booleanValue();
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

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-336097688")) {
            ipChange.ipc$dispatch("-336097688", new Object[]{this});
            return;
        }
        this.d.setVisibility(0);
        this.e.setVisibility(8);
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1475839921")) {
            ipChange.ipc$dispatch("-1475839921", new Object[]{this});
            return;
        }
        View view = this.c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public int e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "137895457")) {
            return ((Integer) ipChange.ipc$dispatch("137895457", new Object[]{this})).intValue();
        }
        View view = this.c;
        if (view != null) {
            return view.getVisibility();
        }
        return 8;
    }

    public void j(@Nullable ThemeRankBean themeRankBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1092946688")) {
            ipChange.ipc$dispatch("1092946688", new Object[]{this, themeRankBean});
        } else if (themeRankBean == null) {
            f();
        } else {
            d();
            i();
            d13 d13Var = this.m;
            if (d13Var != null) {
                d13Var.cancel();
            }
            long j = themeRankBean.countDown;
            if (j > 0) {
                this.d.setVisibility(8);
                this.e.setVisibility(8);
                d13 d13Var2 = new d13(j, 1000L, this);
                this.m = d13Var2;
                d13Var2.start();
            } else {
                h();
            }
            this.k.d(themeRankBean.getRankList());
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2126229630")) {
            ipChange.ipc$dispatch("-2126229630", new Object[]{this});
        } else {
            h();
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onTick(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1847846796")) {
            ipChange.ipc$dispatch("1847846796", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.e.setVisibility(0);
        jm1.b(this.p, j);
        jm1.d(this.q, this.p);
        String[] strArr = this.q;
        String str = strArr[0];
        String str2 = strArr[1];
        String str3 = strArr[2];
        String str4 = strArr[3];
        if (!TextUtils.isEmpty(str) && !g(str)) {
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
