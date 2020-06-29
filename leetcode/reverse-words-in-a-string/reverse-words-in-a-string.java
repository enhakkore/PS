class Solution {
    public String reverseWords(String s) {
        s = s.stripLeading();
        s = s.stripTrailing();

        String[] arr = s.split("\\s+");
        for(int i = 0 ; i < arr.length/2 ; i++){
            String tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }

        return String.join(" ", arr);
    }
}
