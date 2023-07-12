package com.alibaba.pictures.bricks.selector.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.bricks.orderconfirm.OnEventListener;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectMo;
import com.alibaba.pictures.bricks.selector.view.ScriptViewHolder;
import com.alibaba.pictures.bricks.selector.view.ShopViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.i72;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ScriptSelectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int a;
    @Nullable
    private OnEventListener b;
    @Nullable
    private String d;
    @Nullable
    private String e;
    @NotNull
    private ArrayList<ScriptSelectMo> c = new ArrayList<>();
    @NotNull
    private a f = new a();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a implements OnEventListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.alibaba.pictures.bricks.orderconfirm.OnEventListener
        public void onEvent(@NotNull String str, @Nullable View view, @Nullable Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-314131542")) {
                ipChange.ipc$dispatch("-314131542", new Object[]{this, str, view, obj});
                return;
            }
            b41.i(str, "eventId");
            if (b41.d(str, ScriptSelectFragment.EVENT_ID_ITEM_SELECT)) {
                if ((obj instanceof ScriptSelectMo ? (ScriptSelectMo) obj : null) != null) {
                    ScriptSelectAdapter scriptSelectAdapter = ScriptSelectAdapter.this;
                    ScriptSelectMo scriptSelectMo = (ScriptSelectMo) obj;
                    scriptSelectAdapter.g(b41.d(scriptSelectAdapter.d(), scriptSelectMo.getTargetId()) ? null : scriptSelectMo.getTargetId());
                    scriptSelectAdapter.notifyDataSetChanged();
                    i72.INSTANCE.c(view, scriptSelectMo.getTargetId(), scriptSelectAdapter.c());
                }
                OnEventListener onEventListener = ScriptSelectAdapter.this.b;
                if (onEventListener != null) {
                    if (ScriptSelectAdapter.this.d() == null) {
                        obj = null;
                    }
                    onEventListener.onEvent(str, view, obj);
                }
            }
        }
    }

    public ScriptSelectAdapter(int i, @Nullable OnEventListener onEventListener) {
        this.a = i;
        this.b = onEventListener;
    }

    public final void b(@Nullable ArrayList<ScriptSelectMo> arrayList) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-863758822")) {
            ipChange.ipc$dispatch("-863758822", new Object[]{this, arrayList});
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            z = false;
        }
        if (z) {
            return;
        }
        this.c.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Nullable
    public final String c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-23632414") ? (String) ipChange.ipc$dispatch("-23632414", new Object[]{this}) : this.e;
    }

    @Nullable
    public final String d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-304778453") ? (String) ipChange.ipc$dispatch("-304778453", new Object[]{this}) : this.d;
    }

    public final void e(@Nullable ArrayList<ScriptSelectMo> arrayList) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "576525787")) {
            ipChange.ipc$dispatch("576525787", new Object[]{this, arrayList});
            return;
        }
        this.c.clear();
        if (arrayList != null && !arrayList.isEmpty()) {
            z = false;
        }
        if (!z) {
            this.c.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public final void f(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1946108884")) {
            ipChange.ipc$dispatch("1946108884", new Object[]{this, str});
        } else {
            this.e = str;
        }
    }

    public final void g(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-460316397")) {
            ipChange.ipc$dispatch("-460316397", new Object[]{this, str});
        } else {
            this.d = str;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-837006018") ? ((Integer) ipChange.ipc$dispatch("-837006018", new Object[]{this})).intValue() : this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "828864763")) {
            ipChange.ipc$dispatch("828864763", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        b41.i(viewHolder, "holder");
        ScriptSelectMo scriptSelectMo = this.c.get(i);
        b41.h(scriptSelectMo, "dataList[position]");
        ScriptSelectMo scriptSelectMo2 = scriptSelectMo;
        z = (this.d == null || !b41.d(scriptSelectMo2.getTargetId(), this.d)) ? false : false;
        if (viewHolder instanceof ShopViewHolder) {
            ((ShopViewHolder) viewHolder).b(scriptSelectMo2, this.e, Boolean.valueOf(z));
        } else if (viewHolder instanceof ScriptViewHolder) {
            ScriptSelectMo scriptSelectMo3 = this.c.get(i);
            b41.h(scriptSelectMo3, "dataList[position]");
            ((ScriptViewHolder) viewHolder).b(scriptSelectMo3, this.e, Boolean.valueOf(z));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1597373605")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1597373605", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        b41.i(viewGroup, "parent");
        if (this.a == 0) {
            return ShopViewHolder.Companion.a(viewGroup, this.f);
        }
        return ScriptViewHolder.Companion.a(viewGroup, this.f);
    }
}
