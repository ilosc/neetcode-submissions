class Solution {
    public int largestRectangleArea(int[] heights) {
		final int lenHeights = heights.length;
		int maxArea = 0;

		// La pila almacena tuplas de dos elementos del tipo:
		//   (height, pos)
		// Almacena la altura del elemento y la posición desde la que
		// inicia este elemento. Así, el área sería igual a:
		//    height * (posActual - pos)
        var stack = new ArrayList<int[]>();
		

		for (int i = 0; i < lenHeights; i++) {
			int h = heights[i];
			int start = i;
			while (!stack.isEmpty() && (h < stack.getLast()[0])) {
				// Se encuentra un elemento menor al último almacenado
				// en la pila. El último de la pila no puede seguir
				// extendiéndose. Se elimina y se calcula su área.
				int[] elem = stack.removeLast();
				int area = elem[0] * (i - elem[1]);
				if (area > maxArea) maxArea = area;

				// El elemento actual cabe en el anterior, recién eliminado, así
				// que se extiende su posición inicial hacia atrás.
				start = elem[1];
			}
			stack.add(new int[] {h, start});
		}

		// Los que quedan en la pila son elementos que se prolongan
		// hacia la derecha desde su índice hasta el final del vector
		// `heights`.
		int area = 0;
		for (int[] item: stack) {
			area = item[0] * (lenHeights - item[1]);
			if (area > maxArea) maxArea = area;
		}

		return maxArea;
    }
}
