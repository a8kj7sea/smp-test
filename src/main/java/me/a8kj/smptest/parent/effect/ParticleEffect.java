package me.a8kj.smptest.parent.effect;

import me.a8kj.smptest.parent.effect.atrributes.Count;
import me.a8kj.smptest.parent.effect.atrributes.RGBColor;
import me.a8kj.smptest.parent.effect.atrributes.Speed;

public interface ParticleEffect {

    String getName();

    Count getCount();

    RGBColor getColor();

    Speed getSpeed();
}
