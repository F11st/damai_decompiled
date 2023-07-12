package com.youku.resource.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.resource.R;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKLayout extends FrameLayout {
    public static final int TYPE_AD = 4;
    public static final int TYPE_INFO = 1000;
    public static final int TYPE_MEMBER = 3;
    public static final int TYPE_OPERATE = 1;
    public static final int TYPE_PROPERTY = 2;
    public static final int TYPE_SCORE = 1001;
    private View bottom_bg;
    private TextView bottom_left;
    private TextView bottom_right;
    private TUrlImageView resource_image;
    private TextView top_left;
    private TextView top_right;
    private TUrlImageView top_right_gif;

    public YKLayout(Context context) {
        super(context);
        init(context);
    }

    private int getEndColor(int i) {
        Color.parseColor("#b3000000");
        if (i == 1) {
            return Color.parseColor("#cc00beff");
        }
        if (i == 2) {
            return Color.parseColor("#ccff6666");
        }
        if (i == 3) {
            return Color.parseColor("#ccff9313");
        }
        if (i == 4) {
            return Color.parseColor("#b3000000");
        }
        return Color.parseColor("#cc00beff");
    }

    private int getLeftEndColor(int i) {
        Color.parseColor("#e6999999");
        if (i == 1) {
            return Color.parseColor("#e6ff6600");
        }
        if (i == 2) {
            return Color.parseColor("#e6ff9313");
        }
        if (i == 3) {
            return Color.parseColor("#e6eec72a");
        }
        return Color.parseColor("#e6999999");
    }

    private int getLeftStartColor(int i) {
        Color.parseColor("#e65c5c5c");
        if (i == 1) {
            return Color.parseColor("#e6f82a19");
        }
        if (i == 2) {
            return Color.parseColor("#e6ff6600");
        }
        if (i == 3) {
            return Color.parseColor("#e6ff9f00");
        }
        return Color.parseColor("#e65c5c5c");
    }

    private int getStartColor(int i) {
        Color.parseColor("#b3000000");
        if (i == 1) {
            return Color.parseColor("#cc399bff");
        }
        if (i == 2) {
            return Color.parseColor("#ccf82a19");
        }
        if (i == 3) {
            return Color.parseColor("#ccff6600");
        }
        if (i == 4) {
            return Color.parseColor("#b3000000");
        }
        return Color.parseColor("#cc399bff");
    }

    private Drawable getTopLeftDrawable(int i) {
        Path path = new Path();
        path.moveTo(50.0f, 0.0f);
        path.lineTo(0.0f, 50.0f);
        path.lineTo(50.0f, 100.0f);
        path.lineTo(100.0f, 50.0f);
        path.close();
        new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{getLeftStartColor(i), getLeftEndColor(i)});
        return new ShapeDrawable(new PathShape(path, 100.0f, 100.0f));
    }

    private Drawable getTopRightDrawable(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{getStartColor(i), getEndColor(i)});
        gradientDrawable.setShape(0);
        return gradientDrawable;
    }

    private void init(Context context) {
        setWillNotDraw(false);
        View inflate = LayoutInflater.from(context).inflate(R.C8074layout.resource_yklayout, (ViewGroup) this, true);
        TUrlImageView tUrlImageView = (TUrlImageView) inflate.findViewById(R.id.resource_image);
        this.resource_image = tUrlImageView;
        tUrlImageView.setPlaceHoldForeground(getResources().getDrawable(R.C8071color.soku_default_video_bg));
        this.top_left = (TextView) inflate.findViewById(R.id.top_left);
        this.top_right = (TextView) inflate.findViewById(R.id.top_right);
        this.bottom_bg = inflate.findViewById(R.id.bottom_bg);
        this.bottom_left = (TextView) inflate.findViewById(R.id.bottom_left);
        this.bottom_right = (TextView) inflate.findViewById(R.id.bottom_right);
        this.top_right_gif = (TUrlImageView) inflate.findViewById(R.id.top_right_gif);
    }

    public TUrlImageView getTUrlImageView() {
        return this.resource_image;
    }

    public void hideAll() {
        this.bottom_bg.setVisibility(8);
        this.bottom_right.setVisibility(8);
        this.bottom_left.setVisibility(8);
        this.top_right.setVisibility(8);
        this.top_right_gif.setImageUrl(null);
    }

    public void setBottomLeftText(String str) {
        this.bottom_bg.setVisibility(0);
        this.bottom_left.setVisibility(0);
        this.bottom_left.setTextColor(getResources().getColor(17170443));
        this.bottom_left.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.resource_size_11));
        this.bottom_left.setText(str);
    }

    public void setBottomRightText(String str) {
        this.bottom_bg.setVisibility(0);
        this.bottom_right.setVisibility(0);
        this.bottom_right.setTextColor(getResources().getColor(17170443));
        this.bottom_right.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.resource_size_11));
        this.bottom_right.setText(str);
    }

    public void setRank(int i) {
        if (i > 0) {
            TextView textView = this.top_left;
            textView.setText("NO." + i);
        }
    }

    public void setReputation(String str) {
        this.bottom_bg.setVisibility(0);
        this.bottom_right.setVisibility(0);
        this.bottom_right.setTextColor(getResources().getColor(R.C8071color.color_ff6600));
        this.bottom_right.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.resource_size_13));
        this.bottom_right.setText(str);
    }

    public void setTopRight(String str, int i) {
        this.top_right.setVisibility(0);
        this.top_right.setBackgroundDrawable(getTopRightDrawable(i));
        this.top_right.setText(str);
    }

    public void setTopRightImageUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.indexOf("?") == -1 && str.endsWith("apng")) {
            str = str + "?noResize=1&noWebp=1";
        }
        this.top_right_gif.setImageUrl(str);
    }

    public YKLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }
}
