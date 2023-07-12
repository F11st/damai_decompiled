package com.youku.live.dago.widgetlib.ailproom.view.flowview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailproom.view.flowview.TagAdapter;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ViewFlowLayout extends FlowLayout implements TagAdapter.OnDataChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String KEY_DEFAULT = "key_default";
    private static final String TAG = "ViewFlowLayout";
    private ConfigurationListener mConfigurationListener;
    private OnTagClickListener mOnTagClickListener;
    private TagAdapter mTagAdapter;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface ConfigurationListener {
        void onConfigurationChanged(Configuration configuration);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnTagClickListener {
        boolean onTagClick(View view, int i, FlowLayout flowLayout);
    }

    public ViewFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.obtainStyledAttributes(attributeSet, R.styleable.Dago_Pgc_TagFlowLayout).recycle();
    }

    private void changeAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1054074528")) {
            ipChange.ipc$dispatch("1054074528", new Object[]{this});
            return;
        }
        removeAllViews();
        if (this.mTagAdapter != null) {
            for (final int i = 0; i < this.mTagAdapter.getCount(); i++) {
                TagStyle itemStyle = this.mTagAdapter.getItemStyle(i);
                TagAdapter tagAdapter = this.mTagAdapter;
                final View view = tagAdapter.getView(this, i, tagAdapter.getItem(i));
                view.setDuplicateParentStateEnabled(true);
                FrameLayout frameLayout = new FrameLayout(getContext());
                if (itemStyle != null) {
                    frameLayout.setBackgroundResource(itemStyle.backgroundResId);
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(itemStyle.width, itemStyle.height);
                    marginLayoutParams.topMargin = itemStyle.topMargin;
                    marginLayoutParams.bottomMargin = itemStyle.bottomMargin;
                    marginLayoutParams.leftMargin = itemStyle.leftMargin;
                    marginLayoutParams.rightMargin = itemStyle.rightMargin;
                    frameLayout.setLayoutParams(marginLayoutParams);
                    frameLayout.setPadding(itemStyle.leftPadding, itemStyle.topPadding, itemStyle.rightPadding, itemStyle.bottomPadding);
                } else {
                    frameLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
                }
                frameLayout.addView(view);
                addView(frameLayout);
                view.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.ailproom.view.flowview.ViewFlowLayout.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-399647575")) {
                            ipChange2.ipc$dispatch("-399647575", new Object[]{this, view2});
                        } else if (ViewFlowLayout.this.mOnTagClickListener != null) {
                            ViewFlowLayout.this.mOnTagClickListener.onTagClick(view, i, ViewFlowLayout.this);
                        }
                    }
                });
            }
        }
    }

    public int dip2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1919293465") ? ((Integer) ipChange.ipc$dispatch("-1919293465", new Object[]{this, context, Float.valueOf(f)})).intValue() : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public TagAdapter getAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1756505821") ? (TagAdapter) ipChange.ipc$dispatch("1756505821", new Object[]{this}) : this.mTagAdapter;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.view.flowview.TagAdapter.OnDataChangedListener
    public void onChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1300098678")) {
            ipChange.ipc$dispatch("-1300098678", new Object[]{this});
        } else {
            changeAdapter();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-157622270")) {
            ipChange.ipc$dispatch("-157622270", new Object[]{this, configuration});
            return;
        }
        ConfigurationListener configurationListener = this.mConfigurationListener;
        if (configurationListener != null) {
            configurationListener.onConfigurationChanged(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "756418325")) {
            ipChange.ipc$dispatch("756418325", new Object[]{this, parcelable});
        } else if (parcelable instanceof Bundle) {
            super.onRestoreInstanceState(((Bundle) parcelable).getParcelable("key_default"));
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1875558498")) {
            return (Parcelable) ipChange.ipc$dispatch("1875558498", new Object[]{this});
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_default", super.onSaveInstanceState());
        return bundle;
    }

    public void setAdapter(TagAdapter tagAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1988965443")) {
            ipChange.ipc$dispatch("-1988965443", new Object[]{this, tagAdapter});
            return;
        }
        this.mTagAdapter = tagAdapter;
        tagAdapter.setOnDataChangedListener(this);
        changeAdapter();
    }

    public void setConfigurationListener(ConfigurationListener configurationListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1130113206")) {
            ipChange.ipc$dispatch("-1130113206", new Object[]{this, configurationListener});
        } else {
            this.mConfigurationListener = configurationListener;
        }
    }

    public void setOnTagClickListener(OnTagClickListener onTagClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "932989524")) {
            ipChange.ipc$dispatch("932989524", new Object[]{this, onTagClickListener});
        } else {
            this.mOnTagClickListener = onTagClickListener;
        }
    }

    public ViewFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewFlowLayout(Context context) {
        this(context, null);
    }
}
