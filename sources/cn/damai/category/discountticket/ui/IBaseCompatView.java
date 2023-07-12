package cn.damai.category.discountticket.ui;

import android.content.DialogInterface;
import android.view.ViewGroup;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IBaseCompatView {
    ViewGroup getMainView();

    void hideErrorView();

    void showDialog(String str, String str2, DialogInterface.OnClickListener onClickListener);

    void showDialogLoading(boolean z);

    void showErrorTip(String str);

    void showErrorView(String str, String str2, String str3, OnErrorClickListener onErrorClickListener);
}
