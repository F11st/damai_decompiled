package com.taomai.android.h5container.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import com.taomai.android.h5container.R$color;
import com.taomai.android.h5container.R$drawable;
import java.util.ArrayList;
import java.util.List;
import tb.ea0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DialogBottomButtonGroupView extends FrameLayout implements View.OnClickListener {
    public static final int BUTTON_LAYOUT_LIST = 2;
    public static final int BUTTON_LAYOUT_NORMAL = 1;
    public static final int BUTTON_LAYOUT_OLD = 0;
    public static final int BUTTON_LAYOUT_STRONG = 3;
    private LinearLayout buttonContainer;
    private int buttonGroupType;
    private int buttonHeight;
    private List<Button> buttons;
    private Context context;
    private View horizontalDivider;
    private Button negativeBtn;
    private OnItemClickListener onItemClickListener;
    private Button positiveBtn;
    private boolean positiveButtonEnabled;
    private boolean positiveButtonNormal;
    private boolean positiveButtonWarning;
    private View verticalDivider;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public DialogBottomButtonGroupView(Context context) {
        super(context);
        this.buttons = new ArrayList();
        this.buttonGroupType = 0;
        this.positiveButtonEnabled = true;
        this.positiveButtonWarning = false;
        this.positiveButtonNormal = false;
        init(context, null);
    }

    private void addHorizonDivider() {
        this.buttonContainer.addView(createDivider(this.context), -1, 1);
    }

    @NonNull
    private Button createButton(Context context, AttributeSet attributeSet) {
        Button button = new Button(context, attributeSet);
        button.setTextSize(1, 18.0f);
        button.setTextColor(AppCompatResources.getColorStateList(context, R$color.h5_base_dialog_button_text_color));
        button.setBackgroundResource(R$drawable.h5_dialog_normal_button_bg);
        button.setMinHeight(this.buttonHeight);
        button.setGravity(17);
        button.setSingleLine();
        return button;
    }

    private View createDivider(Context context) {
        View view = new View(context);
        view.setBackgroundColor(context.getResources().getColor(R$color.color_e5e5e5));
        return view;
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.context = context;
        this.buttonHeight = ea0.a(49.0f);
        this.positiveBtn = createButton(context, attributeSet);
        this.negativeBtn = createButton(context, attributeSet);
        View createDivider = createDivider(context);
        this.horizontalDivider = createDivider;
        addView(createDivider, -1, 1);
        this.horizontalDivider.setVisibility(8);
        this.verticalDivider = createDivider(context);
        LinearLayout linearLayout = new LinearLayout(context, attributeSet);
        this.buttonContainer = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.buttonContainer, -1, -2);
        renderToOldStyle();
    }

    private void initDefaultStyle() {
        if (this.buttonGroupType == 0) {
            setButtonLayout(1);
        }
    }

    private boolean isNegativeBtnValid() {
        return this.negativeBtn.length() > 0 && this.negativeBtn.getVisibility() == 0;
    }

    private boolean isPositiveBtnValid() {
        return this.positiveBtn.length() > 0 && this.positiveBtn.getVisibility() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void renderNormalStyle() {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taomai.android.h5container.widget.DialogBottomButtonGroupView.renderNormalStyle():void");
    }

    private void renderToListStyle() {
        this.buttonContainer.removeAllViews();
        this.buttonContainer.setOrientation(1);
        if (isPositiveBtnValid()) {
            addHorizonDivider();
            setPositiveBtnStyle();
            this.buttonContainer.addView(this.positiveBtn, -1, this.buttonHeight);
        }
        if (isNegativeBtnValid()) {
            addHorizonDivider();
            this.buttonContainer.addView(this.negativeBtn, -1, this.buttonHeight);
        }
        if (this.buttonContainer.getChildCount() > 0) {
            LinearLayout linearLayout = this.buttonContainer;
            if (linearLayout.getChildAt(linearLayout.getChildCount() - 1) instanceof Button) {
                LinearLayout linearLayout2 = this.buttonContainer;
                linearLayout2.getChildAt(linearLayout2.getChildCount() - 1).setBackgroundResource(R$drawable.h5_dialog_bottom_button_bg);
            }
        }
    }

    private void renderToMainStyle() {
        this.buttonContainer.removeAllViews();
        this.buttonContainer.setOrientation(1);
        if (isPositiveBtnValid()) {
            this.positiveBtn.setBackgroundResource(R$drawable.h5_button_bg_for_main);
            this.positiveBtn.setTextColor(AppCompatResources.getColorStateList(this.context, R$color.h5_button_textcolor_white));
            this.buttonContainer.addView(this.positiveBtn, -1, this.buttonHeight);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.positiveBtn.getLayoutParams();
            int a = ea0.a(12.0f);
            int a2 = ea0.a(12.0f);
            if (isNegativeBtnValid()) {
                a = ea0.a(12.0f);
            }
            layoutParams.setMargins(a2, 0, a2, a);
        }
        if (isNegativeBtnValid()) {
            this.negativeBtn.setBackgroundColor(this.context.getResources().getColor(17170445));
            this.buttonContainer.addView(this.negativeBtn, -1, this.buttonHeight);
        }
    }

    private void renderToOldStyle() {
        this.horizontalDivider.setVisibility(0);
        this.positiveBtn.setBackgroundResource(R$drawable.h5_dialog_normal_button_bg);
        this.buttonContainer.addView(this.positiveBtn, -1, this.buttonHeight);
    }

    private void setPositiveBtnStyle() {
        if (this.positiveButtonWarning) {
            this.positiveBtn.setTextColor(AppCompatResources.getColorStateList(this.context, R$color.h5_base_dialog_button_text_color_warning));
        }
        if (this.positiveButtonNormal || !isNegativeBtnValid()) {
            return;
        }
        this.positiveBtn.getPaint().setFakeBoldText(true);
    }

    public Button getNegativeBtn() {
        return this.negativeBtn;
    }

    public Button getPositiveBtn() {
        return this.positiveBtn;
    }

    public void hideBottomLine() {
        this.horizontalDivider.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnItemClickListener onItemClickListener = this.onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(this.buttons.indexOf(view));
        }
    }

    public void renderView() {
        int i = this.buttonGroupType;
        if (i != 0) {
            if (i == 2) {
                renderToListStyle();
            } else if (i != 3) {
                renderNormalStyle();
            } else {
                renderToMainStyle();
            }
        }
    }

    public void setButtonLayout(int i) {
        if (i <= 0 || i > 3) {
            return;
        }
        this.buttonGroupType = i;
    }

    public void setButtonList(List<? extends CharSequence> list, OnItemClickListener onItemClickListener) {
        this.buttonGroupType = 0;
        this.onItemClickListener = onItemClickListener;
        Context context = getContext();
        this.buttonContainer.removeAllViews();
        this.buttons.clear();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View createDivider = createDivider(context);
            createDivider.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
            this.buttonContainer.addView(createDivider);
            Button createButton = createButton(context, null);
            createButton.setText(list.get(i));
            if (size > 1 && i == 0 && !this.positiveButtonNormal) {
                createButton.getPaint().setFakeBoldText(true);
            }
            if (i == 0) {
                createButton.setEnabled(this.positiveButtonEnabled);
                if (this.positiveButtonWarning) {
                    createButton.setTextColor(AppCompatResources.getColorStateList(context, R$color.h5_base_dialog_button_text_color_warning));
                }
            }
            if (i < size - 1) {
                createButton.setBackgroundResource(R$drawable.h5_dialog_normal_button_bg);
            } else {
                createButton.setBackgroundResource(R$drawable.h5_dialog_bottom_button_bg);
            }
            createButton.setMinHeight(this.buttonHeight);
            createButton.setGravity(17);
            createButton.setOnClickListener(this);
            this.buttonContainer.addView(createButton, -1, this.buttonHeight);
            this.buttons.add(createButton);
        }
    }

    public void setNegativeButton(CharSequence charSequence, View.OnClickListener onClickListener) {
        this.negativeBtn.setText(charSequence);
        this.negativeBtn.setOnClickListener(onClickListener);
        initDefaultStyle();
    }

    public void setPositiveButton(CharSequence charSequence, View.OnClickListener onClickListener) {
        this.positiveBtn.setText(charSequence);
        this.positiveBtn.setOnClickListener(onClickListener);
        initDefaultStyle();
    }

    public void setPositiveButtonEnabled(boolean z) {
        this.positiveButtonEnabled = z;
        this.positiveBtn.setEnabled(z);
        if (this.buttons.size() <= 0 || this.buttons.get(0) == null) {
            return;
        }
        this.buttons.get(0).setEnabled(z);
    }

    public void setPositiveButtonToNormal() {
        this.positiveButtonNormal = true;
    }

    public void setPositiveButtonToWarning() {
        this.positiveButtonWarning = true;
    }

    public DialogBottomButtonGroupView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.buttons = new ArrayList();
        this.buttonGroupType = 0;
        this.positiveButtonEnabled = true;
        this.positiveButtonWarning = false;
        this.positiveButtonNormal = false;
        init(context, attributeSet);
    }
}
