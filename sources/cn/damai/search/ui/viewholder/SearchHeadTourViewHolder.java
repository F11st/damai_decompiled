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
import androidx.annotation.Nullable;
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
public class SearchHeadTourViewHolder extends RecyclerView.ViewHolder {
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

        a(SearchHeadTourViewHolder searchHeadTourViewHolder) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "782186483")) {
                ipChange.ipc$dispatch("782186483", new Object[]{this, view});
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
            if (AndroidInstantRuntime.support(ipChange, "-1401490444")) {
                ipChange.ipc$dispatch("-1401490444", new Object[]{this, view});
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue < 0) {
                return;
            }
            c.e().x(b82.C().M(SearchHeadTourViewHolder.this.m));
            SearchHeadTourViewHolder searchHeadTourViewHolder = SearchHeadTourViewHolder.this;
            searchHeadTourViewHolder.h = !searchHeadTourViewHolder.h;
            SearchHeadTourViewHolder searchHeadTourViewHolder2 = SearchHeadTourViewHolder.this;
            searchHeadTourViewHolder2.c.b(searchHeadTourViewHolder2.h);
            SearchTourItemAdapter searchTourItemAdapter = SearchHeadTourViewHolder.this.c;
            if (searchTourItemAdapter != null) {
                searchTourItemAdapter.notifyDataSetChanged();
            }
            SearchHeadTourViewHolder searchHeadTourViewHolder3 = SearchHeadTourViewHolder.this;
            searchHeadTourViewHolder3.n(searchHeadTourViewHolder3.h, intValue > 6);
        }
    }

    public SearchHeadTourViewHolder(Context context, View view, Daojishi daojishi) {
        super(view);
        this.j = new a(this);
        this.g = context;
        m62.a(context, 9.0f);
        m62.a(context, 1.0f);
        this.h = false;
        j(this.itemView);
        h(context, LayoutInflater.from(context), daojishi);
        i(this.itemView);
        g(this.itemView);
    }

    private void g(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-484384889")) {
            ipChange.ipc$dispatch("-484384889", new Object[]{this, view});
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
        if (AndroidInstantRuntime.support(ipChange, "1225728575")) {
            ipChange.ipc$dispatch("1225728575", new Object[]{this, context, layoutInflater, daojishi});
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
        if (AndroidInstantRuntime.support(ipChange, "-657263768")) {
            ipChange.ipc$dispatch("-657263768", new Object[]{this, view});
            return;
        }
        this.k = view.findViewById(R$id.trends_container);
        this.l = (TextBannerView) view.findViewById(R$id.trends_view);
    }

    private void k(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1541236546")) {
            ipChange.ipc$dispatch("-1541236546", new Object[]{this, projectItemBean});
        } else if (projectItemBean == null) {
        } else {
            this.i.l(projectItemBean, BricksProjectViewHolder.PageType.SEARCH_PAGE);
            this.i.itemView.setTag(projectItemBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705384403")) {
            ipChange.ipc$dispatch("-1705384403", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
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

    public void e(@Nullable SearchTourBean searchTourBean, String str, List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1575545818")) {
            ipChange.ipc$dispatch("1575545818", new Object[]{this, searchTourBean, str, list});
        } else if (searchTourBean == null) {
            this.itemView.setVisibility(8);
        } else {
            this.itemView.setVisibility(0);
            this.m = str;
            l(list);
            k(searchTourBean.topItem);
            f(searchTourBean.title, searchTourBean.items);
        }
    }

    public void f(String str, List<SearchTourItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-669564956")) {
            ipChange.ipc$dispatch("-669564956", new Object[]{this, str, list});
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
        if (AndroidInstantRuntime.support(ipChange, "-1553301302")) {
            ipChange.ipc$dispatch("-1553301302", new Object[]{this, view});
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
        if (AndroidInstantRuntime.support(ipChange, "992090858")) {
            ipChange.ipc$dispatch("992090858", new Object[]{this, list});
        } else if (list != null && !list.isEmpty()) {
            this.k.setVisibility(0);
            this.l.setDatas(list);
        } else {
            this.k.setVisibility(8);
        }
    }

    public void m(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-726792927")) {
            ipChange.ipc$dispatch("-726792927", new Object[]{this, str});
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
