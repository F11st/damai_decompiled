package cn.damai.projectfiltercopy.commonview;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.damai.projectfiltercopy.commonview.CitySelectBottomDialog;
import cn.damai.projectfiltercopy.floatview.CityFloatLayer;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.view.BricksIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class CitySelectBottomDialog extends BottomSheetDialogFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private CityFloatLayer.CustomOnCityClickListener onCityClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final void m69onCreateView$lambda0(CitySelectBottomDialog citySelectBottomDialog, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-558514234")) {
            ipChange.ipc$dispatch("-558514234", new Object[]{citySelectBottomDialog, view});
            return;
        }
        b41.i(citySelectBottomDialog, "this$0");
        Dialog dialog = citySelectBottomDialog.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1779811233")) {
            return (View) ipChange.ipc$dispatch("-1779811233", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        b41.i(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R$layout.bricks_fragment_bottom_city_dialog, viewGroup, false);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.city_list_view);
        ((BricksIconFontTextView) inflate.findViewById(R$id.city_list_close)).setOnClickListener(new View.OnClickListener() { // from class: tb.aj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CitySelectBottomDialog.m69onCreateView$lambda0(CitySelectBottomDialog.this, view);
            }
        });
        CityFloatLayer.CustomOnCityClickListener customOnCityClickListener = this.onCityClickListener;
        if (customOnCityClickListener != null) {
            CityFloatLayer cityFloatLayer = new CityFloatLayer(requireContext());
            cityFloatLayer.x(customOnCityClickListener);
            frameLayout.addView(cityFloatLayer.n());
        }
        b41.h(inflate, "view");
        return inflate;
    }

    public final void setOnCityClickListener(@NotNull CityFloatLayer.CustomOnCityClickListener customOnCityClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "943224504")) {
            ipChange.ipc$dispatch("943224504", new Object[]{this, customOnCityClickListener});
            return;
        }
        b41.i(customOnCityClickListener, "onCityClickListener");
        this.onCityClickListener = customOnCityClickListener;
    }
}
