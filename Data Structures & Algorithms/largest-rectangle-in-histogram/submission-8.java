class Solution {

    private int size = 0;
	private int[][] stack = new int[32][];

    public int largestRectangleArea(int[] heights) {
		final int lenHeights = heights.length;
		int maxArea = 0;

		// La pila almacena tuplas de dos elementos del tipo:
		//   (height, pos)
		// Almacena la altura del elemento y la posición desde la que
		// inicia este elemento. Así, el área sería igual a:
		//    height * (posActual - pos)

		for (int i = 0; i < lenHeights; i++) {
			int h = heights[i];
			int start = i;
			while ((size > 0) && (h < top()[0])) {
				// Se encuentra un elemento menor al último almacenado
				// en la pila. El último de la pila no puede seguir
				// extendiéndose. Se elimina y se calcula su área.
				int[] elem = pop();
				int area = elem[0] * (i - elem[1]);
				if (area > maxArea) maxArea = area;

				// El elemento actual cabe en el anterior, recién eliminado, así
				// que se extiende su posición inicial hacia atrás.
				start = elem[1];
			}
			push(h, start);
		}

		// Los que quedan en la pila son elementos que se prolongan
		// hacia la derecha desde su índice hasta el final del vector
		// `heights`.
		int area = 0;
		for (int i = 0; i < size; i++) {
			int[] item = stack[i];
			area = item[0] * (lenHeights - item[1]);
			if (area > maxArea) maxArea = area;
		}

		return maxArea;
	}

	private void push(int height, int pos) {
		if (size == stack.length) {
			var newStack = new int[(int)(stack.length * 1.5f) + 1][];
			System.arraycopy(stack, 0, newStack, 0, stack.length);
			stack = newStack;
		}
		stack[size++] = new int[] {height, pos};
	}

	private int[] top() {
		return stack[size - 1];
	}

	private int[] pop() {
		return stack[--size];
	}

}
