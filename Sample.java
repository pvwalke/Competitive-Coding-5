// Time Complexity : O(N) -> N being number of treeNodes in the tree
// Space Complexity : O(W) -> maxWidth of the binary tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
//This was intuitivley level order traversal hence used BFS. This is plain old BFS algorithm, except one change i.e comparing maxVal
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        //resultant array
        List<Integer> result = new ArrayList<>();
        //edge case
        if(root == null) return result;
        //define a queue
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); //1

        // go over the queue
        while(!q.isEmpty()){
            int size = q.size(); //3
            int maxVal = Integer.MIN_VALUE;
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll(); //9
                maxVal = Math.max(maxVal, curr.val); //(5, 9) -> 9
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            result.add(maxVal);//[1,3,9]
        }
        return result;
    }
}


// Time Complexity : For this problem TC is O(81) ~ O(1) -> since its a 9*9 grid
// Space Complexity : O(27) ~O(1)-> since I have added added for rows, columns and subgrids
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
//Since we have to search for elements we have to traverse the entire grid and
// since it needs unique elements in rows, columns and subGrids we have to use sets for each to chcek the uniqueness

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int i = 0; i< 9;i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char val = board[r][c];
                if(val != '.'){
                    int boxIndex = r/3 * 3 + c/3; // this is the magic here, I would have needed some help/hint from the interviewer
                    if(rows[r].contains(val) || cols[c].contains(val) || boxes[boxIndex].contains(val)){
                        return false;
                    }
                    rows[r].add(val);
                    cols[c].add(val);
                    boxes[boxIndex].add(val);
                }
            }
        }
        return true;
    }
}