package blockgame;

import blockgame.utils.BlockGameUtil;

/**
 * 프로그램명 : TODO
 * <p>
 * 내      용 : TODO
 *
 * @author damon
 * @since 18-07-06
 */
public class SequentialBlockGame implements IBlockGame {

    public static void main(String[] args) {
        SequentialBlockGame sequentialBlockGame = new SequentialBlockGame();
        BlockGameUtil.test(32, sequentialBlockGame, 300, 1000000000,
                true, Integer.MAX_VALUE, 300);
    }

    @Override
    public long solution(int[][] land, int P, int Q) {
        long answer = -1;

        int minFloor = 1000000000;
        int maxFloor = 0;

        int count = 0;
        int N = land.length;
        int[] blocks = new int[N * N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int blockCount = land[i][j];
                if (blockCount < minFloor) {
                    minFloor = blockCount;
                }
                if (blockCount > maxFloor) {
                    maxFloor = blockCount;
                }
                blocks[count++] = blockCount;
            }
        }

        for (int i = minFloor; i <= maxFloor; i++) {
            double price = 0;
            for (int j = 0; j < count; j++) {
                double blockCount = blocks[j];
                double addedPrice = 0;
                if (blockCount > i) {
                    addedPrice = Q * (blockCount - i);
                } else if (blockCount < i) {
                    addedPrice = P * (i - blockCount);
                }
                price = price + addedPrice;
            }
            if (answer == -1 || price < answer) {
                answer = (long) price;
            } else if (price > answer) {
                break;
            }
        }

        return answer;
    }
}
