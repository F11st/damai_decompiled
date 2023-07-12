package com.taobao.weex.ui.component.helper;

import androidx.annotation.Nullable;
import com.taobao.weex.appfram.pickers.DatePickerImpl;
import com.taobao.weex.ui.component.AbstractEditComponent;
import com.taobao.weex.ui.view.WXEditText;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXTimeInputHelper {
    public static void pickDate(String str, String str2, final AbstractEditComponent abstractEditComponent) {
        final WXEditText hostView = abstractEditComponent.getHostView();
        DatePickerImpl.c(hostView.getContext(), hostView.getText().toString(), str, str2, new DatePickerImpl.OnPickListener() { // from class: com.taobao.weex.ui.component.helper.WXTimeInputHelper.1
            @Override // com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener
            public void onPick(boolean z, @Nullable String str3) {
                if (z) {
                    hostView.setText(str3);
                    abstractEditComponent.performOnChange(str3);
                }
            }
        }, null);
    }

    public static void pickTime(final AbstractEditComponent abstractEditComponent) {
        final WXEditText hostView = abstractEditComponent.getHostView();
        DatePickerImpl.d(hostView.getContext(), hostView.getText().toString(), new DatePickerImpl.OnPickListener() { // from class: com.taobao.weex.ui.component.helper.WXTimeInputHelper.2
            @Override // com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener
            public void onPick(boolean z, @Nullable String str) {
                if (z) {
                    hostView.setText(str);
                    abstractEditComponent.performOnChange(str);
                }
            }
        }, null);
    }
}
