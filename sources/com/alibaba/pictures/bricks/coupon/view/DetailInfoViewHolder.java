package com.alibaba.pictures.bricks.coupon.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.bricks.coupon.view.DetailInfoViewHolder;
import com.alibaba.pictures.bricks.util.htmlparser.HtmlParserManager;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.NavProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.s60;
import tb.v11;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class DetailInfoViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final int b = 0;
    @Nullable
    private OnChangeListener a;
    @NotNull
    public static final a Companion = new a(null);
    private static final int c = 1;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnChangeListener {
        void onChanged(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        public final int a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-32307320") ? ((Integer) ipChange.ipc$dispatch("-32307320", new Object[]{this})).intValue() : DetailInfoViewHolder.b;
        }

        public final int b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "601582884") ? ((Integer) ipChange.ipc$dispatch("601582884", new Object[]{this})).intValue() : DetailInfoViewHolder.c;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b implements HtmlParserManager.OnSpanClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // com.alibaba.pictures.bricks.util.htmlparser.HtmlParserManager.OnSpanClickListener
        public void onSpanClick(int i, @NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-781716268")) {
                ipChange.ipc$dispatch("-781716268", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            b41.i(str, "source");
            NavProviderProxy.getProxy().toUri(this.a, str);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class c implements HtmlParserManager.OnParseFinishedListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RecyclerView a;
        final /* synthetic */ Context b;
        final /* synthetic */ TextView c;
        final /* synthetic */ DetailInfoViewHolder d;

        c(RecyclerView recyclerView, Context context, TextView textView, DetailInfoViewHolder detailInfoViewHolder) {
            this.a = recyclerView;
            this.b = context;
            this.c = textView;
            this.d = detailInfoViewHolder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(RecyclerView recyclerView, List list, TextView textView, DetailInfoViewHolder detailInfoViewHolder, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-733313484")) {
                ipChange.ipc$dispatch("-733313484", new Object[]{recyclerView, list, textView, detailInfoViewHolder, view});
                return;
            }
            b41.i(recyclerView, "$view");
            b41.i(list, "$this_apply");
            b41.i(textView, "$btn");
            b41.i(detailInfoViewHolder, "this$0");
            if (recyclerView.getAdapter() instanceof RichTextAdapter) {
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                b41.g(adapter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.coupon.view.RichTextAdapter");
                if (((RichTextAdapter) adapter).getItemCount() > 2) {
                    RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
                    b41.g(adapter2, "null cannot be cast to non-null type com.alibaba.pictures.bricks.coupon.view.RichTextAdapter");
                    ((RichTextAdapter) adapter2).m(list.subList(0, 2));
                    textView.setText("展开更多");
                    OnChangeListener onChangeListener = detailInfoViewHolder.a;
                    if (onChangeListener != null) {
                        onChangeListener.onChanged(DetailInfoViewHolder.Companion.a());
                        return;
                    }
                    return;
                }
                RecyclerView.Adapter adapter3 = recyclerView.getAdapter();
                b41.g(adapter3, "null cannot be cast to non-null type com.alibaba.pictures.bricks.coupon.view.RichTextAdapter");
                ((RichTextAdapter) adapter3).m(list);
                textView.setText("收起");
                OnChangeListener onChangeListener2 = detailInfoViewHolder.a;
                if (onChangeListener2 != null) {
                    onChangeListener2.onChanged(DetailInfoViewHolder.Companion.b());
                }
            }
        }

        @Override // com.alibaba.pictures.bricks.util.htmlparser.HtmlParserManager.OnParseFinishedListener
        public void onParseFinished(@Nullable List<HtmlParserManager.b> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "638493666")) {
                ipChange.ipc$dispatch("638493666", new Object[]{this, list});
            } else if (list != null) {
                final RecyclerView recyclerView = this.a;
                Context context = this.b;
                final TextView textView = this.c;
                final DetailInfoViewHolder detailInfoViewHolder = this.d;
                ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
                ArrayList<HtmlParserManager.b> arrayList2 = new ArrayList();
                for (Object obj : list) {
                    if (((HtmlParserManager.b) obj).f() == 2) {
                        arrayList2.add(obj);
                    }
                }
                for (HtmlParserManager.b bVar : arrayList2) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("img", String.valueOf(bVar.a()));
                    arrayList.add(hashMap);
                }
                final List<HtmlParserManager.b> c = v11.INSTANCE.c(list);
                if (c.size() > 2) {
                    recyclerView.setAdapter(new RichTextAdapter(c.subList(0, 2), context));
                    RecyclerView.Adapter adapter = recyclerView.getAdapter();
                    b41.g(adapter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.coupon.view.RichTextAdapter");
                    ((RichTextAdapter) adapter).l(arrayList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    textView.setVisibility(0);
                    textView.setText("展开更多");
                    textView.setOnClickListener(new View.OnClickListener() { // from class: tb.t70
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            DetailInfoViewHolder.c.b(RecyclerView.this, c, textView, detailInfoViewHolder, view);
                        }
                    });
                    return;
                }
                recyclerView.setAdapter(new RichTextAdapter(c, context));
                RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
                b41.g(adapter2, "null cannot be cast to non-null type com.alibaba.pictures.bricks.coupon.view.RichTextAdapter");
                ((RichTextAdapter) adapter2).l(arrayList);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                textView.setVisibility(8);
            }
        }
    }

    public final void d(@NotNull String str, @NotNull Context context, @NotNull RecyclerView recyclerView, @NotNull TextView textView, @NotNull OnChangeListener onChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2033715467")) {
            ipChange.ipc$dispatch("-2033715467", new Object[]{this, str, context, recyclerView, textView, onChangeListener});
            return;
        }
        b41.i(str, "str");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(recyclerView, "view");
        b41.i(textView, "btn");
        b41.i(onChangeListener, "listener");
        e(onChangeListener);
        HtmlParserManager.Companion.a(DisplayMetrics.getwidthPixels(s60.INSTANCE.f(context)), 1.4f, 333333, 16, 888888, 14).b(context, str, new b(context), new c(recyclerView, context, textView, this));
    }

    public final void e(@NotNull OnChangeListener onChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175975979")) {
            ipChange.ipc$dispatch("-1175975979", new Object[]{this, onChangeListener});
            return;
        }
        b41.i(onChangeListener, "listener");
        this.a = onChangeListener;
    }
}
