package com.taobao.update.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.taobao.tao.update.common.R$id;
import com.taobao.tao.update.common.R$layout;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CustomDialog extends android.app.Dialog {
    private DialogInterface.OnClickListener a;
    private DialogInterface.OnClickListener b;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b {
        private Context a;
        private String b;
        private View c;
        private DialogInterface.OnClickListener d;
        private DialogInterface.OnClickListener e;

        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        class a implements DialogInterface.OnCancelListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                if (b.this.e != null) {
                    b.this.e.onClick(dialogInterface, -2);
                }
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.taobao.update.dialog.CustomDialog$b$b  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        class View$OnClickListenerC0328b implements View.OnClickListener {
            final /* synthetic */ CustomDialog a;

            View$OnClickListenerC0328b(CustomDialog customDialog) {
                this.a = customDialog;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.a.dismiss();
                if (b.this.e != null) {
                    b.this.e.onClick(this.a, -2);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        class c implements View.OnClickListener {
            final /* synthetic */ CustomDialog a;

            c(CustomDialog customDialog) {
                this.a = customDialog;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.a.dismiss();
                b.this.d.onClick(this.a, -1);
            }
        }

        public b(Context context) {
            this.a = context;
        }

        public CustomDialog create() {
            CustomDialog customDialog = new CustomDialog(this.a);
            View inflate = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R$layout.custom_update_dialog, (ViewGroup) null);
            customDialog.addContentView(inflate, new ViewGroup.LayoutParams(-1, -2));
            View findViewById = inflate.findViewById(R$id.card_view);
            DialogInterface.OnClickListener onClickListener = this.e;
            if (onClickListener != null) {
                customDialog.b = onClickListener;
            }
            DialogInterface.OnClickListener onClickListener2 = this.d;
            if (onClickListener2 != null) {
                customDialog.a = onClickListener2;
            }
            customDialog.setCanceledOnTouchOutside(true);
            customDialog.setCancelable(true);
            customDialog.setOnCancelListener(new a());
            inflate.findViewById(R$id.close_btn).setOnClickListener(new View$OnClickListenerC0328b(customDialog));
            if (this.d != null) {
                findViewById.findViewById(R$id.image_button).setOnClickListener(new c(customDialog));
            }
            if (!TextUtils.isEmpty(this.b)) {
                ((TextView) inflate.findViewById(R$id.text_content)).setText(this.b);
            }
            customDialog.setContentView(inflate);
            return customDialog;
        }

        public b setContentView(View view) {
            this.c = view;
            return this;
        }

        public b setMessage(String str) {
            this.b = str;
            return this;
        }

        public b setNegativeButton(DialogInterface.OnClickListener onClickListener) {
            this.e = onClickListener;
            return this;
        }

        public b setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            String str = (String) this.a.getText(i);
            this.d = onClickListener;
            return this;
        }

        public b setTitle(int i) {
            String str = (String) this.a.getText(i);
            return this;
        }

        public b setTitle(String str) {
            return this;
        }

        public b setMessage(int i) {
            this.b = (String) this.a.getText(i);
            return this;
        }

        public b setPositiveButton(String str, DialogInterface.OnClickListener onClickListener) {
            this.d = onClickListener;
            return this;
        }
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) (f * (context.getResources().getDisplayMetrics().density / 2.0f));
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.width = px2dip(getContext(), 560.0f);
        attributes.height = px2dip(getContext(), 840.0f);
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(17170445);
    }

    private CustomDialog(Context context) {
        super(context);
    }
}
