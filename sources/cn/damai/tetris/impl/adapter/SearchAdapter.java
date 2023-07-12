package cn.damai.tetris.impl.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.holder.ProxyViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SearchAdapter extends RecyclerView.Adapter<ProxyViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    Context a;
    public List<ProjectItemBean> b;
    private View.OnClickListener c;
    private TrackInfo d;

    public SearchAdapter(Context context) {
        this.a = context;
    }

    public void a(List<ProjectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "545338728")) {
            ipChange.ipc$dispatch("545338728", new Object[]{this, list});
        } else if (list == null) {
        } else {
            List<ProjectItemBean> list2 = this.b;
            if (list2 != null) {
                list2.addAll(list);
            } else {
                this.b = list;
            }
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onBindViewHolder(@NonNull ProxyViewHolder proxyViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "531488846")) {
            ipChange.ipc$dispatch("531488846", new Object[]{this, proxyViewHolder, Integer.valueOf(i)});
            return;
        }
        ProjectItemBean projectItemBean = this.b.get(i);
        projectItemBean.pos = i;
        if (this.c != null) {
            proxyViewHolder.itemView.setTag(projectItemBean);
            proxyViewHolder.itemView.setOnClickListener(this.c);
        }
        TrackInfo trackInfo = this.d;
        if (trackInfo != null) {
            String string = trackInfo.containsKey("titlelabel") ? this.d.getString("titlelabel") : "";
            View view = proxyViewHolder.itemView;
            TrackInfo trackInfo2 = this.d;
            e(view, trackInfo2.trackD, trackInfo2.trackC, trackInfo2.trackB, i, string, projectItemBean.id);
        }
        ((ProjectItemViewHolder) proxyViewHolder.a).k(projectItemBean);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: c */
    public ProxyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1503533992")) {
            return (ProxyViewHolder) ipChange.ipc$dispatch("1503533992", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        Context context = this.a;
        return new ProxyViewHolder(new ProjectItemViewHolder(context, LayoutInflater.from(context)));
    }

    public void d(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-923968008")) {
            ipChange.ipc$dispatch("-923968008", new Object[]{this, onClickListener});
        } else {
            this.c = onClickListener;
        }
    }

    public void e(View view, String str, String str2, String str3, int i, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1829091222")) {
            ipChange.ipc$dispatch("1829091222", new Object[]{this, view, str, str2, str3, Integer.valueOf(i), str4, str5});
            return;
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("titlelabel", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("item_id", str5);
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        C0529c e = C0529c.e();
        e.G(view, str + i, str2, str3, hashMap);
    }

    public void f(TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "562053436")) {
            ipChange.ipc$dispatch("562053436", new Object[]{this, trackInfo});
        } else {
            this.d = trackInfo;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2081118197")) {
            return ((Integer) ipChange.ipc$dispatch("2081118197", new Object[]{this})).intValue();
        }
        List<ProjectItemBean> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void setData(List<ProjectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045622137")) {
            ipChange.ipc$dispatch("-2045622137", new Object[]{this, list});
            return;
        }
        this.b = list;
        notifyDataSetChanged();
    }
}
