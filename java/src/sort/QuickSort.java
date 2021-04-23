package sort;

import utils.SysLog;
import utils.Tools;

/**
 * 快速排序
 * 
 * https://github.com/wangzheng0822/algo/blob/master/java/12_sorts/QuickSort.java
 * 
 * @author Solomon
 *
 */
public class QuickSort {

	/**
	 * 快排的思想是这样的: 要排序数组中下标从p到r之间的一组数据，我们选择p到r之间的任意一个数据作为pivot(分区点)；
	 * 
	 * 我们遍历p到r之间的数据，将小于pivot的放到左边，将大于pivot的放到右边，将pivot放到中间；
	 * 
	 * 根据分治、递归的处理思想，我们可以用递归排序下标从p到q-1之间的数据和下标从q+1到r之间的数据，直到区间缩小为1，就说明所有的数据都有序了。
	 * 
	 * @param a
	 */
	public static void quickSort(int... a) {
		final int n = null != a ? a.length : 0;
		if (n <= 1) {
			return;
		}
		quickSortInternally(a, 0, n - 1);
	}

	// 快速排序递归函数，p,r为下标
	public static void quickSortPub(int[] a, int p, int r) {
		final int n = null != a ? a.length : 0;
		if (n <= 1) {
			return;
		}
		if (p < 0 || r >= n || p >= r) {
			return;
		}
		quickSortInternally(a, p, r);
	}

	// 快速排序递归函数，p,r为下标
	private static void quickSortInternally(int[] a, int p, int r) {
		// 终止条件
		if (p >= r) {
			return;
		}

		// 数组p到r之间的数据就被分成了三个部分，前面p到q-1之间都是小于pivot的，中间是pivot，后面的q+1到r之间是大于pivot的。
		int q = partition(a, p, r);// 分区点, q 空出来
		SysLog.log("pivot: a[%d] = %d", q, a[q]);
		Tools.print(a);
		quickSortInternally(a, p, q - 1);
		quickSortInternally(a, q + 1, r);
	}

	/**
	 * 1. 选择p到r之间的任意一个数据作为pivot(分区点)
	 * 
	 * 2. 将小于pivot的放到左边，将大于pivot的放到右边，将pivot放到中间
	 * 
	 * 这里的处理有点类似选择排序。 我们通过游标 i 把 a[p..r-1] 分成两部分: a[p...i-1]的元素都是小于pivot的 , 暂且叫它
	 * 已处理区间 ;
	 * a[i...r-1]是未处理区间，我们每次从未处理区间a[i...r-1]取一个元素a[j]，如果a[j]小于pivot，就将其放到已处理区间的尾部，即a[i];
	 * 
	 * @param a
	 * @param p
	 * @param r
	 * @return
	 */
	private static int partition(int[] a, int p, int r) {
		final int pivot = a[r];
		int i = p;

		for (int j = p; j < r; j++) {
			if (a[j] >= pivot) {
				continue; // i不增加，j继续增加
			}
			// a[j] < pivot
			if (i != j) {
				// i,j 数据交换
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
			i++;
		}

		// int tmp = a[i];
		a[r] = a[i];
		a[i] = pivot;
		return i;
	}

	public static void main(String[] args) {

		final int[] array = { 4, 5, 0, 6, 3, 12, 2, 1, 7 };
		Tools.print(array);

		quickSort(array);
		Tools.print(array);
	}
}
