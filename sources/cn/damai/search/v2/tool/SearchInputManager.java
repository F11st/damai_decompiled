package cn.damai.search.v2.tool;

import android.app.Activity;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.util.SoftInputUtils;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.c;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.search.bean.SearchDataHolder;
import cn.damai.search.bean.SearchSuggest;
import cn.damai.search.bean.SearchWord;
import cn.damai.search.bean.youku.SuggestRes;
import cn.damai.search.model.SearchSugWordRequest;
import cn.damai.search.v2.adapter.SuggestAdapter;
import cn.damai.search.v2.bean.InputInfo;
import cn.damai.search.v2.bean.SearchExtra;
import cn.damai.search.v2.listener.ISearchUIController;
import cn.damai.search.v2.listener.InputInfoProvider;
import cn.damai.search.v2.listener.OnSearchInputListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.a82;
import tb.c82;
import tb.cb2;
import tb.d23;
import tb.kg2;
import tb.ms;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchInputManager implements View.OnClickListener, InputInfoProvider {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private List<SearchDataHolder> b = new ArrayList();
    private EditText c;
    private OnSearchInputListener d;
    private ISearchUIController e;
    private SuggestAdapter f;
    private a82 g;
    private View h;
    private SearchExtra i;
    private View j;
    private InputInfo k;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a extends a82 {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // tb.a82
        public void a(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1130882405")) {
                ipChange.ipc$dispatch("1130882405", new Object[]{this, editable});
            } else if (editable == null || editable.length() <= 0) {
                SearchInputManager.this.h.setVisibility(8);
                SearchInputManager.this.e.showUi(0);
            } else {
                SearchInputManager.this.e.showUi(1);
                SearchInputManager.this.n(editable.toString());
                SearchInputManager.this.h.setVisibility(0);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class b implements SuggestAdapter.OnSuggestListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.search.v2.adapter.SuggestAdapter.OnSuggestListener
        public void onSuggestClick(View view, SearchSuggest searchSuggest, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "899790857")) {
                ipChange.ipc$dispatch("899790857", new Object[]{this, view, searchSuggest, Integer.valueOf(i)});
                return;
            }
            String str = searchSuggest.sugWord;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String trim = str.trim();
            if (TextUtils.isEmpty(trim)) {
                return;
            }
            SoftInputUtils.a(SearchInputManager.this.a);
            SearchInputManager.this.r(trim, 20, true);
            c82.t(SearchInputManager.this.getCurrentInputInfo(), trim, i);
        }

        @Override // cn.damai.search.v2.adapter.SuggestAdapter.OnSuggestListener
        public void onSuggestExpose(View view, SearchSuggest searchSuggest, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-420258933")) {
                ipChange.ipc$dispatch("-420258933", new Object[]{this, view, searchSuggest, Integer.valueOf(i)});
                return;
            }
            String str = searchSuggest.sugWord;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            HashMap<String, String> f = d23.f();
            f.put("keyword", SearchInputManager.this.getCurrentInputInfo().getInput());
            f.put("titlelabel", str);
            c e = c.e();
            e.G(view, "item_" + i, "suggestion", "search", f);
        }
    }

    public SearchInputManager(Activity activity, ISearchUIController iSearchUIController, View view, View view2, final SearchExtra searchExtra, OnSearchInputListener onSearchInputListener) {
        this.d = onSearchInputListener;
        this.e = iSearchUIController;
        this.a = activity;
        this.i = searchExtra;
        this.j = view.findViewById(R$id.header_search_v2_space);
        View findViewById = view.findViewById(R$id.header_search_v2_input_bg);
        this.h = view.findViewById(R$id.header_search_v2_input_delete);
        this.c = (EditText) view.findViewById(R$id.header_search_v2_input);
        View findViewById2 = view.findViewById(R$id.header_search_v2_cancel);
        this.h.setVisibility(8);
        ms.a(this.a, findViewById, false);
        q((RecyclerView) view2.findViewById(R$id.search_v2_suggest_recycler));
        a aVar = new a();
        this.g = aVar;
        this.c.addTextChangedListener(aVar);
        this.c.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: cn.damai.search.v2.tool.SearchInputManager.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "710946629")) {
                    return ((Boolean) ipChange.ipc$dispatch("710946629", new Object[]{this, textView, Integer.valueOf(i), keyEvent})).booleanValue();
                }
                if (i == 3) {
                    String o = SearchInputManager.this.o();
                    if (!TextUtils.isEmpty(o)) {
                        SearchInputManager.this.k = new InputInfo(o, 18);
                        SearchInputManager.this.d.onSearchInputClick(SearchInputManager.this.k);
                    } else if (SearchInputManager.this.i.isUsePresetKeyWord()) {
                        SearchInputManager.this.r(SearchInputManager.this.i.keywords, 21, true);
                    }
                    SoftInputUtils.a(SearchInputManager.this.a);
                    return true;
                }
                return false;
            }
        });
        findViewById2.setOnClickListener(this);
        this.h.setOnClickListener(this);
        if (searchExtra.isHasHint()) {
            this.c.setHint(searchExtra.describe);
        }
        if (searchExtra.isShouldAutoSearch()) {
            this.c.post(new Runnable() { // from class: cn.damai.search.v2.tool.SearchInputManager.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2099120032")) {
                        ipChange.ipc$dispatch("2099120032", new Object[]{this});
                    } else {
                        SearchInputManager.this.r(searchExtra.autowords, 19, true);
                    }
                }
            });
        } else {
            this.c.post(new Runnable() { // from class: cn.damai.search.v2.tool.SearchInputManager.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1902606527")) {
                        ipChange.ipc$dispatch("1902606527", new Object[]{this});
                        return;
                    }
                    SearchInputManager.this.c.setFocusable(true);
                    SearchInputManager.this.c.setFocusableInTouchMode(true);
                    SearchInputManager.this.c.requestFocus();
                    SoftInputUtils.d(SearchInputManager.this.a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(@NonNull final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1327998923")) {
            ipChange.ipc$dispatch("-1327998923", new Object[]{this, str});
        } else {
            new SearchSugWordRequest(str).request(new DMMtopRequestListener<SuggestRes>(SuggestRes.class) { // from class: cn.damai.search.v2.tool.SearchInputManager.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str2, String str3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1664795527")) {
                        ipChange2.ipc$dispatch("-1664795527", new Object[]{this, str2, str3});
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(SuggestRes suggestRes) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-428377144")) {
                        ipChange2.ipc$dispatch("-428377144", new Object[]{this, suggestRes});
                    } else if (suggestRes != null && TextUtils.equals(str, SearchInputManager.this.o())) {
                        SearchInputManager.this.s(SearchWord.youKuSuggestToNative(suggestRes));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String o() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2058918052") ? (String) ipChange.ipc$dispatch("2058918052", new Object[]{this}) : this.c.getText().toString();
    }

    private void q(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "750658741")) {
            ipChange.ipc$dispatch("750658741", new Object[]{this, recyclerView});
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this.a, 1, false));
        SuggestAdapter suggestAdapter = new SuggestAdapter(this.a);
        this.f = suggestAdapter;
        suggestAdapter.b(new b());
        recyclerView.setAdapter(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, int i, boolean z) {
        OnSearchInputListener onSearchInputListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1770877665")) {
            ipChange.ipc$dispatch("1770877665", new Object[]{this, str, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        this.k = new InputInfo(str, i);
        this.g.b();
        this.c.setText(str);
        this.c.clearFocus();
        if (str != null && str.length() > 0) {
            this.h.setVisibility(0);
        }
        if (!z || (onSearchInputListener = this.d) == null) {
            return;
        }
        onSearchInputListener.onSearchInputClick(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(SearchWord searchWord) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1335427200")) {
            ipChange.ipc$dispatch("-1335427200", new Object[]{this, searchWord});
            return;
        }
        this.b.clear();
        if (searchWord != null && !cb2.d(searchWord.words)) {
            for (SearchSuggest searchSuggest : searchWord.words) {
                SearchDataHolder searchDataHolder = new SearchDataHolder(8);
                searchDataHolder.mSuggestWord = searchSuggest;
                searchSuggest.index = i;
                this.b.add(searchDataHolder);
                i++;
            }
        }
        this.f.c(this.b);
    }

    @Override // cn.damai.search.v2.listener.InputInfoProvider
    public InputInfo getCurrentInputInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-858045962")) {
            return (InputInfo) ipChange.ipc$dispatch("-858045962", new Object[]{this});
        }
        InputInfo inputInfo = this.k;
        return inputInfo != null ? inputInfo : new InputInfo(o(), 18);
    }

    public void m(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1505386196")) {
            ipChange.ipc$dispatch("-1505386196", new Object[]{this, str});
            return;
        }
        SoftInputUtils.a(this.a);
        r(str, 22, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1749338945")) {
            ipChange.ipc$dispatch("1749338945", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.header_search_v2_cancel) {
            this.a.finish();
        } else if (id == R$id.header_search_v2_input_delete) {
            c82.q(o());
            this.c.setText((CharSequence) null);
        }
    }

    public void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1718485879")) {
            ipChange.ipc$dispatch("-1718485879", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.j.getLayoutParams().height = kg2.a(this.a);
            this.j.setVisibility(0);
            kg2.f(this.a, true, R$color.black);
            kg2.d(true, this.a);
        } else {
            kg2.f(this.a, false, R$color.black);
            this.j.setVisibility(8);
        }
    }
}
