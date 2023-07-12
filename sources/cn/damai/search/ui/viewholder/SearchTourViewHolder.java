package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.bean.SearchTourBean;
import cn.damai.commonbusiness.search.bean.SearchTourItem;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.bean.SearchTourUT;
import cn.damai.search.helper.SearchHelper;
import cn.damai.search.ui.adapter.SearchTourItemAdapter;
import cn.damai.search.ui.customview.TextBannerView;
import cn.damai.search.ui.decoration.GridItemDecoration;
import com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder;
import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.b82;
import tb.m62;
import tb.wh2;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchTourViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    public RecyclerView b;
    public SearchTourItemAdapter c;
    public View d;
    public LinearLayout e;
    private TextView f;
    private Context g;
    private boolean h;
    private ProjectItemViewHolder i;
    View.OnClickListener j;
    private View k;
    private TextBannerView l;
    private String m;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(SearchTourViewHolder searchTourViewHolder) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "485670771")) {
                ipChange.ipc$dispatch("485670771", new Object[]{this, view});
                return;
            }
            ProjectItemBean projectItemBean = (ProjectItemBean) view.getTag();
            if (projectItemBean != null) {
                SearchTourUT searchTourUT = new SearchTourUT();
                searchTourUT.projectId = projectItemBean.id;
                searchTourUT.schema = projectItemBean.schema;
                searchTourUT.name = projectItemBean.name;
                searchTourUT.verticalPic = projectItemBean.verticalPic;
                searchTourUT.index = 0;
                xr.c(SearchHelper.TOUR_JUMP_PROJECT_PAGE, searchTourUT);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1698006156")) {
                ipChange.ipc$dispatch("-1698006156", new Object[]{this, view});
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue < 0) {
                return;
            }
            c.e().x(b82.C().M(SearchTourViewHolder.this.m));
            SearchTourViewHolder searchTourViewHolder = SearchTourViewHolder.this;
            searchTourViewHolder.h = !searchTourViewHolder.h;
            SearchTourViewHolder searchTourViewHolder2 = SearchTourViewHolder.this;
            searchTourViewHolder2.c.b(searchTourViewHolder2.h);
            SearchTourItemAdapter searchTourItemAdapter = SearchTourViewHolder.this.c;
            if (searchTourItemAdapter != null) {
                searchTourItemAdapter.notifyDataSetChanged();
            }
            SearchTourViewHolder searchTourViewHolder3 = SearchTourViewHolder.this;
            searchTourViewHolder3.n(searchTourViewHolder3.h, intValue > 6);
        }
    }

    public SearchTourViewHolder(Context context, LayoutInflater layoutInflater, Daojishi daojishi) {
        super(layoutInflater.inflate(R$layout.search_list_tour, (ViewGroup) null));
        this.j = new a(this);
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.g = context;
        m62.a(context, 9.0f);
        m62.a(context, 1.0f);
        this.h = false;
        j(this.itemView);
        h(context, layoutInflater, daojishi);
        i(this.itemView);
        g(this.itemView);
    }

    private void g(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "763766791")) {
            ipChange.ipc$dispatch("763766791", new Object[]{this, view});
            return;
        }
        this.d = view.findViewById(R$id.ll_more_tour_line);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.ll_more_tour);
        this.e = linearLayout;
        linearLayout.setVisibility(8);
        this.d.setVisibility(8);
        this.f = (TextView) view.findViewById(R$id.tv_more_title);
        this.e.setOnClickListener(new b());
    }

    private void h(Context context, LayoutInflater layoutInflater, Daojishi daojishi) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1583598015")) {
            ipChange.ipc$dispatch("1583598015", new Object[]{this, context, layoutInflater, daojishi});
            return;
        }
        this.i = new ProjectItemViewHolder(context, layoutInflater);
        ((ViewGroup) this.itemView.findViewById(R$id.project_container)).addView(this.i.itemView);
        this.i.itemView.setOnClickListener(this.j);
        this.i.itemView.setBackgroundColor(0);
        this.i.u(daojishi);
    }

    private void j(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "520625128")) {
            ipChange.ipc$dispatch("520625128", new Object[]{this, view});
            return;
        }
        this.k = view.findViewById(R$id.trends_container);
        this.l = (TextBannerView) view.findViewById(R$id.trends_view);
    }

    private void k(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "357343550")) {
            ipChange.ipc$dispatch("357343550", new Object[]{this, projectItemBean});
        } else if (projectItemBean == null) {
        } else {
            this.i.l(projectItemBean, BricksProjectViewHolder.PageType.SEARCH_PAGE);
            this.i.itemView.setTag(projectItemBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1879469")) {
            ipChange.ipc$dispatch("1879469", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else if (z2) {
            this.e.setVisibility(0);
            this.d.setVisibility(0);
            if (z) {
                this.f.setText("收起");
            } else {
                this.f.setText("展开全部巡演城市");
            }
        } else {
            this.e.setVisibility(8);
            this.d.setVisibility(8);
        }
    }

    public void e(SearchTourBean searchTourBean, String str, List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1184502874")) {
            ipChange.ipc$dispatch("1184502874", new Object[]{this, searchTourBean, str, list});
            return;
        }
        this.m = str;
        l(list);
        k(searchTourBean.topItem);
        f(searchTourBean.title, searchTourBean.items);
    }

    public void f(String str, List<SearchTourItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-202676124")) {
            ipChange.ipc$dispatch("-202676124", new Object[]{this, str, list});
            return;
        }
        int e = wh2.e(list);
        if (e > 0) {
            m(str);
            this.b.setVisibility(0);
            this.c.b(this.h);
            this.c.a(list);
            SearchTourItemAdapter searchTourItemAdapter = this.c;
            if (searchTourItemAdapter != null) {
                searchTourItemAdapter.notifyDataSetChanged();
            }
            this.e.setTag(Integer.valueOf(e));
            n(this.h, e > 6);
            return;
        }
        this.e.setTag(0);
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.e.setVisibility(8);
        this.d.setVisibility(8);
    }

    public void i(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305149622")) {
            ipChange.ipc$dispatch("-305149622", new Object[]{this, view});
            return;
        }
        this.a = (TextView) view.findViewById(R$id.tv_tour_title);
        this.c = new SearchTourItemAdapter(this.g);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.g, 3, 1, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.irc);
        this.b = recyclerView;
        recyclerView.setLayoutManager(gridLayoutManager);
        this.b.setAdapter(this.c);
        if (this.b.getItemDecorationCount() == 0) {
            this.b.addItemDecoration(new GridItemDecoration.b(this.g).c(1.0f).d(1.0f).b(Color.parseColor("#1A000000")).a());
        }
    }

    public void l(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "263291498")) {
            ipChange.ipc$dispatch("263291498", new Object[]{this, list});
        } else if (list != null && !list.isEmpty()) {
            this.k.setVisibility(0);
            this.l.setDatas(list);
        } else {
            this.k.setVisibility(8);
        }
    }

    public void m(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2084416673")) {
            ipChange.ipc$dispatch("2084416673", new Object[]{this, str});
        } else if (str != null && !TextUtils.isEmpty(str.trim())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            try {
                String trim = str.trim();
                String str2 = "";
                boolean z = false;
                int i = -1;
                for (int i2 = 0; i2 < trim.length(); i2++) {
                    if (trim.charAt(i2) >= '0' && trim.charAt(i2) <= '9') {
                        str2 = str2 + trim.charAt(i2);
                        if (i == -1) {
                            i = i2;
                        }
                        z = true;
                    } else if (z) {
                        break;
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.g, R$color.main_color)), i, str2.length() + i, 18);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            this.a.setText(spannableStringBuilder);
            this.a.setVisibility(0);
        }
    }
}
