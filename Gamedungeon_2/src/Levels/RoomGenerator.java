package Levels;

import java.util.Arrays;

public class RoomGenerator {
    private static int[] roomLayout;

    public static int[] generate(){
        generateRoomShape();
        return roomLayout;
    }

    private static void generateRoomShape() {
        int counter = (int) (Math.random() * 20) + 35;
        if (counter % 2 != 1) {
            counter++;
        }
        roomLayout = new int[counter];
        //(int) (Math.random() * 5)
        switch (1) {
            /* 10|00|00|00|00|
               first digits starting point
               second digits amount of tiles
               third digits second starting point
               fourth digits second amount of tiles
               fifth form
             */
            case 0:
                //circle
                roomLayout = generateCircle(roomLayout);
                break;
            case 1:
                //square
                for (int i = 0; i < roomLayout.length; i++) {
                    roomLayout[i] = roomLayout.length * 1000000 + 1;
                }
                break;
            case 2:
                //oval
                break;
            case 3:
                //donut
                int[] smallerCircle;
                int calc = (roomLayout.length / 2);
                int save;
                if (calc % 2 == 0){
                    smallerCircle = new int[calc + 1];
                } else {
                    smallerCircle = new int[calc];
                }
                roomLayout = generateCircle(roomLayout);
                smallerCircle = generateCircle(smallerCircle);
                for (int i = 0; i < smallerCircle.length; i++){
                    calc = ((int)(((roomLayout[i + roomLayout.length / 2 - smallerCircle.length / 2]) % 100000000) / 2) / 1000000);
                    calc += 2;
                    if (calc % 2 == 0){
                        calc++;
                    }
                    calc *= 1000000;
                    save = roomLayout[i + roomLayout.length / 2 - smallerCircle.length / 2]  % 100000000 / 1000000;
                    roomLayout[i + roomLayout.length / 2 - smallerCircle.length / 2] = calc - smallerCircle[i] % 100000000 + (smallerCircle[i] % 100000000) / 100  + ((int)(roomLayout[i + roomLayout.length / 2 - smallerCircle.length / 2] / 100000000) * 100000000);
                    while (save != (roomLayout[i + roomLayout.length / 2 - smallerCircle.length / 2]  % 100000000 / 1000000) * 2 + smallerCircle[i] % 100000000 / 1000000){
                        if (save < (roomLayout[i + roomLayout.length / 2 - smallerCircle.length / 2]  % 100000000 / 1000000) * 2 + smallerCircle[i] % 100000000 / 1000000){
                            roomLayout[i + roomLayout.length / 2 - smallerCircle.length / 2] -= 1000000;
                        } else {
                            roomLayout[i + roomLayout.length / 2 - smallerCircle.length / 2] += 1000000;
                        }
                    }
                }
                for (int i = 0; i < smallerCircle.length; i++){
                    roomLayout[i] += 2;
                }


                break;
            case 4:
                // do not know
                break;
            default:
                //square
        }
    }
    private static int[] generateCircle(int[] roomLayout){
        double number = 0.0;
        int calc = (int) roomLayout.length / 2;
        for (int i = 0; i < roomLayout.length; i++) {
            number = (roomLayout.length - 0.25  * roomLayout.length) * Math.cos(((2f * Math.PI) / (roomLayout.length * 2)) * (i - calc)) + 0.25  * roomLayout.length;
            number = (int) number;
            if (number % 2 == 0) {
                if (number >= roomLayout.length - 0.25  * roomLayout.length) {
                    number--;
                } else {
                    number++;
                }
            }
            if ((i == calc - 1 || i == calc + 1 || i == calc)) {
                number = roomLayout.length;
            }
            roomLayout[i] = (roomLayout.length - calc - ((int) number) / 2) * 100000000 + (int) number * 1000000;
        }
        return roomLayout;
    }
}
