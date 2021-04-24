package binary_search;

import utils.SysLog;
import utils.Tools;

/**
 * 二分查找
 * 
 * @author Solomon
 *
 */
public class BinarySearch {

	/**
	 * 有序数组,不存在重复元素
	 * 
	 * @return 目标值的下标
	 */
	public static int search(final int value, int... a) {
		final int n = null != a ? a.length : 0;
		if (n < 1) {
			return -1;
		}

		int low = 0;
		int high = n - 1;

		/**
		 * 循环(退出)条件，注意是low<=high，而不是low<high
		 */
		while (low <= high) {
			int mid = low + (high - low) / 2; // 避免 height+low 溢出
			// 可以将这里的除以2操作转化成位运算low+((high-low)>>1)。因为相比除法运算来说，计算机处理位运算要快得多。

			if (a[mid] == value) {
				return mid;
			}

			/**
			 * low=mid+1，high=mid-1。 注意这里的+1和-1，如果直接写成low=mid或者high=mid，就可能会发生死循环。
			 * 比如，当high=3，low=3时，如果a[3]不等于value，就 会导致一直循环不退出。
			 */
			if (a[mid] > value) { // 目标值在小区间内
				high = mid - 1;
			} else {
				// 目标值在大区间内
				low = mid + 1;
			}
		}

		return -1;
	}

	/**
	 * 变体一:查找第一个值等于给定值的元素
	 * 
	 * @param value 目标值
	 * @param a
	 * @return 第一个值等于目标值的下标
	 */
	public static int search1(final int value, int... a) {
		final int n = null != a ? a.length : 0;
		if (n < 1) {
			return -1;
		}
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] == value) {
				// low的值保持不变，high不断向low靠拢收缩
				high = mid - 1;
			} else if (a[mid] > value) { // 把搜索范围限定在 小区间里
				high = mid - 1; // 在a[mid] == value 和 a[mid] > value 的情况下，调整high的值，low的值保持不变
			} else { // 大区间
				low = mid + 1;
			}
		}
		// 返回 low
		if (low < n && a[low] == value) {
			return low;
		}
		return -1;
	}

	/**
	 * 变体一:查找第一个值等于给定值的元素
	 * 
	 * @param value 目标值
	 * @param a
	 * @return 第一个值等于目标值的下标
	 */
	public static int search1x(final int value, int... a) {
		final int n = null != a ? a.length : 0;
		if (n < 1) {
			return -1;
		}
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] == value) {
				// 如果mid等于0，那这个元素已经是数组的第一个元素，那它肯定是我们要找的;
				// 如果mid不等于0，但a[mid]的前一个元素a[mid-1]不等于value，那也说明a[mid]就是我们要找的第一个值等于给定值的元素
				if (mid == 0 || a[mid - 1] != value) {
					return mid;
				}

				// 如果经过检查之后发现a[mid]前面的一个元素a[mid-1]也等于value，
				// 那说明此时的a[mid]肯定不是我们要查找的第一个值等于给定值的元素。
				// 那我们就更新high=mid-1，因为要找的元素肯定出现在[low, mid-1]之间。
				high = mid - 1;
			} else if (a[mid] > value) { // 把搜索范围限定在 小区间里
				high = mid - 1; // 在a[mid] == value 和 a[mid] > value 的情况下，调整high的值，low的值保持不变
			} else { // 大区间
				low = mid + 1;
			}
		}
		// 返回 low
		if (low < n && a[low] == value) {
			return low;
		}
		return -1;
	}

	/**
	 * 变体二:查找最后一个值等于给定值的元素
	 * 
	 * @param value
	 * @param a
	 * @return
	 */
	public static int search2(final int value, int... a) {
		final int n = null != a ? a.length : 0;
		if (n < 1) {
			return -1;
		}
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] == value) {
				// 如果mid等于(n-1)，那这个元素已经是数组的最后一个元素，那它肯定是我们要找的;
				// 如果mid不等于(n-1)，但a[mid]的后一个元素a[mid+1]不等于value，那也说明a[mid]就是我们要找的最后一个值等于给定值的元素
				if ((mid == n - 1) || a[mid + 1] != value) {
					return mid;
				}

				// 如果经过检查之后发现a[mid]后面的一个元素a[mid+1]也等于value，
				// 那说明此时的a[mid]肯定不是我们要查找的最后一个值等于给定值的元素。
				// 那我们就更新low，因为要找的元素肯定出现在[mid+1, high]之间。
				low = mid + 1;
			} else if (a[mid] > value) { // 小区间
				high = mid - 1;
			} else { // 大区间
				low = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 变体三:查找第一个大于等于给定值的元素
	 * 
	 * @param value 目标值
	 * @param a
	 * @return 第一个值大于等于目标值的下标
	 */
	public static int search3(final int value, int... a) {
		final int n = null != a ? a.length : 0;
		if (n < 1) {
			return -1;
		}
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] >= value) {
				// 如果mid等于0，那这个元素已经是数组的第一个元素，那它肯定是我们要找的;
				// 如果mid不等于0，但a[mid]的前一个元素a[mid-1] 小于value，那也说明a[mid]就是我们要找的第一个值大于等于给定值的元素
				if (mid == 0 || a[mid - 1] < value) {
					return mid;
				}

				// 如果经过检查之后发现a[mid]前面的一个元素a[mid-1]也大于等于value，
				// 那说明此时的a[mid]肯定不是我们要查找的第一个值等于给定值的元素。
				// 那我们就更新high=mid-1，因为要找的元素肯定出现在[low, mid-1]之间。
				high = mid - 1;
			} else { // 大区间
				low = mid + 1;
			}
		}
		// 返回 low
		if (low < n && a[low] == value) {
			return low;
		}
		return -1;
	}

	/**
	 * 变体四:查找最后一个小于等于给定值的元素
	 * 
	 * @param value
	 * @param a
	 * @return
	 */
	public static int search4(final int value, int... a) {
		final int n = null != a ? a.length : 0;
		if (n < 1) {
			return -1;
		}
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] <= value) {
				// 如果mid等于(n-1)，那这个元素已经是数组的最后一个元素，那它肯定是我们要找的;
				// 如果mid不等于(n-1)，但a[mid]的后一个元素a[mid+1]大于value，那也说明a[mid]就是我们要找的最后一个值小于等于给定值的元素
				if ((mid == n - 1) || a[mid + 1] > value) {
					return mid;
				}

				// 如果经过检查之后发现a[mid]后面的一个元素a[mid+1]也小于等于value，
				// 那说明此时的a[mid]肯定不是我们要查找的最后一个值等于给定值的元素。
				// 那我们就更新low=mid+1，因为要找的元素肯定出现在[mid+1, high]之间。
				low = mid + 1;
			} else if (a[mid] > value) { // 小区间
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int value = 7;
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8, 8, 9 };
		Tools.print(array);
		int res = search(value, array);
		SysLog.log("search , target: %d, index: %d", value, res);

		res = search1(value, array);
		SysLog.log("search1 , target: %d, first index: %d", value, res);

		res = search1x(value, array);
		SysLog.log("search1x , target: %d, first index: %d", value, res);

		res = search2(value, array);
		SysLog.log("search2 , target: %d, last index: %d", value, res);

		res = search3(value, array);
		SysLog.log("search3 , target: %d, first(>=) index: %d", value, res);
		res = search3(8, array);
		SysLog.log("search3 , target: %d, first(>=) index: %d", 8, res);

		res = search4(value, array);
		SysLog.log("search4 , target: %d, last(<=) index: %d", value, res);
	}
}
