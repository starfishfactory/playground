package blockgame.utils;

import blockgame.IBlockGame;

import java.util.Arrays;

/**
 * 프로그램명 : TODO
 * <p>
 * 내      용 : TODO
 *
 * @author damon
 * @since 18-07-06
 */
public class BlockGameUtil {

    public static int random(int max) {
        return (int) (Math.ceil(Math.random() * Math.pow(10, (max + "").toString().length())) % max) + 1;
    }

    public static int[][] land(int N, int max) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            result[i] = new int[N];
            for (int j = 0; j < N; j++) {
                result[i][j] = random(max);
            }
        }
        return result;
    }

    public static void exampleTest(IBlockGame iBlockGame) {
        solution(iBlockGame, new int[][] {{1, 2}, {2, 3}}, 3, 2, true);
        solution(iBlockGame, new int[][] {{4, 4, 3}, {3, 2, 2}, {2, 1, 0}}, 5, 3, true);
    }

    public static void staticTest(IBlockGame iBlockGame, int[][] land, int P, int Q) {
        iBlockGame.solution(land, P, Q);
    }

    public static void test(int testCount, IBlockGame iBlockGame, int N, int maxBlockCount, boolean isDebugging,
            int Pmax, int Qmax) {

        for (int i = 0; i < testCount; i++) {

            int[][] land = land(N, maxBlockCount);
            int P = random(Pmax);
            int Q = random(Qmax);

            solution(iBlockGame, land, P, Q, isDebugging);
        }
    }

    public static void solution(IBlockGame iBlockGame, int[][] land, int P, int Q, boolean isDebugging) {
        long x = System.currentTimeMillis();
        long answer = iBlockGame.solution(land, P, Q);
        x = System.currentTimeMillis() - x;
        if (isDebugging) {
            for (int[] blocks : land) {
                System.out.print(Arrays.toString(blocks));
            }
            System.out.println();
        }
        System.out.println(String.format("%dms, P:%d, Q:%d, answer:%d", x, P, Q, answer));
    }
}
