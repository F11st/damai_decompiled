package cn.damai.discover.content.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.baseview.RCRelativeLayoutView;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.discover.content.bean.ContentTour;
import cn.damai.discover.content.ui.decoration.GridItemDecoration;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.qd2;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMTourView extends LinearLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<ContentTour.ContentRelatedTourListItem> dataSet;
    private boolean isShowAll;
    private OnTourViewListener listener;
    private TourProjectListAdapter tourListAdapter;
    private RecyclerView tourOtherCityList;
    private TextView tourOtherCityTip;
    private View tourOtherCityTopLine;
    private ProjectItemViewHolder tourProject;
    private RCRelativeLayoutView tourProjectContainer;
    private TextView tourShowAll;
    private View tourShowAllTopLine;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnTourViewListener {
        void onTourCityClick(View view, String str, int i);

        void onTourCityExposure(View view, String str, int i);

        void onTourProjectClick(View view, String str);

        void onTourProjectExposure(View view, String str);

        void onTourShowAllClick(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class TourProjectListAdapter extends RecyclerView.Adapter<TourProjectListViewHolder> {
        private static transient /* synthetic */ IpChange $ipChange;

        TourProjectListAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull TourProjectListViewHolder tourProjectListViewHolder, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-723882102")) {
                ipChange.ipc$dispatch("-723882102", new Object[]{this, tourProjectListViewHolder, Integer.valueOf(i)});
            } else {
                tourProjectListViewHolder.a(i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: b */
        public TourProjectListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1443961620") ? (TourProjectListViewHolder) ipChange.ipc$dispatch("-1443961620", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new TourProjectListViewHolder();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-839049593")) {
                return ((Integer) ipChange.ipc$dispatch("-839049593", new Object[]{this})).intValue();
            }
            int e = wh2.e(DMTourView.this.dataSet);
            if (!DMTourView.this.isShowAll && e > 6) {
                return 6;
            }
            return e;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class TourProjectListViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private TextView b;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.discover.content.view.DMTourView$TourProjectListViewHolder$a */
        /* loaded from: classes14.dex */
        public class View$OnClickListenerC1014a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ContentTour.ContentRelatedTourListItem a;
            final /* synthetic */ int b;

            View$OnClickListenerC1014a(ContentTour.ContentRelatedTourListItem contentRelatedTourListItem, int i) {
                this.a = contentRelatedTourListItem;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-835626890")) {
                    ipChange.ipc$dispatch("-835626890", new Object[]{this, view});
                    return;
                }
                if (DMTourView.this.listener != null) {
                    DMTourView.this.listener.onTourCityClick(view, this.a.itemId, this.b);
                }
                Bundle bundle = new Bundle();
                bundle.putString("id", this.a.itemId);
                qd2.a(DMTourView.this.getContext(), this.a.schema, bundle);
            }
        }

        public TourProjectListViewHolder() {
            super(LayoutInflater.from(DMTourView.this.getContext()).inflate(R$layout.live_content_detail_tour_list_item, (ViewGroup) null));
            this.a = (TextView) this.itemView.findViewById(R$id.live_content_detail_tour_list_item_city_name);
            this.b = (TextView) this.itemView.findViewById(R$id.live_content_detail_tour_list_item_time);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void a(int i) {
            ContentTour.ContentRelatedTourListItem contentRelatedTourListItem;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1456945336")) {
                ipChange.ipc$dispatch("1456945336", new Object[]{this, Integer.valueOf(i)});
            } else if (i < wh2.e(DMTourView.this.dataSet) && (contentRelatedTourListItem = (ContentTour.ContentRelatedTourListItem) DMTourView.this.dataSet.get(i)) != null) {
                if (DMTourView.this.listener != null) {
                    DMTourView.this.listener.onTourCityExposure(this.itemView, contentRelatedTourListItem.itemId, i);
                }
                this.a.setText(contentRelatedTourListItem.cityName);
                this.b.setText(contentRelatedTourListItem.showTime);
                this.itemView.setOnClickListener(new View$OnClickListenerC1014a(contentRelatedTourListItem, i));
            }
        }
    }

    public DMTourView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2103174377")) {
            ipChange.ipc$dispatch("-2103174377", new Object[]{this});
            return;
        }
        LinearLayout.inflate(getContext(), R$layout.widget_tour_view, this);
        this.tourProjectContainer = (RCRelativeLayoutView) findViewById(R$id.tour_current_city_project);
        ProjectItemViewHolder projectItemViewHolder = new ProjectItemViewHolder(getContext(), LayoutInflater.from(getContext()));
        this.tourProject = projectItemViewHolder;
        this.tourProjectContainer.addView(projectItemViewHolder.itemView);
        this.tourProject.itemView.setBackgroundColor(0);
        this.tourProject.itemView.setOnClickListener(this);
        this.tourOtherCityTip = (TextView) findViewById(R$id.tour_other_city_tip);
        this.tourOtherCityTopLine = findViewById(R$id.tour_other_city_list_top_line);
        this.tourOtherCityList = (RecyclerView) findViewById(R$id.tour_other_city_list);
        this.tourOtherCityList.setLayoutManager(new GridLayoutManager(getContext(), 3));
        int a = t60.a(getContext(), 0.5f);
        this.tourOtherCityList.addItemDecoration(new GridItemDecoration(a, a, Color.parseColor("#1A000000")));
        TourProjectListAdapter tourProjectListAdapter = new TourProjectListAdapter();
        this.tourListAdapter = tourProjectListAdapter;
        this.tourOtherCityList.setAdapter(tourProjectListAdapter);
        this.tourShowAllTopLine = findViewById(R$id.tour_other_city_show_all_top_line);
        TextView textView = (TextView) findViewById(R$id.tour_other_city_show_all);
        this.tourShowAll = textView;
        textView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "860704061")) {
            ipChange.ipc$dispatch("860704061", new Object[]{this, view});
        } else if (view.getId() == R$id.tour_other_city_show_all) {
            boolean z = !this.isShowAll;
            this.isShowAll = z;
            this.tourShowAll.setText(z ? "收起" : "展开全部演出城市");
            this.tourListAdapter.notifyDataSetChanged();
            OnTourViewListener onTourViewListener = this.listener;
            if (onTourViewListener != null) {
                onTourViewListener.onTourShowAllClick(this.isShowAll);
            }
        } else {
            ProjectItemBean projectItemBean = (ProjectItemBean) view.getTag();
            if (projectItemBean != null) {
                Bundle bundle = new Bundle();
                bundle.putString("id", projectItemBean.id);
                bundle.putString("projectImage", projectItemBean.verticalPic);
                qd2.a(getContext(), projectItemBean.schema, bundle);
            }
            OnTourViewListener onTourViewListener2 = this.listener;
            if (onTourViewListener2 != null) {
                onTourViewListener2.onTourProjectClick(view, projectItemBean.id);
            }
        }
    }

    public void setOnTourViewListener(OnTourViewListener onTourViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-557243690")) {
            ipChange.ipc$dispatch("-557243690", new Object[]{this, onTourViewListener});
        } else {
            this.listener = onTourViewListener;
        }
    }

    public void setOtherCityList(ArrayList<ContentTour.ContentRelatedTourListItem> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1090347339")) {
            ipChange.ipc$dispatch("-1090347339", new Object[]{this, arrayList});
            return;
        }
        this.dataSet = arrayList;
        int e = wh2.e(arrayList);
        TextView textView = this.tourOtherCityTip;
        textView.setText(Html.fromHtml("其余<font color='#ff2869'>" + e + "</font>个演出城市"));
        this.tourOtherCityTip.setVisibility(e > 0 ? 0 : 8);
        this.tourOtherCityTopLine.setVisibility(e > 0 ? 0 : 8);
        this.tourShowAll.setVisibility(e > 6 ? 0 : 8);
        this.tourShowAllTopLine.setVisibility(e <= 6 ? 8 : 0);
        this.tourListAdapter.notifyDataSetChanged();
    }

    public void setProjectInfo(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1157283809")) {
            ipChange.ipc$dispatch("-1157283809", new Object[]{this, projectItemBean});
            return;
        }
        ProjectItemViewHolder projectItemViewHolder = this.tourProject;
        if (projectItemViewHolder == null || projectItemBean == null) {
            return;
        }
        projectItemViewHolder.k(projectItemBean);
        View view = this.tourProject.itemView;
        if (view != null) {
            view.setTag(projectItemBean);
        }
        OnTourViewListener onTourViewListener = this.listener;
        if (onTourViewListener != null) {
            onTourViewListener.onTourProjectExposure(this.tourProject.itemView, projectItemBean.id);
        }
    }

    public DMTourView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMTourView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dataSet = new ArrayList<>();
        setOrientation(1);
        initView();
    }
}
