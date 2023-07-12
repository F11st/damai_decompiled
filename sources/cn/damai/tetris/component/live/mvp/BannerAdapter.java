package cn.damai.tetris.component.live.mvp;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.tetris.component.live.bean.LiveHeaderCardItemBean;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.C9548pb;
import tb.th2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BannerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_CONFIG = 3;
    public static final int TYPE_CONTENT = 1;
    public static final int TYPE_TOPIC = 2;
    private Context a;
    private List<LiveHeaderCardItemBean> b;
    private BannerPresenter c;

    public BannerAdapter(Context context) {
        this.a = context;
    }

    public void a(List<LiveHeaderCardItemBean> list, BannerPresenter bannerPresenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1879180666")) {
            ipChange.ipc$dispatch("-1879180666", new Object[]{this, list, bannerPresenter});
            return;
        }
        this.c = bannerPresenter;
        if (th2.b(list) > 0) {
            this.b = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-916680601")) {
            return ((Integer) ipChange.ipc$dispatch("-916680601", new Object[]{this})).intValue();
        }
        List<LiveHeaderCardItemBean> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-262340722") ? ((Integer) ipChange.ipc$dispatch("-262340722", new Object[]{this, Integer.valueOf(i)})).intValue() : this.b.get(i).type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "586999858")) {
            ipChange.ipc$dispatch("586999858", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (this.b.size() <= i) {
        } else {
            LiveHeaderCardItemBean liveHeaderCardItemBean = this.b.get(i);
            viewHolder.itemView.setTag(liveHeaderCardItemBean);
            BannerPresenter bannerPresenter = this.c;
            if (bannerPresenter != null && bannerPresenter.mTrackInfo != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("usercode", this.c.mTrackInfo.get("usercode") + "");
                hashMap.put("city", this.c.mTrackInfo.get("city") + "");
                hashMap.put("contentlabel", liveHeaderCardItemBean.url);
                if (!TextUtils.isEmpty(liveHeaderCardItemBean.url)) {
                    hashMap.put("contentlabel", liveHeaderCardItemBean.name + "&" + liveHeaderCardItemBean.url);
                } else {
                    hashMap.put("contentlabel", liveHeaderCardItemBean.name);
                }
                if (liveHeaderCardItemBean.type == 2) {
                    hashMap.put(C9548pb.PRE_CONTENT_ID, liveHeaderCardItemBean.id);
                    hashMap.put(C9548pb.PRE_CONTENT_TYPE, "theme");
                }
                BannerPresenter bannerPresenter2 = this.c;
                TrackType trackType = TrackType.expose;
                View view = viewHolder.itemView;
                TrackInfo trackInfo = bannerPresenter2.mTrackInfo;
                String str = trackInfo.trackB;
                String str2 = trackInfo.trackC;
                bannerPresenter2.userTrack(trackType, view, str, str2, "item_" + i, hashMap, false);
            }
            int itemViewType = getItemViewType(i);
            if (itemViewType == 2) {
                ((BannerTopicHolder) viewHolder).a(i, this.b.size(), liveHeaderCardItemBean, this.c);
            } else if (itemViewType != 3) {
            } else {
                ((BannerConfigHolder) viewHolder).a(i, this.b.size(), liveHeaderCardItemBean, this.c);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-779071484")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-779071484", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (i != 1) {
            if (i == 2) {
                return new BannerTopicHolder(from);
            }
            if (i != 3) {
                return null;
            }
        }
        return new BannerConfigHolder(from);
    }
}
