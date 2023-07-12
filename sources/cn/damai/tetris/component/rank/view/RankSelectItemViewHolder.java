package cn.damai.tetris.component.rank.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.tetris.component.drama.viewholder.OnItemClickListener;
import cn.damai.tetris.component.rank.bean.RankSelectItemBean;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.m62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RankSelectItemViewHolder extends BaseViewHolderV2<RankSelectItemBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final DMPosterView c;
    @NotNull
    private final TextView d;
    @NotNull
    private final TextView e;
    @NotNull
    private final LinearLayout f;
    private final int g;
    private final int h;
    @Nullable
    private final OnItemClickListener<RankSelectItemBean> i;
    @Nullable
    private HashMap<Integer, Integer> j;

    public RankSelectItemViewHolder(@Nullable Context context, @Nullable ViewGroup viewGroup, @Nullable OnItemClickListener<RankSelectItemBean> onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.item_tetris_rank_select_card, viewGroup, false));
        View findViewById = this.itemView.findViewById(R$id.iv_poster);
        b41.h(findViewById, "itemView.findViewById(R.id.iv_poster)");
        this.c = (DMPosterView) findViewById;
        View findViewById2 = this.itemView.findViewById(R$id.drama_inner_layout);
        View findViewById3 = this.itemView.findViewById(R$id.tv_title);
        b41.h(findViewById3, "itemView.findViewById(R.id.tv_title)");
        this.d = (TextView) findViewById3;
        View findViewById4 = this.itemView.findViewById(R$id.tv_desc);
        b41.h(findViewById4, "itemView.findViewById(R.id.tv_desc)");
        this.e = (TextView) findViewById4;
        View findViewById5 = this.itemView.findViewById(R$id.ll_tv_container);
        b41.h(findViewById5, "itemView.findViewById(R.id.ll_tv_container)");
        this.f = (LinearLayout) findViewById5;
        this.i = onItemClickListener;
        findViewById2.setOnClickListener(this);
        this.h = m62.a(mu0.a(), 95.0f);
        this.g = m62.a(mu0.a(), 128.0f);
    }

    private final Integer e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1027132277")) {
            return (Integer) ipChange.ipc$dispatch("-1027132277", new Object[]{this, Integer.valueOf(i)});
        }
        if (this.j == null) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            this.j = hashMap;
            b41.f(hashMap);
            hashMap.put(0, Integer.valueOf(R$drawable.bg_rank_select_1));
            HashMap<Integer, Integer> hashMap2 = this.j;
            b41.f(hashMap2);
            hashMap2.put(1, Integer.valueOf(R$drawable.bg_rank_select_2));
            HashMap<Integer, Integer> hashMap3 = this.j;
            b41.f(hashMap3);
            hashMap3.put(2, Integer.valueOf(R$drawable.bg_rank_select_3));
            HashMap<Integer, Integer> hashMap4 = this.j;
            b41.f(hashMap4);
            hashMap4.put(3, Integer.valueOf(R$drawable.bg_rank_select_4));
        }
        HashMap<Integer, Integer> hashMap5 = this.j;
        b41.f(hashMap5);
        return hashMap5.get(Integer.valueOf(i % 4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2
    /* renamed from: d */
    public void c(@Nullable RankSelectItemBean rankSelectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "929753521")) {
            ipChange.ipc$dispatch("929753521", new Object[]{this, rankSelectItemBean, Integer.valueOf(i)});
        } else if (rankSelectItemBean == null) {
        } else {
            LinearLayout linearLayout = this.f;
            Resources resources = mu0.a().getResources();
            Integer e = e(i);
            b41.f(e);
            linearLayout.setBackground(resources.getDrawable(e.intValue()));
            List<String> list = rankSelectItemBean.verticalPicList;
            if (list != null) {
                b41.f(list);
                if (list.size() > 0) {
                    DMPosterView dMPosterView = this.c;
                    List<String> list2 = rankSelectItemBean.verticalPicList;
                    b41.f(list2);
                    dMPosterView.setImageUrlForWebp(list2.get(0), this.h, this.g);
                }
            }
            String str = rankSelectItemBean.shortName;
            if (str != null) {
                this.d.setText(str);
            }
            String str2 = rankSelectItemBean.shortDesc;
            if (str2 != null) {
                this.e.setText(str2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        T t;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-823848634")) {
            ipChange.ipc$dispatch("-823848634", new Object[]{this, view});
            return;
        }
        b41.i(view, "v");
        OnItemClickListener<RankSelectItemBean> onItemClickListener = this.i;
        if (onItemClickListener == null || (t = this.a) == 0) {
            return;
        }
        onItemClickListener.onItemClick(t, this.b);
    }
}
