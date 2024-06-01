class Solution {
    class Pair<K,V>{
        K key;
        V value;
        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    public int[] searchRange(int[] nums, int target){
        //create arr with -1
        int[] arr = new int[2];
        Arrays.fill(arr,-1);
        if(nums==null || nums.length==0) return arr;
        //create stack with pair
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        //add (0, nums.length-1) to stack
        stack.add(new Pair<>(0,nums.length-1));
        //while stack is noy empty
            //pair = stack.pop()
            Pair<Integer,Integer> p = stack.pop();
            //int start = pair.getKey
            int start = p.key;
            //int end = pair.getKey
            int end = p.value;
            //calc. mid
            int mid = start + ((end -start)/2);
            //if target==[mid]
            if(target==nums[mid]){
                //if mid+1<n && [mid+1]==target
                if(mid+1<nums.length && nums[mid+1]==target){
                    if(start<=end)
                        //push mid+1,end to stack
                        stack.add(new Pair<>(mid+1,end));
                }
                //else
                else
                    //arr[1] = (arr[1]!=-1)?max(arr[0],mid):mid
                    arr[1] = (arr[1]!=-1)?Math.max(arr[1],mid):mid;
                //if mid-1>=0 && [mid-1]==target
                if(mid-1>=0 && nums[mid-1]==target){
                    if(start<=end)
                        //push start, mid-1 to stack
                        stack.add(new Pair<>(start,mid-1));
                }
                //else
                else
                    //arr[0] = (arr[0]!=-1)?min(arr[0],mid):mid
                    arr[0] = (arr[0]!=-1)?Math.min(arr[0],mid):mid;
            }
            //else [mid]>target
            else if(nums[mid]>target){
                //if start>end
                if(start<=end && mid-1>=0)
                    //push start,mid-1 to stack
                    stack.add(new Pair<>(start,mid-1));
            }
            //else [mid]<target
            else if(nums[mid]<target){
                //if start>end
                if(start<=end && mid+1<nums.length)
                    //push mid+1, end to stack
                    stack.add(new Pair<>(mid+1,end));
            }
        }
        //return arr
        return arr;
    }
}
class Solution {
    class Pair<K,V>{
        K key;
        V value;
        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    public int[] searchRange(int[] nums, int target){
        //create arr with -1
        int[] arr = new int[2];
        Arrays.fill(arr,-1);
        if(nums==null || nums.length==0) return arr;
        //create stack with pair
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        //add (0, nums.length-1) to stack
        stack.add(new Pair<>(0,nums.length-1));
        //while stack is noy empty
            //pair = stack.pop()
            Pair<Integer,Integer> p = stack.pop();
            //int start = pair.getKey
            int start = p.key;
            //int end = pair.getKey
            int end = p.value;
            //calc. mid
            int mid = start + ((end -start)/2);
            //if target==[mid]
            if(target==nums[mid]){
                //if mid+1<n && [mid+1]==target
                if(mid+1<nums.length && nums[mid+1]==target){
                    if(start<=end)
                        //push mid+1,end to stack
                        stack.add(new Pair<>(mid+1,end));
                }
                //else
                else
                    //arr[1] = (arr[1]!=-1)?max(arr[0],mid):mid
                    arr[1] = (arr[1]!=-1)?Math.max(arr[1],mid):mid;
                //if mid-1>=0 && [mid-1]==target
                if(mid-1>=0 && nums[mid-1]==target){
                    if(start<=end)
                        //push start, mid-1 to stack
                        stack.add(new Pair<>(start,mid-1));
                }
                //else
                else
                    //arr[0] = (arr[0]!=-1)?min(arr[0],mid):mid
                    arr[0] = (arr[0]!=-1)?Math.min(arr[0],mid):mid;
            }
            //else [mid]>target
            else if(nums[mid]>target){
                //if start>end
                if(start<=end && mid-1>=0)
                    //push start,mid-1 to stack
                    stack.add(new Pair<>(start,mid-1));
            }
            //else [mid]<target
            else if(nums[mid]<target){
                //if start>end
                if(start<=end && mid+1<nums.length)
                    //push mid+1, end to stack
                    stack.add(new Pair<>(mid+1,end));
            }
        }
        //return arr
        return arr;
    }
}
