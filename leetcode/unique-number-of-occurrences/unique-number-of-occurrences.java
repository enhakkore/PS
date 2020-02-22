class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> info = new HashSet<>();

        int stand = arr[0];
        int count = 1;
        for(int i = 1 ; i < arr.length ; i++){
            if(stand == arr[i]){
                count++;
            } else {
                if(info.contains(count)) return false;
                info.add(count);
                stand = arr[i];
                count = 1;
            }
        }
        if(info.contains(count)) return false;

        return true;
    }
}
