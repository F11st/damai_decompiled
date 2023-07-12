package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.baseproject.ui.R$id;
import com.baseproject.ui.R$layout;
import com.baseproject.ui.R$string;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ResultEmptyView extends LinearLayout {
    private TextView resultEmptyMsg;
    private ImageView tipIcon;

    public ResultEmptyView(Context context) {
        super(context);
        this.resultEmptyMsg = null;
        this.tipIcon = null;
        init(context);
    }

    protected void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.search_result_noresult_emptyview, (ViewGroup) this, true);
        this.resultEmptyMsg = (TextView) inflate.findViewById(R$id.txt_noresult_emptyview);
        this.tipIcon = (ImageView) inflate.findViewById(R$id.img_noresult_emptyview);
    }

    public void setEmptyViewText(String str) {
        TextView textView = this.resultEmptyMsg;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setEmptyViewTextNoData() {
        TextView textView = this.resultEmptyMsg;
        if (textView != null) {
            textView.setText(getResources().getString(R$string.channel_sub_no_data));
        }
    }

    public void setEmptyViewTextNoResult() {
        TextView textView = this.resultEmptyMsg;
        if (textView != null) {
            textView.setText(getResources().getString(R$string.channel_sub_no_result));
        }
    }

    public void setImageNoData(int i) {
        ImageView imageView = this.tipIcon;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void setEmptyViewText(@StringRes int i) {
        TextView textView = this.resultEmptyMsg;
        if (textView != null) {
            textView.setText(getResources().getString(i));
        }
    }

    public ResultEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.resultEmptyMsg = null;
        this.tipIcon = null;
        init(context);
    }
}
