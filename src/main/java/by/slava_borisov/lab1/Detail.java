package by.slava_borisov.lab1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Detail {
    private final String code;
    @Getter
    private final int time;

    @Override
    public String toString() {
        return "Код: " + code + ", Время: " + time;
    }
}
