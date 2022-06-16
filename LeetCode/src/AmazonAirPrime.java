import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class AmazonAirPrime {
	
	public static void main(String[] args) {
		
		int maxTravelDist = 7000;
		int [][] forwardRouteList = {{1,200}, {2,4000}, {3,6000}};
		
		int[][] returnRouteList = {{1,2000}};
		
		try {
			List<int[]> ans = routePairs(maxTravelDist, forwardRouteList, returnRouteList);
			
			   for(int[] r : ans)
			   {
			       System.out.println(r[0] + " " + r[1]);
			   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		
	}
	public static List<int[]> routePairs(int maxTravelDist,
	        int[][] forwardRouteList, int[][] returnRouteList){

	        //idea is find the most optimal route pairs with total travel distance equal or close to limit,
	        //but not exceed it.
	        List<int[]> ans = new ArrayList<>();

	        //sort by distance ascend
	        Arrays.sort(forwardRouteList, (a,b)-> Integer.compare(a[1],b[1]));
	        Arrays.sort(returnRouteList, (a,b)-> Integer.compare(a[1],b[1]));

	        TreeMap<Integer, List<int[]>> treeMap = new TreeMap<>();
	        for(int[] forward: forwardRouteList){
	            if(forward[1]>=maxTravelDist){
	                break;
	            }
	            int[] backward = findTheOneEqualToOrClose(returnRouteList, maxTravelDist-forward[1]);
	            int diff = maxTravelDist - forward[1] - backward[1];
	            treeMap.putIfAbsent(diff, new ArrayList<>());
	            treeMap.get(diff).add(new int[]{forward[0], backward[0]});
	        }

	        return treeMap.get(treeMap.firstKey());
	    }

	    private static int[] findTheOneEqualToOrClose(int[][] candidates, int target){
	        int left = 0, right = candidates.length - 1;
	        while (left <= right){
	            int mid = left + (right-left)/2;
	            if(candidates[mid][1] == target){
	                return candidates[mid];
	            }else if (candidates[mid][1] > target){
	                right = mid - 1;
	            }else {
	                left = mid + 1;
	            }
	        }
	        return candidates[left - 1 > 0? left -1: 0];
	    }

}
