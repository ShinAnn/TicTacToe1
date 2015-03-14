package it.java.game.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    /**
     * 将游戏内容打印出来
     */
	public static void Print(char[][] n) {
		System.out.println("---------");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				System.out.print(" " + n[i][j]);
			System.out.println();
		}
		System.out.println("---------");
	}
    /**
     * main方法
     */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        /**
         * 新建一个游戏
         */
		char[][] player = new char[3][3];

		
		Print(player);
        /**
         * 游戏最多9步结束
         */
		for (int i = 1; i < 10; i++) {
			if (i % 2 != 0) {
				System.out.print("Enter a row (1,2 or 3)for player x:");
				int row = input.nextInt();
				System.out.print("Enter a column (1,2 or 3)for player x:");
				int column = input.nextInt();

				player[row - 1][column - 1] = 'x';

				Print(player);

				if (isWon(player)) {
					System.out.println("x player won");
					break;
				}
			}

			else {
				System.out.print("Enter a row (1,2 or 3)for player o:");
				int row = input.nextInt();
				System.out.print("Enter a column (1,2 or 3)for player o:");
				int column = input.nextInt();

				player[row - 1][column - 1] = 'o';

				Print(player);

				if (isWon(player)) {
					System.out.println("o player won");
					break;
				}
			}
		}

		if (!isWon(player))
			System.out.println("no winner");

		input.close();

	}
    /**
     * 传入棋盘，判断赢家
     * 赢家只可能是传入棋盘时刻的玩家
     * 所以不需要判断是x还是o
     */
	public static boolean isWon(char[][] m) {
		for (int i = 0; i < 3; i++)
			if (isEqual(m[i]))
				return true;

		for (int j = 0; j < 3; j++) {
			char[] column = new char[3];
			for (int i = 0; i < 3; i++) {
				column[i] = m[i][j];
			}

			if (isEqual(column))
				return true;
		}

		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				char[] column = { m[0][0], m[1][1], m[2][2] };

				if (isEqual(column))
					return true;
			}

			else {
				char[] column = { m[0][1], m[1][1], m[2][0] };

				if (isEqual(column))
					return true;
			}
		}

		return false;
	}
    /**
     * 将3个位置中的元素传入list中，进行判断
     * 看这3个元素是否相等
     * 相等返回true
     * 否则返回false
     */
	public static boolean isEqual(char[] list) {

		final char[] temp = new char[3];

		System.arraycopy(list, 0, temp, 0, 3);

		for (int i = 1; i < 3; i++) {
			// Need to determine whether the element is empty(is not 'x' or 'o')
			if ((temp[i] != temp[i - 1] && temp[i - 1] != 0)
					|| temp[i - 1] == 0) {
				// if(temp[i] != tem[i-1] || temp[i-1] != 'x' || temp[i-1] !=
				// 'o'){
				return false;
			}
		}
		return true;
	}

}
