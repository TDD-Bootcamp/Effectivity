package tdd.course;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EffectivityTest {
    @Test
    public void all_should_take_effect_to_any_tail() {
        Effectivity effectivity = new Effectivity("ALL");
        assertThat(effectivity.isEffect("123"), is(true));
    }

    @Test
    public void should_not_take_effect_if_tail_lower_than_range_begin() {
        Effectivity effectivity = new Effectivity("200-300");
        assertThat(effectivity.isEffect("123"), is(false));
    }

    @Test
    public void should_take_effect_if_tail_inside_range() {
        Effectivity effectivity = new Effectivity("200-300");
        assertThat(effectivity.isEffect("223"), is(true));
    }

    @Test
    public void should_take_effect_if_tail_equal_to_range_begin() {
        Effectivity effectivity = new Effectivity("200-300");
        assertThat(effectivity.isEffect("200"), is(true));
    }

    @Test
    public void should_not_take_effect_if_tail_higher_than_range_end() {
        Effectivity effectivity = new Effectivity("200-300");
        assertThat(effectivity.isEffect("323"), is(false));
    }

    @Test
    public void should_take_effect_if_tail_equals_to_range_end() {
        Effectivity effectivity = new Effectivity("200-300");
        assertThat(effectivity.isEffect("300"), is(true));
    }

    @Test
    public void should_take_effect_if_tail_inside_2nd_range() {
        Effectivity effectivity = new Effectivity("200-300, 320-400");
        assertThat(effectivity.isEffect("323"), is(true));
    }
}
