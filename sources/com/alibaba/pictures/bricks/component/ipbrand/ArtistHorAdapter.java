package com.alibaba.pictures.bricks.component.ipbrand;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.component.artist.BaccountInfo;
import com.alibaba.pictures.bricks.component.artist.UserTrackInterface;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.alibaba.pictures.bricks.view.DMPosterView;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistHorAdapter extends RecyclerView.Adapter<IpDramaBrandArtistHorViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<BaccountInfo> a;
    private Context b;
    private UserTrackInterface c;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class IpDramaBrandArtistHorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private TextView b;
        private TextView c;
        private DMAvatar d;
        private DMPosterView e;

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.pictures.bricks.component.ipbrand.ArtistHorAdapter$IpDramaBrandArtistHorViewHolder$a */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC3479a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ BaccountInfo a;
            final /* synthetic */ int b;

            View$OnClickListenerC3479a(BaccountInfo baccountInfo, int i) {
                this.a = baccountInfo;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1993269203")) {
                    ipChange.ipc$dispatch("-1993269203", new Object[]{this, view});
                    return;
                }
                if (ArtistHorAdapter.this.c != null) {
                    ArtistHorAdapter.this.c.userTrackClick(this.a.damaiId, this.b);
                }
                Action action = new Action();
                action.setActionType(1);
                if (TextUtils.isEmpty(this.a.schema)) {
                    action.setActionUrl("damai://V1/UserprofilePage?userType=2&userId=" + this.a.damaiId);
                } else {
                    action.setActionUrl(this.a.schema);
                }
                NavProviderProxy.getProxy().toUri(IpDramaBrandArtistHorViewHolder.this.a, action);
            }
        }

        public IpDramaBrandArtistHorViewHolder(Context context, ViewGroup viewGroup) {
            super(LayoutInflater.from(context).inflate(R$layout.bricks_component_ip_brand_artist_item, viewGroup, false));
            this.a = context;
            RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.ip_brand_artist_layout);
            this.e = (DMPosterView) this.itemView.findViewById(R$id.drama_image);
            this.d = (DMAvatar) this.itemView.findViewById(R$id.ip_brand_artist_avatar);
            this.b = (TextView) this.itemView.findViewById(R$id.ip_brand_artist_name);
            this.c = (TextView) this.itemView.findViewById(R$id.ip_brand_artist_fancount);
        }

        public void b(BaccountInfo baccountInfo, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "337528815")) {
                ipChange.ipc$dispatch("337528815", new Object[]{this, baccountInfo, Integer.valueOf(i)});
            } else if (baccountInfo == null) {
            } else {
                int i2 = R$drawable.bricks_bg_music_cardbg_0;
                int i3 = i % 4;
                if (i3 != 0) {
                    if (i3 == 1) {
                        i2 = R$drawable.bg_music_cardbg_1;
                    } else if (i3 == 2) {
                        i2 = R$drawable.bg_music_cardbg_2;
                    } else if (i3 == 3) {
                        i2 = R$drawable.bg_music_cardbg_3;
                    }
                }
                this.e.setPlaceholder(i2);
                this.d.setAvatar(baccountInfo.headPic);
                if (baccountInfo.isShowVTag()) {
                    this.d.setAvatarVTagVisibility(0);
                } else {
                    this.d.setAvatarVTagVisibility(8);
                }
                this.b.setText(baccountInfo.name);
                TextView textView = this.c;
                textView.setText(baccountInfo.fansCount + "粉丝");
                if (ArtistHorAdapter.this.c != null) {
                    ArtistHorAdapter.this.c.userTrackExpose(this.itemView, baccountInfo.damaiId, i);
                }
                this.itemView.setOnClickListener(new View$OnClickListenerC3479a(baccountInfo, i));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-105721568")) {
                ipChange.ipc$dispatch("-105721568", new Object[]{this, view});
            }
        }
    }

    public ArtistHorAdapter(Context context) {
        this.b = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onBindViewHolder(@NonNull IpDramaBrandArtistHorViewHolder ipDramaBrandArtistHorViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "958717430")) {
            ipChange.ipc$dispatch("958717430", new Object[]{this, ipDramaBrandArtistHorViewHolder, Integer.valueOf(i)});
        } else {
            ipDramaBrandArtistHorViewHolder.b(this.a.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: c */
    public IpDramaBrandArtistHorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1203541440") ? (IpDramaBrandArtistHorViewHolder) ipChange.ipc$dispatch("-1203541440", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new IpDramaBrandArtistHorViewHolder(this.b, viewGroup);
    }

    public void d(UserTrackInterface userTrackInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1349123199")) {
            ipChange.ipc$dispatch("-1349123199", new Object[]{this, userTrackInterface});
        } else {
            this.c = userTrackInterface;
        }
    }

    public void e(List<BaccountInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1767264883")) {
            ipChange.ipc$dispatch("-1767264883", new Object[]{this, list});
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599466190")) {
            return ((Integer) ipChange.ipc$dispatch("-1599466190", new Object[]{this})).intValue();
        }
        List<BaccountInfo> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
