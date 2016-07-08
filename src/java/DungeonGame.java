package java;

public class DungeonGame {

	public static void main(String[] args) {
		DungeonGame myMain = new DungeonGame();
		System.out
				.println("" + myMain.calculateMinimumHP(new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } }));
	}

	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
			return 0;
		}

		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] mem = new int[m][n];
		mem[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
		for (int i = m - 2; i >= 0; --i) {
			mem[i][n - 1] = Math.max(1, mem[i + 1][n - 1] - dungeon[i][n - 1]);
		}
		for (int j = n - 2; j >= 0; --j) {
			mem[m - 1][j] = Math.max(1, mem[m - 1][j + 1] - dungeon[m - 1][j]);
		}
		for (int i = m - 2; i >= 0; --i) {
			for (int j = n - 2; j >= 0; --j) {
				mem[i][j] = Math.max(1, Math.min(mem[i + 1][j], mem[i][j + 1]) - dungeon[i][j]);
			}
		}
		return mem[0][0];
	}

}
