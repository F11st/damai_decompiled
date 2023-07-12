package com.taobao.weex.ui.component.list;

import androidx.recyclerview.widget.RecyclerView;
import com.taobao.weex.ui.view.listview.adapter.TransformItemDecoration;
import com.taobao.weex.utils.WXLogUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RecyclerTransform {
    private static final String TAG = "RecyclerTransform";
    public static final String TRANSFORM = "transform";
    private static final Pattern transformPattern = Pattern.compile("([a-z]+)\\(([0-9\\.]+),?([0-9\\.]+)?\\)");

    public static RecyclerView.ItemDecoration parseTransforms(int i, String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = transformPattern.matcher(str);
        float f = 0.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (matcher.find()) {
            String group = matcher.group();
            String group2 = matcher.group(1);
            char c = 65535;
            try {
                switch (group2.hashCode()) {
                    case -1267206133:
                        if (group2.equals("opacity")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -925180581:
                        if (group2.equals("rotate")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 109250890:
                        if (group2.equals("scale")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 1052832078:
                        if (group2.equals("translate")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    f2 = Float.parseFloat(matcher.group(2));
                    f3 = Float.parseFloat(matcher.group(3));
                } else if (c == 1) {
                    i2 = Integer.parseInt(matcher.group(2));
                    i3 = Integer.parseInt(matcher.group(3));
                } else if (c == 2) {
                    f = Float.parseFloat(matcher.group(2));
                } else if (c != 3) {
                    WXLogUtils.e(TAG, "Invaild transform expression:" + group);
                } else {
                    i4 = Integer.parseInt(matcher.group(2));
                }
            } catch (NumberFormatException e) {
                WXLogUtils.e("", e);
                WXLogUtils.e(TAG, "Invaild transform expression:" + group);
            }
        }
        return new TransformItemDecoration(i == 1, f, i2, i3, i4, f2, f3);
    }
}
