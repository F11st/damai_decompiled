package cn.damai.comment.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import cn.damai.comment.R$color;
import cn.damai.comment.R$drawable;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.view.PublishDMTagView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.flexbox.FlexboxLayout;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import kotlin.collections.m;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.i41;
import tb.k50;
import tb.m62;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class PublishDMTagView extends FlexboxLayout {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static final class TagView extends AppCompatTextView {
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public TagView(@NotNull Context context) {
            this(context, null, 2, null);
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        }

        public /* synthetic */ TagView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
            this(context, (i & 2) != 0 ? null : attributeSet);
        }

        public final void bindData(@NotNull String str, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1287905691")) {
                ipChange.ipc$dispatch("1287905691", new Object[]{this, str, Boolean.valueOf(z)});
                return;
            }
            b41.i(str, "tag");
            setText(str);
            setTagSelected(z);
        }

        public final void setTagSelected(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "964345905")) {
                ipChange.ipc$dispatch("964345905", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            setSelected(z);
            if (z) {
                setTextColor(ContextCompat.getColor(getContext(), R$color.color_FF2869));
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(ContextCompat.getColor(getContext(), R$color.color_ffeaf1));
                gradientDrawable.setCornerRadius(t60.a(getContext(), 14.0f));
                setBackground(gradientDrawable);
                return;
            }
            setTextColor(ContextCompat.getColor(getContext(), R$color.color_333333));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(ContextCompat.getColor(getContext(), R$color.color_F6F6F6));
            gradientDrawable2.setCornerRadius(t60.a(getContext(), 14.0f));
            setBackground(gradientDrawable2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public TagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            int a = m62.a(context, 14.0f);
            setTextSize(1, 12.0f);
            setPadding(a, 0, a, 0);
            setGravity(17);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishDMTagView(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ PublishDMTagView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindData$lambda-1$lambda-0  reason: not valid java name */
    public static final void m12bindData$lambda1$lambda0(DmInfo dmInfo, String str, TagView tagView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "302059969")) {
            ipChange.ipc$dispatch("302059969", new Object[]{dmInfo, str, tagView, view});
            return;
        }
        b41.i(str, "$tag");
        b41.i(tagView, "$tagView");
        if (view.isSelected()) {
            ArrayList<String> arrayList = dmInfo.dmTags;
            if (arrayList != null) {
                arrayList.remove(str);
            }
        } else {
            ArrayList<String> arrayList2 = dmInfo.dmTags;
            if (arrayList2 != null) {
                arrayList2.add(str);
            }
        }
        tagView.setTagSelected(!tagView.isSelected());
    }

    public final void bindData(@Nullable final DmInfo dmInfo, int i) {
        ArrayList<String> arrayList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1146423947")) {
            ipChange.ipc$dispatch("1146423947", new Object[]{this, dmInfo, Integer.valueOf(i)});
            return;
        }
        ArrayList<String> arrayList2 = dmInfo != null ? dmInfo.allDmTags : null;
        removeAllViews();
        if (arrayList2 == null || arrayList2.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ArrayList<String> arrayList3 = dmInfo.dmTags;
        dmInfo.dmTags = new ArrayList<>();
        int i2 = 0;
        for (Object obj : arrayList2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                m.p();
            }
            final String str = (String) obj;
            Context context = getContext();
            b41.h(context, WPKFactory.INIT_KEY_CONTEXT);
            final TagView tagView = new TagView(context, null, 2, null);
            boolean z = arrayList3 != null && arrayList3.contains(str);
            tagView.bindData(str, z);
            i41.f(tagView, i2, i, str, String.valueOf(dmInfo.getDmId()));
            if (z && (arrayList = dmInfo.dmTags) != null) {
                arrayList.add(str);
            }
            tagView.setOnClickListener(new View.OnClickListener() { // from class: tb.vx1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishDMTagView.m12bindData$lambda1$lambda0(DmInfo.this, str, tagView, view);
                }
            });
            addView(tagView, new FlexboxLayout.LayoutParams(-2, m62.a(getContext(), 28.0f)));
            i2 = i3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishDMTagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        setFlexDirection(0);
        setFlexWrap(1);
        setAlignItems(4);
        setJustifyContent(0);
        setShowDividerHorizontal(2);
        setShowDividerVertical(2);
        setDividerDrawable(getResources().getDrawable(R$drawable.comment_dm_tag_divider));
    }
}
