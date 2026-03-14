class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            set2.add(nums2[i]);
        }

        ArrayList<Integer> res = new ArrayList<>();

        for(Integer el: set1){
            if(set2.contains(el)){
                res.add(el);
            }
        }

        int[] crr = new int[res.size()];
        for(int i=0;i<crr.length;i++){
            crr[i] = res.get(i);
        }
        return crr;

    }
}