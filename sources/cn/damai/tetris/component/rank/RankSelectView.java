package cn.damai.tetris.component.rank;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.rank.RankSelectContract;
import cn.damai.tetris.component.rank.adapter.RankSelectAdapter;
import cn.damai.tetris.component.rank.bean.RankSelectBean;
import cn.damai.tetris.component.rank.bean.RankSelectItemBean;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.h62;
import tb.l62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RankSelectView extends AbsView<RankSelectPresenter> implements RankSelectContract.View<RankSelectPresenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final RankSelectAdapter mAdapter;
    @NotNull
    private final TUrlImageView mBack;
    private final int mEdgePadding;
    private int mPos;
    private final int mRightSize;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.rank.RankSelectView$a */
    /* loaded from: classes7.dex */
    public static final class C1949a implements OnItemBindListener<RankSelectItemBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1949a() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(@Nullable View view, @NotNull RankSelectItemBean rankSelectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1876557740")) {
                ipChange.ipc$dispatch("1876557740", new Object[]{this, view, rankSelectItemBean, Integer.valueOf(i)});
                return;
            }
            b41.i(rankSelectItemBean, "bean");
            RankSelectPresenter presenter = RankSelectView.this.getPresenter();
            b41.f(presenter);
            presenter.expose(view, rankSelectItemBean, i);
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(@Nullable RankSelectItemBean rankSelectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1865292897")) {
                ipChange.ipc$dispatch("1865292897", new Object[]{this, rankSelectItemBean, Integer.valueOf(i)});
                return;
            }
            RankSelectPresenter presenter = RankSelectView.this.getPresenter();
            b41.f(presenter);
            presenter.itemClick(RankSelectView.this, rankSelectItemBean, i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankSelectView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.mRightSize = l62.a(mu0.a(), 6.0f);
        this.mEdgePadding = l62.a(mu0.a(), 12.0f);
        View findViewById = view.findViewById(R$id.rank_select_recycler);
        b41.h(findViewById, "view.findViewById(R.id.rank_select_recycler)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(R$id.rank_bg_img);
        b41.h(findViewById2, "view.findViewById(R.id.rank_bg_img)");
        TUrlImageView tUrlImageView = (TUrlImageView) findViewById2;
        this.mBack = tUrlImageView;
        tUrlImageView.setImageUrl(h62.p("bg_rank_square_apng.png"));
        recyclerView.setLayoutManager(new LinearLayoutManager(mu0.a(), 0, false));
        RankSelectAdapter rankSelectAdapter = new RankSelectAdapter(new C1949a());
        this.mAdapter = rankSelectAdapter;
        recyclerView.setAdapter(rankSelectAdapter);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.tetris.component.rank.RankSelectView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect rect, @NotNull View view2, @NotNull RecyclerView recyclerView2, @NotNull RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1437442051")) {
                    ipChange.ipc$dispatch("1437442051", new Object[]{this, rect, view2, recyclerView2, state});
                    return;
                }
                b41.i(rect, "outRect");
                b41.i(view2, "view");
                b41.i(recyclerView2, "parent");
                b41.i(state, "state");
                int childAdapterPosition = recyclerView2.getChildAdapterPosition(view2);
                if (childAdapterPosition == 0) {
                    rect.left = RankSelectView.this.mEdgePadding;
                } else {
                    rect.left = 0;
                }
                if (childAdapterPosition == RankSelectView.this.mAdapter.getItemCount() - 1) {
                    rect.right = RankSelectView.this.mEdgePadding;
                } else {
                    rect.right = RankSelectView.this.mRightSize;
                }
            }
        });
    }

    @Override // cn.damai.tetris.component.rank.RankSelectContract.View
    public void setData(@Nullable RankSelectBean rankSelectBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1867434953")) {
            ipChange.ipc$dispatch("-1867434953", new Object[]{this, rankSelectBean, Integer.valueOf(i)});
        } else if (rankSelectBean == null) {
        } else {
            this.mPos = i;
            this.mAdapter.d(rankSelectBean.result);
        }
    }
}
