package com.youku.live.dago.view.dagocustomelement;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.image.IImageLoaderFactory;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PopImageLayout extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private View pointView;
    private ImageView popImage;
    private View view;

    public PopImageLayout(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1855422868")) {
            ipChange.ipc$dispatch("1855422868", new Object[]{this, context});
            return;
        }
        setClipToPadding(false);
        setClipChildren(false);
        View inflate = LayoutInflater.from(context).inflate(R.layout.dago_player_interact_pop_image_layout, this);
        this.view = inflate;
        this.popImage = (ImageView) inflate.findViewById(R.id.dago_pop_image);
        this.pointView = this.view.findViewById(R.id.dago_pop_point);
    }

    public void setData(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-208553047")) {
            ipChange.ipc$dispatch("-208553047", new Object[]{this, str, str2});
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            ((IImageLoaderFactory) Dsl.getService(IImageLoaderFactory.class)).createInstance().loadUrl(str).into(this.popImage);
        } else {
            this.popImage.setImageDrawable(null);
        }
        if ("0".equals(str2)) {
            this.pointView.setVisibility(0);
        } else if ("-1".equals(str2)) {
            this.pointView.setVisibility(8);
        } else {
            this.pointView.setVisibility(8);
        }
    }

    public PopImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public PopImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
