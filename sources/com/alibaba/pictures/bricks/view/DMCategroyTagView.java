package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DMCategroyTagView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView mTagName;
    private DMCategroyTagType mTagType;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum DMCategroyTagType {
        TAG_TYPE_DEFAULT,
        TAG_TYPE_PREFERENTIAL
    }

    public DMCategroyTagView(@NonNull Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "941091740")) {
            ipChange.ipc$dispatch("941091740", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.bricks_uikit_category_tag_view, this);
        this.mTagName = (TextView) findViewById(R$id.uikit_tag_view_name);
        updateTagView();
    }

    private void updateTagView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "616590515")) {
            ipChange.ipc$dispatch("616590515", new Object[]{this});
            return;
        }
        int[] iArr = null;
        DMCategroyTagType dMCategroyTagType = this.mTagType;
        if (dMCategroyTagType == DMCategroyTagType.TAG_TYPE_DEFAULT) {
            iArr = new int[]{Color.parseColor("#CC000000"), Color.parseColor("#CC000000")};
        } else if (dMCategroyTagType == DMCategroyTagType.TAG_TYPE_PREFERENTIAL) {
            iArr = new int[]{Color.parseColor("#FF2869"), Color.parseColor("#FF3299")};
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        gradientDrawable.setCornerRadius(s60.INSTANCE.b(getContext(), 4));
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(gradientDrawable);
        } else {
            setBackgroundDrawable(gradientDrawable);
        }
    }

    public void setTagName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1852711032")) {
            ipChange.ipc$dispatch("-1852711032", new Object[]{this, str});
        } else if (this.mTagName == null) {
        } else {
            if (!TextUtils.isEmpty(str)) {
                this.mTagName.setText(str);
                this.mTagName.setVisibility(0);
                return;
            }
            this.mTagName.setVisibility(8);
        }
    }

    public void setTagType(DMCategroyTagType dMCategroyTagType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-470063761")) {
            ipChange.ipc$dispatch("-470063761", new Object[]{this, dMCategroyTagType});
            return;
        }
        this.mTagType = dMCategroyTagType;
        updateTagView();
    }

    public DMCategroyTagView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMCategroyTagView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTagType = DMCategroyTagType.TAG_TYPE_DEFAULT;
        initView(context);
    }
}
