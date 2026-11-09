class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        
        int n=arrival.length;

        TreeSet<Integer>available=new TreeSet<>();
        PriorityQueue<int[]>busy=new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        int maxi=0;
        int[] count=new int[k];

        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        for (int i=0;i<n;i++){

            while(!busy.isEmpty() && busy.peek()[0]<=arrival[i]){
                int[] completed=busy.poll();
                available.add(completed[1]);
            }

            if (available.isEmpty()) continue;
            int preferedServer=i%k;
            Integer server=available.ceiling(preferedServer);

            if (server==null) server=available.first();
            available.remove(server);
            count[server]++;
            busy.offer(new int[]{arrival[i]+load[i],server});
            maxi=Math.max(maxi,count[server]);
        }

        List<Integer>result=new ArrayList<>();

        for (int i=0;i<k;i++){
            if (count[i]==maxi){
                result.add(i);
            }
        }

        return result;
    }
}