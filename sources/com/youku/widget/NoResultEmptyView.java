package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baseproject.ui.R$id;
import com.baseproject.ui.R$layout;
import com.baseproject.ui.R$string;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class NoResultEmptyView extends LinearLayout {
    private TextView txt_noresult_emptyview;

    public NoResultEmptyView(Context context) {
        super(context);
        this.txt_noresult_emptyview = null;
        init(context);
    }

    protected void init(Context context) {
        this.txt_noresult_emptyview = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.search_result_noresult_emptyview, (ViewGroup) this, true).findViewById(R$id.txt_noresult_emptyview);
    }

    public void setEmptyViewText(String str) {
        TextView textView = this.txt_noresult_emptyview;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setEmptyViewTextNoData() {
        TextView textView = this.txt_noresult_emptyview;
        if (textView != null) {
            textView.setText(getResources().getString(R$string.havebuy_no_data));
        }
    }

    public void setEmptyViewText(int i) {
        TextView textView = this.txt_noresult_emptyview;
        if (textView != null) {
            textView.setText(getResources().getString(i));
        }
    }

    public NoResultEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.txt_noresult_emptyview = null;
        init(context);
    }
}
