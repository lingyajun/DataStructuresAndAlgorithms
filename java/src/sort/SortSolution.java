package sort;

import utils.SysLog;
import utils.Tools;

/**
 * 排序算法
 * 
 * @author Solomon
 *
 */
public class SortSolution {

	/**
	 * 冒泡排序, 从小到大
	 * 
	 * @param a
	 */
	public static void bubbleSort(int... a) {
		final int n = null != a ? a.length : 0;
		if (n <= 1) {
			return;
		}

		for (int i = 0; i < n; i++) {
			boolean flag = false; // 提前退出冒泡循环标志位
			final int mm = n - i - 1;
			for (int j = 0; j < mm; j++) {
				if (a[j] > a[j + 1]) {
					// 交换位置
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					flag = true; // 表示有数据交换
				}
			}
			SysLog.log(i + " : ");
			Tools.print(a);
			if (!flag) {
				SysLog.log("bubbleSort 提前退出 : " + i);
				break; // 没有数据交换，退出 循环
			}
		}
	}

	/**
	 * 插入排序
	 * 
	 * 将数组中的数据分为两个区间，已排序区间和未排序区间。初始已排序区间只有一个元素，就是数组的第一个元素。
	 * 
	 * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
	 * 重复这个过程，直到未排序区间中元素为空，算法结束。
	 * 
	 * 找到合适的插入位置。找到插入点之后，我们还需要将插入点之后的元素顺序往后移动一位，这样才能腾出位置给元素 插入。
	 * 
	 * @param a
	 */
	public static void insertionSort(int... a) {
		final int n = null != a ? a.length : 0;
		if (n <= 1) {
			return;
		}

		for (int i = 1; i < n; i++) { // i : [1 ~ n)
			int value = a[i];
			int j = i - 1; // j: [0 ~ i-1]

			for (; j >= 0; j--) { // 查找插入的位置
				if (a[j] > value) {
					a[j + 1] = a[j];// 数据移动
					// 在 [i-1 ~ 0] 中递减查找，只要遇到 比 a[i] 大的，就把查到的值后移一位
				} else {
					break; // 退出 查找循环
					// 在 [i-1 ~ 0] 中递减查找，只要遇到 比 a[i] 小的（相等）就退出查找循环 ，把 a[i]查到 查到的值的后面一位
				}
			}
			SysLog.log(i + " : ");
			Tools.print(a);
			a[j + 1] = value; // 插入数据

//			SysLog.log(i + " : ");
			Tools.print(a);
			SysLog.log("  ");
		}
	}

	/**
	 * 选择排序
	 * 
	 * 分已排序区间和未排序区间
	 * 
	 * 选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
	 */
	public static void selectionSort(int... a) {
		final int n = null != a ? a.length : 0;
		if (n <= 1) {
			return;
		}

		for (int i = 1; i < n; i++) {

			// 在未排序区间查找最小值
			int minIndex = i;
			for (int j = i; j < n; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}

			// 从未排序区间中找到最小的元素,将其放到已排序区间的末尾
			if (a[i - 1] > a[minIndex]) {
				int tmp = a[i - 1];
				a[i - 1] = a[minIndex];
				a[minIndex] = tmp;
			}

			SysLog.log(i + " : ");
			Tools.print(a);
		}
	}

	public static void main(String[] args) {
		final int[] array = { 4, 5, 0, 6, 3, 2, 1, 7 };
		Tools.print(array);

//		bubbleSort(array);
//		insertionSort(array);
		selectionSort(array);
		Tools.print(array);
	}
}
