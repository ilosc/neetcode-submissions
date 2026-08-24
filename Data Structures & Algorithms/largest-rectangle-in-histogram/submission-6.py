class Solution:
	def largestRectangleArea(self, heights: List[int]) -> int:
		max_area = 0
		stack = [] # height and index
		for i, h in enumerate(heights):
			start = i
			while stack and (h < stack[-1][0]):
				elem = stack.pop()
				v = elem[0] * (i - elem[1])
				if v > max_area:
					max_area = v
				start = elem[1]
			
			stack.append([h, start])

		if stack:
			top_index = len(heights)
			for item in stack:
				v = item[0] * (top_index  - item[1])
				if v > max_area:
					max_area = v
		return max_area
			
		