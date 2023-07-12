package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.baseproject.ui.R$id;
import com.baseproject.ui.R$layout;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class HeaderAnimScrollView extends ScrollView {
    private ViewGroup mContainer;
    private ViewGroup mContent;
    private ViewGroup mFooter;
    private ViewGroup mHeader;
    private LayoutInflater mLayoutInflater;
    private OnScrollChangeListener mOnScrollChangeListener;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface OnScrollChangeListener {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public HeaderAnimScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
        findView();
        initView();
        setListener();
    }

    private View clearAndAddContent(ViewGroup viewGroup, View view) {
        viewGroup.removeAllViews();
        if (view != null) {
            viewGroup.addView(view);
        }
        return viewGroup;
    }

    private void findView() {
        this.mContainer = (ViewGroup) findViewById(R$id.vg_widget_header_anim_scroll_view_container);
        this.mHeader = (ViewGroup) findViewById(R$id.vg_widget_header_anim_scroll_view_header);
        this.mContent = (ViewGroup) findViewById(R$id.vg_widget_header_anim_scroll_view_content);
        this.mFooter = (ViewGroup) findViewById(R$id.vg_widget_header_anim_scroll_view_footer);
    }

    private void init() {
        LayoutInflater from = LayoutInflater.from(getContext());
        this.mLayoutInflater = from;
        from.inflate(R$layout.widget_header_anim_scroll_view, (ViewGroup) this, true);
    }

    private void initView() {
    }

    private void setListener() {
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangeListener onScrollChangeListener = this.mOnScrollChangeListener;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChanged(i, i2, i3, i4);
        }
    }

    public View setContent(View view) {
        return clearAndAddContent(this.mContent, view);
    }

    public View setFooter(View view) {
        return clearAndAddContent(this.mFooter, view);
    }

    public View setHeader(View view) {
        return clearAndAddContent(this.mHeader, view);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }

    public View setContent(int i) {
        return clearAndAddContent(this.mContent, i);
    }

    public View setFooter(int i) {
        return clearAndAddContent(this.mFooter, i);
    }

    public View setHeader(int i) {
        return clearAndAddContent(this.mHeader, i);
    }

    private View clearAndAddContent(ViewGroup viewGroup, int i) {
        viewGroup.removeAllViews();
        this.mLayoutInflater.inflate(i, viewGroup, true);
        return viewGroup;
    }
}
