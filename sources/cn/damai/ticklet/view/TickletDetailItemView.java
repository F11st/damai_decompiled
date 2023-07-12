package cn.damai.ticklet.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TickletDetailCompViewBean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.py2;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletDetailItemView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;
    View parent;
    private LinearLayout ticklet_detail_item_layout;
    private TextView ticklet_detail_item_tip;
    private TextView ticklet_detail_item_title;
    private TextView ticklet_detail_second_title;
    private ImageView ticklet_item_image;
    private ImageView ticklet_item_title_icon;
    private DMIconFontTextView tiklet_detail_item_icon;

    public TickletDetailItemView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-303707855")) {
            ipChange.ipc$dispatch("-303707855", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_detail_item_view, this);
        this.parent = inflate;
        this.ticklet_detail_item_layout = (LinearLayout) inflate.findViewById(R$id.ticklet_detail_item_layout);
        this.ticklet_detail_item_title = (TextView) this.parent.findViewById(R$id.ticklet_detail_item_title);
        this.ticklet_item_title_icon = (ImageView) this.parent.findViewById(R$id.ticklet_item_title_icon);
        this.ticklet_item_image = (ImageView) this.parent.findViewById(R$id.ticklet_item_image);
        this.tiklet_detail_item_icon = (DMIconFontTextView) this.parent.findViewById(R$id.tiklet_detail_item_icon_arrow);
        this.ticklet_detail_item_tip = (TextView) this.parent.findViewById(R$id.ticklet_detail_item_tip);
        this.ticklet_detail_second_title = (TextView) this.parent.findViewById(R$id.ticklet_detail_second_title);
    }

    public void update(TickletDetailCompViewBean.BizData bizData, boolean z, boolean z2, View.OnClickListener onClickListener) {
        int a;
        int a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2036123118")) {
            ipChange.ipc$dispatch("2036123118", new Object[]{this, bizData, Boolean.valueOf(z), Boolean.valueOf(z2), onClickListener});
        } else if (bizData == null) {
        } else {
            if (z) {
                a = t60.a(this.context, 5.0f);
            } else {
                a = t60.a(this.context, 21.0f);
            }
            if (z2) {
                a2 = t60.a(this.context, 5.0f);
            } else {
                a2 = t60.a(this.context, 21.0f);
            }
            setPadding(0, a, 0, a2);
            py2.F(this.ticklet_detail_item_title, bizData.title);
            py2.F(this.ticklet_detail_item_tip, bizData.note);
            if (!TextUtils.isEmpty(bizData.iconUrl)) {
                py2.s(this.ticklet_item_title_icon, bizData.iconUrl, R$drawable.uikit_default_image_bg_grey);
                this.ticklet_item_title_icon.setVisibility(0);
            } else {
                this.ticklet_item_title_icon.setVisibility(8);
            }
            if (onClickListener != null) {
                setOnClickListener(onClickListener);
                this.tiklet_detail_item_icon.setVisibility(0);
                return;
            }
            setOnClickListener(null);
            this.tiklet_detail_item_icon.setVisibility(8);
        }
    }

    public TickletDetailItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletDetailItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        setMinimumHeight(t60.a(context, 54.0f));
        initView();
    }

    public void update(Object obj, boolean z, boolean z2, View.OnClickListener onClickListener) {
        int a;
        int a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "817473216")) {
            ipChange.ipc$dispatch("817473216", new Object[]{this, obj, Boolean.valueOf(z), Boolean.valueOf(z2), onClickListener});
        } else if (obj == null) {
        } else {
            TickletDetailCompViewBean tickletDetailCompViewBean = (TickletDetailCompViewBean) obj;
            if (z) {
                a = t60.a(this.context, 5.0f);
            } else {
                a = t60.a(this.context, 21.0f);
            }
            if (z2) {
                a2 = t60.a(this.context, 5.0f);
            } else {
                a2 = t60.a(this.context, 21.0f);
            }
            setPadding(0, a, 0, a2);
            py2.F(this.ticklet_detail_item_title, tickletDetailCompViewBean.title);
            py2.F(this.ticklet_detail_item_tip, tickletDetailCompViewBean.note);
            TickletDetailCompViewBean.BizData bizData = tickletDetailCompViewBean.bizData;
            if (bizData != null && !TextUtils.isEmpty(bizData.iconUrl)) {
                py2.s(this.ticklet_item_title_icon, tickletDetailCompViewBean.bizData.iconUrl, R$drawable.uikit_default_image_bg_grey);
                this.ticklet_item_title_icon.setVisibility(0);
            } else {
                this.ticklet_item_title_icon.setVisibility(8);
            }
            if (TickletDetailCompViewBean.SERVICE_RESOURCE.equals(tickletDetailCompViewBean.key)) {
                this.ticklet_detail_second_title.setVisibility(0);
                this.ticklet_detail_second_title.setText(this.context.getString(R$string.ticklet_custom_service_tip));
            } else {
                this.ticklet_detail_second_title.setVisibility(8);
            }
            TickletDetailCompViewBean.BizData bizData2 = tickletDetailCompViewBean.bizData;
            if (bizData2 != null && !TextUtils.isEmpty(bizData2.picUrl)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ticklet_item_image.getLayoutParams();
                layoutParams.height = t60.a(this.context, 68.0f);
                if (TickletDetailCompViewBean.VENUE_GUIDE_MAIN.equals(tickletDetailCompViewBean.key)) {
                    layoutParams.height = t60.a(this.context, 113.0f);
                }
                this.ticklet_item_image.setVisibility(0);
                py2.q(this.context, this.ticklet_item_image, tickletDetailCompViewBean.bizData.picUrl, R$drawable.uikit_default_image_bg_grey);
            } else {
                this.ticklet_item_image.setVisibility(8);
            }
            if (!tickletDetailCompViewBean.isNoAllowGoto()) {
                this.tiklet_detail_item_icon.setVisibility(0);
                if (onClickListener != null) {
                    setOnClickListener(onClickListener);
                    return;
                } else {
                    setOnClickListener(null);
                    return;
                }
            }
            setOnClickListener(null);
            this.tiklet_detail_item_icon.setVisibility(8);
        }
    }
}
