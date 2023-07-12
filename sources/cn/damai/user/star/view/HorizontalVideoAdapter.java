package cn.damai.user.star.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.a;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.user.star.bean.Videos;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class HorizontalVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<Videos> b;
    private View.OnClickListener c;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class VideoHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        public View a;
        private View b;
        private RoundImageView c;
        private ImageView d;

        public VideoHolder(HorizontalVideoAdapter horizontalVideoAdapter, LayoutInflater layoutInflater) {
            super(layoutInflater.inflate(R$layout.mine_starindex_fragment_perform_videoitem, (ViewGroup) null));
            layoutInflater.getContext();
            this.a = this.itemView.findViewById(R$id.layout_left);
            this.b = this.itemView.findViewById(R$id.layout_right);
            this.c = (RoundImageView) this.itemView.findViewById(R$id.image_video);
            this.d = (ImageView) this.itemView.findViewById(R$id.icon_video);
        }

        public void a(Videos videos, boolean z, boolean z2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "908133025")) {
                ipChange.ipc$dispatch("908133025", new Object[]{this, videos, Boolean.valueOf(z), Boolean.valueOf(z2)});
            } else if (videos == null) {
            } else {
                this.a.setVisibility(8);
                if (z2) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(8);
                }
                RoundImageView roundImageView = this.c;
                int i = R$drawable.uikit_default_image_bg_gradient;
                roundImageView.setImageResource(i);
                a.b().c(videos.picUrl).c(i).g(this.c);
                if (TextUtils.isEmpty(videos.vid)) {
                    this.d.setVisibility(8);
                } else {
                    this.d.setVisibility(0);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1698105584")) {
            return ((Integer) ipChange.ipc$dispatch("1698105584", new Object[]{this})).intValue();
        }
        List<Videos> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-700496375")) {
            ipChange.ipc$dispatch("-700496375", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        if (viewHolder != null) {
            Videos videos = this.b.get(i);
            videos.index = i;
            if (i == 0) {
                ((VideoHolder) viewHolder).a(videos, true, false);
            } else if (i == this.b.size() - 1) {
                ((VideoHolder) viewHolder).a(videos, false, true);
            } else {
                ((VideoHolder) viewHolder).a(videos, false, false);
            }
            VideoHolder videoHolder = (VideoHolder) viewHolder;
            videoHolder.itemView.setTag(videos);
            videoHolder.itemView.setOnClickListener(this.c);
        }
        if (i == 0) {
            ((VideoHolder) viewHolder).a.setVisibility(0);
        } else {
            ((VideoHolder) viewHolder).a.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1833263629") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1833263629", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new VideoHolder(this, LayoutInflater.from(this.a));
    }
}
