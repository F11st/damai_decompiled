package cn.damai.search.v2.tool;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.search.helper.SearchHelper;
import cn.damai.search.v2.bean.InputInfo;
import cn.damai.search.v2.listener.SearchInputObserver;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class HistoryWordManager implements SearchInputObserver {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnHisWordDataChangeListener a;
    private List<String> b = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnHisWordDataChangeListener {
        void updateList(@Nullable List<String> list);
    }

    public HistoryWordManager(OnHisWordDataChangeListener onHisWordDataChangeListener) {
        this.a = onHisWordDataChangeListener;
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-356552361")) {
            ipChange.ipc$dispatch("-356552361", new Object[]{this});
            return;
        }
        OnHisWordDataChangeListener onHisWordDataChangeListener = this.a;
        if (onHisWordDataChangeListener != null) {
            onHisWordDataChangeListener.updateList(this.b);
        }
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2080934153")) {
            ipChange.ipc$dispatch("2080934153", new Object[]{this});
            return;
        }
        SearchHelper.a(mu0.a());
        this.b.clear();
        c();
    }

    public void b() {
        String[] split;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1457708465")) {
            ipChange.ipc$dispatch("1457708465", new Object[]{this});
            return;
        }
        String e = SearchHelper.e(mu0.a());
        if (!TextUtils.isEmpty(e) && (split = e.split(",")) != null && split.length > 0) {
            this.b.addAll(Arrays.asList(split));
        }
        c();
    }

    @Override // cn.damai.search.v2.listener.SearchInputObserver
    public void dispatchInputWord(InputInfo inputInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "307951653")) {
            ipChange.ipc$dispatch("307951653", new Object[]{this, inputInfo});
        } else if (inputInfo == null) {
        } else {
            String trim = inputInfo.inputText.trim();
            if (TextUtils.isEmpty(trim)) {
                return;
            }
            this.b.remove(trim);
            this.b.add(0, trim);
            if (this.b.size() >= 11) {
                this.b.remove(10);
            }
            SearchHelper.t(mu0.a(), this.b);
            c();
        }
    }
}
