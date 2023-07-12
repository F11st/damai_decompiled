package cn.damai.discover.content.ui.viewholder;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.discover.content.bean.ContentTour;
import cn.damai.discover.content.ui.adapter.CityProjectListAdapter;
import cn.damai.homepage.R$id;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CityProjectListPanel {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private CityProjectListAdapter b;
    private View c;
    private Paint d;

    public CityProjectListPanel(View view, OnItemBindListener<ContentTour.ContentRelatedTourListItem> onItemBindListener) {
        View findViewById = view.findViewById(R$id.relate_project_city_list_ui);
        this.a = findViewById;
        RecyclerView recyclerView = (RecyclerView) findViewById.findViewById(R$id.relate_project_city_list);
        this.c = this.a.findViewById(R$id.relate_project_city_list_layout);
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(1.0f);
        this.d.setColor(Color.parseColor("#1A000000"));
        recyclerView.setLayoutManager(new LinearLayoutManager(mu0.a(), 0, false));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.discover.content.ui.viewholder.CityProjectListPanel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void onDrawOver(Canvas canvas, RecyclerView recyclerView2, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-791191471")) {
                    ipChange.ipc$dispatch("-791191471", new Object[]{this, canvas, recyclerView2, state});
                    return;
                }
                int childCount = recyclerView2.getChildCount();
                int measuredHeight = recyclerView2.getMeasuredHeight();
                if (childCount > 0) {
                    for (int i = 0; i < childCount; i++) {
                        View childAt = recyclerView2.getChildAt(i);
                        if (childAt != null) {
                            float right = childAt.getRight();
                            canvas.drawLine(right, 0.0f, right, measuredHeight, CityProjectListPanel.this.d);
                        }
                    }
                }
            }
        });
        CityProjectListAdapter cityProjectListAdapter = new CityProjectListAdapter(onItemBindListener);
        this.b = cityProjectListAdapter;
        recyclerView.setAdapter(cityProjectListAdapter);
    }

    public void b(List<ContentTour.ContentRelatedTourListItem> list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "661273709")) {
            ipChange.ipc$dispatch("661273709", new Object[]{this, list, Boolean.valueOf(z)});
        } else if (cb2.d(list)) {
            this.a.setVisibility(8);
        } else {
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                if (z) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = -1;
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
                }
            }
            this.a.setVisibility(0);
            this.b.d(list);
        }
    }
}
