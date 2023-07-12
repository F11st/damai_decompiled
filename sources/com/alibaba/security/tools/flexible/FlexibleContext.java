package com.alibaba.security.tools.flexible;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.tools.flexible.component.IFlexibleComp;
import java.math.BigDecimal;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FlexibleContext<T> {
    private static final String TAG = "FlexibleContext";
    private Context mContext;
    private T mOwner;
    private View mView;
    private boolean setContentView = true;

    public FlexibleContext(T t, Context context) {
        this.mOwner = t;
        this.mContext = context;
    }

    private View adaptiveView(Context context, View view) {
        FlexibleComponent flexibleComponent = FlexibleComponent.INSTANCE;
        BigDecimal zoomRate = flexibleComponent.getZoomRate(context);
        for (IFlexibleComp iFlexibleComp : flexibleComponent.getAllComponents()) {
            iFlexibleComp.adaptive(view, zoomRate);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                adaptiveView(context, viewGroup.getChildAt(i));
            }
        }
        return view;
    }

    private void doAddView(Context context, View view) {
        while (!(context instanceof Activity)) {
            if (context instanceof ContextWrapper) {
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                try {
                    throw new Exception("Context is not an Activity, can't set content view");
                } catch (Exception unused) {
                    C3800a.b();
                    return;
                }
            }
        }
        ((Activity) context).setContentView(doAdaptive(context, view));
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mView = view;
        if (this.setContentView) {
            doAddView(this.mContext, view);
        }
    }

    public View doAdaptive(Context context, View view) {
        return adaptiveView(context, view);
    }

    public Context getContext() {
        return this.mContext;
    }

    public View getView() {
        return this.mView;
    }

    public void setContentView(int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(i, (ViewGroup) null);
        this.mView = inflate;
        if (inflate != null) {
            doAddView(this.mContext, inflate);
            return;
        }
        throw new IllegalStateException("layoutId is not Illegal");
    }

    public void setContentView(View view) {
        if (view != null) {
            doAddView(this.mContext, view);
            return;
        }
        throw new IllegalStateException("layoutId is not Illegal");
    }
}
