package Test_0302;

import java.util.Arrays;

/*
6.Z ���α任
��һ�������ַ������ݸ������������Դ������¡������ҽ��� Z �������С�
���������ַ���Ϊ "LEETCODEISHIRING" ����Ϊ 3 ʱ���������£�
L   C   I   R
E T O E S I I G
E   D   H   N
֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"LCIRETOESIIGEDHN"��
����ʵ��������ַ�������ָ�������任�ĺ�����
string convert(string s, int numRows);
ʾ�� 1:
����: s = "LEETCODEISHIRING", numRows = 3
���: "LCIRETOESIIGEDHN"
ʾ�� 2:
����: s = "LEETCODEISHIRING", numRows = 4
���: "LDREOEIIECIHNTSG"
����:
L     D     R       
E   O E   I I   
E C   I H   N      
T     S     G       
 */
/*
 * ������
 * ��ͼ��z�����������й��ɵģ���j��ʾ�У���0��ʼ�������ǻᷢ�ֵ�һ�к����һ�е��ַ�����֮�䶼���2*(numRows-1)����
 * ��������ż������ǰһ�����2*(numRows-j-1)����������������λ����ǰһ�����2*j����
 * �����������֮��res��ʼΪ"",ֻ��Ҫ��0-numsRows-1�е��ַ���˳�����res�󼴿ɡ�
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
11. ʢ���ˮ������
���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ���� (i, ai) ���������ڻ� n ����ֱ�ߣ�
��ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0)���ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��

˵�����㲻����б�������� n ��ֵ����Ϊ 2��
ͼ�д�ֱ�ߴ����������� [1,8,6,2,5,4,8,3,7]���ڴ�����£������ܹ�����ˮ����ʾΪ��ɫ���֣������ֵΪ 49��

ʾ��:
����: [1,8,6,2,5,4,8,3,7]
���: 49
 */
/*
 * ������
 * ����һ��
 * ˫��ѭ�������ƽⷨ����max��¼���������ˮ�����
 * ��������
 * ����ļ���ΪMath.min(height[i], height[j]) *(j-i)��������ȡ����i��j�ľ����height[i], height[j]����Сֵ��
 * ����˫ָ�룬i = 0��j = height.length-1;��ʱi��j�������ָ����height[i], height[j]С��һ������������max��¼���������ˮ�������
 */
//public class LeetcodeTest {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int[] height = {1,8,6,2,5,4,8,3,7};
//		System.out.println(So.maxArea2(height));
//	}
//}
//class Solution {
//	//����һ
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
//    //������
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
16. ��ӽ�������֮��
 ����һ������ n ������������ nums �� һ��Ŀ��ֵ target���ҳ� nums �е�����������ʹ�����ǵĺ��� target ��ӽ���
 �������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�
���磬�������� nums = [-1��2��1��-4], �� target = 1.
�� target ��ӽ����������ĺ�Ϊ 2. (-1 + 2 + 1 = 2).
 */
/*
 * ������
 * res�����target��ӽ���������ʼֵΪnums[0] + nums[1] + nums[2]��
 * �ȸ��������򣬱�������������Ϊ0��nums.length-3�������Դ���Ϊ���ģ�ѭ�����ٽ���˫ָ�������l = i+1;
 * r = nums.length-1;sum = nums[i] + nums[l] + nums[r] ��
 * ��sum��target�Ĳ����ֵ��res��target�Ĳ����ֵСʱ����sum����target�У�
 * ���򣬱Ƚ�sum��target�Ĵ�С����sum��˵��Ӧ����Сsum��ֵ����r--,��sumС��˵��Ӧ������sum��ֵ����l++��
 * ��sum����target��ֱ�ӷ���target.������Ϸ���res.
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