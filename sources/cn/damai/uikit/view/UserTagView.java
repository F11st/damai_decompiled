package cn.damai.uikit.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class UserTagView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView tagIcon;
    private DMLabelView tagName;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum UserTagType {
        TAG_TYPE_EDITOR_MAI(1),
        TAG_TYPE_OFFICIAL(2),
        TAG_TYPE_CITY_AMUSEMENT(3),
        TAG_HIGH_LEVE_PLAYER(12),
        TAG_TYPE_OLD_VIP(4);
        
        int type;

        UserTagType(int i) {
            this.type = i;
        }
    }

    public UserTagView(Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-533932050")) {
            ipChange.ipc$dispatch("-533932050", new Object[]{this, context});
            return;
        }
        DMLabelView dMLabelView = new DMLabelView(context);
        this.tagName = dMLabelView;
        dMLabelView.setLabelHeight(q60.a(context, 16.0f));
        this.tagName.setLabelType(DMLabelType.LABEL_TYPE_CUSTOM);
        this.tagName.setPaddingLeft(q60.a(context, 22.0f));
        this.tagName.setPaddingRight(q60.a(context, 6.0f));
        this.tagName.setCornerRadii(q60.a(context, 9.0f), q60.a(context, 8.0f), q60.a(context, 8.0f), q60.a(context, 3.0f));
        this.tagName.setBgColor(Color.parseColor("#000000"), Color.parseColor("#666666"));
        addView(this.tagName);
        this.tagIcon = new ImageView(context);
        addView(this.tagIcon, new FrameLayout.LayoutParams(q60.a(context, 17.0f), q60.a(context, 16.0f)));
        setVisibility(8);
    }

    private void setTagIcon(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1932893627")) {
            ipChange.ipc$dispatch("-1932893627", new Object[]{this, Integer.valueOf(i)});
        } else if (i == UserTagType.TAG_TYPE_EDITOR_MAI.type) {
            setIconImage(R$drawable.uikit_user_tag_editor_mai);
        } else if (i == UserTagType.TAG_TYPE_OFFICIAL.type) {
            setIconImage(R$drawable.uikit_user_tag_official);
        } else if (i == UserTagType.TAG_TYPE_CITY_AMUSEMENT.type) {
            setIconImage(R$drawable.uikit_user_tag_city_amusement);
        } else if (i == UserTagType.TAG_TYPE_OLD_VIP.type) {
            setIconImage(R$drawable.uikit_user_tag_old_vip);
        } else if (i == UserTagType.TAG_HIGH_LEVE_PLAYER.type) {
            setIconImage(R$drawable.high_leve_player);
        }
    }

    public void setIconImage(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "669284084")) {
            ipChange.ipc$dispatch("669284084", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ImageView imageView = this.tagIcon;
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(i);
    }

    public void setIconSize(Context context, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1038534473")) {
            ipChange.ipc$dispatch("1038534473", new Object[]{this, context, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            this.tagIcon.setLayoutParams(new FrameLayout.LayoutParams(q60.a(context, i), q60.a(context, i2)));
        }
    }

    public void setTagName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782960630")) {
            ipChange.ipc$dispatch("782960630", new Object[]{this, str});
            return;
        }
        DMLabelView dMLabelView = this.tagName;
        if (dMLabelView == null) {
            return;
        }
        dMLabelView.setLabelName(str);
        setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    public void setTagNameVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-488636855")) {
            ipChange.ipc$dispatch("-488636855", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        DMLabelView dMLabelView = this.tagName;
        if (dMLabelView != null) {
            dMLabelView.setVisibility(i);
        }
    }

    public void setTagType(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2119685902")) {
            ipChange.ipc$dispatch("2119685902", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        setVisibility(0);
        if (!z) {
            setTagIcon(i);
        } else if (i == 3) {
            setTagIcon(i << 2);
        } else {
            setVisibility(8);
        }
    }

    public UserTagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UserTagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    public void setTagType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1871287162")) {
            ipChange.ipc$dispatch("-1871287162", new Object[]{this, Integer.valueOf(i)});
        } else {
            setTagIcon(i);
        }
    }
}
