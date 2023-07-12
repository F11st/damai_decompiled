package cn.damai.evaluate.ui.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.view.DMTagView;
import cn.damai.comment.view.PraiseView;
import cn.damai.evaluate.view.DMEvaluateProjectCardView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.uikit.view.DMRatingBar;
import cn.damai.uikit.view.NineGridlayout;
import cn.damai.uikit.view.UserTagView;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class EvaluateItemViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    public TextView A;
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public DMRatingBar g;
    public TextView h;
    public TextView i;
    public ImageView j;
    public UserTagView k;
    public DMIconFontTextView l;
    public DMIconFontTextView m;
    public RelativeLayout n;
    public RelativeLayout o;
    public LinearLayout p;
    public LinearLayout q;
    public PraiseView r;
    public NineGridlayout s;
    public DMAvatar t;
    public DMEvaluateProjectCardView u;
    public ImageView v;
    public ImageView w;
    public View x;
    public View y;
    public DMTagView z;

    public EvaluateItemViewHolder(@NonNull View view) {
        super(view);
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2028919486")) {
            ipChange.ipc$dispatch("2028919486", new Object[]{this});
            return;
        }
        this.n = (RelativeLayout) this.itemView.findViewById(R$id.evaluate_item_layout);
        RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.comment_userinfo_layout);
        this.p = (LinearLayout) this.itemView.findViewById(R$id.comment_userinfo_view);
        this.a = (TextView) this.itemView.findViewById(R$id.comment_user_name);
        this.c = (TextView) this.itemView.findViewById(R$id.comment_content);
        this.e = (TextView) this.itemView.findViewById(cn.damai.commonbusiness.R$id.common_exptext_btn);
        this.g = (DMRatingBar) this.itemView.findViewById(R$id.evaluate_grade_view);
        this.y = this.itemView.findViewById(R$id.user_ratingbar);
        this.h = (TextView) this.itemView.findViewById(R$id.comment_score);
        this.b = (TextView) this.itemView.findViewById(R$id.comment_date_city);
        this.f = (TextView) this.itemView.findViewById(R$id.comment_date_indetail);
        DMAvatar dMAvatar = (DMAvatar) this.itemView.findViewById(R$id.uikit_damai_avatar);
        this.t = dMAvatar;
        dMAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_40x40);
        this.j = (ImageView) this.itemView.findViewById(R$id.comment_vip_icon);
        this.k = (UserTagView) this.itemView.findViewById(R$id.user_tag_view);
        this.s = (NineGridlayout) this.itemView.findViewById(R$id.nine_image_layout);
        this.l = (DMIconFontTextView) this.itemView.findViewById(R$id.comment_detail_maincomment_more);
        this.m = (DMIconFontTextView) this.itemView.findViewById(R$id.comment_detail_comment_delete);
        this.q = (LinearLayout) this.itemView.findViewById(R$id.comment_layout);
        this.d = (TextView) this.itemView.findViewById(R$id.comment_num);
        this.o = (RelativeLayout) this.itemView.findViewById(R$id.subreply_layout);
        this.i = (TextView) this.itemView.findViewById(R$id.sub_reply_content);
        this.r = (PraiseView) this.itemView.findViewById(R$id.comment_praise_layout);
        this.u = (DMEvaluateProjectCardView) this.itemView.findViewById(R$id.evaluate_project_info);
        this.v = (ImageView) this.itemView.findViewById(R$id.iv_comment_luxury);
        this.w = (ImageView) this.itemView.findViewById(R$id.evaluate_spoiler_view);
        this.x = this.itemView.findViewById(R$id.evaluate_bottom_line);
        this.z = (DMTagView) this.itemView.findViewById(R$id.evaluate_dm_info_tag_view);
        this.A = (TextView) this.itemView.findViewById(R$id.comment_has_played_icon);
    }

    public EvaluateItemViewHolder(Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.evaluate_item_layout, (ViewGroup) null));
        init();
    }
}
