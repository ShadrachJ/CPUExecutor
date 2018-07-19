

public class ProcessExecutor {

	public static void main(String[] args) {
		Integer[][] pair = { { 2, 1, 8, 4, 5 }, //process time
				   { 2, 1, 4, 2, 3 }, };//priority
		fcfs(pair);
		System.out.println("");
		sjf(pair);
		System.out.println("");
		npp(pair);
	}
	/*implementation wherein the jobs are handled in exactly the order they appear
	  regardless of their size or priority.
	*/
	public static void fcfs(Integer[][] pair) {
		int turnTime = 0;
		System.out.println("First come first serve implementation: \n");
		System.out.println("Process          Turnaround Time");
		for (int i = 0; i < pair[0].length; i++) {
			turnTime += pair[0][i];
			System.out.print("P" + (i + 1) + "               " + turnTime);
			System.out.println("");
		}
	}
 
	/*Implementation wherein the jobs are handled according to their size, with shorter 
	  jobs executing first.
	*/
	public static void sjf(Integer[][] pair) {
		int turnTime = 0;
		int[] subArray = new int[pair[0].length];
		for (int i = 0; i < pair[0].length; i++) {
			subArray[i] = pair[0][i];
		}
		int min = subArray[0];
		int max = subArray[0];
		int mindex = 0;
		int loop = subArray.length;
		System.out.println("Shortest job first implementation: \n");
		System.out.println("Process          Turnaround Time");
		while (loop > 0) {
			for (int i = 0; i < subArray.length; i++) {
				if (subArray[i] == 0) {
					continue;
				}
				if (subArray[i] <= min) {
					min = subArray[i];
					mindex = i;
				}
				if (subArray[i] >= max) {
					max = subArray[i];
				}
			}
			turnTime += subArray[mindex];
			subArray[mindex] = 0;
			min = max;
			System.out.print("P" + (mindex + 1) + "               " + turnTime);
			System.out.println("");
			loop--;
		}
	}
	//implementation wherein the jobs are executed in accordance to their priority,
	//with jobs not having the ability to preempt currently executing tasks. 
	public static void npp(Integer[][] pair) {
		System.out.println("Nonpreimptive priority implementation: \n");
		System.out.println("Process          Turnaround Time");
		int turnTime = 0;
		int maxdex = 0;
		int max = pair[1][0];
		int loop = pair[0].length;
		while(loop >0) {
			for(int i = 0; i < pair[0].length; i++) {
				if(pair[1][i] > max) {
					maxdex = i;
					max = pair[1][i];
				}
			}
			turnTime+=pair[0][maxdex];
			pair[1][maxdex] = 0;
			pair[0][maxdex] = 0;
			max = 0;
			System.out.print("P" + (maxdex + 1) + "               " + turnTime);
			System.out.println("");
			loop--;
		}
	}
}
