package b2512.chenwenjie;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // write your code here
        GetMine(3,3,3);
    }

    public static char[][] GetMine(int width, int height, int mineCount) {
        char[][] map = new char[width][height];
        int[] mines = new int[mineCount];
        int mapSize = width * height;

        // 随机生成地雷位置
        int[] allPossibility = new int[mapSize];
        // [0,1,2,3,4,5,6....]
        for (int i = 0; i < allPossibility.length; i++)
            allPossibility[i] = i;
        for (int i = 0; i < mapSize - mineCount; i++) {
            int randomNumber = new Random().nextInt(mapSize - 1 - i);

            int[] newPossibility = new int[allPossibility.length - 1]; // 临时变量,用于除去一位
            for (int j = 0; j < newPossibility.length; j++) {
                if (j >= randomNumber)
                    newPossibility[j] = allPossibility[j + 1];
                else
                    newPossibility[j] = allPossibility[j];
            }
            allPossibility = newPossibility;
        }

        // 将随机位置改为地雷点
        for (int i : allPossibility) {
            int x = i / width;
            int y = i % height;

            map[x][y] = '*';
        }

        // 计算每个格位周围8个格的地雷数
        for (int i = 0; i < mapSize; i++) {
            int x = i / width;
            int y = i % height;

            char thisChar = map[x][y];

            if (thisChar == '*')
                continue;

            int thisMineCount = 0;

            if (x - 1 < 0 || y - 1 < 0) {
            } else if (map[x - 1][y - 1] == '*')
                thisMineCount++;

            if (x - 1 < 0) {
            } else if (map[x - 1][y] == '*')
                thisMineCount++;

            if (x - 1 < 0 || y + 1 >= height) {
            } else if (map[x - 1][y + 1] == '*')
                thisMineCount++;

            if (x + 1 >= width || y - 1 < 0) {
            } else if (map[x + 1][y - 1] == '*')
                thisMineCount++;

            if (x + 1 >= width) {
            } else if (map[x + 1][y] == '*')
                thisMineCount++;

            if (x + 1 >= width || y + 1 >= height) {
            } else if (map[x + 1][y + 1] == '*')
                thisMineCount++;

            if (y - 1 < 0) {
            } else if (map[x][y - 1] == '*')
                thisMineCount++;

            if (y + 1 >= height) {
            } else if (map[x][y + 1] == '*')
                thisMineCount++;


            map[x][y] = String.valueOf(thisMineCount).charAt(0);
        }

        // 输出结果
        for (char[] content : map) {
            for (char innerContent : content) {
                if ((int) innerContent == 0)
                    System.out.print("0");
                else
                    System.out.print(String.valueOf(innerContent));
            }
            System.out.println();
        }

        return map;
    }
}
