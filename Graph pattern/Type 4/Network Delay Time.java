
class Solution {

    class Pair{
        int key;
        int value;
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        //create priority queue with max comparator
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((p1,p2)->(p1.value>p2.value)?1:-1);
        //maximumMap
        int[] distanceList = new int[n+1];
        Arrays.fill(distanceList,-1);
        //create adjacencyMap
        HashMap<Integer,List<Pair>> adjacencyList = new HashMap();
        for(int[] time:times){
            List<Pair> list = adjacencyList.get(time[0]);
            if(list==null){
                list = new ArrayList();
            }
            list.add(new Pair(time[1],time[2]));
            adjacencyList.put(time[0],list);
        }
        //bfs
        //add k to queue
        queue.add(new Pair(k,0));
        //put (k,0)
        distanceList[k]=0;
        //while queue is not empty
            //size = queue.size()
            int size = queue.size();
            //while(size-->0)
            while(size-->0){
                //int p = queue.pop()
                Pair p = queue.poll();
                //int key = p.key
                int key = p.key;
                //int d = p.value
                int d = p.value;
                //list = adjacencyMap.get(key)
                List<Pair> list = adjacencyList.get(key);
                if(list==null)
                    continue;
                //loop list
                for(Pair l:list){
                    //if(maxDistanceMap.get(l)==null || d+w>maxDistanceMap.get(l))
                    if(distanceList[l.key]==-1 || d+l.value<distanceList[l.key]){
                        //maxDistanceMap.put(l,d+w)
                        distanceList[l.key]=d+l.value;
                        //queue.add(pair(l,d+w))
                        queue.add(new Pair(l.key,d+l.value));
                    }

                }

            }

        }
        int max = -1;
        //loop distanceMap
        for(int i=1;i<distanceList.length;i++){
            if(distanceList[i]==-1)
                return -1;
            max = Math.max(max,distanceList[i]);
        }
        //return max
        return max;
    }
}
