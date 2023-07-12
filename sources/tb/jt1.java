package tb;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.TicketNote;
import com.alibaba.pictures.bricks.component.instructions.ProjectSupportServiceAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class jt1 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(PopupWindow popupWindow, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1107436596")) {
            ipChange.ipc$dispatch("1107436596", new Object[]{popupWindow, view});
        } else if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(PopupWindow popupWindow, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2054340107")) {
            ipChange.ipc$dispatch("-2054340107", new Object[]{popupWindow, view});
        } else if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(PopupWindow popupWindow, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-921149514")) {
            ipChange.ipc$dispatch("-921149514", new Object[]{popupWindow, view});
        } else if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final void d(@NotNull View view, @NotNull List<TicketNote> list, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1001715375")) {
            ipChange.ipc$dispatch("-1001715375", new Object[]{this, view, list, str});
            return;
        }
        b41.i(view, AdvanceSetting.NETWORK_TYPE);
        b41.i(list, "instructions");
        b41.i(str, "title");
        View inflate = LayoutInflater.from(view.getContext()).inflate(R$layout.bricks_layout_service_notice_rl, (ViewGroup) null);
        b41.h(inflate, "from(it.context)\n       …_service_notice_rl, null)");
        qt1 qt1Var = new qt1(inflate, -1);
        Context context = view.getContext();
        b41.g(context, "null cannot be cast to non-null type android.app.Activity");
        qt1 g = qt1Var.g((Activity) context);
        ((TextView) inflate.findViewById(R$id.layer_title)).setText(str);
        int i = R$id.rl_bottom;
        View findViewById = inflate.findViewById(i);
        b41.h(findViewById, "container.findViewById(R.id.rl_bottom)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        b41.g(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        s60 s60Var = s60.INSTANCE;
        Context context2 = view.getContext();
        b41.h(context2, "it.context");
        layoutParams2.height = (int) s60Var.g(context2);
        linearLayout.setLayoutParams(layoutParams2);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R$id.project_support_service_irc);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new ProjectSupportServiceAdapter(view.getContext(), list));
        final PopupWindow b = g.b();
        int e = g.e();
        ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
        b41.g(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        layoutParams4.height = e;
        inflate.findViewById(i).setLayoutParams(layoutParams4);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: tb.gt1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                jt1.e(b, view2);
            }
        });
        inflate.findViewById(R$id.v_outside).setOnClickListener(new View.OnClickListener() { // from class: tb.ht1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                jt1.f(b, view2);
            }
        });
        inflate.findViewById(R$id.layer_close).setOnClickListener(new View.OnClickListener() { // from class: tb.it1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                jt1.g(b, view2);
            }
        });
    }
}
