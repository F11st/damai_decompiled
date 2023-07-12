package com.alibaba.pictures.bricks.component.project.tour;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.search.bean.SearchTourBean;
import cn.damai.commonbusiness.search.bean.SearchTourItem;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder;
import com.alibaba.pictures.bricks.component.project.bean.Daojishi;
import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;
import com.alibaba.pictures.bricks.component.project.tour.GridItemBlankDecoration;
import com.alibaba.pictures.bricks.component.project.tour.TourContract;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import java.util.List;
import tb.n91;
import tb.pd2;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TourView extends AbsView<IItem<ItemValue>, TourContract.Model<IItem<ItemValue>>, TourContract.Presenter<IItem<ItemValue>, TourContract.Model<IItem<ItemValue>>>> implements TourContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    public Daojishi mDaojishi;
    private boolean mExpandState;
    public LinearLayout mMoreTourLayout;
    public View mMoreTourLine;
    private BricksProjectViewHolder mProjectItemViewHolder;
    public RecyclerView mRecyclerView;
    public SearchTourItemAdapter mTourAdapter;
    private TextView mTvMoreText;
    public FrameLayout project_container;
    private float sepWidth;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements UserTrackInterface {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.alibaba.pictures.bricks.component.project.tour.UserTrackInterface
        public void userTrackClick(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-796140241")) {
                ipChange.ipc$dispatch("-796140241", new Object[]{this, str, Integer.valueOf(i)});
            } else {
                ((TourContract.Presenter) TourView.this.presenter).tourCityUserClick(str, i);
            }
        }

        @Override // com.alibaba.pictures.bricks.component.project.tour.UserTrackInterface
        public void userTrackExpose(View view, String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-15505893")) {
                ipChange.ipc$dispatch("-15505893", new Object[]{this, view, str, Integer.valueOf(i)});
            } else {
                ((TourContract.Presenter) TourView.this.presenter).tourCityUserExpose(view, str, i);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "591286692")) {
                ipChange.ipc$dispatch("591286692", new Object[]{this, view});
            } else {
                ((TourContract.Presenter) TourView.this.presenter).dispatchAction();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectItemBean a;

        c(ProjectItemBean projectItemBean) {
            this.a = projectItemBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1592390235")) {
                ipChange.ipc$dispatch("-1592390235", new Object[]{this, view});
                return;
            }
            ((TourContract.Presenter) TourView.this.presenter).projectUserClick();
            Context context = TourView.this.mContext;
            ProjectItemBean projectItemBean = this.a;
            pd2.a(context, projectItemBean.schema, projectItemBean.id, projectItemBean.name, projectItemBean.verticalPic);
        }
    }

    public TourView(View view) {
        super(view);
        this.mExpandState = true;
        this.mDaojishi = new Daojishi(true);
        this.sepWidth = 18.0f;
        Context context = view.getContext();
        this.mContext = context;
        this.sepWidth = s60.INSTANCE.b(context, 9);
        initProjectView(view.getContext(), view, LayoutInflater.from(this.mContext));
        initTourView(view);
        initMoreView(view);
    }

    private void handlerTourData(List<SearchTourItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "633312938")) {
            ipChange.ipc$dispatch("633312938", new Object[]{this, list});
            return;
        }
        int a2 = n91.a(list);
        if (a2 > 0) {
            this.mRecyclerView.setVisibility(0);
            SearchTourItemAdapter searchTourItemAdapter = this.mTourAdapter;
            if (searchTourItemAdapter != null) {
                searchTourItemAdapter.f(this.mExpandState);
                this.mTourAdapter.d(list);
                this.mTourAdapter.notifyDataSetChanged();
            }
            updateMoreData(this.mExpandState, a2, 6);
            return;
        }
        this.mRecyclerView.setVisibility(8);
        this.mMoreTourLayout.setVisibility(8);
        this.mMoreTourLine.setVisibility(8);
    }

    private void initMoreView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1301308375")) {
            ipChange.ipc$dispatch("1301308375", new Object[]{this, view});
            return;
        }
        this.mMoreTourLine = view.findViewById(R$id.ll_more_tour_line);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.ll_more_tour);
        this.mMoreTourLayout = linearLayout;
        linearLayout.setVisibility(8);
        this.mMoreTourLine.setVisibility(8);
        this.mTvMoreText = (TextView) view.findViewById(R$id.tv_more_title);
        this.mMoreTourLayout.setOnClickListener(new b());
    }

    private void initProjectView(Context context, View view, LayoutInflater layoutInflater) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "884359777")) {
            ipChange.ipc$dispatch("884359777", new Object[]{this, context, view, layoutInflater});
            return;
        }
        this.mProjectItemViewHolder = new BricksProjectViewHolder(context, layoutInflater);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.project_container);
        this.project_container = frameLayout;
        frameLayout.addView(this.mProjectItemViewHolder.itemView);
        this.mProjectItemViewHolder.itemView.setBackgroundColor(0);
        BricksProjectViewHolder bricksProjectViewHolder = this.mProjectItemViewHolder;
        s60 s60Var = s60.INSTANCE;
        bricksProjectViewHolder.x(s60Var.b(this.mContext, 102), s60Var.b(this.mContext, 135));
    }

    private void loadProjectData(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1794086158")) {
            ipChange.ipc$dispatch("1794086158", new Object[]{this, projectItemBean});
        } else if (projectItemBean == null) {
            this.project_container.setVisibility(8);
        } else {
            this.project_container.setVisibility(0);
            ((TourContract.Presenter) this.presenter).projectUserExpose();
            this.mProjectItemViewHolder.u(this.mDaojishi);
            this.mProjectItemViewHolder.l(projectItemBean, BricksProjectViewHolder.PageType.SEARCH_PAGE);
            this.mProjectItemViewHolder.itemView.setOnClickListener(new c(projectItemBean));
        }
    }

    private void updateMoreData(boolean z, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2029655945")) {
            ipChange.ipc$dispatch("-2029655945", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (i > i2 && !z) {
            ((TourContract.Presenter) this.presenter).moreUserExpose();
            this.mMoreTourLayout.setVisibility(0);
            this.mMoreTourLine.setVisibility(0);
            TextView textView = this.mTvMoreText;
            textView.setText("查看全部" + i + "个巡演城市");
        } else {
            this.mMoreTourLayout.setVisibility(8);
            this.mMoreTourLine.setVisibility(8);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.tour.TourContract.View
    public BricksProjectViewHolder getHolder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1746266776") ? (BricksProjectViewHolder) ipChange.ipc$dispatch("-1746266776", new Object[]{this}) : this.mProjectItemViewHolder;
    }

    @Override // com.alibaba.pictures.bricks.component.project.tour.TourContract.View
    public LinearLayout getMoreTourLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-328296657") ? (LinearLayout) ipChange.ipc$dispatch("-328296657", new Object[]{this}) : this.mMoreTourLayout;
    }

    @Override // com.alibaba.pictures.bricks.component.project.tour.TourContract.View
    public FrameLayout getProjectContainer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1876733778") ? (FrameLayout) ipChange.ipc$dispatch("1876733778", new Object[]{this}) : this.project_container;
    }

    @Override // com.alibaba.pictures.bricks.component.project.tour.TourContract.View
    public void handlerData(SearchTourBean searchTourBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1264141615")) {
            ipChange.ipc$dispatch("1264141615", new Object[]{this, searchTourBean});
            return;
        }
        loadProjectData(searchTourBean.topItem);
        handlerTourData(searchTourBean.items);
    }

    public void initTourView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "232391962")) {
            ipChange.ipc$dispatch("232391962", new Object[]{this, view});
            return;
        }
        this.mTourAdapter = new SearchTourItemAdapter(this.mContext);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.mContext, 3, 1, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.irc);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(gridLayoutManager);
        this.mRecyclerView.setAdapter(this.mTourAdapter);
        this.mTourAdapter.e(new a());
        if (this.mRecyclerView.getItemDecorationCount() == 0) {
            this.mRecyclerView.addItemDecoration(new GridItemBlankDecoration.b(this.mContext).c(this.sepWidth).d(this.sepWidth).b(Color.parseColor("#ffffff")).a());
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.tour.TourContract.View
    public void setCountDownServerTime(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1482080934")) {
            ipChange.ipc$dispatch("1482080934", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
        } else {
            this.mDaojishi.setServiceTimeAndDiff(j, j2);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.tour.TourContract.View
    public boolean setExpandState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1929903320")) {
            return ((Boolean) ipChange.ipc$dispatch("-1929903320", new Object[]{this, Boolean.valueOf(z)})).booleanValue();
        }
        this.mExpandState = z;
        return z;
    }
}
