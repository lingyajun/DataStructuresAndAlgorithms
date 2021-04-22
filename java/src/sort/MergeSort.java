package sort;

import utils.SysLog;
import utils.Tools;

/**
 * 归并排序算法
 * 
 * https://github.com/wangzheng0822/algo/blob/master/java/12_sorts/MergeSort.java
 * 
 * @author Solomon
 *
 */
public class MergeSort {

	/**
	 * 如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序， 再将排好序的两部分合并在一起，这样整个数组就都有序了。
	 * 
	 * @param a
	 */
	public static void mergeSort(int... a) {
		final int n = null != a ? a.length : 0;
		if (n <= 1) {
			return;
		}

		mergeSortInternally(a, 0, n - 1);
	}

	// 1. 先把数组从中间分成前后两部分，
	// 2. 然后对前后两部分分别排序
	// 3. 再将排好序的两部分合并在一起
	// (p 是起点 ； r 是终点)
	private static void mergeSortInternally(int[] a, int p, int r) {

		// 终止条件
		if (p >= r) {
			SysLog.log("终止 index: [%d , %d]", p, r);
			return;
		}

		// 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
		final int q = (r - p) / 2 + p;
		// 分治+递归
		mergeSortInternally(a, p, q);
		final int q1 = q + 1;
		mergeSortInternally(a, q1, r);

		SysLog.log("两部分 index: [%d, %d] , [%d, %d]", p, q, q1, r);
		Tools.print(p, q, a);
		Tools.print(q1, r, a);
		// TODO 排序，合并，将排好序的两部分合并在一起，将a[p...q]和a[q+1...r]合并
//		merge(a, p, q, r);
		mergeBySentry(a, p, q, r);
	}

	/**
	 * 排序, 将a[p...q]和a[q+1...r]合并
	 * 
	 * 合并的时候就排序
	 * 
	 * @param a
	 * @param p
	 * @param q
	 * @param r
	 */
	private static void merge(int[] a, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int k = 0;

		final int size = r - p + 1;
		final int[] tmp = new int[size];// 申请一个大小跟a[p...r]一样的临时数组

		// i 扫描 a[p...q] ; j 扫描 a[q+1...r]
		while (i <= q && j <= r) {
			if (a[i] <= a[j]) {
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
			}
		}

		// 判断哪个子数组中有剩余的数据
		int start = i, end = q;
		if (j <= r) {
			// a[q+1...r] 数组中有剩余的数据
			start = j;
			end = r;
		}

		// 将剩余的数据拷贝到临时数组tmp
		while (start <= end) {
			tmp[k++] = a[start++];
		}

		// 将tmp中的数组拷贝回a[p...r]
		for (int l = 0; l < size; l++) {
			a[p + l] = tmp[l];
		}
		SysLog.log("merge, tmp[] : ");
		Tools.print(tmp);
	}

	/**
	 * 排序(哨兵), 将a[p...q]和a[q+1...r]合并
	 */
	private static void mergeBySentry(int[] a, int p, int q, int r) {
		final int leftSize = q - p + 2;
		final int rightSize = r - q + 1; // 多一个位置留给“哨兵”
		final int[] leftArr = new int[leftSize];
		final int[] rightArr = new int[rightSize]; // 初始化两个数组

		final int leftBound = leftSize - 1;
		for (int i = 0; i < leftBound; i++) {
			leftArr[i] = a[i + p];// 将a[p...q] 复制到leftArr
		}
		leftArr[leftBound] = Integer.MAX_VALUE; // “哨兵”
		SysLog.log("mergeBySentry, leftArr[] : ");
		Tools.print(leftArr);

		final int rightBound = rightSize - 1;
		for (int i = 0; i < rightBound; i++) {
			rightArr[i] = a[q + 1 + i];
		}
		rightArr[rightBound] = Integer.MAX_VALUE; // “哨兵”
		SysLog.log("mergeBySentry, rightArr[] : ");
		Tools.print(rightArr);

		int i = 0;
		int j = 0;
		int k = p;
		while (k <= r) { // k <= r ： 避免了数组越界。
			// “哨兵” —— 数组最后一个，并且是 Integer.MAX_VALUE
			if (leftArr[i] < rightArr[j]) {
				a[k++] = leftArr[i++];
				// a[k] = leftArr[i];
				// k++;
				// i++;
			} else {
				a[k++] = rightArr[j++];
			}
		}
	}

	public static void main(String[] args) {

		final int[] array = { 4, 5, 0, 6, 3, 2, 1, 7 };
		Tools.print(array);

		mergeSort(array);
		Tools.print(array);
	}
}
