package cn.damai.tetris.component.girl.mvp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.girl.bean.BannerBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.th2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BannerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<BannerBean> b;
    private String c;
    private BannerPresenter d;
    public Map<String, Integer> e = new HashMap();
    private OnItemBindListener<BannerBean> f;

    public BannerAdapter(Context context, BannerPresenter bannerPresenter, OnItemBindListener<BannerBean> onItemBindListener) {
        this.a = context;
        this.d = bannerPresenter;
        this.f = onItemBindListener;
    }

    public void a(List<BannerBean> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1122226257")) {
            ipChange.ipc$dispatch("-1122226257", new Object[]{this, list, str});
            return;
        }
        this.c = str;
        if (th2.b(list) > 0) {
            this.b = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437465623")) {
            return ((Integer) ipChange.ipc$dispatch("437465623", new Object[]{this})).intValue();
        }
        List<BannerBean> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-301369214")) {
            ipChange.ipc$dispatch("-301369214", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            BannerBean bannerBean = this.b.get(i);
            CategoryGalleyHolder categoryGalleyHolder = (CategoryGalleyHolder) viewHolder;
            if (i == 0) {
                categoryGalleyHolder.b(this.d, i, this.c, bannerBean, true, false, this.e);
            } else if (i == this.b.size() - 1) {
                categoryGalleyHolder.b(this.d, i, this.c, bannerBean, false, true, this.e);
            } else {
                categoryGalleyHolder.b(this.d, i, this.c, bannerBean, false, false, this.e);
            }
            OnItemBindListener<BannerBean> onItemBindListener = this.f;
            if (onItemBindListener != null) {
                onItemBindListener.exposeItem(categoryGalleyHolder.itemView, bannerBean, i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "514832820") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("514832820", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new CategoryGalleyHolder(LayoutInflater.from(this.a));
    }
}
