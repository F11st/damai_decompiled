package cn.damai.commonbusiness.citycopy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class FloatingTitleDecoration extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final int[] k = {16843284};
    private Drawable a;
    private int b;
    private int d;
    private Paint e;
    private Paint f;
    private float g;
    private float h;
    private Context i;
    private Map<Integer, String> c = new HashMap();
    private boolean j = true;

    public FloatingTitleDecoration(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(k);
        this.a = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        this.b = this.a.getIntrinsicHeight();
        this.a.getIntrinsicWidth();
        b(context);
    }

    private String a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1383884522")) {
            return (String) ipChange.ipc$dispatch("-1383884522", new Object[]{this, Integer.valueOf(i)});
        }
        while (i >= 0) {
            if (this.c.containsKey(Integer.valueOf(i))) {
                return this.c.get(Integer.valueOf(i));
            }
            i--;
        }
        return null;
    }

    private void b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2028606717")) {
            ipChange.ipc$dispatch("2028606717", new Object[]{this, context});
            return;
        }
        this.i = context;
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setTextSize(TypedValue.applyDimension(1, 13.0f, context.getResources().getDisplayMetrics()));
        this.e.setColor(Color.parseColor("#AAAAAA"));
        Paint.FontMetrics fontMetrics = this.e.getFontMetrics();
        float f = fontMetrics.bottom;
        this.g = f - fontMetrics.top;
        this.h = f;
        Paint paint2 = new Paint();
        this.f = paint2;
        paint2.setAntiAlias(true);
        this.f.setColor(Color.parseColor("#F5F5F5"));
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1194637165")) {
            ipChange.ipc$dispatch("-1194637165", new Object[]{this, canvas, recyclerView});
            return;
        }
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            if (!this.c.containsKey(Integer.valueOf(layoutParams.getViewLayoutPosition()))) {
                int top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int i2 = this.b;
                int i3 = top - i2;
                this.a.setBounds(paddingLeft, i3, width, i2 + i3);
                this.a.draw(canvas);
            } else {
                int top2 = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int i4 = this.d;
                int i5 = top2 - i4;
                float f = i4 + i5;
                canvas.drawRect(paddingLeft, i5, width, f, this.f);
                float applyDimension = TypedValue.applyDimension(1, 15.0f, this.i.getResources().getDisplayMetrics());
                float f2 = (f - ((this.d - this.g) / 2.0f)) - this.h;
                if (!TextUtils.isEmpty(this.c.get(Integer.valueOf(layoutParams.getViewLayoutPosition())))) {
                    canvas.drawText(this.c.get(Integer.valueOf(layoutParams.getViewLayoutPosition())), applyDimension, f2, this.e);
                }
            }
        }
    }

    public void c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1751875835")) {
            ipChange.ipc$dispatch("-1751875835", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.d = i;
        }
    }

    public void d(Map<Integer, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1919904787")) {
            ipChange.ipc$dispatch("1919904787", new Object[]{this, map});
            return;
        }
        this.c.clear();
        this.c.putAll(map);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2117972400")) {
            ipChange.ipc$dispatch("2117972400", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.c.containsKey(Integer.valueOf(recyclerView.getChildViewHolder(view).getAdapterPosition()))) {
            rect.set(0, this.d, 0, 0);
        } else {
            rect.set(0, this.b, 0, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1836099200")) {
            ipChange.ipc$dispatch("1836099200", new Object[]{this, canvas, recyclerView, state});
            return;
        }
        super.onDraw(canvas, recyclerView, state);
        drawVertical(canvas, recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int findFirstVisibleItemPosition;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1600166668")) {
            ipChange.ipc$dispatch("-1600166668", new Object[]{this, canvas, recyclerView, state});
            return;
        }
        super.onDrawOver(canvas, recyclerView, state);
        if (this.j && (findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition()) != -1) {
            String a = a(findFirstVisibleItemPosition);
            if (TextUtils.isEmpty(a)) {
                return;
            }
            int i = findFirstVisibleItemPosition + 1;
            if (a(i) != null && !a.equals(a(i)) && recyclerView.findViewHolderForAdapterPosition(findFirstVisibleItemPosition) != null) {
                View view = recyclerView.findViewHolderForAdapterPosition(findFirstVisibleItemPosition).itemView;
                if (view.getTop() + view.getMeasuredHeight() < this.d) {
                    canvas.save();
                    canvas.translate(0.0f, (view.getTop() + view.getMeasuredHeight()) - this.d);
                    z = true;
                }
            }
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int paddingTop = recyclerView.getPaddingTop();
            float f = this.d + paddingTop;
            canvas.drawRect(paddingLeft, paddingTop, width, f, this.f);
            canvas.drawText(a, TypedValue.applyDimension(1, 15.0f, this.i.getResources().getDisplayMetrics()), (f - ((this.d - this.g) / 2.0f)) - this.h, this.e);
            if (z) {
                canvas.restore();
            }
        }
    }
}
