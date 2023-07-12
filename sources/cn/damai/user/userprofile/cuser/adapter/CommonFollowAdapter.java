package cn.damai.user.userprofile.cuser.adapter;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.repertoite.view.AttentionView;
import cn.damai.user.userprofile.FeedsViewModel;
import cn.damai.user.userprofile.UserIndexViewModel;
import cn.damai.user.userprofile.cuser.bean.CommonFavObject;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.cs;
import tb.iv2;
import tb.t60;
import tb.u12;
import tb.vr;
import tb.z20;
import tb.zq;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class CommonFollowAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<CommonFavObject> a;
    private Context b;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public DMAvatar a;
        public TextView b;
        public AttentionView c;

        public ViewHolder(View view, DMAvatar dMAvatar, TextView textView, AttentionView attentionView) {
            super(view);
            this.a = dMAvatar;
            this.b = textView;
            this.c = attentionView;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommonFavObject a;
        final /* synthetic */ int b;

        a(CommonFavObject commonFavObject, int i) {
            this.a = commonFavObject;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "795898419")) {
                ipChange.ipc$dispatch("795898419", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            CommonFavObject commonFavObject = this.a;
            CommonFollowAdapter.this.b(bundle, commonFavObject.id, commonFavObject.type);
            CommonFollowAdapter.this.e(this.b, this.a.id + "&" + this.a.type);
        }
    }

    public CommonFollowAdapter(Context context, List<CommonFavObject> list) {
        this.b = context;
        this.a = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Bundle bundle, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1412282276")) {
            ipChange.ipc$dispatch("-1412282276", new Object[]{this, bundle, str, Integer.valueOf(i)});
        } else if (i == 1) {
            bundle.putString(FeedsViewModel.ARG_USERID, str);
            DMNav.from(this.b).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
        } else if (i == 2) {
            bundle.putString("artistid", str);
            DMNav.from(this.b).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
        } else if (i == 4) {
            bundle.putString("brandid", str);
            DMNav.from(this.b).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
        } else if (i != 5) {
        } else {
            bundle.putString(RepertoireDetailFragment.REPERTOIREID, str);
            DMNav.from(this.b).withExtras(bundle).toUri(NavUri.b(u12.REPERTOITE));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-655678743")) {
            ipChange.ipc$dispatch("-655678743", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        CommonFavObject commonFavObject = this.a.get(i);
        if (viewHolder.a.getTag() instanceof vr) {
            ((vr) viewHolder.a.getTag()).cancel();
        }
        new zq(0.0f, 0, t60.a(this.b, 0.5f), this.b.getResources().getColor(R$color.color_6black));
        viewHolder.a.setAvatar(commonFavObject.pic);
        viewHolder.a.setOnClickListener(new a(commonFavObject, i));
        viewHolder.b.setText(commonFavObject.name);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "615463469")) {
            return (ViewHolder) ipChange.ipc$dispatch("615463469", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(t60.a(this.b, 80.0f), -2);
        layoutParams.setMargins(0, 0, t60.a(this.b, 15.0f), 0);
        layoutParams.gravity = 1;
        linearLayout.setLayoutParams(layoutParams);
        DMAvatar dMAvatar = new DMAvatar(viewGroup.getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        dMAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_60x60);
        layoutParams2.addRule(13);
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        ViewGroup.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(t60.a(this.b, 80.0f), t60.a(this.b, 80.0f));
        relativeLayout.addView(dMAvatar, layoutParams2);
        linearLayout.addView(relativeLayout, layoutParams3);
        TextView textView = new TextView(viewGroup.getContext());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(t60.a(this.b, 80.0f), -2);
        layoutParams4.setMargins(0, t60.a(this.b, 12.0f), 0, 0);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextSize(14.0f);
        textView.setText("名字");
        textView.setTextColor(viewGroup.getResources().getColor(R$color.color_111111));
        textView.setGravity(17);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams4.setLayoutDirection(17);
        }
        textView.setLayoutParams(layoutParams4);
        linearLayout.addView(textView);
        AttentionView attentionView = new AttentionView(viewGroup.getContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(t60.a(this.b, 69.0f), t60.a(this.b, 30.0f));
        layoutParams5.setMargins(t60.a(this.b, 5.5f), t60.a(this.b, 12.0f), 0, 0);
        attentionView.setBackGroundState(R$drawable.user_attention_bg_gray, R$drawable.star_attention_bg_red);
        attentionView.setTextColorState(R$color.color_888888, R$color.color_white);
        attentionView.setLayoutParams(layoutParams5);
        linearLayout.addView(attentionView);
        return new ViewHolder(linearLayout, dMAvatar, textView, attentionView);
    }

    public void e(int i, String str) {
        UserIndexViewModel userIndexViewModel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1328584343")) {
            ipChange.ipc$dispatch("1328584343", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        Context context = this.b;
        if ((context instanceof FragmentActivity) && (userIndexViewModel = (UserIndexViewModel) ViewModelProviders.of((FragmentActivity) context).get(UserIndexViewModel.class)) != null) {
            hashMap.put("contentlabel", userIndexViewModel.userid);
        }
        hashMap.put("titlelabel", str);
        b bVar = new b();
        c.e().x(bVar.e(iv2.USER_HOME_PAGE, "taste", "follow_" + i, hashMap, Boolean.TRUE));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-855705118") ? ((Integer) ipChange.ipc$dispatch("-855705118", new Object[]{this})).intValue() : this.a.size();
    }
}
