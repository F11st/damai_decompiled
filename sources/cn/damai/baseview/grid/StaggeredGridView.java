package cn.damai.baseview.grid;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import cn.damai.baseview.grid.ExtendableListView;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Arrays;
import tb.pw2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class StaggeredGridView extends ExtendableListView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final boolean DBG = false;
    private static final int DEFAULT_COLUMNS_LANDSCAPE = 3;
    private static final int DEFAULT_COLUMNS_PORTRAIT = 2;
    private static final String TAG = "StaggeredGridView";
    private int[] mColumnBottoms;
    private int mColumnCount;
    private int mColumnCountLandscape;
    private int mColumnCountPortrait;
    private int[] mColumnLefts;
    private int[] mColumnTops;
    private int mColumnWidth;
    private int mDistanceToTop;
    private int mGridPaddingBottom;
    private int mGridPaddingLeft;
    private int mGridPaddingRight;
    private int mGridPaddingTop;
    private int mItemMargin;
    private boolean mNeedSync;
    private SparseArray<GridItemRecord> mPositionData;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class GridItemRecord implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<GridItemRecord> CREATOR = new a();
        int column;
        double heightRatio;
        boolean isHeaderFooter;

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public static final class a implements Parcelable.Creator<GridItemRecord> {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public GridItemRecord createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "347679743") ? (GridItemRecord) ipChange.ipc$dispatch("347679743", new Object[]{this, parcel}) : new GridItemRecord(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public GridItemRecord[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "990350992") ? (GridItemRecord[]) ipChange.ipc$dispatch("990350992", new Object[]{this, Integer.valueOf(i)}) : new GridItemRecord[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1322289261")) {
                return ((Integer) ipChange.ipc$dispatch("1322289261", new Object[]{this})).intValue();
            }
            return 0;
        }

        public String toString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1991426893")) {
                return (String) ipChange.ipc$dispatch("1991426893", new Object[]{this});
            }
            return "GridItemRecord.ListSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " column:" + this.column + " heightRatio:" + this.heightRatio + " isHeaderFooter:" + this.isHeaderFooter + "}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1660552190")) {
                ipChange.ipc$dispatch("1660552190", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeInt(this.column);
            parcel.writeDouble(this.heightRatio);
            parcel.writeByte(this.isHeaderFooter ? (byte) 1 : (byte) 0);
        }

        GridItemRecord() {
        }

        private GridItemRecord(Parcel parcel) {
            this.column = parcel.readInt();
            this.heightRatio = parcel.readDouble();
            this.isHeaderFooter = parcel.readByte() == 1;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class GridListSavedState extends ExtendableListView.ListSavedState {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<GridListSavedState> CREATOR = new a();
        int columnCount;
        int[] columnTops;
        SparseArray positionData;

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public static final class a implements Parcelable.Creator<GridListSavedState> {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public GridListSavedState createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1698411639") ? (GridListSavedState) ipChange.ipc$dispatch("1698411639", new Object[]{this, parcel}) : new GridListSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public GridListSavedState[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-48176496") ? (GridListSavedState[]) ipChange.ipc$dispatch("-48176496", new Object[]{this, Integer.valueOf(i)}) : new GridListSavedState[i];
            }
        }

        public GridListSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // cn.damai.baseview.grid.ExtendableListView.ListSavedState
        public String toString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-670569591")) {
                return (String) ipChange.ipc$dispatch("-670569591", new Object[]{this});
            }
            return "StaggeredGridView.GridListSavedState{" + Integer.toHexString(System.identityHashCode(this)) + "}";
        }

        @Override // cn.damai.baseview.grid.ExtendableListView.ListSavedState, cn.damai.baseview.grid.ClassLoaderSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "280047674")) {
                ipChange.ipc$dispatch("280047674", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.columnCount);
            parcel.writeIntArray(this.columnTops);
            parcel.writeSparseArray(this.positionData);
        }

        public GridListSavedState(Parcel parcel) {
            super(parcel);
            int readInt = parcel.readInt();
            this.columnCount = readInt;
            int[] iArr = new int[readInt < 0 ? 0 : readInt];
            this.columnTops = iArr;
            parcel.readIntArray(iArr);
            this.positionData = parcel.readSparseArray(GridItemRecord.class.getClassLoader());
        }
    }

    public StaggeredGridView(Context context) {
        this(context, null);
    }

    private void alignTops() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1512937914")) {
            ipChange.ipc$dispatch("-1512937914", new Object[]{this});
        } else if (this.mFirstPosition == getHeaderViewsCount()) {
            int[] highestNonHeaderTops = getHighestNonHeaderTops();
            int i = -1;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < highestNonHeaderTops.length; i3++) {
                if (z && i3 > 0 && highestNonHeaderTops[i3] != i2) {
                    z = false;
                }
                if (highestNonHeaderTops[i3] < i2) {
                    i2 = highestNonHeaderTops[i3];
                    i = i3;
                }
            }
            if (z) {
                return;
            }
            for (int i4 = 0; i4 < highestNonHeaderTops.length; i4++) {
                if (i4 != i) {
                    offsetChildrenTopAndBottom(i2 - highestNonHeaderTops[i4], i4);
                }
            }
            invalidate();
        }
    }

    private int calculateColumnLeft(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1015146640")) {
            return ((Integer) ipChange.ipc$dispatch("1015146640", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int rowPaddingLeft = getRowPaddingLeft();
        int i2 = this.mItemMargin;
        return rowPaddingLeft + i2 + ((i2 + this.mColumnWidth) * i);
    }

    private int calculateColumnWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-337936385")) {
            return ((Integer) ipChange.ipc$dispatch("-337936385", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int rowPaddingLeft = i - (getRowPaddingLeft() + getRowPaddingRight());
        int i2 = this.mItemMargin;
        int i3 = this.mColumnCount;
        return (rowPaddingLeft - (i2 * (i3 + 1))) / i3;
    }

    private int getChildBottomMargin() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1708265419") ? ((Integer) ipChange.ipc$dispatch("-1708265419", new Object[]{this})).intValue() : this.mItemMargin;
    }

    private int getChildColumn(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1709661463")) {
            return ((Integer) ipChange.ipc$dispatch("-1709661463", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
        }
        int positionColumn = getPositionColumn(i);
        int i2 = this.mColumnCount;
        if (positionColumn < 0 || positionColumn >= i2) {
            if (z) {
                return getHighestPositionedBottomColumn();
            }
            return getLowestPositionedTopColumn();
        }
        return positionColumn;
    }

    private int getChildHeight(View view) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-724036687") ? ((Integer) ipChange.ipc$dispatch("-724036687", new Object[]{this, view})).intValue() : view.getMeasuredHeight();
    }

    private int getChildTopMargin(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1576315050")) {
            return ((Integer) ipChange.ipc$dispatch("1576315050", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (i < getHeaderViewsCount() + this.mColumnCount) {
            return this.mItemMargin;
        }
        return 0;
    }

    private int[] getHighestNonHeaderTops() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-945061051")) {
            return (int[]) ipChange.ipc$dispatch("-945061051", new Object[]{this});
        }
        int[] iArr = new int[this.mColumnCount];
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt != null && childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof GridLayoutParams)) {
                    GridLayoutParams gridLayoutParams = (GridLayoutParams) childAt.getLayoutParams();
                    if (gridLayoutParams.viewType != -2) {
                        int top = childAt.getTop();
                        int i2 = gridLayoutParams.column;
                        if (top < iArr[i2]) {
                            iArr[i2] = childAt.getTop();
                        }
                    }
                }
            }
        }
        return iArr;
    }

    private int getHighestPositionedBottom() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1669392941") ? ((Integer) ipChange.ipc$dispatch("-1669392941", new Object[]{this})).intValue() : this.mColumnBottoms[getHighestPositionedBottomColumn()];
    }

    private int getHighestPositionedBottomColumn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1845764515")) {
            return ((Integer) ipChange.ipc$dispatch("-1845764515", new Object[]{this})).intValue();
        }
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        for (int i3 = 0; i3 < this.mColumnCount; i3++) {
            int i4 = this.mColumnBottoms[i3];
            if (i4 < i) {
                i = i4;
                i2 = i3;
            }
        }
        return i2;
    }

    private int getHighestPositionedTop() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1088870717") ? ((Integer) ipChange.ipc$dispatch("1088870717", new Object[]{this})).intValue() : this.mColumnTops[getHighestPositionedTopColumn()];
    }

    private int getHighestPositionedTopColumn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1402595911")) {
            return ((Integer) ipChange.ipc$dispatch("1402595911", new Object[]{this})).intValue();
        }
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        for (int i3 = 0; i3 < this.mColumnCount; i3++) {
            int i4 = this.mColumnTops[i3];
            if (i4 < i) {
                i = i4;
                i2 = i3;
            }
        }
        return i2;
    }

    private int getLowestPositionedBottom() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1971736833") ? ((Integer) ipChange.ipc$dispatch("1971736833", new Object[]{this})).intValue() : this.mColumnBottoms[getLowestPositionedBottomColumn()];
    }

    private int getLowestPositionedBottomColumn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-624328949")) {
            return ((Integer) ipChange.ipc$dispatch("-624328949", new Object[]{this})).intValue();
        }
        int i = Integer.MIN_VALUE;
        int i2 = 0;
        for (int i3 = 0; i3 < this.mColumnCount; i3++) {
            int i4 = this.mColumnBottoms[i3];
            if (i4 > i) {
                i = i4;
                i2 = i3;
            }
        }
        return i2;
    }

    private int getLowestPositionedTop() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "680991951") ? ((Integer) ipChange.ipc$dispatch("680991951", new Object[]{this})).intValue() : this.mColumnTops[getLowestPositionedTopColumn()];
    }

    private int getLowestPositionedTopColumn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "605665369")) {
            return ((Integer) ipChange.ipc$dispatch("605665369", new Object[]{this})).intValue();
        }
        int i = Integer.MIN_VALUE;
        int i2 = 0;
        for (int i3 = 0; i3 < this.mColumnCount; i3++) {
            int i4 = this.mColumnTops[i3];
            if (i4 > i) {
                i = i4;
                i2 = i3;
            }
        }
        return i2;
    }

    private GridItemRecord getOrCreateRecord(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2009958449")) {
            return (GridItemRecord) ipChange.ipc$dispatch("-2009958449", new Object[]{this, Integer.valueOf(i)});
        }
        GridItemRecord gridItemRecord = this.mPositionData.get(i, null);
        if (gridItemRecord == null) {
            GridItemRecord gridItemRecord2 = new GridItemRecord();
            this.mPositionData.append(i, gridItemRecord2);
            return gridItemRecord2;
        }
        return gridItemRecord;
    }

    private int getPositionColumn(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-503801630")) {
            return ((Integer) ipChange.ipc$dispatch("-503801630", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        GridItemRecord gridItemRecord = this.mPositionData.get(i, null);
        if (gridItemRecord != null) {
            return gridItemRecord.column;
        }
        return -1;
    }

    private void initColumnBottoms() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1181477881")) {
            ipChange.ipc$dispatch("-1181477881", new Object[]{this});
        } else {
            Arrays.fill(this.mColumnBottoms, getPaddingTop() + this.mGridPaddingTop);
        }
    }

    private void initColumnLefts() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-456732061")) {
            ipChange.ipc$dispatch("-456732061", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.mColumnCount; i++) {
            this.mColumnLefts[i] = calculateColumnLeft(i);
        }
    }

    private void initColumnTops() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1007543805")) {
            ipChange.ipc$dispatch("1007543805", new Object[]{this});
        } else {
            Arrays.fill(this.mColumnTops, getPaddingTop() + this.mGridPaddingTop);
        }
    }

    private void initColumnTopsAndBottoms() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1636002708")) {
            ipChange.ipc$dispatch("-1636002708", new Object[]{this});
            return;
        }
        initColumnTops();
        initColumnBottoms();
    }

    private boolean isHeaderOrFooter(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1825332891") ? ((Boolean) ipChange.ipc$dispatch("1825332891", new Object[]{this, Integer.valueOf(i)})).booleanValue() : this.mAdapter.getItemViewType(i) == -2;
    }

    private void layoutGridChild(View view, int i, boolean z, int i2, int i3) {
        int i4;
        int childHeight;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "382334950")) {
            ipChange.ipc$dispatch("382334950", new Object[]{this, view, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        int positionColumn = getPositionColumn(i);
        int childTopMargin = getChildTopMargin(i);
        int childBottomMargin = getChildBottomMargin();
        int i5 = childTopMargin + childBottomMargin;
        if (z) {
            childHeight = this.mColumnBottoms[positionColumn];
            i4 = getChildHeight(view) + i5 + childHeight;
        } else {
            i4 = this.mColumnTops[positionColumn];
            childHeight = i4 - (getChildHeight(view) + i5);
        }
        ((GridLayoutParams) view.getLayoutParams()).column = positionColumn;
        updateColumnBottomIfNeeded(positionColumn, i4);
        updateColumnTopIfNeeded(positionColumn, childHeight);
        view.layout(i2, childHeight + childTopMargin, i3, i4 - childBottomMargin);
    }

    private void layoutGridHeaderFooter(View view, int i, boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int childHeight;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-341862598")) {
            ipChange.ipc$dispatch("-341862598", new Object[]{this, view, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
            return;
        }
        if (z) {
            int lowestPositionedBottom = getLowestPositionedBottom();
            childHeight = lowestPositionedBottom;
            i6 = getChildHeight(view) + lowestPositionedBottom;
        } else {
            int highestPositionedTop = getHighestPositionedTop();
            i6 = highestPositionedTop;
            childHeight = highestPositionedTop - getChildHeight(view);
        }
        for (int i7 = 0; i7 < this.mColumnCount; i7++) {
            updateColumnTopIfNeeded(i7, childHeight);
            updateColumnBottomIfNeeded(i7, i6);
        }
        super.onLayoutChild(view, i, z, i2, childHeight, i4, i6);
    }

    private void offsetAllColumnsTopAndBottom(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-282401570")) {
            ipChange.ipc$dispatch("-282401570", new Object[]{this, Integer.valueOf(i)});
        } else if (i != 0) {
            for (int i2 = 0; i2 < this.mColumnCount; i2++) {
                offsetColumnTopAndBottom(i, i2);
            }
        }
    }

    private void offsetColumnTopAndBottom(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-16844469")) {
            ipChange.ipc$dispatch("-16844469", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (i != 0) {
            int[] iArr = this.mColumnTops;
            iArr[i2] = iArr[i2] + i;
            int[] iArr2 = this.mColumnBottoms;
            iArr2[i2] = iArr2[i2] + i;
        }
    }

    private void offsetDistanceToTop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1151659860")) {
            ipChange.ipc$dispatch("-1151659860", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mDistanceToTop += i;
        }
    }

    private void offsetGridChild(View view, int i, boolean z, int i2, int i3) {
        int i4;
        int childHeight;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-805630499")) {
            ipChange.ipc$dispatch("-805630499", new Object[]{this, view, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        int positionColumn = getPositionColumn(i);
        int childTopMargin = getChildTopMargin(i);
        int childBottomMargin = getChildBottomMargin() + childTopMargin;
        if (z) {
            childHeight = this.mColumnBottoms[positionColumn];
            i4 = getChildHeight(view) + childBottomMargin + childHeight;
        } else {
            i4 = this.mColumnTops[positionColumn];
            childHeight = i4 - (getChildHeight(view) + childBottomMargin);
        }
        ((GridLayoutParams) view.getLayoutParams()).column = positionColumn;
        updateColumnBottomIfNeeded(positionColumn, i4);
        updateColumnTopIfNeeded(positionColumn, childHeight);
        super.onOffsetChild(view, i, z, i2, childHeight + childTopMargin);
    }

    private void offsetGridHeaderFooter(View view, int i, boolean z, int i2, int i3) {
        int highestPositionedTop;
        int childHeight;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1491385219")) {
            ipChange.ipc$dispatch("1491385219", new Object[]{this, view, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        if (z) {
            childHeight = getLowestPositionedBottom();
            highestPositionedTop = getChildHeight(view) + childHeight;
        } else {
            highestPositionedTop = getHighestPositionedTop();
            childHeight = highestPositionedTop - getChildHeight(view);
        }
        int i4 = childHeight;
        for (int i5 = 0; i5 < this.mColumnCount; i5++) {
            updateColumnTopIfNeeded(i5, i4);
            updateColumnBottomIfNeeded(i5, highestPositionedTop);
        }
        super.onOffsetChild(view, i, z, i2, i4);
    }

    private void onColumnSync() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1343736175")) {
            ipChange.ipc$dispatch("-1343736175", new Object[]{this});
            return;
        }
        int min = Math.min(this.mSyncPosition, getCount() - 1);
        SparseArray sparseArray = new SparseArray(min);
        for (int i = 0; i < min; i++) {
            GridItemRecord gridItemRecord = this.mPositionData.get(i);
            if (gridItemRecord == null) {
                break;
            }
            pw2.a(TAG, "onColumnSync:" + i + " ratio:" + gridItemRecord.heightRatio);
            sparseArray.append(i, Double.valueOf(gridItemRecord.heightRatio));
        }
        this.mPositionData.clear();
        for (int i2 = 0; i2 < min; i2++) {
            GridItemRecord orCreateRecord = getOrCreateRecord(i2);
            double doubleValue = ((Double) sparseArray.get(i2)).doubleValue();
            int i3 = (int) (this.mColumnWidth * doubleValue);
            orCreateRecord.heightRatio = doubleValue;
            if (isHeaderOrFooter(i2)) {
                int lowestPositionedBottom = getLowestPositionedBottom();
                int i4 = i3 + lowestPositionedBottom;
                for (int i5 = 0; i5 < this.mColumnCount; i5++) {
                    this.mColumnTops[i5] = lowestPositionedBottom;
                    this.mColumnBottoms[i5] = i4;
                }
            } else {
                int highestPositionedBottomColumn = getHighestPositionedBottomColumn();
                int i6 = this.mColumnBottoms[highestPositionedBottomColumn];
                int childTopMargin = i3 + i6 + getChildTopMargin(i2) + getChildBottomMargin();
                this.mColumnTops[highestPositionedBottomColumn] = i6;
                this.mColumnBottoms[highestPositionedBottomColumn] = childTopMargin;
                orCreateRecord.column = highestPositionedBottomColumn;
            }
        }
        int highestPositionedBottomColumn2 = getHighestPositionedBottomColumn();
        setPositionColumn(min, highestPositionedBottomColumn2);
        int i7 = -this.mColumnBottoms[highestPositionedBottomColumn2];
        offsetAllColumnsTopAndBottom(this.mSpecificTop + i7);
        this.mDistanceToTop = i7;
        System.arraycopy(this.mColumnBottoms, 0, this.mColumnTops, 0, this.mColumnCount);
    }

    private void preLayoutChildren() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1541939395")) {
            ipChange.ipc$dispatch("-1541939395", new Object[]{this});
            return;
        }
        if (!this.mNeedSync) {
            Arrays.fill(this.mColumnBottoms, 0);
        } else {
            this.mNeedSync = false;
        }
        System.arraycopy(this.mColumnTops, 0, this.mColumnBottoms, 0, this.mColumnCount);
    }

    private void requestLayoutChildren() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1063859503")) {
            ipChange.ipc$dispatch("-1063859503", new Object[]{this});
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                childAt.requestLayout();
            }
        }
    }

    private void setPositionColumn(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1419790488")) {
            ipChange.ipc$dispatch("-1419790488", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            getOrCreateRecord(i).column = i2;
        }
    }

    private void setPositionHeightRatio(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-275676888")) {
            ipChange.ipc$dispatch("-275676888", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            getOrCreateRecord(i).heightRatio = i2 / this.mColumnWidth;
        }
    }

    private void setPositionIsHeaderFooter(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1837737097")) {
            ipChange.ipc$dispatch("-1837737097", new Object[]{this, Integer.valueOf(i)});
        } else {
            getOrCreateRecord(i).isHeaderFooter = true;
        }
    }

    private void updateColumnBottomIfNeeded(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-249959003")) {
            ipChange.ipc$dispatch("-249959003", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int[] iArr = this.mColumnBottoms;
        if (i2 > iArr[i]) {
            iArr[i] = i2;
        }
    }

    private void updateColumnTopIfNeeded(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1170905857")) {
            ipChange.ipc$dispatch("1170905857", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int[] iArr = this.mColumnTops;
        if (i2 < iArr[i]) {
            iArr[i] = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public void adjustViewsAfterFillGap(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-4641023")) {
            ipChange.ipc$dispatch("-4641023", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.adjustViewsAfterFillGap(z);
        if (z) {
            return;
        }
        alignTops();
    }

    @Override // cn.damai.baseview.grid.ExtendableListView
    protected ExtendableListView.LayoutParams generateChildLayoutParams(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-554249997")) {
            return (ExtendableListView.LayoutParams) ipChange.ipc$dispatch("-554249997", new Object[]{this, view});
        }
        GridLayoutParams gridLayoutParams = null;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams instanceof GridLayoutParams) {
                gridLayoutParams = (GridLayoutParams) layoutParams;
            } else {
                gridLayoutParams = new GridLayoutParams(layoutParams);
            }
        }
        return gridLayoutParams == null ? new GridLayoutParams(this.mColumnWidth, -2) : gridLayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public int getChildBottom(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "506320870")) {
            return ((Integer) ipChange.ipc$dispatch("506320870", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (isHeaderOrFooter(i)) {
            return super.getChildBottom(i);
        }
        int positionColumn = getPositionColumn(i);
        if (positionColumn == -1) {
            return getLowestPositionedTop();
        }
        return this.mColumnTops[positionColumn];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public int getChildLeft(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1987513922")) {
            return ((Integer) ipChange.ipc$dispatch("1987513922", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (isHeaderOrFooter(i)) {
            return super.getChildLeft(i);
        }
        return this.mColumnLefts[getPositionColumn(i)];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public int getChildTop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24119780")) {
            return ((Integer) ipChange.ipc$dispatch("-24119780", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (isHeaderOrFooter(i)) {
            return super.getChildTop(i);
        }
        int positionColumn = getPositionColumn(i);
        if (positionColumn == -1) {
            return getHighestPositionedBottom();
        }
        return this.mColumnBottoms[positionColumn];
    }

    public int getColumnWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1377605306") ? ((Integer) ipChange.ipc$dispatch("1377605306", new Object[]{this})).intValue() : this.mColumnWidth;
    }

    public int getDistanceToTop() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1672343621") ? ((Integer) ipChange.ipc$dispatch("1672343621", new Object[]{this})).intValue() : this.mDistanceToTop;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public int getFirstChildTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1945024065")) {
            return ((Integer) ipChange.ipc$dispatch("1945024065", new Object[]{this})).intValue();
        }
        if (isHeaderOrFooter(this.mFirstPosition)) {
            return super.getFirstChildTop();
        }
        return getLowestPositionedTop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public int getHighestChildTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1294477133")) {
            return ((Integer) ipChange.ipc$dispatch("1294477133", new Object[]{this})).intValue();
        }
        if (isHeaderOrFooter(this.mFirstPosition)) {
            return super.getHighestChildTop();
        }
        return getHighestPositionedTop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public int getLastChildBottom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1027005497")) {
            return ((Integer) ipChange.ipc$dispatch("1027005497", new Object[]{this})).intValue();
        }
        if (isHeaderOrFooter(this.mFirstPosition + (getChildCount() - 1))) {
            return super.getLastChildBottom();
        }
        return getHighestPositionedBottom();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public int getLowestChildBottom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-741716523")) {
            return ((Integer) ipChange.ipc$dispatch("-741716523", new Object[]{this})).intValue();
        }
        if (isHeaderOrFooter(this.mFirstPosition + (getChildCount() - 1))) {
            return super.getLowestChildBottom();
        }
        return getLowestPositionedBottom();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public int getNextChildDownsTop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1276946292")) {
            return ((Integer) ipChange.ipc$dispatch("-1276946292", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (isHeaderOrFooter(i)) {
            return super.getNextChildDownsTop(i);
        }
        return getHighestPositionedBottom();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public int getNextChildUpsBottom(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206998045")) {
            return ((Integer) ipChange.ipc$dispatch("206998045", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (isHeaderOrFooter(i)) {
            return super.getNextChildUpsBottom(i);
        }
        return getLowestPositionedTop();
    }

    public int getRowPaddingBottom() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-683702748") ? ((Integer) ipChange.ipc$dispatch("-683702748", new Object[]{this})).intValue() : getListPaddingBottom() + this.mGridPaddingBottom;
    }

    public int getRowPaddingLeft() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1722161016") ? ((Integer) ipChange.ipc$dispatch("-1722161016", new Object[]{this})).intValue() : getListPaddingLeft() + this.mGridPaddingLeft;
    }

    public int getRowPaddingRight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-705599963") ? ((Integer) ipChange.ipc$dispatch("-705599963", new Object[]{this})).intValue() : getListPaddingRight() + this.mGridPaddingRight;
    }

    public int getRowPaddingTop() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "737129100") ? ((Integer) ipChange.ipc$dispatch("737129100", new Object[]{this})).intValue() : getListPaddingTop() + this.mGridPaddingTop;
    }

    @Override // cn.damai.baseview.grid.ExtendableListView
    protected boolean hasSpaceUp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-528377282")) {
            return ((Boolean) ipChange.ipc$dispatch("-528377282", new Object[]{this})).booleanValue();
        }
        return getLowestPositionedTop() > (this.mClipToPadding ? getRowPaddingTop() : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView, android.widget.AbsListView
    public void layoutChildren() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1681264648")) {
            ipChange.ipc$dispatch("-1681264648", new Object[]{this});
            return;
        }
        preLayoutChildren();
        super.layoutChildren();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public void offsetChildrenTopAndBottom(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1968594015")) {
            ipChange.ipc$dispatch("-1968594015", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.offsetChildrenTopAndBottom(i);
        offsetAllColumnsTopAndBottom(i);
        offsetDistanceToTop(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public void onChildCreated(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-207708921")) {
            ipChange.ipc$dispatch("-207708921", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        super.onChildCreated(i, z);
        if (!isHeaderOrFooter(i)) {
            setPositionColumn(i, getChildColumn(i, z));
        } else {
            setPositionIsHeaderFooter(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public void onChildrenDetached(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "811233649")) {
            ipChange.ipc$dispatch("811233649", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onChildrenDetached(i, i2);
        Arrays.fill(this.mColumnTops, Integer.MAX_VALUE);
        Arrays.fill(this.mColumnBottoms, 0);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null) {
                ExtendableListView.LayoutParams layoutParams = (ExtendableListView.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.viewType != -2 && (layoutParams instanceof GridLayoutParams)) {
                    GridLayoutParams gridLayoutParams = (GridLayoutParams) layoutParams;
                    int i4 = gridLayoutParams.column;
                    int i5 = gridLayoutParams.position;
                    int top = childAt.getTop();
                    int[] iArr = this.mColumnTops;
                    if (top < iArr[i4]) {
                        iArr[i4] = top - getChildTopMargin(i5);
                    }
                    int bottom = childAt.getBottom();
                    int[] iArr2 = this.mColumnBottoms;
                    if (bottom > iArr2[i4]) {
                        iArr2[i4] = bottom + getChildBottomMargin();
                    }
                } else {
                    int top2 = childAt.getTop();
                    int bottom2 = childAt.getBottom();
                    for (int i6 = 0; i6 < this.mColumnCount; i6++) {
                        int[] iArr3 = this.mColumnTops;
                        if (top2 < iArr3[i6]) {
                            iArr3[i6] = top2;
                        }
                        int[] iArr4 = this.mColumnBottoms;
                        if (bottom2 > iArr4[i6]) {
                            iArr4[i6] = bottom2;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public void onLayoutChild(View view, int i, boolean z, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1441295219")) {
            ipChange.ipc$dispatch("-1441295219", new Object[]{this, view, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        } else if (isHeaderOrFooter(i)) {
            layoutGridHeaderFooter(view, i, z, i2, i3, i4, i5);
        } else {
            layoutGridChild(view, i, z, i2, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24231286")) {
            ipChange.ipc$dispatch("-24231286", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        if (this.mColumnCount <= 0) {
            this.mColumnCount = getMeasuredWidth() > getMeasuredHeight() ? this.mColumnCountLandscape : this.mColumnCountPortrait;
        }
        this.mColumnWidth = calculateColumnWidth(getMeasuredWidth());
        int[] iArr = this.mColumnTops;
        if (iArr == null || iArr.length != this.mColumnCount) {
            this.mColumnTops = new int[this.mColumnCount];
            initColumnTops();
        }
        int[] iArr2 = this.mColumnBottoms;
        if (iArr2 == null || iArr2.length != this.mColumnCount) {
            this.mColumnBottoms = new int[this.mColumnCount];
            initColumnBottoms();
        }
        int[] iArr3 = this.mColumnLefts;
        if (iArr3 == null || iArr3.length != this.mColumnCount) {
            this.mColumnLefts = new int[this.mColumnCount];
            initColumnLefts();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public void onMeasureChild(View view, ExtendableListView.LayoutParams layoutParams) {
        int makeMeasureSpec;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1788643851")) {
            ipChange.ipc$dispatch("1788643851", new Object[]{this, view, layoutParams});
            return;
        }
        int i = layoutParams.viewType;
        int i2 = layoutParams.position;
        if (i != -2 && i != -1) {
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.mColumnWidth, 1073741824);
            int i3 = ((AbsListView.LayoutParams) layoutParams).height;
            if (i3 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
            }
            view.measure(makeMeasureSpec2, makeMeasureSpec);
        } else {
            super.onMeasureChild(view, layoutParams);
        }
        setPositionHeightRatio(i2, getChildHeight(view));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public void onOffsetChild(View view, int i, boolean z, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "575866084")) {
            ipChange.ipc$dispatch("575866084", new Object[]{this, view, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (isHeaderOrFooter(i)) {
            offsetGridHeaderFooter(view, i, z, i2, i3);
        } else {
            offsetGridChild(view, i, z, i2, i3);
        }
    }

    @Override // cn.damai.baseview.grid.ExtendableListView, android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1640880159")) {
            ipChange.ipc$dispatch("1640880159", new Object[]{this, parcelable});
            return;
        }
        GridListSavedState gridListSavedState = (GridListSavedState) parcelable;
        int i = gridListSavedState.columnCount;
        this.mColumnCount = i;
        this.mColumnTops = gridListSavedState.columnTops;
        this.mColumnBottoms = new int[i];
        this.mPositionData = gridListSavedState.positionData;
        this.mNeedSync = true;
        super.onRestoreInstanceState(gridListSavedState);
    }

    @Override // cn.damai.baseview.grid.ExtendableListView, android.widget.AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1990678932")) {
            return (Parcelable) ipChange.ipc$dispatch("-1990678932", new Object[]{this});
        }
        ExtendableListView.ListSavedState listSavedState = (ExtendableListView.ListSavedState) super.onSaveInstanceState();
        GridListSavedState gridListSavedState = new GridListSavedState(listSavedState.getSuperState());
        gridListSavedState.selectedId = listSavedState.selectedId;
        gridListSavedState.firstId = listSavedState.firstId;
        gridListSavedState.viewTop = listSavedState.viewTop;
        gridListSavedState.position = listSavedState.position;
        gridListSavedState.height = listSavedState.height;
        if (((getChildCount() <= 0 || getCount() <= 0) ? false : false) && this.mFirstPosition > 0) {
            gridListSavedState.columnCount = this.mColumnCount;
            gridListSavedState.columnTops = this.mColumnTops;
            gridListSavedState.positionData = this.mPositionData;
        } else {
            int i = this.mColumnCount;
            int i2 = i >= 0 ? i : 0;
            gridListSavedState.columnCount = i2;
            gridListSavedState.columnTops = new int[i2];
            gridListSavedState.positionData = new SparseArray();
        }
        return gridListSavedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "678155061")) {
            ipChange.ipc$dispatch("678155061", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        onSizeChanged(i, i2);
    }

    @Override // cn.damai.baseview.grid.ExtendableListView
    public void resetToTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-412507850")) {
            ipChange.ipc$dispatch("-412507850", new Object[]{this});
            return;
        }
        int i = this.mColumnCount;
        if (i > 0) {
            if (this.mColumnTops == null) {
                this.mColumnTops = new int[i];
            }
            if (this.mColumnBottoms == null) {
                this.mColumnBottoms = new int[i];
            }
            initColumnTopsAndBottoms();
            this.mPositionData.clear();
            this.mNeedSync = false;
            this.mDistanceToTop = 0;
            setSelection(0);
        }
    }

    public void setColumnCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2079434073")) {
            ipChange.ipc$dispatch("2079434073", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mColumnCountPortrait = i;
        this.mColumnCountLandscape = i;
        onSizeChanged(getWidth(), getHeight());
        requestLayoutChildren();
    }

    public void setColumnCountLandscape(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-30600066")) {
            ipChange.ipc$dispatch("-30600066", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mColumnCountLandscape = i;
        onSizeChanged(getWidth(), getHeight());
        requestLayoutChildren();
    }

    public void setColumnCountPortrait(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1512596")) {
            ipChange.ipc$dispatch("1512596", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mColumnCountPortrait = i;
        onSizeChanged(getWidth(), getHeight());
        requestLayoutChildren();
    }

    public void setGridPadding(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "314518488")) {
            ipChange.ipc$dispatch("314518488", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        this.mGridPaddingLeft = i;
        this.mGridPaddingTop = i2;
        this.mGridPaddingRight = i3;
        this.mGridPaddingBottom = i4;
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class GridLayoutParams extends ExtendableListView.LayoutParams {
        private static transient /* synthetic */ IpChange $ipChange;
        int column;

        public GridLayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            enforceStaggeredLayout();
        }

        private void enforceStaggeredLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2098568215")) {
                ipChange.ipc$dispatch("2098568215", new Object[]{this});
                return;
            }
            if (((AbsListView.LayoutParams) this).width != -1) {
                ((AbsListView.LayoutParams) this).width = -1;
            }
            if (((AbsListView.LayoutParams) this).height == -1) {
                ((AbsListView.LayoutParams) this).height = -2;
            }
        }

        public GridLayoutParams(int i, int i2) {
            super(i, i2);
            enforceStaggeredLayout();
        }

        public GridLayoutParams(int i, int i2, int i3) {
            super(i, i2);
            enforceStaggeredLayout();
        }

        public GridLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            enforceStaggeredLayout();
        }
    }

    public StaggeredGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StaggeredGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mColumnCountPortrait = 2;
        this.mColumnCountLandscape = 3;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.StaggeredGridView, i, 0);
            int integer = obtainStyledAttributes.getInteger(R$styleable.StaggeredGridView_column_count, 0);
            this.mColumnCount = integer;
            if (integer > 0) {
                this.mColumnCountPortrait = integer;
                this.mColumnCountLandscape = integer;
            } else {
                this.mColumnCountPortrait = obtainStyledAttributes.getInteger(R$styleable.StaggeredGridView_column_count_portrait, 2);
                this.mColumnCountLandscape = obtainStyledAttributes.getInteger(R$styleable.StaggeredGridView_column_count_landscape, 3);
            }
            this.mItemMargin = obtainStyledAttributes.getDimensionPixelSize(R$styleable.StaggeredGridView_item_margin, 0);
            this.mGridPaddingLeft = obtainStyledAttributes.getDimensionPixelSize(R$styleable.StaggeredGridView_grid_paddingLeft, 0);
            this.mGridPaddingRight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.StaggeredGridView_grid_paddingRight, 0);
            this.mGridPaddingTop = obtainStyledAttributes.getDimensionPixelSize(R$styleable.StaggeredGridView_grid_paddingTop, 0);
            this.mGridPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(R$styleable.StaggeredGridView_grid_paddingBottom, 0);
            obtainStyledAttributes.recycle();
        }
        this.mColumnCount = 0;
        this.mColumnTops = new int[0];
        this.mColumnBottoms = new int[0];
        this.mColumnLefts = new int[0];
        this.mPositionData = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.grid.ExtendableListView
    public void onSizeChanged(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "626402325")) {
            ipChange.ipc$dispatch("626402325", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onSizeChanged(i, i2);
        int i3 = i > i2 ? this.mColumnCountLandscape : this.mColumnCountPortrait;
        if (this.mColumnCount != i3) {
            this.mColumnCount = i3;
            this.mColumnWidth = calculateColumnWidth(i);
            int i4 = this.mColumnCount;
            this.mColumnTops = new int[i4];
            this.mColumnBottoms = new int[i4];
            this.mColumnLefts = new int[i4];
            this.mDistanceToTop = 0;
            initColumnTopsAndBottoms();
            initColumnLefts();
            if (getCount() > 0 && this.mPositionData.size() > 0) {
                onColumnSync();
            }
            requestLayout();
        }
    }

    protected void offsetChildrenTopAndBottom(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-896842878")) {
            ipChange.ipc$dispatch("-896842878", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof GridLayoutParams) && ((GridLayoutParams) childAt.getLayoutParams()).column == i2) {
                childAt.offsetTopAndBottom(i);
            }
        }
        offsetColumnTopAndBottom(i, i2);
    }
}
