package sort.linear;

import utils.SysLog;
import utils.Tools;

/**
 * 计数排序
 * 
 * https://github.com/wangzheng0822/algo/blob/master/java/13_sorts/CountingSort.java
 * 
 * @author Solomon
 *
 */
public class CountingSort {

	/**
	 * 计数排序其实是桶排序的一种特殊情况。
	 * 当要排序的n个数据，所处的范围并不大的时候，比如最大值是k，我们就可以把数据划分成k个桶。每个桶内的数据值都是相同的，省掉了桶内排序的时间。
	 * 
	 * @param a 数组, 假设数组中存储的都是非负整数。
	 */
	public static void countingSort(int... a) {
		final int n = null != a ? a.length : 0;
		if (n <= 1) {
			return;
		}

		// 1. 找出最大值，用来确定桶的数量。同时，假设数组中存储的都是非负整数。
		int maxValue = a[0];
		for (int i = 0; i < n; i++) {
			if (a[i] > maxValue) {
				maxValue = a[i];
			}
		}

		// 桶的数量
		int bucketCount = maxValue + 1;
		int[] bcArr = new int[bucketCount]; // 数组下标代表桶的编号，每个元素的数值代表对应桶内数据的数量
		// 统计，每个桶内数据的数量
		for (int i = 0; i < n; i++) {
			int bucketIndex = a[i]; // 桶的数量 = 数组的最大值+1
			bcArr[bucketIndex]++;
		}
		SysLog.log("统计，每个桶内数据的数量 : ");
		Tools.print(bcArr);

		// 小技巧：计算出，每个桶的数据在有序数组中对应的存储位置：
		// 对bcArr[]数组顺序求和，那么bcArr[m]里存储值小于等于m的元素的个数。
		for (int i = 1; i < bucketCount; i++) {
			bcArr[i] = bcArr[i - 1] + bcArr[i];
		}
		SysLog.log("对bcArr[]数组顺序求和 : ");
		Tools.print(bcArr);

		// 扫描整个数组a，将每个元素放到正确的位置上(新建的数组res)
		int[] res = new int[n];
//		for (int i = 0; i < n; i++) {
		for (int i = n - 1; i >= 0; i--) {
			int value = a[i];
			int bucketIndex = a[i]; // value
			int size = bcArr[bucketIndex]; // bcArr[m]里存储值小于等于m的元素的个数
			res[size - 1] = value;
			bcArr[bucketIndex]--;
		}
		SysLog.log("res: ");
		Tools.print(res);
		SysLog.log("bcArr[] : ");
		Tools.print(bcArr);

		// 将数组res 复制到 数组a
		for (int i = 0; i < n; i++) {
			a[i] = res[i];
		}
	}

	public static void main(String[] args) {
		final int[] array = { 4, 5, 0, 6, 3, 12, 2, 1, 7 };
		countingSort(array);
		SysLog.log("countingSort: ");
		Tools.print(array);

		// 计数排序: 排序的n个数据，所处的范围并不大
//		final int[] ba = { (int) (Math.random() * 1000), (int) (Math.random() * 100000), (int) (Math.random() * 10),
//				(int) (Math.random() * 1000000), (int) (Math.random() * 1000), (int) (Math.random() * 100), 2, 1, 7 };
//		Tools.print(ba);
//		countingSort(ba);
//		SysLog.log("countingSort: ");
//		Tools.print(ba);
	}
}
