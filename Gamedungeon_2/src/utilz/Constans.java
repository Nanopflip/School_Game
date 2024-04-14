package utilz;

public class Constans {

    public static class Directions{
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int DOWN = 2;
        public static final int RIGHT = 3;
        public static final int UPLEFT = 4;
    }

    public static class PlayerHitbox{
        public static final int yMin = 468;
        public static final int yMax = 612;
        public static final int xMin = 908;
        public static final int xMax = 1052;
    }

    public static class RoomTiles{
        public static final int LEFT = 0;
    }


    public static class PlayerConstans{
        public static final int RUNNING = 0;
        public static final int IDLE = 1;
        public static final int JUMPING = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
        public static final int ATTACK = 6;
        public static final int ATTACKJUMP = 7;

        public static int getSpriteAmount(int playerAction){
            switch (playerAction){
                case RUNNING:
                    return 1;
                case IDLE:
                    return 3;
                case JUMPING:
                    return 4;
                default:
                    return 1;
            }
        }
    }
}
