package com.alibaba.pictures.share.common.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.share.R$id;
import com.alibaba.pictures.share.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ob2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0007\bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/adapter/ShareMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/alibaba/pictures/share/common/ui/adapter/ShareMenuAdapter$ShareMenuHolder;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "OnShareMenuItemClickListener", "ShareMenuHolder", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class ShareMenuAdapter extends RecyclerView.Adapter<ShareMenuHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<ob2> a;
    private OnShareMenuItemClickListener b;
    @NotNull
    private final Context c;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/adapter/ShareMenuAdapter$OnShareMenuItemClickListener;", "", "", RemoteMessageConst.Notification.CHANNEL_ID, "Ltb/wt2;", "onMenuItemClick", "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public interface OnShareMenuItemClickListener {
        void onMenuItemClick(int i);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/adapter/ShareMenuAdapter$ShareMenuHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/alibaba/pictures/share/common/ui/adapter/ShareMenuAdapter;Landroid/view/View;)V", "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public final class ShareMenuHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private ImageView a;
        @Nullable
        private TextView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShareMenuHolder(@NotNull ShareMenuAdapter shareMenuAdapter, View view) {
            super(view);
            b41.i(view, "itemView");
            this.a = (ImageView) view.findViewById(R$id.share_channel_icon);
            this.b = (TextView) view.findViewById(R$id.share_channel_name);
        }

        @Nullable
        public final ImageView a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "468086537") ? (ImageView) ipChange.ipc$dispatch("468086537", new Object[]{this}) : this.a;
        }

        @Nullable
        public final TextView getTitle() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2081393638") ? (TextView) ipChange.ipc$dispatch("2081393638", new Object[]{this}) : this.b;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int b;

        a(int i) {
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1107429683")) {
                ipChange.ipc$dispatch("1107429683", new Object[]{this, view});
                return;
            }
            OnShareMenuItemClickListener onShareMenuItemClickListener = ShareMenuAdapter.this.b;
            if (onShareMenuItemClickListener != null) {
                onShareMenuItemClickListener.onMenuItemClick(((ob2) ShareMenuAdapter.this.a.get(this.b)).b());
            }
        }
    }

    public ShareMenuAdapter(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.c = context;
        this.a = new ArrayList<>();
    }

    public final void c(@NotNull ob2 ob2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "863960791")) {
            ipChange.ipc$dispatch("863960791", new Object[]{this, ob2Var});
            return;
        }
        b41.i(ob2Var, "channelUIData");
        this.a.add(ob2Var);
        notifyItemInserted(this.a.indexOf(ob2Var));
    }

    public final void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-352772901")) {
            ipChange.ipc$dispatch("-352772901", new Object[]{this});
        } else {
            this.a.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(@NotNull ShareMenuHolder shareMenuHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-281257222")) {
            ipChange.ipc$dispatch("-281257222", new Object[]{this, shareMenuHolder, Integer.valueOf(i)});
            return;
        }
        b41.i(shareMenuHolder, "holder");
        ImageView a2 = shareMenuHolder.a();
        if (a2 != null) {
            a2.setImageResource(this.a.get(i).a());
        }
        TextView title = shareMenuHolder.getTitle();
        if (title != null) {
            title.setText(this.a.get(i).c());
        }
        shareMenuHolder.itemView.setOnClickListener(new a(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: f */
    public ShareMenuHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "829853052")) {
            return (ShareMenuHolder) ipChange.ipc$dispatch("829853052", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        b41.i(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.c).inflate(R$layout.share_channel_recycler_item, viewGroup, false);
        b41.h(inflate, "view");
        return new ShareMenuHolder(this, inflate);
    }

    public final void g(@NotNull OnShareMenuItemClickListener onShareMenuItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-84790697")) {
            ipChange.ipc$dispatch("-84790697", new Object[]{this, onShareMenuItemClickListener});
            return;
        }
        b41.i(onShareMenuItemClickListener, "listener");
        this.b = onShareMenuItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "96805915") ? ((Integer) ipChange.ipc$dispatch("96805915", new Object[]{this})).intValue() : this.a.size();
    }
}
