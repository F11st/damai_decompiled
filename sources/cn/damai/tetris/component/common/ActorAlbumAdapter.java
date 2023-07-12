package cn.damai.tetris.component.common;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.common.bean.ActorBean;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.uikit.image.C2497a;
import cn.damai.uikit.view.DMLRLabelView;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cs;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ActorAlbumAdapter extends RecyclerView.Adapter<C1795b> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ActorBean> a;
    private Context b;
    private BasePresenter c;
    private int d = 1;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.common.ActorAlbumAdapter$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1794a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ActorBean a;
        final /* synthetic */ int b;

        View$OnClickListenerC1794a(ActorBean actorBean, int i) {
            this.a = actorBean;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1032304529")) {
                ipChange.ipc$dispatch("1032304529", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(FeedsViewModel.ARG_USERID, this.a.getArtistId());
            bundle.putString("usertype", "2");
            DMNav.from(ActorAlbumAdapter.this.b).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
            if (ActorAlbumAdapter.this.c != null) {
                BasePresenter basePresenter = ActorAlbumAdapter.this.c;
                basePresenter.userTrackClick("artist_" + this.b, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.common.ActorAlbumAdapter$b */
    /* loaded from: classes7.dex */
    public class C1795b extends RecyclerView.ViewHolder {
        public ImageView a;
        public DMLRLabelView b;
        public TextView c;

        public C1795b(ActorAlbumAdapter actorAlbumAdapter, View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R$id.actor_album_item_pic);
            this.b = (DMLRLabelView) view.findViewById(R$id.tv_tag);
            this.c = (TextView) view.findViewById(R$id.actor_album_item_name);
        }
    }

    public ActorAlbumAdapter(Context context, List list, BasePresenter basePresenter) {
        this.b = context;
        this.a = list;
        this.c = basePresenter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(C1795b c1795b, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-205771063")) {
            ipChange.ipc$dispatch("-205771063", new Object[]{this, c1795b, Integer.valueOf(i)});
            return;
        }
        if (i == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) c1795b.itemView.getLayoutParams();
            marginLayoutParams.setMargins(t60.a(this.b, 21.0f), 0, t60.a(this.b, 12.0f), 0);
            c1795b.itemView.setLayoutParams(marginLayoutParams);
        }
        ActorBean actorBean = this.a.get(i);
        if (actorBean == null) {
            return;
        }
        C2497a.a().loadinto(actorBean.getHeadPic(), c1795b.a);
        c1795b.b.setColor(1);
        String subtype = actorBean.getSubtype();
        if (subtype != null && subtype.length() > 3) {
            subtype = subtype.substring(0, 3) + "...";
        }
        c1795b.b.setContent("V", subtype);
        c1795b.c.setText(actorBean.getName());
        BasePresenter basePresenter = this.c;
        if (basePresenter != null) {
            basePresenter.userTrackExpose(c1795b.a, "artist_" + i);
        }
        c1795b.itemView.setOnClickListener(new View$OnClickListenerC1794a(actorBean, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public C1795b onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-234602163")) {
            return (C1795b) ipChange.ipc$dispatch("-234602163", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.b).inflate(R$layout.actor_album_item, viewGroup, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t60.a(this.b, 80.0f), -1);
        layoutParams.setMargins(0, 0, t60.a(this.b, 12.0f), 0);
        inflate.setLayoutParams(layoutParams);
        return new C1795b(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-27739328")) {
            return ((Integer) ipChange.ipc$dispatch("-27739328", new Object[]{this})).intValue();
        }
        List<ActorBean> list = this.a;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1557785113")) {
            return ((Integer) ipChange.ipc$dispatch("-1557785113", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        List<ActorBean> list = this.a;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.d;
    }
}
