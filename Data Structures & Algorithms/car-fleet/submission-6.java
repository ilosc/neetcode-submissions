class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        var cars = new ArrayList<int[]>();
		for (int i = 0; i < position.length; i++) {
			cars.add(new int[] {position[i], speed[i]});
		}
		cars.sort((c1, c2) -> Integer.compare(c2[0], c1[0]));

		int fleets = 0;
		float prev_times = -1;
		float times = 0;
		for (int[] c: cars) {
			times = (target - c[0]) / (float)c[1];
			if ((prev_times == -1) || (times > prev_times)) {
				fleets++;
				prev_times = times;
			}
		}
		return fleets;
    }
}
