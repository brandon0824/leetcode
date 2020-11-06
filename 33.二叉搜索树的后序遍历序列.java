class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null || postorder.length == 0){
            return true;
        }
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int first, int last){
        if(last - first <= 1){
            return true;
        }
        int rootval = postorder[last];
        int index = first;
        while(index < last && postorder[index] <= rootval){
            index++;
        }
        for(int i = index; i < last; i++){
            if(postorder[i] < rootval){
                return false;
            }
        }
        return verify(postorder, first, index-1) && verify(postorder,index, last-1);
    }
}