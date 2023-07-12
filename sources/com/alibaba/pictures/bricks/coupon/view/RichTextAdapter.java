package com.alibaba.pictures.bricks.coupon.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.bricks.coupon.view.RichTextAdapter;
import com.alibaba.pictures.bricks.coupon.view.RichTextViewHolder;
import com.alibaba.pictures.bricks.util.htmlparser.HtmlParserManager;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.ImageTicket;
import com.alient.oneservice.image.SuccessEvent;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RichTextAdapter extends RecyclerView.Adapter<RichTextViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private List<HtmlParserManager.b> a;
    @NotNull
    private Context b;
    @NotNull
    private ArrayList<HashMap<String, String>> c;

    public RichTextAdapter(@NotNull List<HtmlParserManager.b> list, @NotNull Context context) {
        b41.i(list, "convertedItemList");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = list;
        this.b = context;
        this.c = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final RichTextViewHolder richTextViewHolder, int i, final RichTextAdapter richTextAdapter, final Ref$ObjectRef ref$ObjectRef, SuccessEvent successEvent) {
        Drawable drawable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1500517228")) {
            ipChange.ipc$dispatch("1500517228", new Object[]{richTextViewHolder, Integer.valueOf(i), richTextAdapter, ref$ObjectRef, successEvent});
            return;
        }
        b41.i(richTextViewHolder, "$holder");
        b41.i(richTextAdapter, "this$0");
        b41.i(ref$ObjectRef, "$item");
        if (successEvent != null && (drawable = successEvent.drawable) != null) {
            richTextAdapter.k(richTextViewHolder.a(), i, (int) (((successEvent.drawable.getIntrinsicHeight() * i) * 1.0f) / drawable.getIntrinsicWidth()));
            richTextViewHolder.a().setImageDrawable(successEvent.drawable);
            richTextViewHolder.a().setOnClickListener(new View.OnClickListener() { // from class: tb.l32
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RichTextAdapter.g(RichTextViewHolder.this, ref$ObjectRef, richTextAdapter, view);
                }
            });
            return;
        }
        richTextViewHolder.a().setImageResource(R$drawable.bricks_uikit_default_image_bg_grey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(RichTextViewHolder richTextViewHolder, Ref$ObjectRef ref$ObjectRef, RichTextAdapter richTextAdapter, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1237863150")) {
            ipChange.ipc$dispatch("1237863150", new Object[]{richTextViewHolder, ref$ObjectRef, richTextAdapter, view});
            return;
        }
        b41.i(richTextViewHolder, "$holder");
        b41.i(ref$ObjectRef, "$item");
        b41.i(richTextAdapter, "this$0");
        Context context = richTextViewHolder.itemView.getContext();
        if (!TextUtils.isEmpty(((HtmlParserManager.b) ref$ObjectRef.element).d())) {
            Bundle bundle = new Bundle();
            bundle.putString("url", ((HtmlParserManager.b) ref$ObjectRef.element).d());
            Action action = new Action();
            action.setActionType(1);
            action.setActionUrl("damai://webview");
            action.setExtra(bundle);
            NavProviderProxy.getProxy().toUri(context, action);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("pic_info_map", richTextAdapter.c);
        bundle2.putInt("position", ((HtmlParserManager.b) ref$ObjectRef.element).e());
        Action action2 = new Action();
        action2.setActionType(1);
        action2.setActionUrl("damai://videobrowse");
        action2.setExtra(bundle2);
        NavProviderProxy.getProxy().toUri(context, action2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(RichTextAdapter richTextAdapter, int i, RichTextViewHolder richTextViewHolder, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1274665792")) {
            ipChange.ipc$dispatch("1274665792", new Object[]{richTextAdapter, Integer.valueOf(i), richTextViewHolder, failEvent});
            return;
        }
        b41.i(richTextAdapter, "this$0");
        b41.i(richTextViewHolder, "$holder");
        richTextAdapter.j(i, richTextViewHolder);
    }

    private final void j(int i, RichTextViewHolder richTextViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "308048160")) {
            ipChange.ipc$dispatch("308048160", new Object[]{this, Integer.valueOf(i), richTextViewHolder});
            return;
        }
        int i2 = i / 2;
        k(richTextViewHolder.a(), i2, (int) ((i2 * 6.0f) / 19));
        richTextViewHolder.a().setImageDrawable(this.b.getResources().getDrawable(R$drawable.bricks_default_image_bg_gradient));
    }

    private final void k(ImageView imageView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1161977545")) {
            ipChange.ipc$dispatch("-1161977545", new Object[]{this, imageView, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        imageView.getLayoutParams().width = i;
        imageView.getLayoutParams().height = i2;
        imageView.setLayoutParams(imageView.getLayoutParams());
    }

    @NotNull
    public final HtmlParserManager.b d(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1220803712") ? (HtmlParserManager.b) ipChange.ipc$dispatch("-1220803712", new Object[]{this, Integer.valueOf(i)}) : this.a.get(i);
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [com.alibaba.pictures.bricks.util.htmlparser.HtmlParserManager$b, T] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(@NotNull final RichTextViewHolder richTextViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "636867714")) {
            ipChange.ipc$dispatch("636867714", new Object[]{this, richTextViewHolder, Integer.valueOf(i)});
            return;
        }
        b41.i(richTextViewHolder, "holder");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? d = d(i);
        ref$ObjectRef.element = d;
        if (((HtmlParserManager.b) d).f() == 1) {
            richTextViewHolder.b().setText(((HtmlParserManager.b) ref$ObjectRef.element).a());
            return;
        }
        final int b = DisplayMetrics.getwidthPixels(this.b.getResources().getDisplayMetrics()) - (s60.INSTANCE.b(this.b, 12) * 2);
        Object tag = richTextViewHolder.a().getTag();
        if (tag != null) {
            b41.h(tag, "getTag()");
            ((ImageTicket) tag).cancel();
        }
        j(b, richTextViewHolder);
        richTextViewHolder.a().setTag(ImageLoaderProviderProxy.getProxy().load(String.valueOf(((HtmlParserManager.b) ref$ObjectRef.element).a()), R$drawable.bricks_default_image_bg_gradient, new IImageSuccListener() { // from class: tb.n32
            @Override // com.alient.oneservice.image.IImageSuccListener
            public final void onSuccess(SuccessEvent successEvent) {
                RichTextAdapter.f(RichTextViewHolder.this, b, this, ref$ObjectRef, successEvent);
            }
        }, new IImageFailListener() { // from class: tb.m32
            @Override // com.alient.oneservice.image.IImageFailListener
            public final void onFail(FailEvent failEvent) {
                RichTextAdapter.h(RichTextAdapter.this, b, richTextViewHolder, failEvent);
            }
        }));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "338127787") ? ((Integer) ipChange.ipc$dispatch("338127787", new Object[]{this})).intValue() : this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-671049518") ? ((Integer) ipChange.ipc$dispatch("-671049518", new Object[]{this, Integer.valueOf(i)})).intValue() : d(i).f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: i */
    public RichTextViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1710624844")) {
            return (RichTextViewHolder) ipChange.ipc$dispatch("-1710624844", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        b41.i(viewGroup, "parent");
        if (i == 1) {
            TextView textView = new TextView(viewGroup.getContext());
            s60 s60Var = s60.INSTANCE;
            textView.setLineSpacing(s60Var.a(this.b, 9.0f), 1.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = s60Var.a(this.b, 9.0f);
            textView.setLayoutParams(layoutParams);
            return new RichTextViewHolder(textView);
        }
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new RichTextViewHolder(imageView);
    }

    public final void l(@NotNull ArrayList<HashMap<String, String>> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1348191616")) {
            ipChange.ipc$dispatch("-1348191616", new Object[]{this, arrayList});
            return;
        }
        b41.i(arrayList, "<set-?>");
        this.c = arrayList;
    }

    public final void m(@NotNull List<HtmlParserManager.b> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-808602436")) {
            ipChange.ipc$dispatch("-808602436", new Object[]{this, list});
            return;
        }
        b41.i(list, "convertedItemList");
        this.a = list;
        notifyDataSetChanged();
    }
}
