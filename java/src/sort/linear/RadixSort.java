package sort.linear;

import utils.SysLog;
import utils.Tools;

/**
 * 基数排序
 * 
 * https://github.com/wangzheng0822/algo/blob/master/java/13_sorts/RadixSort.java
 * 
 * @author Solomon
 *
 */
public class RadixSort {

	/**
	 * 根据每一位来排序， 可以用桶排序或者计数排序。
	 * 
	 * 如果要排序的数据有k位，那我们就需要k次桶排序或者计数排序。
	 * 当k不大的时候，比如手机号码排序的例子，k最大就是11，所以基数排序的时间复杂度就近似于O(n)。
	 * 
	 * 基数排序对要排序的数据是有要求的，需要可以分割出独立的“位”来比较，而且位之间有递进的关系，如果a数据的高位比b数据大，那剩下的低位就不用比较了。
	 * 
	 * @param a 数组, 假设数组中存储的都是非负整数。
	 */
	public static void radixSort(int... a) {
		final int n = null != a ? a.length : 0;
		if (n <= 1) {
			return;
		}
		// 1. 找出最大值。
		int maxValue = a[0];
		for (int i = 0; i < n; i++) {
			if (a[i] > maxValue) {
				maxValue = a[i];
			}
		}

		// 2. 根据每一位来排序，即按"指数"进行排序
		for (int exp = 1; maxValue / exp > 0; exp *= 10) {
			countingSort(a, exp);
		}
	}

	/**
	 * 根据某一位来排序，即按"指数"进行排序 —— 计数排序
	 * 
	 * @param a
	 * @param exp 指数
	 */
	private static void countingSort(final int[] a, final int exp) {
		SysLog.log("指数  %d :", exp);
		Tools.print(a);
		final int n = null != a ? a.length : 0;
		if (n <= 1) {
			return;
		}
		if (1 > exp) {
			return;
		}

		// 桶的数量
		int bucketCount = 10; // 0~9 十个单位数
		int[] bcArr = new int[bucketCount];
		// 统计，每个桶内对应位上的数据的数量
		for (int i = 0; i < n; i++) {
			int index = (a[i] / exp) % 10;
			bcArr[index]++;
		}

		// 计算出，每个桶的数据在有序数组中对应的存储位置：
		// 对bcArr[]数组顺序求和，那么bcArr[m]里存储值 对应位上小于等于m的元素的个数。
		for (int i = 1; i < bucketCount; i++) {
			bcArr[i] += bcArr[i - 1];
		}

		// 新建数组res，扫描整个数组a，将每个元素放到res的正确位置上
		int[] res = new int[n];
//		for (int i = 0; i < n; i++) {
		for (int i = n - 1; i >= 0; i--) {
			int value = a[i];
			int index = (value / exp) % 10;
			int size = bcArr[index];
			res[size - 1] = value;
			bcArr[index]--;
		}

		// 将数组res 复制到 数组a
		for (int i = 0; i < n; i++) {
			a[i] = res[i];
		}
	}

	public static void main(String[] args) {
		final int[] array = { (int) (Math.random() * 1000), (int) (Math.random() * 100000), (int) (Math.random() * 10),
				(int) (Math.random() * 1000000), (int) (Math.random() * 1000), (int) (Math.random() * 100), 2, 1, 7 };
		Tools.print(array);

		radixSort(array);
		SysLog.log("radixSort: ");
		Tools.print(array);

//		Collections.sort(null);
	}
}
