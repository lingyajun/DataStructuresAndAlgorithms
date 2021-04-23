package sort.linear;

import sort.QuickSort;
import utils.SysLog;
import utils.Tools;

/**
 * 桶排序
 * 
 * https://github.com/wangzheng0822/algo/blob/master/java/13_sorts/BucketSort.java
 * 
 * @author Solomon
 *
 */
public class BucketSort {

	/**
	 * 核心思想是将要排序的数据分到几个有序的桶里，每个桶里的数据再单独进行排序。
	 * 
	 * 桶内排完序之后，再把每个桶里的数据按照顺序依次取出，组成的序列就是有序的了。
	 * 
	 * 如果要排序的数据有n个，我们把它们均匀地划分到m个桶内，每个桶里就有k=n/m个元素。 每个桶内部使用快速排序，时间复杂度为O(k * logk)。
	 * 
	 * @param a
	 * @param bucketSize 桶容量
	 */
	public static void sort(final int bucketSize, int... a) {
		final int n = null != a ? a.length : 0;
		if (n <= 1) {
			return;
		}
		if (1 > bucketSize) {
			return;
		}

		int minValue = a[0];
		int maxValue = a[1]; // 查找数组最大、最小值 => 确定桶的数量
		for (int i = 0; i < n; i++) {
			if (a[i] > maxValue) {
				maxValue = a[i];
			} else if (a[i] < minValue) {
				minValue = a[i];
			}
		}

		final int bucketCount = (maxValue - minValue) / bucketSize + 1; // 桶的数量
		int[][] bucketMap = new int[bucketCount][bucketSize]; // 二维数组：桶的编号 & 桶内数组
		int[] indexArr = new int[bucketCount]; // 记录每个桶内实际数据的数量

		// 将数组分配到桶里
		for (int i = 0; i < n; i++) {
			int bucketIndex = (a[i] - minValue) / bucketSize; // 根据a[i] 的数值 算出a[i] 所对应桶的编号
			int[] bucket = bucketMap[bucketIndex];
			int size = indexArr[bucketIndex];
			if (size == bucket.length) {
				// 数组扩容
				ensureCapacity(bucketMap, bucketIndex);
				bucket = bucketMap[bucketIndex]; // 重新赋值
			}
			bucket[size] = a[i];
			size++;
			indexArr[bucketIndex] = size;
		}

		// 对每个桶进行排序，快速排序

		int k = 0;
		int len = bucketMap.length; // bucketCount
		for (int i = 0; i < len; i++) {
			final int size = indexArr[i];
			if (size < 1) {// 空桶
				SysLog.log(" {%d 号桶 : %d 个数据}", i, size);
				continue;
			}
			int[] bucket = bucketMap[i];
			int tail = size - 1;
			// 对桶内数据进行排序
			QuickSort.quickSortPub(bucket, 0, tail);

			// 将桶内数据放回到原数组
			for (int j = 0; j < size; j++) {
				a[k] = bucket[j];
				k++;
			}

			SysLog.log(" {%d 号桶 : %d 个数据}", i, size);
		}
	}

	private static void ensureCapacity(int[][] bucketMap, int bucketIndex) {
		int[] old = bucketMap[bucketIndex];
		final int size = old.length;
		int[] newArr = new int[size * 2];
		for (int i = 0; i < size; i++) {
			newArr[i] = old[i];
		}

		bucketMap[bucketIndex] = newArr; // 指向扩容后的新数组
	}

	public static void main(String[] args) {
		final int bucketSize = 4;
		final int[] array = { 4, 5, 0, 6, 3, 12, 2, 1, 7 };
		sort(bucketSize, array);
		Tools.print(array);
	}
}
