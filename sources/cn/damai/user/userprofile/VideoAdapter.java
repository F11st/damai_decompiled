package cn.damai.user.userprofile;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.user.userprofile.bean.VideoItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.t60;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class VideoAdapter extends RecyclerView.Adapter<VideoHoloder> {
    private static transient /* synthetic */ IpChange $ipChange;
    VideoFragment a;
    List<VideoItem> b = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class VideoHoloder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        public ImageView a;
        public TextView b;

        public VideoHoloder(@NonNull VideoAdapter videoAdapter, View view) {
            super(view);
            this.b = (TextView) view.findViewById(R$id.brand_user_video_title);
            this.a = (ImageView) view.findViewById(R$id.brand_user_video_bg);
        }

        public void a(VideoItem videoItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1911989160")) {
                ipChange.ipc$dispatch("1911989160", new Object[]{this, videoItem});
                return;
            }
            this.b.setText(videoItem.title);
            DMImageCreator c = cn.damai.common.image.a.b().c(videoItem.picUrl);
            int i = R$drawable.uikit_default_image_bg_gradient;
            c.i(i).c(i).g(this.a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ VideoItem a;
        final /* synthetic */ int b;

        a(VideoItem videoItem, int i) {
            this.a = videoItem;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-666205567")) {
                ipChange.ipc$dispatch("-666205567", new Object[]{this, view});
                return;
            }
            Log.d("videoclick", this.a.vid);
            if (VideoAdapter.this.a.getContext() != null) {
                Bundle bundle = new Bundle();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                VideoInfo videoInfo = new VideoInfo();
                videoInfo.setTitle(this.a.title);
                videoInfo.setPicUrl(this.a.picUrl);
                videoInfo.setVid(this.a.vid);
                arrayList.add(videoInfo);
                bundle.putParcelableArrayList("video_info", arrayList);
                bundle.putInt("position", 0);
                DMNav.from(VideoAdapter.this.a.getContext()).withExtras(bundle).toUri(NavUri.b("videobrowse"));
                HashMap hashMap = new HashMap();
                hashMap.put("usercode", z20.E());
                hashMap.put("biz_id", VideoAdapter.this.a.videoRequest.artistId + "");
                hashMap.put("biz_type", VideoAdapter.this.a.type + "");
                hashMap.put("video_id", this.a.vid);
                b bVar = new b();
                c.e().x(bVar.e("business_homepage", "video", "video_" + this.b, hashMap, Boolean.TRUE));
            }
        }
    }

    public VideoAdapter(VideoFragment videoFragment) {
        this.a = videoFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull VideoHoloder videoHoloder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-287442854")) {
            ipChange.ipc$dispatch("-287442854", new Object[]{this, videoHoloder, Integer.valueOf(i)});
            return;
        }
        VideoItem videoItem = this.b.get(i);
        if (videoItem != null) {
            videoHoloder.a(videoItem);
        }
        videoHoloder.itemView.setOnClickListener(new a(videoItem, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: b */
    public VideoHoloder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "961734044")) {
            return (VideoHoloder) ipChange.ipc$dispatch("961734044", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.a.getContext()).inflate(R$layout.mine_user_video_item, viewGroup, false);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, t60.a(this.a.getContext(), 260.0f)));
        return new VideoHoloder(this, inflate);
    }

    public void c(List<VideoItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1083597441")) {
            ipChange.ipc$dispatch("1083597441", new Object[]{this, list});
            return;
        }
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "409953840") ? ((Integer) ipChange.ipc$dispatch("409953840", new Object[]{this})).intValue() : this.b.size();
    }
}
