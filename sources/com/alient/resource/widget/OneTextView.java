package com.alient.resource.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.alient.oneresource.R;
import com.alient.resource.token.TokenManager;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.uc.webview.export.extension.UCCore;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/alient/resource/widget/OneTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "Ltb/wt2;", UCCore.LEGACY_EVENT_INIT, "loadAttrs", "", "textColorToken", "Ljava/lang/String;", "textSizeToken", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "oneresource_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes10.dex */
public class OneTextView extends AppCompatTextView {
    private String textColorToken;
    private String textSizeToken;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneTextView(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        init(context, null);
    }

    private final void init(Context context, AttributeSet attributeSet) {
        Integer fontToken;
        Integer colorToken;
        loadAttrs(context, attributeSet);
        String str = this.textColorToken;
        if (str != null && (colorToken = TokenManager.Companion.getInstance().getColorToken(context, str)) != null) {
            setTextColor(colorToken.intValue());
        }
        String str2 = this.textSizeToken;
        if (str2 == null || (fontToken = TokenManager.Companion.getInstance().getFontToken(context, str2)) == null) {
            return;
        }
        setTextSize(1, fontToken.intValue());
    }

    private final void loadAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = null;
        try {
            try {
                typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.OneTextView);
                this.textColorToken = typedArray.getString(R.styleable.OneTextView_OneTextColor);
                this.textSizeToken = typedArray.getString(R.styleable.OneTextView_OneTextSize);
            } catch (Exception e) {
                e.printStackTrace();
                if (typedArray == null) {
                    return;
                }
            }
            typedArray.recycle();
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        init(context, attributeSet);
    }
}
