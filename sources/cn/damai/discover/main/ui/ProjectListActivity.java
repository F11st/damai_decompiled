package cn.damai.discover.main.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.discover.main.ui.adapter.ProjectListAdapter;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.C9548pb;
import tb.kg2;
import tb.lm2;
import tb.s90;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ProjectListActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String DATA_LIST_KEY = "projectList";
    private List<ProjectItemBean> data;
    private DMIconFontTextView ivBack;
    private ProjectListAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private final lm2 mUt = new lm2();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.discover.main.ui.ProjectListActivity$a */
    /* loaded from: classes5.dex */
    public class C1026a implements ProjectListAdapter.ProjectClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1026a() {
        }

        @Override // cn.damai.discover.main.ui.adapter.ProjectListAdapter.ProjectClickListener
        public void onClick(int i, ProjectItemBean projectItemBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1307168420")) {
                ipChange.ipc$dispatch("1307168420", new Object[]{this, Integer.valueOf(i), projectItemBean});
                return;
            }
            s90.j(ProjectListActivity.this, projectItemBean);
            C9548pb.j(ProjectListActivity.this.mUt.A(i, projectItemBean.id, true));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.discover.main.ui.ProjectListActivity$b */
    /* loaded from: classes5.dex */
    public class C1027b implements ProjectListAdapter.Exposure {
        private static transient /* synthetic */ IpChange $ipChange;

        C1027b() {
        }

        @Override // cn.damai.discover.main.ui.adapter.ProjectListAdapter.Exposure
        public void exposureProject(View view, ProjectItemBean projectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1892003992")) {
                ipChange.ipc$dispatch("1892003992", new Object[]{this, view, projectItemBean, Integer.valueOf(i)});
            } else {
                ProjectListActivity.this.mUt.u(view, projectItemBean.id, i, true);
            }
        }
    }

    private void initExtra() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1609764905")) {
            ipChange.ipc$dispatch("-1609764905", new Object[]{this});
        } else if (getIntent() == null) {
            finish();
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
            } else {
                this.data = (List) extras.getSerializable(DATA_LIST_KEY);
            }
        }
    }

    private void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-980648257")) {
            ipChange.ipc$dispatch("-980648257", new Object[]{this});
            return;
        }
        this.mRecyclerView = (RecyclerView) findViewById(R$id.recycler_view);
        ProjectListAdapter projectListAdapter = new ProjectListAdapter(this, new C1026a());
        this.mAdapter = projectListAdapter;
        projectListAdapter.c(new C1027b());
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mAdapter.d(this.data);
    }

    private void initTitleStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1534987942")) {
            ipChange.ipc$dispatch("-1534987942", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.title_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = kg2.a(this);
                findViewById.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            return;
        }
        kg2.f(this, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1117888854")) {
            ipChange.ipc$dispatch("-1117888854", new Object[]{this});
            return;
        }
        this.bese_head_view.setVisibility(8);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) findViewById(R$id.title_left_icon);
        this.ivBack = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(this);
        initTitleStatusBar();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-348278245")) {
            ipChange.ipc$dispatch("-348278245", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1055876369") ? ((Integer) ipChange.ipc$dispatch("-1055876369", new Object[]{this})).intValue() : R$layout.activity_theme_project_list_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-234427796")) {
            ipChange.ipc$dispatch("-234427796", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1601433281")) {
            ipChange.ipc$dispatch("-1601433281", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-509220354")) {
            ipChange.ipc$dispatch("-509220354", new Object[]{this});
            return;
        }
        C0529c.e().K(this);
        initExtra();
        initTitleView();
        initRecyclerView();
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-478818204")) {
            ipChange.ipc$dispatch("-478818204", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view.getId() == R$id.title_left_icon) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1035703940")) {
            ipChange.ipc$dispatch("-1035703940", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(this.mUt.C());
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1216007389") ? (String) ipChange.ipc$dispatch("-1216007389", new Object[]{this}) : "";
    }
}
