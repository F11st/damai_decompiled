package cn.damai.mine.report;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.a;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.report.bean.ReportReason;
import cn.damai.mine.util.KeyBoardHelper;
import cn.damai.uikit.view.BottomActionDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ReportActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private RecyclerView recyclerView;
    private ReportViewModel reportViewModel;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-756007395")) {
                ipChange.ipc$dispatch("-756007395", new Object[]{this, view});
                return;
            }
            ReportActivity.this.reportViewModel.submitReport();
            cn.damai.common.user.c.e().x(new cn.damai.common.user.b().e("report", "bottom", "submit", new HashMap(), Boolean.FALSE));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class b implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1058621561")) {
                ipChange.ipc$dispatch("1058621561", new Object[]{this, editable});
            } else if (editable == null) {
            } else {
                if (editable.toString().length() <= 50) {
                    ReportActivity.this.reportViewModel.getReasonMemo().setValue(editable.toString());
                    return;
                }
                ReportActivity reportActivity = ReportActivity.this;
                int i = R$id.report_reason_memo;
                ((EditText) reportActivity.findViewById(i)).setText(editable.toString().substring(0, 50));
                ((EditText) ReportActivity.this.findViewById(i)).setSelection(50);
                ReportActivity.this.reportViewModel.getReasonMemo().setValue(editable.toString().substring(0, 50));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-792471702")) {
                ipChange.ipc$dispatch("-792471702", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-507129590")) {
                ipChange.ipc$dispatch("-507129590", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class c implements KeyBoardHelper.SoftKeyboardStateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ScrollView a;

        c(ScrollView scrollView) {
            this.a = scrollView;
        }

        @Override // cn.damai.mine.util.KeyBoardHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-796372430")) {
                ipChange.ipc$dispatch("-796372430", new Object[]{this});
                return;
            }
            ScrollView scrollView = this.a;
            if (scrollView == null) {
                return;
            }
            scrollView.fullScroll(33);
        }

        @Override // cn.damai.mine.util.KeyBoardHelper.SoftKeyboardStateListener
        public void onSoftKeyboardOpened(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-306542706")) {
                ipChange.ipc$dispatch("-306542706", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            ScrollView scrollView = this.a;
            if (scrollView == null) {
                return;
            }
            scrollView.fullScroll(130);
            ReportActivity.this.findViewById(R$id.report_reason_memo).setFocusable(true);
        }
    }

    private void addListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1737935131")) {
            ipChange.ipc$dispatch("1737935131", new Object[]{this});
            return;
        }
        findViewById(R$id.submit_report).setOnClickListener(new a());
        ((EditText) findViewById(R$id.report_reason_memo)).addTextChangedListener(new b());
        int i = R$id.report_root;
        new KeyBoardHelper(findViewById(i)).a(new c((ScrollView) findViewById(i)));
    }

    private void addObserver(final ReasonAdapter reasonAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1442814185")) {
            ipChange.ipc$dispatch("-1442814185", new Object[]{this, reasonAdapter});
            return;
        }
        this.reportViewModel.getReasons().observe(this, new Observer<List<ReportReason>>() { // from class: cn.damai.mine.report.ReportActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable List<ReportReason> list) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-419654273")) {
                    ipChange2.ipc$dispatch("-419654273", new Object[]{this, list});
                } else {
                    reasonAdapter.a(list);
                }
            }
        });
        this.reportViewModel.getSelectEvent().observe(this, new Observer<Void>() { // from class: cn.damai.mine.report.ReportActivity.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable Void r6) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "397737620")) {
                    ipChange2.ipc$dispatch("397737620", new Object[]{this, r6});
                    return;
                }
                ReportActivity reportActivity = ReportActivity.this;
                int i = R$id.submit_report;
                if (reportActivity.findViewById(i).isEnabled()) {
                    return;
                }
                ReportActivity.this.findViewById(i).setEnabled(true);
                ReportActivity.this.findViewById(i).setBackgroundResource(R$drawable.report_submit_bg);
            }
        });
        this.reportViewModel.getReasonMemo().observe(this, new Observer<String>() { // from class: cn.damai.mine.report.ReportActivity.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable String str) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1840434966")) {
                    ipChange2.ipc$dispatch("1840434966", new Object[]{this, str});
                    return;
                }
                int length = str.length();
                if (length == 50) {
                    ((TextView) ReportActivity.this.findViewById(R$id.report_reason_length)).setText(Html.fromHtml("<font color='#FF1268'>50</font>/50"));
                } else if (length < 50) {
                    ((TextView) ReportActivity.this.findViewById(R$id.report_reason_length)).setText(length + "/50");
                }
            }
        });
        this.reportViewModel.getToastEvent().observe(this, new Observer<String>() { // from class: cn.damai.mine.report.ReportActivity.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable String str) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1429040331")) {
                    ipChange2.ipc$dispatch("-1429040331", new Object[]{this, str});
                } else {
                    ToastUtil.i(str);
                }
            }
        });
        this.reportViewModel.getCloseEvent().observe(this, new Observer<Void>() { // from class: cn.damai.mine.report.ReportActivity.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable Void r5) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1337606607")) {
                    ipChange2.ipc$dispatch("-1337606607", new Object[]{this, r5});
                } else {
                    ReportActivity.this.finish();
                }
            }
        });
    }

    public static ReportViewModel obtainViewModel(FragmentActivity fragmentActivity) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1283405131") ? (ReportViewModel) ipChange.ipc$dispatch("-1283405131", new Object[]{fragmentActivity}) : (ReportViewModel) ViewModelProviders.of(fragmentActivity, ViewModelFactory.getInstance(fragmentActivity.getApplication())).get(ReportViewModel.class);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1130358888") ? ((Integer) ipChange.ipc$dispatch("1130358888", new Object[]{this})).intValue() : R$layout.activity_report;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-22829835")) {
            ipChange.ipc$dispatch("-22829835", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(new a.b().i("report"));
        this.bese_head_view.setVisibility(0);
        ReportViewModel obtainViewModel = obtainViewModel(this);
        this.reportViewModel = obtainViewModel;
        obtainViewModel.targetId = getString("targetId");
        this.reportViewModel.targetType = getInt("targetType");
        this.reportViewModel.type = getInt("type");
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.report_reason_list);
        this.recyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, 1);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R$drawable.report_listitem_divider));
        this.recyclerView.addItemDecoration(dividerItemDecoration);
        ReasonAdapter reasonAdapter = new ReasonAdapter(this.reportViewModel);
        this.recyclerView.setAdapter(reasonAdapter);
        addObserver(reasonAdapter);
        addListener();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-79759140") ? (String) ipChange.ipc$dispatch("-79759140", new Object[]{this}) : BottomActionDialog.REPORT;
    }
}
