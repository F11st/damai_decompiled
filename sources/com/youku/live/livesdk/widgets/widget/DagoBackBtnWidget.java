package com.youku.live.livesdk.widgets.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.utils.ViewUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.image.IImageLoaderFactory;
import com.youku.live.livesdk.R;
import com.youku.live.livesdk.monitor.page.LivePageTaskHolder;
import com.youku.live.widgets.impl.BaseWidget;
import com.youku.live.widgets.protocol.ICall;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IProps;
import com.youku.live.widgets.protocol.IResult;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.protocol.IWidgetData;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DagoBackBtnWidget extends BaseWidget implements ICall {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String METHOD_HIDE = "hide";
    public static final String METHOD_SHOW = "show";
    public static final String SRC_PROP = "src";
    ImageView mImageView;
    private boolean mIsVisible = true;

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2144831516")) {
            ipChange.ipc$dispatch("2144831516", new Object[]{this});
            return;
        }
        Activity activity = ViewUtils.getActivity(getEngineInstance().getContext());
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477406723")) {
            ipChange.ipc$dispatch("-477406723", new Object[]{this});
            return;
        }
        IProps props = getProps();
        if (props != null) {
            render(props.getString("src", null));
        }
    }

    private void render(String str) {
        ImageView imageView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "964969002")) {
            ipChange.ipc$dispatch("964969002", new Object[]{this, str});
        } else if (str == null || (imageView = this.mImageView) == null) {
        } else {
            ((IImageLoaderFactory) Dsl.getService(IImageLoaderFactory.class)).createInstance().loadUrl(str).into(imageView);
        }
    }

    private void updateVisibility() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2113718821")) {
            ipChange.ipc$dispatch("-2113718821", new Object[]{this});
            return;
        }
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setVisibility(this.mIsVisible ? 0 : 4);
        }
    }

    @Override // com.youku.live.widgets.protocol.ICall
    public void call(IEngineInstance iEngineInstance, String str, Map<String, Object> map, IResult iResult, IResult iResult2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112692618")) {
            ipChange.ipc$dispatch("112692618", new Object[]{this, iEngineInstance, str, map, iResult, iResult2});
            return;
        }
        if ("show".equals(str)) {
            this.mIsVisible = true;
        } else if ("hide".equals(str)) {
            this.mIsVisible = false;
        }
        updateVisibility();
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void didUnmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-895799819")) {
            ipChange.ipc$dispatch("-895799819", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public View initHostView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "265475633")) {
            return (View) ipChange.ipc$dispatch("265475633", new Object[]{this, context});
        }
        if (this.mImageView == null) {
            this.mImageView = new ImageView(context);
        }
        this.mImageView.setImageResource(R.drawable.dago_icon_back_btn);
        this.mImageView.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.livesdk.widgets.widget.DagoBackBtnWidget.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "645010036")) {
                    ipChange2.ipc$dispatch("645010036", new Object[]{this, view});
                } else {
                    DagoBackBtnWidget.this.close();
                }
            }
        });
        this.mIsVisible = true;
        updateVisibility();
        this.mImageView.setTag("BackBtn");
        return this.mImageView;
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IWidgetViewInitInterface
    public void initWithData(IEngineInstance iEngineInstance, IWidget iWidget, IWidgetData iWidgetData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1339673207")) {
            ipChange.ipc$dispatch("-1339673207", new Object[]{this, iEngineInstance, iWidget, iWidgetData});
            return;
        }
        super.initWithData(iEngineInstance, iWidget, iWidgetData);
        LivePageTaskHolder.getInstance().addPageNormalTask((Activity) this.mImageView.getContext(), true, new Runnable() { // from class: com.youku.live.livesdk.widgets.widget.DagoBackBtnWidget.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1035070245")) {
                    ipChange2.ipc$dispatch("-1035070245", new Object[]{this});
                } else {
                    DagoBackBtnWidget.this.initWithNothing();
                }
            }
        }, "DagoBackBtnWidget_initWithNothing");
    }

    @Override // com.youku.live.widgets.impl.BaseWidget, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void willMount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1664375603")) {
            ipChange.ipc$dispatch("-1664375603", new Object[]{this});
        }
    }
}
