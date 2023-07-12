package com.alibaba.pictures.bricks.component.home;

import android.text.TextPaint;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.home.DMGenericHeaderView;
import com.alient.onearch.adapter.component.header.GenericHeaderView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class DMGenericHeaderView extends GenericHeaderView {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DMGenericHeaderView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderTitle$lambda-0  reason: not valid java name */
    public static final void m115renderTitle$lambda0(ImageView imageView, DMGenericHeaderView dMGenericHeaderView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "404669290")) {
            ipChange.ipc$dispatch("404669290", new Object[]{imageView, dMGenericHeaderView, successEvent});
            return;
        }
        b41.i(dMGenericHeaderView, "this$0");
        if ((successEvent != null ? successEvent.drawable : null) != null) {
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (imageView != null) {
                imageView.setImageDrawable(successEvent.drawable);
                return;
            }
            return;
        }
        if (imageView != null) {
            imageView.setImageDrawable(dMGenericHeaderView.getView().getContext().getDrawable(R$drawable.bricks_horicard_bg_titlepic));
        }
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderTitle$lambda-1  reason: not valid java name */
    public static final void m116renderTitle$lambda1(ImageView imageView, DMGenericHeaderView dMGenericHeaderView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "43015412")) {
            ipChange.ipc$dispatch("43015412", new Object[]{imageView, dMGenericHeaderView, failEvent});
            return;
        }
        b41.i(dMGenericHeaderView, "this$0");
        if (imageView != null) {
            imageView.setImageDrawable(dMGenericHeaderView.getView().getContext().getDrawable(R$drawable.bricks_horicard_bg_titlepic));
        }
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
    }

    @Override // com.alient.onearch.adapter.component.header.GenericHeaderView, com.alient.onearch.adapter.component.header.GenericHeaderContract.View
    public void renderTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-275783177")) {
            ipChange.ipc$dispatch("-275783177", new Object[]{this, str});
            return;
        }
        TextView textView = (TextView) getView().findViewById(R$id.title);
        final ImageView imageView = (ImageView) getView().findViewById(R$id.title_image);
        if (Patterns.WEB_URL.matcher(str).matches()) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageLoaderProviderProxy.getProxy().load(str, new IImageSuccListener() { // from class: tb.kr
                @Override // com.alient.oneservice.image.IImageSuccListener
                public final void onSuccess(SuccessEvent successEvent) {
                    DMGenericHeaderView.m115renderTitle$lambda0(imageView, this, successEvent);
                }
            }, new IImageFailListener() { // from class: tb.jr
                @Override // com.alient.oneservice.image.IImageFailListener
                public final void onFail(FailEvent failEvent) {
                    DMGenericHeaderView.m116renderTitle$lambda1(imageView, this, failEvent);
                }
            });
            return;
        }
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextPaint paint = textView != null ? textView.getPaint() : null;
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }
}
