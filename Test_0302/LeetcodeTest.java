package Test_0302;

import java.util.Arrays;

/*
6.Z 字形变换
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);
示例 1:
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:
输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:
L     D     R       
E   O E   I I   
E C   I H   N      
T     S     G       
 */
/*
 * 分析：
 * 上图的z字型排列是有规律的，用j表示行（从0开始），我们会发现第一行和最后一行的字符两两之间都相差2*(numRows-1)个，
 * 而其他行偶数个与前一个相差2*(numRows-j-1)，奇数个（不算首位）与前一个相差2*j个，
 * 发现这个规律之后，res初始为"",只需要将0-numsRows-1行的字符按顺序加在res后即可。
 */
//public class LeetcodeTest {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		String s = "LEETCODEISHIRING";
//		int numRows = 3;
//		System.out.println(So.convert(s, numRows));
//	}
//}
//class Solution {
//    public String convert(String s, int numRows) {
//    	if(numRows <= 1){
//    		return s;
//    	}
//    	String res = "";
//    	int ret = 0;
//    	for(int j=0; j<numRows; j++){
//    		if(j != numRows-1){
//    			ret = 2*(numRows-j-1);
//    		}else{
//    			ret = 2*j;
//    		}
//    		if(j==0 || j == numRows-1){
//    			for(int i=j; i<s.length(); i+=ret){
//    				res += String.valueOf(s.charAt(i));
//    			 }
//   			}else{
//    			int i=j;
//    			int flag = 0;
//    			while(i<s.length()){
//    				res += String.valueOf(s.charAt(i));
//    				if(flag==0){
//    					i += ret;
//    					flag = 1;
//    				}else{
//    					i += 2*j;
//    					flag = 0;
//    				}
//    			}
//    		}
//    	}
//    	return res;
//    }
//}
/*
11. 盛最多水的容器
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。
图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

示例:
输入: [1,8,6,2,5,4,8,3,7]
输出: 49
 */
/*
 * 分析：
 * 方法一：
 * 双层循环暴力破解法，用max记录出容纳最多水的面积
 * 方法二：
 * 面积的计算为Math.min(height[i], height[j]) *(j-i)，最大面积取决于i、j的距离和height[i], height[j]的最小值，
 * 采用双指针，i = 0，j = height.length-1;此时i、j距离最大，指针由height[i], height[j]小的一方往进缩，用max记录出容纳最多水的面积。
 */
//public class LeetcodeTest {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int[] height = {1,8,6,2,5,4,8,3,7};
//		System.out.println(So.maxArea2(height));
//	}
//}
//class Solution {
//	//方法一
//    public int maxArea1(int[] height) {
//    	if(height.length < 2){
//    		return -1;
//    	}
//    	int max = 0;
//        for(int i=1; i<height.length; i++){
//        	for(int j=0 ;j<i; j++){
//        		max = Math.max(max, Math.min(height[i], height[j]) *(i-j));
//        	}
//        }
//        return max;
//    }
//    //方法二
//    public int maxArea2(int[] height) {
//    	if(height.length < 2){
//    		return -1;
//    	}
//    	int i = 0;
//    	int j = height.length-1;
//    	int max = 0;
//    	while(i<j){
//    		max = Math.max(max, Math.min(height[i], height[j]) * (j-i));
//    		if(height[i] <height[j]){
//    			i++;
//    		}else{
//    			j--;
//    		}
//    	}
//    	return max;
//    }
//}
/*
16. 最接近的三数之和
 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 返回这三个数的和。假定每组输入只存在唯一答案。
例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
/*
 * 分析：
 * res存放与target最接近的数，初始值为nums[0] + nums[1] + nums[2]，
 * 先给数组排序，遍历数组中索引为0到nums.length-3的数，以此数为中心，循环内再进行双指针遍历，l = i+1;
 * r = nums.length-1;sum = nums[i] + nums[l] + nums[r] ，
 * 当sum与target的差绝对值比res与target的差绝对值小时，将sum存入target中，
 * 否则，比较sum与target的大小，若sum大，说明应该缩小sum的值，故r--,若sum小，说明应该增大sum的值，故l++，
 * 若sum等于target，直接返回target.遍历完毕返回res.
 */
public class LeetcodeTest {
	public static void main(String[] args) {
		Solution So = new Solution();
		int[] nums = {0,2,1,-3}; 
		int target = 1;
		System.out.println(So.threeSumClosest(nums, target));
	}
}
class Solution {
    public int threeSumClosest(int[] nums, int target) {
       Arrays.sort(nums);
       int res = nums[0] + nums[1] + nums[2] ;
       for(int i = 0;i<nums.length-2 ; i++){
    	   int l = i+1;
    	   int r = nums.length-1;
    	   while(l<r){
    		   int sum = nums[i] + nums[l] + nums[r];
    		   if(Math.abs(sum - target) < Math.abs(res - target)){
    			   res = sum;
    		   }else if(sum > target){
    			   r--;
    		   }else if(sum < target){
    			   l++;
    		   }else{
    			   return target;
    		   }
    	   }
       }
       return res;
    }
}