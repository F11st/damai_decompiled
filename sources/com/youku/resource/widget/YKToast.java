package com.youku.resource.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.resource.R;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKToast {
    private TUrlImageView imageView;
    private TextView textView;
    private Toast toast;

    public void cancel() {
        this.toast.cancel();
    }

    @TargetApi(21)
    public YKToast makeText(Context context, CharSequence charSequence, int i) {
        this.toast = Toast.makeText(context, charSequence, i);
        View inflate = LayoutInflater.from(context).inflate(R.C8074layout.resource_yk_toast, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.yk_toast_text);
        this.textView = textView;
        textView.setText(charSequence);
        this.imageView = (TUrlImageView) inflate.findViewById(R.id.yk_toast_img);
        this.toast.setView(inflate);
        this.toast.setGravity(17, 0, 0);
        return this;
    }

    public void setGravity(int i, int i2, int i3) {
        this.toast.setGravity(i, i2, i3);
    }

    public void show() {
        this.toast.show();
    }

    public YKToast showImage(int i) {
        this.imageView.setImageResource(i);
        this.imageView.setVisibility(0);
        return this;
    }

    public YKToast showImage(String str) {
        this.imageView.setImageUrl(str);
        this.imageView.setVisibility(0);
        return this;
    }
}
