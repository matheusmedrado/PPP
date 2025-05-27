package FreezeMonster;

import java.awt.*;

public class Commons extends Framework.Commons {
    protected int MONSTER_WIDTH = 80;
    protected int MONSTER_HEIGHT = 80;
    protected int PROJECTILE_SPEED = 6;
    protected int PROJECTILE_SIZE = 30;
    protected int PLAYER_WIDTH = 65;
    protected int PLAYER_HEIGHT = 65;
    protected int NUMBER_OF_MONSTERS_TO_DESTROY = 10;

    protected Commons() {
        BOARD_WIDTH = 1280;
        BOARD_HEIGHT = 720;
        BG_COLOR = new Color(100, 200, 100);
        INIT_PLAYER_X = BOARD_WIDTH / 2 - PLAYER_WIDTH / 2;
        INIT_PLAYER_Y = BOARD_HEIGHT / 2 - PLAYER_HEIGHT / 2;
    }

    public static int PROJECTILE_SPEED() {
        return ensureInstance().PROJECTILE_SPEED;
    }

    // Garante que a instância seja do tipo FreezeMonster.Commons
    public static Commons ensureInstance() {
        Framework.Commons instance = getInstance();
        if (!(instance instanceof Commons))
            setInstance(new Commons());

        return (Commons) getInstance();
    }

    public static int MONSTER_WIDTH() {
        return ensureInstance().MONSTER_WIDTH;
    }

    public static int MONSTER_HEIGHT() {
        return ensureInstance().MONSTER_HEIGHT;
    }

    public static int NUMBER_OF_MONSTERS_TO_DESTROY() {
        return ensureInstance().NUMBER_OF_MONSTERS_TO_DESTROY;
    }

    public static int PLAYER_WIDTH() {
        return ensureInstance().PLAYER_WIDTH;
    }

    public static int PLAYER_HEIGHT() {
        return ensureInstance().PLAYER_HEIGHT;
    }

    public static int PROJECTILE_SIZE() {
        return ensureInstance().PROJECTILE_SIZE;
    }
}
