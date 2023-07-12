package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.bricks.bean.BaseArtistDataMo;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import kotlin.collections.C8214m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ArtistRichTextView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context mContext;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.ArtistRichTextView$a */
    /* loaded from: classes7.dex */
    public /* synthetic */ class C3562a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BaseArtistDataMo.ValueType.values().length];
            iArr[BaseArtistDataMo.ValueType.TEXT.ordinal()] = 1;
            iArr[BaseArtistDataMo.ValueType.NUM.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtistRichTextView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, "mContext");
        b41.i(attributeSet, TemplateDom.KEY_ATTRS);
        this.mContext = context;
        setOrientation(0);
        setGravity(16);
    }

    private final ImageView mImageFactory(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1313005264")) {
            return (ImageView) ipChange.ipc$dispatch("-1313005264", new Object[]{this, str});
        }
        ImageView imageView = new ImageView(this.mContext);
        ImageLoaderProviderProxy.loadinto(str, imageView);
        return imageView;
    }

    private final TextView mTextFactory(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-395144378")) {
            return (TextView) ipChange.ipc$dispatch("-395144378", new Object[]{this, str});
        }
        TextView textView = new TextView(this.mContext);
        textView.setText(str);
        textView.setTextSize(1, 12.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(this.mContext.getResources().getColor(R$color.bricks_5f6672));
        return textView;
    }

    @NotNull
    public final Context getMContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "733223698") ? (Context) ipChange.ipc$dispatch("733223698", new Object[]{this}) : this.mContext;
    }

    public final void setRichView(@Nullable List<? extends BaseArtistDataMo> list) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "149816064")) {
            ipChange.ipc$dispatch("149816064", new Object[]{this, list});
            return;
        }
        removeAllViews();
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                C8214m.p();
            }
            BaseArtistDataMo baseArtistDataMo = (BaseArtistDataMo) obj;
            if (baseArtistDataMo != null) {
                BaseArtistDataMo.ValueType valueType = baseArtistDataMo.valueType;
                int i3 = valueType == null ? -1 : C3562a.$EnumSwitchMapping$0[valueType.ordinal()];
                if (i3 != 1 && i3 != 2) {
                    String str = baseArtistDataMo.value;
                    b41.h(str, "data.value");
                    ImageView mImageFactory = mImageFactory(str);
                    s60 s60Var = s60.INSTANCE;
                    Context context = getContext();
                    b41.h(context, WPKFactory.INIT_KEY_CONTEXT);
                    addView(mImageFactory, new LinearLayout.LayoutParams(-2, s60Var.b(context, 12)));
                } else {
                    String str2 = baseArtistDataMo.value;
                    b41.h(str2, "data.value");
                    addView(mTextFactory(str2), new LinearLayout.LayoutParams(-2, -2));
                }
            }
            i = i2;
        }
    }
}
