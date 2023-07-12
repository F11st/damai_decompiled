package com.alient.onearch.adapter.component.horizontal;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class RecyclerViewHorizontalTouchManager {
    private static final String TAG = "RecyclerViewHorizontalTouchManager";
    private boolean mForceNoInterceptTouchEvent;
    private boolean mIsHorizontalDrag;
    private final RecyclerView.OnItemTouchListener mOnItemTouchListener;
    private RecyclerView mRecyclerView;
    private int mTouchSlop;
    private float startX;
    private float startY;

    private RecyclerViewHorizontalTouchManager() {
        this.startY = 0.0f;
        this.startX = 0.0f;
        this.mTouchSlop = 0;
        this.mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.alient.onearch.adapter.component.horizontal.RecyclerViewHorizontalTouchManager.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (AppInfoProviderProxy.isDebuggable()) {
                    LogUtil.d(RecyclerViewHorizontalTouchManager.TAG, "touch onInterceptTouchEvent action:" + action + " mIsHorizontalDrag:" + RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag + " mTouchSlop:" + RecyclerViewHorizontalTouchManager.this.mTouchSlop);
                }
                if (action == 0) {
                    RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag = false;
                    RecyclerViewHorizontalTouchManager.this.startY = motionEvent.getY();
                    RecyclerViewHorizontalTouchManager.this.startX = motionEvent.getX();
                } else if (action != 1) {
                    if ((action != 2 && action != 3) || RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag || RecyclerViewHorizontalTouchManager.this.mForceNoInterceptTouchEvent) {
                        return false;
                    }
                    float y = motionEvent.getY();
                    float x = motionEvent.getX();
                    float abs = Math.abs(x - RecyclerViewHorizontalTouchManager.this.startX);
                    float abs2 = Math.abs(y - RecyclerViewHorizontalTouchManager.this.startY);
                    if (AppInfoProviderProxy.isDebuggable()) {
                        LogUtil.d(RecyclerViewHorizontalTouchManager.TAG, "touch onInterceptTouchEvent action:" + action + " mIsHorizontalDrag:" + RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag + " mTouchSlop:" + RecyclerViewHorizontalTouchManager.this.mTouchSlop + " startX：" + RecyclerViewHorizontalTouchManager.this.startX + " startY:" + RecyclerViewHorizontalTouchManager.this.startY + " endX：" + x + " endY:" + y + " distanceX:" + abs + " distanceY:" + abs2);
                    }
                    if (abs >= RecyclerViewHorizontalTouchManager.this.mTouchSlop || abs2 >= RecyclerViewHorizontalTouchManager.this.mTouchSlop) {
                        if (abs > RecyclerViewHorizontalTouchManager.this.mTouchSlop && abs > abs2) {
                            if (AppInfoProviderProxy.isDebuggable()) {
                                LogUtil.d(RecyclerViewHorizontalTouchManager.TAG, "touch onInterceptTouchEvent action:" + action + " mIsHorizontalDrag:" + RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag + " mTouchSlop:" + RecyclerViewHorizontalTouchManager.this.mTouchSlop + " call v.requestDisallowInterceptTouchEvent(true)");
                            }
                            RecyclerViewHorizontalTouchManager recyclerViewHorizontalTouchManager = RecyclerViewHorizontalTouchManager.this;
                            RecyclerView listRecyclerView = recyclerViewHorizontalTouchManager.getListRecyclerView(recyclerViewHorizontalTouchManager.mRecyclerView.getParent());
                            if (listRecyclerView != null) {
                                RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag = true;
                                listRecyclerView.requestDisallowInterceptTouchEvent(true);
                            }
                            return false;
                        }
                        if (AppInfoProviderProxy.isDebuggable()) {
                            LogUtil.d(RecyclerViewHorizontalTouchManager.TAG, "touch onInterceptTouchEvent action:" + action + " mIsHorizontalDrag:" + RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag + " mTouchSlop:" + RecyclerViewHorizontalTouchManager.this.mTouchSlop + " call v.requestDisallowInterceptTouchEvent(false)");
                        }
                        RecyclerViewHorizontalTouchManager recyclerViewHorizontalTouchManager2 = RecyclerViewHorizontalTouchManager.this;
                        RecyclerView listRecyclerView2 = recyclerViewHorizontalTouchManager2.getListRecyclerView(recyclerViewHorizontalTouchManager2.mRecyclerView.getParent());
                        if (listRecyclerView2 != null) {
                            listRecyclerView2.requestDisallowInterceptTouchEvent(false);
                        }
                    } else {
                        if (AppInfoProviderProxy.isDebuggable()) {
                            LogUtil.d(RecyclerViewHorizontalTouchManager.TAG, "touch onInterceptTouchEvent action:" + action + " mIsHorizontalDrag:" + RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag + " mTouchSlop:" + RecyclerViewHorizontalTouchManager.this.mTouchSlop + " call v.requestDisallowInterceptTouchEvent(true)");
                        }
                        RecyclerViewHorizontalTouchManager recyclerViewHorizontalTouchManager3 = RecyclerViewHorizontalTouchManager.this;
                        RecyclerView listRecyclerView3 = recyclerViewHorizontalTouchManager3.getListRecyclerView(recyclerViewHorizontalTouchManager3.mRecyclerView.getParent());
                        if (listRecyclerView3 != null) {
                            listRecyclerView3.requestDisallowInterceptTouchEvent(true);
                        }
                        return false;
                    }
                } else {
                    RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag = false;
                }
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onRequestDisallowInterceptTouchEvent(boolean z) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RecyclerView getListRecyclerView(ViewParent viewParent) {
        if (viewParent == null) {
            return null;
        }
        if (viewParent instanceof RecyclerView) {
            return (RecyclerView) viewParent;
        }
        return getListRecyclerView(viewParent.getParent());
    }

    public void delegateHorizontalTouch() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            if (this.mTouchSlop == 0) {
                this.mTouchSlop = ViewConfiguration.get(recyclerView.getContext()).getScaledTouchSlop();
            }
            this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
            this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        }
    }

    public void forceNoInterceptTouchEvent(boolean z) {
        this.mForceNoInterceptTouchEvent = z;
    }

    public RecyclerViewHorizontalTouchManager(RecyclerView recyclerView) {
        this.startY = 0.0f;
        this.startX = 0.0f;
        this.mTouchSlop = 0;
        this.mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.alient.onearch.adapter.component.horizontal.RecyclerViewHorizontalTouchManager.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(RecyclerView recyclerView2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (AppInfoProviderProxy.isDebuggable()) {
                    LogUtil.d(RecyclerViewHorizontalTouchManager.TAG, "touch onInterceptTouchEvent action:" + action + " mIsHorizontalDrag:" + RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag + " mTouchSlop:" + RecyclerViewHorizontalTouchManager.this.mTouchSlop);
                }
                if (action == 0) {
                    RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag = false;
                    RecyclerViewHorizontalTouchManager.this.startY = motionEvent.getY();
                    RecyclerViewHorizontalTouchManager.this.startX = motionEvent.getX();
                } else if (action != 1) {
                    if ((action != 2 && action != 3) || RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag || RecyclerViewHorizontalTouchManager.this.mForceNoInterceptTouchEvent) {
                        return false;
                    }
                    float y = motionEvent.getY();
                    float x = motionEvent.getX();
                    float abs = Math.abs(x - RecyclerViewHorizontalTouchManager.this.startX);
                    float abs2 = Math.abs(y - RecyclerViewHorizontalTouchManager.this.startY);
                    if (AppInfoProviderProxy.isDebuggable()) {
                        LogUtil.d(RecyclerViewHorizontalTouchManager.TAG, "touch onInterceptTouchEvent action:" + action + " mIsHorizontalDrag:" + RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag + " mTouchSlop:" + RecyclerViewHorizontalTouchManager.this.mTouchSlop + " startX：" + RecyclerViewHorizontalTouchManager.this.startX + " startY:" + RecyclerViewHorizontalTouchManager.this.startY + " endX：" + x + " endY:" + y + " distanceX:" + abs + " distanceY:" + abs2);
                    }
                    if (abs >= RecyclerViewHorizontalTouchManager.this.mTouchSlop || abs2 >= RecyclerViewHorizontalTouchManager.this.mTouchSlop) {
                        if (abs > RecyclerViewHorizontalTouchManager.this.mTouchSlop && abs > abs2) {
                            if (AppInfoProviderProxy.isDebuggable()) {
                                LogUtil.d(RecyclerViewHorizontalTouchManager.TAG, "touch onInterceptTouchEvent action:" + action + " mIsHorizontalDrag:" + RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag + " mTouchSlop:" + RecyclerViewHorizontalTouchManager.this.mTouchSlop + " call v.requestDisallowInterceptTouchEvent(true)");
                            }
                            RecyclerViewHorizontalTouchManager recyclerViewHorizontalTouchManager = RecyclerViewHorizontalTouchManager.this;
                            RecyclerView listRecyclerView = recyclerViewHorizontalTouchManager.getListRecyclerView(recyclerViewHorizontalTouchManager.mRecyclerView.getParent());
                            if (listRecyclerView != null) {
                                RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag = true;
                                listRecyclerView.requestDisallowInterceptTouchEvent(true);
                            }
                            return false;
                        }
                        if (AppInfoProviderProxy.isDebuggable()) {
                            LogUtil.d(RecyclerViewHorizontalTouchManager.TAG, "touch onInterceptTouchEvent action:" + action + " mIsHorizontalDrag:" + RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag + " mTouchSlop:" + RecyclerViewHorizontalTouchManager.this.mTouchSlop + " call v.requestDisallowInterceptTouchEvent(false)");
                        }
                        RecyclerViewHorizontalTouchManager recyclerViewHorizontalTouchManager2 = RecyclerViewHorizontalTouchManager.this;
                        RecyclerView listRecyclerView2 = recyclerViewHorizontalTouchManager2.getListRecyclerView(recyclerViewHorizontalTouchManager2.mRecyclerView.getParent());
                        if (listRecyclerView2 != null) {
                            listRecyclerView2.requestDisallowInterceptTouchEvent(false);
                        }
                    } else {
                        if (AppInfoProviderProxy.isDebuggable()) {
                            LogUtil.d(RecyclerViewHorizontalTouchManager.TAG, "touch onInterceptTouchEvent action:" + action + " mIsHorizontalDrag:" + RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag + " mTouchSlop:" + RecyclerViewHorizontalTouchManager.this.mTouchSlop + " call v.requestDisallowInterceptTouchEvent(true)");
                        }
                        RecyclerViewHorizontalTouchManager recyclerViewHorizontalTouchManager3 = RecyclerViewHorizontalTouchManager.this;
                        RecyclerView listRecyclerView3 = recyclerViewHorizontalTouchManager3.getListRecyclerView(recyclerViewHorizontalTouchManager3.mRecyclerView.getParent());
                        if (listRecyclerView3 != null) {
                            listRecyclerView3.requestDisallowInterceptTouchEvent(true);
                        }
                        return false;
                    }
                } else {
                    RecyclerViewHorizontalTouchManager.this.mIsHorizontalDrag = false;
                }
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onRequestDisallowInterceptTouchEvent(boolean z) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onTouchEvent(RecyclerView recyclerView2, MotionEvent motionEvent) {
            }
        };
        this.mRecyclerView = recyclerView;
        if (recyclerView == null || recyclerView.getContext() == null) {
            return;
        }
        this.mTouchSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
    }
}
