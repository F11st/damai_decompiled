package tb;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class n00 implements View.OnTouchListener {
    private DXRecyclerLayout a;
    GestureDetector b = new GestureDetector(DinamicXEngine.i(), new a());

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (n00.this.a != null) {
                n00.this.a.postEvent(new hy(-6544685697300501093L));
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (n00.this.a != null) {
                n00.this.a.postEvent(new hy(18903999933159L));
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    public n00(DXRecyclerLayout dXRecyclerLayout) {
        this.a = dXRecyclerLayout;
    }

    public void b(DXRecyclerLayout dXRecyclerLayout) {
        this.a = dXRecyclerLayout;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.b.onTouchEvent(motionEvent);
        return false;
    }
}
