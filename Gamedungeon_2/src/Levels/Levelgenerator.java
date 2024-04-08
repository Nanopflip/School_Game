package Levels;

import java.util.*;

public class Levelgenerator {
    public static int[][] generate(int[][] level){
        int lastPoint =((int)(Math.random() * level[0].length));
        level[0][lastPoint] = 1;
        int startPoint = ((int)(Math.random() * level[0].length));
        level[level.length -1][startPoint] = 1;
        level = generateRandom(level,lastPoint, startPoint);
        level = generateMethodical(level);
        level = assignDirections(level);
        level = generatePointsOfInterrest(level);
        return level;
    }

    private static int[][] generateRandom(int[][] level, int lastPointGiven, int startPoint){
        int[] lastPoint = {0, lastPointGiven};
        int[] directions = new int[4];
        int[] shuffler = {0,1,2,3};
        int var = 1;
        for (int i = 0; i < 6; i++){
            if (i == 3){
                lastPoint[0] = level.length - 1;
                lastPoint[1] = startPoint;
                level[level.length-1][startPoint] = 2;
                var = 2;
            }
            boolean varFound = false;
            if (lastPoint[1] - 1 >= 0 && level[lastPoint[0]][lastPoint[1] - 1] == 0){
                    directions[0] = 1;
            } else {
                directions[0] = 0;
            }
            if (lastPoint[1] + 1 < level[0].length && level[lastPoint[0]][lastPoint[1] + 1] == 0){
                    directions[1] = 1;
            } else {
                directions[1] = 0;
            }
            if (lastPoint[0] - 1 >= 0 && level[lastPoint[0] - 1][lastPoint[1]] == 0 ){
                    directions[2] = 1;
            } else {
                directions[2] = 0;
            }
            if (lastPoint[0] + 1 < level.length && (level[lastPoint[0] + 1][lastPoint[1]] == 0)){
                    directions[3] = 1;
            } else {
                directions[3] = 0;
            }
            shuffleArray(shuffler);
            for (int j = 0; j < directions.length; j++){
                if (directions[shuffler[j]] == 1 && !varFound){
                    switch (shuffler[j]){
                        case 0:
                            level[lastPoint[0]][lastPoint[1] - 1] = var;
                            lastPoint[1] = lastPoint[1] - 1;
                            break;
                        case 1:
                            level[lastPoint[0]][lastPoint[1] + 1] = var;
                            lastPoint[1] = lastPoint[1] + 1;
                            break;
                        case 2:
                            level[lastPoint[0] - 1][lastPoint[1]] = var;
                            lastPoint[0] = lastPoint[0] - 1;
                            break;
                        case 3:
                            level[lastPoint[0] + 1][lastPoint[1]] = var;
                            lastPoint[0] = lastPoint[0] + 1;
                            break;
                    }
                    varFound = true;
                }
            }
        }
        return level;
    }

    private static int[][] generateMethodical(int[][] level){
        int[] nearestUpPoint = {0,0};
        int[] nearestDownPoint = {0,0};
        for (int i = 4; i > 0; i--){
            for (int j = 0; j < level[i].length; j++){
                if (level[i][j] == 1 && nearestUpPoint[0] == 0){
                    nearestUpPoint[0] = i;
                    nearestUpPoint[1] = j;
                }
            }
        }
        for (int i = level.length - 5; i < level.length; i++){
            for (int j = 0; j < level[i].length; j++){
                if (level[nearestDownPoint[1]][j] == 2 && nearestDownPoint[0] == 0){
                    nearestDownPoint[0] = i;
                    nearestDownPoint[1] = nearestUpPoint[1];
                } else {
                    if (level[i][j] == 2 && nearestDownPoint[0] == 0) {
                        nearestDownPoint[0] = i;
                        nearestDownPoint[1] = j;
                    }
                }
            }
        }
        while (nearestUpPoint[0] != nearestDownPoint[0]){
            if (nearestDownPoint[0] > nearestUpPoint[0]){
                nearestUpPoint[0] += 1;
            } else {
                nearestUpPoint[0] -= 1;
            }
            level[nearestUpPoint[0]][nearestUpPoint[1]] = 1;
        }
        while (nearestUpPoint[1] != nearestDownPoint[1]){
            if (nearestDownPoint[1] > nearestUpPoint[1]){
                nearestUpPoint[1] += 1;
            } else {
                nearestUpPoint[1] -= 1;
            }
            level[nearestUpPoint[0]][nearestUpPoint[1]] = 1;
        }
        return level;
    }

    private static int[][] assignDirections(int[][] level){
        for (int i = 0; i < level.length; i++){
            for (int j = 0; j < level[i].length; j++){
                if (level[i][j] != 0){
                    level[i][j] = 1;
                }
                if (j + 1 < level[i].length && level[i][j + 1] != 0 && level[i][j] != 0){
                    level[i][j] += 10;
                }
                if (i - 1 >= 0 && level[i -1][j] != 0 && level[i][j] != 0){
                    level[i][j] += 100;
                }
                if (i +1 < level.length && level[i +1][j ] != 0 && level[i][j] != 0){
                    level[i][j] += 1000;
                }
                if (!(j - 1 >= 0 && level[i][j - 1] != 0) && level[i][j] != 0){
                    level[i][j] -= 1;
                }
            }
        }
        return level;
    }

    private static int[][] generatePointsOfInterrest(int[][] level){
        boolean found = false;
        int counter = 0;
        int[] point = new int[2];
        for (int i = 0; i < level.length; i++){
            if (level[0][i] != 0){
                counter += 1;
                point[1] = level[0][i];
            }
        }
        if (counter == 1){
            level[0][point[1]] += 10000;
        } else {
            for (int i = 0; i < level.length; i++){
                if ((level[0][i] & (level[0][i] - 1)) == 0 && level[0][i] != 0 && !found){
                    level[0][i] += 10000;
                    found = true;
                }
            }
            if (!found){

            }
        }
        return level;
    }

    private static void shuffleArray(int[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
