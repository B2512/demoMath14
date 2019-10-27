package b2512.wuzhangjie;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        //随机生成地雷数
        int numOfMines=3;
        //地图尺寸
        int mapSize=5;
        Random r=new Random();
        //用二位数组做地图
        int [][] map=new int[mapSize][mapSize];
        //地雷周围的偏移量
        int[]around={-1,0,1};
        //开始生成
        for (int i=0;i<numOfMines;i++){
            int x,y;
            do {
                x=r.nextInt(mapSize);
                y=r.nextInt(mapSize);
            }while(map[x][y]>=100);
            //埋雷
            map[x][y]=100;
            //周围的提示
            for (int dy:around){
                for (int dx:around){
                    if (dx==0 && dy==0){
                        continue;
                    }
                    if ((x+dx)>=0
                            && (x+dx)<mapSize
                            && (y+dy)>=0
                            && (y+dy)<mapSize){
                        try {
                            map[x+dx][y+dy]++;
                        } catch (Exception e) {
                            System.out.println(x+dx+"  "+y+dy);
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        for (int y=0;y<mapSize;y++){
            for (int x=0;x<mapSize;x++){
                if (map[x][y]>=100){
                    System.out.print("[*]");
                }else if (map[x][y]==0){
                    System.out.print("[0]");
                }else {
                    System.out.print("["+map[x][y]+"]");
                }
            }
            System.out.println();
        }
        */

        char[][] arr = new char[5][5];
        for (int i = 0; i < 3; i++) {
            int a = (int) (Math.random() * 5);
            int b = (int) (Math.random() * 5);
            if (arr[a][b] == '*') {
                i--;
            } else {
                arr[a][b] = '*';
            }
        }

        for (int i=0;i<arr.length;i++){

            for (int j=0;j<arr[i].length;j++){
                int str=0;
                if (arr[i][j]=='*'){
                    System.out.print(arr[i][j]);
                    continue;
                }else {
                    if (j != 0 && arr[i][j-1] == '*'){
                        str++;
                    }
                    if (i != 0 && j != 0 && arr[i-1][j-1] == '*'){
                        str++;
                    }
                    if (i != 0 && arr[i-1][j] == '*'){
                        str++;
                    }
                    if (i != 0 && j != arr[0].length-1 && arr[i-1][j+1] == '*'){
                        str++;
                    }
                    if (j != arr[0].length-1 && arr[i][j+1] == '*'){
                        str++;
                    }
                    if (i != arr.length-1 && j != arr[0].length-1 && arr[i+1][j+1] == '*'){
                        str++;
                    }
                    if (i != arr.length-1 && arr[i+1][j] == '*'){
                        str++;
                    }
                    if (i != arr.length-1 && j != 0 && arr[i+1][j-1] == '*'){
                        str++;
                    }
                }
                arr[i][j] = String.valueOf(str).charAt(0);
                System.out.print(arr[i][j]);
            }
            System.out.println();

        }
    }
}
