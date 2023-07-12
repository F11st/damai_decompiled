package cn.damai.comment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.bean.DmInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public final class PublishDMSelectView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final PublishDMListView dmListView;
    @NotNull
    private final PublishDMTagView dmTagListView;
    @Nullable
    private OnItemClickListener onItemClickListener;
    @Nullable
    private DmInfo selectedDm;
    @Nullable
    private Integer selectedDmIndex;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static final class a implements OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.comment.view.OnItemClickListener
        public void onItemClick(@NotNull View view, int i, @Nullable DmInfo dmInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1802614363")) {
                ipChange.ipc$dispatch("-1802614363", new Object[]{this, view, Integer.valueOf(i), dmInfo});
                return;
            }
            b41.i(view, "itemView");
            PublishDMSelectView.this.selectedDm = dmInfo;
            PublishDMSelectView.this.selectedDmIndex = Integer.valueOf(i);
            PublishDMSelectView.this.dmTagListView.bindData(dmInfo, i);
            OnItemClickListener onItemClickListener = PublishDMSelectView.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(view, i, dmInfo);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishDMSelectView(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ PublishDMSelectView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void bindData(@Nullable List<DmInfo> list, @Nullable DmInfo dmInfo) {
        Object obj;
        Set F0;
        List X;
        Set F02;
        List X2;
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1658441669")) {
            ipChange.ipc$dispatch("1658441669", new Object[]{this, list, dmInfo});
            return;
        }
        if (list == null || list.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.selectedDm = dmInfo;
        if (dmInfo != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                DmInfo dmInfo2 = (DmInfo) obj;
                if ((dmInfo2 != null ? dmInfo2.getDmId() : null) == null || !b41.d(dmInfo2.getDmId(), dmInfo.getDmId())) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            DmInfo dmInfo3 = (DmInfo) obj;
            if (dmInfo3 != null) {
                dmInfo3.dmTags = dmInfo.dmTags;
                ArrayList<String> arrayList = dmInfo3.allDmTags;
                if (arrayList != null && dmInfo.dmTags != null) {
                    b41.f(arrayList);
                    ArrayList<String> arrayList2 = dmInfo.dmTags;
                    b41.f(arrayList2);
                    F02 = CollectionsKt___CollectionsKt.F0(arrayList, arrayList2);
                    Object[] array = F02.toArray(new String[0]);
                    b41.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    X2 = ArraysKt___ArraysKt.X(array);
                    b41.g(X2, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
                    ArrayList<String> arrayList3 = (ArrayList) X2;
                    dmInfo3.allDmTags = arrayList3;
                    dmInfo.allDmTags = arrayList3;
                }
                this.selectedDm = dmInfo3;
            } else {
                ArrayList<String> arrayList4 = dmInfo.allDmTags;
                if (arrayList4 != null && dmInfo.dmTags != null) {
                    b41.f(arrayList4);
                    ArrayList<String> arrayList5 = dmInfo.dmTags;
                    b41.f(arrayList5);
                    F0 = CollectionsKt___CollectionsKt.F0(arrayList4, arrayList5);
                    Object[] array2 = F0.toArray(new String[0]);
                    b41.g(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    X = ArraysKt___ArraysKt.X(array2);
                    b41.g(X, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
                    dmInfo.allDmTags = (ArrayList) X;
                }
                ArrayList arrayList6 = list instanceof ArrayList ? (ArrayList) list : null;
                if (arrayList6 != null) {
                    arrayList6.add(0, dmInfo);
                }
            }
        }
        this.dmListView.bindData(list, this.selectedDm);
        DmInfo dmInfo4 = this.selectedDm;
        int indexOf = dmInfo4 != null ? list.indexOf(dmInfo4) : 0;
        if (this.selectedDm != null) {
            this.selectedDmIndex = Integer.valueOf(indexOf);
        }
        this.dmTagListView.bindData(this.selectedDm, indexOf);
    }

    @Nullable
    public final OnItemClickListener getOnItemClickListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "534315241") ? (OnItemClickListener) ipChange.ipc$dispatch("534315241", new Object[]{this}) : this.onItemClickListener;
    }

    @Nullable
    public final DmInfo getSelectedDm() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-688047231") ? (DmInfo) ipChange.ipc$dispatch("-688047231", new Object[]{this}) : this.selectedDm;
    }

    @Nullable
    public final Integer getSelectedDmIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-695893146") ? (Integer) ipChange.ipc$dispatch("-695893146", new Object[]{this}) : this.selectedDmIndex;
    }

    public final void setOnItemClickListener(@Nullable OnItemClickListener onItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2119983431")) {
            ipChange.ipc$dispatch("2119983431", new Object[]{this, onItemClickListener});
        } else {
            this.onItemClickListener = onItemClickListener;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishDMSelectView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(context).inflate(R$layout.publish_dm_select_layout, (ViewGroup) this, true);
        setOrientation(1);
        View findViewById = findViewById(R$id.comment_publish_dm_list);
        b41.h(findViewById, "findViewById(R.id.comment_publish_dm_list)");
        PublishDMListView publishDMListView = (PublishDMListView) findViewById;
        this.dmListView = publishDMListView;
        View findViewById2 = findViewById(R$id.comment_publish_dm_tag_container);
        b41.h(findViewById2, "findViewById(R.id.commen…publish_dm_tag_container)");
        this.dmTagListView = (PublishDMTagView) findViewById2;
        publishDMListView.setItemClickListener(new a());
    }
}
