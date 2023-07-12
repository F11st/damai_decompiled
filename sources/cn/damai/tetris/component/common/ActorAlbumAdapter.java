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
import cn.damai.uikit.view.DMLRLabelView;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cs;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ActorAlbumAdapter extends RecyclerView.Adapter<b> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ActorBean> a;
    private Context b;
    private BasePresenter c;
    private int d = 1;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ActorBean a;
        final /* synthetic */ int b;

        a(ActorBean actorBean, int i) {
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
    /* loaded from: classes7.dex */
    public class b extends RecyclerView.ViewHolder {
        public ImageView a;
        public DMLRLabelView b;
        public TextView c;

        public b(ActorAlbumAdapter actorAlbumAdapter, View view) {
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
    public void onBindViewHolder(b bVar, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-205771063")) {
            ipChange.ipc$dispatch("-205771063", new Object[]{this, bVar, Integer.valueOf(i)});
            return;
        }
        if (i == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) bVar.itemView.getLayoutParams();
            marginLayoutParams.setMargins(t60.a(this.b, 21.0f), 0, t60.a(this.b, 12.0f), 0);
            bVar.itemView.setLayoutParams(marginLayoutParams);
        }
        ActorBean actorBean = this.a.get(i);
        if (actorBean == null) {
            return;
        }
        cn.damai.uikit.image.a.a().loadinto(actorBean.getHeadPic(), bVar.a);
        bVar.b.setColor(1);
        String subtype = actorBean.getSubtype();
        if (subtype != null && subtype.length() > 3) {
            subtype = subtype.substring(0, 3) + "...";
        }
        bVar.b.setContent("V", subtype);
        bVar.c.setText(actorBean.getName());
        BasePresenter basePresenter = this.c;
        if (basePresenter != null) {
            basePresenter.userTrackExpose(bVar.a, "artist_" + i);
        }
        bVar.itemView.setOnClickListener(new a(actorBean, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-234602163")) {
            return (b) ipChange.ipc$dispatch("-234602163", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.b).inflate(R$layout.actor_album_item, viewGroup, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t60.a(this.b, 80.0f), -1);
        layoutParams.setMargins(0, 0, t60.a(this.b, 12.0f), 0);
        inflate.setLayoutParams(layoutParams);
        return new b(this, inflate);
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
