package com.alibaba.pictures.bricks.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$style;
import com.alibaba.pictures.bricks.bean.BottomAction;
import com.alibaba.pictures.bricks.view.BottomActionDialog;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.opendevice.c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class BottomActionDialog extends Dialog implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final ArrayList<BottomAction> a;
    @NotNull
    private final OnActionListener b;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static transient /* synthetic */ IpChange $ipChange;

        public Adapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1226955268") ? ((Integer) ipChange.ipc$dispatch("1226955268", new Object[]{this})).intValue() : BottomActionDialog.this.c().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1989560203")) {
                ipChange.ipc$dispatch("-1989560203", new Object[]{this, viewHolder, Integer.valueOf(i)});
                return;
            }
            b41.i(viewHolder, "holder");
            BottomAction bottomAction = BottomActionDialog.this.c().get(i);
            b41.h(bottomAction, "actionList[position]");
            ((Vh) viewHolder).b(bottomAction);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1276002593")) {
                return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1276002593", new Object[]{this, viewGroup, Integer.valueOf(i)});
            }
            b41.i(viewGroup, "parent");
            BottomActionDialog bottomActionDialog = BottomActionDialog.this;
            View inflate = LayoutInflater.from(bottomActionDialog.getContext()).inflate(R$layout.bricks_bottom_one_action_view, viewGroup, false);
            b41.h(inflate, "from(context)\n          …tion_view, parent, false)");
            return new Vh(bottomActionDialog, inflate);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnActionListener {
        void onClick(@NotNull BottomAction bottomAction, @NotNull View view, @NotNull Dialog dialog);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class Vh extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final TextView a;
        final /* synthetic */ BottomActionDialog b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Vh(@NotNull BottomActionDialog bottomActionDialog, View view) {
            super(view);
            b41.i(view, "itemView");
            this.b = bottomActionDialog;
            View findViewById = view.findViewById(R$id.bricks_dialog_bottom_action_tv);
            b41.h(findViewById, "itemView.findViewById(R.…_dialog_bottom_action_tv)");
            this.a = (TextView) findViewById;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(BottomActionDialog bottomActionDialog, BottomAction bottomAction, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2088576450")) {
                ipChange.ipc$dispatch("2088576450", new Object[]{bottomActionDialog, bottomAction, view});
                return;
            }
            b41.i(bottomActionDialog, "this$0");
            b41.i(bottomAction, "$action");
            OnActionListener d = bottomActionDialog.d();
            b41.h(view, AdvanceSetting.NETWORK_TYPE);
            d.onClick(bottomAction, view, bottomActionDialog);
        }

        public final void b(@NotNull final BottomAction bottomAction) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-156414106")) {
                ipChange.ipc$dispatch("-156414106", new Object[]{this, bottomAction});
                return;
            }
            b41.i(bottomAction, "action");
            this.a.setText(bottomAction.getTitle());
            View view = this.itemView;
            final BottomActionDialog bottomActionDialog = this.b;
            view.setOnClickListener(new View.OnClickListener() { // from class: tb.hd
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BottomActionDialog.Vh.c(BottomActionDialog.this, bottomAction, view2);
                }
            });
        }
    }

    public /* synthetic */ BottomActionDialog(Context context, ArrayList arrayList, OnActionListener onActionListener, int i, int i2, k50 k50Var) {
        this(context, arrayList, onActionListener, (i2 & 8) != 0 ? R$style.bricks_translucent_dialog_style : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(BottomActionDialog bottomActionDialog, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1583569472")) {
            ipChange.ipc$dispatch("-1583569472", new Object[]{bottomActionDialog, view});
            return;
        }
        b41.i(bottomActionDialog, "this$0");
        bottomActionDialog.dismiss();
    }

    @NotNull
    public final ArrayList<BottomAction> c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "745122670") ? (ArrayList) ipChange.ipc$dispatch("745122670", new Object[]{this}) : this.a;
    }

    @NotNull
    public final OnActionListener d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-930604141") ? (OnActionListener) ipChange.ipc$dispatch("-930604141", new Object[]{this}) : this.b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-911868483")) {
            ipChange.ipc$dispatch("-911868483", new Object[]{this, view});
            return;
        }
        b41.i(view, "v");
        if (view.getId() == R$id.bricks_dialog_bottom_action_container) {
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        WindowManager.LayoutParams attributes;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-641429777")) {
            ipChange.ipc$dispatch("-641429777", new Object[]{this});
            return;
        }
        super.show();
        Window window = getWindow();
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        b41.h(attributes, "attributes");
        attributes.width = DisplayMetrics.getwidthPixels(window.getContext().getResources().getDisplayMetrics());
        window.setAttributes(attributes);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomActionDialog(@NotNull Context context, @NotNull ArrayList<BottomAction> arrayList, @NotNull OnActionListener onActionListener, int i) {
        super(context, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(arrayList, "actionList");
        b41.i(onActionListener, "listener");
        this.a = arrayList;
        this.b = onActionListener;
        View inflate = LayoutInflater.from(context).inflate(R$layout.bricks_bottom_action_dialog, (ViewGroup) null);
        b41.h(inflate, "from(context).inflate(R.…ttom_action_dialog, null)");
        inflate.findViewById(R$id.bricks_dialog_bottom_action_cancel).setOnClickListener(new View.OnClickListener() { // from class: tb.gd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomActionDialog.b(BottomActionDialog.this, view);
            }
        });
        View findViewById = inflate.findViewById(R$id.bricks_dialog_bottom_action_container);
        View findViewById2 = inflate.findViewById(R$id.bricks_dialog_bottom_action_lv);
        b41.h(findViewById2, "inflate.findViewById(R.i…_dialog_bottom_action_lv)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        recyclerView.setAdapter(new Adapter());
        final Paint paint = new Paint(1);
        paint.setColor(Color.parseColor("#16000000"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.alibaba.pictures.bricks.view.BottomActionDialog.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void onDrawOver(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView2, @NotNull RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                int i2 = 0;
                if (AndroidInstantRuntime.support(ipChange, "-238074604")) {
                    ipChange.ipc$dispatch("-238074604", new Object[]{this, canvas, recyclerView2, state});
                    return;
                }
                b41.i(canvas, c.a);
                b41.i(recyclerView2, "parent");
                b41.i(state, "state");
                super.onDrawOver(canvas, recyclerView2, state);
                int childCount = recyclerView2.getChildCount();
                if (childCount < 0) {
                    return;
                }
                while (true) {
                    if (i2 < recyclerView2.getChildCount() - 1) {
                        View childAt = recyclerView2.getChildAt(i2);
                        canvas.drawLine(childAt.getLeft(), childAt.getBottom(), childAt.getRight(), childAt.getBottom(), paint);
                    }
                    if (i2 == childCount) {
                        return;
                    }
                    i2++;
                }
            }
        });
        findViewById.setOnClickListener(this);
        setContentView(inflate);
    }
}
