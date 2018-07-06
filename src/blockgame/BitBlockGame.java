package blockgame;

import blockgame.utils.BlockGameUtil;

import java.util.Arrays;

/**
 * 프로그램명 : TODO
 * <p>
 * 내      용 : TODO
 *
 * @author damon
 * @since 18-07-06
 */
public class BitBlockGame implements IBlockGame {

    public static void main(String[] args) {
        BitBlockGame bitBlockGame = new BitBlockGame();
        BlockGameUtil.exampleTest(bitBlockGame);
/*
        BlockGameUtil.test(32, bitBlockGame, 300, 1000000000,
                true, Integer.MAX_VALUE, 300);
*/
    }

    @Override
    public long solution(int[][] land, int P, int Q) {
        long answer = -1;

        int minFloor = 1000000000;
        int maxFloor = 0;

        int count = 0;
        int N = land.length;
        int[] bits = new int[N * N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int blockCount = land[i][j];
                if (blockCount < minFloor) {
                    minFloor = blockCount;
                }
                if (blockCount > maxFloor) {
                    maxFloor = blockCount;
                }
                int top = (int) (Math.pow(2, blockCount) - 1);
                bits[count++] = top;
            }
        }

        for (int i = minFloor; i < maxFloor; i++) {

        }

        for (int bit : bits) {
            System.out.print(Integer.toBinaryString(bit) + ", ");
        }
        System.out.println();
        System.out.println(Arrays.toString(bits));

        for (int i = minFloor; i <= maxFloor; i++) {
        }

        return answer;
    }
}
