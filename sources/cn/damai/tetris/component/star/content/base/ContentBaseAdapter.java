package cn.damai.tetris.component.star.content.base;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.star.content.base.bean.ContentFreeRootBean;
import cn.damai.tetris.component.star.content.base.bean.ContentItemBean;
import cn.damai.tetris.core.BasePresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.ao;
import tb.jb1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ContentBaseAdapter extends RecyclerView.Adapter<ContentBaseViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private BasePresenter b;
    private ContentFreeRootBean c;
    private List<ContentItemBean> d;

    public ContentBaseAdapter(Context context, View.OnClickListener onClickListener, BasePresenter basePresenter) {
        this.a = context;
        this.b = basePresenter;
    }

    private boolean a(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "368563445") ? ((Boolean) ipChange.ipc$dispatch("368563445", new Object[]{this, Integer.valueOf(i)})).booleanValue() : i + 1 == this.d.size();
    }

    private void h(ContentItemBean contentItemBean, int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1480624216")) {
            ipChange.ipc$dispatch("1480624216", new Object[]{this, contentItemBean, Integer.valueOf(i), view});
        } else if (contentItemBean == null || TextUtils.isEmpty(contentItemBean.getCard())) {
        } else {
            this.b.userTrackExpose(view, "card_" + i, ao.a(this.b.getModel().getTrackInfo().getArgsMap(), contentItemBean.getContentId(), contentItemBean.getCard()), false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onBindViewHolder(ContentBaseViewHolder contentBaseViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "186510986")) {
            ipChange.ipc$dispatch("186510986", new Object[]{this, contentBaseViewHolder, Integer.valueOf(i)});
            return;
        }
        jb1.a("real-uikit", "onBindViewHolder()");
        if (contentBaseViewHolder != null) {
            contentBaseViewHolder.n(this.d.get(i), i, a(i));
            contentBaseViewHolder.itemView.setTag(this.d.get(i));
            contentBaseViewHolder.itemView.setTag(R$id.offical_content_item_index_id, Integer.valueOf(i));
            if (contentBaseViewHolder.itemView.getLayoutParams() == null) {
                contentBaseViewHolder.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            h(this.d.get(i), i, contentBaseViewHolder.itemView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public ContentBaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "462193132") ? (ContentBaseViewHolder) ipChange.ipc$dispatch("462193132", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ContentBaseViewHolder(this.a, LayoutInflater.from(this.a), this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onViewAttachedToWindow(@NonNull ContentBaseViewHolder contentBaseViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1636162975")) {
            ipChange.ipc$dispatch("1636162975", new Object[]{this, contentBaseViewHolder});
            return;
        }
        super.onViewAttachedToWindow(contentBaseViewHolder);
        jb1.a("real-uikit", "attachFromWindow(holder)");
        contentBaseViewHolder.m();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onViewDetachedFromWindow(@NonNull ContentBaseViewHolder contentBaseViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706085724")) {
            ipChange.ipc$dispatch("706085724", new Object[]{this, contentBaseViewHolder});
            return;
        }
        super.onViewDetachedFromWindow(contentBaseViewHolder);
        jb1.a("real-uikit", "detachFromWindow(holder)");
        contentBaseViewHolder.q();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onViewRecycled(@NonNull ContentBaseViewHolder contentBaseViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1921718081")) {
            ipChange.ipc$dispatch("1921718081", new Object[]{this, contentBaseViewHolder});
            return;
        }
        jb1.a("real-uikit", "onRecycled()");
        super.onViewRecycled(contentBaseViewHolder);
        contentBaseViewHolder.G();
    }

    public void g(ContentFreeRootBean contentFreeRootBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1236143902")) {
            ipChange.ipc$dispatch("1236143902", new Object[]{this, contentFreeRootBean});
        } else if (contentFreeRootBean == null) {
        } else {
            this.c = contentFreeRootBean;
            List<ContentItemBean> contents = contentFreeRootBean.getContents();
            if (contents == null || contents.size() <= 0) {
                return;
            }
            this.d = contents;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1726353567")) {
            return ((Integer) ipChange.ipc$dispatch("1726353567", new Object[]{this})).intValue();
        }
        List<ContentItemBean> list = this.d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690285337")) {
            ipChange.ipc$dispatch("-690285337", new Object[]{this, recyclerView});
            return;
        }
        super.onAttachedToRecyclerView(recyclerView);
        jb1.a("real-uikit", "attachFromWindow(RecyclerView)");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-328934108")) {
            ipChange.ipc$dispatch("-328934108", new Object[]{this, recyclerView});
            return;
        }
        super.onDetachedFromRecyclerView(recyclerView);
        jb1.a("real-uikit", "detachFromWindow(RecyclerView)");
    }
}
