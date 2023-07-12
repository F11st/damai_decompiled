package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.uikit.tag.DMPeopleSeeTagView;
import cn.damai.uikit.view.DMLabelView;
import cn.damai.uikit.view.DMRatingBar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class cz1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private DMLabelView b;
    private ImageView c;
    private TextView d;
    private DMPeopleSeeTagView e;
    private DMRatingBar f;
    private TextView g;

    public cz1(View view) {
        this.a = view.getContext();
        this.b = (DMLabelView) view.findViewById(R$id.label_view);
        this.c = (ImageView) view.findViewById(R$id.image_tag);
        this.d = (TextView) view.findViewById(R$id.tv_order_num);
        this.e = (DMPeopleSeeTagView) view.findViewById(R$id.view_tag_num);
        this.f = (DMRatingBar) view.findViewById(R$id.rank_bar_rating);
        this.g = (TextView) view.findViewById(R$id.rank_item_score);
    }

    public void a(int i, String str, int i2, int i3, double d, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086039886")) {
            ipChange.ipc$dispatch("1086039886", new Object[]{this, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d), Integer.valueOf(i4)});
            return;
        }
        if (i == 1) {
            com.alibaba.pictures.bricks.view.DMLabelView bgColor = this.b.setLabelHeight(l62.a(this.a, 24.0f)).setPaddingLeft(l62.a(this.a, 9.0f)).setPaddingRight(l62.a(this.a, 18.0f)).setBgColor("#FF5A5A", "#FF42B0");
            bgColor.setLabelName("NO." + i).setLabelTextSize(14.0f);
        } else if (i == 2) {
            com.alibaba.pictures.bricks.view.DMLabelView bgColor2 = this.b.setLabelHeight(l62.a(this.a, 24.0f)).setPaddingLeft(l62.a(this.a, 9.0f)).setPaddingRight(l62.a(this.a, 18.0f)).setBgColor("#FF833C", "#FF4A72");
            bgColor2.setLabelName("NO." + i).setLabelTextSize(14.0f);
        } else if (i != 3) {
            com.alibaba.pictures.bricks.view.DMLabelView bgColor3 = this.b.setLabelHeight(l62.a(this.a, 24.0f)).setPaddingLeft(l62.a(this.a, 9.0f)).setPaddingRight(l62.a(this.a, 18.0f)).setBgColor("#6A7A99", "#98A7C2");
            bgColor3.setLabelName("NO." + i).setLabelTextSize(14.0f);
        } else {
            com.alibaba.pictures.bricks.view.DMLabelView bgColor4 = this.b.setLabelHeight(l62.a(this.a, 24.0f)).setPaddingLeft(l62.a(this.a, 9.0f)).setPaddingRight(l62.a(this.a, 18.0f)).setBgColor("#FFDA00", "#FFAD00");
            bgColor4.setLabelName("NO." + i).setLabelTextSize(14.0f);
        }
        if (TextUtils.isEmpty(str)) {
            this.c.setImageResource(R$drawable.rank_tag_new);
            this.d.setText("");
        } else {
            int parseInt = Integer.parseInt(str);
            if (parseInt == 0) {
                this.c.setImageResource(R$drawable.rank_tag_ping);
                this.d.setText("");
            } else if (parseInt < 0) {
                this.c.setImageResource(R$drawable.rank_tag_down);
                TextView textView = this.d;
                textView.setText(Math.abs(parseInt) + "");
            } else {
                this.c.setImageResource(R$drawable.rank_tag_up);
                TextView textView2 = this.d;
                textView2.setText(Math.abs(parseInt) + "");
            }
        }
        if (i4 == 3) {
            if (i3 != 0 && d != 0.0d) {
                this.f.setVisibility(0);
                this.g.setVisibility(0);
                this.f.setStarMark(i3 / 2.0f);
                TextView textView3 = this.g;
                textView3.setText(d + "");
            } else {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
            }
            this.e.setVisibility(8);
            return;
        }
        if (i2 > 0) {
            this.e.setVisibility(0);
            this.e.setPeopleNum(i2);
            this.e.setPadding(0, l62.a(this.a, 6.0f), 0, 0);
        } else {
            this.e.setVisibility(8);
        }
        this.f.setVisibility(8);
        this.g.setVisibility(8);
    }
}
