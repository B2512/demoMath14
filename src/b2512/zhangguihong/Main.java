package b2512.zhangguihong;

public class Main {
    public static void main(String[] args) {
        int height = 20;
        int width = 20;
        int mine = 300;
        char[][] lattice = new char[height][width];
        for (int i = 0; i < mine; i++) {
            int random1 = (int) (Math.random() * height);
            int random2 = (int) (Math.random() * width);
            if (lattice[random1][random2] == '*') {
                i--;
            } else {
                lattice[random1][random2] = '*';
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int result = 0;
                if (lattice[i][j] == '*') {
                    System.out.print(lattice[i][j]);
                    continue;
                } else {
                    if (j != 0 && lattice[i][j - 1] == '*') {
                        result++;
                    }
                    if (j != 0 && i != 0 && lattice[i - 1][j - 1] == '*') {
                        result++;
                    }
                    if (i != 0 && lattice[i - 1][j] == '*') {
                        result++;
                    }
                    if (i != 0 && j != lattice[0].length - 1 && lattice[i - 1][j + 1] == '*'){
                        result++;
                    }
                    if (j != lattice[0].length - 1 && lattice[i][j + 1] == '*'){
                        result++;
                    }
                    if (i != lattice.length - 1 && j != lattice[0].length - 1 && lattice[i + 1][j + 1] == '*'){
                        result++;
                    }
                    if (i != lattice.length - 1 && lattice[i + 1][j] == '*'){
                        result++;
                    }
                    if (i != lattice.length - 1 && j != 0 && lattice[i + 1][j - 1] == '*'){
                        result++;
                    }
                }
                lattice[i][j] = String.valueOf(result).charAt(0);
                System.out.print(lattice[i][j]);
            }
            System.out.println();
        }
    }
}
