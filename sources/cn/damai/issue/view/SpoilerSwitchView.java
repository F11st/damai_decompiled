package cn.damai.issue.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.R$string;
import cn.damai.issue.view.SpoilerSwitchView;
import cn.damai.uikit.switchbutton.SwitchButton;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class SpoilerSwitchView extends ConstraintLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private TextView desTv;
    @Nullable
    private SwitchButton spoilerSwitch;
    @Nullable
    private TextView switchDesTv;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpoilerSwitchView(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ SpoilerSwitchView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m64_init_$lambda0(SpoilerSwitchView spoilerSwitchView, View view) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1898235296")) {
            ipChange.ipc$dispatch("-1898235296", new Object[]{spoilerSwitchView, view});
            return;
        }
        b41.i(spoilerSwitchView, "this$0");
        SwitchButton switchButton = spoilerSwitchView.spoilerSwitch;
        if ((switchButton == null || !switchButton.isChecked()) ? false : false) {
            TextView textView = spoilerSwitchView.desTv;
            if (textView != null) {
                textView.setText(spoilerSwitchView.getResources().getString(R$string.spoiler_des_ch));
            }
            TextView textView2 = spoilerSwitchView.switchDesTv;
            if (textView2 == null) {
                return;
            }
            textView2.setText("包含");
            return;
        }
        TextView textView3 = spoilerSwitchView.desTv;
        if (textView3 != null) {
            textView3.setText(spoilerSwitchView.getResources().getString(R$string.spoiler_des));
        }
        TextView textView4 = spoilerSwitchView.switchDesTv;
        if (textView4 == null) {
            return;
        }
        textView4.setText("不含");
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1535529750")) {
            ipChange.ipc$dispatch("-1535529750", new Object[]{this});
            return;
        }
        this.spoilerSwitch = (SwitchButton) findViewById(R$id.spoiler_switch);
        this.desTv = (TextView) findViewById(R$id.tv_des);
        this.switchDesTv = (TextView) findViewById(R$id.tv_switch_des);
    }

    @Nullable
    public final TextView getDesTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "118597909") ? (TextView) ipChange.ipc$dispatch("118597909", new Object[]{this}) : this.desTv;
    }

    @Nullable
    public final Boolean getIsSpoiler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1999950426")) {
            return (Boolean) ipChange.ipc$dispatch("1999950426", new Object[]{this});
        }
        SwitchButton switchButton = this.spoilerSwitch;
        if (switchButton != null) {
            return Boolean.valueOf(switchButton.isChecked());
        }
        return null;
    }

    @Nullable
    public final SwitchButton getSpoilerSwitch() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-90351841") ? (SwitchButton) ipChange.ipc$dispatch("-90351841", new Object[]{this}) : this.spoilerSwitch;
    }

    @Nullable
    public final TextView getSwitchDesTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1333980265") ? (TextView) ipChange.ipc$dispatch("1333980265", new Object[]{this}) : this.switchDesTv;
    }

    public final void setDesTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-204726729")) {
            ipChange.ipc$dispatch("-204726729", new Object[]{this, textView});
        } else {
            this.desTv = textView;
        }
    }

    public final void setIsSpoiler(boolean z) {
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-463556917")) {
            ipChange.ipc$dispatch("-463556917", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        SwitchButton switchButton = this.spoilerSwitch;
        if (switchButton != null) {
            switchButton.setChecked(z);
        }
        SwitchButton switchButton2 = this.spoilerSwitch;
        if ((switchButton2 == null || !switchButton2.isChecked()) ? false : false) {
            TextView textView = this.desTv;
            if (textView != null) {
                textView.setText(getResources().getString(R$string.spoiler_des_ch));
            }
            TextView textView2 = this.switchDesTv;
            if (textView2 == null) {
                return;
            }
            textView2.setText("包含");
            return;
        }
        TextView textView3 = this.desTv;
        if (textView3 != null) {
            textView3.setText(getResources().getString(R$string.spoiler_des));
        }
        TextView textView4 = this.switchDesTv;
        if (textView4 == null) {
            return;
        }
        textView4.setText("不含");
    }

    public final void setSpoilerSwitch(@Nullable SwitchButton switchButton) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1189810125")) {
            ipChange.ipc$dispatch("-1189810125", new Object[]{this, switchButton});
        } else {
            this.spoilerSwitch = switchButton;
        }
    }

    public final void setSwitchDesTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1622466973")) {
            ipChange.ipc$dispatch("-1622466973", new Object[]{this, textView});
        } else {
            this.switchDesTv = textView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpoilerSwitchView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(context).inflate(R$layout.spoiler_switch_view_layout, (ViewGroup) this, true);
        initView();
        SwitchButton switchButton = this.spoilerSwitch;
        if (switchButton != null) {
            switchButton.setOnClickListener(new View.OnClickListener() { // from class: tb.hf2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpoilerSwitchView.m64_init_$lambda0(SpoilerSwitchView.this, view);
                }
            });
        }
    }
}
