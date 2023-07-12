package cn.damai.search.v2.tool;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.v2.bean.RankWordBean;
import cn.damai.search.v2.bean.SearchRankWordRes;
import cn.damai.search.v2.request.RankingListMtopRequest;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;
import tb.l62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class RankWordManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private ViewGroup b;
    private TextView c;
    private TextView d;
    private OnRankWordListener e;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnRankWordListener {
        void onRankWordClick(RankWordBean rankWordBean, int i);

        void onRankWordExpose(View view, RankWordBean rankWordBean, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RankWordBean a;
        final /* synthetic */ int b;

        a(RankWordBean rankWordBean, int i) {
            this.a = rankWordBean;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-813657277")) {
                ipChange.ipc$dispatch("-813657277", new Object[]{this, view});
            } else if (RankWordManager.this.e != null) {
                RankWordManager.this.e.onRankWordClick(this.a, this.b);
            }
        }
    }

    public RankWordManager(View view, OnRankWordListener onRankWordListener) {
        this.e = onRankWordListener;
        this.a = view;
        view.setVisibility(8);
        this.b = (ViewGroup) this.a.findViewById(R$id.search_v2_hot_word_container);
        this.c = (TextView) this.a.findViewById(R$id.search_v2_hot_word_title);
        this.d = (TextView) this.a.findViewById(R$id.search_v2_hot_word_sub_title);
    }

    private void c(RankWordBean rankWordBean, int i, View view) {
        int parseColor;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1927855394")) {
            ipChange.ipc$dispatch("1927855394", new Object[]{this, rankWordBean, Integer.valueOf(i), view});
            return;
        }
        View findViewById = view.findViewById(R$id.search_v2_rank_word_ui);
        TextView textView = (TextView) view.findViewById(R$id.search_v2_rank_number);
        TextView textView2 = (TextView) view.findViewById(R$id.search_v2_rank_text);
        ImageView imageView = (ImageView) view.findViewById(R$id.search_v2_rank_tag);
        ImageView imageView2 = (ImageView) view.findViewById(R$id.search_v2_rank_trend);
        textView2.setMaxWidth(Math.min(l62.a(mu0.a(), 250.0f), DisplayMetrics.getwidthPixels(l62.b(mu0.a())) - l62.a(mu0.a(), 149.0f)));
        rankWordBean.index = i;
        boolean isShowTag = rankWordBean.isShowTag();
        imageView.setVisibility(isShowTag ? 0 : 4);
        if (isShowTag) {
            imageView.setImageResource(rankWordBean.getTagDrawableRid());
        }
        boolean isShowTrend = rankWordBean.isShowTrend();
        imageView2.setVisibility(isShowTrend ? 0 : 4);
        if (isShowTrend) {
            imageView2.setImageResource(rankWordBean.getTrendDrawableRid());
        }
        if (i == 0) {
            parseColor = Color.parseColor("#FE4361");
        } else if (i == 1) {
            parseColor = Color.parseColor("#FE8F1A");
        } else if (i == 2) {
            parseColor = Color.parseColor("#FAB704");
        } else {
            parseColor = Color.parseColor("#8896B1");
        }
        textView.setTextColor(parseColor);
        textView.setText((i + 1) + "");
        textView2.setText(rankWordBean.keyword);
        findViewById.setOnClickListener(new a(rankWordBean, i));
        OnRankWordListener onRankWordListener = this.e;
        if (onRankWordListener != null) {
            onRankWordListener.onRankWordExpose(findViewById, rankWordBean, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SearchRankWordRes searchRankWordRes) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "422028668")) {
            ipChange.ipc$dispatch("422028668", new Object[]{this, searchRankWordRes});
        } else if (searchRankWordRes != null && !cb2.d(searchRankWordRes.searchRankingList)) {
            this.a.setVisibility(0);
            this.c.setText(searchRankWordRes.name);
            this.d.setText(searchRankWordRes.description);
            List<RankWordBean> list = searchRankWordRes.searchRankingList;
            this.b.removeAllViews();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View inflate = LayoutInflater.from(mu0.a()).inflate(R$layout.item_search_rank_word, this.b, false);
                c(list.get(i), i, inflate);
                this.b.addView(inflate);
            }
        } else {
            this.a.setVisibility(8);
        }
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "202337592")) {
            ipChange.ipc$dispatch("202337592", new Object[]{this});
        } else {
            new RankingListMtopRequest().request(new DMMtopRequestListener<SearchRankWordRes>(SearchRankWordRes.class) { // from class: cn.damai.search.v2.tool.RankWordManager.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1919947688")) {
                        ipChange2.ipc$dispatch("1919947688", new Object[]{this, str, str2});
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(SearchRankWordRes searchRankWordRes) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1081530910")) {
                        ipChange2.ipc$dispatch("-1081530910", new Object[]{this, searchRankWordRes});
                    } else {
                        RankWordManager.this.e(searchRankWordRes);
                    }
                }
            });
        }
    }
}
