package me.a8kj.smptest.internal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.a8kj.smptest.parent.effect.atrributes.RGBColor;

@RequiredArgsConstructor
@Getter
public enum ColorCode {
    DARK_RED(1, new RGBColor(170, 0, 0)),
    RED(2, new RGBColor(255, 85, 85)),
    GOLD(3, new RGBColor(255, 170, 0)),
    YELLOW(4, new RGBColor(255, 255, 85)),
    GREEN(5, new RGBColor(85, 255, 85)),
    AQUA(6, new RGBColor(85, 255, 255)),
    BLUE(7, new RGBColor(85, 85, 255)),
    PURPLE(8, new RGBColor(170, 0, 170)),
    DEFAULT(0, new RGBColor(255, 255, 255));

    private final int code;
    private final RGBColor color;

    public static RGBColor getColorByCode(int code) {
        for (ColorCode colorNumber : ColorCode.values()) {
            if (colorNumber.getCode() == code) {
                return colorNumber.getColor();
            }
        }
        return DEFAULT.getColor();
    }
}
