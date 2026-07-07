package com.javarush.module2.lesson18.sample_proxylog.logger;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String text();

    Level level() default Level.INFO;

    enum Level {
        ERROR(Colors.ANSI_RED),
        DEBUG(Colors.ANSI_GREEN),
        INFO(Colors.ANSI_YELLOW),
        MESSAGES(Colors.ANSI_BLUE);

        public final String color;

        Level(String color) {
            this.color = color;
        }
    }
}
