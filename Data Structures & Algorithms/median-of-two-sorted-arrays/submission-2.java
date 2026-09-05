class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merge = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        // Actually merge the two sorted arrays
        while(i < nums1.length && j < nums2.length){

            if(nums1[i] <= nums2[j]){
                merge[k] = nums1[i];
                i++;
            }
            else{
                merge[k] = nums2[j];
                j++;
            }

            k++;
        }

        // Remaining nums1
        while(i < nums1.length){
            merge[k] = nums1[i];
            i++;
            k++;
        }

        // Remaining nums2
        while(j < nums2.length){
            merge[k] = nums2[j];
            j++;
            k++;
        }

        int n = merge.length;

        if(n % 2 == 1){
            return merge[n / 2];
        }
        else{
            return (merge[n / 2 - 1] + merge[n / 2]) / 2.0;
        }
    }
}