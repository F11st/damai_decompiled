package com.taobao.android.dinamicx.view.richtext.node;

import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class RichText extends LinkedList<RichTextNode> {
    private CharSequence mCachedText;
    private String mDefaultText;

    public RichText() {
    }

    public String originText() {
        if (size() == 0) {
            return this.mDefaultText;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<RichTextNode> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().getText());
        }
        return sb.toString();
    }

    public CharSequence renderText() {
        return renderText(false);
    }

    public RichText(@NonNull String str) {
        this.mDefaultText = str;
    }

    public CharSequence renderText(boolean z) {
        if (this.mCachedText == null || z) {
            this.mCachedText = renderText(this, z);
        }
        return this.mCachedText;
    }

    public CharSequence renderText(List<RichTextNode> list, boolean z) {
        if (list.size() == 0) {
            return this.mDefaultText;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (RichTextNode richTextNode : list) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) richTextNode.getText());
            for (Object obj : richTextNode.toSpans(z)) {
                spannableStringBuilder.setSpan(obj, length, richTextNode.getText().length() + length, 33);
            }
        }
        return spannableStringBuilder;
    }
}
