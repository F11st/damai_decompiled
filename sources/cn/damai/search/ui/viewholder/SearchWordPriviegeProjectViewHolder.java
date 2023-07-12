package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.comment.bean.StoreInfo;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.b82;
import tb.q60;
import tb.vr;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchWordPriviegeProjectViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private Context b;
    private RoundImageView c;
    private TextView d;
    private TextView e;
    private FrameLayout f;
    TextView g;
    View h;

    public SearchWordPriviegeProjectViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.search_list_privilege_issue_project, (ViewGroup) null));
        this.a = 0;
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.b = context;
        c(this.itemView);
    }

    public static String a(String str, Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "940661329")) {
            return (String) ipChange.ipc$dispatch("940661329", new Object[]{str, l});
        }
        if (l != null && l.longValue() != 0 && !TextUtils.isEmpty(str)) {
            return StoreInfo.geCountText(String.valueOf(l)) + "人去玩过 | " + str;
        } else if (l == null || l.longValue() == 0) {
            return !TextUtils.isEmpty(str) ? str : "";
        } else {
            return StoreInfo.geCountText(String.valueOf(l)) + "人去玩过";
        }
    }

    private void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1729350090")) {
            ipChange.ipc$dispatch("1729350090", new Object[]{this, view});
            return;
        }
        this.f = (FrameLayout) view.findViewById(R$id.iv_project_image_layout);
        this.c = (RoundImageView) view.findViewById(R$id.iv_project_image);
        this.d = (TextView) view.findViewById(R$id.tv_project_name);
        this.e = (TextView) view.findViewById(R$id.tv_project_time);
    }

    private void d(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1678487130")) {
            ipChange.ipc$dispatch("1678487130", new Object[]{this, str, str2});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "时间待定";
        }
        if (!TextUtils.isEmpty(str2)) {
            TextView textView = this.e;
            textView.setText(str + " | " + str2);
            return;
        }
        TextView textView2 = this.e;
        textView2.setText(str + " | 场馆待定");
    }

    private void e(TextView textView, List<String> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-109902685")) {
            ipChange.ipc$dispatch("-109902685", new Object[]{this, textView, list, str});
            return;
        }
        int size = list == null ? 0 : list.size();
        if (size == 0) {
            textView.setText(str);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i = 0; i < size; i++) {
            try {
                Matcher matcher = Pattern.compile(list.get(i)).matcher(str);
                while (matcher.find()) {
                    int start = matcher.start();
                    this.a = start;
                    if (start == -1) {
                        break;
                    } else if (start >= 0) {
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ContextCompat.getColor(this.b, R$color.color_FF2D79));
                        int i2 = this.a;
                        spannableStringBuilder.setSpan(foregroundColorSpan, i2, list.get(i).length() + i2, 18);
                    }
                }
            } catch (Exception unused) {
            }
        }
        textView.setGravity(16);
        textView.setText(spannableStringBuilder);
    }

    public void b(ProjectItemBean projectItemBean, boolean z, int i, boolean z2) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-440712081")) {
            ipChange.ipc$dispatch("-440712081", new Object[]{this, projectItemBean, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)});
        } else if (projectItemBean == null) {
        } else {
            String str2 = "";
            if (i == 21) {
                if ("0".equals(projectItemBean.categoryName)) {
                    str = "topic";
                } else {
                    str = "1".equals(projectItemBean.categoryName) ? "be_evaluated" : "";
                }
                c.e().F(this.itemView, str, "top", b82.SEARCH_ITEM_ASSOCIATE);
            }
            if (z) {
                TextView textView = this.g;
                if (textView != null) {
                    ((ViewGroup) this.itemView).removeView(textView);
                }
                TextView textView2 = new TextView(this.b);
                this.g = textView2;
                if (i == 13) {
                    textView2.setText("当前在售");
                } else if (i == 21) {
                    if ("0".equals(projectItemBean.categoryName)) {
                        this.g.setText("主题关联项目");
                    } else if ("1".equals(projectItemBean.categoryName)) {
                        this.g.setText("待评价项目");
                    }
                } else {
                    textView2.setText("往期项目");
                }
                this.g.setTextSize(1, 16.0f);
                this.g.setTextColor(this.b.getResources().getColor(cn.damai.homepage.R$color.black));
                this.g.setGravity(115);
                this.g.setPadding(0, 0, 0, q60.a(this.b, 15.0f));
                ((ViewGroup) this.itemView).addView(this.g, 0, new LinearLayout.LayoutParams(-1, -2));
                if (z2 && (i == 17 || i == 21)) {
                    View view = this.h;
                    if (view != null) {
                        ((ViewGroup) this.itemView).removeView(view);
                    }
                    View view2 = new View(this.b);
                    this.h = view2;
                    view2.setBackgroundColor(this.b.getResources().getColor(cn.damai.homepage.R$color.color_eeeeee));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
                    layoutParams.setMargins(0, 0, 0, q60.a(this.b, 15.0f));
                    ((ViewGroup) this.itemView).addView(this.h, 0, layoutParams);
                }
            } else {
                TextView textView3 = this.g;
                if (textView3 != null) {
                    ((ViewGroup) this.itemView).removeView(textView3);
                    this.g = null;
                }
                View view3 = this.h;
                if (view3 != null) {
                    ((ViewGroup) this.itemView).removeView(view3);
                    this.h = null;
                }
            }
            Integer num = projectItemBean.itemType;
            if (num != null && num.intValue() == 1) {
                this.f.getLayoutParams().height = q60.a(this.b, 48.0f);
                this.d.setMaxLines(1);
                this.e.setText(a(projectItemBean.priceDesc, projectItemBean.playerCount));
            } else {
                this.f.getLayoutParams().height = q60.a(this.b, 68.0f);
                this.d.setMaxLines(2);
                d(projectItemBean.showTime, projectItemBean.venueName);
            }
            if (this.c.getTag() instanceof vr) {
                ((vr) this.c.getTag()).cancel();
            }
            Integer num2 = projectItemBean.itemType;
            if (num2 != null && num2.intValue() == 1) {
                DMImageCreator c = a.b().c(projectItemBean.verticalPic);
                int i2 = R$drawable.store_defult_img;
                this.c.setTag(c.i(i2).c(i2).g(this.c));
            } else {
                DMImageCreator c2 = a.b().c(projectItemBean.verticalPic);
                int i3 = R$drawable.uikit_default_image_bg_gradient;
                this.c.setTag(c2.i(i3).c(i3).g(this.c));
            }
            if (!TextUtils.isEmpty(projectItemBean.venueCity)) {
                str2 = "【" + projectItemBean.venueCity + "】";
            }
            List<String> list = projectItemBean.highlightWord;
            if ((list != null ? list.size() : 0) > 0) {
                e(this.d, projectItemBean.highlightWord, str2 + projectItemBean.name);
                return;
            }
            this.d.setText(str2 + projectItemBean.name);
        }
    }
}
