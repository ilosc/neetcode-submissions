class Solution:
	def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
		data = sorted(zip(position, speed), reverse=True)

		prev_times = None
		n_fleets = 0
		for d in data:
			times = (target - d[0]) / d[1]
			if (prev_times is None) or (times > prev_times):
				n_fleets += 1
				prev_times = times

		return n_fleets        