package Engine.Utils;

import java.awt.event.KeyEvent;

public class Config {
    public class Input {
        public class MovementAxis {
            public class Horizontal {
            public static final int NEGATIVE_KEY = KeyEvent.VK_A;
            public static final int POSITIVE_KEY = KeyEvent.VK_D;
            }
            public class Vertical {
            public static final int NEGATIVE_KEY = KeyEvent.VK_W;
            public static final int POSITIVE_KEY = KeyEvent.VK_S;
            }

        }
    }
}
