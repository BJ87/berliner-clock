package com.ubs.opsit.interviews.clock.row;

import com.ubs.opsit.interviews.clock.lamp.Lamp;
import com.ubs.opsit.interviews.clock.lamp.RedLamp;
import com.ubs.opsit.interviews.clock.lamp.YellowLamp;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockRowTest {

    private static final Lamp LAMP_1 = new RedLamp();
    private static final Lamp LAMP_2 = new YellowLamp();
    private static final Lamp LAMP_3 = new YellowLamp();

    private ClockRow clockRow;

    @Before
    public void setUp() {
        List<Lamp> lamps = new ArrayList<>();
        lamps.add(LAMP_1);
        lamps.add(LAMP_2);
        lamps.add(LAMP_3);
        clockRow = new ClockRow(lamps);
    }

    @Test
    public void shouldTurnOnLamps() {
        clockRow.turnLampsOn(2);

        assertThat(LAMP_1.getState()).isEqualTo("R");
        assertThat(LAMP_2.getState()).isEqualTo("Y");
        assertThat(LAMP_3.getState()).isEqualTo("O");
    }

    @Test
    public void shouldTurnOnAllLampsWhenRequestedMoreThenRowContains() {
        clockRow.turnLampsOn(4);

        assertThat(LAMP_1.getState()).isEqualTo("R");
        assertThat(LAMP_2.getState()).isEqualTo("Y");
        assertThat(LAMP_3.getState()).isEqualTo("Y");
    }

    @Test
    public void shouldReturnLampsConfiguration() {
        String configuration = clockRow.retrieveLampConfiguration();
        assertThat(configuration).isEqualTo("OOO");

        clockRow.turnLampsOn(2);

        String newConfiguration = clockRow.retrieveLampConfiguration();
        assertThat(newConfiguration).isEqualTo("RYO");
    }
}