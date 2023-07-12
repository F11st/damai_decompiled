package cn.damai.onearch.component.scripttag;

import android.view.View;
import cn.damai.commonbusiness.R$id;
import cn.damai.onearch.component.scripttag.ScriptTagContract;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.onearch.adapter.widget.OneTabLayout;
import com.alient.onearch.adapter.widget.RichTitle;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.tabs.TabLayout;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ScriptTagView extends AbsView<GenericItem<ItemValue>, ScriptTagModel, ScriptTagPresent> implements ScriptTagContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private a tagSelectedListener;
    @NotNull
    private final OneTabLayout tagsView;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public final class a implements TabLayout.OnTabSelectedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        public a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(@NotNull TabLayout.Tab tab) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-177345784")) {
                ipChange.ipc$dispatch("-177345784", new Object[]{this, tab});
            } else {
                b41.i(tab, "tab");
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@NotNull TabLayout.Tab tab) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "474416475")) {
                ipChange.ipc$dispatch("474416475", new Object[]{this, tab});
                return;
            }
            b41.i(tab, "tab");
            ((ScriptTagPresent) ScriptTagView.this.getPresenter()).selectTag(tab.getPosition());
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@NotNull TabLayout.Tab tab) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1525740258")) {
                ipChange.ipc$dispatch("1525740258", new Object[]{this, tab});
            } else {
                b41.i(tab, "tab");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptTagView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        View findViewById = view.findViewById(R$id.script_tags);
        b41.h(findViewById, "view.findViewById(R.id.script_tags)");
        this.tagsView = (OneTabLayout) findViewById;
    }

    @Override // cn.damai.onearch.component.scripttag.ScriptTagContract.View
    public void renderTags(@NotNull List<RichTitle> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1942224744")) {
            ipChange.ipc$dispatch("-1942224744", new Object[]{this, list, Integer.valueOf(i)});
            return;
        }
        b41.i(list, IRequestConst.TAGS);
        a aVar = this.tagSelectedListener;
        if (aVar != null) {
            OneTabLayout oneTabLayout = this.tagsView;
            b41.g(aVar, "null cannot be cast to non-null type cn.damai.onearch.component.scripttag.ScriptTagView.TagSelectedListener");
            oneTabLayout.removeOnTabSelectedListener((TabLayout.OnTabSelectedListener) aVar);
        }
        this.tagsView.removeAllTabs();
        this.tagsView.setTitles(list, i);
        a aVar2 = new a();
        this.tagsView.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) aVar2);
        this.tagSelectedListener = aVar2;
    }
}
