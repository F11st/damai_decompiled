package cn.damai.tetris.component.ip;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.tetris.component.ip.bean.ContentInfo;
import cn.damai.tetris.component.ip.bean.VideoAlbum;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.image.C2497a;
import cn.damai.uikit.image.IImageLoader;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.uikit.view.round.RoundImageView2;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.C9175gc;
import tb.C9548pb;
import tb.cs;
import tb.qx2;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IpVideoAlbumAdapter extends RecyclerView.Adapter<C1913b> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<VideoAlbum> a;
    private Context b;
    private BasePresenter c;
    private int d = 1;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.ip.IpVideoAlbumAdapter$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1912a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ VideoAlbum a;
        final /* synthetic */ int b;

        View$OnClickListenerC1912a(VideoAlbum videoAlbum, int i) {
            this.a = videoAlbum;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2126731156")) {
                ipChange.ipc$dispatch("-2126731156", new Object[]{this, view});
                return;
            }
            if (this.a.contentTag == 2) {
                NavProxy.from(IpVideoAlbumAdapter.this.b).withExtras(IpVideoAlbumAdapter.this.c(this.a, Integer.valueOf(this.b))).toUri(INavUri.page("videobrowse"));
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("contentId", this.a.getId());
                NavProxy.from(IpVideoAlbumAdapter.this.b).withExtras(bundle).toUri(INavUri.page(cs.DISCOVER_CONTENT_DETAIL));
            }
            if (IpVideoAlbumAdapter.this.c != null) {
                BasePresenter basePresenter = IpVideoAlbumAdapter.this.c;
                basePresenter.userTrackClick("item_" + this.b, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.ip.IpVideoAlbumAdapter$b */
    /* loaded from: classes7.dex */
    public class C1913b extends RecyclerView.ViewHolder {
        public RoundImageView2 a;
        public TextView b;
        public ImageView c;
        public TextView d;
        public View e;
        public TextView f;
        public View g;
        public ImageView h;

        public C1913b(IpVideoAlbumAdapter ipVideoAlbumAdapter, View view) {
            super(view);
            this.a = (RoundImageView2) view.findViewById(R$id.ip_album_item_pic);
            this.b = (TextView) view.findViewById(R$id.ip_video_album_item_comment);
            this.c = (ImageView) view.findViewById(R$id.ip_video_album_item_header);
            this.d = (TextView) view.findViewById(R$id.ip_video_album_item_name);
            this.e = view.findViewById(R$id.ip_video_pic_tip);
            this.f = (TextView) view.findViewById(R$id.ip_video_pic_tiptv);
            this.g = view.findViewById(R$id.ip_video_album_play);
            this.h = (ImageView) view.findViewById(R$id.ip_video_album_usericon);
        }
    }

    public IpVideoAlbumAdapter(Context context, List list, BasePresenter basePresenter) {
        this.b = context;
        this.a = list;
        this.c = basePresenter;
    }

    private void g(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-325897055")) {
            ipChange.ipc$dispatch("-325897055", new Object[]{this, str, imageView});
        } else if ("1".equals(str)) {
            f(R$drawable.uikit_user_tag_editor_mai, imageView);
        } else if ("2".equals(str)) {
            f(R$drawable.uikit_user_tag_official, imageView);
        } else if ("3".equals(str)) {
            f(R$drawable.uikit_user_tag_city_amusement, imageView);
        }
    }

    public Bundle c(VideoAlbum videoAlbum, Object obj) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1143866530")) {
            return (Bundle) ipChange.ipc$dispatch("1143866530", new Object[]{this, videoAlbum, obj});
        }
        Bundle bundle = new Bundle();
        if (videoAlbum == null) {
            return bundle;
        }
        if (obj != null) {
            try {
                i = Integer.parseInt(String.valueOf(obj));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        bundle.putInt("position", i);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setTitle(videoAlbum.getContent());
        videoInfo.setPicUrl(videoAlbum.getPic());
        videoInfo.setVideoUrl(videoAlbum.getVideoInfo().getUrl());
        videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
        arrayList.add(videoInfo);
        bundle.putParcelableArrayList("video_info", arrayList);
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(C1913b c1913b, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "500001123")) {
            ipChange.ipc$dispatch("500001123", new Object[]{this, c1913b, Integer.valueOf(i)});
            return;
        }
        VideoAlbum videoAlbum = this.a.get(i);
        if (videoAlbum == null) {
            return;
        }
        String pic = videoAlbum.getPic();
        if (videoAlbum.contentTag > 0) {
            c1913b.e.setVisibility(0);
            int i2 = videoAlbum.contentTag;
            if (i2 == 1) {
                c1913b.f.setText("图文");
                c1913b.g.setVisibility(8);
                pic = videoAlbum.getPic();
            } else if (i2 == 2) {
                c1913b.f.setText(qx2.h(videoAlbum.getVideoInfo().videoTime));
                c1913b.g.setVisibility(0);
                if (videoAlbum.getVideoInfo() != null) {
                    pic = videoAlbum.getVideoInfo().getCoverUrl();
                }
            }
        } else {
            c1913b.e.setVisibility(8);
        }
        IImageLoader a = C2497a.a();
        RoundImageView2 roundImageView2 = c1913b.a;
        int i3 = cn.damai.commonbusiness.R$drawable.uikit_default_image_bg_grey;
        a.loadinto(pic, roundImageView2, i3, i3);
        if (videoAlbum.baseUserDO != null) {
            C2497a.a().loadinto(videoAlbum.baseUserDO.headImg, c1913b.c, i3, i3);
            C9175gc.a(c1913b.d, videoAlbum.baseUserDO.nickName);
            g(videoAlbum.baseUserDO.userTypeCode, c1913b.h);
        }
        ContentInfo contentInfo = videoAlbum.contentInfo;
        if (contentInfo != null) {
            C9175gc.a(c1913b.b, contentInfo.title);
        }
        if (i == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) c1913b.itemView.getLayoutParams();
            marginLayoutParams.setMargins(t60.a(this.b, 21.0f), 0, t60.a(this.b, 12.0f), 0);
            c1913b.itemView.setLayoutParams(marginLayoutParams);
        }
        if (this.c.getModel() != null && this.c.getModel().getTrackInfo() != null) {
            this.c.getModel().getTrackInfo().put(C9548pb.PRE_CONTENT_ID, (Object) videoAlbum.getId());
            this.c.getModel().getTrackInfo().put(C9548pb.PRE_CONTENT_TYPE, (Object) "video");
        }
        c1913b.a.setOnClickListener(new View$OnClickListenerC1912a(videoAlbum, i));
        BasePresenter basePresenter = this.c;
        if (basePresenter != null) {
            RoundImageView2 roundImageView22 = c1913b.a;
            basePresenter.userTrackExpose(roundImageView22, "item_" + i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public C1913b onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "806194803")) {
            return (C1913b) ipChange.ipc$dispatch("806194803", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.b).inflate(R$layout.ip_video_album_item, viewGroup, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t60.a(this.b, 208.0f), -1);
        layoutParams.setMargins(0, 0, t60.a(this.b, 12.0f), 0);
        inflate.setLayoutParams(layoutParams);
        return new C1913b(this, inflate);
    }

    public void f(@DrawableRes int i, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1211042961")) {
            ipChange.ipc$dispatch("-1211042961", new Object[]{this, Integer.valueOf(i), imageView});
        } else if (imageView == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1517764069")) {
            return ((Integer) ipChange.ipc$dispatch("-1517764069", new Object[]{this})).intValue();
        }
        List<VideoAlbum> list = this.a;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829685438")) {
            return ((Integer) ipChange.ipc$dispatch("-1829685438", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        List<VideoAlbum> list = this.a;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.d;
    }
}
