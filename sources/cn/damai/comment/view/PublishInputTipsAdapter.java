package cn.damai.comment.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.R$color;
import cn.damai.comment.view.PublishInputTipsAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.i41;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class PublishInputTipsAdapter extends RecyclerView.Adapter<PublishInputTipsVH> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private OnTipsSelectedListener a;
    @Nullable
    private List<String> b;

    public PublishInputTipsAdapter(@Nullable OnTipsSelectedListener onTipsSelectedListener) {
        this.a = onTipsSelectedListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TextView textView, int i, PublishInputTipsAdapter publishInputTipsAdapter, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-391428836")) {
            ipChange.ipc$dispatch("-391428836", new Object[]{textView, Integer.valueOf(i), publishInputTipsAdapter, view});
            return;
        }
        b41.i(textView, "$this_apply");
        b41.i(publishInputTipsAdapter, "this$0");
        CharSequence text = textView.getText();
        b41.g(text, "null cannot be cast to non-null type kotlin.String");
        String str = (String) text;
        i41.p(str, i);
        OnTipsSelectedListener onTipsSelectedListener = publishInputTipsAdapter.a;
        if (onTipsSelectedListener != null) {
            onTipsSelectedListener.onTipsSelected(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onBindViewHolder(@NotNull PublishInputTipsVH publishInputTipsVH, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1990734357")) {
            ipChange.ipc$dispatch("-1990734357", new Object[]{this, publishInputTipsVH, Integer.valueOf(i)});
            return;
        }
        b41.i(publishInputTipsVH, "viewHolder");
        List<String> list = this.b;
        String str = list != null ? list.get(i) : null;
        View view = publishInputTipsVH.itemView;
        TextView textView = view instanceof TextView ? (TextView) view : null;
        i41.h(textView, str, i);
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: c */
    public PublishInputTipsVH onCreateViewHolder(@NotNull ViewGroup viewGroup, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1062362347")) {
            return (PublishInputTipsVH) ipChange.ipc$dispatch("1062362347", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        b41.i(viewGroup, "parent");
        final TextView textView = new TextView(viewGroup.getContext());
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R$color.black));
        textView.setGravity(17);
        int a = t60.a(textView.getContext(), 8.0f);
        textView.setPadding(0, a, 0, a);
        textView.setOnClickListener(new View.OnClickListener() { // from class: tb.wx1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublishInputTipsAdapter.d(textView, i, this, view);
            }
        });
        return new PublishInputTipsVH(textView);
    }

    public final void e(@Nullable OnTipsSelectedListener onTipsSelectedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-828720276")) {
            ipChange.ipc$dispatch("-828720276", new Object[]{this, onTipsSelectedListener});
        } else {
            this.a = onTipsSelectedListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "471021863")) {
            return ((Integer) ipChange.ipc$dispatch("471021863", new Object[]{this})).intValue();
        }
        List<String> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void setData(@Nullable List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "246813717")) {
            ipChange.ipc$dispatch("246813717", new Object[]{this, list});
            return;
        }
        this.b = list;
        notifyDataSetChanged();
    }
}
