package com.taobao.update.dialog;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taobao.tao.update.common.R$anim;
import com.taobao.tao.update.common.R$id;
import com.taobao.tao.update.common.R$layout;
import com.taobao.update.framework.UpdateRuntime;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Dialog extends android.app.Dialog {
    Context a;
    View b;
    View c;
    String d;
    TextView e;
    String f;
    TextView g;
    ButtonFlat h;
    ButtonFlat i;
    String j;
    String k;
    View.OnClickListener l;
    View.OnClickListener m;
    boolean n;
    private View o;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getX() < Dialog.this.b.getLeft() || motionEvent.getX() > Dialog.this.b.getRight() || motionEvent.getY() > Dialog.this.b.getBottom() || motionEvent.getY() < Dialog.this.b.getTop()) {
                Dialog dialog = Dialog.this;
                if (dialog.n) {
                    View.OnClickListener onClickListener = dialog.m;
                    if (onClickListener != null) {
                        onClickListener.onClick(dialog.i);
                    }
                    Dialog.this.dismiss();
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Dialog.this.dismiss();
            View.OnClickListener onClickListener = Dialog.this.m;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!Dialog.this.k.equals("立即安装")) {
                Dialog.this.dismiss();
            }
            View.OnClickListener onClickListener = Dialog.this.l;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public Dialog(Context context) {
        super(context);
        this.n = true;
    }

    public void addAcceptButton(String str) {
        this.k = str;
        ButtonFlat buttonFlat = this.h;
        if (buttonFlat != null) {
            buttonFlat.setText(str);
        }
    }

    public void addCancelButton(String str) {
        this.j = str;
        ButtonFlat buttonFlat = this.i;
        if (buttonFlat != null) {
            buttonFlat.setText(str);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a.getApplicationContext(), R$anim.dialog_main_hide_amination);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.taobao.update.dialog.Dialog.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Dialog.this.b.post(new Runnable() { // from class: com.taobao.update.dialog.Dialog.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Dialog.super.dismiss();
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.a.getApplicationContext(), R$anim.dialog_root_hide_amin);
        this.b.startAnimation(loadAnimation);
        this.c.startAnimation(loadAnimation2);
    }

    public ButtonFlat getButtonAccept() {
        return this.h;
    }

    public ButtonFlat getButtonCancel() {
        return this.i;
    }

    public View getContentView() {
        return this.o;
    }

    public String getMessage() {
        return this.d;
    }

    public TextView getMessageTextView() {
        return this.e;
    }

    public String getTitle() {
        return this.f;
    }

    public TextView getTitleTextView() {
        return this.g;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        View.OnClickListener onClickListener = this.m;
        if (onClickListener != null) {
            onClickListener.onClick(null);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        super.setContentView(LayoutInflater.from(UpdateRuntime.getContext()).inflate(R$layout.update_dialog, (ViewGroup) null));
        this.b = (RelativeLayout) findViewById(R$id.update_contentDialog);
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.update_dialog_rootView);
        this.c = frameLayout;
        frameLayout.setOnTouchListener(new a());
        this.g = (TextView) findViewById(R$id.update_title);
        setTitle(this.f);
        if (this.o != null) {
            ((FrameLayout) findViewById(R$id.update_dialog_content)).addView(this.o);
            findViewById(R$id.message_scrollView).setVisibility(8);
        } else {
            this.e = (TextView) findViewById(R$id.update_message);
            setMessage(this.d);
        }
        if (this.j != null) {
            ButtonFlat buttonFlat = (ButtonFlat) findViewById(R$id.update_button_cancel);
            this.i = buttonFlat;
            buttonFlat.setVisibility(0);
            this.i.setText(this.j);
            this.i.setOnClickListener(new b());
        }
        if (this.k != null) {
            ButtonFlat buttonFlat2 = (ButtonFlat) findViewById(R$id.update_button_accept);
            this.h = buttonFlat2;
            buttonFlat2.setVisibility(0);
            this.h.setText(this.k);
            this.h.setOnClickListener(new c());
        }
    }

    public void setButtonAccept(ButtonFlat buttonFlat) {
        this.h = buttonFlat;
    }

    public void setButtonCancel(ButtonFlat buttonFlat) {
        this.i = buttonFlat;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.o = view;
    }

    public void setMessage(String str) {
        this.d = str;
        this.e.setText(str);
    }

    public void setMessageTextView(TextView textView) {
        this.e = textView;
    }

    public void setOnAcceptButtonClickListener(View.OnClickListener onClickListener) {
        this.l = onClickListener;
        ButtonFlat buttonFlat = this.h;
        if (buttonFlat != null) {
            buttonFlat.setOnClickListener(onClickListener);
        }
    }

    public void setOnCancelButtonClickListener(View.OnClickListener onClickListener) {
        this.m = onClickListener;
        ButtonFlat buttonFlat = this.i;
        if (buttonFlat != null) {
            buttonFlat.setOnClickListener(onClickListener);
        }
    }

    public void setTitle(String str) {
        this.f = str;
        if (str == null) {
            this.g.setVisibility(8);
            return;
        }
        this.g.setVisibility(0);
        this.g.setText(str);
    }

    public void setTitleTextView(TextView textView) {
        this.g = textView;
    }

    @Override // android.app.Dialog
    public void show() {
        Log.e("UIConfirmImpl", "dialog show");
        super.show();
        this.b.startAnimation(AnimationUtils.loadAnimation(this.a.getApplicationContext(), R$anim.dialog_main_show_amination));
        this.c.startAnimation(AnimationUtils.loadAnimation(this.a.getApplicationContext(), R$anim.dialog_root_show_amin));
    }

    public Dialog(Context context, String str, String str2) {
        super(context, 16973839);
        this.n = true;
        this.a = context;
        this.d = str2;
        this.f = str;
    }

    public void addAcceptButton(String str, View.OnClickListener onClickListener) {
        this.k = str;
        this.l = onClickListener;
    }

    public void addCancelButton(String str, View.OnClickListener onClickListener) {
        this.j = str;
        this.m = onClickListener;
    }

    public Dialog(Context context, String str, String str2, boolean z) {
        super(context, 16973839);
        this.n = true;
        this.a = context;
        this.d = str2;
        this.f = str;
        this.n = z;
    }
}
