package com.youku.resource.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import com.youku.resource.R;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKActionSheet extends DialogFragment {
    public static final String ACTION_STYLE_DEFAULT = "default";
    public static final String ACTION_STYLE_DEFAULT_2LINE = "default_2line";
    public static final String ACTION_STYLE_DESCRIBE = "describe";
    public static final String ACTION_STYLE_DESCRIBE_2LINE = "describe_2lines";
    public static final String ACTION_STYLE_DISABLE = "disable";
    public static final String ACTION_STYLE_WARNING = "warning";
    ArrayList<Action> actions = new ArrayList<>();
    private LinearLayout mActionList;
    private View mCancel;
    private InnerDialog mDialog;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class Action {
        public int actionId;
        public View.OnClickListener onClickListener;
        public String style;
        public String text;

        public Action(int i, String str, String str2, View.OnClickListener onClickListener) {
            this.actionId = i;
            this.style = str;
            this.text = str2;
            this.onClickListener = onClickListener;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    class InnerDialog extends Dialog {
        public InnerDialog(@NonNull Context context) {
            super(context, R.C8077style.YKAcitonSheetDialog);
        }

        @Override // android.app.Dialog
        public void show() {
            super.show();
            Window window = YKActionSheet.this.getDialog().getWindow();
            window.setGravity(83);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setAttributes(attributes);
        }
    }

    private void addActionView(int i, String str, String str2, View.OnClickListener onClickListener) {
        YKTextView yKTextView = new YKTextView(getActivity());
        char c = 65535;
        yKTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.resource_size_52)));
        Resources resources = getResources();
        int i2 = R.dimen.dim_6;
        yKTextView.setPadding(0, resources.getDimensionPixelOffset(i2), 0, getResources().getDimensionPixelOffset(i2));
        yKTextView.setGravity(17);
        switch (str.hashCode()) {
            case -1884636671:
                if (str.equals(ACTION_STYLE_DESCRIBE_2LINE)) {
                    c = 3;
                    break;
                }
                break;
            case 1018214091:
                if (str.equals(ACTION_STYLE_DESCRIBE)) {
                    c = 2;
                    break;
                }
                break;
            case 1124446108:
                if (str.equals(ACTION_STYLE_WARNING)) {
                    c = 0;
                    break;
                }
                break;
            case 1544803905:
                if (str.equals("default")) {
                    c = 4;
                    break;
                }
                break;
            case 1671308008:
                if (str.equals(ACTION_STYLE_DISABLE)) {
                    c = 1;
                    break;
                }
                break;
        }
        if (c == 0) {
            yKTextView.setStyle(YKTextView.STYLE_1_B);
            yKTextView.setTextColor(getResources().getColor(R.C8071color.cr_1));
        } else if (c == 1) {
            yKTextView.setStyle(YKTextView.STYLE_1_B);
            yKTextView.setTextColor(getResources().getColor(R.C8071color.cg_3));
        } else if (c == 2) {
            yKTextView.setStyle(YKTextView.STYLE_5_B);
            yKTextView.setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
        } else if (c != 3) {
            yKTextView.setStyle(YKTextView.STYLE_1_B);
        } else {
            yKTextView.setStyle(YKTextView.STYLE_5_C);
            yKTextView.setTextColor(getResources().getColor(R.C8071color.ykn_primary_info));
        }
        yKTextView.setTag(Integer.valueOf(i));
        yKTextView.setText(str2);
        yKTextView.setOnClickListener(onClickListener);
        this.mActionList.addView(yKTextView);
    }

    private void addDivider() {
        View view = new View(getActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
        view.setBackgroundColor(getResources().getColor(R.C8071color.ykn_seconary_separator));
        this.mActionList.addView(view);
    }

    public YKActionSheet addAction(int i, String str, String str2, View.OnClickListener onClickListener) {
        this.actions.add(new Action(i, str, str2, onClickListener));
        if (isAdded()) {
            addDivider();
            addActionView(i, str, str2, onClickListener);
        }
        return this;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        this.mDialog = new InnerDialog(getActivity());
        if (getActivity() == null) {
            return this.mDialog;
        }
        View inflate = getActivity().getLayoutInflater().inflate(R.C8074layout.resource_ykactionsheet, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.actionsheet_cancel);
        this.mCancel = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.youku.resource.widget.YKActionSheet.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YKActionSheet.this.mDialog.dismiss();
            }
        });
        this.mActionList = (LinearLayout) inflate.findViewById(R.id.actionsheet_list);
        for (int i = 0; i < this.actions.size(); i++) {
            if (this.actions.get(i) != null) {
                addActionView(this.actions.get(i).actionId, this.actions.get(i).style, this.actions.get(i).text, this.actions.get(i).onClickListener);
            }
            if (i != this.actions.size() - 1) {
                addDivider();
            }
        }
        this.mDialog.setContentView(inflate);
        return this.mDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mActionList = null;
        this.mCancel = null;
        super.onDestroyView();
        this.mDialog = null;
    }
}
