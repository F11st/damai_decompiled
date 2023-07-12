package com.taobao.weex.appfram.pickers;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.ui.module.WXModalUIModule;
import com.taobao.weex.utils.WXLogUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DatePickerImpl {
    private static SimpleDateFormat a;
    private static SimpleDateFormat b;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnPickListener {
        void onPick(boolean z, @Nullable String str);
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.appfram.pickers.DatePickerImpl$a */
    /* loaded from: classes11.dex */
    static class C6951a implements DatePickerDialog.OnDateSetListener {
        final /* synthetic */ OnPickListener a;

        C6951a(OnPickListener onPickListener) {
            this.a = onPickListener;
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String valueOf;
            String valueOf2;
            int i4 = i2 + 1;
            if (i4 < 10) {
                valueOf = "0" + i4;
            } else {
                valueOf = String.valueOf(i4);
            }
            if (i3 < 10) {
                valueOf2 = "0" + i3;
            } else {
                valueOf2 = String.valueOf(i3);
            }
            this.a.onPick(true, i + "-" + valueOf + "-" + valueOf2);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.appfram.pickers.DatePickerImpl$b */
    /* loaded from: classes11.dex */
    static class DialogInterface$OnCancelListenerC6952b implements DialogInterface.OnCancelListener {
        final /* synthetic */ OnPickListener a;

        DialogInterface$OnCancelListenerC6952b(OnPickListener onPickListener) {
            this.a = onPickListener;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.a.onPick(false, null);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.appfram.pickers.DatePickerImpl$c */
    /* loaded from: classes11.dex */
    static class C6953c implements TimePickerDialog.OnTimeSetListener {
        final /* synthetic */ OnPickListener a;

        C6953c(OnPickListener onPickListener) {
            this.a = onPickListener;
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            String valueOf;
            String valueOf2;
            if (i < 10) {
                valueOf = "0" + i;
            } else {
                valueOf = String.valueOf(i);
            }
            if (i2 < 10) {
                valueOf2 = "0" + i2;
            } else {
                valueOf2 = String.valueOf(i2);
            }
            this.a.onPick(true, valueOf + ":" + valueOf2);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.appfram.pickers.DatePickerImpl$d */
    /* loaded from: classes11.dex */
    static class DialogInterface$OnCancelListenerC6954d implements DialogInterface.OnCancelListener {
        final /* synthetic */ OnPickListener a;

        DialogInterface$OnCancelListenerC6954d(OnPickListener onPickListener) {
            this.a = onPickListener;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.a.onPick(false, null);
        }
    }

    private static Date a(String str) {
        if (b == null) {
            b = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT, Locale.getDefault());
        }
        try {
            return b.parse(str);
        } catch (ParseException e) {
            WXLogUtils.w("[DatePickerImpl] " + e.toString());
            return new Date();
        }
    }

    private static Date b(String str) {
        if (a == null) {
            a = new SimpleDateFormat("HH:mm", Locale.getDefault());
        }
        try {
            return a.parse(str);
        } catch (ParseException e) {
            WXLogUtils.w("[DatePickerImpl] " + e.toString());
            return new Date();
        }
    }

    public static void c(@NonNull Context context, String str, String str2, String str3, @NonNull OnPickListener onPickListener, @Nullable Map<String, Object> map) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(a(str));
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new C6951a(onPickListener), calendar.get(1), calendar.get(2), calendar.get(5));
        DatePicker datePicker = datePickerDialog.getDatePicker();
        Calendar calendar2 = Calendar.getInstance(Locale.getDefault());
        Calendar calendar3 = Calendar.getInstance(Locale.getDefault());
        calendar2.set(1900, 0, 1);
        calendar3.set(2100, 11, 31);
        if (!TextUtils.isEmpty(str3)) {
            if (datePicker.getMaxDate() >= a(str3).getTime()) {
                datePicker.setMinDate(a(str3).getTime());
            } else {
                datePicker.setMinDate(calendar2.getTimeInMillis());
                datePicker.setMaxDate(calendar3.getTimeInMillis());
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            if (datePicker.getMinDate() <= a(str2).getTime()) {
                datePicker.setMaxDate(a(str2).getTime());
            } else {
                datePicker.setMinDate(calendar2.getTimeInMillis());
                datePicker.setMaxDate(calendar3.getTimeInMillis());
            }
        }
        datePickerDialog.setOnCancelListener(new DialogInterface$OnCancelListenerC6952b(onPickListener));
        e(datePickerDialog, -2, String.valueOf(map != null ? map.get(WXModalUIModule.CANCEL_TITLE) : null));
        e(datePickerDialog, -1, String.valueOf(map != null ? map.get("confirmTitle") : null));
        datePickerDialog.show();
    }

    public static void d(@NonNull Context context, String str, @NonNull OnPickListener onPickListener, @Nullable Map<String, Object> map) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(b(str));
        TimePickerDialog timePickerDialog = new TimePickerDialog(context, new C6953c(onPickListener), calendar.get(11), calendar.get(12), false);
        timePickerDialog.setOnCancelListener(new DialogInterface$OnCancelListenerC6954d(onPickListener));
        e(timePickerDialog, -2, String.valueOf(map != null ? map.get(WXModalUIModule.CANCEL_TITLE) : null));
        e(timePickerDialog, -1, String.valueOf(map != null ? map.get("confirmTitle") : null));
        timePickerDialog.show();
    }

    private static void e(final AlertDialog alertDialog, final int i, final CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence) || "null".equals(charSequence)) {
            return;
        }
        try {
            alertDialog.getWindow().getDecorView().post(WXThread.secure(new Runnable() { // from class: com.taobao.weex.appfram.pickers.DatePickerImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    Button button = alertDialog.getButton(i);
                    if (button != null) {
                        button.setAllCaps(false);
                        button.setText(charSequence);
                    }
                }
            }));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
