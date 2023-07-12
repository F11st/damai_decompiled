package com.ali.user.mobile.register.old;

import android.content.Context;
import android.content.Intent;
import android.text.style.URLSpan;
import android.view.View;
import com.ali.user.mobile.ui.WebConstant;
import com.ali.user.mobile.webview.WebViewActivity;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class TaoUrlSpan extends URLSpan {
    public TaoUrlSpan(String str) {
        super(str);
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        if (view == null || view.getContext() == null) {
            return;
        }
        Context context = view.getContext();
        Intent intent = new Intent();
        intent.setClass(context, WebViewActivity.class);
        intent.putExtra(WebConstant.WEBURL, getURL());
        context.startActivity(intent);
    }
}
