package cn.damai.tetris.component.livehouse.mvp;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.livehouse.bean.ArtistItemBean;
import cn.damai.tetris.component.livehouse.bean.ArtistList;
import cn.damai.tetris.component.livehouse.mvp.ArtistListContract;
import cn.damai.tetris.component.livehouse.viewholder.ArtistProMutiRecycleAdapter;
import cn.damai.tetris.component.livehouse.viewholder.ArtistRecycleAdapter;
import cn.damai.tetris.component.online.bean.OnlineTitleBean;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.l62;
import tb.lo2;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistListView extends AbsView<ArtistListContract.Presenter> implements ArtistListContract.View<ArtistListContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isfirst;
    private final ArtistRecycleAdapter mAdapter;
    private RecyclerView mContentRecycler;
    private final int mEdgeContentPadding;
    private final int mEdgePadding;
    private ArtistProMutiRecycleAdapter mMutiAdapter;
    private final lo2 mPanel;
    private int mPos;
    private ArtistListContract.Presenter mPresenter;
    private final int mRightSize;
    private String mTitleName;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements OnItemBindListener<ArtistItemBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, ArtistItemBean artistItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "787625263")) {
                ipChange.ipc$dispatch("787625263", new Object[]{this, view, artistItemBean, Integer.valueOf(i)});
                return;
            }
            ArtistListView artistListView = ArtistListView.this;
            artistListView.mPresenter = artistListView.getPresenter();
            if (ArtistListView.this.mMutiAdapter != null) {
                ArtistListView.this.mMutiAdapter.h(ArtistListView.this.mPresenter);
            }
            ArtistListView.this.getPresenter().onArtistAvatarItemViewExpose(view, artistItemBean, i, ArtistListView.this.mTitleName);
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(ArtistItemBean artistItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2032907034")) {
                ipChange.ipc$dispatch("2032907034", new Object[]{this, artistItemBean, Integer.valueOf(i)});
                return;
            }
            ArtistListView artistListView = ArtistListView.this;
            ArtistListView.this.getPresenter().onArtistAvatarItemViewClick(artistListView, artistItemBean, i, artistListView.mTitleName);
            ArtistListView.this.mMutiAdapter.g(artistItemBean.content, i, artistItemBean.artistVo.damaiId);
            ArtistListView.this.mContentRecycler.smoothScrollToPosition(0);
        }
    }

    public ArtistListView(View view) {
        super(view);
        this.isfirst = true;
        this.mRightSize = l62.a(mu0.a(), 12.0f);
        this.mEdgePadding = l62.a(mu0.a(), 21.0f);
        this.mEdgeContentPadding = l62.a(mu0.a(), 12.0f);
        this.mPanel = new lo2(view);
        this.mContentRecycler = (RecyclerView) view.findViewById(R$id.livehouse_artist_content_recycler);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.livehouse_artist_recycler);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.tetris.component.livehouse.mvp.ArtistListView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView2, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2055981041")) {
                    ipChange.ipc$dispatch("2055981041", new Object[]{this, rect, view2, recyclerView2, state});
                    return;
                }
                int childAdapterPosition = recyclerView2.getChildAdapterPosition(view2);
                if (childAdapterPosition == 0) {
                    rect.left = ArtistListView.this.mEdgePadding;
                } else {
                    rect.left = 0;
                }
                if (childAdapterPosition == ArtistListView.this.mAdapter.getItemCount() - 1) {
                    rect.right = ArtistListView.this.mEdgePadding;
                } else {
                    rect.right = ArtistListView.this.mRightSize;
                }
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(mu0.a(), 0, false));
        ArtistRecycleAdapter artistRecycleAdapter = new ArtistRecycleAdapter(new a());
        this.mAdapter = artistRecycleAdapter;
        recyclerView.setAdapter(artistRecycleAdapter);
        this.mMutiAdapter = new ArtistProMutiRecycleAdapter(mu0.a(), this.mPresenter, this.mTitleName);
        this.mContentRecycler.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.tetris.component.livehouse.mvp.ArtistListView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView2, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "286509427")) {
                    ipChange.ipc$dispatch("286509427", new Object[]{this, rect, view2, recyclerView2, state});
                    return;
                }
                int childAdapterPosition = recyclerView2.getChildAdapterPosition(view2);
                if (childAdapterPosition == 0) {
                    rect.left = ArtistListView.this.mEdgeContentPadding;
                } else {
                    rect.left = 0;
                }
                if (childAdapterPosition == ArtistListView.this.mAdapter.getItemCount() - 1) {
                    rect.right = ArtistListView.this.mEdgeContentPadding;
                } else {
                    rect.right = ArtistListView.this.mRightSize;
                }
            }
        });
        this.mContentRecycler.setLayoutManager(new LinearLayoutManager(mu0.a(), 0, false));
        this.mContentRecycler.setAdapter(this.mMutiAdapter);
    }

    public void onCityFreshChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1796929665")) {
            ipChange.ipc$dispatch("-1796929665", new Object[]{this});
        } else {
            this.isfirst = true;
        }
    }

    @Override // cn.damai.tetris.component.livehouse.mvp.ArtistListContract.View
    public void setData(ArtistList artistList, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "967951693")) {
            ipChange.ipc$dispatch("967951693", new Object[]{this, artistList, Integer.valueOf(i)});
        } else if (artistList == null) {
        } else {
            if (this.isfirst) {
                this.mPos = i;
                this.mAdapter.d(artistList.result);
                OnlineTitleBean onlineTitleBean = artistList.mTitleBean;
                if (onlineTitleBean != null) {
                    this.mPanel.b(true);
                    String str = onlineTitleBean.title;
                    this.mTitleName = str;
                    this.mPanel.a(str);
                }
                List<ArtistItemBean> list = artistList.result;
                if (list != null) {
                    this.mMutiAdapter.f(list.get(0).content, artistList.result.get(0).artistVo.damaiId);
                }
            }
            this.isfirst = false;
        }
    }
}
