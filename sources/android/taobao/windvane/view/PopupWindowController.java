package android.taobao.windvane.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.taobao.windvane.util.EnvUtil;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.taobao.weex.ui.module.WXModalUIModule;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PopupWindowController {
    private int cancelIndex;
    private boolean isHideByBackButton;
    AtomicBoolean isShow;
    private Animation mAnimation;
    private Context mContext;
    private PopupWindow mPopupWindow;
    private View mView;
    private LinearLayout popupLayout;
    private FrameLayout popupViewGroup;

    public PopupWindowController(Context context, View view, String[] strArr, View.OnClickListener onClickListener) {
        this(context, view, null, strArr, onClickListener);
    }

    private void fixPopupWindow(final PopupWindow popupWindow) {
        if (Build.VERSION.SDK_INT < 14) {
            try {
                final Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
                declaredField.setAccessible(true);
                Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
                declaredField2.setAccessible(true);
                final ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = (ViewTreeObserver.OnScrollChangedListener) declaredField2.get(popupWindow);
                declaredField2.set(popupWindow, new ViewTreeObserver.OnScrollChangedListener() { // from class: android.taobao.windvane.view.PopupWindowController.3
                    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                    public void onScrollChanged() {
                        try {
                            WeakReference weakReference = (WeakReference) declaredField.get(popupWindow);
                            if (weakReference != null && weakReference.get() != null) {
                                onScrollChangedListener.onScrollChanged();
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initButtons(String str, String[] strArr, View.OnClickListener onClickListener) {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.popupViewGroup = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        this.popupLayout = linearLayout;
        linearLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.popupLayout.setLayoutParams(layoutParams);
        this.popupLayout.setBackgroundColor(-7829368);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        if (!TextUtils.isEmpty(str)) {
            Button button = new Button(this.mContext);
            button.setText(str);
            button.setBackgroundColor(-657931);
            button.setTextColor(-7829368);
            button.setLayoutParams(layoutParams2);
            this.popupLayout.addView(button);
            TextView textView = new TextView(this.mContext);
            textView.setHeight(4);
            this.popupLayout.addView(textView);
        }
        if (strArr != null) {
            for (String str2 : strArr) {
                Button button2 = new Button(this.mContext);
                button2.setText(str2);
                button2.setTag(str2);
                button2.setBackgroundColor(-657931);
                button2.setTextColor(-16777216);
                button2.setLayoutParams(layoutParams2);
                button2.setOnClickListener(onClickListener);
                this.popupLayout.addView(button2);
                TextView textView2 = new TextView(this.mContext);
                textView2.setHeight(2);
                this.popupLayout.addView(textView2);
            }
        }
        final Button button3 = new Button(this.mContext);
        button3.setText(EnvUtil.isCN() ? "取消" : WXModalUIModule.CANCEL);
        button3.setBackgroundColor(-657931);
        button3.setTextColor(-7829368);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = 4;
        button3.setLayoutParams(layoutParams3);
        this.popupLayout.addView(button3);
        this.popupViewGroup.addView(this.popupLayout);
        button3.setOnClickListener(onClickListener);
        this.popupViewGroup.setOnTouchListener(new View.OnTouchListener() { // from class: android.taobao.windvane.view.PopupWindowController.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int top = PopupWindowController.this.popupLayout.getTop();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == 1 && y < top) {
                    button3.performClick();
                }
                return true;
            }
        });
    }

    private void initPopupWindow() {
        PopupWindow popupWindow = new PopupWindow(this.mContext);
        this.mPopupWindow = popupWindow;
        popupWindow.setContentView(this.popupViewGroup);
        this.mPopupWindow.setWidth(-1);
        this.mPopupWindow.setHeight(-1);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(2130706432));
        fixPopupWindow(this.mPopupWindow);
        this.mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: android.taobao.windvane.view.PopupWindowController.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (PopupWindowController.this.isHideByBackButton) {
                    View childAt = PopupWindowController.this.popupLayout.getChildAt(PopupWindowController.this.cancelIndex);
                    if (childAt != null) {
                        childAt.performClick();
                        return;
                    }
                    return;
                }
                PopupWindowController.this.isHideByBackButton = true;
            }
        });
    }

    public void hide() {
        if (this.isShow.get()) {
            this.isHideByBackButton = false;
            this.mPopupWindow.dismiss();
            if (this.mPopupWindow.isShowing()) {
                return;
            }
            this.isShow.compareAndSet(true, false);
        }
    }

    public void show() {
        if (this.isShow.compareAndSet(false, true)) {
            try {
                this.mPopupWindow.showAtLocation(this.mView, 81, 0, 0);
                this.popupLayout.startAnimation(this.mAnimation);
                this.mPopupWindow.update();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public PopupWindowController(Context context, View view, String str, String[] strArr, View.OnClickListener onClickListener) {
        this.isShow = new AtomicBoolean(false);
        this.isHideByBackButton = true;
        this.cancelIndex = 4;
        this.mContext = context;
        this.mView = view;
        initButtons(str, strArr, onClickListener);
        initPopupWindow();
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        this.mAnimation = translateAnimation;
        translateAnimation.setDuration(250L);
    }
}
