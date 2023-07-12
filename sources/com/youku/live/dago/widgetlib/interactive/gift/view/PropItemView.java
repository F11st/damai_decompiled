package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftPropBean;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PropItemView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    GiftCheckableImageView checkableImageView;
    ImageView imageViewIcon;
    Animation scaleAnim;
    TextView textViewName;
    TextView textViewPropCount;
    TextView textViewTips;

    public PropItemView(Context context) {
        this(context, null);
    }

    private void showScaleAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1047109787")) {
            ipChange.ipc$dispatch("1047109787", new Object[]{this});
            return;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.1f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.1f, 1.0f));
        ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
        ofPropertyValuesHolder.setDuration(250L).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1620430758")) {
            ipChange.ipc$dispatch("1620430758", new Object[]{this});
        } else {
            super.onDetachedFromWindow();
        }
    }

    public void setData(GiftPropBean giftPropBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-825170493")) {
            ipChange.ipc$dispatch("-825170493", new Object[]{this, giftPropBean});
        } else if (giftPropBean == null) {
        } else {
            if (giftPropBean.isMoreBtn) {
                this.imageViewIcon.setBackgroundResource(R.C7941drawable.dago_pgc_ykl_more_pro_btn_bg);
                this.imageViewIcon.setImageResource(R.C7941drawable.dago_pgc_more_prop_icon);
                this.textViewName.setText(giftPropBean.name);
                return;
            }
            this.imageViewIcon.setBackgroundColor(0);
            updateSelectState(giftPropBean);
            this.textViewName.setVisibility(0);
            this.textViewName.setText(TextUtils.isEmpty(giftPropBean.name) ? "" : giftPropBean.name);
            if (giftPropBean.num == 0) {
                this.textViewTips.setVisibility(8);
            } else {
                this.textViewTips.setVisibility(0);
                TextView textView = this.textViewTips;
                textView.setText(giftPropBean.num + "个");
            }
            ur1.o().s(giftPropBean.icon).y(this.imageViewIcon);
            this.checkableImageView.setTag(giftPropBean.id);
        }
    }

    public void updateCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373234320")) {
            ipChange.ipc$dispatch("373234320", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        TextView textView = this.textViewPropCount;
        textView.setText(i + "");
    }

    public void updateData(GiftPropBean giftPropBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "134247156")) {
            ipChange.ipc$dispatch("134247156", new Object[]{this, giftPropBean});
        } else if (giftPropBean == null) {
        } else {
            if (!TextUtils.isEmpty(giftPropBean.name)) {
                this.textViewName.setText(TextUtils.isEmpty(giftPropBean.name) ? "" : giftPropBean.name);
            }
            if (giftPropBean.num == 0) {
                this.textViewTips.setVisibility(8);
                return;
            }
            this.textViewTips.setVisibility(0);
            TextView textView = this.textViewTips;
            textView.setText(giftPropBean.num + "个");
        }
    }

    public void updateSelectState(GiftPropBean giftPropBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1927748483")) {
            ipChange.ipc$dispatch("1927748483", new Object[]{this, giftPropBean});
            return;
        }
        this.checkableImageView.setTag(giftPropBean.id);
        if (giftPropBean.isChecked) {
            setBackgroundResource(R.C7941drawable.dago_pgc_ykl_gift_item_bg);
            showScaleAnim();
            return;
        }
        setBackground(null);
        this.scaleAnim.cancel();
    }

    public PropItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PropItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.C7942layout.dago_pgc_ykl_prop_item_layout, (ViewGroup) this, true);
        setOrientation(1);
        this.imageViewIcon = (ImageView) findViewById(R.id.id_prop_image_icon);
        this.checkableImageView = (GiftCheckableImageView) findViewById(R.id.id_iv_prop_check_state);
        this.textViewTips = (TextView) findViewById(R.id.id_tv_prop_tip);
        this.textViewPropCount = (TextView) findViewById(R.id.id_prop_count);
        this.textViewName = (TextView) findViewById(R.id.id_tv_prop_name);
        this.scaleAnim = AnimationUtils.loadAnimation(getContext(), R.anim.dago_pgc_gift_item_selected_anim);
    }
}
